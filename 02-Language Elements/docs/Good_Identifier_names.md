# Buenos y malos nombres de identificadores en Java

> **Importante:** Todos los identificadores de este documento son **válidos en Java**. La diferencia está en su **calidad**, **legibilidad** y **capacidad para expresar su propósito**.

## Comparativa de nombres

| ❌ Poco recomendable | ✅ Recomendado | Explicación |
|----------------------|---------------|-------------|
| `a` | `studentAge` | Un nombre descriptivo facilita entender qué almacena la variable. |
| `x` | `totalPrice` | Evita nombres genéricos que no aportan información. |
| `d` | `birthDate` | El nombre indica claramente el significado del dato. |
| `str` | `customerName` | El nombre debe describir el contenido, no el tipo de dato. |
| `num` | `invoiceNumber` | Es más específico que una abreviatura genérica. |
| `list` | `employeeList` | Indica qué contiene la colección. |
| `obj` | `currentCustomer` | Describe el objeto representado. |
| `tmp` | `formattedText` | Explica el propósito de la variable. |
| `flag` | `isLoggedIn` | Los booleanos deben responder a una pregunta. |
| `value` | `averageGrade` | Evita nombres demasiado genéricos. |
| `data` | `customerData` | Especifica qué datos almacena. |
| `result` | `finalScore` | Describe el resultado obtenido. |
| `calc()` | `calculateAverage()` | El método indica claramente la acción que realiza. |
| `proc()` | `processOrders()` | Utiliza un verbo descriptivo. |
| `get()` | `getCustomerName()` | Especifica qué devuelve el método. |
| `set()` | `setEmployeeSalary()` | Especifica qué modifica. |
| `check()` | `isValidEmail()` | El nombre expresa claramente la comprobación. |
| `run()` | `startApplication()` | Indica la finalidad del método. |
| `arr` | `studentGrades` | Describe el contenido del array. |
| `map` | `productPrices` | Indica qué información contiene el mapa. |

---

# Ejemplos de variables

## ❌ Poco recomendable

```java
int a;
double x;
String str;
boolean flag;
```

Aunque estos nombres son **válidos**, no ayudan a comprender el código.

## ✅ Recomendado

```java
int studentAge;
double totalPrice;
String customerName;
boolean isLoggedIn;
```

Con solo leer el nombre es posible entender el propósito de cada variable.

---

# Ejemplos de métodos

## ❌ Poco recomendable

```java
calc();
proc();
run();
check();
```

No queda claro qué hace cada método.

## ✅ Recomendado

```java
calculateAverage();
processOrders();
startApplication();
isValidEmail();
```

Los nombres utilizan un verbo y describen claramente la funcionalidad.

---

# Ejemplos de colecciones

## ❌ Poco recomendable

```java
list
map
items
data
```

## ✅ Recomendado

```java
employeeList
productPrices
shoppingCartItems
customerData
```

---

# Ejemplos de constantes

## ❌ Poco recomendable

```java
max
pi
port
```

## ✅ Recomendado

```java
MAX_STUDENTS
PI
DEFAULT_PORT
```

Las constantes deben escribirse en **UPPER_SNAKE_CASE**.

---

# Buenas prácticas

- Utiliza nombres que describan el propósito de la variable o del método.
- Evita abreviaturas poco conocidas.
- No utilices nombres de una sola letra, salvo en contadores de bucles (`i`, `j`, `k`).
- Los métodos deben comenzar con un verbo (`calculate`, `send`, `find`, `create`, `update`).
- Las variables booleanas deberían empezar por `is`, `has`, `can` o `should`.
- Las colecciones deberían utilizar nombres en plural (`students`, `employees`, `orders`).
- Las constantes deben escribirse en **UPPER_SNAKE_CASE**.

---

# Resumen

> Un identificador puede ser **válido en Java** y, aun así, ser un **mal nombre** desde el punto de vista de la calidad del código.

Un buen identificador:

- ✔️ Describe claramente su propósito.
- ✔️ Facilita la lectura del código.
- ✔️ Reduce la necesidad de comentarios.
- ✔️ Hace que el código sea más fácil de mantener.
- ✔️ Favorece el trabajo en equipo.