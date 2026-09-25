package com.pragma.loanapp.domain.exception;

public class RiskEvaluationException extends RuntimeException {
    private final String evaluationContext;
    private final String customerId;

    public RiskEvaluationException(String message) {
        super(message);
        this.evaluationContext = null;
        this.customerId = null;
    }

    public RiskEvaluationException(String message, Throwable cause) {
        super(message, cause);
        this.evaluationContext = null;
        this.customerId = null;
    }

    public RiskEvaluationException(String evaluationContext, String customerId, String message) {
        super(String.format("Error en evaluación de riesgo [%s] para cliente %s: %s", evaluationContext, customerId, message));
        this.evaluationContext = evaluationContext;
        this.customerId = customerId;
    }

    public String getEvaluationContext() {
        return evaluationContext;
    }

    public String getCustomerId() {
        return customerId;
    }

    public static RiskEvaluationException insufficientData(String customerId) {
        return new RiskEvaluationException("INSUFFICIENT_DATA", customerId, "Datos insuficientes para evaluar el riesgo");
    }

    public static RiskEvaluationException calculationError(String customerId, Throwable cause) {
        return new RiskEvaluationException("CALCULATION_ERROR", customerId, "Error al calcular el riesgo del préstamo", cause);
    }

    public static RiskEvaluationException invalidParameters(String customerId, String reason) {
        return new RiskEvaluationException("INVALID_PARAMETERS", customerId, reason);
    }
}