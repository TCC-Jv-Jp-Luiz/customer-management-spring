package br.edu.unipe.customer_management_spring.exceptionhandler;

import br.edu.unipe.customer_management_spring.errors.BusinessException;
import br.edu.unipe.customer_management_spring.errors.DuplicateResourceException;
import br.edu.unipe.customer_management_spring.errors.ResourceNotFoundException;
import br.edu.unipe.customer_management_spring.exceptionhandler.dto.ValidationErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponseDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {
        ValidationErrorResponseDTO validationErrorResponse = new ValidationErrorResponseDTO();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            String errorCode = "invalid_" + error.getField();

            String errorMessage = error.getDefaultMessage();
            validationErrorResponse.addError(errorCode, errorMessage);
        });

        return ResponseEntity.badRequest().body(validationErrorResponse);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ValidationErrorResponseDTO> handleInvalidBody(HttpMessageNotReadableException exception) {
        ValidationErrorResponseDTO validationErrorResponse = new ValidationErrorResponseDTO();
        validationErrorResponse.addError("invalid_action", "request body invalid");

        return ResponseEntity.badRequest().body(validationErrorResponse);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ValidationErrorResponseDTO> handleBusinessException(BusinessException businessException) {
        ValidationErrorResponseDTO validationErrorResponse = new ValidationErrorResponseDTO();
        validationErrorResponse.addError(businessException);

        return ResponseEntity.badRequest().body(validationErrorResponse);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public void handleResourceNotFoundException(ResourceNotFoundException exception) { }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public void handleException(Exception exception) {
        exception.printStackTrace();

        
    }

    @ExceptionHandler(DuplicateResourceException.class) 
    public ResponseEntity<ValidationErrorResponseDTO> handleDuplicateResourceException(DuplicateResourceException ex) {
        ValidationErrorResponseDTO validationErrorResponse = new ValidationErrorResponseDTO();
        validationErrorResponse.addError("duplicate_resource", ex.getMessage()); 
        return new ResponseEntity<>(validationErrorResponse, HttpStatus.CONFLICT); 
    }

}
