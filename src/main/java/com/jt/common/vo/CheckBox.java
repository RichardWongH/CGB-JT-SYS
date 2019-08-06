package com.jt.common.vo;

import java.io.Serializable;
/**借助此对象封装页面checkbox对象需要的数据*/
public class CheckBox implements Serializable {
	private static final long serialVersionUID = 2031967811425337153L;
	private Integer id;
	private String  name;
	
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
	
}
