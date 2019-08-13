/** 
 * <pre>项目名称:car 
 * 文件名称:TreeController.java 
 * 包名:com.jk.controller 
 * 创建日期:2019年7月4日下午9:45:56 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.jk.service.TreeService;
import com.jk.util.EasyuiPage;

/** 
 * <pre>项目名称：car    
 * 类名称：TreeController    
 * 类描述：    
 * 创建人：侯国军 
 *
 * 励志语录:业精于勤荒于嬉 行成于思毁于随
 *
 * 创建时间：2019年7月4日 下午9:45:56    
 * 修改人：侯国军  1476181116@qq.com
 * 修改时间：2019年7月4日 下午9:45:56    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("tree")
public class TreeController {
	
	@Reference
	private TreeService TreeService;
	
	
	@RequestMapping("queryTree")
	@ResponseBody
	public  EasyuiPage queryTree(Integer page, Integer rows, Tree tree) {
		return TreeService.queryTree(page,rows,tree);
		
	} 
	

	
	

}
