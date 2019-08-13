/** 
 * <pre>项目名称:car 
 * 文件名称:UserController.java 
 * 包名:com.jk.controller 
 * 创建日期:2019年7月4日下午3:15:07 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.controller;

import java.awt.print.Book;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Role;
import com.jk.model.Tree;
import com.jk.model.User;
import com.jk.util.*;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.jk.service.UserService;

import org.springframework.web.multipart.MultipartFile;

/** 
 * <pre>项目名称：car    
 * 类名称：UserController    
 * 类描述：    
 * 创建人：侯国军 
 *
 * 励志语录:业精于勤荒于嬉 行成于思毁于随
 *
 * 创建时间：2019年7月4日 下午3:15:07    
 * 修改人：侯国军  1476181116@qq.com
 * 修改时间：2019年7月4日 下午3:15:07    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("user")
public class UserController {

	@Reference
	private UserService userService;
	@Autowired
	private RedisTemplate redisTemplate;

	@RequestMapping("tologin")
	public String tologin(){
		return "login";
	}

	@RequestMapping("login")
	@ResponseBody
	public String denglu(User user, HttpServletRequest request){

		User us = userService.loginUser(user);

		if (us==null) {
			return "userError";
		}
		//判断密码
		if (!us.getPassword().equals(user.getPassword())) {
			return "pwdError";
		}

		request.getSession().setAttribute("user", us);
		return "success";
	}
	@RequestMapping("getTreeAll")
	@ResponseBody
	public List<Tree> getTreeAll(HttpServletRequest request){
		List<Tree> list = new ArrayList<>();
		User user =(User) request.getSession().getAttribute("user");
		//1、定义缓存key
		String key = "tree"+user.getId();
		//2、先判断缓存中是否存在
		if (redisTemplate.hasKey(key)) {
			System.out.println("=====走缓存=======");
			//3、a 存在 ：从缓存中获取，返回list
			list = (List<Tree>) redisTemplate.opsForValue().get(key);
		}else {
			System.out.println("=====走数据库=======");
			//3、 b 不存在：
			//先从数据库查询、
			list =userService.getTreeAll(user.getId());
			list = TreeNoteUtil.getFatherNode(list);
			//放入缓存中、返回list
			redisTemplate.opsForValue().set(key, list);
			//设置过期时间
			redisTemplate.expire(key, 3, TimeUnit.MINUTES);
		}
		return list;
	}
	
	
	@RequestMapping("queryUser")
	@ResponseBody
	public  EasyuiPage queryUser(Integer page, Integer rows,User user) {
		return userService.queryUser(page,rows,user);
		
	}


	@RequestMapping("getUserById")
	@ResponseBody
	public   List<Role>  getRoleByUserId(Integer id){

		List<Role> list = userService.getRoleByUserId(id);

		return list;


	}


	@RequestMapping("updateUserBy")
	@ResponseBody
	public   int updateUserRole(Integer[] ids,Integer id){



		return userService.updateUserRole(ids,id);
	}

	@RequestMapping("exportExce")
	public void exportExcel(HttpServletResponse response){
		//导出的excel的标题
		String title = "1902B书籍管理";
		//导出excel的列名
		String[] rowName = {"编号","名称","密码"};
		//导出的excel数据
		List<Object[]>  dataList = new ArrayList<Object[]>();
		//查询的数据库的书籍信息
		List<User> list=   userService.query();
		//循环书籍信息
		for(User user:list){
			Object[] obj =new Object[rowName.length];
			obj[0]=user.getId();
			obj[1]=user.getUsername();
			obj[2]=user.getPassword();

			dataList.add(obj);
		}
		ExportExcel exportExcel =new ExportExcel(title,rowName,dataList,response);
		try {
			exportExcel.export();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("importExcel")
	public String importExcel(MultipartFile file, HttpServletResponse response){
		//获得上传文件上传的类型
		String contentType = file.getContentType();
		//上传文件的名称
		String fileName = file.getOriginalFilename();
		//获得文件的后缀名
		String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		//上传文件的新的路径
		//生成新的文件名称
		String filePath = "./src/main/resources/templates/fileupload/";
		//创建list集合接收excel中读取的数据
		List<User> list =new ArrayList<User>();
		try {
			uploadFile(file.getBytes(),filePath,fileName);
			FileInputStream fileInputStream = new FileInputStream(filePath+fileName);
			Workbook workbook = WorkbookFactory.create(fileInputStream);
			//通过workbook对象获得sheet页 有可能不止一个sheet
			for(int i=0 ;i<workbook.getNumberOfSheets();i++){
				//获得里面的每一个sheet对象
				Sheet sheetAt = workbook.getSheetAt(i);
				//通过sheet对象获得每一行
				for(int j=3;j<sheetAt.getPhysicalNumberOfRows();j++){
					//创建一个book对象接收excel的数据
					User user=new User();
					//获得每一行的数据
					Row row = sheetAt.getRow(j);

					//获得每一个单元格的数据
					if(row.getCell(1)!=null && !"".equals(row.getCell(1))){
						user.setUsername(this.getCellValue(row.getCell(1)));
					}
					if(row.getCell(2)!=null && !"".equals(row.getCell(2))){
						user.setPassword(this.getCellValue(row.getCell(2)));
					}

					list.add(user);
				}
			}
			userService.addUser(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}



	//上传文件的方法
	public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
		File targetFile = new File(filePath);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		FileOutputStream out = new FileOutputStream(filePath + fileName);
		out.write(file);
		out.flush();
		out.close();
	}

	//判断从Excel文件中解析出来数据的格式
	private static String getCellValue(Cell cell){
		String value = null;
		//简单的查检列类型
		switch(cell.getCellType())
		{
			case Cell.CELL_TYPE_STRING://字符串
				value = cell.getRichStringCellValue().getString();
				break;
			case Cell.CELL_TYPE_NUMERIC://数字
				long dd = (long)cell.getNumericCellValue();
				value = dd+"";
				break;
			case Cell.CELL_TYPE_BLANK:
				value = "";
				break;
			case Cell.CELL_TYPE_FORMULA:
				value = String.valueOf(cell.getCellFormula());
				break;
			case Cell.CELL_TYPE_BOOLEAN://boolean型值
				value = String.valueOf(cell.getBooleanCellValue());
				break;
			case Cell.CELL_TYPE_ERROR:
				value = String.valueOf(cell.getErrorCellValue());
				break;
			default:
				break;
		}
		return value;
	}

	@RequestMapping("queryLog")
	@ResponseBody
	public DataGridResult queryLog(Integer page, Integer rows){
		DataGridResult result = new DataGridResult();
		PageUtil2 pageUtil2 = userService.queryLog(page,rows);
		result.setRows(pageUtil2.getList());
		result.setTotal(pageUtil2.getSumSize());
		return result;
	}


}
