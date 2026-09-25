package com.pragma.loanapp.domain.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public abstract class Loan {
    @NotNull(message = "El monto del préstamo no puede ser nulo")
    @DecimalMin(value = "0.01", message = "El monto del préstamo debe ser mayor que cero")
    private BigDecimal amount;

    @NotNull(message = "La tasa de interés no puede ser nula")
    @DecimalMin(value = "0.01", message = "La tasa de interés debe ser mayor que cero")
    private BigDecimal interestRate;

    @NotNull(message = "El plazo no puede ser nulo")
    @Min(value = 1, message = "El plazo debe ser al menos de 1 mes")
    private Integer termMonths;

    @NotBlank(message = "El tipo de préstamo no puede estar vacío")
    private String loanType;

    @NotNull(message = "La fecha de inicio no puede ser nula")
    private LocalDate startDate;

    protected Loan(BigDecimal amount, BigDecimal interestRate, Integer termMonths, String loanType, LocalDate startDate) {
        this.amount = amount;
        this.interestRate = interestRate;
        this.termMonths = termMonths;
        this.loanType = loanType;
        this.startDate = startDate;
        validateLoan();
    }

    private void validateLoan() {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto del préstamo debe ser positivo");
        }
        if (interestRate.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("La tasa de interés debe ser positiva");
        }
        if (termMonths <= 0) {
            throw new IllegalArgumentException("El plazo debe ser positivo");
        }
        if (startDate == null || startDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de inicio debe ser válida y no futura");
        }
    }

    public abstract BigDecimal calculateMonthlyPayment();

    public BigDecimal calculateTotalInterest() {
        BigDecimal monthlyPayment = calculateMonthlyPayment();
        BigDecimal totalPayment = monthlyPayment.multiply(BigDecimal.valueOf(termMonths));
        return totalPayment.subtract(amount);
    }

    public BigDecimal calculateTotalPayment() {
        return calculateMonthlyPayment().multiply(BigDecimal.valueOf(termMonths));
    }
}