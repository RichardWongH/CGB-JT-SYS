package com.jt.sys.pojo;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jt.common.DateJsonSerializer;
/**持久化对象(有些企业还会定义在entity包中)
 * 1)int insertObject(SysRole entity);
 * 2)SysRole doFindSysRoleById(Integer id);
 * 这样的对象编写时应注意:
 * 1)实现Serializable接口,并提供版本ID
 * 2)提供无参构造函数
 * 3)提供属性以及对应的set/get方法,一般属性名要与
 * 表中的字段名保持一致.
 * 4)有选择性的重写toString方法
 * */
public class SysRole implements Serializable{
	private static final long serialVersionUID = -5225339701513043662L;
    private Integer id;
    private String name;
    private String note;
    private Date createdTime;
    private Date modifiedTime;
    private String createdUser;
    private String modifiedUser;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@JsonSerialize(using=DateJsonSerializer.class)
	public Date getCreatedTime() {
		System.out.println("getCreatedTime");
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	@JsonSerialize(using=DateJsonSerializer.class)
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	@Override
	public String toString() {
		return "SysRole [id=" + id + ", name=" + name + ", note=" + note + ", createdTime=" + createdTime
				+ ", modifiedTime=" + modifiedTime + ", createdUser=" + createdUser + ", modifiedUser=" + modifiedUser
				+ "]";
	}
    
}






