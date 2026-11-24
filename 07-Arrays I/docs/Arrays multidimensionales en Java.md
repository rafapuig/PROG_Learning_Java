# Arrays multidimensionales en Java

## 1. Introducción

Hasta ahora hemos trabajado con arrays que permiten almacenar varios elementos de un mismo tipo.

Por ejemplo, podemos utilizar un array para almacenar las notas de cinco alumnos:

```java
double[] grades = {7.5, 8.0, 6.5, 9.0, 7.0};
```

Cada elemento del array se identifica mediante un índice:

| Índice | Valor |
|---:|---:|
| 0 | 7.5 |
| 1 | 8.0 |
| 2 | 6.5 |
| 3 | 9.0 |
| 4 | 7.0 |

Pero ¿qué ocurre si necesitamos almacenar información organizada en filas y columnas?

Por ejemplo:

- Las notas de varios alumnos en diferentes asignaturas.
- Las temperaturas registradas en varias ciudades durante una semana.
- Los asientos disponibles en una sala de cine.
- Los elementos de un tablero de ajedrez.
- Los píxeles de una imagen.

En estos casos podemos utilizar **arrays multidimensionales**.

Un array multidimensional es un array cuyos elementos son, a su vez, otros arrays.

Java permite crear arrays con tantas dimensiones como necesitemos.

En este documento comenzaremos por los arrays bidimensionales, que son los más habituales.

---

## 2. Arrays bidimensionales

Un array bidimensional es una estructura que organiza sus elementos en filas y columnas.

Podemos imaginarlo como una tabla.

Por ejemplo, supongamos que queremos almacenar las notas de tres alumnos en cuatro asignaturas:

| Alumno | Matemáticas | Programación | Bases de datos | Lenguajes |
|---|---:|---:|---:|---:|
| Alumno 0 | 7 | 8 | 6 | 9 |
| Alumno 1 | 5 | 7 | 8 | 6 |
| Alumno 2 | 9 | 9 | 8 | 10 |

Podemos representar esta información mediante un array bidimensional de 3 filas y 4 columnas.

```java
double[][] grades = {
    {7, 8, 6, 9},
    {5, 7, 8, 6},
    {9, 9, 8, 10}
};
```

Cada fila representa un alumno y cada columna representa una asignatura.

### 2.1. Acceder a los elementos

Para acceder a un elemento de un array bidimensional necesitamos dos índices:

1. El índice de la fila.
2. El índice de la columna.

La sintaxis es:

```java
array[fila][columna]
```

Por ejemplo:

```java
double grade = grades[1][2];
```

Este código obtiene el elemento situado en la fila 1 y la columna 2.

Recuerda que los índices comienzan en cero.

Por tanto, estamos accediendo a la nota del segundo alumno en la tercera asignatura.

El resultado será `8`.

Podemos modificar cualquier elemento de la misma manera que hacíamos con los arrays unidimensionales:

```java
grades[0][1] = 10;
```

Esta instrucción cambia la nota de la primera fila y la segunda columna.

### 2.2. Representación de los índices

Es importante entender cómo se organizan los índices.

Consideremos esta matriz:

```java
int[][] numbers = {
    {10, 20, 30},
    {40, 50, 60},
    {70, 80, 90}
};
```

Podemos representar sus posiciones de la siguiente forma:

| | Columna 0 | Columna 1 | Columna 2 |
|---|---:|---:|---:|
| Fila 0 | 10 | 20 | 30 |
| Fila 1 | 40 | 50 | 60 |
| Fila 2 | 70 | 80 | 90 |

Algunos ejemplos de acceso:

```java
numbers[0][0] // 10
numbers[0][2] // 30
numbers[1][1] // 50
numbers[2][0] // 70
numbers[2][2] // 90
```

**Recuerda:** el primer índice siempre identifica la fila y el segundo identifica la columna.

---

## 3. Declaración de arrays bidimensionales

La declaración de un array bidimensional es muy parecida a la de un array unidimensional.

