package com.jt.common.exception;
/***
 * 自定义异常是对异常信息更加细致的描述,便于我们
 * 对异常进行更加精确的分析.
 * @author adminitartor
 * 借助此异常类处理具体业务异常.
 */
public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = -4181072079763562413L;
	public ServiceException() {
		super();
	}
	public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
	public ServiceException(String message) {
		super(message);
	}
	public ServiceException(Throwable cause) {
		super(cause);
	}
}
