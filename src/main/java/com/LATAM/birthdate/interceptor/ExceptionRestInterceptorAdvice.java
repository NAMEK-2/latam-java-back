package com.LATAM.birthdate.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.LATAM.birthdate.dto.StandarResponseDto;
import com.LATAM.birthdate.exceptions.BusinessLogicException;
import com.LATAM.birthdate.helpers.MessageErrorHelper;

@ControllerAdvice
public class ExceptionRestInterceptorAdvice {

	private static Logger log = LoggerFactory.getLogger(ExceptionRestInterceptorAdvice.class);
	
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandarResponseDto> HttpMessageHandler() {
        String msg = "ERROR EN LOS PARÁMETROS ENVIADOS A LA API.";
        log.warn(msg);
        
        StandarResponseDto response = new StandarResponseDto();
		response.setStatus(false);
		response.setData(MessageErrorHelper.dataRequestInvalid(msg));
        
        return new ResponseEntity<>( response, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandarResponseDto> argumentsApi() {
        String msg = "ERROR EN LOS PARÁMETROS ENVIADOS A LA API.";
        log.warn(msg);
        
        StandarResponseDto response = new StandarResponseDto();
		response.setStatus(false);
		response.setData(MessageErrorHelper.dataRequestInvalid(msg));
        
        return new ResponseEntity<>( response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(BusinessLogicException.class)
    public ResponseEntity<StandarResponseDto> logicaNegocioHandler(BusinessLogicException ex) {
        log.warn("BUSINESS LOGIC EXCEPTION: ", ex);
        
        StandarResponseDto response = new StandarResponseDto();
		response.setStatus(false);
		response.setData(ex.getMessage());
		
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandarResponseDto> exceptionHandler(Exception ex) {
        log.error("ERROR INTERNO: ", ex.getMessage());
        ex.printStackTrace();
        
        StandarResponseDto response = new StandarResponseDto();
		response.setStatus(false);
		response.setData(MessageErrorHelper.internalError(ex));
        
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
