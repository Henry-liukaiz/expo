package com.expo.aspectj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * Created by liukai on 2018/11/18.
 */
public class PrintResponseTimeInterceptor  implements ClientHttpRequestInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(PrintResponseTimeInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        long startTime = System.currentTimeMillis();
        try {
            return execution.execute(request, body);
        } finally {
            LOGGER.info("call {} cost {}ms", request.getURI(), System.currentTimeMillis() - startTime);
        }
    }
}
