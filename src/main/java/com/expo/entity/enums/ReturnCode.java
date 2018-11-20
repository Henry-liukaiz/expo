package com.expo.entity.enums;

public enum ReturnCode {

	SUCCESS("0", "成功"), 
	ERROR("1", "失败"), 
	TOKEN_ERROR("2", "token为空或不正确"), 
	TOKEN_EXPIRE("3", "token过期"),
	TOKEN_USER_ERROR("4", "userId不正确");

	private String code;
	private String msg;

	ReturnCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
