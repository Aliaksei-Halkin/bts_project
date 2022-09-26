package com.bts.recruiting.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status,
            WebRequest request) {
        String error = "Malformed JSON request";
        System.out.println(ex.getMessage());
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException entityNotFoundException) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(entityNotFoundException.getLocalizedMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(JsonProcessingException.class)
    protected ResponseEntity<Object> jsonProcessing(JsonProcessingException jsonProcessingException) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage(jsonProcessingException.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(NoSuchElementException.class)
    protected ResponseEntity<Object> noSuchElementException(NoSuchElementException noSuchElementException) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage("Record was not found");
        System.out.println(noSuchElementException.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(Error.class)
    public ResponseEntity<Object> handle(Error ex) {
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(PSQLException.class)
    public ResponseEntity<Object> handle(PSQLException ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    /**
     * The {@link ConstraintViolationException} to be thrown at controllers when method parameters
     * invalid
     *
     * @param e the ConstraintViolationException
     * @return the Response entity with an error code and a message.
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiError> handleConstraintViolationException(
            ConstraintViolationException e) {
        String message = "not valid due to validation error: " + e.getMessage();
        ApiError errorHandler = new ApiError(message);
        return new ResponseEntity<>(errorHandler, HttpStatus.BAD_REQUEST);
    }

    /**
     * The {@link MethodArgumentNotValidException} to be thrown when validation on an argument
     * annotated with @Valid in the response body fails.
     *
     * @param ex the MethodArgumentNotValidException
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status,
            WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    /**
     * Exception thrown  when trying to set bean property with the wrong type.
     *
     * @param ex      MethodArgumentTypeMismatchException
     * @param request WebRequest
     * @return the Response entity with an error code and a message.
     */
    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(
            MethodArgumentTypeMismatchException ex, WebRequest request) {
        String error = ex.getName() + " should be of type " + ex.getRequiredType().getName()
                + ex.getLocalizedMessage();
        return new ResponseEntity<Object>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Exception thrown when a bean depends on other beans or simple properties that were not
     * specified in the bean factory definition, although dependency checking was enabled.
     *
     * @param exception - {@link UnsatisfiedDependencyException}
     * @return the Response entity with an error code and a message.
     */
    @ExceptionHandler(UnsatisfiedDependencyException.class)
    public ResponseEntity<Object> handleTypeError(UnsatisfiedDependencyException exception) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage(exception.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(BtsException.class)
    public ResponseEntity<Object> handleApiException(BtsException exception) {
        ApiError apiError = new ApiError(exception.getHttpStatus());
        apiError.setMessage(exception.getMessage());
        return buildResponseEntity(apiError);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

}
