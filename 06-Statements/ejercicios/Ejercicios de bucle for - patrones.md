# Ejercicios de patrones con bucles `for` en Java

## Indicaciones generales

Resuelve los siguientes ejercicios utilizando exclusivamente:

- Variables de tipos primitivos.
- Bucles `for`.
- Condicionales `if`, `else if` y `else`.
- Operadores aritméticos, relacionales y lógicos.
- Instrucciones `IO.print()` y `IO.println()`.

**No se permite utilizar arrays, matrices, colecciones ni métodos propios.**

En los ejercicios que lo necesiten, puedes solicitar al usuario el tamaño de la figura mediante `IO.readln()`.

---

# 1. Patrones básicos

### Ejercicio 1. Cuadrado de asteriscos

Solicita un número entero que represente el tamaño de un cuadrado y dibújalo utilizando asteriscos.

Ejemplo para un tamaño de 5:

    *****
    *****
    *****
    *****
    *****

### Ejercicio 2. Rectángulo de asteriscos

Solicita al usuario la altura y la anchura de un rectángulo y dibújalo utilizando asteriscos.

Ejemplo para una altura de 3 y una anchura de 7:

    *******
    *******
    *******

### Ejercicio 3. Triángulo creciente

Solicita un número entero y dibuja un triángulo rectángulo creciente.

Ejemplo para un tamaño de 5:

    *
    **
    ***
    ****
    *****

### Ejercicio 4. Triángulo decreciente

Solicita un número entero y dibuja un triángulo rectángulo decreciente.

Ejemplo para un tamaño de 5:

    *****
    ****
    ***
    **
    *

### Ejercicio 5. Triángulo alineado a la derecha

Solicita un número entero y dibuja un triángulo rectángulo alineado a la derecha.

Ejemplo para un tamaño de 5:

        *
       **
      ***
     ****
    *****

### Ejercicio 6. Triángulo numérico

Solicita un número entero y dibuja un triángulo en el que cada fila contiene tantos números como indica su posición.

Ejemplo para un tamaño de 5:

    1
    12
    123
    1234
    12345

---

# 2. Figuras geométricas

### Ejercicio 7. Pirámide de asteriscos

Solicita un número entero que represente la altura de una pirámide y dibújala utilizando asteriscos.

Ejemplo para una altura de 5:

        *
       ***
      *****
     *******
    *********

### Ejercicio 8. Pirámide invertida

Solicita un número entero y dibuja una pirámide invertida.

Ejemplo para una altura de 5:

    *********
     *******
      *****
       ***
        *

### Ejercicio 9. Rombo relleno

Solicita un número impar y dibuja un rombo relleno de asteriscos.

Ejemplo para un tamaño de 7:

       *
      ***
     *****
    *******
     *****
      ***
       *

### Ejercicio 10. Reloj de arena

Solicita un número impar y dibuja una figura con forma de reloj de arena.

Ejemplo para un tamaño de 7:

    *******
     *****
      ***
       *
      ***
     *****
    *******

### Ejercicio 11. Cuadrado hueco

Solicita un número entero y dibuja un cuadrado en el que solamente se representen los bordes.

Ejemplo para un tamaño de 6:

    ******
    *    *
    *    *
    *    *
    *    *
    ******

### Ejercicio 12. Triángulo hueco

Solicita un número entero y dibuja un triángulo en el que solamente se representen los bordes.

Ejemplo para un tamaño de 5:

    *
    **
    * *
    *  *
    *****

### Ejercicio 13. Rombo hueco

Solicita un número impar y dibuja un rombo en el que solamente se representen los bordes.

Ejemplo para un tamaño de 7:

       *
      * *
     *   *
    *     *
     *   *
      * *
       *

---

# 3. Patrones numéricos

### Ejercicio 14. Pirámide numérica

Solicita un número entero y dibuja una pirámide en la que cada fila contiene números consecutivos desde el 1.

Ejemplo para una altura de 5:

        1
       123
      12345
     1234567
    123456789

### Ejercicio 15. Tabla de multiplicar

Solicita un número entero y muestra su tabla de multiplicar del 1 al 10 utilizando un bucle `for`.

Ejemplo para el número 7:

    7 x 1 = 7
    7 x 2 = 14
    7 x 3 = 21
    7 x 4 = 28
    7 x 5 = 35
    7 x 6 = 42
    7 x 7 = 49
    7 x 8 = 56
    7 x 9 = 63
    7 x 10 = 70

### Ejercicio 16. Triángulo de números repetidos

Solicita un número entero y dibuja un triángulo en el que cada fila repite el número correspondiente a su posición.

Ejemplo para un tamaño de 5:

    1
    22
    333
    4444
    55555

### Ejercicio 17. Triángulo de números consecutivos

Solicita un número entero y dibuja un triángulo en el que los números son consecutivos y no se reinician al comenzar una nueva fila.

Ejemplo para un tamaño de 5:

    1
    23
    456
    78910
    1112131415

---

# 4. Patrones temáticos

### Ejercicio 18. Lluvia

Dibuja una representación de la lluvia utilizando el carácter `|`.

Solicita al usuario el número de filas y columnas.

Ejemplo para 5 filas y 7 columnas:

    |  |  |
      |  |
    |  |  |
      |  |
    |  |  |