La diferencia es que utilizamos dos pares de corchetes:

```java
int[][] matrix;
```

Esta declaración crea una variable que podrá almacenar una referencia a un array bidimensional de enteros.

De momento, no hemos creado el array ni hemos reservado espacio para sus elementos.

### 3.1. Crear el array

Para crear un array bidimensional utilizamos el operador `new` e indicamos el número de filas y columnas:

```java
int[][] matrix = new int[3][4];
```

Esta instrucción crea un array con:

- 3 filas.
- 4 columnas en cada fila.
- 12 elementos en total.

Al igual que sucede con los arrays unidimensionales, Java inicializa automáticamente sus elementos con el valor predeterminado del tipo correspondiente.

Por ejemplo:

- Los elementos de tipo `int` se inicializan a `0`.
- Los elementos de tipo `double` se inicializan a `0.0`.
- Los elementos de tipo `boolean` se inicializan a `false`.
- Los elementos de tipo `char` se inicializan a `'\u0000'`.
- Los elementos de tipo referencia se inicializan a `null`.

Podemos comprobarlo:

```java
int[][] matrix = new int[3][4];

IO.println(matrix[0][0]); // 0
IO.println(matrix[1][2]); // 0
IO.println(matrix[2][3]); // 0
```

### 3.2. Inicializar el array directamente

También podemos crear un array bidimensional indicando directamente sus elementos:

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
```

En este caso, Java determina automáticamente el número de filas y columnas a partir de los datos proporcionados.

No necesitamos utilizar `new` ni indicar las dimensiones.

### 3.3. Crear el array e inicializar sus elementos después

Otra posibilidad consiste en crear primero el array y asignar después los valores:

```java
int[][] matrix = new int[2][3];

matrix[0][0] = 10;
matrix[0][1] = 20;
matrix[0][2] = 30;

matrix[1][0] = 40;
matrix[1][1] = 50;
matrix[1][2] = 60;
```

Esta forma resulta especialmente útil cuando los datos se obtienen durante la ejecución del programa.

Por ejemplo, podemos solicitar al usuario que introduzca los valores.

```java
int[][] matrix = new int[2][3];

for (int row = 0; row < 2; row++) {
    for (int col = 0; col < 3; col++) {
        IO.print("Value [" + row + "][" + col + "]: ");
        matrix[row][col] = Integer.parseInt(IO.readln());
    }
}
```

---

## 4. Recorrer un array bidimensional

Para recorrer todos los elementos de un array bidimensional necesitamos normalmente dos bucles anidados.

El primer bucle recorre las filas y el segundo recorre las columnas de cada fila.

Por ejemplo:

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

for (int row = 0; row < 3; row++) {
    for (int col = 0; col < 3; col++) {
        IO.println(matrix[row][col]);
    }
}
```

Vamos a entender cómo funciona.

### 4.1. El bucle exterior

```java
for (int row = 0; row < 3; row++)
```

Este bucle controla las filas.

La variable `row` toma los valores:

- 0
- 1
- 2

Por cada valor de `row`, se ejecuta completamente el bucle interior.

### 4.2. El bucle interior

```java
for (int col = 0; col < 3; col++)
```

Este bucle controla las columnas.

La variable `col` toma los valores:

- 0
- 1
- 2

Por tanto, cuando `row` vale 0, se recorren los elementos:

```java
matrix[0][0]
matrix[0][1]
matrix[0][2]
```

Cuando `row` vale 1:

```java
matrix[1][0]
matrix[1][1]
matrix[1][2]
```

Y cuando `row` vale 2:

```java
matrix[2][0]
matrix[2][1]
matrix[2][2]
```

El bucle interior se ejecuta tres veces por cada iteración del bucle exterior.

Como el bucle exterior se ejecuta tres veces, en total accedemos a nueve elementos.

### 4.3. Mostrar la matriz en forma de tabla

Podemos utilizar `IO.print()` para mostrar los elementos de cada fila en una misma línea.

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

