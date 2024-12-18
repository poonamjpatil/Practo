package com.practo.exception;

import com.practo.payload.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalException {

    //Patient Exception
    @ExceptionHandler(PatientException.class)
    public ResponseEntity<String> handledInvalidAgeException(PatientException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<String> handledDoctorNotFoundException(DoctorNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<String> handledPatientNotFoundException(PatientNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    //All Review Exception
    @ExceptionHandler(ReviewRatingsException.class)
    public ResponseEntity<ErrorResponse> handledInvalidRatingsException(ReviewRatingsException e) {
        ErrorResponse errorResponse = new ErrorResponse(
                e.getMessage(), HttpStatus.BAD_REQUEST.value(), new Date()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ReviewDescriptionException.class)
    public ResponseEntity<ErrorResponse> handledDescriptionException(ReviewDescriptionException e) {
        ErrorResponse errorResponse = new ErrorResponse(
                e.getMessage(), HttpStatus.BAD_REQUEST.value(), new Date()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }
}