package com.myproject.admin.api;

/**
 * 通用返回对象
 *      1、响应码 code
 *      2、返回给客户端的内容 data
 *      3、提示信息 message
 */
public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    protected CommonResult(){}

    protected CommonResult(long code,String message,T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    /**
     * 返回成功的结果
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data);
    }


    /**
     * 定制成功结果的消息
     */
    public static <T> CommonResult<T> success(String message,T data) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),message,data);
    }


    /**
     * 返回失败的结果
     */
    public static <T> CommonResult<T> failed() {
        return failed(ResultCode.FAILED);
    }

    public static <T> CommonResult<T> failed(IErrorCode errorCode) {
        return new CommonResult<T>(errorCode.getCode(),errorCode.getMessage(),null);
    }

    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(ResultCode.FAILED.getCode(),message,null);
    }

    /**
     * 参数检验失败的结果
     */
    public static <T> CommonResult<T> validateFailed() {
        return validateFailed(ResultCode.VALIDATE_FAILED);
    }

    public static <T> CommonResult<T> validateFailed(IErrorCode errorCode) {
        return new CommonResult<T>(errorCode.getCode(),errorCode.getMessage(),null);
    }

    public static <T> CommonResult<T> validateFailed(String message) {
        return new CommonResult<T>(ResultCode.VALIDATE_FAILED.getCode(),message,null);
    }

    /**
     * 未登录返回的结果
     */
    public static <T> CommonResult<T> unauthorized() {
        return validateFailed(ResultCode.UNAUTHORIZED);
    }

    /**
     * 未授权返回结果
     */
    public static <T> CommonResult<T> forbidden(T data) {
        return new CommonResult<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }

    public static <T> CommonResult<T> unauthorized(IErrorCode errorCode) {
        return new CommonResult<T>(errorCode.getCode(),errorCode.getMessage(),null);
    }

    public static <T> CommonResult<T> unauthorized(T data) {
        return new CommonResult<T>(ResultCode.UNAUTHORIZED.getCode(),ResultCode.UNAUTHORIZED.getMessage(),data);
    }
    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
