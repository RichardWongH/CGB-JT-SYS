package com.jt.sys.dao;

import java.util.List;
import java.util.Map;

import com.jt.common.vo.Node;
import com.jt.sys.pojo.SysMenu;

public interface SysMenuDao {
	List<Map<String,Object>> findObjects();
	int hasChild(int menuId);
	int deleteObject(int id);
	int insertObject(SysMenu entity);
	int updateObject(SysMenu entity);
	List<Node> findZtreeNodes();
	
	Map<String,Object> 
	findObjectById(Integer id);
	
}
