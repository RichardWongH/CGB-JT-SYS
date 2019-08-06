package com.jt.sys.dao;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.jt.sys.pojo.SysUser;
/**此接口的实现类会交给Spring创建*/
public interface SysUserDao {
	/**
	 * 根据用户id查找用户权限标识信息
	 * 例如：sys:role:view,sys:role:add
	 * @param userId
	 * @return
	 */
	List<String> findUserPermissions(Integer userId);
	/**根据ID查找用户信息*/
	SysUser findObjectById(Integer id);
	/**根据用户名查找用户信息*/
	SysUser findObjectByUserName(String username);
	
	/**更新用户信息*/
	int updateObject(SysUser entity);
	
	/**写入用户信息*/
	int insertObject(SysUser entity);
	
	/**通过这个方法实现禁用启用操作*/
	int validById(
			@Param("id")Integer id,
			@Param("valid")Integer valid,
			@Param("modifiedUser")String modifiedUser);
    /**
     * 分页查询页面信息
     * @param username
     * @param startIndex
     * @param pageSize
     * @return
     */
	List<SysUser> findPageObjects(
			@Param("username")String username,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize") Integer pageSize);
	
	int getRowCount(@Param("username")String username);
	
	
	

}






