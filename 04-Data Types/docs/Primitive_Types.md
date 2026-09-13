# Tipos de datos primitivos en Java

Los **tipos de datos primitivos** son los tipos básicos que proporciona Java para almacenar valores simples. A diferencia de los objetos, los tipos primitivos almacenan directamente el valor en memoria.

## Tabla de tipos primitivos

| Tipo | Tamaño | Valor mínimo | Valor máximo | Valor por defecto* | Ejemplo |
|------|:------:|-------------:|-------------:|-------------------|---------|
| `byte` | 8 bits | -128 | 127 | `0` | `byte age = 18;` |
| `short` | 16 bits | -32.768 | 32.767 | `0` | `short year = 2025;` |
| `int` | 32 bits | -2.147.483.648 | 2.147.483.647 | `0` | `int population = 8500000;` |
| `long` | 64 bits | -2⁶³ | 2⁶³ - 1 | `0L` | `long distance = 384400000L;` |
| `float` | 32 bits | ±1.4E-45 | ±3.4028235E38 | `0.0f` | `float temperature = 21.5f;` |
| `double` | 64 bits | ±4.9E-324 | ±1.7976931348623157E308 | `0.0d` | `double pi = 3.141592653589793;` |
| `char` | 16 bits | `'\u0000'` | `'\uFFFF'` | `'\u0000'` | `char grade = 'A';` |
| `boolean` | Depende de la JVM** | `false` | `true` | `false` | `boolean isActive = true;` |

> **\*** El valor por defecto se aplica únicamente a los atributos (variables de instancia y de clase). Las variables locales deben inicializarse antes de utilizarse.

> **\*\*** La especificación de Java no define el tamaño en memoria del tipo `boolean`. Solo establece que puede almacenar los valores `true` y `false`.

---

# Clasificación de los tipos primitivos

## Tipos enteros

| Tipo | Tamaño |
|------|:------:|
| `byte` | 8 bits |
| `short` | 16 bits |
| `int` | 32 bits |
| `long` | 64 bits |

---

## Tipos de coma flotante

| Tipo | Tamaño |
|------|:------:|
| `float` | 32 bits |
| `double` | 64 bits |

---

## Tipo carácter

| Tipo | Tamaño | Codificación |
|------|:------:|-------------|
| `char` | 16 bits | Unicode (UTF-16) |

---

## Tipo lógico

| Tipo | Valores posibles |
|------|------------------|
| `boolean` | `true` o `false` |

---

# Recomendaciones

- Utiliza **`int`** para números enteros salvo que necesites un rango mayor o menor.
- Utiliza **`double`** para números decimales; es el tipo recomendado en la mayoría de los casos.
- Utiliza **`long`** cuando los valores puedan superar el rango de `int`.
- Utiliza **`char`** para almacenar un único carácter.
- Utiliza **`boolean`** para representar condiciones o estados lógicos.

## Ejemplo

```java
byte age = 18;
short year = 2025;
int students = 30;
long worldPopulation = 8100000000L;

float temperature = 23.5f;
double average = 8.75;

char grade = 'A';

boolean isApproved = true;
```