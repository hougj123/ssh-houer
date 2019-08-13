/** 
 * <pre>项目名称:car 
 * 文件名称:RoleServiceImpl.java 
 * 包名:com.jk.service.impl 
 * 创建日期:2019年7月4日下午7:32:48 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.RoleMapper;
import com.jk.model.Role;
import com.jk.model.RoleTree;
import com.jk.model.Tree;
import org.springframework.beans.factory.annotation.Autowired;


import com.jk.util.EasyuiPage;
import com.jk.util.PageUtil;
import com.jk.util.StringUtil;

/** 
 * <pre>项目名称：car    
 * 类名称：RoleServiceImpl    
 * 类描述：    
 * 创建人：侯国军 
 *
 * 励志语录:业精于勤荒于嬉 行成于思毁于随
 *
 * 创建时间：2019年7月4日 下午7:32:48    
 * 修改人：侯国军  1476181116@qq.com
 * 修改时间：2019年7月4日 下午7:32:48    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Override
	public EasyuiPage queryRole(Integer page, Integer rows, Role role) {
		Map map = new HashMap();
		map.put("name",StringUtil.formatLike(role.getName()));
		EasyuiPage page1 = new EasyuiPage();
		Integer total = roleMapper.queryRoleCount(map);
		page1.setTotal(total);
		PageUtil<Role> page2 = new PageUtil<>(total, page, rows);
		map.put("start", page2.getStartIndex());
		map.put("end", page2.getEndIndex());
		List<Role> list = roleMapper.queryRole(map);
		page1.setRows(list);
		return page1;
	}

	@Override
	public List<Tree> getTreeId(Integer id) {
		List<String> list = roleMapper.getTreeId(id);

		List<Tree>  listTwo = roleMapper.getRoleTreeAll();

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
	public int updateTreeById(Integer[] ids, Integer id) {
		int i = roleMapper.deleteRoleTree(id);
		if(i>=0) {
			for (int j = 0; j < ids.length; j++) {
				RoleTree re = new RoleTree();
				re.setTreeid(ids[j]);
				re.setRoleid(id);
				i=roleMapper.addRoleTreeAll(re);
			}

		}

		return i;
	}


}
