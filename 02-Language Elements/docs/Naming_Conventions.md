# Convenciones de nomenclatura en programación

Las **convenciones de nomenclatura** (*Naming Conventions*) son un conjunto de reglas y recomendaciones utilizadas para asignar nombres a variables, métodos, clases, constantes y otros elementos del código.

Aunque un programa funcionará correctamente aunque no siga estas convenciones, utilizarlas mejora la **legibilidad**, el **mantenimiento** y el **trabajo en equipo**.

> **Importante**
>
> En Java existen convenciones ampliamente aceptadas (definidas por Oracle) que todos los desarrolladores deberían seguir.

---

# Principales convenciones de nomenclatura

| Convención | Ejemplo | Uso habitual | ¿Se utiliza en Java? |
|------------|---------|--------------|----------------------|
| **camelCase** | `firstName` | Variables y métodos | ✅ Sí |
| **PascalCase** | `StudentManager` | Clases, interfaces, enums y records | ✅ Sí |
| **UPPER_SNAKE_CASE** | `MAX_SIZE` | Constantes (`static final`) | ✅ Sí |
| **snake_case** | `first_name` | Python, SQL, bases de datos | ❌ No recomendado |
| **kebab-case** | `first-name` | URLs, archivos CSS | ❌ No válido como identificador |
| **SCREAMING-KEBAB-CASE** | `MAX-SIZE` | Documentación y configuración | ❌ No válido como identificador |
| **Train-Case** | `Student-Manager` | Títulos y documentación | ❌ No válido como identificador |

---

# camelCase

En **camelCase** la primera palabra comienza con minúscula y las siguientes empiezan con mayúscula.

## Ejemplos

```java
firstName
lastName
studentAge
totalPrice
accountBalance
```

### Uso en Java

Se utiliza para:

- Variables
- Métodos
- Parámetros
- Atributos

### Ejemplos

```java
String firstName;
double accountBalance;

calculateAverage();
sendEmail();
```

---

# PascalCase

En **PascalCase** todas las palabras comienzan con mayúscula.

## Ejemplos

```java
Student
BankAccount
InvoiceManager
CarRentalService
```

### Uso en Java

Se utiliza para:

- Clases
- Interfaces
- Enumeraciones (`enum`)
- Registros (`record`)

### Ejemplo

```java
public class StudentManager {

}
```

---

# UPPER_SNAKE_CASE

Todas las palabras se escriben en mayúsculas y separadas mediante guiones bajos.

## Ejemplos

```java
MAX_SIZE
DEFAULT_PORT
SECONDS_PER_MINUTE
PI
```

### Uso en Java

Se utiliza para las **constantes**, normalmente declaradas como:

```java
public static final
```

### Ejemplo

```java
public static final int MAX_STUDENTS = 30;
```

---

# snake_case

Todas las palabras están en minúsculas y separadas mediante guiones bajos.

## Ejemplos

```text
first_name
student_age
employee_salary
```

### Uso habitual

Muy frecuente en:

- Python
- SQL
- PostgreSQL
- MySQL

### ¿Se utiliza en Java?

No.

Aunque el compilador lo acepta, **no sigue las convenciones oficiales de Java**.

---

# kebab-case

Las palabras se separan mediante guiones.

## Ejemplos

```text
first-name
student-age
user-profile
```

### Uso habitual

- URLs
- Archivos CSS
- Sitios web

### En Java

No puede utilizarse porque el carácter `-` representa el operador de resta.

```java
first-name
```

❌ Identificador no válido.

---

# SCREAMING-KEBAB-CASE

Versión en mayúsculas de kebab-case.

## Ejemplo

```text
MAX-SIZE
DEFAULT-PORT
```

Se utiliza en algunos archivos de configuración y documentación.

En Java **no puede utilizarse**.

---

# Train-Case

Cada palabra comienza con mayúscula y se separa mediante guiones.

## Ejemplo

```text
Student-Manager
Bank-Account
```

Se utiliza en:

- Títulos
- Documentación
- Algunos frameworks

En Java no es un identificador válido.

---

# Comparativa visual

| Convención | Ejemplo |
|------------|---------|
| camelCase | `studentAge` |
| PascalCase | `StudentAge` |
| snake_case | `student_age` |
| UPPER_SNAKE_CASE | `STUDENT_AGE` |
| kebab-case | `student-age` |
| Train-Case | `Student-Age` |

---

# Convenciones recomendadas en Java

## Variables

Utiliza **camelCase**.

```java
String firstName;
double totalPrice;
boolean isLoggedIn;
```

---

## Métodos

También utilizan **camelCase** y normalmente comienzan por un verbo.

```java
calculateAverage();
sendEmail();
findStudent();
createInvoice();
updateCustomer();
```

---

## Clases

Utilizan **PascalCase**.

```java
Student
StudentManager
BankAccount
ShoppingCart
```

---

## Interfaces

También utilizan **PascalCase**.

```java
Serializable
Comparable
Runnable
```

---

## Enumeraciones

```java
DayOfWeek
OrderStatus
```

---

## Records

```java
Student
Employee
Product
```

---

## Constantes

Utilizan **UPPER_SNAKE_CASE**.

```java
MAX_STUDENTS
DEFAULT_PORT
SECONDS_PER_DAY
PI
```

---

## Paquetes

Los nombres de los paquetes se escriben completamente en minúsculas.

```java
com.company.project
es.instituto.programming
```

---

# Buenas prácticas

- Utiliza nombres descriptivos.
- Evita abreviaturas poco conocidas.
- No utilices nombres de una sola letra salvo en bucles (`i`, `j`, `k`).
- Los métodos deberían comenzar por un verbo.
- Los booleanos deberían empezar por:
    - `is`
    - `has`
    - `can`
    - `should`
- Las colecciones deberían escribirse en plural.

## Ejemplo

```java
students
employees
products
orders
```

---

# Errores frecuentes

## Variable poco descriptiva

```java
int a;
```

Mejor:

```java
int studentAge;
```

---

## Método poco descriptivo

```java
calc();
```

Mejor:

```java
calculateAverage();
```

---

## Colección mal nombrada

```java
list
```

Mejor:

```java
employeeList
```

---

## Booleano mal nombrado

```java
flag
```

Mejor:

```java
isLoggedIn
```

---

# Resumen

| Elemento | Convención recomendada |
|----------|------------------------|
| Variables | `camelCase` |
| Métodos | `camelCase` |
| Clases | `PascalCase` |
| Interfaces | `PascalCase` |
| Enums | `PascalCase` |
| Records | `PascalCase` |
| Constantes | `UPPER_SNAKE_CASE` |
| Paquetes | `lowercase` |

---

> **Recuerda**
>
> Un buen nombre no solo debe ser **válido**, sino también **descriptivo**. Elegir nombres claros mejora la legibilidad, facilita el mantenimiento del código y hace que otros desarrolladores comprendan el programa con mayor rapidez.