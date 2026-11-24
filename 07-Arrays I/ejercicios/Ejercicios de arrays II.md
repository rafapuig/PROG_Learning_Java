# Prácticas de programación: Arrays

**Asignatura:** Programación  
**Ciclo:** Desarrollo de Aplicaciones Web (DAW)  
**Lenguaje:** Java 26

## Condiciones generales

En estas prácticas vamos a profundizar en el uso de arrays unidimensionales e introducir los arrays multidimensionales.

Todavía no hemos estudiado la programación orientada a objetos ni la creación de funciones propias. Por tanto, todos los ejercicios deben resolverse dentro del método `main`.

Para la entrada y salida de datos utilizaremos las nuevas operaciones de Java 26:

- `IO.print()`
- `IO.println()`
- `IO.readln()`

### Restricciones

- No se permite utilizar funciones o métodos propios.
- No se permite utilizar clases auxiliares.
- No se permite utilizar colecciones como `ArrayList`.
- No se permite utilizar métodos de ordenación de Java.
- Se deben utilizar arrays para almacenar los datos.
- Se deben utilizar estructuras de repetición para recorrer y manipular los arrays.
- Cuando sea necesario, se deberán utilizar bucles anidados.

---

# BLOQUE 1. Ampliación de arrays unidimensionales

En esta primera parte vamos a trabajar con algoritmos que requieren algo más que recorrer un array y calcular resultados.

Aprenderemos a desplazar elementos, insertar y eliminar valores, buscar información, eliminar duplicados y ordenar arrays.

## Nivel 1. Manipulación de arrays

### Ejercicio 1. Desplazar elementos a la derecha

Crea un array de 10 números enteros e inicialízalo con los valores que quieras.

Desplaza todos sus elementos una posición hacia la derecha. El último elemento deberá pasar a ocupar la primera posición.

**Ejemplo:**

Array original:

    [3, 7, 2, 9, 5]

Array resultante:

    [5, 3, 7, 2, 9]

**Condiciones:**

- No se puede utilizar un segundo array.
- Debes realizar el desplazamiento modificando directamente el array original.
- No se debe perder ningún elemento.

### Ejercicio 2. Rotación de un array

Crea un array de 8 números enteros y solicita al usuario que introduzca sus valores.

A continuación, solicita cuántas posiciones quiere desplazar los elementos hacia la izquierda.

Los elementos que salgan por el principio deberán volver a aparecer al final del array.

**Ejemplo:**

Array original:

    [1, 2, 3, 4, 5, 6]

Desplazamiento: 2 posiciones.

Array resultante:

    [3, 4, 5, 6, 1, 2]

**Condiciones:**

- No se puede utilizar un segundo array.
- El desplazamiento puede ser superior al tamaño del array.
- Debes contemplar que el usuario introduzca un desplazamiento negativo.

### Ejercicio 3. Insertar un elemento

Crea un array de 10 posiciones que inicialmente contenga 7 números enteros.

Solicita al usuario un número y la posición donde quiere insertarlo.

Debes desplazar los elementos necesarios hacia la derecha para introducir el nuevo número sin perder ninguno de los anteriores.

Muestra el array resultante.

**Ejemplo:**

Array original:

    [10, 20, 30, 40, 50, 60, 70]

Número a insertar: 25

Posición: 2

Array resultante:

    [10, 20, 25, 30, 40, 50, 60, 70]

**Condiciones:**

- No se puede utilizar un segundo array.
- Las posiciones comienzan en 0.
- No se permite insertar un elemento si el array está lleno.
- Debes comprobar que la posición introducida sea válida.

### Ejercicio 4. Eliminar un elemento

Crea un array de 10 posiciones que contenga inicialmente 8 números enteros.

Solicita al usuario una posición y elimina el elemento que ocupa dicha posición.

Para ello, desplaza hacia la izquierda todos los elementos posteriores.

Muestra el array resultante.

**Ejemplo:**

Array original:

    [10, 20, 30, 40, 50, 60, 70, 80]

Posición a eliminar: 3

Array resultante:

    [10, 20, 30, 50, 60, 70, 80]

**Condiciones:**

- No se puede utilizar un segundo array.
- Las posiciones comienzan en 0.
- Debes comprobar que la posición introducida sea válida.
- Debes controlar el número de elementos que contiene realmente el array.

