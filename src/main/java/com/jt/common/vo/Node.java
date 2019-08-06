package com.jt.common.vo;

import java.io.Serializable;

public class Node implements Serializable{
	private static final long serialVersionUID = 4351174414771192644L;
	private Integer id;
	private Integer parentId;
	private String name;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
