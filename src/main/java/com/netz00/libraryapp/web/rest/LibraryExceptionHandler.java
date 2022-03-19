package com.netz00.libraryapp.web.rest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.netz00.libraryapp.exception.AuthorDoesNotExistsException;
import com.netz00.libraryapp.exception.BookDoesNotExistsException;
import com.netz00.libraryapp.exception.UserDoesNotExistsException;
import com.netz00.libraryapp.web.rest.dto.ApiError;
import org.hibernate.exception.DataException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.annotation.PostConstruct;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class LibraryExceptionHandler extends ResponseEntityExceptionHandler {

    private HttpHeaders headers;

    @PostConstruct
    public void init() {
        headers = new HttpHeaders();
        headers.add("X-API-Version", "v1");
    }


    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Malformed JSON request";


        status = HttpStatus.BAD_REQUEST;

        return new ResponseEntity<>(new ApiError(status, error, request, ex), this.headers, status);

    }


    @ExceptionHandler(UserDoesNotExistsException.class)
    public ResponseEntity<Object> handleUserDoesNotExistsException(Exception ex, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(new ApiError(status, request, ex), headers, status);
    }

    @ExceptionHandler(AuthorDoesNotExistsException.class)
    public ResponseEntity<Object> handleAuthorDoesNotExistsException(Exception ex, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(new ApiError(status, request, ex), headers, status);
    }

    @ExceptionHandler(BookDoesNotExistsException.class)
    public ResponseEntity<Object> handleBookDoesNotExistsException(Exception ex, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(new ApiError(status, request, ex), headers, status);
    }


    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<Object> handleNumberFormatException(Exception ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(new ApiError(status, request, ex), headers, status);
    }

    @ExceptionHandler(JsonMappingException.class)
    public ResponseEntity<Object> handleJsonMappingException(Exception ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(new ApiError(status, request, ex), headers, status);
    }

    @ExceptionHandler(JsonParseException.class)
    public ResponseEntity<Object> handleJsonParseException(Exception ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(new ApiError(status, request, ex), headers, status);
    }

    @ExceptionHandler(DataException.class)
    public ResponseEntity<Object> handleDataException(Exception ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(new ApiError(status, request, ex), headers, status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handle(Exception ex, WebRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(new ApiError(status, request, ex), headers, status);
    }
}
