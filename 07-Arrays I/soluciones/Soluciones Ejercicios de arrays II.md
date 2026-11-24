# Solucionario: ampliación de arrays en Java

## Introducción

Este documento contiene las soluciones explicadas de los 20 ejercicios de ampliación de arrays unidimensionales y multidimensionales.

Los programas están planteados para Java 26, utilizando la API de entrada y salida:

- `IO.print()`
- `IO.println()`
- `IO.readln()`

Se utilizan exclusivamente variables, estructuras condicionales, bucles y arrays. No se emplean funciones propias ni programación orientada a objetos.

---

# Bloque 1. Arrays unidimensionales

## Ejercicio 1. Desplazamiento circular a la derecha

### Planteamiento

Tenemos que desplazar todos los elementos del array una posición hacia la derecha. El último elemento debe pasar a ocupar la primera posición.

Por ejemplo:

```text
Original:  4  8  2  9  5  1  7  3
Resultado: 3  4  8  2  9  5  1  7
```

### Explicación de la solución

El problema es que, si empezamos a desplazar los elementos desde la primera posición, perderíamos los valores originales que todavía necesitamos copiar.

Por eso debemos recorrer el array de derecha a izquierda.

Primero guardamos el último elemento en una variable auxiliar, porque vamos a sobrescribir su posición.

Después desplazamos cada elemento una posición hacia la derecha:

- El elemento de la posición 6 pasa a la posición 7.
- El elemento de la posición 5 pasa a la posición 6.
- Y así sucesivamente.

Finalmente, colocamos en la primera posición el valor que habíamos guardado.

### Código

```java
int[] numbers = new int[8];

for (int i = 0; i < numbers.length; i++) {
    numbers[i] = Integer.parseInt(IO.readln("Número: "));
}

IO.println("Array original:");

for (int number : numbers) {
    IO.print(number + " ");
}

// Guardamos el último elemento.
int last = numbers[numbers.length - 1];

// Desplazamos los elementos hacia la derecha.
for (int i = numbers.length - 1; i > 0; i--) {
    numbers[i] = numbers[i - 1];
}

// Colocamos el último elemento al principio.
numbers[0] = last;

IO.println("\nArray desplazado:");

for (int number : numbers) {
    IO.print(number + " ");
}
```

### Aspectos importantes

- El desplazamiento se realiza de derecha a izquierda para no sobrescribir datos que todavía necesitamos.
- La variable `last` permite conservar el último elemento.
- `numbers.length - 1` representa el índice del último elemento.

---

## Ejercicio 2. Rotación circular de un array

### Planteamiento

Tenemos que desplazar los elementos de un array varias posiciones hacia la izquierda.

Por ejemplo:

```text
Original:  10  20  30  40  50
Resultado: 30  40  50  10  20
```

En este caso hemos desplazado dos posiciones.

### Explicación de la solución

Podemos realizar una rotación de una posición y repetir el proceso tantas veces como indique el usuario.

Para desplazar una posición hacia la izquierda:

1. Guardamos el primer elemento.
2. Desplazamos todos los demás elementos una posición hacia la izquierda.
3. Colocamos el elemento guardado en la última posición.

Este procedimiento se repite tantas veces como desplazamientos necesitemos.

Hay un detalle interesante: desplazar un array de 10 elementos 12 posiciones equivale a desplazarlo solamente 2 posiciones.

Por eso utilizamos el operador módulo:

`positions % numbers.length`

El operador `%` obtiene el resto de una división y nos permite eliminar las vueltas completas.

### Código

```java
int[] numbers = new int[10];

for (int i = 0; i < numbers.length; i++) {
    numbers[i] = (int) (Math.random() * 50) + 1;
}

IO.println("Array original:");

for (int number : numbers) {
    IO.print(number + " ");
}

int positions = Integer.parseInt(IO.readln("\nPosiciones: "));

// Eliminamos las vueltas completas.
positions = positions % numbers.length;

// Repetimos el desplazamiento.
for (int count = 0; count < positions; count++) {

    int first = numbers[0];

    for (int i = 0; i < numbers.length - 1; i++) {
        numbers[i] = numbers[i + 1];
    }

    numbers[numbers.length - 1] = first;
}

IO.println("\nArray rotado:");

for (int number : numbers) {
    IO.print(number + " ");
}
```

### Aspectos importantes

- El bucle exterior controla cuántas rotaciones realizamos.
- El bucle interior desplaza los elementos una posición.
- La variable auxiliar `first` conserva el elemento que vamos a mover al final.
- El operador módulo permite reducir el número de desplazamientos.

---

## Ejercicio 3. Insertar un elemento en un array

### Planteamiento

Tenemos un array de capacidad 10, pero solamente contiene 7 elementos.

Queremos insertar un nuevo elemento en una posición determinada sin perder los valores que ya contiene.

### Explicación de la solución

En este ejercicio aparece un concepto importante: la diferencia entre la capacidad del array y el número de elementos que contiene realmente.

El array tiene 10 posiciones, pero solamente utilizamos las primeras 7.

Para controlar los elementos ocupados utilizamos una variable:

`size = 7`

Si queremos insertar un elemento en una posición determinada, debemos desplazar hacia la derecha todos los elementos que se encuentran a partir de esa posición.

Es importante hacerlo de derecha a izquierda para evitar sobrescribir los valores originales.

Por ejemplo, si tenemos:

```text
[10, 20, 30, 40, 50, 60, 70]
```

Y queremos insertar el 99 en la posición 2:

```text
[10, 20, 99, 30, 40, 50, 60, 70]
```

Una vez desplazados los elementos, colocamos el nuevo valor y aumentamos `size`.

La posición de inserción puede estar comprendida entre 0 y `size`, ambas incluidas. Esto permite insertar al principio o al final de los elementos ocupados.

### Código

```java
int[] numbers = new int[10];
int size = 7;

for (int i = 0; i < size; i++) {
    numbers[i] = Integer.parseInt(IO.readln("Número: "));
}

IO.println("Array original:");

for (int i = 0; i < size; i++) {
    IO.print(numbers[i] + " ");
}

if (size == numbers.length) {
    IO.println("\nEl array está lleno.");
} else {

    int number = Integer.parseInt(IO.readln("\nNúmero que insertar: "));
    int position = Integer.parseInt(IO.readln("Posición: "));

    if (position < 0 || position > size) {
        IO.println("Posición incorrecta.");
    } else {

        // Desplazamos los elementos hacia la derecha.
        for (int i = size; i > position; i--) {
            numbers[i] = numbers[i - 1];
        }

        // Insertamos el nuevo elemento.
        numbers[position] = number;

        // Actualizamos el número de elementos.
        size++;

        IO.println("Array resultante:");

        for (int i = 0; i < size; i++) {
            IO.print(numbers[i] + " ");
        }
    }
}
```

