/** 
 * <pre>项目名称:ssm 
 * 文件名称:RoleTree.java 
 * 包名:com.jk.pojo 
 * 创建日期:2019年7月3日下午9:11:37 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.model;

import java.io.Serializable;

/**
 * <pre>项目名称：ssm    
 * 类名称：RoleTree    
 * 类描述：    
 * 创建人：侯国军 
 *
 * 励志语录:业精于勤荒于嬉 行成于思毁于随
 *
 * 创建时间：2019年7月3日 下午9:11:37    
 * 修改人：侯国军  1476181116@qq.com
 * 修改时间：2019年7月3日 下午9:11:37    
 * 修改备注：       
 * @version </pre>    
 */
public class RoleTree implements Serializable {
	private Integer id;
	private Integer roleid;
	private Integer treeid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	public Integer getTreeid() {
		return treeid;
	}
	public void setTreeid(Integer treeid) {
		this.treeid = treeid;
	}
	
	


}
