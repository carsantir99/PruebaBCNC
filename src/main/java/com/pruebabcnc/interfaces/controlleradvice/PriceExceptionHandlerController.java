package com.pruebabcnc.interfaces.controlleradvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.pruebabcnc.exceptions.DateParserException;
import com.pruebabcnc.exceptions.NotFoundException;
import com.pruebabcnc.utils.ExceptionHandlerConstants;

@RestControllerAdvice
public class PriceExceptionHandlerController {

    @ExceptionHandler(DateParserException.class)
    public ResponseEntity<Map<String, Object>> handleDateParserException(DateParserException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put(ExceptionHandlerConstants.ERROR, ExceptionHandlerConstants.ERROR_TYPE_BAD_REQUEST);
        response.put(ExceptionHandlerConstants.MESSAGE, ex.getMessage());
        response.put(ExceptionHandlerConstants.TIMESTAMP, LocalDateTime.now());
        response.put(ExceptionHandlerConstants.STATUS, HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.badRequest().body(response);
    }
    
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFoundException(NotFoundException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put(ExceptionHandlerConstants.ERROR, ExceptionHandlerConstants.ERROR_TYPE_NOT_FOUND);
        response.put(ExceptionHandlerConstants.MESSAGE, ex.getMessage());
        response.put(ExceptionHandlerConstants.TIMESTAMP, LocalDateTime.now());
        response.put(ExceptionHandlerConstants.STATUS, HttpStatus.NOT_FOUND.value());

        return ResponseEntity.badRequest().body(response);
    }
    
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Map<String, Object>> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put(ExceptionHandlerConstants.ERROR, ExceptionHandlerConstants.ERROR_TYPE_BAD_REQUEST);
        response.put(ExceptionHandlerConstants.MESSAGE, "Required request parameter: '"+ex.getParameterName()+"' not provided.");
        response.put(ExceptionHandlerConstants.TIMESTAMP, LocalDateTime.now());
        response.put("status", HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.badRequest().body(response);
    }
    
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, Object>> handleTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put(ExceptionHandlerConstants.ERROR, ExceptionHandlerConstants.ERROR_TYPE_BAD_REQUEST);
        response.put(ExceptionHandlerConstants.MESSAGE, "The parameter: '"+ex.getPropertyName()+"' has an incorrect type.");
        response.put(ExceptionHandlerConstants.TIMESTAMP, LocalDateTime.now());
        response.put(ExceptionHandlerConstants.STATUS, HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.badRequest().body(response);
    }
}
