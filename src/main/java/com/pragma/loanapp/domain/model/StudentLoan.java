package com.pragma.loanapp.domain.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class StudentLoan extends Loan {
    private String institucionEducativa;
    private String carrera;
    private Integer anoCarrera;
    private boolean tieneBeca;
    private BigDecimal ingresoFamiliar;
    private static final BigDecimal TASA_ESTUDIANTIL_BASE = new BigDecimal("0.05");
    private static final BigDecimal DESCUELTO_BECA = new BigDecimal("0.02");

    public StudentLoan(BigDecimal amount, BigDecimal interestRate, Integer termMonths, 
                       String loanType, LocalDate startDate, String institucionEducativa,
                       String carrera, Integer anoCarrera, boolean tieneBeca, 
                       BigDecimal ingresoFamiliar) {
        super(amount, interestRate, termMonths, loanType, startDate);
        this.institucionEducativa = institucionEducativa;
        this.carrera = carrera;
        this.anoCarrera = anoCarrera;
        this.tieneBeca = tieneBeca;
        this.ingresoFamiliar = ingresoFamiliar != null ? ingresoFamiliar : BigDecimal.ZERO;
        validateStudentLoan();
    }

    private void validateStudentLoan() {
        if (institucionEducativa == null || institucionEducativa.isBlank()) {
            throw new IllegalArgumentException("La institución educativa es obligatoria para préstamos estudiantiles");
        }
        if (anoCarrera != null && (anoCarrera < 1 || anoCarrera > 10)) {
            throw new IllegalArgumentException("El año de carrera debe estar entre 1 y 10");
        }
    }

    @Override
    public BigDecimal calculateMonthlyPayment() {
        BigDecimal tasaInteres = getInterestRate();
        if (tieneBeca) {
            tasaInteres = tasaInteres.subtract(DESCUELTO_BECA);
        }
        if (tasaInteres.compareTo(BigDecimal.ZERO) <= 0) {
            tasaInteres = TASA_ESTUDIANTIL_BASE;
        }
        
        BigDecimal principal = getAmount();
        Integer meses = getTermMonths();
        
        if (meses == null || meses <= 0) {
            throw new IllegalStateException("El plazo en meses debe ser mayor a cero");
        }
        
        BigDecimal tasaMensual = tasaInteres.divide(BigDecimal.valueOf(12), 10, RoundingMode.HALF_UP);
        BigDecimal factor = BigDecimal.ONE.add(tasaMensual).pow(meses);
        BigDecimal numerador = principal.multiply(tasaMensual).multiply(factor);
        BigDecimal denominador = factor.subtract(BigDecimal.ONE);
        
        return numerador.divide(denominador, 2, RoundingMode.HALF_UP);
    }

    public BigDecimal calculateDiscountForBeca() {
        if (!tieneBeca) {
            return BigDecimal.ZERO;
        }
        BigDecimal cuotaNormal = calculateMonthlyPayment();
        BigDecimal tasaConBeca = getInterestRate().subtract(DESCUELTO_BECA);
        if (tasaConBeca.compareTo(BigDecimal.ZERO) <= 0) {
            tasaConBeca = TASA_ESTUDIANTIL_BASE;
        }
        
        BigDecimal tasaMensual = tasaConBeca.divide(BigDecimal.valueOf(12), 10, RoundingMode.HALF_UP);
        BigDecimal factor = BigDecimal.ONE.add(tasaMensual).pow(getTermMonths());
        BigDecimal numerador = getAmount().multiply(tasaMensual).multiply(factor);
        BigDecimal denominador = factor.subtract(BigDecimal.ONE);
        BigDecimal cuotaConBeca = numerador.divide(denominador, 2, RoundingMode.HALF_UP);
        
        return cuotaNormal.subtract(cuotaConBeca);
    }

    public String getInstitucionEducativa() {
        return institucionEducativa;
    }

    public void setInstitucionEducativa(String institucionEducativa) {
        this.institucionEducativa = institucionEducativa;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Integer getAnoCarrera() {
        return anoCarrera;
    }

    public void setAnoCarrera(Integer anoCarrera) {
        this.anoCarrera = anoCarrera;
    }

    public boolean isTieneBeca() {
        return tieneBeca;
    }

    public void setTieneBeca(boolean tieneBeca) {
        this.tieneBeca = tieneBeca;
    }

    public BigDecimal getIngresoFamiliar() {
        return ingresoFamiliar;
    }

    public void setIngresoFamiliar(BigDecimal ingresoFamiliar) {
        this.ingresoFamiliar = ingresoFamiliar;
    }

    public BigDecimal getTasaConBeca() {
        BigDecimal tasa = getInterestRate();
        if (tieneBeca) {
            tasa = tasa.subtract(DESCUELTO_BECA);
        }
        return tasa.compareTo(BigDecimal.ZERO) <= 0 ? TASA_ESTUDIANTIL_BASE : tasa;
    }
}