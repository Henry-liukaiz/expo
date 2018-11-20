package com.expo.entity.enums;

public enum Sex {
	GIRL("0"), //女
	BOY("1");  //男
    
    private String code;

    Sex(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
