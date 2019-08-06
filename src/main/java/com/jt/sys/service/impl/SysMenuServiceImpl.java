package com.jt.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.jt.common.exception.ServiceException;
import com.jt.common.vo.Node;
import com.jt.sys.dao.SysMenuDao;
import com.jt.sys.pojo.SysMenu;
import com.jt.sys.service.SysMenuService;

@Service
public class SysMenuServiceImpl implements SysMenuService {

	@Autowired
	private SysMenuDao sysMenuDao;
	
	@Override
	public Map<String, Object> findObjectById(Integer id) {
		if(id==null||id<1)
		throw new ServiceException("id的值无效");
		Map<String,Object> map=
		sysMenuDao.findObjectById(id);
		return map;
	}
	
	@Override
	public int saveObject(SysMenu entity) {
		if(entity==null)
		throw new ServiceException("保存的数据不能为空");
		int rows=sysMenuDao.insertObject(entity);
		if(rows!=1)
		throw new ServiceException("数据保存失败");
		return rows;
	}
	@Override
	public int updateObject(SysMenu entity) {
		//合法验证
		if(entity==null)
			throw new ServiceException("更新的数据不能为空");
		if(StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("菜单名不能为空");
		//数据更新
		int rows=sysMenuDao.updateObject(entity);
		
		if(rows!=1)
			throw new ServiceException("数据更新失败");
		return rows;
	}
	
	@Override
	public List<Node> findZtreeNodes() {
		return sysMenuDao.findZtreeNodes();
	}
	@Override
	public List<Map<String, Object>> findObjects() {
		return sysMenuDao.findObjects();
	}
	@Override
	public void deleteObject(Integer menuId) {
		//1.判定参数有效性
		if(menuId==null||menuId<=0)
	    throw new ServiceException("id值的无效");
		//2.判定此id对应的菜单有没有子菜单
		int num=sysMenuDao.hasChild(menuId);
		if(num>0)
		throw new ServiceException("此菜单下还有子菜单");
		//3.删除菜单
		int rows=sysMenuDao.deleteObject(menuId);
		if(rows==0)
		throw new ServiceException("此菜单可能已经不存在");
	}

}
