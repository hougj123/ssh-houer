/** 
 * <pre>项目名称:ssm 
 * 文件名称:UserRole.java 
 * 包名:com.jk.pojo 
 * 创建日期:2019年7月3日下午9:12:45 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.model;

import java.io.Serializable;

/**
 * <pre>项目名称：ssm    
 * 类名称：UserRole    
 * 类描述：    
 * 创建人：侯国军 
 *
 * 励志语录:业精于勤荒于嬉 行成于思毁于随
 *
 * 创建时间：2019年7月3日 下午9:12:45    
 * 修改人：侯国军  1476181116@qq.com
 * 修改时间：2019年7月3日 下午9:12:45    
 * 修改备注：       
 * @version </pre>    
 */
public class UserRole implements Serializable {
	private Integer id;
	private Integer userid;
	private Integer roleid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	
	
	

}
