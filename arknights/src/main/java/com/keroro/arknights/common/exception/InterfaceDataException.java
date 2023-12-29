package com.keroro.arknights.common.exception;

/**
 * 接口返回数据异常
 * @author wangpeng
 * @since 2023年12月29日 21:49
 */
public class InterfaceDataException extends RuntimeException {

    public InterfaceDataException(String message) {
        super(message);
    }
}
