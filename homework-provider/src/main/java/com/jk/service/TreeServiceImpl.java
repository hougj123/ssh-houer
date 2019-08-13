/** 
 * <pre>项目名称:car 
 * 文件名称:TreeServiceImpl.java 
 * 包名:com.jk.service.impl 
 * 创建日期:2019年7月4日下午9:47:25 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.TreeMapper;
import com.jk.model.Tree;
import org.springframework.beans.factory.annotation.Autowired;


import com.jk.service.TreeService;
import com.jk.util.EasyuiPage;
import com.jk.util.PageUtil;
import com.jk.util.StringUtil;

/** 
 * <pre>项目名称：car    
 * 类名称：TreeServiceImpl    
 * 类描述：    
 * 创建人：侯国军 
 *
 * 励志语录:业精于勤荒于嬉 行成于思毁于随
 *
 * 创建时间：2019年7月4日 下午9:47:25    
 * 修改人：侯国军  1476181116@qq.com
 * 修改时间：2019年7月4日 下午9:47:25    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class TreeServiceImpl implements TreeService {
	@Autowired
	private TreeMapper treeMapper;

	@Override
	public EasyuiPage queryTree(Integer page, Integer rows, Tree tree) {
		Map map = new HashMap();
		map.put("name",StringUtil.formatLike(tree.getText()));
		EasyuiPage page1 = new EasyuiPage();
		Integer total = treeMapper.queryTreeCount(map);
		page1.setTotal(total);
		PageUtil<Tree> page2 = new PageUtil<>(total, page, rows);
		map.put("start", page2.getStartIndex());
		map.put("end", page2.getEndIndex());
		List<Tree> list = treeMapper.queryTree(map);
		page1.setRows(list);
		return page1;
	}


}