---

## Nivel 2. Algoritmos de búsqueda y análisis

### Ejercicio 5. Segundo número más grande

Solicita 10 números enteros al usuario y almacénalos en un array.

Determina cuál es el segundo número más grande del array.

**Ejemplo:**

Array:

    [12, 45, 23, 78, 34, 56, 89, 11, 67, 90]

Resultado:

    El segundo número más grande es 89.

**Condiciones:**

- No se permite ordenar el array.
- No se permite utilizar un segundo array.
- Puedes considerar que todos los números son diferentes.

### Ejercicio 6. Frecuencia de los elementos

Solicita al usuario 15 números enteros y almacénalos en un array.

A continuación, muestra cada número diferente que aparece en el array y el número de veces que se repite.

**Ejemplo:**

Array:

    [2, 4, 2, 5, 4, 2, 7, 5]

Resultado:

    2: 3 veces
    4: 2 veces
    5: 2 veces
    7: 1 vez

**Condiciones:**

- Debes recorrer el array para contar las apariciones de cada número.
- Cada número debe aparecer una sola vez en el resultado.
- No se permite utilizar colecciones.

### Ejercicio 7. Eliminar elementos repetidos

Crea un array de 10 números enteros, permitiendo que existan valores repetidos.

Genera un segundo array que contenga los mismos números, pero eliminando los valores duplicados.

Se debe conservar el orden en el que aparecían los elementos originales.

**Ejemplo:**

Array original:

    [3, 5, 3, 2, 5, 8, 2, 9, 8, 1]

Array resultante:

    [3, 5, 2, 8, 9, 1]

**Condiciones:**

- Debes utilizar un segundo array.
- No se pueden utilizar colecciones.
- No se debe insertar un número si ya aparece en el array resultante.
- Debes controlar cuántos elementos contiene realmente el segundo array.

### Ejercicio 8. Intercalar dos arrays

Crea dos arrays de 5 números enteros cada uno.

Genera un tercer array colocando alternativamente un elemento del primer array y otro del segundo.

**Ejemplo:**

Array A:

    [1, 3, 5, 7, 9]

Array B:

    [2, 4, 6, 8, 10]

