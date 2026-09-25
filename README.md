# Aplicación de conceptos OOP en un sistema de gestión de préstamos

En el contexto de un sistema de gestión de préstamos para una entidad financiera, debes aplicar los principios básicos de la programación orientada a objetos. El sistema gestiona préstamos de diferentes tipos (hipotecarios, personales, estudiantiles) y debe ser capaz de calcular cuotas, evaluar el riesgo del préstamo y gestionar la información del cliente. Los préstamos tienen atributos como monto, tasa de interés, plazo y tipo de préstamo. El sistema debe ser capaz de manejar diferentes tipos de préstamos y calcular las cuotas mensuales en función de estos atributos. Además, debe evaluar el riesgo del préstamo en base a la información del cliente y del préstamo.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | desarrollo de software con oop |
| **Nivel** | advanced-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Modelado de clases para préstamos

**Objetivo:** Crear las clases necesarias para representar diferentes tipos de préstamos y sus atributos.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Identificar los atributos comunes y específicos de los diferentes tipos de préstamos.
- Diseñar las clases para representar estos préstamos, incluyendo herencia y polimorfismo donde sea aplicable.
- Asegurar que las clases cumplan con los principios de encapsulación y abstracción.

**Entregable:** Diagrama de clases y descripción de las mismas.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo los diferentes tipos de préstamos pueden heredar de una clase base.
- Piensa en cómo puedes usar la abstracción para representar atributos comunes y específicos.

</details>

### Fase 2: Implementación de métodos para calcular cuotas

**Objetivo:** Implementar métodos en las clases de préstamos para calcular las cuotas mensuales.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Diseñar y implementar métodos para calcular las cuotas mensuales de los préstamos en función de sus atributos.
- Asegurar que los métodos sean idempotentes y robustos ante diferentes valores de entrada.
- Documentar los métodos y sus posibles modos de falla.

**Entregable:** Código implementado y documentado para calcular cuotas mensuales.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo puedes usar genéricos para hacer tus métodos más flexibles.
- Piensa en cómo puedes manejar diferentes modos de falla, como tasas de interés negativas o montos de préstamo inválidos.

</details>

### Fase 3: Evaluación de riesgo del préstamo

**Objetivo:** Implementar un método para evaluar el riesgo del préstamo en base a la información del cliente y del préstamo.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Diseñar y implementar un método para evaluar el riesgo del préstamo.
- Considerar factores como el historial crediticio del cliente, el monto del préstamo y la tasa de interés.
- Asegurar que el método sea robusto y documentar sus posibles modos de falla.

**Entregable:** Código implementado y documentado para evaluar el riesgo del préstamo.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo puedes usar anotaciones para documentar y validar la entrada del método.
- Piensa en cómo puedes manejar diferentes modos de falla, como información incompleta del cliente.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué son los principios básicos de la programación orientada a objetos y cómo se aplican en este reto?
- **paraQueSirve**: ¿Para qué sirve la herencia en el diseño de las clases de préstamos?
- **comoSeUsa**: ¿Cómo se implementan y usan los métodos para calcular cuotas y evaluar el riesgo del préstamo?
- **erroresComunes**: ¿Cuáles son los errores comunes que pueden ocurrir al implementar los métodos de cálculo de cuotas y evaluación de riesgo?
- **queDecisionesImplica**: ¿Qué decisiones de diseño implica la aplicación de los principios de OOP en este reto?

## Criterios de Evaluacion

- Aplicación correcta de los principios de OOP en el diseño de clases.
- Implementación robusta y documentada de métodos para calcular cuotas y evaluar el riesgo del préstamo.
- Manejo adecuado de errores comunes y modos de falla.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
