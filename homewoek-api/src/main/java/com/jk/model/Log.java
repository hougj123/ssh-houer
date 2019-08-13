/** 
 * <pre>项目名称:ssm_store 
 * 文件名称:Log.java 
 * 包名:com.jk.pojo 
 * 创建日期:2019年7月12日下午7:13:20 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/** 
 * <pre>项目名称：ssm_store    
 * 类名称：Log    
 * 类描述：    
 * 创建人：王航
 *
 * 励志语录:逆水行舟不进则退
 *
 * 创建时间：2019年7月12日 下午7:13:20    
 * 修改人：王航  whkokon@163.com
 * 修改时间：2019年7月12日 下午7:13:20    
 * 修改备注：       
 * @version </pre>    
 */
public class Log implements Serializable {
	
	//物流日志
	
	private String logip;
	private Integer userid;
	private String logname;
	@DateTimeFormat(pattern = "yyyy-MM-dd") // 处理从	前端到后端的时间
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")// 处理从	后端到前端的时间
	private Date logtime;
	private String logis;
	public String getLogip() {
		return logip;
	}
	public void setLogip(String logip) {
		this.logip = logip;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getLogname() {
		return logname;
	}
	public void setLogname(String logname) {
		this.logname = logname;
	}
	public Date getLogtime() {
		return logtime;
	}
	public void setLogtime(Date logtime) {
		this.logtime = logtime;
	}
	public String getLogis() {
		return logis;
	}
	public void setLogis(String logis) {
		this.logis = logis;
	}
	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "Log [logip=" + logip + ", userid=" + userid + ", logname=" + logname + ", logtime=" + logtime
				+ ", logis=" + logis + "]";
	}
}