### Aspectos importantes

- `numbers.length` indica la capacidad total.
- `size` indica cuántas posiciones están ocupadas.
- El desplazamiento se realiza de derecha a izquierda.
- El bucle comienza en `size`, porque esa es la primera posición libre.
- La posición `size` también es válida para insertar al final.

---

## Ejercicio 4. Eliminar un elemento de un array

### Planteamiento

Queremos eliminar un elemento de un array indicando su posición.

Como los arrays tienen un tamaño fijo, no podemos reducir físicamente su longitud. Lo que hacemos es desplazar los elementos posteriores hacia la izquierda y actualizar el tamaño lógico.

### Explicación de la solución

Supongamos que tenemos:

```text
[10, 20, 30, 40, 50, 60, 70]
```

Queremos eliminar el elemento de la posición 2.

Para ello:

1. El elemento de la posición 3 pasa a la posición 2.
2. El elemento de la posición 4 pasa a la posición 3.
3. Continuamos hasta llegar al último elemento ocupado.
4. Reducimos `size` en una unidad.

El resultado será:

```text
[10, 20, 40, 50, 60, 70]
```

No necesitamos borrar físicamente el último valor. Basta con dejar de considerarlo parte del contenido del array.

### Código

```java
int[] numbers = new int[10];
int size = 7;

for (int i = 0; i < size; i++) {
    numbers[i] = Integer.parseInt(IO.readln("Número: "));
}

IO.println("Array original:");

for (int i = 0; i < size; i++) {
    IO.print(numbers[i] + " ");
}

int position = Integer.parseInt(IO.readln("\nPosición que eliminar: "));

if (position < 0 || position >= size) {
    IO.println("Posición incorrecta.");
} else {

    // Desplazamos los elementos hacia la izquierda.
    for (int i = position; i < size - 1; i++) {
        numbers[i] = numbers[i + 1];
    }

    // Reducimos el número de elementos.
    size--;

    IO.println("Array resultante:");

    for (int i = 0; i < size; i++) {
        IO.print(numbers[i] + " ");
    }
}
```

### Aspectos importantes

- La última posición ocupada es `size - 1`.
- Por eso el desplazamiento termina cuando `i` alcanza `size - 2`.
- La condición `position >= size` impide eliminar una posición que no contiene un elemento válido.
- El tamaño lógico se reduce después de realizar el desplazamiento.

---

## Ejercicio 5. Segundo número más grande

### Planteamiento

Tenemos que encontrar el segundo valor más grande de un array, teniendo en cuenta que debe ser diferente del mayor.

Por ejemplo:

```text
[10, 40, 20, 40, 30]
```

El mayor es 40 y el segundo mayor distinto es 30.

No podemos ordenar el array.

### Explicación de la solución

Vamos a recorrer el array una sola vez, manteniendo dos variables:

- `largest`: el mayor valor encontrado.
- `secondLargest`: el segundo mayor valor encontrado.

Además, necesitamos una variable booleana para indicar si hemos encontrado un segundo valor distinto.

Cuando encontramos un número mayor que `largest`, tenemos que actualizar ambas variables:

1. El antiguo mayor pasa a ser el segundo mayor.
2. El nuevo número se convierte en el mayor.

Si el número no supera al mayor, todavía puede convertirse en el segundo mayor. Para ello debe cumplir dos condiciones:

- Ser menor que el mayor.
- Ser mayor que el segundo mayor actual, o todavía no haber encontrado un segundo valor.

Es importante comprobar que sea estrictamente menor que `largest`, porque el enunciado pide un segundo valor distinto.

### Código

```java
int[] numbers = new int[10];

for (int i = 0; i < numbers.length; i++) {
    numbers[i] = (int) (Math.random() * 100) + 1;
}

IO.println("Array:");

for (int number : numbers) {
    IO.print(number + " ");
}

int largest = numbers[0];
int secondLargest = 0;
boolean foundSecond = false;

for (int i = 1; i < numbers.length; i++) {

    if (numbers[i] > largest) {

        secondLargest = largest;
        largest = numbers[i];

        foundSecond = true;

    } else if (numbers[i] < largest &&
               (!foundSecond || numbers[i] > secondLargest)) {

        secondLargest = numbers[i];
        foundSecond = true;
    }
}

IO.println("\nMayor: " + largest);

if (foundSecond) {
    IO.println("Segundo mayor distinto: " + secondLargest);
} else {
    IO.println("No existe un segundo valor distinto.");
}
```

### Aspectos importantes

- No necesitamos ordenar el array.
- Solo recorremos sus elementos una vez.
- La variable `foundSecond` permite distinguir entre un segundo valor encontrado y la ausencia de uno.
- No debemos aceptar como segundo mayor un valor igual al mayor.

---

## Ejercicio 6. Frecuencia de los elementos

### Planteamiento

Tenemos que calcular cuántas veces aparece cada número en un array.

Por ejemplo:

```text
[2, 5, 2, 1, 5, 2, 3]
```

El resultado sería:

```text
1 aparece 1 vez
2 aparece 3 veces
3 aparece 1 vez
5 aparece 2 veces
```

### Explicación de la solución

Una primera posibilidad sería recorrer el array y contar cuántas veces aparece cada número.

El problema es que, si hacemos esto directamente para cada posición, calcularemos varias veces la frecuencia de un mismo valor.

Por ejemplo, si el número 2 aparece tres veces, realizaríamos el mismo cálculo tres veces.

Para evitarlo utilizamos un segundo array booleano:

`counted`

Cada posición de este array indica si ya hemos contabilizado el elemento correspondiente del array original.

El procedimiento es:

1. Recorremos el array original.
2. Si el elemento ya está contabilizado, lo ignoramos.
3. Si todavía no está contabilizado, contamos sus apariciones.
4. Marcamos como contabilizadas todas sus apariciones.
5. Mostramos su frecuencia.

### Código

