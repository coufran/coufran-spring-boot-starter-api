package cn.coufran.springboot.starter.api.exception;

/**
 * 业务错误
 * @author liuhuiming
 * @since 1.1.0
 * @version 1.1.0
 */
public class ServiceException extends RuntimeException {
    private String code;

    public String getCode() {
        return code;
    }

    public ServiceException(int code, String message) {
        this(String.valueOf(code), message);
    }

    public ServiceException(String code, String message) {
        super(message);
        this.code = code;
    }

    public ServiceException(int code, String message, Throwable e) {
        this(String.valueOf(code), message, e);
    }

    public ServiceException(String code, String message, Throwable e) {
        super(message, e);
        this.code = code;
    }

    public ServiceException(int code) {
        this.code = String.valueOf(code);
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable e) {
        super(e);
    }

}
