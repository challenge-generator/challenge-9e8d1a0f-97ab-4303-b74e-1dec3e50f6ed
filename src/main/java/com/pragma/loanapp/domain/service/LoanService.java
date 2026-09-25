package com.pragma.loanapp.domain.service;


import com.pragma.loanapp.domain.model.ScoreRiesgo;
import com.pragma.loanapp.domain.model.Customer;
import com.pragma.loanapp.domain.model.Loan;
import java.math.BigDecimal;
import java.util.List;

public interface LoanService {
    BigDecimal calcularCuotaMensual(Loan loan);
    
    BigDecimal calcularTotalInteres(Loan loan);
    
    BigDecimal calcularPagoTotal(Loan loan);
    
    Customer.ScoreRiesgo evaluarRiesgo(Loan loan, Customer customer);
    
    boolean esPrestamoAprobado(Loan loan, Customer customer);
    
    List<String> validarPrestamo(Loan loan);
    
    BigDecimal calcularCapacidadPago(Customer customer);
    
    BigDecimal calcularRatioDeudaIngreso(Loan loan, Customer customer);
}