/** 
 * <pre>项目名称:ssm 
 * 文件名称:Role.java 
 * 包名:com.jk.pojo 
 * 创建日期:2019年7月3日上午11:37:18 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.model;

import java.io.Serializable;

/**
 * <pre>项目名称：ssm    
 * 类名称：Role    
 * 类描述：    
 * 创建人：侯国军 
 *
 * 励志语录:业精于勤荒于嬉 行成于思毁于随
 *
 * 创建时间：2019年7月3日 上午11:37:18    
 * 修改人：侯国军  1476181116@qq.com
 * 修改时间：2019年7月3日 上午11:37:18    
 * 修改备注：       
 * @version </pre>    
 */
public class Role implements Serializable {
	
	
	private Integer id;
	private String name;
	private String introduce;
	private String text;
	private String checked;
	
	
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	
	
}
