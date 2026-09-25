package com.pragma.loanapp.infrastructure.rest.controller;

import com.pragma.loanapp.application.LoanUseCase;
import com.pragma.loanapp.domain.exception.InvalidLoanException;
import com.pragma.loanapp.domain.exception.RiskEvaluationException;
import com.pragma.loanapp.infrastructure.rest.dto.LoanRequest;
import com.pragma.loanapp.infrastructure.rest.dto.LoanResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

/**
 * Controlador REST que expone los endpoints para la gestión de préstamos.
 * Proporciona operaciones para crear préstamos y calcular cuotas mensuales.
 */
@RestController
@RequestMapping("/api/v1/loans")
public class LoanController {

    private final LoanUseCase loanUseCase;

    public LoanController(LoanUseCase loanUseCase) {
        this.loanUseCase = loanUseCase;
    }

    /**
     * Crea un nuevo préstamo en el sistema.
     * Valida los datos del préstamo y calcula la cuota mensual inicial.
     *
     * @param request Datos del préstamo a crear
     * @return Respuesta con los datos del préstamo creado incluyendo la cuota mensual
     */
    @PostMapping
    public ResponseEntity<LoanResponse> createLoan(@Valid @RequestBody LoanRequest request) {
        try {
            LoanResponse response = loanUseCase.createLoan(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (InvalidLoanException e) {
            throw new RuntimeException("Error al crear el préstamo: " + e.getMessage(), e);
        } catch (RiskEvaluationException e) {
            throw new RuntimeException("Error en evaluación de riesgo: " + e.getMessage(), e);
        }
    }

    /**
     * Calcula la cuota mensual para un préstamo sin persistente.
     * Útil para simulações antes de crear el préstamo formalmente.
     *
     * @param amount Monto del préstamo
     * @param interestRate Tasa de interés anual
     * @param termMonths Plazo en meses
     * @param loanType Tipo de préstamo (PERSONAL, MORTGAGE, STUDENT)
     * @return Cuota mensual calculada
     */
    @GetMapping("/calculate")
    public ResponseEntity<BigDecimal> calculateMonthlyPayment(
            @RequestParam BigDecimal amount,
            @RequestParam BigDecimal interestRate,
            @RequestParam Integer termMonths,
            @RequestParam String loanType) {
        
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto del préstamo debe ser mayor a cero");
        }
        if (interestRate == null || interestRate.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("La tasa de interés debe ser mayor a cero");
        }
        if (termMonths == null || termMonths <= 0) {
            throw new IllegalArgumentException("El plazo debe ser mayor a cero");
        }
        if (loanType == null || loanType.isBlank()) {
            throw new IllegalArgumentException("El tipo de préstamo es requerido");
        }

        try {
            BigDecimal monthlyPayment = loanUseCase.calculateMonthlyPayment(
                amount, interestRate, termMonths, loanType
            );
            return ResponseEntity.ok(monthlyPayment);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo de préstamo no válido: " + loanType);
        }
    }

    /**
     * Obtiene todos los préstamos registrados en el sistema.
     *
     * @return Lista de préstamos existentes
     */
    @GetMapping
    public ResponseEntity<List<LoanResponse>> getAllLoans() {
        List<LoanResponse> loans = loanUseCase.getAllLoans();
        return ResponseEntity.ok(loans);
    }

    /**
     * Evalúa el riesgo de un préstamo potencial sin crearlo.
     *
     * @param request Datos del préstamo a evaluar
     * @return Nivel de riesgo evaluado
     */
    @PostMapping("/evaluate-risk")
    public ResponseEntity<String> evaluateRisk(@Valid @RequestBody LoanRequest request) {
        try {
            String riskLevel = loanUseCase.evaluateRisk(request);
            return ResponseEntity.ok(riskLevel);
        } catch (RiskEvaluationException e) {
            throw new RuntimeException("Error al evaluar el riesgo: " + e.getMessage(), e);
        }
    }
}