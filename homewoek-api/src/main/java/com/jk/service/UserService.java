/** 
 * <pre>项目名称:car 
 * 文件名称:UserService.java 
 * 包名:com.jk.service 
 * 创建日期:2019年7月4日下午3:16:04 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.service;

import java.util.List;

import com.jk.model.Role;
import com.jk.model.Tree;
import com.jk.model.User;
import com.jk.util.EasyuiPage;
import com.jk.util.PageUtil2;


/**
 * <pre>项目名称：car    
 * 类名称：UserService    
 * 类描述：    
 * 创建人：侯国军 
 *
 * 励志语录:业精于勤荒于嬉 行成于思毁于随
 *
 * 创建时间：2019年7月4日 下午3:16:04    
 * 修改人：侯国军  1476181116@qq.com
 * 修改时间：2019年7月4日 下午3:16:04    
 * 修改备注：       
 * @version </pre>    
 */
public interface UserService {


	User loginUser(User user);

	List<Tree> getTreeAll(Integer id);

	/** <pre>queryUser(这里用一句话描述这个方法的作用)   
	 * 创建人：yueyuewei 1476181116@qq.com
	 * 创建时间：2019年7月4日 下午8:31:53    
	 * 修改人：侯国军
	 * 修改时间：2019年7月4日 下午8:31:53    
	 * 修改备注： 
	 * @param page
	 * @param rows
	 * @param user
	 * @return</pre>    
	 */
	EasyuiPage queryUser(Integer page, Integer rows, User user);

    List<Role> getRoleByUserId(Integer id);

	int updateUserRole(Integer[] ids, Integer id);

	List<User> query();

	void addUser(List<User> list);

	PageUtil2 queryLog(Integer page, Integer rows);

	/** <pre>addUser(这里用一句话描述这个方法的作用)   
	 * 创建人：yueyuewei 1476181116@qq.com
	 * 创建时间：2019年7月4日 下午8:38:26    
	 * 修改人：侯国军
	 * 修改时间：2019年7月4日 下午8:38:26    
	 * 修改备注： 
	 * @param user</pre>    
	 */


}
