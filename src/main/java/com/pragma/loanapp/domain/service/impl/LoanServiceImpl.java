package com.pragma.loanapp.domain.service.impl;

import com.pragma.loanapp.domain.exception.InvalidLoanException;
import com.pragma.loanapp.domain.exception.RiskEvaluationException;
import com.pragma.loanapp.domain.model.Customer;
import com.pragma.loanapp.domain.model.Loan;
import com.pragma.loanapp.domain.model.MortgageLoan;
import com.pragma.loanapp.domain.model.PersonalLoan;
import com.pragma.loanapp.domain.model.StudentLoan;
import com.pragma.loanapp.domain.service.LoanService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.EnumMap;
import java.util.Map;

public class LoanServiceImpl implements LoanService {

    private static final BigDecimal HIGH_RISK_THRESHOLD = new BigDecimal("50000");
    private static final BigDecimal MEDIUM_RISK_THRESHOLD = new BigDecimal("20000");
    private static final int LONG_TERM_MONTHS = 60;
    private static final BigDecimal BASE_INTEREST_RATE = new BigDecimal("0.01");

    private final Map<RiskLevel, BigDecimal> riskMultipliers;

    public LoanServiceImpl() {
        this.riskMultipliers = new EnumMap<>(RiskLevel.class);
        this.riskMultipliers.put(RiskLevel.ALTO, new BigDecimal("1.5"));
        this.riskMultipliers.put(RiskLevel.MEDIO, new BigDecimal("1.2"));
        this.riskMultipliers.put(RiskLevel.BAJO, new BigDecimal("1.0"));
    }

