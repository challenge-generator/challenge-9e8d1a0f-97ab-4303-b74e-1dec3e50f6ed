package com.pragma.loanapp.infrastructure.rest.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LoanRequest {

    @NotNull(message = "El monto del préstamo es obligatorio")
    @Positive(message = "El monto debe ser mayor a cero")
    private BigDecimal amount;

    @NotNull(message = "La tasa de interés es obligatoria")
    @DecimalMin(value = "0.01", message = "La tasa de interés debe ser mayor a 0")
    @DecimalMax(value = "1.0", message = "La tasa de interés no puede exceder 100%")
    private BigDecimal interestRate;

    @NotNull(message = "El plazo en meses es obligatorio")
    @Min(value = 1, message = "El plazo mínimo es 1 mes")
    @Max(value = 360, message = "El plazo máximo es 360 meses")
    private Integer termMonths;

    @NotBlank(message = "El tipo de préstamo es obligatorio")
    private String loanType;

    @NotNull(message = "La fecha de inicio es obligatoria")
    @FutureOrPresent(message = "La fecha debe ser hoy o futura")
    private LocalDate startDate;

    private String collateral;
    private BigDecimal collateralValue;
    private String purpose;
    private Integer creditScore;

    public LoanRequest() {}

    public LoanRequest(BigDecimal amount, BigDecimal interestRate, Integer termMonths,
                       String loanType, LocalDate startDate, String collateral,
                       BigDecimal collateralValue, String purpose, Integer creditScore) {
        this.amount = amount;
        this.interestRate = interestRate;
        this.termMonths = termMonths;
        this.loanType = loanType;
        this.startDate = startDate;
        this.collateral = collateral;
        this.collateralValue = collateralValue;
        this.purpose = purpose;
        this.creditScore = creditScore;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public Integer getTermMonths() {
        return termMonths;
    }

    public void setTermMonths(Integer termMonths) {
        this.termMonths = termMonths;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getCollateral() {
        return collateral;
    }

    public void setCollateral(String collateral) {
        this.collateral = collateral;
    }

    public BigDecimal getCollateralValue() {
        return collateralValue;
    }

    public void setCollateralValue(BigDecimal collateralValue) {
        this.collateralValue = collateralValue;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Integer getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }
}