```java
int[] numbers = new int[15];
boolean[] counted = new boolean[15];

for (int i = 0; i < numbers.length; i++) {
    numbers[i] = (int) (Math.random() * 10) + 1;
}

IO.println("Array:");

for (int number : numbers) {
    IO.print(number + " ");
}

IO.println("\nFrecuencias:");

for (int i = 0; i < numbers.length; i++) {

    if (!counted[i]) {

        int frequency = 0;

        for (int j = 0; j < numbers.length; j++) {

            if (numbers[i] == numbers[j]) {
                frequency++;
                counted[j] = true;
            }
        }

        IO.println(numbers[i] + ": " + frequency);
    }
}
```

### Aspectos importantes

- `counted` tiene tantas posiciones como el array original.
- Inicialmente todos sus elementos valen `false`.
- Cuando encontramos un número, marcamos todas sus apariciones.
- El segundo bucle cuenta las apariciones de un valor concreto.
- El resultado evita repetir frecuencias.

---

## Ejercicio 7. Eliminar los elementos duplicados

### Planteamiento

Tenemos que construir un segundo array que contenga únicamente los valores diferentes del primero.

Debemos conservar el orden de la primera aparición de cada número.

Por ejemplo:

```text
Original:       4  2  4  7  2  9  7  1
Sin duplicados: 4  2  7  9  1
```

### Explicación de la solución

Creamos un segundo array que utilizaremos para almacenar los elementos sin duplicados.

Como no sabemos cuántos elementos diferentes vamos a encontrar, necesitamos una variable `size` para controlar cuántos elementos hemos almacenado.

Recorremos el array original y, para cada elemento, comprobamos si ya aparece en el array auxiliar.

Para ello utilizamos una variable booleana:

`found`

Inicialmente vale `false`.

Recorremos las posiciones ocupadas del array auxiliar. Si encontramos el número, cambiamos `found` a `true`.

Si terminamos la búsqueda y `found` sigue siendo `false`, significa que el número todavía no estaba almacenado. Por tanto, lo añadimos al final del array auxiliar.

### Código

```java
int[] numbers = new int[12];
int[] unique = new int[12];

int size = 0;

for (int i = 0; i < numbers.length; i++) {
    numbers[i] = (int) (Math.random() * 10) + 1;
}

IO.println("Array original:");

for (int number : numbers) {
    IO.print(number + " ");
}

for (int i = 0; i < numbers.length; i++) {

    boolean found = false;

    // Buscamos el elemento en el array auxiliar.
    for (int j = 0; j < size; j++) {

        if (unique[j] == numbers[i]) {
            found = true;
        }
    }

    // Si no existe, lo añadimos.
    if (!found) {
        unique[size] = numbers[i];
        size++;
    }
}

IO.println("\nArray sin duplicados:");

for (int i = 0; i < size; i++) {
    IO.print(unique[i] + " ");
}
```

### Aspectos importantes

- El array auxiliar puede tener la misma capacidad que el original.
- `size` indica cuántos elementos contiene realmente.
- Solo buscamos en las posiciones ocupadas del array auxiliar.
- El orden se conserva porque recorremos el array original de izquierda a derecha.

---

## Ejercicio 8. Intercalar dos arrays

### Planteamiento

Tenemos dos arrays del mismo tamaño y queremos construir un tercero intercalando sus elementos.

Por ejemplo:

```text
Primer array:  1  3  5  7  9
Segundo array: 2  4  6  8  10

Resultado:     1  2  3  4  5  6  7  8  9  10
```

### Explicación de la solución

La solución consiste en aprovechar que conocemos la posición que debe ocupar cada elemento.

El elemento de la posición `i` del primer array debe ir a la posición `i * 2` del resultado.

El elemento de la posición `i` del segundo array debe ir a la posición `i * 2 + 1`.

Por ejemplo:

| Posición original | Primer array | Segundo array |
|---|---|---|
| 0 | Resultado[0] | Resultado[1] |
| 1 | Resultado[2] | Resultado[3] |
| 2 | Resultado[4] | Resultado[5] |

Así podemos construir el resultado utilizando un único bucle.

### Código

```java
int[] first = new int[5];
int[] second = new int[5];
int[] result = new int[10];

for (int i = 0; i < first.length; i++) {
    first[i] = Integer.parseInt(IO.readln("Primer array: "));
}

for (int i = 0; i < second.length; i++) {
    second[i] = Integer.parseInt(IO.readln("Segundo array: "));
}

for (int i = 0; i < first.length; i++) {

    result[i * 2] = first[i];
    result[i * 2 + 1] = second[i];

}

IO.println("Resultado:");

for (int number : result) {
    IO.print(number + " ");
}
```

### Aspectos importantes

- Los dos arrays tienen que tener el mismo tamaño en esta solución.
- El array resultante tiene el doble de capacidad.
- La expresión `i * 2` permite calcular la posición par.
- La expresión `i * 2 + 1` permite calcular la posición impar.

---

## Ejercicio 9. Ordenación por selección

### Planteamiento

Tenemos que ordenar un array de menor a mayor utilizando el algoritmo de selección.

### Explicación de la solución

El algoritmo de selección consiste en buscar el elemento más pequeño de la parte del array que todavía no está ordenada.

Una vez encontrado, lo intercambiamos con el primer elemento de esa parte.

Por ejemplo:

```text
[8, 3, 6, 1, 5]
```

Primera pasada:

- Buscamos el menor de todo el array.
- Encontramos el 1.
- Lo intercambiamos con el primer elemento.

Resultado:

```text
[1, 3, 6, 8, 5]
```

Segunda pasada:

- El primer elemento ya está ordenado.
- Buscamos el menor desde la posición 1.
- Encontramos el 3, que ya está en su sitio.

Y así sucesivamente.

Necesitamos dos bucles:

- El exterior determina la posición que vamos a ocupar.
- El interior busca el menor elemento de la parte que todavía no está ordenada.

La variable `minIndex` guarda la posición del menor elemento encontrado.

Al finalizar la búsqueda, intercambiamos los elementos utilizando una variable auxiliar.

### Código

```java
int[] numbers = new int[10];

for (int i = 0; i < numbers.length; i++) {
    numbers[i] = (int) (Math.random() * 100) + 1;
}

IO.println("Array original:");

for (int number : numbers) {
    IO.print(number + " ");
}

for (int i = 0; i < numbers.length - 1; i++) {

    int minIndex = i;

    // Buscamos el menor elemento.
    for (int j = i + 1; j < numbers.length; j++) {

        if (numbers[j] < numbers[minIndex]) {
            minIndex = j;
        }
    }

    // Intercambiamos los elementos.
    int temp = numbers[i];
    numbers[i] = numbers[minIndex];
    numbers[minIndex] = temp;
}

IO.println("\nArray ordenado:");

for (int number : numbers) {
    IO.print(number + " ");
}
```

