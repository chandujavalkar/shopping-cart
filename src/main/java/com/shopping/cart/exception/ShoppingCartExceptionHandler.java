package com.shopping.cart.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.shopping.cart.constants.ShoppingCartConstants;
import com.shopping.cart.util.ShoppingCartErrorUtil;

@ControllerAdvice
public class ShoppingCartExceptionHandler {
	
	@Autowired
	public ShoppingCartErrorUtil shoppingCartErrorUtil;
	
	public ShoppingCartExceptionHandler(){
		
	}
	
	@ExceptionHandler(ShoppingCartException.class)
	public ResponseEntity<Map<String, String>> handleCRMException(
			ShoppingCartException ex) {
		Map<String, String> errorResponse = this.getErrorResponse(ex.getErrorMsg());
		return new ResponseEntity<Map<String,String>>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	private Map<String,String> getErrorResponse(String errorCode) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put(ShoppingCartConstants.ERROR_CODE, errorCode);
		errorMap.put(ShoppingCartConstants.ERROR_MESSAGE, this.shoppingCartErrorUtil.getError().get(errorCode));
		return errorMap;
	}

}
