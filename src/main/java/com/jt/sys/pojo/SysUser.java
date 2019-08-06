package com.jt.sys.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.DatatypeConverter;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jt.common.DateJsonSerializer;

public class SysUser implements Serializable{
	private static final long serialVersionUID = -6134435220278610755L;
	private Integer id;
	private String  username;
	private String  password;
	private String  email;
	private String  mobile;
	private String  salt;  //盐值
	private Integer valid=1;
	private Date    createdTime;
	private String  createdUser;
	private String  modifiedUser;
	private Date    modifiedTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public Integer getValid() {
		return valid;
	}
	public void setValid(Integer valid) {
		this.valid = valid;
	}
	@JsonSerialize(using=DateJsonSerializer.class)
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
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
	@JsonSerialize(using=DateJsonSerializer.class)
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	@Override
	public String toString() {
		return "SysUser [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", mobile=" + mobile + ", salt=" + salt + ", valid=" + valid + ", createdTime=" + createdTime
				+ ", createdUser=" + createdUser + ", modifiedUser=" + modifiedUser + ", modifiedTime=" + modifiedTime
				+ "]";
	}

}
