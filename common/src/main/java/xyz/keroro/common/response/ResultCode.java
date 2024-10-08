package xyz.keroro.common.response;

/**
 * @author wangpeng
 * @since 2023年12月28日 16:38
 */
public interface ResultCode {

    /**
     * 是否成功
     */
    boolean success();

    /**
     * 状态码
     */
    String code();

    /**
     * 提示信息
     */
    String message();
}
