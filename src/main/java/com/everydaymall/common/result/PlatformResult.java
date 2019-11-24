package com.everydaymall.common.result;

import java.io.Serializable;

import com.everydaymall.common.constants.Constants;

import lombok.Data;

@Data
public class PlatformResult<T> implements Serializable {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 8968766969795754248L;

	/**
	 * 描述
	 */
	private String message;

	/**
	 * 状态
	 */

	private int statusCode;

	 
	private boolean success;

	private T object;
	
    public static <T> PlatformResult<T> success() {
		PlatformResult<T> result = new PlatformResult<>();
		result.setSuccess(true);
		result.setStatusCode(Constants.STATUS_SUCESS_CODE);
		return result;
	}
	
	public static <T> PlatformResult<T> success(T data) {
		PlatformResult<T> result = new PlatformResult<>();
		result.setSuccess(true);
		result.setStatusCode(Constants.STATUS_SUCESS_CODE);
		result.setObject(data);
		return result;
	}
	
	public static <T> PlatformResult<T> failure() {
		PlatformResult<T> result = new PlatformResult<>();
		result.setSuccess(false);
		return result;
	}
	
	public static <T> PlatformResult<T> failure(String message) {
		PlatformResult<T> result = new PlatformResult<>();
		result.setSuccess(false);
		result.setMessage(message);
		return result;
	}
	
	public static <T> PlatformResult<T> failure(String message, T data) {
		PlatformResult<T> result = new PlatformResult<>();
		result.setSuccess(false);
		result.setMessage(message);
		result.setObject(data);
		return result;
	}
}
