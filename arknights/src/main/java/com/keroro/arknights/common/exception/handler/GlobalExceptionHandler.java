package com.keroro.arknights.common.exception.handler;

import com.keroro.common.response.ResponseCode;
import com.keroro.common.response.ResponseResult;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author wangpeng
 * @since 2023年12月28日 17:34
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseResult<String> handleException(Exception e) {
        // 接口参数校验异常
        if (e.getClass().equals(ConstraintViolationException.class)) {
            logger.info(e.getMessage());

            return ResponseResult.fail(ResponseCode.INVALID_PARAM.success(),
                    ResponseCode.INVALID_PARAM.code(),
                    ResponseCode.INVALID_PARAM.message(),
                    StringUtils.hasLength(e.getMessage()) ? e.getMessage() : ResponseCode.INVALID_PARAM.message());
        } else {
            logger.error(e.getMessage(), e);
            return ResponseResult.fail(StringUtils.hasLength(e.getMessage()) ? e.getMessage() : "操作失败");
        }

    }
}