### Aspectos importantes

- `minIndex` no almacena el valor mínimo, sino su posición.
- El bucle interior comienza en `i + 1` porque no necesitamos comparar la posición actual consigo misma.
- El intercambio utiliza una variable auxiliar.
- No necesitamos realizar una última pasada porque, cuando llegamos al último elemento, necesariamente estará ordenado.

---

## Ejercicio 10. Fusionar dos arrays ordenados

### Planteamiento

Tenemos dos arrays ordenados de menor a mayor y queremos construir un tercero que contenga todos sus elementos, también ordenados.

No debemos ordenar el resultado después de copiar los elementos.

### Explicación de la solución

La clave es aprovechar que los dos arrays originales ya están ordenados.

Utilizamos tres índices:

- `i`: posición actual del primer array.
- `j`: posición actual del segundo array.
- `k`: posición donde vamos a insertar el siguiente elemento en el resultado.

Mientras queden elementos en los dos arrays, comparamos sus elementos actuales.

El menor de los dos se copia al resultado y avanzamos el índice correspondiente.

Por ejemplo:

```text
Primer array:  1  4  7
Segundo array: 2  3  8
```

Primero comparamos 1 y 2. Copiamos el 1.

Después comparamos 4 y 2. Copiamos el 2.

Continuamos hasta que uno de los arrays se quede sin elementos.

Cuando esto sucede, ya no necesitamos comparar nada: simplemente copiamos los elementos restantes del otro array.

### Código

```java
int[] first = new int[6];
int[] second = new int[6];
int[] result = new int[12];

IO.println("Introduce el primer array ordenado:");

for (int i = 0; i < first.length; i++) {
    first[i] = Integer.parseInt(IO.readln("Número: "));
}

IO.println("Introduce el segundo array ordenado:");

for (int i = 0; i < second.length; i++) {
    second[i] = Integer.parseInt(IO.readln("Número: "));
}

int i = 0;
int j = 0;
int k = 0;

// Fusionamos mientras queden elementos en ambos arrays.
while (i < first.length && j < second.length) {

    if (first[i] <= second[j]) {

        result[k] = first[i];
        i++;

    } else {

        result[k] = second[j];
        j++;

    }

    k++;
}

// Copiamos los elementos restantes del primer array.
while (i < first.length) {

    result[k] = first[i];

    i++;
    k++;
}

// Copiamos los elementos restantes del segundo array.
while (j < second.length) {

    result[k] = second[j];

    j++;
    k++;
}

IO.println("Array fusionado:");

for (int number : result) {
    IO.print(number + " ");
}
```

### Aspectos importantes

- No necesitamos ordenar el resultado.
- Los índices `i` y `j` avanzan de manera independiente.
- El índice `k` avanza cada vez que copiamos un elemento.
- Los dos últimos bucles garantizan que no perdamos los elementos que quedan en alguno de los arrays.

---

# Bloque 2. Arrays multidimensionales

## Ejercicio 11. Declaración y recorrido de una matriz

### Planteamiento

Tenemos una matriz de 3 filas y 4 columnas.

Debemos mostrar sus elementos, recorrer una fila, recorrer una columna y conocer sus dimensiones.

### Explicación de la solución

Una matriz es un array cuyos elementos son, a su vez, arrays.

En Java, una matriz se declara de la siguiente manera:

`int[][] matrix`

Para acceder a un elemento necesitamos dos índices:

`matrix[row][col]`

El primero indica la fila y el segundo la columna.

Para recorrer todos los elementos necesitamos dos bucles anidados:

- El bucle exterior recorre las filas.
- El bucle interior recorre las columnas de cada fila.

La propiedad `length` tiene un significado importante:

- `matrix.length` devuelve el número de filas.
- `matrix[row].length` devuelve el número de columnas de esa fila.

### Código

```java
int[][] matrix = {
    {1, 2, 3, 4},
    {5, 6, 7, 8},
    {9, 10, 11, 12}
};

IO.println("Matriz:");

for (int row = 0; row < matrix.length; row++) {

    for (int col = 0; col < matrix[row].length; col++) {
        IO.print(matrix[row][col] + "\t");
    }

    IO.println();
}

IO.println("Número de filas: " + matrix.length);
IO.println("Número de columnas: " + matrix[0].length);

IO.println("Primera fila:");

for (int col = 0; col < matrix[0].length; col++) {
    IO.print(matrix[0][col] + " ");
}

IO.println("\nSegunda columna:");

for (int row = 0; row < matrix.length; row++) {
    IO.print(matrix[row][1] + " ");
}
```

### Aspectos importantes

- Una matriz utiliza dos índices.
- El primer índice identifica la fila.
- El segundo índice identifica la columna.
- `matrix.length` no devuelve el número total de elementos.
- Los bucles anidados permiten recorrer todos los elementos.

---

## Ejercicio 12. Rellenar y mostrar una matriz

### Planteamiento

Tenemos que solicitar al usuario los valores de una matriz de 3 filas y 3 columnas y mostrar posteriormente su contenido.

### Explicación de la solución

El procedimiento es prácticamente idéntico al recorrido de una matriz.

La diferencia es que, en lugar de leer los elementos de un array unidimensional, necesitamos dos bucles para solicitar los valores de todas las posiciones.

Cada vez que se ejecuta el bucle interior, solicitamos un elemento de la fila actual.

La expresión `matrix[row][col]` identifica exactamente la posición que queremos rellenar.

### Código

```java
int[][] matrix = new int[3][3];

// Rellenamos la matriz.
for (int row = 0; row < matrix.length; row++) {

    for (int col = 0; col < matrix[row].length; col++) {

        matrix[row][col] =
            Integer.parseInt(IO.readln(
                "Valor [" + row + "][" + col + "]: "
            ));
    }
}

// Mostramos la matriz.
IO.println("Matriz:");

for (int row = 0; row < matrix.length; row++) {

    for (int col = 0; col < matrix[row].length; col++) {
        IO.print(matrix[row][col] + "\t");
    }

    IO.println();
}
```

### Aspectos importantes

