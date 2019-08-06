package com.jt.sys.service;

import java.util.List;
import java.util.Map;

import com.jt.common.vo.Node;
import com.jt.sys.pojo.SysMenu;

public interface SysMenuService {

	 List<Map<String,Object>> findObjects();
	 void deleteObject(Integer menuId);
	 List<Node> findZtreeNodes();
	 int saveObject(SysMenu entity);
	 int updateObject(SysMenu entity);
	 Map<String,Object> findObjectById(Integer id);
	 
}
