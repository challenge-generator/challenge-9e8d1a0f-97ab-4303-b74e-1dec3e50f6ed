package com.pragma.loanapp.infrastructure.config;

import com.pragma.loanapp.domain.exception.InvalidLoanException;
import com.pragma.loanapp.domain.exception.RiskEvaluationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Manejador global de excepciones para la aplicación.
 * Proporciona respuestas consistentes y apropiadas para diferentes tipos de errores.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja excepciones de validación de argumentos en requests.
     * Ocurre cuando los datos enviados no cumplen las validaciones de Jakarta.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(
            MethodArgumentNotValidException ex, WebRequest request) {
        
        Map<String, String> errors = ex.getBindingResult().getFieldErrors().stream()
            .collect(Collectors.toMap(
                FieldError::getField,
                error -> error.getDefaultMessage() != null 
                    ? error.getDefaultMessage() 
                    : "Valor no válido",
                (existing, replacement) -> existing
            ));

        String message = "Error de validación en los campos: " + String.join(", ", errors.keySet());
        
        ErrorResponse errorResponse = new ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            message,
            errors,
            LocalDateTime.now(),
            request.getDescription(false).replace("uri=", "")
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    /**
     * Maneja excepciones cuando un préstamo tiene datos inválidos.
     */
    @ExceptionHandler(InvalidLoanException.class)
    public ResponseEntity<ErrorResponse> handleInvalidLoanException(
            InvalidLoanException ex, WebRequest request) {
        
        Map<String, String> details = new HashMap<>();
        details.put("error", "Préstamo inválido");
        details.put("detalle", ex.getMessage());

        ErrorResponse errorResponse = new ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            ex.getMessage(),
            details,
            LocalDateTime.now(),
            request.getDescription(false).replace("uri=", "")
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    /**
     * Maneja excepciones cuando la evaluación de riesgo falla.
     */
    @ExceptionHandler(RiskEvaluationException.class)
    public ResponseEntity<ErrorResponse> handleRiskEvaluationException(
            RiskEvaluationException ex, WebRequest request) {
        
        Map<String, String> details = new HashMap<>();
        details.put("error", "Error en evaluación de riesgo");
        details.put("detalle", ex.getMessage());

        ErrorResponse errorResponse = new ErrorResponse(
            HttpStatus.UNPROCESSABLE_ENTITY.value(),
            "No se pudo evaluar el riesgo del préstamo",
            details,
            LocalDateTime.now(),
            request.getDescription(false).replace("uri=", "")
        );

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errorResponse);
    }

    /**
     * Maneja excepciones de argumentos ilegales en general.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(
            IllegalArgumentException ex, WebRequest request) {
        
        Map<String, String> details = new HashMap<>();
        details.put("error", "Argumento inválido");
        details.put("detalle", ex.getMessage());

        ErrorResponse errorResponse = new ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            ex.getMessage(),
            details,
            LocalDateTime.now(),
            request.getDescription(false).replace("uri=", "")
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    /**
     * Maneja excepciones genéricas no controladas.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(
            Exception ex, WebRequest request) {
        
        Map<String, String> details = new HashMap<>();
        details.put("error", "Error interno del servidor");
        details.put("detalle", ex.getMessage());

        ErrorResponse errorResponse = new ErrorResponse(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Ocurrió un error inesperado en el servidor",
            details,
            LocalDateTime.now(),
            request.getDescription(false).replace("uri=", "")
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    /**
     * Clase interna para representar respuestas de error estandarizadas.
     */
    public static class ErrorResponse {
        private int status;
        private String message;
        private Map<String, String> details;
        private LocalDateTime timestamp;
        private String path;

        public ErrorResponse(int status, String message, Map<String, String> details, 
                           LocalDateTime timestamp, String path) {
            this.status = status;
            this.message = message;
            this.details = details;
            this.timestamp = timestamp;
            this.path = path;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Map<String, String> getDetails() {
            return details;
        }

        public void setDetails(Map<String, String> details) {
            this.details = details;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    }
}