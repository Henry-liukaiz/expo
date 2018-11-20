package com.expo.controller.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.expo.entity.enums.ReturnCode;
import com.expo.entity.response.BaseResponseBuilder;
import com.expo.util.Constant;
import com.expo.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;


@Configuration
public class TokenFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        HttpServletRequest sr = (HttpServletRequest) request;

        //login、图片虚拟路径files 不校验token
        if (sr.getServletPath().indexOf("login") != -1 || sr.getServletPath().indexOf("register") != -1 || sr.getServletPath().indexOf("files") != -1) {
            chain.doFilter(request, response);
        } else {
            try {
                String token = sr.getHeader("token");
                String userId = sr.getHeader("userId");
                long tokenMillis = Long.parseLong(sr.getHeader("tokenMillis") == null ? "0" : sr.getHeader("tokenMillis"));

                if (null != token && !"".equals(token) && !"null".equals(token)) {
                    //校验token
                    Claims claims = JwtUtil.parseJWT(token);
                    if (null != claims) {
                        //校验token过期时间
                        if (new Date().getTime() - tokenMillis >= Constant.EXPIRE_TIME) {
                            IOUtils.write(JSON.toJSONString(BaseResponseBuilder.buildBaseResponse(ReturnCode.TOKEN_EXPIRE)), response.getWriter());
                        } else {
                            String sub_userId = JSONObject.parseObject(claims.getSubject()).getString("userId");
                            if (userId.equals(sub_userId)) {
                                chain.doFilter(request, response);
                            } else {
                                //用户ID不正确
                                IOUtils.write(JSON.toJSONString(BaseResponseBuilder.buildBaseResponse(ReturnCode.TOKEN_USER_ERROR)), response.getWriter());
                            }
                        }
                    } else {
                        //token为空或不正确
                        IOUtils.write(JSON.toJSONString(BaseResponseBuilder.buildBaseResponse(ReturnCode.TOKEN_ERROR)), response.getWriter());
                    }
                } else {
                    //token为空或不正确
                    IOUtils.write(JSON.toJSONString(BaseResponseBuilder.buildBaseResponse(ReturnCode.TOKEN_ERROR)), response.getWriter());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void destroy() {

    }
}
