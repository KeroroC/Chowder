package xyz.keroro.common.response;

public enum ResponseCode implements ResultCode {

    SUCCESS(true, "0", "操作成功"),
    FAIL(false, "-1", "操作失败"),
    USER_NOT_LOGIN(false, "1000", "用户未登录"),
    INVALID_PARAM(false, "10000", "参数不合法");

    final boolean success;

    final String code;

    final String message;

    ResponseCode(boolean success, String code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
