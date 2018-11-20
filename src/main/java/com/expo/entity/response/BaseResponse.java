package com.expo.entity.response;


import com.expo.util.PageUtil;
import lombok.Data;

import java.util.Date;

@Data
public class BaseResponse<T> {
    private String code;   		// 业务响应码，默认是0
    private String message;  	// 响应消息，默认是ok
    private String token;		//token
    private long tokenMillis = new Date().getTime();	//token时限
    T data;
    private PageUtil pageUtil;	//分页信息

}