- El primer bucle recorre las filas.
- El segundo recorre las columnas.
- La posición `[0][0]` corresponde al primer elemento.
- La posición `[2][2]` corresponde al último elemento de esta matriz.

---

## Ejercicio 13. Suma de los elementos de una matriz

### Planteamiento

Tenemos una matriz de 4 filas y 5 columnas.

Debemos rellenarla con números aleatorios y calcular la suma y la media de todos sus elementos.

### Explicación de la solución

Para sumar todos los elementos de una matriz basta con recorrerla completamente utilizando dos bucles.

Cada vez que generamos un nuevo número aleatorio, lo almacenamos en la matriz y lo sumamos a una variable acumuladora.

Al terminar el recorrido, tendremos la suma de todos los elementos.

Para calcular la media necesitamos conocer cuántos elementos tiene la matriz.

Como tiene 4 filas y 5 columnas:

`4 * 5 = 20 elementos`

Podemos obtener esta cantidad utilizando las propiedades `length` de la matriz.

Es importante realizar una conversión a `double` antes de dividir para obtener una media decimal.

### Código

```java
int[][] matrix = new int[4][5];

int sum = 0;

for (int row = 0; row < matrix.length; row++) {

    for (int col = 0; col < matrix[row].length; col++) {

        matrix[row][col] = (int) (Math.random() * 20) + 1;

        sum += matrix[row][col];
    }
}

IO.println("Matriz:");

for (int row = 0; row < matrix.length; row++) {

    for (int col = 0; col < matrix[row].length; col++) {
        IO.print(matrix[row][col] + "\t");
    }

    IO.println();
}

int totalElements = matrix.length * matrix[0].length;

double average = (double) sum / totalElements;

IO.println("Suma total: " + sum);
IO.println("Media: " + average);
```

### Aspectos importantes

- La suma se calcula durante el mismo recorrido en el que rellenamos la matriz.
- El número total de elementos se obtiene multiplicando filas por columnas.
- La conversión `(double)` evita realizar una división entera.
- El recorrido de una matriz necesita dos índices.

---

## Ejercicio 14. Sumas por filas y columnas

### Planteamiento

Tenemos una matriz cuadrada de 4 filas y 4 columnas.

Debemos calcular:

- La suma de cada fila.
- La suma de cada columna.
- La suma total de todos los elementos.

### Explicación de la solución

En este ejercicio es importante comprender cómo cambia el recorrido dependiendo de lo que queremos calcular.

Para sumar una fila concreta, mantenemos fija la fila y recorremos todas sus columnas.

Por ejemplo, para sumar la fila 2:

```java
for (int col = 0; col < matrix[2].length; col++) {
    sum += matrix[2][col];
}
```

En cambio, para sumar una columna concreta, mantenemos fija la columna y recorremos todas las filas.

Por ejemplo, para sumar la columna 2:

```java
for (int row = 0; row < matrix.length; row++) {
    sum += matrix[row][2];
}
```

La diferencia es que, al recorrer una fila, cambia el índice de columna. Al recorrer una columna, cambia el índice de fila.

### Código

```java
int[][] matrix = new int[4][4];

for (int row = 0; row < matrix.length; row++) {

    for (int col = 0; col < matrix[row].length; col++) {
        matrix[row][col] = (int) (Math.random() * 20) + 1;
    }
}

IO.println("Matriz:");

for (int row = 0; row < matrix.length; row++) {

    for (int col = 0; col < matrix[row].length; col++) {
        IO.print(matrix[row][col] + "\t");
    }

    IO.println();
}

IO.println("\nSuma por filas:");

for (int row = 0; row < matrix.length; row++) {

    int sum = 0;

    for (int col = 0; col < matrix[row].length; col++) {
        sum += matrix[row][col];
    }

    IO.println("Fila " + row + ": " + sum);
}

IO.println("\nSuma por columnas:");

int total = 0;

for (int col = 0; col < matrix[0].length; col++) {

    int sum = 0;

    for (int row = 0; row < matrix.length; row++) {
        sum += matrix[row][col];
    }

    IO.println("Columna " + col + ": " + sum);

    total += sum;
}

IO.println("Suma total: " + total);
```

### Aspectos importantes

- Para sumar una fila, se fija el índice de fila.
- Para sumar una columna, se fija el índice de columna.
- Cada suma parcial debe inicializarse a cero.
- La suma total puede obtenerse acumulando las sumas de las columnas.

---

## Ejercicio 15. Diagonales de una matriz

### Planteamiento

Tenemos una matriz cuadrada de 4 filas y 4 columnas.

Debemos mostrar los elementos de sus dos diagonales y calcular sus respectivas sumas.

### Explicación de la solución

En una matriz cuadrada existen dos diagonales principales.

La diagonal principal está formada por los elementos cuyo índice de fila coincide con el índice de columna:

```text
matrix[0][0]
matrix[1][1]
matrix[2][2]
matrix[3][3]
```

Por tanto, basta con utilizar un único índice para acceder a ambas dimensiones:

`matrix[i][i]`

La diagonal secundaria sigue un patrón diferente.

El índice de fila aumenta, pero el índice de columna disminuye.

En una matriz de 4 por 4 tenemos:

```text
matrix[0][3]
matrix[1][2]
matrix[2][1]
matrix[3][0]
```

La columna se obtiene mediante:

`matrix.length - 1 - i`

Esto nos permite recorrer ambas diagonales utilizando un único bucle.

### Código

```java
int[][] matrix = new int[4][4];

for (int row = 0; row < matrix.length; row++) {

    for (int col = 0; col < matrix[row].length; col++) {
        matrix[row][col] = (int) (Math.random() * 50) + 1;
    }
}

IO.println("Matriz:");

for (int row = 0; row < matrix.length; row++) {

    for (int col = 0; col < matrix[row].length; col++) {
        IO.print(matrix[row][col] + "\t");
    }

    IO.println();
}

int mainSum = 0;
int secondarySum = 0;

IO.print("\nDiagonal principal: ");

for (int i = 0; i < matrix.length; i++) {

    IO.print(matrix[i][i] + " ");

    mainSum += matrix[i][i];
}

IO.println("\nSuma principal: " + mainSum);

IO.print("\nDiagonal secundaria: ");

for (int i = 0; i < matrix.length; i++) {

    int value = matrix[i][matrix.length - 1 - i];

    IO.print(value + " ");

    secondarySum += value;
}

IO.println("\nSuma secundaria: " + secondarySum);
```

