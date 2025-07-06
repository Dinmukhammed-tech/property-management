package io.proglib.mycompany.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> handleFieldValidation(MethodArgumentNotValidException manv) {
        List<ErrorModel> errorModelList = new ArrayList<>();
        ErrorModel errorModel = null;
        List<FieldError> fieldErrorList = manv.getBindingResult().getFieldErrors();

        for(FieldError fe : fieldErrorList) {
            logger.debug("Inside field validation:{} - {}",fe.getField(),fe.getDefaultMessage());
            logger.info("Inside field validation: {} - {}",fe.getField(),fe.getDefaultMessage());
            errorModel = new ErrorModel();
            errorModel.setCode(fe.getField());
            errorModel.setMessage(fe.getDefaultMessage());
            errorModelList.add(errorModel);
        }
        return new ResponseEntity<>(errorModelList, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handlerBusinessException(BusinessException bex){
        for(ErrorModel er : bex.getErrors()){
            logger.debug("BusinessException is thrown - level - debug:{} - {}",er.getCode(),er.getMessage());
            logger.info("BusinessException is thrown - level - info:{} - {}",er.getCode(),er.getMessage());
            logger.warn("BusinessException is thrown - level - warn:{} - {}",er.getCode(),er.getMessage());
            logger.error("BusinessException is thrown - level - error:{} - {}",er.getCode(),er.getMessage());
        }

        return new ResponseEntity<>(bex.getErrors(), HttpStatus.BAD_REQUEST);
    }
}
