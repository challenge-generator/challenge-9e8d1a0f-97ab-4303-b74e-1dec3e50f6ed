package com.pragma.loanapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.Clock;

@SpringBootApplication
public class LoanAppApplication {
    
    private final Clock clock;
    
    public LoanAppApplication() {
        this.clock = Clock.systemUTC();
    }
    
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
    @Bean
    public Clock clock() {
        return this.clock;
    }
    
    public static void main(String[] args) {
        var context = SpringApplication.run(LoanAppApplication.class, args);
        
        // Validación de arranque: verifica que el contexto se levantó correctamente
        if (context.containsBean("loanController")) {
            System.out.println("✅ Aplicación arrancada correctamente. Controlador de préstamos disponible.");
        } else {
            System.err.println("❌ Error: No se pudo inicializar el controlador de préstamos.");
            context.close();
            System.exit(1);
        }
    }
}