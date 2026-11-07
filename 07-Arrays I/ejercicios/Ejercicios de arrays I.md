# Ejercicios de arrays en Java
## 1.º de Desarrollo de Aplicaciones Web (DAW)

**Módulo:** Programación  
**Nivel:** Primer curso de DAW  
**Tema:** Introducción a los arrays unidimensionales  
**Lenguaje:** Java

---

## Indicaciones didácticas

### Objetivos

Con esta colección de ejercicios se pretende que el alumnado aprenda a:

- Comprender qué es un array y para qué sirve.
- Declarar arrays unidimensionales.
- Crear arrays utilizando el operador `new`.
- Inicializar arrays con valores conocidos.
- Acceder a los elementos mediante sus índices.
- Consultar el número de elementos mediante la propiedad `length`.
- Modificar los valores almacenados.
- Recorrer arrays utilizando bucles `for`.
- Introducir y mostrar elementos mediante la API de entrada y salida de Java.
- Realizar operaciones básicas con los elementos de un array.
- Buscar, comparar y manipular arrays.

### Conocimientos previos

Se considera que el alumnado ya conoce:

- Variables y tipos de datos primitivos.
- Operadores aritméticos, relacionales y lógicos.
- Estructuras condicionales (`if`, `else if` y `else`).
- Bucles `for`.
- Entrada y salida de datos mediante la API `IO` de Java.

### Restricciones

Para resolver los ejercicios se pueden utilizar:

- Variables de tipos primitivos.
- Arrays unidimensionales.
- Operador `new`.
- Bucles `for`, cuando sean necesarios.
- Condicionales `if`, `else if` y `else`.
- Operadores aritméticos, relacionales y lógicos.
- Entrada de datos mediante `IO.readln()`.
- Salida de datos mediante `IO.print()` e `IO.println()`.

No se permite utilizar:

- Métodos propios.
- Programación orientada a objetos.
- Arrays multidimensionales.
- Colecciones (`ArrayList`, etc.).
- Métodos de utilidad de la clase `Arrays`.
- Bucles `while` o `do-while`.

Todos los ejercicios deben resolverse directamente dentro del método `main`.

### Consideraciones

- Los índices de los arrays comienzan en 0.
- La propiedad `length` permite conocer el número de elementos de un array.
- El último índice siempre es `length - 1`.
- Los arrays tienen un tamaño fijo una vez creados.
- No es obligatorio utilizar bucles para acceder a los elementos de un array. Cuando se conozcan las posiciones que se quieren consultar o modificar, se puede acceder directamente a ellas.
- Se recomienda utilizar bucles `for` cuando sea necesario realizar una misma operación sobre varios o todos los elementos del array.

---

# 1. Declaración, creación e inicialización

En este primer bloque se pretende que el alumnado comprenda cómo se declaran, crean e inicializan los arrays.

No es necesario utilizar bucles.

### Ejercicio 1. Mi primer array

Declara un array de enteros e inicialízalo directamente con los siguientes valores:

`{10, 20, 30, 40, 50}`

Muestra por pantalla el primer y el último elemento del array.

Resultado esperado:

```text
Primer elemento: 10
Último elemento: 50
```

### Ejercicio 2. Crear un array con new

Declara un array de enteros de 10 posiciones utilizando el operador `new`.

Asigna manualmente los siguientes valores a sus primeras cinco posiciones:

- Posición 0: 15
- Posición 1: 25
- Posición 2: 35
- Posición 3: 45
- Posición 4: 55

Muestra por pantalla los valores almacenados en esas cinco posiciones.

### Ejercicio 3. Array de nombres

Declara e inicializa un array de cadenas de texto con los nombres de cuatro compañeros de clase.

Muestra el nombre almacenado en la primera posición y el nombre almacenado en la última posición.

### Ejercicio 4. Conocer el tamaño de un array

Declara e inicializa un array de enteros con los siguientes valores:

`{5, 10, 15, 20, 25, 30, 35}`

Muestra por pantalla:

- El número de elementos del array.
- El índice de su primer elemento.
- El índice de su último elemento.

Utiliza la propiedad `length` para obtener el tamaño.

### Ejercicio 5. Array de caracteres

Declara e inicializa un array de caracteres con las letras de la palabra `JAVA`.

Muestra cada una de sus letras accediendo directamente a las posiciones del array.

Resultado esperado:

```text
J
A
V
A
```

---

# 2. Acceso y modificación de posiciones

En este bloque se practica el acceso individual a los elementos y la modificación de sus valores.

Todavía no es necesario utilizar bucles.

### Ejercicio 6. Consultar una posición

Declara e inicializa un array de enteros con los siguientes valores:

`{12, 25, 37, 48, 59, 63}`

Solicita al usuario un índice y muestra el valor almacenado en esa posición.

Puedes suponer que el usuario introduce un índice válido.

Ejemplo:

```text
Introduce un índice: 3

El valor almacenado es: 48
```

### Ejercicio 7. Modificar un elemento

