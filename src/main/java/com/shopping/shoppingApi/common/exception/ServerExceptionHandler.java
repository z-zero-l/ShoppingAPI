package com.shopping.shoppingApi.common.exception;

import com.shopping.shoppingApi.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ServerExceptionHandler {

    /**
     * 处理自定义异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(ServerException.class)
    public ResponseEntity<Result<Object>> handleException(ServerException exception) {
        return Result.error(exception.getCode(), exception.getMsg()).responseEntity();
    }

    /**
     * 数据校验异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity<Result<Object>> bindException(BindException exception) {
        FieldError fieldError = exception.getFieldError();
        assert fieldError != null;
        return Result.error(fieldError.getDefaultMessage()).responseEntity();
    }

    /**
     * 其他异常情况
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Result<Object>> handleException(Exception exception) {
        log.error(exception.getMessage(), exception);
        return Result.error(ErrorCode.INTERNAL_SERVER_ERROR).responseEntity();
    }
}