package com.keroro.common.response;

/**
 * 统一响应体
 * @author wangpeng
 * @since 2023年12月28日 16:21
 */
public class ResponseResult<T> {

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 状态码
     */
    private int code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 接口数据
     */
    private T data;

    public ResponseResult(boolean success, int code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<>(ResponseCode.SUCCESS.success(), ResponseCode.SUCCESS.code(), ResponseCode.SUCCESS.message(), data);
    }

    public static <T> ResponseResult<T> fail() {
        return new ResponseResult<>(ResponseCode.FAIL.success(), ResponseCode.FAIL.code(), ResponseCode.FAIL.message(), null);
    }

    public static <T> ResponseResult<T> fail(T data) {
        return new ResponseResult<>(ResponseCode.FAIL.success(), ResponseCode.FAIL.code(), ResponseCode.FAIL.message(), data);
    }

    public static <T> ResponseResult<T> fail(boolean success, int code, String message, T data) {
        return new ResponseResult<>(success, code, message, data);
    }
}
