package com.pragma.loanapp.domain.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
public class PersonalLoan extends Loan {
    @NotBlank(message = "La finalidad del préstamo no puede estar vacía")
    private String purpose;

    @NotNull(message = "El puntaje crediticio no puede ser nulo")
    private Integer creditScore;

    public PersonalLoan(BigDecimal amount, BigDecimal interestRate, Integer termMonths, String loanType,
                       LocalDate startDate, String purpose, Integer creditScore) {
        super(amount, interestRate, termMonths, loanType, startDate);
        this.purpose = purpose;
        this.creditScore = creditScore;
        validatePurposeAndCreditScore();
    }

    private void validatePurposeAndCreditScore() {
        if (purpose == null || purpose.trim().isEmpty()) {
            throw new IllegalArgumentException("La finalidad del préstamo no puede estar vacía");
        }
        if (creditScore == null || creditScore < 300 || creditScore > 850) {
            throw new IllegalArgumentException("El puntaje crediticio debe estar entre 300 y 850");
        }
    }

    @Override
    public BigDecimal calculateMonthlyPayment() {
        BigDecimal monthlyInterestRate = getInterestRate().divide(BigDecimal.valueOf(12), 10, BigDecimal.ROUND_HALF_UP);
        BigDecimal pow = BigDecimal.ONE.add(monthlyInterestRate).pow(getTermMonths());
        BigDecimal numerator = getAmount().multiply(monthlyInterestRate).multiply(pow);
        BigDecimal denominator = pow.subtract(BigDecimal.ONE);
        BigDecimal monthlyPayment = numerator.divide(denominator, 2, BigDecimal.ROUND_HALF_UP);
        
        // Ajuste por puntaje crediticio: mayor puntaje reduce la cuota en un porcentaje
        BigDecimal creditScoreAdjustment = calculateCreditScoreAdjustment();
        return monthlyPayment.multiply(creditScoreAdjustment).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    private BigDecimal calculateCreditScoreAdjustment() {
        if (creditScore >= 750) {
            return BigDecimal.valueOf(0.95); // 5% de descuento por excelente puntaje
        } else if (creditScore >= 650) {
            return BigDecimal.valueOf(0.98); // 2% de descuento por buen puntaje
        } else {
            return BigDecimal.ONE; // Sin ajuste
        }
    }

    public BigDecimal calculateRiskPremium() {
        if (creditScore >= 750) {
            return getInterestRate().multiply(BigDecimal.valueOf(0.9)); // 10% menos de interés
        } else if (creditScore >= 650) {
            return getInterestRate(); // Interés normal
        } else {
            return getInterestRate().multiply(BigDecimal.valueOf(1.1)); // 10% más de interés
        }
    }
}