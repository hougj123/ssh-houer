/** 
 * <pre>项目名称:car 
 * 文件名称:RoleController.java 
 * 包名:com.jk.controller 
 * 创建日期:2019年7月4日下午7:30:54 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.controller;

import java.util.List;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Role;
import com.jk.model.Tree;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import com.jk.service.RoleService;
import com.jk.util.EasyuiPage;
import com.jk.util.TreeNoteUtil;

/** 
 * <pre>项目名称：car    
 * 类名称：RoleController    
 * 类描述：    
 * 创建人：侯国军 
 *
 * 励志语录:业精于勤荒于嬉 行成于思毁于随
 *
 * 创建时间：2019年7月4日 下午7:30:54    
 * 修改人：侯国军  1476181116@qq.com
 * 修改时间：2019年7月4日 下午7:30:54    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("role")
public class RoleController {

	@Reference
	private RoleService roleService;
	

	@RequestMapping("queryRole")
	@ResponseBody
	public  EasyuiPage queryRole(Integer page, Integer rows, Role role) {
		return roleService.queryRole(page,rows,role);
		
	}

	@RequestMapping("getTreeById")
	@ResponseBody
	public  List<Tree>  getTreeId(Integer id){

		List<Tree> list = roleService.getTreeId(id);

		//自己调用自己（递归）
		list = TreeNoteUtil.getFatherNode(list);

		return list;
	}


	@RequestMapping("updateTree")
	@ResponseBody
	public   String updateTreeById(Integer[] ids,Integer id){

		int i = roleService.updateTreeById(ids,id);
		if(i<1){
			return "0";
		}
		return "1";
	}
	
	
}
