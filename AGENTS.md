# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Aplicación de conceptos OOP en un sistema de gestión de préstamos**.

| | |
|---|---|
| Tema | desarrollo de software con oop |
| Nivel | advanced-l2 |
| Chapter | Backend |
| Especialidad | Java |
| Stack | Java 21 / Spring Boot 3.5 |
| Patron arquitectonico | capas estándar (dominio, aplicación, infraestructura) |
| Tiempo estimado | 8 horas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz`
- `clase con @SpringBootApplication`
- `application.yml en src/main/resources`
- `capa de dominio con entidades y puertos`
- `capa de aplicacion con casos de uso`
- `capa de infraestructura con adaptadores y @RestController`

Trampas conocidas:

- TODA `<version>` del pom va con tres segmentos: la del parent (ej. `3.5.6`) y la de cada dependencia que la lleve (ej. Resilience4j `2.2.0`). `3.4` y `2.0` no existen como artefacto y el build muere resolviendo dependencias.
- Las dependencias que el parent POM gestiona van SIN `<version>`: `spring-boot-starter-web`, `-data-jpa`, `-validation`, `-test`, etc.
- Resilience4j publica un artefacto por linea de Spring Boot. Con Spring Boot 3 va `resilience4j-spring-boot3` con version de tres segmentos (ej. `2.2.0`, no `2.0`). `resilience4j-spring-boot2` es de Spring Boot 2 y rompe el arranque.
- Si usas anotaciones de validacion (`@NotNull`, `@Size`, `@Positive`) declara `spring-boot-starter-validation`: el starter web no las trae.
- El `spring-boot-maven-plugin` tiene que estar en `<build><plugins>` o no se empaqueta ejecutable.
- Spring Boot 3 usa `jakarta.*`, nunca `javax.*`.
- Cada archivo empieza con su `package` y con un `import` por cada clase del proyecto que viva en otro paquete. Usar `PaymentService` desde `infrastructure` sin `import com.x.application.PaymentService` no compila.

Dependencias:

- org.springframework.boot:spring-boot-starter-web n/a
- org.springframework.boot:spring-boot-starter-validation n/a
- org.projectlombok:lombok 1.18.34
- org.springframework.boot:spring-boot-starter-test n/a
- org.junit.jupiter:junit-jupiter-api n/a
- org.mockito:mockito-core 5.12.0

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Modelado de clases para préstamos**: Diagrama de clases y descripción de las mismas.
- **Fase 2 — Implementación de métodos para calcular cuotas**: Código implementado y documentado para calcular cuotas mensuales.
- **Fase 3 — Evaluación de riesgo del préstamo**: Código implementado y documentado para evaluar el riesgo del préstamo.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Lo que falta y tenes que completar

### 1. Referencias colgando (14)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/main/java/com/pragma/loanapp/domain/service/impl/LoanServiceImpl.java` — `Loan.getAmount`
      Se invoca `getAmount` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanapp/domain/service/impl/LoanServiceImpl.java` — `Loan.getTermMonths`
      Se invoca `getTermMonths` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanapp/domain/service/impl/LoanServiceImpl.java` — `Loan.getInterestRate`
      Se invoca `getInterestRate` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanapp/domain/service/impl/LoanServiceImpl.java` — `PersonalLoan.getCreditScore`
      Se invoca `getCreditScore` sobre `PersonalLoan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanapp/domain/service/impl/LoanServiceImpl.java` — `Customer.getAnnualIncome`
      Se invoca `getAnnualIncome` sobre `Customer`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanapp/application/LoanUseCase.java` — `LoanService.createLoan`
      Se invoca `createLoan` sobre `LoanService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanapp/application/LoanUseCase.java` — `Loan.getAmount`
      Se invoca `getAmount` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanapp/application/LoanUseCase.java` — `Loan.getInterestRate`
      Se invoca `getInterestRate` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanapp/application/LoanUseCase.java` — `Loan.getTermMonths`
      Se invoca `getTermMonths` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanapp/application/LoanUseCase.java` — `Loan.getLoanType`
      Se invoca `getLoanType` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanapp/application/LoanUseCase.java` — `Loan.getStartDate`
      Se invoca `getStartDate` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanapp/infrastructure/rest/controller/LoanController.java` — `RiskEvaluationException.getMessage`
      Se invoca `getMessage` sobre `RiskEvaluationException`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanapp/infrastructure/rest/controller/LoanController.java` — `LoanUseCase.calculateMonthlyPayment`
      Se invoca `calculateMonthlyPayment` sobre `LoanUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanapp/infrastructure/rest/controller/LoanController.java` — `LoanUseCase.getAllLoans`
      Se invoca `getAllLoans` sobre `LoanUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (17)

- `pom.xml`
- `src/main/java/com/pragma/loanapp/LoanAppApplication.java`
- `src/main/resources/application.yml`
- `src/main/java/com/pragma/loanapp/domain/model/Loan.java`
- `src/main/java/com/pragma/loanapp/domain/model/MortgageLoan.java`
- `src/main/java/com/pragma/loanapp/domain/model/PersonalLoan.java`
- `src/main/java/com/pragma/loanapp/domain/model/StudentLoan.java`
- `src/main/java/com/pragma/loanapp/domain/model/Customer.java`
- `src/main/java/com/pragma/loanapp/domain/service/LoanService.java`
- `src/main/java/com/pragma/loanapp/domain/exception/InvalidLoanException.java`
- `src/main/java/com/pragma/loanapp/domain/exception/RiskEvaluationException.java`
- `src/main/java/com/pragma/loanapp/domain/service/impl/LoanServiceImpl.java`
- `src/main/java/com/pragma/loanapp/infrastructure/rest/dto/LoanRequest.java`
- `src/main/java/com/pragma/loanapp/infrastructure/rest/dto/LoanResponse.java`
- `src/main/java/com/pragma/loanapp/application/LoanUseCase.java`
- `src/main/java/com/pragma/loanapp/infrastructure/rest/controller/LoanController.java`
- `src/main/java/com/pragma/loanapp/infrastructure/config/GlobalExceptionHandler.java`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/pragma/loanapp`
- `src/main/java/com/pragma/loanapp/domain/model`
- `src/main/java/com/pragma/loanapp/domain/service`
- `src/main/java/com/pragma/loanapp/domain/exception`
- `src/main/java/com/pragma/loanapp/application`
- `src/main/java/com/pragma/loanapp/infrastructure/rest/dto`
- `src/main/java/com/pragma/loanapp/infrastructure/rest/controller`
- `src/main/resources`

## Verificacion

```bash
mvn clean compile
```

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **capas estándar (dominio, aplicación, infraestructura)**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Backend, Especialidad Desarrollador, Tecnología Java, Advanced
- Brecha que el reto ataca: Aplica los principios básicos de la programación orientada a objetos en el código (también conocida como OOP). Esto incluye los pilares de OOP, bucles, genéricos, anotaciones y más.
- Mision: Candidato Advanced con experiencia en Backend Java.

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
