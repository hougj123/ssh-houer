/** 
 * <pre>项目名称:car 
 * 文件名称:TreeMapper.java 
 * 包名:com.jk.mapper 
 * 创建日期:2019年7月4日下午9:48:08 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.dao;

import java.util.List;
import java.util.Map;

import com.jk.model.Tree;
import org.apache.ibatis.annotations.Delete;


/** 
 * <pre>项目名称：car    
 * 类名称：TreeMapper    
 * 类描述：    
 * 创建人：侯国军 
 *
 * 励志语录:业精于勤荒于嬉 行成于思毁于随
 *
 * 创建时间：2019年7月4日 下午9:48:08    
 * 修改人：侯国军  1476181116@qq.com
 * 修改时间：2019年7月4日 下午9:48:08    
 * 修改备注：       
 * @version </pre>    
 */
public interface TreeMapper {

	/** <pre>queryTreeCount(这里用一句话描述这个方法的作用)   
	 * 创建人：yueyuewei 1476181116@qq.com
	 * 创建时间：2019年7月4日 下午9:55:14    
	 * 修改人：侯国军
	 * 修改时间：2019年7月4日 下午9:55:14    
	 * 修改备注： 
	 * @param map
	 * @return</pre>    
	 */
	Integer queryTreeCount(Map map);

	/** <pre>queryTree(这里用一句话描述这个方法的作用)   
	 * 创建人：yueyuewei 1476181116@qq.com
	 * 创建时间：2019年7月4日 下午9:56:41    
	 * 修改人：侯国军
	 * 修改时间：2019年7月4日 下午9:56:41    
	 * 修改备注： 
	 * @param map
	 * @return</pre>    
	 */
	List<Tree> queryTree(Map map);

	/** <pre>addTree(这里用一句话描述这个方法的作用)   
	 * 创建人：yueyuewei 1476181116@qq.com
	 * 创建时间：2019年7月4日 下午10:05:02    
	 * 修改人：侯国军
	 * 修改时间：2019年7月4日 下午10:05:02    
	 * 修改备注： 
	 * @param tree</pre>    
	 */


}