### Aspectos importantes

- La diagonal principal utiliza `matrix[i][i]`.
- La diagonal secundaria utiliza `matrix[i][n - 1 - i]`.
- Estas expresiones funcionan para matrices cuadradas.
- No necesitamos utilizar dos bucles para recorrer las diagonales.

---

## Ejercicio 16. Matriz transpuesta

### Planteamiento

Tenemos una matriz de 3 filas y 4 columnas.

Debemos construir otra matriz que sea su transpuesta.

La matriz resultante tendrá 4 filas y 3 columnas.

### Explicación de la solución

La transpuesta de una matriz se obtiene intercambiando las filas por las columnas.

Esto significa que un elemento que estaba en:

`matrix[row][col]`

Pasa a estar en:

`transposed[col][row]`

Por tanto, para construir la matriz transpuesta basta con recorrer la matriz original y copiar cada elemento intercambiando sus índices.

Es importante declarar la segunda matriz con las dimensiones invertidas.

Si la original tiene 3 filas y 4 columnas, la transpuesta debe tener 4 filas y 3 columnas.

### Código

```java
int[][] matrix = new int[3][4];
int[][] transposed = new int[4][3];

for (int row = 0; row < matrix.length; row++) {

    for (int col = 0; col < matrix[row].length; col++) {

        matrix[row][col] = (int) (Math.random() * 20) + 1;

        transposed[col][row] = matrix[row][col];
    }
}

IO.println("Matriz original:");

for (int row = 0; row < matrix.length; row++) {

    for (int col = 0; col < matrix[row].length; col++) {
        IO.print(matrix[row][col] + "\t");
    }

    IO.println();
}

IO.println("\nMatriz transpuesta:");

for (int row = 0; row < transposed.length; row++) {

    for (int col = 0; col < transposed[row].length; col++) {
        IO.print(transposed[row][col] + "\t");
    }

    IO.println();
}
```

### Aspectos importantes

- Las dimensiones de la matriz transpuesta están invertidas.
- El índice de fila se convierte en índice de columna.
- El índice de columna se convierte en índice de fila.
- La expresión fundamental es `transposed[col][row]`.

---

## Ejercicio 17. Buscar un valor en una matriz

### Planteamiento

Tenemos una matriz de 5 filas y 5 columnas.

Debemos buscar todas las apariciones de un número introducido por el usuario.

### Explicación de la solución

El procedimiento es similar a buscar un elemento en un array unidimensional, pero ahora necesitamos recorrer dos dimensiones.

Utilizamos dos bucles anidados para visitar todas las posiciones de la matriz.

Cada vez que encontramos el valor buscado:

1. Mostramos sus coordenadas.
2. Incrementamos un contador.

Al terminar el recorrido, el contador nos permite saber cuántas veces aparece el número.

Si el contador sigue valiendo cero, significa que no hemos encontrado ninguna aparición.

### Código

```java
int[][] matrix = new int[5][5];

for (int row = 0; row < matrix.length; row++) {

    for (int col = 0; col < matrix[row].length; col++) {
        matrix[row][col] = (int) (Math.random() * 10) + 1;
    }
}

IO.println("Matriz:");

for (int row = 0; row < matrix.length; row++) {

    for (int col = 0; col < matrix[row].length; col++) {
        IO.print(matrix[row][col] + "\t");
    }

    IO.println();
}

int target = Integer.parseInt(IO.readln("Número que buscar: "));

int frequency = 0;

for (int row = 0; row < matrix.length; row++) {

    for (int col = 0; col < matrix[row].length; col++) {

        if (matrix[row][col] == target) {

            IO.println("Encontrado en [" + row + "][" + col + "]");

            frequency++;
        }
    }
}

if (frequency == 0) {
    IO.println("El número no aparece.");
} else {
    IO.println("Apariciones: " + frequency);
}
```

### Aspectos importantes

- Necesitamos dos índices para recorrer la matriz.
- El contador se incrementa cada vez que encontramos una coincidencia.
- No debemos detener la búsqueda al encontrar la primera aparición, porque queremos conocer todas las posiciones.

---

## Ejercicio 18. Registro de temperaturas

### Planteamiento

Una estación meteorológica registra las temperaturas de cuatro ciudades durante siete días.

Utilizamos una matriz de 4 filas y 7 columnas:

- Cada fila representa una ciudad.
- Cada columna representa un día.

Debemos calcular las medias por ciudad y por día, además de encontrar las temperaturas máxima y mínima.

### Explicación de la solución

Este ejercicio combina varios de los recorridos que hemos visto anteriormente.

Primero rellenamos la matriz con temperaturas aleatorias.

Mientras la rellenamos, podemos ir buscando la temperatura máxima y mínima.

Para ello necesitamos guardar:

- El valor máximo.
- La fila y columna donde aparece.
- El valor mínimo.
- La fila y columna donde aparece.

Inicializamos el máximo con `Integer.MIN_VALUE` y el mínimo con `Integer.MAX_VALUE`. Así nos aseguramos de que cualquier temperatura generada pueda sustituirlos.

Después calculamos las medias.

Para obtener la media de una ciudad, recorremos una fila completa y sumamos sus siete temperaturas.

Para obtener la media de un día, recorremos una columna completa y sumamos las temperaturas de las cuatro ciudades.

Observa que el recorrido es el mismo que utilizamos en el ejercicio de sumas por filas y columnas.

### Código

