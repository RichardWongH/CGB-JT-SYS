package com.jt.sys.service;

import java.util.Map;

import com.jt.common.vo.PageObject;
import com.jt.sys.pojo.SysRole;
import com.jt.sys.pojo.SysUser;

public interface SysUserService {
	
	/**根据用户名和密码进行登录认证*/
	void login(String username,String password);
	
	/**更新用户信息*/
	int updateObject(SysUser entity,String roleIds);
	
	/**
	 *根据id查询用户信息以及用户关联的角色信息 
	 *@param  id 表示用户id
	 *@return 包含用户信息以及角色信息
	 */
	Map<String,Object> findObjectById(Integer id);
	
	int saveObject(SysUser entity,String roleIds);
	
	PageObject<SysUser> findPageObjects(
			String username, 
			Integer pageCurrent);
	
	/**禁用和启用*/
	int validById(Integer id,Integer valid,String modifiedUser);

}
