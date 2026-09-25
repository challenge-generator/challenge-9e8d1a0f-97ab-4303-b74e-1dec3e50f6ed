package com.pragma.loanapp.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Customer {
    private String id;
    private String nombre;
    private String apellido;
    private String identificacion;
    private String correoElectronico;
    private String telefono;
    private Integer edad;
    private BigDecimal ingresoMensual;
    private BigDecimal ingresoFamiliar;
    private HistorialCrediticio historialCrediticio;
    private ScoreRiesgo scoreRiesgo;
    private List<Loan> prestamosActivos;
    private LocalDate fechaRegistro;
    private boolean verificado;

    public Customer(String nombre, String apellido, String identificacion, 
                    String correoElectronico, String telefono, Integer edad,
                    BigDecimal ingresoMensual) {
        this.id = UUID.randomUUID().toString();
        this.nombre = Objects.requireNonNull(nombre, "El nombre es obligatorio");
        this.apellido = Objects.requireNonNull(apellido, "El apellido es obligatorio");
        this.identificacion = Objects.requireNonNull(identificacion, "La identificación es obligatoria");
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.edad = edad;
        this.ingresoMensual = ingresoMensual != null ? ingresoMensual : BigDecimal.ZERO;
        this.ingresoFamiliar = BigDecimal.ZERO;
        this.historialCrediticio = HistorialCrediticio.SIN_HISTORIAL;
        this.scoreRiesgo = ScoreRiesgo.MEDIO;
        this.prestamosActivos = new ArrayList<>();
        this.fechaRegistro = LocalDate.now();
        this.verificado = false;
        validateCustomer();
    }

    private void validateCustomer() {
        if (edad != null && edad < 18) {
            throw new IllegalArgumentException("El cliente debe ser mayor de edad");
        }
        if (identificacion.length() < 5) {
            throw new IllegalArgumentException("La identificación debe tener al menos 5 caracteres");
        }
    }

    public boolean puedeObtenerPrestamo(Loan loan) {
        if (!verificado) {
            return false;
        }
        if (scoreRiesgo == ScoreRiesgo.ALTO) {
            return false;
        }
        BigDecimal cuotaMensual = loan.calculateMonthlyPayment();
        BigDecimal capacidadPago = ingresoMensual.multiply(new BigDecimal("0.40"));
        return cuotaMensual.compareTo(capacidadPago) <= 0;
    }

    public void agregarPrestamo(Loan loan) {
        if (loan == null) {
            throw new IllegalArgumentException("El préstamo no puede ser nulo");
        }
        prestamosActivos.add(loan);
    }

    public void removerPrestamo(Loan loan) {
        prestamosActivos.remove(loan);
    }

    public int getCantidadPrestamosActivos() {
        return prestamosActivos.size();
    }

    public BigDecimal getDeudaTotal() {
        return prestamosActivos.stream()
            .map(Loan::calculateTotalPayment)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void actualizarScoreRiesgo() {
        if (historialCrediticio == HistorialCrediticio.EXCELENTE && getCantidadPrestamosActivos() <= 2) {
            scoreRiesgo = ScoreRiesgo.BAJO;
        } else if (historialCrediticio == HistorialCrediticio.MALO || getCantidadPrestamosActivos() > 5) {
            scoreRiesgo = ScoreRiesgo.ALTO;
        } else if (historialCrediticio == HistorialCrediticio.REGULAR || getCantidadPrestamosActivos() > 3) {
            scoreRiesgo = ScoreRiesgo.MEDIO;
        } else {
            scoreRiesgo = ScoreRiesgo.BAJO;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public BigDecimal getIngresoMensual() {
        return ingresoMensual;
    }

    public void setIngresoMensual(BigDecimal ingresoMensual) {
        this.ingresoMensual = ingresoMensual;
    }

    public BigDecimal getIngresoFamiliar() {
        return ingresoFamiliar;
    }

    public void setIngresoFamiliar(BigDecimal ingresoFamiliar) {
        this.ingresoFamiliar = ingresoFamiliar;
    }

    public HistorialCrediticio getHistorialCrediticio() {
        return historialCrediticio;
    }

    public void setHistorialCrediticio(HistorialCrediticio historialCrediticio) {
        this.historialCrediticio = historialCrediticio;
    }

    public ScoreRiesgo getScoreRiesgo() {
        return scoreRiesgo;
    }

    public void setScoreRiesgo(ScoreRiesgo scoreRiesgo) {
        this.scoreRiesgo = scoreRiesgo;
    }

    public List<Loan> getPrestamosActivos() {
        return Collections.unmodifiableList(prestamosActivos);
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean isVerificado() {
        return verificado;
    }

    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }

    public enum HistorialCrediticio {
        SIN_HISTORIAL,
        EXCELENTE,
        BUENO,
        REGULAR,
        MALO
    }

    public enum ScoreRiesgo {
        BAJO,
        MEDIO,
        ALTO
    }
}