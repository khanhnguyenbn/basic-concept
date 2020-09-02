package com.example.baseconcept.exception;

import com.example.baseconcept.payload.ApiDefaultResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class ExceptionHandler {


    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity handleUserNotFoundException(final Exception ex) {
        String errorMessage = "Error " + ex.toString() + " at " +  ex.getStackTrace().toString() ;

        return new ResponseEntity<>(new ApiDefaultResponse(false, errorMessage, null), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ResponseBody
    public ApiDefaultResponse exception(StudentNotFoundException exception) {
        return new ApiDefaultResponse(false, exception.getMessage(), null);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(HttpClientErrorException.BadRequest.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiDefaultResponse handleBadRequestException(HttpClientErrorException.BadRequest exception) {
        return new ApiDefaultResponse(false, exception.getMessage(), null, null);
    }
}
