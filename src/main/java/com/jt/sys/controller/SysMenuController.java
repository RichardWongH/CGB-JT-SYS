package com.jt.sys.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.JsonResult;
import com.jt.common.vo.Node;
import com.jt.sys.pojo.SysMenu;
import com.jt.sys.service.SysMenuService;

@RequestMapping("/menu/")
@Controller
public class SysMenuController {

	@Autowired
	private SysMenuService sysMenuService;
	
	@RequestMapping("listUI")
	public String listUI(){
		return "sys/menu_list";
	}
	@RequestMapping("editUI")
	public String editUI(){
		return "sys/menu_edit";
	}
	@RequestMapping("treeUI")
	@ResponseBody
	public JsonResult treeUI(){
		List<Node> list=sysMenuService.findZtreeNodes();
		return new JsonResult(1,"ok",list);
	}
	
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer id){
		Map<String,Object> map=
		sysMenuService.findObjectById(id);
		return new JsonResult(1, "ok", map);
	}
	
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysMenu entity){
		sysMenuService.saveObject(entity);
		return new JsonResult(1, "save ok");
	}
	
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysMenu entity){
		sysMenuService.updateObject(entity);
		return new JsonResult(1, "update ok");
	}
	
	@RequestMapping("doFindObjects")
	@ResponseBody
	public JsonResult doFindObjects(){
		
		List<Map<String,Object>> list=
		sysMenuService.findObjects();
		
		return new JsonResult(1, "ok",list);
	}
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer menuId){
		sysMenuService.deleteObject(menuId);
		return new JsonResult(1, "delete ok");
	}
}
