package xyz.keroro.common.response;

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
    private String code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 接口数据
     */
    private T data;

    public ResponseResult(boolean success, String code, String msg, T data) {
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

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<>(ResponseCode.SUCCESS.success(), ResponseCode.SUCCESS.code(), ResponseCode.SUCCESS.message(), data);
    }

    public static <T> ResponseResult<T> fail() {
        return new ResponseResult<>(ResponseCode.FAIL.success(), ResponseCode.FAIL.code(), ResponseCode.FAIL.message(), null);
    }

    public static <T> ResponseResult<T> fail(T data) {
        return new ResponseResult<>(ResponseCode.FAIL.success(), ResponseCode.FAIL.code(), ResponseCode.FAIL.message(), data);
    }

    public static <T> ResponseResult<T> fail(boolean success, String code, String message, T data) {
        return new ResponseResult<>(success, code, message, data);
    }
}
