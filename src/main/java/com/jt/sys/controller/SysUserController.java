package com.jt.sys.controller;

import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jt.common.vo.JsonResult;
import com.jt.common.vo.PageObject;
import com.jt.sys.pojo.SysUser;
import com.jt.sys.service.SysUserService;

@Controller
@RequestMapping("/user/")
public class SysUserController {
	@Autowired
	private SysUserService sysUserService;
	@RequestMapping("listUI")
	public String listUI(){
		return "sys/user_list";
	}
//	@RequiresPermissions("sys:user:update")
	@RequestMapping("editUI")
	public String editUI(){
		return "sys/user_edit";
	}
	
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer id){
		Map<String,Object>  map=
		sysUserService.findObjectById(id);
		return new JsonResult(1, "ok", map);
	}
	
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(
			SysUser entity,
			String roleIds){
		sysUserService.saveObject(entity, roleIds);
		return new JsonResult(1,"save ok");
	}
	//
//	@RequiresPermissions("sys:user:update")
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(
			SysUser entity,
			String roleIds){
		entity.setModifiedUser("admin");
		sysUserService.updateObject(entity, roleIds);
		return new JsonResult(1, "OK");
	}
	

	@RequestMapping("doValidById")
	@ResponseBody
	public JsonResult doValidById(
			Integer id,
			Integer valid){
		sysUserService.validById(id, valid,"admin");
		return new JsonResult(1, "valid ok");
	}
	
	
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String username,Integer pageCurrent){
		PageObject<SysUser> pageObject=
		       sysUserService.findPageObjects(
				username,pageCurrent);
		return new JsonResult(1, "ok",pageObject);
	}

}
