# Ejercicios de Java: bucle `for`

**Ciclo:** 1.º DAW  
**Objetivo:** practicar el uso del bucle `for` en Java.  
**Restricciones:** no se permite utilizar arrays, colecciones ni otros tipos de estructuras de almacenamiento.

## Nivel 1. Ejercicios básicos

### Ejercicio 1. Contar del 1 al 10

Escribe un programa que muestre por pantalla los números del 1 al 10, ambos incluidos.

**Salida esperada:**
```text
1
2
3
4
5
6
7
8
9
10
```

### Ejercicio 2. Cuenta atrás

Escribe un programa que muestre los números del 10 al 1, en orden descendente. Al terminar, debe mostrar el mensaje `¡Despegue!`.

### Ejercicio 3. Números pares

Muestra todos los números pares comprendidos entre 2 y 20, ambos incluidos.

**Salida esperada:**
```text
2 4 6 8 10 12 14 16 18 20
```

### Ejercicio 4. Tabla de multiplicar

Solicita al usuario un número entero y muestra su tabla de multiplicar del 1 al 10.

**Ejemplo:** si el usuario introduce el número 7, el programa mostrará:

```text
7 x 1 = 7
7 x 2 = 14
7 x 3 = 21
...
7 x 10 = 70
```

### Ejercicio 5. Saltos de tres en tres

Muestra los números comprendidos entre 3 y 30, avanzando de tres en tres.

**Salida esperada:**
```text
3 6 9 12 15 18 21 24 27 30
```

## Nivel 2. Acumuladores y cálculos

### Ejercicio 6. Suma de los primeros N números

Solicita un número entero positivo `N` y calcula la suma de todos los números comprendidos entre 1 y `N`.

**Ejemplo:**

```text
Introduce un número: 5
La suma es: 15
```

El resultado se obtiene sumando `1 + 2 + 3 + 4 + 5`.

### Ejercicio 7. Suma de números pares

Solicita un número entero positivo `N` y calcula la suma de todos los números pares comprendidos entre 1 y `N`, ambos incluidos.

**Ejemplo:**

```text
Introduce un número: 10
La suma de los pares es: 30
```

### Ejercicio 8. Factorial

Solicita un número entero entre 0 y 10 y calcula su factorial.

El factorial de un número se obtiene multiplicando todos los enteros positivos menores o iguales que él. Por convenio, el factorial de 0 es 1.

**Ejemplo:**

```text
Introduce un número: 5
El factorial de 5 es 120
```

### Ejercicio 9. Potencia sin utilizar `Math.pow()`

Solicita dos números enteros: una base y un exponente no negativo. Calcula la potencia utilizando un bucle `for`, sin utilizar `Math.pow()`.

**Ejemplo:**

```text
Base: 3
Exponente: 4
Resultado: 81
```

### Ejercicio 10. Media aritmética

Solicita al usuario cuántos números va a introducir. Después, pide esos números uno a uno y calcula su media aritmética.

No se permite almacenar los números introducidos.

**Ejemplo:**

```text
¿Cuántos números vas a introducir? 4
Número 1: 5
Número 2: 7
Número 3: 8
Número 4: 4
La media es: 6.0
```

## Nivel 3. Bucles y condiciones

### Ejercicio 11. Contar múltiplos

Solicita dos números enteros positivos `A` y `B`, con `A` menor o igual que `B`.

Muestra todos los múltiplos de 5 comprendidos entre ambos números, incluidos los extremos si corresponde.

Al terminar, muestra cuántos múltiplos se han encontrado.

### Ejercicio 12. Contar positivos, negativos y ceros

Solicita al usuario cuántos números va a introducir. A continuación, lee esos números y cuenta cuántos son positivos, cuántos negativos y cuántos son iguales a cero.

Al terminar, muestra los tres contadores.

**Restricción:** no se pueden almacenar los números en arrays ni en otras estructuras.

### Ejercicio 13. Suma de cifras

Solicita un número entero positivo y calcula la suma de sus cifras.

**Ejemplo:**

```text
Introduce un número: 5832
La suma de sus cifras es: 18
```

*Pista:* puedes obtener la última cifra mediante el operador `%` y eliminarla mediante una división entera entre 10. Utiliza un bucle `for` sin escribir una condición de parada basada en `while`.

### Ejercicio 14. Números primos

Solicita un número entero mayor o igual que 2 e indica si es primo.

Un número primo es aquel que solamente tiene dos divisores positivos: 1 y él mismo.

**Ejemplos:**

```text
Introduce un número: 7
El número es primo.
```

```text
Introduce un número: 12
El número no es primo.
```

### Ejercicio 15. Aproximación de una suma

Solicita un número entero positivo `N` y calcula el valor de la siguiente suma:

\[
S = 1 + \frac{1}{2} + \frac{1}{3} + \cdots + \frac{1}{N}
\]

Muestra el resultado con cuatro decimales.

**Ejemplo:**

```text
Introduce N: 4
Resultado: 2.0833
```

Ten en cuenta que debes realizar divisiones reales, no divisiones enteras.

## Nivel 4. Dibujar patrones con bucles

### Ejercicio 16. Triángulo de asteriscos

Solicita un número entero positivo `N` y dibuja un triángulo de asteriscos con `N` filas.

**Ejemplo para N = 5:**

```text
*
**
***
****
*****
```

Debes utilizar dos bucles `for` anidados.

### Ejercicio 17. Triángulo invertido

Solicita un número entero positivo `N` y muestra un triángulo invertido de asteriscos.

**Ejemplo para N = 5:**

```text
*****
****
***
**
*
```

### Ejercicio 18. Cuadrado hueco

Solicita un número entero `N` mayor o igual que 2 y dibuja un cuadrado de lado `N` utilizando asteriscos. El interior debe quedar vacío.

**Ejemplo para N = 5:**

```text
*****
*   *
*   *
*   *
*****
```

Utiliza dos bucles `for` anidados y condiciones para decidir cuándo imprimir un asterisco y cuándo imprimir un espacio.

### Ejercicio 19. Tabla de multiplicar completa

Muestra las tablas de multiplicar del 1 al 10. Cada tabla debe contener los productos del número correspondiente por los números del 1 al 10.

**Requisito:** utiliza dos bucles `for` anidados.

### Ejercicio 20. Pirámide numérica

Solicita un número entero positivo `N` y muestra una pirámide en la que cada fila contenga los números desde 1 hasta el número de fila.

**Ejemplo para N = 5:**

```text
1
12
123
1234
12345
```

Utiliza dos bucles `for` anidados.

## Indicaciones generales

- Utiliza nombres de variables descriptivos.
- Declara las variables en el ámbito más reducido posible.
- Inicializa correctamente los acumuladores y contadores.
- No utilices arrays, listas ni colecciones.
- No sustituyas el bucle `for` por un bucle `while` o `do-while`.
- Comprueba los resultados con varios valores de entrada.
- En los ejercicios que lo requieran, valida que los datos introducidos sean correctos.
