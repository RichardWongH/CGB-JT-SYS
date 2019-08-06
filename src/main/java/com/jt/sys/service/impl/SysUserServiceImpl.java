package com.jt.sys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jt.common.exception.ServiceException;
import com.jt.common.vo.PageObject;
import com.jt.sys.dao.SysUserDao;
import com.jt.sys.dao.SysUserRoleDao;
import com.jt.sys.pojo.SysUser;
import com.jt.sys.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService{
	 
	 @Autowired
	 @Qualifier("sysUserDao")
	 private SysUserDao sysUserDao;
	 @Autowired
	 private SysUserRoleDao sysUserRoleDao;
	 @Override
	 public void login(String username,String password) {
		 System.out.println("==login==");
		//参数合法性验证
		 if(StringUtils.isEmpty(username))
			 throw new ServiceException("用户名不能为空");
		 if(StringUtils.isEmpty(password))
			 throw new ServiceException("密码不能为空");
		 //获取Subject主体对象
		 Subject subject=SecurityUtils.getSubject();
		 
	     if(subject.isAuthenticated())return;
	     //2.封装用户名和密码
	     UsernamePasswordToken token=
	     new UsernamePasswordToken(username, password);
//	     3.执行身份认证
	     try {
			subject.login(token);
			//此请求会提交给SecurityManager，SecurityManager会调用认证处理器Authenticator
			//认证处理器会访问相关realm对象获取认证信息
		 }catch (IncorrectCredentialsException ice) {
	        throw new ServiceException("用户名或密码错误！");
	     } catch(AuthenticationException ae){
	        ae.printStackTrace();
	        throw new ServiceException("认证失败");
	     }
	     //记录用户信息
	     Session session = SecurityUtils.getSubject().getSession();
	     session.setAttribute("user", username);
	 }
	 @Override
	 public int updateObject(SysUser entity,
			String roleIds) {
		 //1.参数业务验证
		 if(entity==null)
	     throw new ServiceException("更新对象不能为空");
		 if(entity.getId()==null)
		 throw new ServiceException("更新用户时id不能为空");
		 if(StringUtils.isEmpty(roleIds))
		 throw new ServiceException("用户角色不能为空");
		 //2.更新数据
		 //2.1 更新用户基本信息
		 System.out.println("updateObject.pwd="+entity.getPassword());
		 if(!StringUtils.isEmpty(entity.getPassword())) {
		 String saltStr = UUID.randomUUID().toString();
		 ByteSource salt = ByteSource.Util.bytes(saltStr);
		 //shrio中的类
		 String pwd = new SimpleHash("MD5",entity.getPassword(),salt).toString();
		 entity.setPassword(pwd);
		 entity.setSalt(saltStr);
		 }
		 //更新数据
		 int rows=sysUserDao.updateObject(entity);
		 //2.2删除用户角色关系数据
		 sysUserRoleDao.deleteObject(entity.getId());
		 //2.3重新建立关系
		 try {
			 sysUserRoleDao.insertObject(entity.getId(),
					 roleIds.split(","));
		} catch (Exception e) {
			throw new ServiceException("系统维护中");
		}
		 
		return rows;
	}
	
	 @Override
	 public Map<String, Object> findObjectById(Integer id) {
		 //合法性验证
		 //查找用户信息
		 SysUser user=sysUserDao.findObjectById(id);
		 //查询角色信息
		 List<Integer> roleIds=
		 sysUserRoleDao.findRolesByUserId(id);
		 //封装数据
		 Map<String,Object> map=new HashMap<String,Object>();
		 map.put("sysUser", user);
		 map.put("roleIds", roleIds);
		 return map;
	 }
	 
	 @SuppressWarnings("unused")
	@Override
	 public int saveObject(SysUser entity, 
			String roleIds) {//2,3,4,5,
		//1.保存用户信息
		System.out.println("start.id="+entity.getId());
		//1.对数据进行合法验证
				if(entity==null)
				throw new ServiceException("保存对象不能为空");
				if(StringUtils.isEmpty(entity.getUsername()))
				throw new ServiceException("用户名不能为空");
				if(StringUtils.isEmpty(entity.getPassword()))
				throw new ServiceException("用户密码不能为空");
				if(StringUtils.isEmpty(roleIds))
				throw new ServiceException("必须要选择一个角色");
				//2.保存用户数据
				//2.1对密码进行加密(后续会采用md5加密算法)
		String saltStr = UUID.randomUUID().toString();
		ByteSource salt = ByteSource.Util.bytes(saltStr);
		String newPwd = new SimpleHash("MD5",entity.getPassword(),salt).toString();
		entity.setPassword(newPwd);
		entity.setSalt(saltStr);
		//2.2存储用户信息
		int rows;
		try {
			 rows=sysUserDao.insertObject(entity);
		} catch (Exception e) {
			e.printStackTrace();
			//报警
			 if(e instanceof DuplicateKeyException){
			 throw new ServiceException("此用户已存在");
			 }
			throw new ServiceException("系统维护中");
		}
		
		System.out.println("end.id="+entity.getId());
		//2.保存关系数据(用户与角色关系数据)
		try {
			sysUserRoleDao.insertObject(entity.getId(),roleIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			 //报警
			throw new ServiceException("系统维护中");
		}
		
		return rows;
	 }
	//底层Subject.isPermitted(....)是否有权限
//	@RequiresPermissions("sys:user:valid")
	 @Override
	 public int validById(Integer id, Integer valid,String modifiedUser) {
		//1.参数有效性验证
		 if(id==null||id<1)
		 throw new ServiceException("id 值无效");
		 if(valid==null||valid<0)
	     throw new ServiceException("状态值无效");
		 
		//2.执行更新操作,修改状态信息
			int rows;
			try{
		    rows=sysUserDao.validById(id, valid,modifiedUser);
			}catch(Throwable e){
			e.printStackTrace();
		    //报警
			throw new ServiceException("系统维护中");
			}
			//3.验证结果并处理
			if(rows==0)
			throw new ServiceException("数据可能已经不存在");
		return rows;
	}
	 
	 
     @Override
     public PageObject<SysUser> findPageObjects(String username, 
    		 Integer pageCurrent) {
    	//1.查询当前页数据
    	 int pageSize=3;
    	 //开始的序列号，第二页就从三开始
    	 int startIndex=(pageCurrent-1)*pageSize;
    	 List<SysUser> records=
    		sysUserDao.findPageObjects(username,
    			 startIndex, pageSize);
    	//2.根据条件查询总记录数
    	 int rowCount=sysUserDao.getRowCount(username);
    	 int pageCount=rowCount/pageSize;
    	 if(rowCount%pageSize!=0){
    		 pageCount++;
    	 }
    	//3.封装数据(当前页数据,分页信息)
    	 PageObject<SysUser> pageObject=
    			 new PageObject<>();
    	 pageObject.setPageCount(pageCount);
    	 pageObject.setRowCount(rowCount);
    	 pageObject.setPageCurrent(pageCurrent);
    	 pageObject.setRecords(records);
    	 
    	return pageObject;
     }
}
