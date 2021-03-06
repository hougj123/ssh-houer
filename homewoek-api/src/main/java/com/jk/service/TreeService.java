/** 
 * <pre>项目名称:car 
 * 文件名称:TreeService.java 
 * 包名:com.jk.service 
 * 创建日期:2019年7月4日下午9:46:55 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.service;


import com.jk.model.Tree;
import com.jk.util.EasyuiPage;


/** 
 * <pre>项目名称：car    
 * 类名称：TreeService    
 * 类描述：    
 * 创建人：侯国军 
 *
 * 励志语录:业精于勤荒于嬉 行成于思毁于随
 *
 * 创建时间：2019年7月4日 下午9:46:55    
 * 修改人：侯国军  1476181116@qq.com
 * 修改时间：2019年7月4日 下午9:46:55    
 * 修改备注：       
 * @version </pre>    
 */
public interface TreeService {

	/** <pre>queryTree(这里用一句话描述这个方法的作用)   
	 * 创建人：yueyuewei 1476181116@qq.com
	 * 创建时间：2019年7月4日 下午9:53:00    
	 * 修改人：侯国军
	 * 修改时间：2019年7月4日 下午9:53:00    
	 * 修改备注： 
	 * @param page
	 * @param rows
	 * @param tree
	 * @return</pre>    
	 */
	EasyuiPage queryTree(Integer page, Integer rows, Tree tree);


}
