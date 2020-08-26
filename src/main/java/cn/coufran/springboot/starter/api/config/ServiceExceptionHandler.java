package cn.coufran.springboot.starter.api.config;

import cn.coufran.springboot.starter.api.Result;
import cn.coufran.springboot.starter.api.exception.ServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 业务异常全局处理配置
 * @author liuhuiming
 * @since 1.1.0
 * @version 1.1.0
 */
@RestControllerAdvice
public class ServiceExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public Result handleServiceException(ServiceException e) {
        String message = e.getMessage();
        String code = e.getCode();
        return Result.error(code, message);
    }


}
