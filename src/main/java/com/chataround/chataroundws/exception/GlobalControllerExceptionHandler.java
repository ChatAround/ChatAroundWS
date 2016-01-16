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


    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User Not Found")
    @ExceptionHandler(OnlineUserNotFoundException.class)
    public void handleUserNotFoundException(OnlineUserNotFoundException e) {
    }

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Wrong Password")
    @ExceptionHandler(WrongPasswordException.class)
    public void handleWrongPasswordException(WrongPasswordException e) {
    }

    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Username Already exists")
    @ExceptionHandler(AlreadyInUseUsername.class)
    public void handleAlreadyInUseUsernameException(AlreadyInUseUsername e) {
    }


    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    @ExceptionHandler(Exception.class)
    public void defaultErrorHandler(Exception e) throws Exception {
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) throw e;
    }
}