for (int row = 0; row < 3; row++) {
    for (int col = 0; col < 3; col++) {
        IO.print(matrix[row][col] + " ");
    }

    IO.println();
}
```

La salida será:

```text
1 2 3
4 5 6
7 8 9
```

Observa que `IO.println()` se encuentra fuera del bucle interior, pero dentro del exterior.

De esta forma, después de mostrar todos los elementos de una fila, pasamos a la siguiente línea.

### 4.4. Utilizar las dimensiones del array

En los ejemplos anteriores hemos utilizado valores constantes para indicar el número de filas y columnas.

Sin embargo, lo recomendable es obtener las dimensiones directamente del array.

Para conocer el número de filas:

```java
int rows = matrix.length;
```

Para conocer el número de columnas de una fila:

```java
int columns = matrix[0].length;
```

Por tanto, podemos recorrer la matriz sin necesidad de conocer previamente sus dimensiones:

```java
for (int row = 0; row < matrix.length; row++) {
    for (int col = 0; col < matrix[row].length; col++) {
        IO.print(matrix[row][col] + " ");
    }

    IO.println();
}
```

Fíjate en esta expresión:

```java
matrix[row].length
```

Estamos consultando la longitud de la fila que estamos recorriendo.

Esto es importante porque, como veremos más adelante, no todas las filas tienen por qué tener el mismo número de elementos.

---

## 5. Cómo funcionan realmente los arrays bidimensionales en Java

Hasta ahora hemos representado los arrays bidimensionales como tablas, pero internamente Java los organiza de una forma diferente.

Un array bidimensional es realmente un array cuyos elementos contienen referencias a otros arrays.

Es decir, un array bidimensional no es una única estructura rectangular de memoria: es un array principal que contiene referencias a otros arrays.

Podemos imaginarlo así:

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
```

El array principal contiene tres elementos.

Cada uno de esos elementos referencia a otro array:

- El primer elemento referencia al array `{1, 2, 3}`.
- El segundo elemento referencia al array `{4, 5, 6}`.
- El tercer elemento referencia al array `{7, 8, 9}`.

Por eso, cuando escribimos:

```java
matrix[1]
```

Obtenemos una referencia al segundo array, que contiene:

```text
{4, 5, 6}
```

Y cuando escribimos:

```java
matrix[1][2]
```

Accedemos al tercer elemento de ese segundo array.

Esta característica permite que las filas tengan diferentes longitudes.

---

## 6. Arrays irregulares o de filas de distinta longitud

Como hemos visto, cada fila de un array bidimensional es realmente un array independiente.

Por tanto, Java permite que las filas tengan diferentes números de elementos.

A este tipo de estructura se le suele llamar array irregular o *jagged array*.

Por ejemplo:

```java
int[][] numbers = {
    {1, 2, 3},
    {4, 5},
    {6, 7, 8, 9}
};
```

Esta estructura tiene:

- Una primera fila con 3 elementos.
- Una segunda fila con 2 elementos.
- Una tercera fila con 4 elementos.

No podemos representar correctamente esta estructura mediante una tabla rectangular, porque las filas tienen distintas longitudes.

### 6.1. Crear un array irregular

También podemos crear primero el array principal e inicializar después cada una de sus filas:

```java
int[][] numbers = new int[3][];

numbers[0] = new int[3];
numbers[1] = new int[2];
numbers[2] = new int[4];
```

Observa que al crear el array principal hemos indicado el número de filas, pero no la longitud de las filas.

Después hemos creado cada una de ellas de forma independiente.

### 6.2. Recorrer un array irregular

Cuando recorremos un array irregular, debemos consultar la longitud de cada fila.

```java
int[][] numbers = {
    {1, 2, 3},
    {4, 5},
    {6, 7, 8, 9}
};

for (int row = 0; row < numbers.length; row++) {
    for (int col = 0; col < numbers[row].length; col++) {
        IO.print(numbers[row][col] + " ");
    }

    IO.println();
}
```

