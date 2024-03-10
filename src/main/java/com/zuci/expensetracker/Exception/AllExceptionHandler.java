package com.zuci.expensetracker.Exception;

import com.zuci.expensetracker.Model.ApiError;
import jakarta.persistence.PersistenceException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.List;


@RestControllerAdvice
@Configuration
public class AllExceptionHandler {

    @ExceptionHandler({IdNotFoundException.class})
    public ResponseEntity<String> idNotFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not exits");
    }
    @ExceptionHandler({NullException.class})
    public ResponseEntity<String> nullException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Null in input");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationExceptions(MethodArgumentNotValidException ex, HttpServletRequest request) {
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        StringBuilder sb = new StringBuilder();
        for (FieldError fieldError : fieldErrors) {
            sb.append(fieldError.getField()).append(":").append(fieldError.getDefaultMessage()).append(";");
        }
        ApiError apiError = ApiError.builder()
                .Path(request.getRequestURI())
                .message(sb.toString())
                .date(new Date())
                .build();
        return ResponseEntity.badRequest().body(apiError);
    }

    @ExceptionHandler(PersistenceException.class)
    public ResponseEntity<ApiError> handlePersistenceException(PersistenceException ex, HttpServletRequest request) {

        ApiError apiError = ApiError.builder()
                .Path(request.getRequestURI())
                .message("Database constraint violation: " + ex.getMessage())
                .date(new Date())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }

    //@ExceptionHandler(ConstraintViolationException.class)
//    public ResponseEntity<ApiError> handleConstraintViolationExceptions(ConstraintViolationException ex, HttpServletRequest request) {
//        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
//        StringBuilder sb = new StringBuilder();
//        for (ConstraintViolation<?> violation : violations) {
//            sb.append(violation.getPropertyPath().toString()).append(":").append(violation.getMessage()).append(";");
//        }
//        ApiError apiError = ApiError.builder()
//                .Path(request.getRequestURI())
//                .message(sb.toString())
//                .date(new Date())
//                .build();
//        return ResponseEntity.badRequest().body(apiError);
//    }

}





