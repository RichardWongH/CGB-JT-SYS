package com.jt.sys.service;
import java.util.List;
import java.util.Map;

import com.jt.common.vo.CheckBox;
import com.jt.common.vo.PageObject;
import com.jt.sys.pojo.SysRole;

public interface SysRoleService {
	
	  List<CheckBox> findObjects();
	  /**
	   * @param pageCurrent 当前页码(来自哪里?)
	   * @param name 按名字搜索时输入的参数
	   * @return
	   */
	  PageObject<SysRole> findPageObjects(
			  Integer pageCurrent,
			  String name);
	  
	  /**根据id执行删除操作*/
	  int deleteObject(String ids); 
	  /**保存角色信息*/
	  int saveObject(SysRole entity,String menuIds);
	  /**根据id查询角色信息*/
	  Map<String,Object> findObjectById(Integer id);
	  /**修改角色信息*/
	  int updateObject(SysRole entity,String menuIds);
}