La salida será:

```text
1 2 3
4 5
6 7 8 9
```

**Importante:** no debemos utilizar `numbers[0].length` como límite del bucle interior, porque no todas las filas tienen la misma longitud.

Debemos utilizar siempre:

```java
numbers[row].length
```

De esta manera, el bucle se adapta a la longitud de cada fila.

### 6.3. Un ejemplo práctico: alumnos y asignaturas

Imagina que tenemos varios alumnos y cada uno cursa un número diferente de asignaturas.

Podemos representar sus notas mediante un array irregular:

```java
double[][] grades = {
    {7.5, 8.0, 6.5},
    {9.0, 8.5},
    {6.0, 7.0, 8.0, 9.0}
};
```

Cada fila contiene las notas de un alumno.

Podemos recorrerlas y calcular la media de cada alumno:

```java
for (int row = 0; row < grades.length; row++) {
    double sum = 0;

    for (int col = 0; col < grades[row].length; col++) {
        sum += grades[row][col];
    }

    double average = sum / grades[row].length;

    IO.println("Student " + row + ": " + average);
}
```

Observa que el número de asignaturas puede variar entre alumnos, pero el programa sigue funcionando correctamente.

---

## 7. Arrays de más de dos dimensiones

Java permite crear arrays con más de dos dimensiones.

Un array tridimensional es un array cuyos elementos son arrays bidimensionales.

Podemos imaginarlo como un conjunto de matrices.

Por ejemplo, supongamos que queremos almacenar las temperaturas de varias ciudades durante varios días y en diferentes momentos del día.

Podríamos utilizar tres dimensiones:

- Primera dimensión: ciudad.
- Segunda dimensión: día.
- Tercera dimensión: momento del día.

La declaración sería:

```java
double[][][] temperatures = new double[3][7][4];
```

Esto crea:

- 3 ciudades.
- 7 días por ciudad.
- 4 mediciones por día.

En total tendremos 84 valores.

### 7.1. Acceder a los elementos

Para acceder a un elemento necesitamos tres índices:

```java
temperatures[city][day][measurement]
```

Por ejemplo:

```java
temperatures[1][2][3] = 25.5;
```

Esta instrucción almacena el valor `25.5` correspondiente a la segunda ciudad, el tercer día y la cuarta medición.

### 7.2. Recorrer un array tridimensional

Necesitamos tres bucles anidados:

```java
for (int city = 0; city < temperatures.length; city++) {
    for (int day = 0; day < temperatures[city].length; day++) {
        for (int measurement = 0;
             measurement < temperatures[city][day].length;
             measurement++) {

            IO.print(temperatures[city][day][measurement] + " ");
        }

        IO.println();
    }

    IO.println();
}
```

Cada bucle controla una dimensión diferente:

- El primero recorre las ciudades.
- El segundo recorre los días.
- El tercero recorre las mediciones.

La misma idea se puede aplicar a arrays de cuatro o más dimensiones, aunque en la práctica suelen utilizarse con mucha menos frecuencia.

---

## 8. Errores habituales al trabajar con arrays multidimensionales

Es importante conocer algunos errores que aparecen con frecuencia al trabajar con estas estructuras.

### 8.1. Confundir filas y columnas

El primer índice representa siempre la fila y el segundo la columna.

```java
matrix[row][col]
```

No debemos intercambiar su orden.

### 8.2. Utilizar límites incorrectos en los bucles

Si una matriz tiene 3 filas y 4 columnas, los índices válidos son:

- Filas: 0, 1 y 2.
- Columnas: 0, 1, 2 y 3.

Por tanto, debemos utilizar:

```java
for (int row = 0; row < matrix.length; row++) {
    for (int col = 0; col < matrix[row].length; col++) {
        // ...
    }
}
```

No debemos utilizar `<=` en lugar de `<`, porque intentaríamos acceder a una posición inexistente.

### 8.3. Suponer que todas las filas tienen la misma longitud

