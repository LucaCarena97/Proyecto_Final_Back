package com.example.clinicaOdontologica.exception;

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
    public ResponseEntity<?> errores(Exception e, WebRequest req) {
        logger.error(e.getMessage());
        return new ResponseEntity("ERROR " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> notFoundException(ResourceNotFoundException ex) {
        logger.error(ex.getMessage());
        return new ResponseEntity<>("No se encontró el valor en la base de datos", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> badRequestException(BadRequestException ex) {
        logger.error(ex.getMessage());
        return new ResponseEntity<>("No hay datos para guardar o hay campos nulos",
                HttpStatus.BAD_REQUEST);
    }

    /*
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<String> serviceException(ServiceException ex) {
        logger.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
*/
}
