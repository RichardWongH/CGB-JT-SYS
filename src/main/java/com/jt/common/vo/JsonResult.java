package com.jt.common.vo;
/***
 * 借助此类对控制层返回的数据进行统一封装,
 * 便于在客户端对数据进行更好处理.
 * @author adminitartor
 */
public class JsonResult {//Result/R
     /**状态码(例如404是一个状态)
      * State=1,表示业务成功完成.
	  * State=0,表示业务完成失败*/
	 private int state=1;
	 /**与状态码对应的具体消息(
	  * 例如404表示错误信息,是url对应的地址没找到)
	  * */
	 private String message="OK";
	 /**借助此属性封装服务端返回的具体数据,
	  * 例如查询的结果*/
  	 private Object data;
  	 public JsonResult() {}
  	 public JsonResult(int state,String message) {
  		 this.state=state;
  		 this.message=message;
  	 }
  	 public JsonResult(int state,String message,Object data) {
  		 this.state=state;
  		 this.message=message;
  		 this.data=data;
  	 }
  	 /**当在控制层将一个JsonResult对象
  	  * 转换为JSON串时,会调用此对象对应的
  	  * get方法*/
  	 public int getState() {
		return state;
	 }
  	 public String getMessage() {
		return message;
	 }
  	 public Object getData() {
		return data;
	 }
}
