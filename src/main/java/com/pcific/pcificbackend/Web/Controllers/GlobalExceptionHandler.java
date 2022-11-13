package com.pcific.pcificbackend.Web.Controllers;

import com.pcific.pcificbackend.Exceptions.FillTheBlanksException;
import com.pcific.pcificbackend.Exceptions.MustBeGraterThanZero;
import com.pcific.pcificbackend.Exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({MustBeGraterThanZero.class})
    public ResponseEntity<CustomError> mustBeGraterThanZeroException(RuntimeException exception){
        log.info("Must be grater than zero exception occurred");
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(CustomError.builder()
                        .status(HttpStatus.CONFLICT.value())
                        .error(HttpStatus.CONFLICT.getReasonPhrase())
                        .message(exception.getMessage())
                        .timeStamp(LocalDateTime.now())
                        .build());
    }

    @ExceptionHandler({FillTheBlanksException.class})
    public ResponseEntity<CustomError> nameCannotBeEmptyException(RuntimeException exception){
        log.info("Name cannot be empty exception occurred");
        return ResponseEntity.status(HttpStatus.NOT_EXTENDED)
                .body(CustomError.builder()
                        .status(HttpStatus.NOT_EXTENDED.value())
                        .error(HttpStatus.NOT_EXTENDED.getReasonPhrase())
                        .message(exception.getMessage())
                        .timeStamp(LocalDateTime.now())
                        .build());
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<CustomError> notFoundException(RuntimeException exception){
        log.info("Not found exception occurred");
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(CustomError.builder()
                        .status(HttpStatus.NOT_FOUND.value())
                        .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                        .message(exception.getMessage())
                        .timeStamp(LocalDateTime.now())
                        .build());
    }
}