    @Override
    public BigDecimal calculateMonthlyPayment(Loan loan) {
        validateLoanParameters(loan);

        if (loan.getAmount() == null || loan.getTermMonths() == null) {
            throw InvalidLoanException.zeroOrNegativeAmount(loan.getAmount());
        }

        BigDecimal monthlyRate = loan.getInterestRate()
                .divide(BigDecimal.valueOf(12), 10, RoundingMode.HALF_UP);

        if (monthlyRate.compareTo(BigDecimal.ZERO) == 0) {
            return loan.getAmount()
                    .divide(BigDecimal.valueOf(loan.getTermMonths()), 2, RoundingMode.HALF_UP);
        }

        BigDecimal onePlusRatePowTerm = BigDecimal.ONE.add(monthlyRate)
                .pow(loan.getTermMonths());

        BigDecimal numerator = monthlyRate.multiply(onePlusRatePowTerm);
        BigDecimal denominator = onePlusRatePowTerm.subtract(BigDecimal.ONE);

        BigDecimal monthlyPayment = loan.getAmount()
                .multiply(numerator.divide(denominator, 10, RoundingMode.HALF_UP));

        return monthlyPayment.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public RiskLevel evaluateRisk(Loan loan, Customer customer) {
        if (loan == null || customer == null) {
            throw RiskEvaluationException.insufficientData(
                    customer != null ? customer.getId() : "UNKNOWN"
            );
        }

        try {
            int riskScore = calculateRiskScore(loan, customer);
            return determineRiskLevel(riskScore);
        } catch (Exception e) {
            throw RiskEvaluationException.calculationError(customer.getId(), e);
        }
    }

    @Override
    public BigDecimal calculateTotalPayment(Loan loan) {
        validateLoanParameters(loan);
        BigDecimal monthlyPayment = calculateMonthlyPayment(loan);
        return monthlyPayment.multiply(BigDecimal.valueOf(loan.getTermMonths()))
                .setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal calculateTotalInterest(Loan loan) {
        validateLoanParameters(loan);
        BigDecimal totalPayment = calculateTotalPayment(loan);
        return totalPayment.subtract(loan.getAmount())
                .setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public Loan createLoan(BigDecimal amount, BigDecimal interestRate, Integer termMonths, 
                          String loanType, Map<String, Object> additionalParams) {
        validateCreateLoanParams(amount, interestRate, termMonths, loanType);

        Loan loan = buildLoanByType(amount, interestRate, termMonths, loanType, additionalParams);
        loan.validateLoan();
        
        return loan;
    }

    @Override
    public BigDecimal calculateEffectiveRate(Loan loan, RiskLevel riskLevel) {
        validateLoanParameters(loan);
        
        BigDecimal baseRate = loan.getInterestRate();
        BigDecimal multiplier = riskMultipliers.getOrDefault(riskLevel, BigDecimal.ONE);
        
        return baseRate.multiply(multiplier).setScale(4, RoundingMode.HALF_UP);
    }

    private void validateLoanParameters(Loan loan) {
        if (loan == null) {
            throw new InvalidLoanException("El préstamo no puede ser nulo");
        }
        if (loan.getAmount() == null || loan.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw InvalidLoanException.zeroOrNegativeAmount(loan.getAmount());
        }
        if (loan.getInterestRate() == null || loan.getInterestRate().compareTo(BigDecimal.ZERO) < 0) {
            throw InvalidLoanException.negativeInterestRate(loan.getInterestRate());
        }
        if (loan.getTermMonths() == null || loan.getTermMonths() <= 0) {
            throw InvalidLoanException.invalidTermMonths(loan.getTermMonths());
        }
    }

    private void validateCreateLoanParams(BigDecimal amount, BigDecimal interestRate, 
                                         Integer termMonths, String loanType) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw InvalidLoanException.zeroOrNegativeAmount(amount);
        }
        if (interestRate == null || interestRate.compareTo(BigDecimal.ZERO) < 0) {
            throw InvalidLoanException.negativeInterestRate(interestRate);
        }
        if (termMonths == null || termMonths <= 0) {
            throw InvalidLoanException.invalidTermMonths(termMonths);
        }
        if (loanType == null || loanType.trim().isEmpty()) {
            throw InvalidLoanException.nullLoanType(loanType);
        }
    }

    private Loan buildLoanByType(BigDecimal amount, BigDecimal interestRate, Integer termMonths,
                                 String loanType, Map<String, Object> additionalParams) {
        LocalDate startDate = LocalDate.now();
        
        return switch (loanType.toUpperCase()) {
            case "MORTGAGE" -> {
                String collateral = additionalParams != null ? 
                        (String) additionalParams.getOrDefault("collateral", "") : "";
                BigDecimal collateralValue = additionalParams != null && 
                        additionalParams.get("collateralValue") != null ?
                        new BigDecimal(additionalParams.get("collateralValue").toString()) : 
                        BigDecimal.ZERO;
                yield new MortgageLoan(amount, interestRate, termMonths, loanType, 
                        startDate, collateral, collateralValue);
            }
            case "PERSONAL" -> {
                String purpose = additionalParams != null ? 
                        (String) additionalParams.getOrDefault("purpose", "") : "";
                Integer creditScore = additionalParams != null && 
                        additionalParams.get("creditScore") != null ?
                        Integer.parseInt(additionalParams.get("creditScore").toString()) : 0;
                yield new PersonalLoan(amount, interestRate, termMonths, loanType, 
                        startDate, purpose, creditScore);
            }
            case "STUDENT" -> {
                String institution = additionalParams != null ? 
                        (String) additionalParams.getOrDefault("institution", "") : "";
                String career = additionalParams != null ? 
                        (String) additionalParams.getOrDefault("career", "") : "";
                yield new StudentLoan(amount, interestRate, termMonths, loanType, 
                        startDate, institution, career);
            }
            default -> throw new InvalidLoanException("loanType", loanType, 
                    "Tipo de préstamo no soportado. Use MORTGAGE, PERSONAL o STUDENT");
        };
    }

    private int calculateRiskScore(Loan loan, Customer customer) {
        int score = 0;

        if (loan.getAmount().compareTo(HIGH_RISK_THRESHOLD) > 0) {
            score += 30;
        } else if (loan.getAmount().compareTo(MEDIUM_RISK_THRESHOLD) > 0) {
            score += 15;
        } else {
            score += 5;
        }

        if (loan.getTermMonths() > LONG_TERM_MONTHS) {
            score += 25;
        } else if (loan.getTermMonths() > 36) {
            score += 10;
        }

        if (loan instanceof MortgageLoan) {
            MortgageLoan mortgage = (MortgageLoan) loan;
            BigDecimal ltv = mortgage.calculateLoanToValueRatio();
            if (ltv.compareTo(new BigDecimal("0.8")) > 0) {
                score += 20;
            } else if (ltv.compareTo(new BigDecimal("0.6")) > 0) {
                score += 10;
            }
        } else if (loan instanceof PersonalLoan) {
            PersonalLoan personal = (PersonalLoan) loan;
            int creditScore = personal.getCreditScore();
            if (creditScore < 500) {
                score += 30;
            } else if (creditScore < 650) {
                score += 15;
            }
        } else if (loan instanceof StudentLoan) {
            score += 5;
        }

        BigDecimal totalPayment = calculateTotalPayment(loan);
        BigDecimal annualIncome = customer.getAnnualIncome();
        if (annualIncome != null && annualIncome.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal debtToIncome = totalPayment
                    .multiply(BigDecimal.valueOf(12))
                    .divide(annualIncome, 4, RoundingMode.HALF_UP);
            
            if (debtToIncome.compareTo(new BigDecimal("0.4")) > 0) {
                score += 25;
            } else if (debtToIncome.compareTo(new BigDecimal("0.3")) > 0) {
                score += 10;
            }
        }

        return score;
    }

    private RiskLevel determineRiskLevel(int riskScore) {
        if (riskScore >= 70) {
            return RiskLevel.ALTO;
        } else if (riskScore >= 40) {
            return RiskLevel.MEDIO;
        } else {
            return RiskLevel.BAJO;
        }
    }

    public enum RiskLevel {
        ALTO,
        MEDIO,
        BAJO
    }
}