# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/pragma/loanapp/domain/service/impl/LoanServiceImpl.java` — `Loan.getAmount`: Se invoca `getAmount` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanapp/domain/service/impl/LoanServiceImpl.java` — `Loan.getTermMonths`: Se invoca `getTermMonths` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanapp/domain/service/impl/LoanServiceImpl.java` — `Loan.getInterestRate`: Se invoca `getInterestRate` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanapp/domain/service/impl/LoanServiceImpl.java` — `PersonalLoan.getCreditScore`: Se invoca `getCreditScore` sobre `PersonalLoan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanapp/domain/service/impl/LoanServiceImpl.java` — `Customer.getAnnualIncome`: Se invoca `getAnnualIncome` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanapp/application/LoanUseCase.java` — `LoanService.createLoan`: Se invoca `createLoan` sobre `LoanService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanapp/application/LoanUseCase.java` — `Loan.getAmount`: Se invoca `getAmount` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanapp/application/LoanUseCase.java` — `Loan.getInterestRate`: Se invoca `getInterestRate` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanapp/application/LoanUseCase.java` — `Loan.getTermMonths`: Se invoca `getTermMonths` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanapp/application/LoanUseCase.java` — `Loan.getLoanType`: Se invoca `getLoanType` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanapp/application/LoanUseCase.java` — `Loan.getStartDate`: Se invoca `getStartDate` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanapp/infrastructure/rest/controller/LoanController.java` — `RiskEvaluationException.getMessage`: Se invoca `getMessage` sobre `RiskEvaluationException`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanapp/infrastructure/rest/controller/LoanController.java` — `LoanUseCase.calculateMonthlyPayment`: Se invoca `calculateMonthlyPayment` sobre `LoanUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanapp/infrastructure/rest/controller/LoanController.java` — `LoanUseCase.getAllLoans`: Se invoca `getAllLoans` sobre `LoanUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Java, Advanced

### Brecha de conocimiento
Aplica los principios básicos de la programación orientada a objetos en el código (también conocida como OOP). Esto incluye los pilares de OOP, bucles, genéricos, anotaciones y más.

### Misión / candidato
Candidato Advanced con experiencia en Backend Java.

### Reto
- Tema: desarrollo de software con oop
- Seniority: advanced-l2
- Tipo: practical
- Título: Aplicación de conceptos OOP en un sistema de gestión de préstamos
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Modelado de clases para préstamos — objetivo: Crear las clases necesarias para representar diferentes tipos de préstamos y sus atributos. — entregable (NO resolver): Diagrama de clases y descripción de las mismas.
- Fase 2: Implementación de métodos para calcular cuotas — objetivo: Implementar métodos en las clases de préstamos para calcular las cuotas mensuales. — entregable (NO resolver): Código implementado y documentado para calcular cuotas mensuales.
- Fase 3: Evaluación de riesgo del préstamo — objetivo: Implementar un método para evaluar el riesgo del préstamo en base a la información del cliente y del préstamo. — entregable (NO resolver): Código implementado y documentado para evaluar el riesgo del préstamo.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.6</version>
        <relativePath/>
    </parent>

    <groupId>com.pragma</groupId>
    <artifactId>loanapp</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>loanapp</name>
    <description>Sistema de gestión de préstamos estudiantiles</description>

    <properties>
        <java.version>21</java.version>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
    </properties>

    <dependencies>
        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>

        <!-- Lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.34</version>
            <scope>provided</scope>
        </dependency>

        <!-- Testing -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <version>5.12.0</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/pragma/loanapp/LoanAppApplication.java ===
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

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  application:
    name: loanapp
  
  profiles:
    active: dev
  
server:
  port: 8080
  servlet:
    context-path: /api/loans

logging:
  level:
    root: INFO
    com.pragma.loanapp: DEBUG
    org.springframework.web: INFO
    org.hibernate: ERROR

management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics
  endpoint:
    health:
      show-details: always

loanapp:
  evaluation:
    risk-thresholds:
      high: 0.7
      medium: 0.4
  calculation:
    default-interest-rate: 0.05
    max-loan-amount: 1000000
    min-loan-term-months: 6
    max-loan-term-months: 120

