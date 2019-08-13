/** 
 * <pre>项目名称:car 
 * 文件名称:RoleMapper.java 
 * 包名:com.jk.mapper 
 * 创建日期:2019年7月4日下午7:33:27 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.dao;

import java.util.List;
import java.util.Map;

import com.jk.model.Role;
import com.jk.model.RoleTree;
import com.jk.model.Tree;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


/** 
 * <pre>项目名称：car    
 * 类名称：RoleMapper    
 * 类描述：    
 * 创建人：侯国军 
 *
 * 励志语录:业精于勤荒于嬉 行成于思毁于随
 *
 * 创建时间：2019年7月4日 下午7:33:27    
 * 修改人：侯国军  1476181116@qq.com
 * 修改时间：2019年7月4日 下午7:33:27    
 * 修改备注：       
 * @version </pre>    
 */
public interface RoleMapper {

	/** <pre>queryRoleCount(这里用一句话描述这个方法的作用)   
	 * 创建人：yueyuewei 1476181116@qq.com
	 * 创建时间：2019年7月4日 下午7:41:54    
	 * 修改人：侯国军
	 * 修改时间：2019年7月4日 下午7:41:54    
	 * 修改备注： 
	 * @param map
	 * @return</pre>    
	 */
	Integer queryRoleCount(Map map);

	/** <pre>queryRole(这里用一句话描述这个方法的作用)   
	 * 创建人：yueyuewei 1476181116@qq.com
	 * 创建时间：2019年7月4日 下午7:41:58    
	 * 修改人：侯国军
	 * 修改时间：2019年7月4日 下午7:41:58    
	 * 修改备注： 
	 * @param map
	 * @return</pre>    
	 */
	List<Role> queryRole(Map map);

	List<String> getTreeId(Integer id);

	List<Tree> getRoleTreeAll();
	@Delete("delete from wl_tree_role where roleid =#{id}")
	int deleteRoleTree(Integer id);
	@Insert("insert into wl_tree_role(id, treeid, roleid) values(#{id,jdbcType=INTEGER}, #{treeid,jdbcType=INTEGER}, #{roleid,jdbcType=INTEGER})")
	int addRoleTreeAll(RoleTree re);
}
