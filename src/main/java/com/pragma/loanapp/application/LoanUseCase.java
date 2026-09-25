package com.pragma.loanapp.application;

import com.pragma.loanapp.domain.exception.InvalidLoanException;
import com.pragma.loanapp.domain.model.Loan;
import com.pragma.loanapp.domain.model.MortgageLoan;
import com.pragma.loanapp.domain.model.PersonalLoan;
import com.pragma.loanapp.domain.service.LoanService;
import com.pragma.loanapp.infrastructure.rest.dto.LoanRequest;
import com.pragma.loanapp.infrastructure.rest.dto.LoanResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class LoanUseCase {

    private final LoanService loanService;

    public LoanUseCase(LoanService loanService) {
        this.loanService = loanService;
    }

    public LoanResponse createLoan(LoanRequest request) {
        Loan loan = buildLoanFromRequest(request);
        loan.validateLoan();

        loanService.createLoan(loan);

        BigDecimal monthlyPayment = loan.calculateMonthlyPayment();
        BigDecimal totalPayment = loan.calculateTotalPayment();
        BigDecimal totalInterest = loan.calculateTotalInterest();

        String riskLevel = evaluateRisk(loan);

        return new LoanResponse(
            loan.getAmount(),
            loan.getInterestRate(),
            loan.getTermMonths(),
            loan.getLoanType(),
            loan.getStartDate(),
            monthlyPayment.setScale(2, RoundingMode.HALF_UP),
            totalPayment.setScale(2, RoundingMode.HALF_UP),
            totalInterest.setScale(2, RoundingMode.HALF_UP),
            riskLevel
        );
    }

    private Loan buildLoanFromRequest(LoanRequest request) {
        String loanType = request.getLoanType();

        if ("MORTGAGE".equalsIgnoreCase(loanType)) {
            return new MortgageLoan(
                request.getAmount(),
                request.getInterestRate(),
                request.getTermMonths(),
                request.getLoanType(),
                request.getStartDate(),
                request.getCollateral(),
                request.getCollateralValue()
            );
        } else if ("PERSONAL".equalsIgnoreCase(loanType)) {
            return new PersonalLoan(
                request.getAmount(),
                request.getInterestRate(),
                request.getTermMonths(),
                request.getLoanType(),
                request.getStartDate(),
                request.getPurpose(),
                request.getCreditScore()
            );
        } else {
            throw new InvalidLoanException("Tipo de préstamo no soportado: " + loanType);
        }
    }

    private String evaluateRisk(Loan loan) {
        if (loan instanceof MortgageLoan) {
            MortgageLoan mortgage = (MortgageLoan) loan;
            BigDecimal ltv = mortgage.calculateLoanToValueRatio();
            if (ltl.compareTo(new BigDecimal("0.80")) > 0) {
                return "ALTO";
            } else if (ltv.compareTo(new BigDecimal("0.60")) > 0) {
                return "MEDIO";
            }
            return "BAJO";
        } else if (loan instanceof PersonalLoan) {
            PersonalLoan personal = (PersonalLoan) loan;
            BigDecimal riskPremium = personal.calculateRiskPremium();
            if (riskPremium.compareTo(new BigDecimal("0.05")) > 0) {
                return "ALTO";
            } else if (riskPremium.compareTo(new BigDecimal("0.02")) > 0) {
                return "MEDIO";
            }
            return "BAJO";
        }
        return "MEDIO";
    }
}