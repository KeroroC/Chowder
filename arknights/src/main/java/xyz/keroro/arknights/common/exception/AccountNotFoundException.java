package xyz.keroro.arknights.common.exception;

/**
 * 账号未找到异常
 * @author wangpeng
 * @since 2023年12月28日 21:16
 */
public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(String message) {
        super(message);
    }
}
