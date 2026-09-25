package com.pragma.loanapp.domain.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
public class MortgageLoan extends Loan {
    @NotBlank(message = "La garantía no puede estar vacía")
    private String collateral;

    @NotNull(message = "El valor de la garantía no puede ser nulo")
    private BigDecimal collateralValue;

    public MortgageLoan(BigDecimal amount, BigDecimal interestRate, Integer termMonths, String loanType,
                       LocalDate startDate, String collateral, BigDecimal collateralValue) {
        super(amount, interestRate, termMonths, loanType, startDate);
        this.collateral = collateral;
        this.collateralValue = collateralValue;
        validateCollateral();
    }

    private void validateCollateral() {
        if (collateral == null || collateral.trim().isEmpty()) {
            throw new IllegalArgumentException("La garantía no puede estar vacía");
        }
        if (collateralValue == null || collateralValue.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El valor de la garantía debe ser positivo");
        }
        if (collateralValue.compareTo(getAmount()) < 0) {
            throw new IllegalArgumentException("El valor de la garantía debe ser al menos igual al monto del préstamo");
        }
    }

    @Override
    public BigDecimal calculateMonthlyPayment() {
        BigDecimal monthlyInterestRate = getInterestRate().divide(BigDecimal.valueOf(12), 10, BigDecimal.ROUND_HALF_UP);
        BigDecimal pow = BigDecimal.ONE.add(monthlyInterestRate).pow(getTermMonths());
        BigDecimal numerator = getAmount().multiply(monthlyInterestRate).multiply(pow);
        BigDecimal denominator = pow.subtract(BigDecimal.ONE);
        return numerator.divide(denominator, 2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal calculateLoanToValueRatio() {
        return getAmount().divide(collateralValue, 2, BigDecimal.ROUND_HALF_UP);
    }
}