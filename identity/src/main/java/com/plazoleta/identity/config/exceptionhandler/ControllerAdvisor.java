package com.plazoleta.identity.config.exceptionhandler;

import com.plazoleta.identity.domain.exceptions.BadRequestException;
import com.plazoleta.identity.domain.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class ControllerAdvisor {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionCodeResponse> handleBadRequestException(
            BadRequestException exception
    ) {
        log.error("[ERROR] Code: {} - Resource already exists: {}",
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionCodeResponse(
                exception.getMessage(), HttpStatus.BAD_REQUEST.getReasonPhrase(), LocalDateTime.now(), HttpStatus.BAD_REQUEST.value()));
    }


    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionCodeResponse> handleNotFoundException(NotFoundException exception) {
        log.error("[ERROR] Code: {} - Resource not found: {}",
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionCodeResponse(
                exception.getMessage(), HttpStatus.NOT_FOUND.getReasonPhrase(), LocalDateTime.now(), HttpStatus.NOT_FOUND.value()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionCodeResponse> handlerArgumentInvalidException(MethodArgumentNotValidException exception) {
        FieldError firstFieldError = exception.getFieldErrors().get(0);
        log.error("[ERROR] Code: {} - Validation error: {}",
                HttpStatus.BAD_REQUEST.value(),
                firstFieldError.getDefaultMessage());
        return ResponseEntity.badRequest().body(new ExceptionCodeResponse(firstFieldError.getDefaultMessage(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(), LocalDateTime.now(), HttpStatus.BAD_REQUEST.value()));
    }

}