// === ARCHIVO: src/main/java/com/pragma/loanapp/domain/model/Loan.java ===
package com.pragma.loanapp.domain.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public abstract class Loan {
    @NotNull(message = "El monto del préstamo no puede ser nulo")
    @DecimalMin(value = "0.01", message = "El monto del préstamo debe ser mayor que cero")
    private BigDecimal amount;

    @NotNull(message = "La tasa de interés no puede ser nula")
    @DecimalMin(value = "0.01", message = "La tasa de interés debe ser mayor que cero")
    private BigDecimal interestRate;

    @NotNull(message = "El plazo no puede ser nulo")
    @Min(value = 1, message = "El plazo debe ser al menos de 1 mes")
    private Integer termMonths;

    @NotBlank(message = "El tipo de préstamo no puede estar vacío")
    private String loanType;

    @NotNull(message = "La fecha de inicio no puede ser nula")
    private LocalDate startDate;

    protected Loan(BigDecimal amount, BigDecimal interestRate, Integer termMonths, String loanType, LocalDate startDate) {
        this.amount = amount;
        this.interestRate = interestRate;
        this.termMonths = termMonths;
        this.loanType = loanType;
        this.startDate = startDate;
        validateLoan();
    }

    private void validateLoan() {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto del préstamo debe ser positivo");
        }
        if (interestRate.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("La tasa de interés debe ser positiva");
        }
        if (termMonths <= 0) {
            throw new IllegalArgumentException("El plazo debe ser positivo");
        }
        if (startDate == null || startDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de inicio debe ser válida y no futura");
        }
    }

    public abstract BigDecimal calculateMonthlyPayment();

    public BigDecimal calculateTotalInterest() {
        BigDecimal monthlyPayment = calculateMonthlyPayment();
        BigDecimal totalPayment = monthlyPayment.multiply(BigDecimal.valueOf(termMonths));
        return totalPayment.subtract(amount);
    }

    public BigDecimal calculateTotalPayment() {
        return calculateMonthlyPayment().multiply(BigDecimal.valueOf(termMonths));
    }
}

// === ARCHIVO: src/main/java/com/pragma/loanapp/domain/model/MortgageLoan.java ===
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

// === ARCHIVO: src/main/java/com/pragma/loanapp/domain/model/PersonalLoan.java ===
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

// === ARCHIVO: src/main/java/com/pragma/loanapp/domain/model/StudentLoan.java ===
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

// === ARCHIVO: src/main/java/com/pragma/loanapp/domain/model/Customer.java ===
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

// === ARCHIVO: src/main/java/com/pragma/loanapp/domain/service/LoanService.java ===
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

// === ARCHIVO: src/main/java/com/pragma/loanapp/domain/exception/InvalidLoanException.java ===
package com.pragma.loanapp.domain.exception;

public class InvalidLoanException extends RuntimeException {
    private final String field;
    private final Object rejectedValue;
    private final String reason;

    public InvalidLoanException(String message) {
        super(message);
        this.field = null;
        this.rejectedValue = null;
        this.reason = null;
    }

    public InvalidLoanException(String message, Throwable cause) {
        super(message, cause);
        this.field = null;
        this.rejectedValue = null;
        this.reason = null;
    }

    public InvalidLoanException(String field, Object rejectedValue, String reason) {
        super(String.format("Campo '%s' con valor '%s' es inválido: %s", field, rejectedValue, reason));
        this.field = field;
        this.rejectedValue = rejectedValue;
        this.reason = reason;
    }

    public String getField() {
        return field;
    }

    public Object getRejectedValue() {
        return rejectedValue;
    }

    public String getReason() {
        return reason;
    }

    public static InvalidLoanException negativeInterestRate(BigDecimal rate) {
        return new InvalidLoanException("interestRate", rate, "La tasa de interés no puede ser negativa");
    }

    public static InvalidLoanException zeroOrNegativeAmount(BigDecimal amount) {
        return new InvalidLoanException("amount", amount, "El monto del préstamo debe ser mayor a cero");
    }

    public static InvalidLoanException invalidTermMonths(Integer term) {
        return new InvalidLoanException("termMonths", term, "El plazo en meses debe ser mayor a cero");
    }

