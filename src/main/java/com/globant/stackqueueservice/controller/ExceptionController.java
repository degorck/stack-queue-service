package com.globant.stackqueueservice.controller;

import com.globant.stackqueueservice.dto.ErrorDto;
import com.globant.stackqueueservice.exception.InvalidDataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

import static com.globant.stackqueueservice.utils.Constants.HANDLE_ERRORS;
import static com.globant.stackqueueservice.utils.Constants.INVALID_DATA;
import static com.globant.stackqueueservice.utils.Constants.VALIDATION_FAILED;

@SuppressWarnings({"unchecked", "rawtypes"})
@ControllerAdvice
@Slf4j
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest webRequest){
        List<String> details = new ArrayList<>();
        details.add(exception.getLocalizedMessage());
        ErrorDto errorDto = new ErrorDto(HANDLE_ERRORS, details);
        log.info("Solving Exception: {}", details);
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidDataException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(InvalidDataException invalidDataException, WebRequest webRequest){
        List<String> details = new ArrayList<>();
        details.add(invalidDataException.getLocalizedMessage());
        ErrorDto errorDto = new ErrorDto(INVALID_DATA, details);
        log.info("Solving InvalidDataException: {}", details);
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException methodArgumentNotValidException, HttpHeaders httpHeaders, HttpStatus httpStatus, WebRequest webRequest){
        List<String> details = new ArrayList<>();
        for(ObjectError error: methodArgumentNotValidException.getBindingResult().getAllErrors()){
            details.add(error.getDefaultMessage());
        }
        ErrorDto errorDto = new ErrorDto(VALIDATION_FAILED, details);
        log.info("Solving MethodArgumentNotValidException: {}", details);
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }
}
