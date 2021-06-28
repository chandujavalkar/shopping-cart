package com.shopping.cart.exception;

public class ShoppingCartException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errorMsg;
	private String exceptionStackTrace;
	private int statusCode;

	public ShoppingCartException(String errorMsg, String exceptionStackTrace) {
		super(errorMsg);
		this.errorMsg = errorMsg;
		this.exceptionStackTrace = exceptionStackTrace;
	}

	public ShoppingCartException(int statusCode, String errorMsg) {
		super(errorMsg);
		this.errorMsg = errorMsg;
		this.statusCode = statusCode;
	}

	public ShoppingCartException(String errorMsg) {
		super(errorMsg);
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getExceptionStackTrace() {
		return exceptionStackTrace;
	}

	public void setExceptionStackTrace(String exceptionStackTrace) {
		this.exceptionStackTrace = exceptionStackTrace;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return "ShoppingCartException [errorMsg=" + errorMsg + ", exceptionStackTrace=" + exceptionStackTrace + "]";
	}

}