```java
int[][] temperatures = new int[4][7];

int maximum = Integer.MIN_VALUE;
int minimum = Integer.MAX_VALUE;

int maxCity = 0;
int maxDay = 0;

int minCity = 0;
int minDay = 0;

// Rellenamos la matriz y buscamos máximo y mínimo.
for (int city = 0; city < temperatures.length; city++) {

    for (int day = 0; day < temperatures[city].length; day++) {

        temperatures[city][day] =
            (int) (Math.random() * 31) + 5;

        int temperature = temperatures[city][day];

        if (temperature > maximum) {

            maximum = temperature;

            maxCity = city;
            maxDay = day;
        }

        if (temperature < minimum) {

            minimum = temperature;

            minCity = city;
            minDay = day;
        }
    }
}

// Mostramos las temperaturas.
IO.println("Temperaturas:");

for (int city = 0; city < temperatures.length; city++) {

    IO.print("Ciudad " + city + ": ");

    for (int day = 0; day < temperatures[city].length; day++) {
        IO.print(temperatures[city][day] + " ");
    }

    IO.println();
}

// Calculamos la media de cada ciudad.
IO.println("\nMedia por ciudad:");

for (int city = 0; city < temperatures.length; city++) {

    int sum = 0;

    for (int day = 0; day < temperatures[city].length; day++) {
        sum += temperatures[city][day];
    }

    double average = (double) sum / temperatures[city].length;

    IO.println("Ciudad " + city + ": " + average);
}

// Calculamos la media de cada día.
IO.println("\nMedia por día:");

for (int day = 0; day < temperatures[0].length; day++) {

    int sum = 0;

    for (int city = 0; city < temperatures.length; city++) {
        sum += temperatures[city][day];
    }

    double average = (double) sum / temperatures.length;

    IO.println("Día " + day + ": " + average);
}

// Mostramos máximo y mínimo.
IO.println("\nTemperatura máxima: " + maximum);
IO.println("Ciudad: " + maxCity + ", día: " + maxDay);

IO.println("Temperatura mínima: " + minimum);
IO.println("Ciudad: " + minCity + ", día: " + minDay);
```

### Aspectos importantes

- Para calcular la media de una fila, recorremos sus columnas.
- Para calcular la media de una columna, recorremos sus filas.
- Las variables `maxCity` y `maxDay` permiten conservar la posición del máximo.
- Las variables `minCity` y `minDay` permiten conservar la posición del mínimo.
- La matriz permite representar información organizada en dos dimensiones.

---

## Ejercicio 19. Juego del tres en raya

### Planteamiento

Vamos a desarrollar un juego del tres en raya para dos jugadores.

El tablero tendrá tres filas y tres columnas.

Los jugadores utilizarán los símbolos `X` y `O`.

El juego terminará cuando uno de los jugadores consiga tres símbolos en línea o cuando se ocupen todas las posiciones.

### Explicación de la solución

Utilizamos una matriz de caracteres:

`char[][] board`

Cada posición representa una casilla del tablero.

Inicialmente todas las casillas contienen un espacio en blanco.

También necesitamos controlar:

- El jugador que tiene el turno.
- El número de movimientos realizados.
- Si ya existe un ganador.

El juego se ejecuta dentro de un bucle `while`.

La condición permite continuar mientras no exista un ganador y queden posiciones disponibles.

En cada turno solicitamos una fila y una columna.

Antes de colocar el símbolo comprobamos que:

1. La fila y la columna estén dentro de los límites.
2. La posición todavía esté vacía.

Si el movimiento es válido, colocamos el símbolo del jugador y aumentamos el número de movimientos.

Después comprobamos las posibles combinaciones ganadoras.

Existen ocho posibilidades:

- Tres filas.
- Tres columnas.
- Dos diagonales.

Si encontramos una línea con tres símbolos iguales al del jugador actual, establecemos `winner = true`.

Si no hay ganador, cambiamos el turno.

Es importante que los movimientos incorrectos no incrementen el contador de movimientos ni cambien el jugador.

### Código

```java
char[][] board = new char[3][3];

// Inicializamos el tablero.
for (int row = 0; row < board.length; row++) {

    for (int col = 0; col < board[row].length; col++) {
        board[row][col] = ' ';
    }
}

char player = 'X';

boolean winner = false;

int moves = 0;

while (!winner && moves < 9) {

    // Mostramos el tablero.
    IO.println("\nTablero:");

    for (int row = 0; row < board.length; row++) {

        for (int col = 0; col < board[row].length; col++) {

            IO.print(" " + board[row][col] + " ");

            if (col < 2) {
                IO.print("|");
            }
        }

        IO.println();

        if (row < 2) {
            IO.println("---+---+---");
        }
    }

    IO.println("\nTurno del jugador " + player);

    int row = Integer.parseInt(IO.readln("Fila (0-2): "));
    int col = Integer.parseInt(IO.readln("Columna (0-2): "));

    if (row < 0 || row >= 3 || col < 0 || col >= 3) {

        IO.println("Posición incorrecta.");

    } else if (board[row][col] != ' ') {

        IO.println("Esa posición ya está ocupada.");

    } else {

        // Colocamos el símbolo.
        board[row][col] = player;

        moves++;

        boolean line = false;

        // Comprobamos las filas.
        for (int i = 0; i < 3; i++) {

            if (board[i][0] == player &&
                board[i][1] == player &&
                board[i][2] == player) {

                line = true;
            }
        }

        // Comprobamos las columnas.
        for (int i = 0; i < 3; i++) {

            if (board[0][i] == player &&
                board[1][i] == player &&
                board[2][i] == player) {

                line = true;
            }
        }

        // Comprobamos la diagonal principal.
        if (board[0][0] == player &&
            board[1][1] == player &&
            board[2][2] == player) {

            line = true;
        }

        // Comprobamos la diagonal secundaria.
        if (board[0][2] == player &&
            board[1][1] == player &&
            board[2][0] == player) {

            line = true;
        }

        if (line) {

            winner = true;

        } else if (player == 'X') {

            player = 'O';

        } else {

            player = 'X';
        }
    }
}

// Mostramos el tablero final.
IO.println("\nTablero final:");

for (int row = 0; row < board.length; row++) {

    for (int col = 0; col < board[row].length; col++) {

        IO.print(" " + board[row][col] + " ");

        if (col < 2) {
            IO.print("|");
        }
    }

    IO.println();

    if (row < 2) {
        IO.println("---+---+---");
    }
}

if (winner) {

    IO.println("Ha ganado el jugador " + player);

} else {

    IO.println("Empate.");
}
```

### Aspectos importantes

- Una matriz de caracteres permite representar fácilmente el tablero.
- El espacio `' '` representa una casilla vacía.
- El contador `moves` permite detectar el empate.
- El jugador solo cambia después de un movimiento válido.
- Las condiciones de victoria utilizan los operadores lógicos `&&`.
- Para comprobar las filas y columnas utilizamos bucles.
- Las diagonales se comprueban directamente mediante sus coordenadas.

---

## Ejercicio 20. Gestión de asientos de un cine

### Planteamiento

Un cine dispone de una sala con seis filas y ocho asientos por fila.

Tenemos que desarrollar un programa que permita consultar, reservar y cancelar asientos.

### Explicación de la solución

Utilizamos una matriz de valores booleanos:

`boolean[][] seats`

Cada posición representa un asiento.

Los valores posibles son:

- `false`: asiento libre.
- `true`: asiento ocupado.