    public static InvalidLoanException nullLoanType(String loanType) {
        return new InvalidLoanException("loanType", loanType, "El tipo de préstamo no puede ser nulo o vacío");
    }
}

// === ARCHIVO: src/main/java/com/pragma/loanapp/domain/exception/RiskEvaluationException.java ===
package com.pragma.loanapp.domain.exception;

public class RiskEvaluationException extends RuntimeException {
    private final String evaluationContext;
    private final String customerId;

    public RiskEvaluationException(String message) {
        super(message);
        this.evaluationContext = null;
        this.customerId = null;
    }

    public RiskEvaluationException(String message, Throwable cause) {
        super(message, cause);
        this.evaluationContext = null;
        this.customerId = null;
    }

    public RiskEvaluationException(String evaluationContext, String customerId, String message) {
        super(String.format("Error en evaluación de riesgo [%s] para cliente %s: %s", evaluationContext, customerId, message));
        this.evaluationContext = evaluationContext;
        this.customerId = customerId;
    }

    public String getEvaluationContext() {
        return evaluationContext;
    }

    public String getCustomerId() {
        return customerId;
    }

    public static RiskEvaluationException insufficientData(String customerId) {
        return new RiskEvaluationException("INSUFFICIENT_DATA", customerId, "Datos insuficientes para evaluar el riesgo");
    }

    public static RiskEvaluationException calculationError(String customerId, Throwable cause) {
        return new RiskEvaluationException("CALCULATION_ERROR", customerId, "Error al calcular el riesgo del préstamo", cause);
    }

    public static RiskEvaluationException invalidParameters(String customerId, String reason) {
        return new RiskEvaluationException("INVALID_PARAMETERS", customerId, reason);
    }
}

// === ARCHIVO: src/main/java/com/pragma/loanapp/domain/service/impl/LoanServiceImpl.java ===
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

