# Ejercicios: Literales enteros (`int` y `long`) en Java

## Ejercicio 1. Escribe el literal correcto

Escribe un literal que represente cada uno de los siguientes valores. Utiliza `int` cuando sea posible y `long` cuando sea necesario.

1. 42
2. 2025
3. 1.000.000
4. 2.147.483.647
5. 2.147.483.648
6. 5.000.000.000
7. -100
8. -2.147.483.648
9. -2.147.483.649
10. 9.223.372.036.854.775.807

---

## Ejercicio 2. Expresa el mismo valor de distintas formas

Escribe cada número utilizando:

- Decimal
- Hexadecimal
- Binario
- Octal

1. 15
2. 42
3. 64
4. 127
5. 255
6. 1024

---

## Ejercicio 3. ¿Qué tipo tiene el literal?

Indica si cada literal es de tipo `int`, `long` o produce un error de compilación.

```java
123
```

```java
123L
```

```java
123l
```

```java
2147483647
```

```java
2147483648
```

```java
2147483648L
```

```java
5000000000
```

```java
5000000000L
```

```java
0x7FFFFFFF
```

```java
0x80000000
```

```java
0x80000000L
```

```java
0b11111111111111111111111111111111
```

---

## Ejercicio 4. Indica el valor decimal

Convierte a decimal los siguientes literales.

```java
0xFF
```

```java
0x7FFFFFFF
```

```java
0x80000000L
```

```java
0b11111111
```

```java
0777
```

```java
0b10000000000000000000000000000000L
```

```java
0x1_0000_0000L
```

```java
01234567
```

---

## Ejercicio 5. ¿Compila?

Indica si el siguiente código compila. En caso contrario, explica brevemente el motivo.

```java
int a = 100;
```

```java
int a = 2147483647;
```

```java
int a = 2147483648;
```

```java
long a = 2147483648L;
```

```java
long a = 2147483648;
```

```java
long a = 5000000000L;
```

```java
long a = 5000000000;
```

```java
int a = 0xFFFFFFFF;
```

```java
long a = 0xFFFFFFFFL;
```

```java
long a = 0xFFFFFFFF;
```

---

## Ejercicio 6. ¿Es válido el literal?

Indica si cada literal es válido.

```java
123_
```

```java
_123
```

```java
1__23
```

```java
0x_FF
```

```java
0b_1010
```

```java
0xFF_FF
```

```java
0b1010_1010
```

```java
0_123
```

```java
500_000_000L
```

```java
5_000_000_000L
```

---

## Ejercicio 7. Corrige los errores

Modifica únicamente el literal para que el código compile.

```java
long a = 5000000000;
```

```java
int b = 2147483648;
```

```java
long c = 0x100000000;
```

```java
int d = 089;
```

```java
long e = 123_;
```

```java
long f = 0b10201;
```

```java
int g = 0xFG;
```

---

## Ejercicio 8. Completa la tabla

| Valor decimal | Literal `int` | Literal `long` |
|---------------|---------------|----------------|
| 100 | | |
| 1024 | | |
| 65535 | | |
| 2147483647 | | |
| 2147483648 | | |
| 5000000000 | | |
| 1000000000000 | | |

---

## Ejercicio 9. Identifica la base numérica

Indica en qué base está escrito cada literal.

```java
1234
```

```java
01234
```

```java
0x1234
```

```java
0b1010
```

```java
0xCAFEBABE
```

```java
0777
```

```java
0b1111000011110000L
```

---

## Ejercicio 10. Literales con separadores

Reescribe los siguientes literales utilizando separadores `_` para mejorar su legibilidad.

```java
1000000
```

```java
2147483647
```

```java
5000000000L
```

```java
1000000000000L
```

```java
0xFFFFFFFFL
```

```java
0b11111111111111111111111111111111
```

---

## Ejercicio 11. Mixto

Para cada literal indica:

- Si es válido.
- Su tipo (`int` o `long`).
- Su valor decimal.

```java
42
```

```java
42L
```

```java
0x2A
```

```java
0x2AL
```

```java
052
```

```java
0b101010
```

```java
2147483647
```

```java
2147483648L
```

```java
0x7FFFFFFF
```

```java
0x80000000L
```

```java
5000000000L
```

```java
0x1_0000_0000L
```

```java
077777777777L
```

---

## Ejercicio 12. Reto (nivel examen)

Indica para cada una de las siguientes asignaciones si compila y justifica la respuesta.

```java
int a = 100L;
```

```java
long b = 100;
```

```java
long c = 2147483648;
```

```java
long d = 2147483648L;
```

```java
int e = 0x7FFFFFFF;
```

```java
int f = 0x80000000;
```

```java
long g = 0x80000000;
```

```java
long h = 0x80000000L;
```

```java
long i = 9223372036854775807L;
```

```java
long j = 9223372036854775808L;
```

```java
long k = 0x7FFFFFFFFFFFFFFFL;
```

```java
long l = 0x8000000000000000L;
```