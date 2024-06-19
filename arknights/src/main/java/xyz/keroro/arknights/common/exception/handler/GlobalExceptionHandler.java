package xyz.keroro.arknights.common.exception.handler;

import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.keroro.common.response.ResponseCode;
import xyz.keroro.common.response.ResponseResult;

/**
 * @author wangpeng
 * @since 2023年12月28日 17:34
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理接口参数校验异常
     * @param e exception
     * @return ResponseResult<String>
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseResult<String> handleConstraintViolationException(Exception e) {
        logger.info(e.getMessage());

        return ResponseResult.fail(ResponseCode.INVALID_PARAM.success(),
                ResponseCode.INVALID_PARAM.code(),
                ResponseCode.INVALID_PARAM.message(),
                StringUtils.hasLength(e.getMessage()) ? e.getMessage() : ResponseCode.INVALID_PARAM.message());
    }

    /**
     * 处理其他的所有异常
     * @param e exception
     * @return ResponseResult<String>
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult<String> handleException(Exception e) {
        logger.error(e.getMessage(), e);
        return ResponseResult.fail(StringUtils.hasLength(e.getMessage()) ? e.getMessage() : "操作失败");
    }
}
