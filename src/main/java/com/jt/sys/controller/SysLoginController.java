package com.jt.sys.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jt.common.vo.JsonResult;
import com.jt.sys.service.SysUserService;
//访问http://localhost:8080/CGB-JT-SYS-V1.02/loginUI.do
@Controller
@RequestMapping("/")
public class SysLoginController {
	  @Autowired
	  private SysUserService sysUserService;
	  @RequestMapping("loginUI")
	  public String loginUI(){
		  return "login";
	  } 
	  @RequestMapping("doLogin")
	  @ResponseBody
	  public JsonResult doLogin(String username,String password){
//		String  r=DigestUtils.md5DigestAsHex("12345".getBytes());
		  sysUserService.login(username, password);
		  return new JsonResult(1, "login ok");
	  }
	  
}