Puedes utilizar condiciones para alternar la posición de las gotas en cada fila.

### Ejercicio 19. Árbol de Navidad

Solicita un número entero que represente la altura del árbol y dibuja un árbol de Navidad utilizando asteriscos.

Ejemplo para una altura de 5:

        *
       ***
      *****
     *******
    *********
        *
        *

### Ejercicio 20. Cohete

Dibuja un cohete utilizando asteriscos.

Ejemplo:

       *
      ***
     *****
    *******
    *     *
    *     *
    *******
      * *
      * *
     *****

### Ejercicio 21. Tablero de ajedrez

Solicita un número entero que represente el tamaño del tablero y dibuja un tablero alternando los caracteres `X` y `O`.

Ejemplo para un tamaño de 6:

    XOXOXO
    OXOXOX
    XOXOXO
    OXOXOX
    XOXOXO
    OXOXOX

### Ejercicio 22. Escalera

Solicita un número entero y dibuja una escalera utilizando asteriscos.

Ejemplo para un tamaño de 5:

    *
    **
    ***
    ****
    *****

---

# 5. Retos adicionales

### Ejercicio 23. Flecha hacia arriba

Solicita un número impar y dibuja una flecha hacia arriba utilizando asteriscos.

Ejemplo:

       *
      ***
     *****
    *******
       *
       *
       *

### Ejercicio 24. Rombo numérico

Solicita un número impar y dibuja un rombo utilizando números. Cada fila debe contener números crecientes y decrecientes de forma simétrica.

Ejemplo para un tamaño de 5:

      1
     121
    12321
     121
      1

### Ejercicio 25. Pantalla de inicio de un videojuego

Dibuja una pantalla de inicio sencilla utilizando caracteres.

Ejemplo:

    *************************
    *                       *
    *      SPACE GAME       *
    *                       *
    *     1. JUGAR          *
    *     2. OPCIONES       *
    *     3. SALIR          *
    *                       *
    *************************

### Ejercicio 26. Cruz de asteriscos

Solicita un número impar y dibuja una cruz utilizando asteriscos.

La cruz debe tener el mismo número de filas y columnas.

Ejemplo para un tamaño de 7:

       *
       *
       *
    *******
       *
       *
       *

**Pista:** utiliza dos bucles `for` anidados. En cada posición debes comprobar si estás en la fila central o en la columna central. Si se cumple alguna de las dos condiciones, imprime un asterisco; en caso contrario, imprime un espacio.

## Indicaciones didácticas

### Objetivos

Con esta colección de ejercicios se pretende que el alumnado practique:

- El uso de bucles `for` para repetir instrucciones un número determinado de veces.
- La utilización de bucles anidados para recorrer filas y columnas.
- La construcción de patrones mediante la impresión de caracteres.
- El uso de variables de control para determinar qué caracteres deben imprimirse.
- La utilización de estructuras condicionales dentro de los bucles.
- La combinación de operaciones aritméticas y condiciones para construir figuras.
- La descomposición de un problema en filas, columnas y posiciones.

### Restricciones

Para resolver los ejercicios se deben utilizar exclusivamente los contenidos trabajados hasta el momento:

- Variables de tipos primitivos.
- Entrada de datos mediante `Scanner`.
- Bucles `for`.
- Condicionales `if`, `else if` y `else`.
- Operadores aritméticos, relacionales y lógicos.
- Instrucciones `System.out.print()` y `System.out.println()`.

No se permite utilizar:

- Arrays ni matrices.
- Colecciones.
- Métodos propios.
- Recursividad.
- Clases auxiliares.

### Recomendaciones para resolver los ejercicios

1. Antes de programar, observa detenidamente el patrón y determina cuántas filas y columnas tiene.
2. Identifica qué caracteres deben imprimirse en cada posición.
3. Cuando sea necesario, utiliza un bucle `for` exterior para recorrer las filas y otro interior para recorrer las columnas.
4. Utiliza condiciones para decidir si debes imprimir un asterisco, un número o un espacio.
5. Recuerda que `System.out.print()` permite continuar escribiendo en la misma línea, mientras que `System.out.println()` finaliza la línea actual.
6. Prueba los programas con diferentes tamaños para comprobar que los patrones se dibujan correctamente.

### Organización y dificultad

Los ejercicios están organizados progresivamente:

| Bloque | Contenido principal | Dificultad orientativa |
|---|---|---|
| 1. Patrones básicos | Bucles simples y anidados | Básica |
| 2. Figuras geométricas | Espacios, posiciones y condiciones | Media |
| 3. Patrones numéricos | Contadores y operaciones aritméticas | Media |
| 4. Patrones temáticos | Combinación de bucles y condiciones | Media |
| 5. Retos adicionales | Resolución de patrones más elaborados | Media-alta |

### Consideraciones

- Los ejercicios que solicitan un número impar deben recibir un valor impar. Si todavía no se han trabajado las validaciones de entrada, se puede asumir que el usuario introduce un valor correcto.
- No es necesario utilizar variables adicionales para almacenar el patrón completo: debe generarse directamente mediante instrucciones de impresión.
- Se recomienda resolver primero los ejercicios básicos antes de abordar las figuras geométricas y los retos adicionales.