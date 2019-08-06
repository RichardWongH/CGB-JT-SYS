package com.jt.sys.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.common.vo.CheckBox;
import com.jt.sys.pojo.SysRole;
/**数据持久层对象?
 * 此类型的对象由谁创建?(框架,mybatis-spring)
 * 回顾mybatis中是如何获得DAO对象的?
 * SysRoleDao dao=
 * sqlSession.getMapper(SysRoleDao.class);
 * 说明:在mybatis应用于此接口对应的通常会有一个
 * mapper文件
 * */
public interface SysRoleDao {
	 List<String> findUserPermissions(Integer userId);
	 /**查询所有角色信息:只包含id和name*/
	 List<CheckBox> findObjects();
	 /***
	  * 
	  * @param name 按名字查询时的查询参数
	  * @param startIndex 分页查询时起始页的位置
	  * @param pageSize 每页最多显示多少提交记录
	  * @return
	  */
	 List<SysRole> findPageObjects(
			   @Param("name") String name,
			   @Param("startIndex")Integer startIndex,
			   @Param("pageSize")Integer pageSize);
	 /**统计记录数*/
	 int getRowCount(@Param("name") String name);
	
	 /**根据id删除角色信息,这个ids
	  * 可能对应多id值,例如1,2,3,4*/
	 int deleteObject(@Param("ids")String[] ids);
	 /**执行insert操作*/
	 int insertObject(SysRole entity);
	 /**根据id查询角色信息*/
	 SysRole findObjectById(Integer id);
	 /**根据id修改角色信息*/
	 int updateObject(SysRole entity);
}










