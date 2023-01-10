package dev.luanfernandes.cars.api.exceptions.handler;


import dev.luanfernandes.cars.api.exceptions.ConflictException;
import dev.luanfernandes.cars.api.exceptions.ConvertException;
import dev.luanfernandes.cars.api.exceptions.ExternalApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import javax.servlet.http.HttpServletRequest;
import java.rmi.ServerException;
import java.time.Instant;

@Slf4j
@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConvertException.class)
    public ResponseEntity<StandardError> convertException(HttpServletRequest req, ConvertException e) {
        return buildResponseEntity(new StandardError(
                Instant.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request:",
                e.getMessage(),
                req.getRequestURI()));
    }

    @ExceptionHandler(ExternalApiException.class)
    public ResponseEntity<StandardError> externalApiException(HttpServletRequest req, ExternalApiException e) {
        return buildResponseEntity(new StandardError(Instant.now(), HttpStatus.BAD_REQUEST.value(),
                "Bad request", e.getMessage(), req.getRequestURI()));
    }


    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<StandardError> conflictException(HttpServletRequest req, ConflictException e) {
        return buildResponseEntity(new StandardError(Instant.now(), HttpStatus.CONFLICT.value(),
                "Conflict", e.getMessage(), req.getRequestURI()));
    }

    @ExceptionHandler(ServerException.class)
    public ResponseEntity<StandardError> serverException(HttpServletRequest req, ServerException e) {
        return buildResponseEntity(new StandardError(Instant.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage(), req.getRequestURI()));
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<StandardError> nullPointerException(HttpServletRequest req, NullPointerException e) {
        return buildResponseEntity(new StandardError(Instant.now(), HttpStatus.BAD_REQUEST.value(),
                "Resource Null Pointer", e.getMessage(), req.getRequestURI()));
    }


    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity<StandardError> handleDataIntegrityViolation(DataIntegrityViolationException e, HttpServletRequest req) {
        if (e.getCause() == null) {
            return buildResponseEntity(new StandardError(Instant.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Unexpected error", e.getMessage(), req.getRequestURI()));
        }
        return buildResponseEntity(new StandardError(Instant.now(), HttpStatus.CONFLICT.value(),
                "Database error", e.getMessage(), req.getRequestURI()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> defaultErrorHandler(HttpServletRequest req, Exception e) {
        return buildResponseEntity(new StandardError(Instant.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Unexpected error", e.getMessage(), req.getRequestURI()));
    }

    private ResponseEntity<StandardError> buildResponseEntity(StandardError error) {
        log.error("{}",error);
        return ResponseEntity.status(HttpStatus.valueOf(error.getStatus())).body(error);
    }
}