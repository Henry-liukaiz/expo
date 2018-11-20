package com.expo.util;

import lombok.Data;

@Data
public class PageUtil {

    private int pageNo; 	// 当前页数
    private int pageSize = 6; 	// 每页显示的数据条数
    private int totalCount; // 总条数

    public PageUtil(){}

    public PageUtil(int pageNo, int pageSize){
    	this.pageNo = pageNo;
    	this.pageSize = pageSize;
    }
}
