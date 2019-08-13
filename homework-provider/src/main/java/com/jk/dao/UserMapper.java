/** 
 * <pre>项目名称:car 
 * 文件名称:UserMapper.java 
 * 包名:com.jk.mapper 
 * 创建日期:2019年7月4日下午3:16:59 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.dao;

import java.util.List;
import java.util.Map;

import com.jk.model.Role;
import com.jk.model.Tree;
import com.jk.model.User;
import com.jk.model.UserRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


/** 
 * <pre>项目名称：car    
 * 类名称：UserMapper    
 * 类描述：    
 * 创建人：侯国军 
 *
 * 励志语录:业精于勤荒于嬉 行成于思毁于随
 *
 * 创建时间：2019年7月4日 下午3:16:59    
 * 修改人：侯国军  1476181116@qq.com
 * 修改时间：2019年7月4日 下午3:16:59    
 * 修改备注：       
 * @version </pre>    
 */
public interface UserMapper {



	/** <pre>getTreeAll(这里用一句话描述这个方法的作用)   
	 * 创建人：yueyuewei 1476181116@qq.com
	 * 创建时间：2019年7月4日 下午3:35:15    
	 * 修改人：侯国军
	 * 修改时间：2019年7月4日 下午3:35:15    
	 * 修改备注： 
	 * @param id
	 * @return</pre>    
	 */
	List<Tree> getTreeAll(Integer id);

	/** <pre>queryUserCount(这里用一句话描述这个方法的作用)   
	 * 创建人：yueyuewei 1476181116@qq.com
	 * 创建时间：2019年7月4日 下午8:35:37    
	 * 修改人：侯国军
	 * 修改时间：2019年7月4日 下午8:35:37    
	 * 修改备注： 
	 * @param map
	 * @return</pre>    
	 */
	Integer queryUserCount(Map map);

	/** <pre>queryUserAll(这里用一句话描述这个方法的作用)   
	 * 创建人：yueyuewei 1476181116@qq.com
	 * 创建时间：2019年7月4日 下午8:36:19    
	 * 修改人：侯国军
	 * 修改时间：2019年7月4日 下午8:36:19    
	 * 修改备注： 
	 * @param map
	 * @return</pre>    
	 */
	List<User> queryUserAll(Map map);

	/** <pre>addUser(这里用一句话描述这个方法的作用)   
	 * 创建人：yueyuewei 1476181116@qq.com
	 * 创建时间：2019年7月4日 下午8:39:15    
	 * 修改人：侯国军
	 * 修改时间：2019年7月4日 下午8:39:15    
	 * 修改备注： 
	 * @param user</pre>    
	 */

@Select("select * from wl_user where username = #{username}")
	User loginUser(User user);
@Select("SELECT roleid FROM wl_user_role where userid = #{id}")
    List<String> getRoleIdTow(Integer id);
@Select("SELECT * FROM wl_role")
	List<Role> getRoleAllTow();

	int deleteUserRole(Integer id);
@Insert("insert into wl_user_role(id, userid, roleid) values(#{id,jdbcType=INTEGER}, #{userid,jdbcType=INTEGER}, #{roleid,jdbcType=INTEGER})")
	int addUserRole(UserRole re);
@Select("select * from wl_user")
	List<User> query();

	void addUser(List<User> list);
}
