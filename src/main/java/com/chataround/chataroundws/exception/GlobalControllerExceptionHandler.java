package com.chataround.chataroundws.exception;

/**
 * @author Georgia Grigoriadou
 */
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerExceptionHandler {
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    @ExceptionHandler(Exception.class)
    public void defaultErrorHandler(Exception e) throws Exception {
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) throw e;
    }
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Error in passing null properties")
    @ExceptionHandler(NullLocationPropertiesException.class)
    public void handleNullLocationPropertiesException(NullLocationPropertiesException e) {
    }
}