// === ARCHIVO: src/main/java/com/pragma/loanapp/infrastructure/rest/dto/LoanRequest.java ===
package com.pragma.loanapp.infrastructure.rest.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LoanRequest {

    @NotNull(message = "El monto del préstamo es obligatorio")
    @Positive(message = "El monto debe ser mayor a cero")
    private BigDecimal amount;

    @NotNull(message = "La tasa de interés es obligatoria")
    @DecimalMin(value = "0.01", message = "La tasa de interés debe ser mayor a 0")
    @DecimalMax(value = "1.0", message = "La tasa de interés no puede exceder 100%")
    private BigDecimal interestRate;

    @NotNull(message = "El plazo en meses es obligatorio")
    @Min(value = 1, message = "El plazo mínimo es 1 mes")
    @Max(value = 360, message = "El plazo máximo es 360 meses")
    private Integer termMonths;

    @NotBlank(message = "El tipo de préstamo es obligatorio")
    private String loanType;

    @NotNull(message = "La fecha de inicio es obligatoria")
    @FutureOrPresent(message = "La fecha debe ser hoy o futura")
    private LocalDate startDate;

    private String collateral;
    private BigDecimal collateralValue;
    private String purpose;
    private Integer creditScore;

    public LoanRequest() {}

    public LoanRequest(BigDecimal amount, BigDecimal interestRate, Integer termMonths,
                       String loanType, LocalDate startDate, String collateral,
                       BigDecimal collateralValue, String purpose, Integer creditScore) {
        this.amount = amount;
        this.interestRate = interestRate;
        this.termMonths = termMonths;
        this.loanType = loanType;
        this.startDate = startDate;
        this.collateral = collateral;
        this.collateralValue = collateralValue;
        this.purpose = purpose;
        this.creditScore = creditScore;
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

    public String getCollateral() {
        return collateral;
    }

    public void setCollateral(String collateral) {
        this.collateral = collateral;
    }

    public BigDecimal getCollateralValue() {
        return collateralValue;
    }

    public void setCollateralValue(BigDecimal collateralValue) {
        this.collateralValue = collateralValue;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Integer getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }
}

// === ARCHIVO: src/main/java/com/pragma/loanapp/infrastructure/rest/dto/LoanResponse.java ===
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

// === ARCHIVO: src/main/java/com/pragma/loanapp/application/LoanUseCase.java ===
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

// === ARCHIVO: src/main/java/com/pragma/loanapp/infrastructure/rest/controller/LoanController.java ===
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

// === ARCHIVO: src/main/java/com/pragma/loanapp/infrastructure/config/GlobalExceptionHandler.java ===
package com.pragma.loanapp.infrastructure.config;

import com.pragma.loanapp.domain.exception.InvalidLoanException;
import com.pragma.loanapp.domain.exception.RiskEvaluationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Manejador global de excepciones para la aplicación.
 * Proporciona respuestas consistentes y apropiadas para diferentes tipos de errores.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja excepciones de validación de argumentos en requests.
     * Ocurre cuando los datos enviados no cumplen las validaciones de Jakarta.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(
            MethodArgumentNotValidException ex, WebRequest request) {
        
        Map<String, String> errors = ex.getBindingResult().getFieldErrors().stream()
            .collect(Collectors.toMap(
                FieldError::getField,
                error -> error.getDefaultMessage() != null 
                    ? error.getDefaultMessage() 
                    : "Valor no válido",
                (existing, replacement) -> existing
            ));

        String message = "Error de validación en los campos: " + String.join(", ", errors.keySet());
        
        ErrorResponse errorResponse = new ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            message,
            errors,
            LocalDateTime.now(),
            request.getDescription(false).replace("uri=", "")
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    /**
     * Maneja excepciones cuando un préstamo tiene datos inválidos.
     */
    @ExceptionHandler(InvalidLoanException.class)
    public ResponseEntity<ErrorResponse> handleInvalidLoanException(
            InvalidLoanException ex, WebRequest request) {
        
        Map<String, String> details = new HashMap<>();
        details.put("error", "Préstamo inválido");
        details.put("detalle", ex.getMessage());

        ErrorResponse errorResponse = new ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            ex.getMessage(),
            details,
            LocalDateTime.now(),
            request.getDescription(false).replace("uri=", "")
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    /**
     * Maneja excepciones cuando la evaluación de riesgo falla.
     */
    @ExceptionHandler(RiskEvaluationException.class)
    public ResponseEntity<ErrorResponse> handleRiskEvaluationException(
            RiskEvaluationException ex, WebRequest request) {
        
        Map<String, String> details = new HashMap<>();
        details.put("error", "Error en evaluación de riesgo");
        details.put("detalle", ex.getMessage());

        ErrorResponse errorResponse = new ErrorResponse(
            HttpStatus.UNPROCESSABLE_ENTITY.value(),
            "No se pudo evaluar el riesgo del préstamo",
            details,
            LocalDateTime.now(),
            request.getDescription(false).replace("uri=", "")
        );

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errorResponse);
    }

    /**
     * Maneja excepciones de argumentos ilegales en general.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(
            IllegalArgumentException ex, WebRequest request) {
        
        Map<String, String> details = new HashMap<>();
        details.put("error", "Argumento inválido");
        details.put("detalle", ex.getMessage());

        ErrorResponse errorResponse = new ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            ex.getMessage(),
            details,
            LocalDateTime.now(),
            request.getDescription(false).replace("uri=", "")
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    /**
     * Maneja excepciones genéricas no controladas.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(
            Exception ex, WebRequest request) {
        
        Map<String, String> details = new HashMap<>();
        details.put("error", "Error interno del servidor");
        details.put("detalle", ex.getMessage());

        ErrorResponse errorResponse = new ErrorResponse(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Ocurrió un error inesperado en el servidor",
            details,
            LocalDateTime.now(),
            request.getDescription(false).replace("uri=", "")
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    /**
     * Clase interna para representar respuestas de error estandarizadas.
     */
    public static class ErrorResponse {
        private int status;
        private String message;
        private Map<String, String> details;
        private LocalDateTime timestamp;
        private String path;

        public ErrorResponse(int status, String message, Map<String, String> details, 
                           LocalDateTime timestamp, String path) {
            this.status = status;
            this.message = message;
            this.details = details;
            this.timestamp = timestamp;
            this.path = path;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Map<String, String> getDetails() {
            return details;
        }

        public void setDetails(Map<String, String> details) {
            this.details = details;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    }
}
```