Declara e inicializa un array con los siguientes valores:

`{10, 20, 30, 40, 50}`

Solicita al usuario un índice y un nuevo valor.

Modifica el elemento situado en ese índice y muestra el contenido de la posición modificada.

Ejemplo:

```text
Introduce el índice: 2
Introduce el nuevo valor: 99

El nuevo valor es: 99
```

### Ejercicio 8. Intercambiar dos posiciones

Declara e inicializa un array con los siguientes valores:

`{10, 20, 30, 40, 50}`

Intercambia los valores de las posiciones 0 y 4 utilizando una variable auxiliar.

Muestra el contenido de esas dos posiciones después del intercambio.

Resultado esperado:

```text
50
20
30
40
10
```

### Ejercicio 9. Actualizar el precio de un producto

Declara un array de valores decimales que almacene los precios de cinco productos:

`{12.50, 8.99, 25.00, 15.75, 30.00}`

Solicita al usuario el índice del producto cuyo precio quiere modificar y su nuevo precio.

Actualiza el valor correspondiente y muestra el precio actualizado.

### Ejercicio 10. Consultar las notas de un alumno

Declara un array de cinco números decimales que represente las notas de un alumno:

`{6.5, 7.0, 8.5, 5.0, 9.0}`

Solicita al usuario el número de la asignatura (del 1 al 5) y muestra la nota correspondiente.

Recuerda que el número de asignatura no coincide con el índice del array.

Por ejemplo, la asignatura 1 corresponde al índice 0.

---

# 3. Entrada y salida de datos

En este bloque se introduce el uso de bucles `for` para introducir y mostrar los elementos de un array.

### Ejercicio 11. Introducir cinco números

Crea un array de enteros de cinco posiciones.

Solicita al usuario los cinco números y almacénalos en el array.

Puedes utilizar un bucle `for` para realizar la lectura de los datos.

Ejemplo:

```text
Introduce el número 1: 15
Introduce el número 2: 23
Introduce el número 3: 8
Introduce el número 4: 42
Introduce el número 5: 17
```

### Ejercicio 12. Mostrar todos los elementos

Declara e inicializa un array con los siguientes valores:

`{5, 10, 15, 20, 25}`

Muestra todos sus elementos utilizando un bucle `for`.

Resultado esperado:

```text
5
10
15
20
25
```

### Ejercicio 13. Introducir y mostrar nombres

Solicita al usuario cinco nombres y almacénalos en un array de cadenas de texto.

Una vez introducidos, muestra todos los nombres por pantalla.

Utiliza un bucle `for` para introducir los datos y otro para mostrarlos.

### Ejercicio 14. Mostrar los elementos en orden inverso

Declara e inicializa un array con los siguientes valores:

`{10, 20, 30, 40, 50}`

Muestra sus elementos desde el último hasta el primero.

Utiliza un bucle `for` que recorra el array en sentido inverso.

Resultado esperado:

```text
50
40
30
20
10
```

---

# 4. Operaciones con los elementos de un array

En este bloque se practican los recorridos mediante bucles `for`, combinándolos con acumuladores, contadores y operaciones aritméticas.

### Ejercicio 15. Sumar los elementos

Solicita al usuario cinco números enteros y almacénalos en un array.

Utiliza un bucle `for` para calcular la suma de todos sus elementos.

Muestra el resultado.

Ejemplo:

```text
Introduce 5 números:
10
20
30
40
50

La suma es: 150
```

### Ejercicio 16. Calcular la media

Solicita al usuario cinco números enteros y almacénalos en un array.

Calcula la media aritmética de todos los elementos y muestra el resultado con dos decimales.

Ejemplo:

```text
Introduce 5 números:
10
20
30
40
50

La media es: 30.00
```

### Ejercicio 17. Encontrar el mayor elemento

Solicita al usuario seis números enteros y almacénalos en un array.

Utiliza un bucle `for` para encontrar el número mayor.

Ejemplo:

```text
Introduce 6 números:
12
45
8
67
23
31

El número mayor es: 67
```

### Ejercicio 18. Encontrar el menor elemento

Solicita al usuario seis números enteros y almacénalos en un array.

Utiliza un bucle `for` para encontrar el número menor.

Ejemplo:

```text
Introduce 6 números:
12
45
8
67
23
31

El número menor es: 8
```

### Ejercicio 19. Contar números positivos y negativos

Solicita al usuario ocho números enteros y almacénalos en un array.

Recorre el array y cuenta cuántos números son positivos y cuántos son negativos.

Los valores iguales a cero no deben incluirse en ninguno de los dos contadores.

Ejemplo:

```text
Introduce 8 números:
-5
10
0
8
-3
12
-7
4

Números positivos: 4
Números negativos: 3
```

### Ejercicio 20. Contar números pares e impares

Solicita al usuario diez números enteros y almacénalos en un array.

Recorre el array y cuenta cuántos números son pares y cuántos son impares.

Ejemplo:

```text
Introduce 10 números:
2
5
8
11
14
17
20
23
26
29

Números pares: 5
Números impares: 5
```

