package com.jt.sys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.exception.ServiceException;
import com.jt.common.vo.CheckBox;
import com.jt.common.vo.PageObject;
import com.jt.sys.dao.SysRoleDao;
import com.jt.sys.dao.SysRoleMenuDao;
import com.jt.sys.pojo.SysRole;
import com.jt.sys.service.SysRoleService;
@Service
public class SysRoleServiceImpl implements SysRoleService {
	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
    private SysRoleMenuDao sysRoleMenuDao;
	@Override
	public List<CheckBox> findObjects() {
		return sysRoleDao.findObjects();
	}
	
	@Override
	public int updateObject(SysRole entity,String menuIds) {
		if(entity==null)
		throw new RuntimeException("更新对象不能为空");
		if(entity.getId()==null)
		throw new RuntimeException("更新对象的id不能为空");
	    int rows=sysRoleDao.updateObject(entity);
	    sysRoleMenuDao.deleteObject(entity.getId());
	    sysRoleMenuDao.insertObject(entity.getId(), menuIds.split(","));
	    return rows;
	}
	
	@Override
	public Map<String,Object> findObjectById(Integer id) {
		if(id==null)
		throw new ServiceException("id is null");
		SysRole role=sysRoleDao.findObjectById(id);
		List<Integer> menuIds=sysRoleMenuDao.findMenuIdsByRoleId(id);
		Map<String,Object> map=new HashMap<>();
		map.put("role", role);
		map.put("menuIds", menuIds);
		return map;
	}
	
	@Override
	public int saveObject(SysRole entity,String menuIds) {
		if("admin".equals(entity.getName()))
		throw new ServiceException("role's name already exists");
		int rows=sysRoleDao.insertObject(entity);
		sysRoleMenuDao.insertObject(entity.getId(), menuIds.split(","));
		return rows;
	}
	
    @Override
    public int deleteObject(String ids) {
    	//1.验证参数有效性
    	if(ids==null||ids.length()==0)
    	throw new ServiceException("选中的记录不能为null");
    	//2.对参数数据进行转换
    	String[] checkedIds=ids.split(",");
    	//3.执行删除操作
    	int rows=sysRoleDao.deleteObject(checkedIds);
    	return rows;
    }
	
	
	@Override
	public PageObject<SysRole> findPageObjects(
			Integer pageCurrent, 
			String name) {
		if(pageCurrent<1)
		throw new ServiceException("当前页码不能为负数");
		//1.获取当前页数据
		//1.1定义每页最多显示3条记录
		int pageSize=3;
		//1.2计算每页查询的起始位置(limit startIndex,pageSize)
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysRole> list=
		sysRoleDao.findPageObjects(name,
				startIndex,//查询的起始位置
				pageSize);
		//2.获取总记录数,计算总页数
		int rowCount=sysRoleDao.getRowCount(name);
		int pageCount=rowCount/pageSize;
		if(rowCount%pageSize!=0){
			pageCount++;
		}
		//3.封装数据(封装到pageObject)
		PageObject<SysRole> pageObject=new PageObject<>();
		pageObject.setRecords(list);
		pageObject.setRowCount(rowCount);
		pageObject.setPageCount(pageCount);
		pageObject.setPageCurrent(pageCurrent);
		return pageObject;//pageObject
	}
	
	
	
	
	
	
}
