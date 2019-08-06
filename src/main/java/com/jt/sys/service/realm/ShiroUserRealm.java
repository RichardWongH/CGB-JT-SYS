package com.jt.sys.service.realm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jt.sys.dao.SysUserDao;
import com.jt.sys.pojo.SysUser;

/**通过Realm这个领域对象对认证领域和授权领域信息进行检测*/
@Component
public class ShiroUserRealm extends AuthorizingRealm {
	/*
	 * @Autowired private SysShiroService loginService;
	 */
	@Autowired
    private SysUserDao sysUserDao;
	/**负责授权检测
	 * 完成授权信息的获取及其封装
	 * 此方法何时调用（执行检测时调用）
	 * */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("doGetAuthorizationInfo");
		// 1.获取登录用户信息
		String username= (String)principals.getPrimaryPrincipal();
		//2查找用户权限信息
		//
		SysUser user = (SysUser) SecurityUtils.getSubject()
				.getSession().getAttribute("user");
		int userId = user.getId();
		List<String> permsList = new ArrayList<>();
		permsList = sysUserDao.findUserPermissions(userId);
		// 用户权限列表
		Set<String> permsSet = new HashSet<String>();
		for (String perm : permsList) {
			if (perm != null && !("".equals(perm))) {
				permsSet.add(perm);
			}
		}
		System.out.println("permsSet=" + permsSet);
		//3对权限信息进行封装
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(permsSet);
		return info;

	}
	/**
	 * 完成认证信息的获取以及封装
	 * @param token，封装用户身份信息及凭证信息对象
	 * @return  AuthenticationInfo 封装信息的对象（从数据库查到）
	 * client-->controller-->service-->realm
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
		AuthenticationToken token)
		throws AuthenticationException {
		System.out.println("doGetAuthenticationInfo");
		// 1.获取用户身份信息
		UsernamePasswordToken upt=(UsernamePasswordToken)token;
		String username=upt.getUsername();
		//2.基于用户身份查询数据信息
		SysUser user=sysUserDao.findObjectByUserName(username);
		//3.对查询结果进行封装
				//获取用户salt值，将其转换为一个字节源对象
		ByteSource credentialsSalt=ByteSource.Util.bytes(user.getSalt());
		System.out.println("user.password="+user.getPassword());
		SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(
				//主身user.getUsername()
		user.getUsername(),user.getPassword(),credentialsSalt,getName());
		//realm 的名字getname  
		SecurityUtils.getSubject().getSession().setAttribute("user",user);
		return info;
	}

}
