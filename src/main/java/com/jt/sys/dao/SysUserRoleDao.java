package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**通过这个接口操作用户与角色之间的关系数据*/
public interface SysUserRoleDao {

	 /**根据用户id删除中间表角色信息相关记录*/
	 int deleteObject(Integer userId);
	 
	 /**向表中写入关系数据*/
	 int insertObject(
			 @Param("userId")Integer userId,
			 @Param("roleIds")String[] roleIds);
	 
     /**根据用户ID查询角色id*/
	 List<Integer> findRolesByUserId(Integer id);
	 
	 
}
