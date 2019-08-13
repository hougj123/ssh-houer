/** 
 * <pre>项目名称:car 
 * 文件名称:UserServiceImpl.java 
 * 包名:com.jk.service.impl 
 * 创建日期:2019年7月4日下午3:16:23 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.UserMapper;
import com.jk.model.*;
import com.jk.util.PageUtil2;
import org.springframework.beans.factory.annotation.Autowired;


import com.jk.service.UserService;
import com.jk.util.EasyuiPage;
import com.jk.util.PageUtil;
import com.jk.util.StringUtil;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

/** 
 * <pre>项目名称：car    
 * 类名称：UserServiceImpl    
 * 类描述：    
 * 创建人：侯国军 
 *
 * 励志语录:业精于勤荒于嬉 行成于思毁于随
 *
 * 创建时间：2019年7月4日 下午3:16:23    
 * 修改人：侯国军  1476181116@qq.com
 * 修改时间：2019年7月4日 下午3:16:23    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
@Autowired
private MongoTemplate mongoTemplate;
	@Override
	public User loginUser(User user) {
		return userMapper.loginUser(user);
	}


	
	@Override
	public List<Tree> getTreeAll(Integer id) {
	
		return userMapper.getTreeAll(id);
	}



	@Override
	public EasyuiPage queryUser(Integer page, Integer rows, User user) {
		Map map = new HashMap();
		map.put("name",StringUtil.formatLike(user.getUsername()));
		EasyuiPage page1 = new EasyuiPage();
		Integer total = userMapper.queryUserCount(map);
		page1.setTotal(total);
		PageUtil<User> page2 = new PageUtil<>(total, page, rows);
		map.put("start", page2.getStartIndex());
		map.put("end", page2.getEndIndex());
		List<User> list = userMapper.queryUserAll(map);
		page1.setRows(list);
		return page1;
	}

	@Override
	public List<Role> getRoleByUserId(Integer id) {
		List<String> list = userMapper.getRoleIdTow(id);

		List<Role>  listTwo = userMapper.getRoleAllTow();

		for (int i = 0; i < list.size(); i++) {

			for (int j = 0; j < listTwo.size(); j++) {
				if(list.get(i).equals(listTwo.get(j).getId().toString())){
					listTwo.get(j).setChecked("true");
				}


			}

		}


		return listTwo;
	}

	@Override
	public int updateUserRole(Integer[] ids, Integer id) {
		int i = userMapper.deleteUserRole(id);
		if(i>=0) {
			for (int j = 0; j < ids.length; j++) {
				UserRole re = new UserRole();
				re.setRoleid(ids[j]);
				re.setUserid(id);
				i=userMapper.addUserRole(re);
			}

		}

		return i;
	}

	@Override
	public List<User> query() {
		return userMapper.query();
	}

	@Override
	public void addUser(List<User> list) {
		userMapper.addUser(list);
	}

	@Override
	public PageUtil2 queryLog(Integer page, Integer rows) {
		Query query = new Query();
		long sumSize = mongoTemplate.count(query, Log.class,"log");
		PageUtil2 pageUtil2 = new PageUtil2((int) sumSize,page,rows);
		Integer skip = pageUtil2.getFirstResultCount();
		query.skip(skip);
		query.limit(rows);
		List<Log> list = mongoTemplate.find(query,Log.class,"log");
		pageUtil2.setList(list);
		return pageUtil2;

	}


}
