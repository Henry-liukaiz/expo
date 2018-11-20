package com.expo.entity.enums;

public enum Status {
	ZERO("0"), //删除
	ONE("1");  //启用
    
    private String code;

    Status(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
