package com.jt.sys.controller;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.CheckBox;
import com.jt.common.vo.JsonResult;
import com.jt.common.vo.PageObject;
import com.jt.sys.pojo.SysRole;
import com.jt.sys.pojo.SysUser;
import com.jt.sys.service.SysRoleService;
@RequestMapping("/role/")
@Controller
public class SysRoleController {
	@Autowired
	private SysRoleService sysRoleService;
	
//	@RequiresPermissions("sys:role:view")
	@RequestMapping("listUI")
	public String listUI(){
		return "sys/role_list";
	}
	@RequestMapping("editUI")
	public String editUI(){
		return "sys/role_edit";
	}
	@RequestMapping("doFindObjects")
	@ResponseBody
	public JsonResult doFindObjects(){
		List<CheckBox> list=
		sysRoleService.findObjects();
		return new JsonResult(1, "ok",list);
	}
	
//	@RequiresPermissions("sys:role:update")
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysRole entity,String menuIds){
		sysRoleService.updateObject(entity,menuIds);
		return new JsonResult(1,"update ok");
	}
	
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public Map<String,Object> doFindObjectById(Integer id){   
		return sysRoleService.findObjectById(id);
	}
   /*
	@ExceptionHandler(ServiceException.class)
	public ModelAndView handleException(
			ServiceException e){
		return null;
	}*/
	
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(
			SysRole entity,String menuIds){
		sysRoleService.saveObject(entity,menuIds);
		return new JsonResult(1, "save ok");
	}
	//权限控制
//	@RequiresPermissions("sys:role:delete")
	@RequestMapping("doDeleteObject.do")
	@ResponseBody
	public JsonResult doDeleteObject(String checkedIds){
		System.out.println("checkedIds="+checkedIds);
		sysRoleService.deleteObject(checkedIds);
		return new JsonResult(1,"delete ok");
	}//controller-->service-->dao
	
	//表示层(view,controller)/业务层(service)/数据层(dao)
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(
			Integer pageCurrent,String name){
		PageObject<SysRole> pageObject=
		sysRoleService.
		findPageObjects(pageCurrent, name);
		return new JsonResult(1,"query ok", pageObject);//data
	}
}




