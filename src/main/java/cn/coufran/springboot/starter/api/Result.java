package cn.coufran.springboot.starter.api;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * API标准结果
 * @author liuhuiming
 * @since 1.1.0
 * @version 1.1.0
 */
public class Result <T extends Serializable> implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final String DEFAULT_CODE_OK = "200";
    private static final String DEFAULT_CODE_ERROR = "500";
    private static final String DEFAULT_MSG_OK = "成功";
    private static final String DEFAULT_MSG_ERROR = "失败";

    private boolean success;
    private String code;
    private String msg;
    private T data;

    public Result() {
    }

    public Result(boolean success, String code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public static Result ok() {
        return Result.ok(null);
    }

    public static <T extends Serializable> Result<T> ok(T data) {
        return Result.ok(DEFAULT_CODE_OK, DEFAULT_MSG_OK, data);
    }

    public static Result ok(int code) {
        return Result.ok(code, DEFAULT_MSG_OK);
    }

    public static Result ok(String msg) {
        return Result.ok(DEFAULT_CODE_OK, msg);
    }

    public static Result ok(int code, String msg) {
        return Result.ok(code, msg, null);
    }

    public static Result ok(String code, String msg) {
        return Result.ok(code, msg, null);
    }

    public static <T extends Serializable> Result<T> ok(int code, String msg, T data) {
        return Result.ok(String.valueOf(code), msg, data);
    }

    public static <T extends Serializable> Result<T> ok(String code, String msg, T data) {
        return new Result(true, code, msg, data);
    }

    public static Result error() {
        return Result.error(null);
    }

    public static Result error(int code) {
        return Result.error(code, DEFAULT_MSG_ERROR);
    }

    public static Result error(String msg) {
        return Result.error(DEFAULT_CODE_ERROR, msg);
    }

    public static Result error(int code, String msg) {
        return Result.error(code, msg, null);
    }

    public static Result error(String code, String msg) {
        return Result.error(code, msg, null);
    }

    public static <T extends Serializable> Result<T> error(int code, String msg, T data) {
        return Result.error(String.valueOf(code), msg, data);
    }

    public static <T extends Serializable> Result<T> error(String code, String msg, T data) {
        return new Result(false, code, msg, data);
    }
}