En Java las filas pueden tener longitudes diferentes.

Por eso, para recorrerlas correctamente debemos utilizar:

```java
matrix[row].length
```

En lugar de utilizar siempre la longitud de la primera fila.

### 8.4. Intentar acceder a una fila que no existe

Si tenemos:

```java
int[][] matrix = new int[3][4];
```

Los índices válidos para las filas son 0, 1 y 2.

Por tanto:

```java
matrix[3][0]
```

Provocará una excepción `ArrayIndexOutOfBoundsException`.

### 8.5. No inicializar una fila

Podemos crear un array principal sin crear todavía sus filas:

```java
int[][] matrix = new int[3][];
```

En este momento, sus tres elementos contienen `null`.

Por tanto, no podemos acceder a:

```java
matrix[0][0]
```

Hasta que no inicialicemos la primera fila:

```java
matrix[0] = new int[4];
```

### 8.6. Confundir la longitud del array principal con la longitud de sus filas

En un array bidimensional:

```java
matrix.length
```

Devuelve el número de filas.

En cambio:

```java
matrix[row].length
```

Devuelve el número de elementos de una fila concreta.

Son dos longitudes diferentes y ambas son importantes.

---

## 9. Ejercicios de comprobación

Los siguientes ejercicios permiten comprobar que se han entendido los conceptos explicados.

### Ejercicio 1. Declaración y acceso

Declara un array bidimensional de enteros de 3 filas y 4 columnas.

Asigna valores a algunos de sus elementos y muestra por pantalla:

- El elemento de la primera fila y primera columna.
- El elemento de la segunda fila y tercera columna.
- El elemento de la última fila y última columna.

### Ejercicio 2. Recorrer una matriz

Declara una matriz de 4 filas y 5 columnas.

Inicializa sus elementos con valores numéricos y muestra todos sus elementos organizados en filas y columnas.

Utiliza dos bucles `for`.

### Ejercicio 3. Introducción de datos

Declara una matriz de 3 filas y 2 columnas.

Solicita al usuario que introduzca todos sus elementos.

Después muestra la matriz en forma de tabla.

### Ejercicio 4. Suma de elementos

Declara una matriz de 3 filas y 4 columnas.

Inicializa sus elementos y calcula la suma de todos ellos.

Muestra el resultado.

### Ejercicio 5. Array irregular

Declara un array bidimensional de tres filas:

- La primera fila tendrá 2 elementos.
- La segunda fila tendrá 4 elementos.
- La tercera fila tendrá 3 elementos.

Inicializa sus elementos y muestra su contenido utilizando bucles anidados.

### Ejercicio 6. Número de elementos

Declara un array irregular con varias filas de diferentes longitudes.

Calcula y muestra el número total de elementos que contiene.

Pista: tendrás que sumar las longitudes de todas sus filas.

### Ejercicio 7. Array tridimensional

Declara un array tridimensional de dimensiones 2x3x4.

Inicializa sus elementos con valores numéricos y recorre toda su estructura mostrando los valores almacenados.

---

## 10. Resumen

Los arrays multidimensionales permiten organizar información mediante varias dimensiones.

Las ideas fundamentales que debemos recordar son:

- Un array bidimensional es un array de arrays.
- El primer índice identifica la fila.
- El segundo índice identifica la columna.
- Para acceder a un elemento utilizamos `matrix[row][col]`.
- `matrix.length` devuelve el número de filas.
- `matrix[row].length` devuelve el número de elementos de una fila.
- Para recorrer una matriz rectangular o irregular utilizamos normalmente dos bucles anidados.
- Java permite crear arrays irregulares, cuyas filas tienen diferentes longitudes.
- Los arrays tridimensionales permiten trabajar con tres dimensiones y necesitan tres índices.

La idea más importante es comprender que un array multidimensional no es más que un array cuyos elementos son otros arrays. A partir de ahí, su declaración, inicialización, acceso y recorrido siguen las mismas reglas que ya conocemos de los arrays unidimensionales.