El programa debe mostrar un menú y repetirlo hasta que el usuario seleccione la opción de salir.

Para conseguirlo utilizamos un bucle `do-while`.

Dentro del bucle utilizamos una estructura `switch` para ejecutar la operación correspondiente.

Cada opción tiene un comportamiento diferente:

**Opción 1. Mostrar todos los asientos**

Recorremos la matriz completa.

Si una posición contiene `true`, mostramos una X. Si contiene `false`, mostramos una casilla vacía.

**Opción 2. Reservar un asiento**

Solicitamos la fila y la columna.

Primero comprobamos que los índices sean válidos. Después comprobamos si el asiento ya está ocupado.

Si está libre, cambiamos su valor a `true`.

**Opción 3. Cancelar una reserva**

Realizamos las mismas comprobaciones de índices.

Si el asiento está ocupado, cambiamos su valor a `false`.

**Opción 4. Consultar un asiento**

Comprobamos el valor booleano de la posición solicitada y mostramos su estado.

**Opción 5. Mostrar los asientos libres**

Recorremos toda la matriz y contamos cuántos elementos contienen `false`.

**Opción 6. Salir**

El programa termina cuando el usuario selecciona esta opción.

### Código

```java
boolean[][] seats = new boolean[6][8];

int option;

do {

    IO.println("\nGESTIÓN DE ASIENTOS");

    IO.println("1. Mostrar todos los asientos");
    IO.println("2. Reservar un asiento");
    IO.println("3. Cancelar una reserva");
    IO.println("4. Consultar un asiento");
    IO.println("5. Mostrar número de asientos libres");
    IO.println("6. Salir");

    option = Integer.parseInt(IO.readln("Opción: "));

    switch (option) {

        case 1 -> {

            IO.println("\nAsientos:");

            for (int row = 0; row < seats.length; row++) {

                for (int col = 0; col < seats[row].length; col++) {

                    if (seats[row][col]) {
                        IO.print("[X] ");
                    } else {
                        IO.print("[ ] ");
                    }
                }

                IO.println();
            }
        }

        case 2 -> {

            int row = Integer.parseInt(IO.readln("Fila (0-5): "));
            int col = Integer.parseInt(IO.readln("Columna (0-7): "));

            if (row < 0 || row >= seats.length ||
                col < 0 || col >= seats[row].length) {

                IO.println("Posición incorrecta.");

            } else if (seats[row][col]) {

                IO.println("El asiento ya está ocupado.");

            } else {

                seats[row][col] = true;

                IO.println("Reserva realizada.");
            }
        }

        case 3 -> {

            int row = Integer.parseInt(IO.readln("Fila (0-5): "));
            int col = Integer.parseInt(IO.readln("Columna (0-7): "));

            if (row < 0 || row >= seats.length ||
                col < 0 || col >= seats[row].length) {

                IO.println("Posición incorrecta.");

            } else if (!seats[row][col]) {

                IO.println("El asiento ya está libre.");

            } else {

                seats[row][col] = false;

                IO.println("Reserva cancelada.");
            }
        }

        case 4 -> {

            int row = Integer.parseInt(IO.readln("Fila (0-5): "));
            int col = Integer.parseInt(IO.readln("Columna (0-7): "));

            if (row < 0 || row >= seats.length ||
                col < 0 || col >= seats[row].length) {

                IO.println("Posición incorrecta.");

            } else if (seats[row][col]) {

                IO.println("El asiento está ocupado.");

            } else {

                IO.println("El asiento está libre.");
            }
        }

        case 5 -> {

            int freeSeats = 0;

            for (int row = 0; row < seats.length; row++) {

                for (int col = 0; col < seats[row].length; col++) {

                    if (!seats[row][col]) {
                        freeSeats++;
                    }
                }
            }

            IO.println("Asientos libres: " + freeSeats);
        }

        case 6 -> {

            IO.println("Saliendo del programa.");
        }

        default -> {

            IO.println("Opción incorrecta.");
        }
    }

} while (option != 6);
```

### Aspectos importantes

- Una matriz booleana permite representar estados de manera sencilla.
- El valor `false` es el valor inicial de todos los elementos de un array booleano.
- El menú se repite mediante un bucle `do-while`.
- La estructura `switch` permite separar las distintas operaciones.
- La validación de los índices debe realizarse antes de acceder a la matriz.
- El operador `||` permite comprobar si alguna de las coordenadas está fuera de los límites.
- El operador `!` permite comprobar si un asiento está libre.

---

# Resumen didáctico

Los ejercicios anteriores permiten trabajar diferentes técnicas de manipulación de arrays.

## Arrays unidimensionales

| Ejercicio | Concepto principal |
|---|---|
| 1 | Desplazamiento de elementos |
| 2 | Rotación circular y módulo |
| 3 | Inserción de elementos |
| 4 | Eliminación de elementos |
| 5 | Búsqueda de máximos y segundos valores |
| 6 | Frecuencia de aparición |
| 7 | Eliminación de duplicados |
| 8 | Construcción de arrays mediante otros arrays |
| 9 | Ordenación por selección |
| 10 | Fusión de arrays ordenados |

## Arrays multidimensionales

| Ejercicio | Concepto principal |
|---|---|
| 11 | Declaración y recorrido de matrices |
| 12 | Rellenar matrices |
| 13 | Acumulación de valores |
| 14 | Recorrido por filas y columnas |
| 15 | Diagonales de matrices cuadradas |
| 16 | Matriz transpuesta |
| 17 | Búsqueda en matrices |
| 18 | Tratamiento de datos organizados en dos dimensiones |
| 19 | Aplicación de matrices a un juego |
| 20 | Gestión de información mediante una matriz booleana |

## Conceptos especialmente importantes que deben dominar

1. Diferenciar entre la capacidad de un array y el número de elementos ocupados.
2. Saber cuándo recorrer un array de izquierda a derecha o de derecha a izquierda.
3. Utilizar variables auxiliares para intercambiar o conservar valores.
4. Comprender el funcionamiento de los índices.
5. Utilizar correctamente los bucles anidados.
6. Diferenciar entre recorrer una fila y recorrer una columna.
7. Comprender que una matriz utiliza dos índices.
8. Saber obtener las dimensiones de una matriz mediante `length`.
9. Aplicar condiciones para validar las posiciones antes de acceder a ellas.
10. Utilizar arrays como estructuras para representar problemas reales.