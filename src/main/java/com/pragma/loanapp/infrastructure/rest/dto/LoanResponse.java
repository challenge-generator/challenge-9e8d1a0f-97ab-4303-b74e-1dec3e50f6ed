package com.pragma.loanapp.infrastructure.rest.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LoanResponse {

    private BigDecimal amount;
    private BigDecimal interestRate;
    private Integer termMonths;
    private String loanType;
    private LocalDate startDate;
    private BigDecimal monthlyPayment;
    private BigDecimal totalPayment;
    private BigDecimal totalInterest;
    private String riskLevel;

    public LoanResponse() {}

    public LoanResponse(BigDecimal amount, BigDecimal interestRate, Integer termMonths,
                        String loanType, LocalDate startDate, BigDecimal monthlyPayment,
                        BigDecimal totalPayment, BigDecimal totalInterest, String riskLevel) {
        this.amount = amount;
        this.interestRate = interestRate;
        this.termMonths = termMonths;
        this.loanType = loanType;
        this.startDate = startDate;
        this.monthlyPayment = monthlyPayment;
        this.totalPayment = totalPayment;
        this.totalInterest = totalInterest;
        this.riskLevel = riskLevel;
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

    public BigDecimal getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(BigDecimal monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public BigDecimal getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(BigDecimal totalPayment) {
        this.totalPayment = totalPayment;
    }

    public BigDecimal getTotalInterest() {
        return totalInterest;
    }

    public void setTotalInterest(BigDecimal totalInterest) {
        this.totalInterest = totalInterest;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }
}