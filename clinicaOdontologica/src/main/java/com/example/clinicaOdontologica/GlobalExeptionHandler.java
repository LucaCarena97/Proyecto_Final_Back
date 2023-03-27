package com.example.clinicaOdontologica;

import org.apache.log4j.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExeptionHandler {

    private static final Logger logger = Logger.getLogger(GlobalExeptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> errores(Exception e, WebRequest req){
        logger.error(e.getMessage());
        return new ResponseEntity("ERROR " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
