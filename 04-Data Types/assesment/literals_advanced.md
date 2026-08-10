# Examen de Programación

## 1.º DAW

### Examen avanzado – Literales en Java

**Nombre:** _______________________________________

**Fecha:** ____ / ____ / ______

**Duración:** 90 minutos

**Puntuación:** 10 puntos

> **Objetivo:** Este examen evalúa el conocimiento profundo de los literales de Java, incluyendo reglas léxicas, inferencia de tipos, promoción numérica, Unicode, IEEE 754 y peculiaridades del compilador.

---

# Ejercicio 1. ¿Compila? ¿Qué tipo tiene? (2 puntos)

Para cada una de las siguientes declaraciones indica:

- Si compila o no.
- En caso afirmativo, cuál es el tipo del literal.
- En caso negativo, explica exactamente por qué.

---

### a)

```java
var x = 1;
```

---

### b)

```java
var x = 1L;
```

---

### c)

```java
var x = 1.;
```

---

### d)

```java
var x = .5;
```

---

### e)

```java
var x = 1e2;
```

---

### f)

```java
var x = 1e2F;
```

---

### g)

```java
var x = 0x1p4;
```

---

### h)

```java
var x = 0x1.8p2;
```

---

# Ejercicio 2. Literales hexadecimales en coma flotante (1 punto)

Calcula el valor decimal de los siguientes literales.

a)

```java
0x1p3
```

---

b)

```java
0x2p4
```

---

c)

```java
0x1.8p2
```

---

d)

```java
0x1.0p-2
```

---

e)

```java
0xAp0
```

---

# Ejercicio 3. Separadores '_' (2 puntos)

Indica cuáles son válidos.

Justifica cada respuesta.

```java
1_2_3
```

```java
_123
```

```java
123_
```

```java
0_xFF
```

```java
0x_FF
```

```java
0xF_F
```

```java
0b1010_0101
```

```java
0b_1010
```

```java
1__2
```

```java
1_.5
```

```java
1._5
```

```java
1.5_0
```

---

# Ejercicio 4. Unicode (1 punto)

Sin ejecutar el programa indica qué imprimirá.

---

### a)

```java
System.out.println('\u0041');
```

---

### b)

```java
System.out.println('\101');
```

---

### c)

```java
System.out.println("\u0041");
```

---

### d)

```java
char c = '\u000A';
System.out.println("Hola");
```

¿Compila?

Explica el motivo.

---

### e)

```java
char c = 'ñ';
```

¿Cuál es el valor Unicode del carácter?

---

# Ejercicio 5. Inferencia del compilador (1,5 puntos)

Indica el tipo inferido por `var`.

---

```java
var a = 0;
```

---

```java
var b = 0L;
```

---

```java
var c = 0F;
```

---

```java
var d = 0D;
```

---

```java
var e = 'A';
```

---

```java
var f = "A";
```

---

```java
var g = true;
```

---

```java
var h = null;
```

---

# Ejercicio 6. Literales y promoción de tipos (1,5 puntos)

Indica si compila y explica el motivo.

---

### a)

```java
byte b = 127;
```

---

### b)

```java
byte b = 128;
```

---

### c)

```java
short s = 32767;
```

---

### d)

```java
short s = 32768;
```

---

### e)

```java
char c = 65535;
```

---

### f)

```java
char c = 65536;
```

---

### g)

```java
long l = 2147483648;
```

---

### h)

```java
long l = 2147483648L;
```

---

# Ejercicio 7. IEEE 754 (1 punto)

Indica cuáles de los siguientes literales representan exactamente el valor decimal indicado.

---

### a)

```java
0.5
```

---

### b)

```java
0.1
```

---

### c)

```java
0.25F
```

---

### d)

```java
0.2F
```

---

### e)

```java
1.0 / 0.0
```

¿Qué valor produce?

---

### f)

```java
0.0 / 0.0
```

¿Qué valor produce?

---

# Ejercicio 8. Preguntas trampa (Bonus +2)

---

### a)

¿Qué imprime?

```java
System.out.println(012);
System.out.println(0x12);
System.out.println(0b12);
```

---

### b)

¿Qué imprime?

```java
System.out.println('A' + 1);
```

---

### c)

¿Qué imprime?

```java
System.out.println('A' + "1");
```

---

### d)

¿Qué imprime?

```java
System.out.println("A" + '1');
```

---

### e)

¿Qué imprime?

```java
System.out.println(1 + 2 + "3");
```

---

### f)

¿Qué imprime?

```java
System.out.println("1" + 2 + 3);
```

---

### g)

¿Cuál es el tipo del literal?

```java
9223372036854775807L
```

---

### h)

¿Existe algún literal que represente un `byte`?

Justifica tu respuesta utilizando las reglas del lenguaje Java.

---

# Pregunta de excelencia (sin puntuación)

¿Por qué Java decidió que **todos los literales enteros decimales** fueran inicialmente de tipo `int`, incluso cuando posteriormente puedan asignarse a un `byte`, `short`, `char` o `long`?

Razona la respuesta desde el punto de vista del diseño del lenguaje y del compilador.

---

# Puntuación

| Ejercicio | Puntos |
|-----------|:------:|
| 1 | 2 |
| 2 | 1 |
| 3 | 2 |
| 4 | 1 |
| 5 | 1,5 |
| 6 | 1,5 |
| 7 | 1 |
| **Total** | **10** |
| Bonus | +2 |