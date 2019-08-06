package com.jt.common.controller;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.exception.ServiceException;
import com.jt.common.vo.JsonResult;
/**借助注解描述此类为全局异常处理类*/
@ControllerAdvice
public class ControllerExceptionHandler {
	  /***
	   * @ExceptionHandler 用于描述这个方法能够
	   * 处理的异常.
	   * @param e
	   */
	  @ExceptionHandler({ServiceException.class,AuthorizationException.class})
	  @ResponseBody
	  public JsonResult handleServiceException(
			  RuntimeException e){
		  e.printStackTrace();
		  String message="出异常了";
		  if(e instanceof ServiceException) {
			  message=e.getMessage();
		  }else if(e instanceof AuthorizationException) {
			  message="没有权限";
		  }
		  return new JsonResult(0,message);
	  }
}


