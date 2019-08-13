package com.ddastudio.fishing.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019-08-06
 */

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class FishingExceptionHandler {

    @ExceptionHandler(FishingValidationException.class)
    @ResponseBody
    public ResponseEntity handleValidationException(FishingValidationException e) {
        ErrorVO errorVO = ErrorVO.builder()
                .code(101)
                .message(e.getMessage())
                .build();
        return ResponseEntity.badRequest().body(new ErrorResource(errorVO));
    }

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseBody
    public ResponseEntity handleDataNotFoundException(DataNotFoundException e) {
        ErrorVO errorVO = ErrorVO.builder()
                .code(100)
                .message(e.getMessage())
                .build();
        return ResponseEntity.badRequest().body(new ErrorResource(errorVO));
    }

    @ExceptionHandler(FishingException.class)
    @ResponseBody
    public ResponseEntity handleFishingException(FishingException e) {
        ErrorVO errorVO = ErrorVO.builder()
                .code(200)
                .message(e.getMessage())
                .build();
        return ResponseEntity.badRequest().body(new ErrorResource(errorVO));
    }

    @ExceptionHandler(FishingRuntimeException.class)
    @ResponseBody
    public ResponseEntity handleFishingRuntimeException(FishingRuntimeException e) {
        ErrorVO errorVO = ErrorVO.builder()
                .code(300)
                .message(e.getMessage())
                .build();
        return ResponseEntity.badRequest().body(new ErrorResource(errorVO));
    }
}
