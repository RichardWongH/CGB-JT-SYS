package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysRoleMenuDao {
	
	 int deleteObject(Integer roleId);
	 /**向表中写入关系数据*/
	 int insertObject(
			 @Param("roleId")Integer roleId,
			 @Param("menuIds")String[] menuIds);
	 List<Integer> findMenuIdsByRoleId(Integer roleId);
	 
}
