package com.pragma.loanapp.domain.exception;

public class InvalidLoanException extends RuntimeException {
    private final String field;
    private final Object rejectedValue;
    private final String reason;

    public InvalidLoanException(String message) {
        super(message);
        this.field = null;
        this.rejectedValue = null;
        this.reason = null;
    }

    public InvalidLoanException(String message, Throwable cause) {
        super(message, cause);
        this.field = null;
        this.rejectedValue = null;
        this.reason = null;
    }

    public InvalidLoanException(String field, Object rejectedValue, String reason) {
        super(String.format("Campo '%s' con valor '%s' es inválido: %s", field, rejectedValue, reason));
        this.field = field;
        this.rejectedValue = rejectedValue;
        this.reason = reason;
    }

    public String getField() {
        return field;
    }

    public Object getRejectedValue() {
        return rejectedValue;
    }

    public String getReason() {
        return reason;
    }

    public static InvalidLoanException negativeInterestRate(BigDecimal rate) {
        return new InvalidLoanException("interestRate", rate, "La tasa de interés no puede ser negativa");
    }

    public static InvalidLoanException zeroOrNegativeAmount(BigDecimal amount) {
        return new InvalidLoanException("amount", amount, "El monto del préstamo debe ser mayor a cero");
    }

    public static InvalidLoanException invalidTermMonths(Integer term) {
        return new InvalidLoanException("termMonths", term, "El plazo en meses debe ser mayor a cero");
    }

    public static InvalidLoanException nullLoanType(String loanType) {
        return new InvalidLoanException("loanType", loanType, "El tipo de préstamo no puede ser nulo o vacío");
    }
}