Array resultante:

    [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

**Condiciones:**

- Los dos arrays originales deben conservarse sin modificaciones.
- El tercer array debe tener capacidad para almacenar todos los elementos.
- Debes utilizar un bucle para realizar el intercalado.

---

## Nivel 3. Algoritmos más elaborados

### Ejercicio 9. Ordenación por selección (Selection Sort)

Solicita 10 números enteros al usuario y almacénalos en un array.

Ordena los elementos de menor a mayor utilizando el algoritmo de ordenación por selección.

El algoritmo funciona de la siguiente manera:

1. Busca el menor elemento del array.
2. Intercambia su posición con el elemento que ocupa la primera posición.
3. Busca el menor elemento del resto del array.
4. Intercambia su posición con el elemento que ocupa la segunda posición.
5. Repite el procedimiento hasta completar la ordenación.

**Ejemplo:**

Array original:

    [8, 3, 6, 1, 9, 2]

Array ordenado:

    [1, 2, 3, 6, 8, 9]

**Condiciones:**

- No se permite utilizar métodos de ordenación de Java.
- No se permite utilizar un segundo array.
- Los intercambios deben realizarse utilizando una variable auxiliar.

### Ejercicio 10. Mezclar dos arrays ordenados

Dispones de dos arrays de números enteros, ambos ordenados de menor a mayor.

Genera un tercer array que contenga todos los elementos de los dos arrays originales, manteniendo el orden.

**Ejemplo:**

Array A:

    [1, 4, 7, 10]

Array B:

    [2, 3, 8, 12]

Array resultante:

    [1, 2, 3, 4, 7, 8, 10, 12]

**Condiciones:**

- Los arrays originales deben conservarse sin modificaciones.
- No se permite ordenar el array resultante mediante otro algoritmo.
- Debes aprovechar que los dos arrays originales ya están ordenados.
- Se recomienda utilizar tres índices: uno para cada array original y otro para el array resultante.

---

# BLOQUE 2. Arrays multidimensionales

En esta segunda parte vamos a introducir los arrays multidimensionales.

Un array bidimensional permite almacenar información organizada en filas y columnas.

Por ejemplo, podemos representar una tabla de números mediante una matriz de 3 filas y 4 columnas:

    1   2   3   4
    5   6   7   8
    9  10  11  12

Para acceder a un elemento utilizaremos dos índices:

    matrix[row][column]

El primer índice indica la fila y el segundo la columna.

## Nivel 1. Primer contacto con matrices

### Ejercicio 1. Crear y mostrar una matriz

Declara una matriz de 3 filas y 4 columnas de números enteros.

Inicializa sus elementos con los siguientes valores:

    1   2   3   4
    5   6   7   8
    9  10  11  12

Muestra su contenido en pantalla respetando su distribución en filas y columnas.

**Condiciones:**

- Debes utilizar dos bucles `for` anidados.
- El primer bucle recorrerá las filas.
- El segundo bucle recorrerá las columnas.

### Ejercicio 2. Introducir datos en una matriz

Crea una matriz de 3 filas y 3 columnas.

Solicita al usuario que introduzca los valores de todos sus elementos.

Una vez completada, muestra la matriz en pantalla.

**Ejemplo de ejecución:**

    Introduce los valores de la matriz:

    Fila 0:
    1 2 3

    Fila 1:
    4 5 6

    Fila 2:
    7 8 9

    Matriz resultante:

    1 2 3
    4 5 6
    7 8 9

### Ejercicio 3. Sumar todos los elementos

Crea una matriz de 4 filas y 5 columnas.

Inicializa sus elementos con números enteros aleatorios entre 1 y 20.

Calcula y muestra la suma de todos los elementos de la matriz.

**Condiciones:**

- Debes utilizar dos bucles anidados para recorrer la matriz.
- Puedes utilizar `Math.random()` para generar los valores aleatorios.
- Debes mostrar la matriz antes de mostrar el resultado de la suma.

### Ejercicio 4. Suma de filas y columnas

Crea una matriz de 4 filas y 4 columnas con números introducidos por el usuario.

Una vez completada, calcula y muestra:

1. La suma de los elementos de cada fila.
2. La suma de los elementos de cada columna.
3. La suma total de todos los elementos.

**Ejemplo:**

Matriz:

    1  2  3  4
    5  6  7  8
    9  1  2  3
    4  5  6  7

Resultado:

    Suma de la fila 0: 10
    Suma de la fila 1: 26
    Suma de la fila 2: 15
    Suma de la fila 3: 22

    Suma de la columna 0: 19
    Suma de la columna 1: 14
    Suma de la columna 2: 18
    Suma de la columna 3: 22

    Suma total: 73

---

## Nivel 2. Operaciones con matrices

### Ejercicio 5. Diagonal principal y secundaria

Crea una matriz cuadrada de 4 filas y 4 columnas y rellénala con números enteros introducidos por el usuario.

Muestra los elementos de la diagonal principal y de la diagonal secundaria.

Calcula también la suma de los elementos de cada diagonal.

**Ejemplo:**

Matriz:

    1  2  3  4
    5  6  7  8
    9  1  2  3
    4  5  6  7

Diagonal principal:

    1, 6, 2, 7

Diagonal secundaria:

    4, 7, 1, 4

Suma diagonal principal: 16

Suma diagonal secundaria: 16

**Condiciones:**

- No es necesario recorrer toda la matriz para obtener las diagonales.
- Recuerda que los elementos de la diagonal principal tienen el mismo índice de fila y columna.
- La diagonal secundaria comienza en la primera fila y última columna.

### Ejercicio 6. Matriz transpuesta

Solicita al usuario los elementos de una matriz de 3 filas y 4 columnas.

Construye una segunda matriz que sea su transpuesta.

La matriz transpuesta debe tener 4 filas y 3 columnas.

Para construirla, intercambia los índices de fila y columna.

**Ejemplo:**

Matriz original:

    1  2  3  4
    5  6  7  8
    9  0  1  2

Matriz transpuesta:

    1  5  9
    2  6  0
    3  7  1
    4  8  2

### Ejercicio 7. Buscar un elemento en una matriz

Crea una matriz de 5 filas y 5 columnas con números aleatorios entre 1 y 50.

Solicita un número al usuario y determina:

- Si aparece en la matriz.
- Cuántas veces aparece.
- En qué posiciones se encuentra (fila y columna).

**Ejemplo:**

Matriz:

    4  8  2  7  5
    1  9  4  3  6
    7  2  4  8  1
    5  3  9  4  2
    6  1  8  7  3

Número buscado: 4

Resultado:

    El número aparece 4 veces.

    Posiciones:
    Fila 0, columna 0
    Fila 1, columna 2
    Fila 2, columna 2
    Fila 3, columna 3

### Ejercicio 8. Matriz de temperaturas

Una estación meteorológica registra las temperaturas de 4 ciudades durante 7 días.

Almacena los datos en una matriz de 4 filas y 7 columnas.

Cada fila representa una ciudad y cada columna representa un día de la semana.

Solicita al usuario las temperaturas registradas.

Una vez introducidos todos los datos, calcula y muestra:

1. La temperatura media de cada ciudad durante la semana.
2. La temperatura media de cada día entre todas las ciudades.
3. La temperatura máxima registrada y su posición.
4. La temperatura mínima registrada y su posición.

**Condiciones:**

- Utiliza una matriz de números decimales.
- Debes utilizar bucles anidados para recorrer los datos.
- Debes indicar a qué ciudad y día corresponden las temperaturas máxima y mínima.

---

## Nivel 3. Aplicaciones de las matrices

### Ejercicio 9. Juego del tres en raya

Crea un programa que permita jugar al tres en raya entre dos jugadores.

El tablero estará representado mediante una matriz de 3 filas y 3 columnas.

Cada posición podrá contener:

- Un espacio vacío.
- Una X.
- Una O.

Los jugadores introducirán alternativamente la fila y la columna donde quieren colocar su símbolo.

Después de cada jugada, se mostrará el tablero actualizado.

**Ejemplo de tablero:**

    X | O | X
    ---------
    O | X |  
    ---------
      |   | O

**Condiciones:**

- Los jugadores deben alternar sus turnos.
- No se puede colocar un símbolo en una posición ocupada.
- Se debe comprobar que las posiciones introducidas sean válidas.
- El juego debe terminar cuando un jugador consiga tres símbolos consecutivos o cuando no queden posiciones libres.

**Ampliación:**

Comprueba si alguno de los jugadores ha conseguido tres símbolos consecutivos:

- En horizontal.
- En vertical.
- En la diagonal principal.
- En la diagonal secundaria.

Si no hay ganador y el tablero está completo, la partida termina en empate.

### Ejercicio 10. Gestión de asientos de un cine

Un cine dispone de una sala con 6 filas y 8 asientos por fila.

Representa los asientos mediante una matriz de valores booleanos:

- `false`: asiento libre.
- `true`: asiento ocupado.

El programa debe permitir realizar las siguientes operaciones mediante un menú:

1. Mostrar el estado actual de la sala.
2. Reservar un asiento indicando fila y columna.
3. Cancelar una reserva.
4. Comprobar si un asiento está disponible.
5. Mostrar el número de asientos libres.
6. Mostrar el porcentaje de ocupación de la sala.
7. Salir del programa.

**Ejemplo de representación:**

    O O X O O O X O
    O O O O X O O O
    X O O O O O O O
    O X O O O O X O
    O O O X O O O O
    O O O O O X O O

Donde:

- `O` representa un asiento libre.
- `X` representa un asiento ocupado.

**Condiciones:**

- Debes utilizar una matriz de tipo `boolean`.
- No se puede reservar un asiento que ya esté ocupado.
- No se puede cancelar una reserva de un asiento que ya esté libre.
- Debes comprobar que las filas y columnas introducidas sean válidas.
- El menú debe repetirse hasta que el usuario decida salir.

**Ampliación:**

Al mostrar la ocupación de la sala, representa también el porcentaje de asientos ocupados respecto al total.

---

# Recomendaciones finales

Antes de comenzar cada ejercicio:

1. Analiza qué información necesitas almacenar.
2. Decide qué tamaño debe tener el array o la matriz.
3. Piensa qué índices necesitas para recorrer sus elementos.
4. Identifica qué operaciones debes realizar sobre los datos.
5. Comprueba los casos especiales: array vacío, posiciones no válidas, elementos repetidos, etc.

Recuerda que el objetivo no es solamente conseguir que el programa funcione, sino comprender cómo se almacenan, recorren y manipulan los datos mediante arrays.