### Ejercicio 21. Contar números mayores que la media

Solicita al usuario seis números enteros y almacénalos en un array.

Calcula primero la media de los elementos.

Después, realiza otro recorrido para contar cuántos números son superiores a la media.

Ejemplo:

```text
Introduce 6 números:
10
20
30
40
50
60

Media: 35.0
Números superiores a la media: 3
```

---

# 5. Búsqueda de elementos

En este bloque se introduce la búsqueda de valores dentro de un array.

### Ejercicio 22. Buscar un número

Solicita al usuario ocho números enteros y almacénalos en un array.

A continuación, solicita otro número y comprueba si se encuentra dentro del array.

Muestra un mensaje indicando si el número existe o no.

Ejemplo:

```text
Introduce 8 números:
4
8
12
16
20
24
28
32

¿Qué número quieres buscar? 20

El número 20 está en el array.
```

### Ejercicio 23. Contar las apariciones de un número

Solicita al usuario diez números enteros y almacénalos en un array.

Después, solicita un número y cuenta cuántas veces aparece dentro del array.

Ejemplo:

```text
Introduce 10 números:
5
3
5
8
2
5
7
5
1
9

¿Qué número quieres buscar? 5

El número 5 aparece 4 veces.
```

### Ejercicio 24. Buscar la posición de un número

Declara e inicializa un array con los siguientes valores:

`{12, 25, 37, 48, 59, 63, 72}`

Solicita un número al usuario y muestra el índice de la primera posición en la que aparece.

Si no existe, muestra un mensaje indicándolo.

Ejemplo:

```text
¿Qué número quieres buscar? 48

El número 48 se encuentra en el índice 3.
```

### Ejercicio 25. Mostrar los números que superan un valor

Solicita al usuario ocho números enteros y almacénalos en un array.

Después, solicita un número de referencia.

Recorre el array y muestra únicamente los elementos superiores al número de referencia.

Ejemplo:

```text
Introduce 8 números:
10
25
8
40
15
60
5
30

Introduce el número de referencia: 20

Números superiores a 20:
25
40
60
30
```

---

# 6. Retos de manipulación de arrays

Estos últimos ejercicios combinan diferentes operaciones y requieren prestar especial atención a los índices.

### Ejercicio 26. Duplicar los elementos

Declara e inicializa un array con los siguientes valores:

`{2, 4, 6, 8, 10}`

Utiliza un bucle `for` para multiplicar por dos todos sus elementos.

Finalmente, muestra el contenido del array.

Resultado esperado:

```text
4
8
12
16
20
```

### Ejercicio 27. Sustituir los números negativos por cero

Solicita al usuario ocho números enteros y almacénalos en un array.

Recorre el array y sustituye todos los valores negativos por cero.

Finalmente, muestra el contenido del array.

Ejemplo:

```text
Introduce 8 números:
5
-3
8
-10
12
-4
7
-1

Array modificado:
5 0 8 0 12 0 7 0
```

### Ejercicio 28. Copiar un array

Declara e inicializa un array con los siguientes valores:

`{10, 20, 30, 40, 50}`

Crea un segundo array del mismo tamaño.

Utiliza un bucle `for` para copiar todos los elementos del primer array en el segundo.

Finalmente, muestra el contenido de ambos arrays.

### Ejercicio 29. Invertir el contenido de un array

Solicita al usuario seis números enteros y almacénalos en un array.

Invierte el orden de sus elementos utilizando un bucle `for` y una variable auxiliar.

No se permite crear un segundo array.

Ejemplo:

```text
Array original:
10 20 30 40 50 60

Array invertido:
60 50 40 30 20 10
```

### Ejercicio 30. Detectar números repetidos

Solicita al usuario ocho números enteros y almacénalos en un array.

Comprueba si existe algún número repetido.

Si existe, muestra un mensaje indicando que hay elementos repetidos. En caso contrario, indica que todos los elementos son diferentes.

Ejemplo:

```text
Introduce 8 números:
10
20
30
40
20
50
60
70

El array contiene números repetidos.
```

**Pista:** puedes utilizar dos bucles `for` anidados para comparar los elementos entre sí. Evita comparar un elemento consigo mismo.

---

## Propuesta de secuenciación didáctica

| Sesión | Ejercicios | Contenidos |
|---|---:|---|
| 1 | 1-5 | Declaración, creación, inicialización y longitud |
| 2 | 6-10 | Acceso y modificación de posiciones |
| 3 | 11-14 | Entrada, salida y recorridos |
| 4 | 15-21 | Acumuladores, contadores, máximos y mínimos |
| 5 | 22-25 | Búsquedas |
| 6 | 26-30 | Manipulación y comparación |

**Nota:** he mantenido los ejercicios de acceso directo al principio para que el alumnado comprenda que un array no implica necesariamente utilizar un bucle. El bucle `for` aparece cuando aporta una ventaja real: recorrer, procesar o comparar múltiples elementos.