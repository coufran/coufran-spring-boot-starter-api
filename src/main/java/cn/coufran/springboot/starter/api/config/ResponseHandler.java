package cn.coufran.springboot.starter.api.config;

import cn.coufran.springboot.starter.api.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.io.Serializable;

/**
 * 返回数据包装
 * @author coufran
 * @version 1.0.0
 * @since 1.0.0
 */
@ControllerAdvice
public class ResponseHandler implements ResponseBodyAdvice<Object> {

    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {
        if(body instanceof Result) {
            return body;
        } else if(body instanceof Serializable) {
            return Result.ok((Serializable) body);
        } else {
            return body;
        }
    }
}