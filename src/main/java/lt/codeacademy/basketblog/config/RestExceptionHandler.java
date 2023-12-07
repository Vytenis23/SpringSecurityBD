package lt.codeacademy.basketblog.config;

import lt.codeacademy.basketblog.dto.ErrorResponse;
import lt.codeacademy.basketblog.exception.AppException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = { AppException.class })
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleException(AppException ex) {
        return ResponseEntity
                .status(ex.getStatus())
                .body(ErrorResponse.builder().message(ex.getMessage()).build());
    }
}