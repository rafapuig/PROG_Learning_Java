# Retos de programación con arrays y matrices

Java 26 · 1.º DAW

## Indicaciones generales

- Los ejercicios se resolverán utilizando arrays y matrices.
- No se permite utilizar colecciones como `ArrayList`, `HashSet` o `HashMap`.
- No se permite utilizar métodos propios ni clases auxiliares.
- Se pueden utilizar variables, operadores, condicionales y bucles.
- Salvo que el enunciado indique lo contrario, no se permite utilizar arrays auxiliares para resolver el problema.
- Todos los programas deben mostrar resultados comprensibles.

Los ejercicios están ordenados aproximadamente por dificultad. Algunos son especialmente exigentes y pueden plantearse como retos voluntarios.

---

# 1. Valores más frecuentes

## Enunciado

Dado un array de números enteros, encuentra todos los valores que aparecen el mayor número de veces.

No debes mostrar varias veces un mismo valor, aunque aparezca repetido en el array.

Por ejemplo:

```java
int[] numbers = {4, 2, 7, 4, 3, 2, 4, 2, 8};
```

El resultado sería:

```text
Valores más frecuentes:
4
2
Frecuencia: 3
```

En este caso, tanto el 4 como el 2 aparecen tres veces.

## Restricciones

- No se permite utilizar arrays auxiliares.
- No se permite ordenar el array.
- No se debe mostrar varias veces un mismo valor.
- Se deben resolver los empates.

## Solución

```java
void main() {
    int[] numbers = {4, 2, 7, 4, 3, 2, 4, 2, 8};

    int maxFrequency = 0;

    // Primera pasada: encontrar la frecuencia máxima.
    for (int i = 0; i < numbers.length; i++) {
        int frequency = 0;

        for (int j = 0; j < numbers.length; j++) {
            if (numbers[i] == numbers[j]) {
                frequency++;
            }
        }

        if (frequency > maxFrequency) {
            maxFrequency = frequency;
        }
    }

    // Segunda pasada: mostrar los valores con frecuencia máxima.
    IO.println("Valores más frecuentes:");

    for (int i = 0; i < numbers.length; i++) {
        boolean appearedBefore = false;

        for (int j = 0; j < i; j++) {
            if (numbers[i] == numbers[j]) {
                appearedBefore = true;
                break;
            }
        }

        if (!appearedBefore) {
            int frequency = 0;

            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    frequency++;
                }
            }

            if (frequency == maxFrequency) {
                IO.println(numbers[i]);
            }
        }
    }

    IO.println("Frecuencia: " + maxFrequency);
}
```

**Qué se practica:** recorridos anidados, búsqueda de duplicados, contadores y resolución de empates.

---

# 2. Comparación de dos arrays

## Enunciado

Disponemos de dos arrays de la misma longitud que contienen números enteros.

Debes comparar ambos arrays y calcular:

1. Cuántas posiciones contienen valores diferentes.
2. Cuántas posiciones contienen valores iguales.
3. El porcentaje de coincidencias entre ambos arrays.

Por ejemplo:

```java
int[] first = {4, 8, 2, 9, 5, 1};
int[] second = {4, 3, 2, 7, 5, 6};
```

Resultado:

```text
Posiciones iguales: 3
Posiciones diferentes: 3
Porcentaje de coincidencias: 50.0 %
```

## Restricciones

- No se permite crear un tercer array.
- Los dos arrays tienen la misma longitud.
- Se deben comparar los elementos que ocupan la misma posición.

## Solución

```java
void main() {
    int[] first = {4, 8, 2, 9, 5, 1};
    int[] second = {4, 3, 2, 7, 5, 6};

    int equalPositions = 0;
    int differentPositions = 0;

    for (int i = 0; i < first.length; i++) {
        if (first[i] == second[i]) {
            equalPositions++;
        } else {
            differentPositions++;
        }
    }

    double percentage = equalPositions * 100.0 / first.length;

    IO.println("Posiciones iguales: " + equalPositions);
    IO.println("Posiciones diferentes: " + differentPositions);
    IO.println("Porcentaje de coincidencias: " + percentage + " %");
}
```

**Qué se practica:** recorridos paralelos de arrays y cálculos porcentuales.

---

# 3. Eliminar todas las apariciones de un valor

## Enunciado

Tenemos un array que puede contener elementos repetidos y queremos eliminar todas las apariciones de un determinado valor.

Sin embargo, no podemos crear otro array.

Para resolver el problema utilizaremos una variable `size` que indica cuántas posiciones del array contienen datos válidos.

Por ejemplo:

```java
int[] numbers = {4, 7, 2, 7, 9, 7, 3, 5};
int size = 8;
int value = 7;
```

Después de eliminar todos los 7, el array debe quedar conceptualmente así:

```text
{4, 2, 9, 3, 5}
```

Y el tamaño lógico será 5.

Las posiciones posteriores a `size - 1` no deben tenerse en cuenta.

## Restricciones

- No se permite crear otro array.
- No se permite utilizar otro array como almacenamiento temporal.
- Se deben eliminar todas las apariciones.
- Se debe actualizar el tamaño lógico.

## Solución

```java
void main() {
    int[] numbers = {4, 7, 2, 7, 9, 7, 3, 5};
    int size = 8;
    int value = 7;

    int i = 0;

    while (i < size) {
        if (numbers[i] == value) {

            // Desplazar los elementos posteriores una posición.
            for (int j = i; j < size - 1; j++) {
                numbers[j] = numbers[j + 1];
            }

            size--;

            // No incrementamos i porque ahora ocupa
            // esa posición un elemento que todavía
            // debemos comprobar.
        } else {
            i++;
        }
    }

    IO.println("Array resultante:");

    for (int j = 0; j < size; j++) {
        IO.print(numbers[j] + " ");
    }

    IO.println();
    IO.println("Nuevo tamaño lógico: " + size);
}
```

**Qué se practica:** desplazamiento de elementos, eliminación lógica, índices y control de límites.

---

# 4. Rotación circular de un array

## Enunciado

Dado un array de números enteros, debes realizar una rotación circular de sus elementos.

Una rotación a la derecha desplaza todos los elementos una posición hacia la derecha. El último elemento pasa a ocupar la primera posición.

Por ejemplo, partiendo de:

```text
{1, 2, 3, 4, 5}
```

Una rotación a la derecha produce:

```text
{5, 1, 2, 3, 4}
```

Dos rotaciones producen:

```text
{4, 5, 1, 2, 3}
```

El número de posiciones puede ser:

- Positivo: rotación a la derecha.
- Negativo: rotación a la izquierda.
- Mayor que la longitud del array.

Por ejemplo, rotar 12 posiciones a la derecha un array de longitud 5 equivale a rotarlo 2 posiciones.

## Restricciones

- No se permite crear otro array.
- Debes modificar el array original.
- Debes contemplar valores positivos, negativos y mayores que la longitud.
- La solución debe funcionar con arrays de cualquier longitud, incluido el array vacío.

## Solución

Una forma interesante de resolverlo consiste en invertir partes del array.

Para rotar a la derecha tres posiciones:

```text
Original:
1 2 3 4 5 6 7

Invertir todo:
7 6 5 4 3 2 1

Invertir los tres primeros:
5 6 7 4 3 2 1

Invertir el resto:
5 6 7 1 2 3 4
```

Código:

```java
void main() {
    int[] numbers = {1, 2, 3, 4, 5, 6, 7};
    int k = 3;

    int n = numbers.length;

    if (n > 0) {
        // Normalizar el número de rotaciones.
        int rotations = ((k % n) + n) % n;

        // Invertir todo el array.
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int temp = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temp;

            left++;
            right--;
        }

        // Invertir las primeras rotations posiciones.
        left = 0;
        right = rotations - 1;

        while (left < right) {
            int temp = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temp;

            left++;
            right--;
        }

        // Invertir el resto del array.
        left = rotations;
        right = n - 1;

        while (left < right) {
            int temp = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temp;

            left++;
            right--;
        }
    }

    for (int number : numbers) {
        IO.print(number + " ");
    }

    IO.println();
}
```

**Qué se practica:** intercambio de elementos, inversión de arrays, aritmética modular y tratamiento de índices.

---

# 5. Fusionar dos arrays ordenados

## Enunciado

Disponemos de dos arrays de números enteros que ya están ordenados de menor a mayor.

Debes construir un tercer array que contenga todos los elementos de ambos arrays, también ordenados de menor a mayor.

Por ejemplo:

```java
int[] first = {1, 4, 7, 9};
int[] second = {2, 3, 7, 8, 10};
```

El resultado debe ser:

```text
{1, 2, 3, 4, 7, 7, 8, 9, 10}
```

Observa que los elementos repetidos deben conservarse.

## Restricciones

- Los arrays originales no se pueden modificar.
- Se debe crear un tercer array.
- No se permite ordenar el array resultante mediante otro algoritmo de ordenación.
- Debes aprovechar que los dos arrays originales ya están ordenados.

## Solución

La idea consiste en mantener tres índices:

- `i`: posición actual del primer array.
- `j`: posición actual del segundo array.
- `k`: posición donde insertar el siguiente elemento en el resultado.

```java
void main() {
    int[] first = {1, 4, 7, 9};
    int[] second = {2, 3, 7, 8, 10};

    int[] result = new int[first.length + second.length];

    int i = 0;
    int j = 0;
    int k = 0;

    // Fusionar mientras queden elementos en ambos arrays.
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

    // Copiar los elementos restantes del primer array.
    while (i < first.length) {
        result[k] = first[i];
        i++;
        k++;
    }

    // Copiar los elementos restantes del segundo array.
    while (j < second.length) {
        result[k] = second[j];
        j++;
        k++;
    }

    for (int number : result) {
        IO.print(number + " ");
    }

    IO.println();
}
```

**Qué se practica:** recorridos simultáneos, índices independientes y aprovechamiento del orden previo de los datos.

---

# 6. La secuencia consecutiva más larga

## Enunciado

Dado un array de números enteros desordenados, encuentra la longitud de la secuencia de números consecutivos más larga.

Los números de una secuencia consecutiva no tienen que estar juntos en el array.

Por ejemplo:

```java
int[] numbers = {100, 4, 200, 1, 3, 2, 5, 10};
```

La secuencia consecutiva más larga es:

```text
1, 2, 3, 4, 5
```

Por tanto, su longitud es 5.

Otro ejemplo:

```java
int[] numbers = {8, 3, 4, 10, 5, 9, 2, 7};
```

Existen dos secuencias de longitud 4:

```text
2, 3, 4, 5
7, 8, 9, 10
```

El resultado debe ser 4.

## Restricciones

- No se permite ordenar el array.
- No se permite utilizar arrays auxiliares.
- No se permite utilizar colecciones.
- Debes contemplar que puede haber valores repetidos.

## Solución

Para evitar contar una misma secuencia varias veces, solo comenzaremos a contar desde un número cuando su predecesor no exista en el array.

Por ejemplo, si encontramos el número 4, pero también existe el 3, no empezaremos una secuencia desde el 4.

```java
void main() {
    int[] numbers = {100, 4, 200, 1, 3, 2, 5, 10};

    int maxLength = 0;

    for (int i = 0; i < numbers.length; i++) {
        int value = numbers[i];

        boolean hasPrevious = false;

        // Comprobar si existe value - 1.
        for (int j = 0; j < numbers.length; j++) {
            if ((long) numbers[j] == (long) value - 1) {
                hasPrevious = true;
                break;
            }
        }

        if (!hasPrevious) {
            int length = 1;
            long next = (long) value + 1;

            // Buscar los siguientes valores consecutivos.
            while (true) {
                boolean found = false;

                for (int j = 0; j < numbers.length; j++) {
                    if (numbers[j] == next) {
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    break;
                }

                length++;
                next++;
            }

            if (length > maxLength) {
                maxLength = length;
            }
        }
    }

    IO.println("Longitud de la secuencia más larga: " + maxLength);
}
```

**Qué se practica:** búsquedas repetidas, razonamiento algorítmico y eliminación de trabajo redundante.

**Ampliación:** mostrar todas las secuencias que tengan la longitud máxima.

---

# 7. Encontrar el elemento mayoritario

## Enunciado

Un elemento mayoritario es aquel que aparece en un array más de la mitad de las veces.

Por ejemplo:

```java
int[] numbers = {3, 3, 4, 2, 3, 3, 5, 3};
```

El número 3 aparece cinco veces en un array de ocho elementos.

Como cinco es mayor que ocho dividido entre dos, el 3 es el elemento mayoritario.

Sin embargo:

```java
int[] numbers = {1, 2, 3, 2, 1, 3};
```

No existe ningún elemento mayoritario.

## Restricciones

- No se permite ordenar el array.
- No se permite utilizar arrays auxiliares.
- No se permite utilizar colecciones.
- Debes comprobar que realmente existe un elemento mayoritario.

## Solución

Utilizaremos el algoritmo de Boyer-Moore.

La idea es mantener un candidato y un contador:

- Si el contador es cero, el siguiente elemento se convierte en candidato.
- Si encontramos el candidato, incrementamos el contador.
- Si encontramos otro valor, lo decrementamos.

Al terminar tendremos un posible candidato, pero todavía debemos verificar que aparece más de la mitad de las veces.

```java
void main() {
    int[] numbers = {3, 3, 4, 2, 3, 3, 5, 3};

    int candidate = 0;
    int count = 0;

    // Primera pasada: encontrar un posible candidato.
    for (int number : numbers) {
        if (count == 0) {
            candidate = number;
            count = 1;
        } else if (number == candidate) {
            count++;
        } else {
            count--;
        }
    }

    // Segunda pasada: verificar el candidato.
    int frequency = 0;

    for (int number : numbers) {
        if (number == candidate) {
            frequency++;
        }
    }

    if (frequency > numbers.length / 2) {
        IO.println("Elemento mayoritario: " + candidate);
    } else {
        IO.println("No existe elemento mayoritario.");
    }
}
```

**Qué se practica:** diseño de algoritmos, contadores y separación entre obtener un candidato y verificar una condición.

---

# 8. Parejas cuya suma sea un objetivo

## Enunciado

Dado un array de números enteros y un valor objetivo, encuentra todas las parejas de posiciones distintas cuyos elementos sumen ese objetivo.

Por ejemplo:

```java
int[] numbers = {2, 7, 4, 5, 3, 8, 1};
int target = 9;
```

Las parejas de valores son:

```text
2 + 7 = 9
4 + 5 = 9
8 + 1 = 9
```

Debes mostrar las posiciones de los elementos que forman cada pareja.

## Restricciones

- No se permite ordenar el array.
- No se permite crear otro array.
- No se deben mostrar dos veces las mismas posiciones.
- La posición del primer elemento debe ser siempre menor que la del segundo.

## Solución

```java
void main() {
    int[] numbers = {2, 7, 4, 5, 3, 8, 1};
    int target = 9;

    for (int i = 0; i < numbers.length; i++) {
        for (int j = i + 1; j < numbers.length; j++) {
            if (numbers[i] + numbers[j] == target) {
                IO.println(
                    "Posiciones " + i + " y " + j
                    + ": " + numbers[i] + " + " + numbers[j]
                );
            }
        }
    }
}
```

**Qué se practica:** bucles anidados, combinaciones de elementos y control de índices para evitar duplicados.

**Ampliación:** resolver el problema cuando el array está ordenado, intentando reducir el número de comparaciones.

---

# 9. La pareja cuya suma está más cerca del objetivo

## Enunciado

Dado un array de números enteros y un valor objetivo, encuentra la pareja de elementos cuya suma esté más cerca del objetivo.

Por ejemplo:

```java
int[] numbers = {2, 8, 4, 15, 7, 3};
int target = 12;
```

Una de las mejores parejas es:

```text
8 + 4 = 12
```

La diferencia respecto al objetivo es cero.

Si ninguna pareja suma exactamente el objetivo, debes encontrar la que produzca la menor diferencia absoluta.

Por ejemplo:

```java
int[] numbers = {1, 4, 8, 10};
int target = 13;
```

La pareja más cercana es:

```text
4 + 10 = 14
Diferencia: 1
```

## Restricciones

- No se permite ordenar el array.
- No se permite crear arrays auxiliares.
- No se pueden utilizar dos veces las mismas posiciones.
- Si hay varias parejas con la misma diferencia mínima, puedes mostrar cualquiera de ellas.

## Solución

```java
void main() {
    int[] numbers = {2, 8, 4, 15, 7, 3};
    int target = 12;

    long minDifference = Long.MAX_VALUE;

    int firstValue = 0;
    int secondValue = 0;

    int firstPosition = -1;
    int secondPosition = -1;

    for (int i = 0; i < numbers.length; i++) {
        for (int j = i + 1; j < numbers.length; j++) {

            long sum = (long) numbers[i] + numbers[j];
            long difference = Math.abs(sum - target);

            if (difference < minDifference) {
                minDifference = difference;

                firstValue = numbers[i];
                secondValue = numbers[j];

                firstPosition = i;
                secondPosition = j;
            }
        }
    }

    if (firstPosition == -1) {
        IO.println("No hay suficientes elementos.");
    } else {
        IO.println(
            "Pareja: " + firstValue + " + " + secondValue
        );

        IO.println(
            "Posiciones: " + firstPosition + " y " + secondPosition
        );

        IO.println("Diferencia: " + minDifference);
    }
}
```

**Qué se practica:** búsqueda exhaustiva, comparación de resultados y cálculo de diferencias.

---

# 10. Ordenar por frecuencia

## Enunciado

Dado un array de números enteros, debes ordenar sus valores distintos según su frecuencia de aparición, de mayor a menor.

Cuando dos valores tengan la misma frecuencia, se debe mantener el orden en el que aparecieron por primera vez en el array original.

Por ejemplo:

```java
int[] numbers = {4, 2, 4, 3, 2, 4, 5, 3, 2, 8};
```

Las frecuencias son:

```text
4 aparece 3 veces
2 aparece 3 veces
3 aparece 2 veces
5 aparece 1 vez
8 aparece 1 vez
```

El resultado será:

```text
4: 3 veces
2: 3 veces
3: 2 veces
5: 1 vez
8: 1 vez
```

Observa que el 4 aparece antes que el 2 en el array original. Como ambos tienen la misma frecuencia, el 4 debe mantenerse delante.

## Restricciones

- No se permiten colecciones.
- Se pueden utilizar arrays auxiliares.
- No se debe contar varias veces la frecuencia de un mismo valor.
- Se debe conservar el orden de primera aparición cuando hay empates.

## Solución

Utilizaremos dos arrays auxiliares:

- `values`: contiene cada valor distinto una sola vez.
- `frequencies`: contiene la frecuencia correspondiente a cada valor.

Después ordenaremos ambos arrays conjuntamente mediante una variante estable de Insertion Sort.

```java
void main() {
    int[] numbers = {4, 2, 4, 3, 2, 4, 5, 3, 2, 8};

    int[] values = new int[numbers.length];
    int[] frequencies = new int[numbers.length];

    int size = 0;

    // Construir los arrays de valores únicos y frecuencias.
    for (int i = 0; i < numbers.length; i++) {
        int position = -1;

        for (int j = 0; j < size; j++) {
            if (values[j] == numbers[i]) {
                position = j;
                break;
            }
        }

        if (position == -1) {
            values[size] = numbers[i];
            frequencies[size] = 1;
            size++;
        } else {
            frequencies[position]++;
        }
    }

    // Ordenar por frecuencia descendente.
    // En los empates se conserva el orden original.
    for (int i = 1; i < size; i++) {
        int keyValue = values[i];
        int keyFrequency = frequencies[i];

        int j = i - 1;

        while (j >= 0 && frequencies[j] < keyFrequency) {
            values[j + 1] = values[j];
            frequencies[j + 1] = frequencies[j];

            j--;
        }

        values[j + 1] = keyValue;
        frequencies[j + 1] = keyFrequency;
    }

    // Mostrar el resultado.
    for (int i = 0; i < size; i++) {
        IO.println(
            values[i] + ": " + frequencies[i] + " veces"
        );
    }
}
```

**Qué se practica:** arrays paralelos, búsqueda de valores, construcción de estructuras auxiliares y ordenación estable.

---

# 11. Ordenar una parte desordenada de un array

## Enunciado

Tenemos un array cuya primera parte ya está ordenada de menor a mayor, mientras que el resto contiene elementos desordenados.

Debes insertar los elementos de la parte desordenada en la parte ordenada utilizando el algoritmo Insertion Sort.

Por ejemplo:

```java
int[] numbers = {2, 4, 7, 9, 3, 1, 8, 5};
int sortedSize = 4;
```

Las primeras cuatro posiciones ya están ordenadas:

```text
2, 4, 7, 9
```

El resto está desordenado:

```text
3, 1, 8, 5
```

El resultado debe ser:

```text
1, 2, 3, 4, 5, 7, 8, 9
```

## Restricciones

- No se permite crear otro array.
- Se debe utilizar el array original.
- No se debe volver a ordenar desde cero la parte que ya estaba ordenada.
- Se debe utilizar la idea de Insertion Sort.

## Solución

```java
void main() {
    int[] numbers = {2, 4, 7, 9, 3, 1, 8, 5};
    int sortedSize = 4;

    // Insertar cada elemento de la parte desordenada
    // en la posición que le corresponda.
    for (int i = sortedSize; i < numbers.length; i++) {
        int key = numbers[i];
        int j = i - 1;

        while (j >= 0 && numbers[j] > key) {
            numbers[j + 1] = numbers[j];
            j--;
        }

        numbers[j + 1] = key;
    }

    for (int number : numbers) {
        IO.print(number + " ");
    }

    IO.println();
}
```

**Qué se practica:** Insertion Sort, desplazamiento de elementos y aprovechamiento de información previa.

---

# 12. Buscaminas

## Enunciado

Vamos a representar un tablero de Buscaminas mediante una matriz de números enteros.

Cada posición puede contener:

- `0`: casilla vacía.
- `1`: casilla con una mina.

Debes crear una segunda matriz que indique cuántas minas hay alrededor de cada casilla.

Se deben comprobar las ocho posiciones vecinas:

```text
┌─────┬─────┬─────┐
│ -1,-1│ -1,0│ -1,1│
├─────┼─────┼─────┤
│ 0,-1│ 0,0 │ 0,1 │
├─────┼─────┼─────┤
│ 1,-1│ 1,0 │ 1,1 │
└─────┴─────┴─────┘
```

La posición central no se cuenta a sí misma.

Por ejemplo, para este tablero:

```text
0 1 0 0
0 0 1 0
1 0 0 0
0 0 0 1
```

El resultado debe ser:

```text
1 * 2 1
2 3 * 1
* 2 2 2
1 1 1 *
```

El símbolo `*` representa una mina.

## Restricciones

- Se debe utilizar una matriz auxiliar para almacenar los resultados.
- Se deben comprobar los límites de la matriz.
- No se pueden consultar posiciones que estén fuera del tablero.

## Solución

```java
void main() {
    int[][] board = {
        {0, 1, 0, 0},
        {0, 0, 1, 0},
        {1, 0, 0, 0},
        {0, 0, 0, 1}
    };

    int rows = board.length;
    int columns = board[0].length;

    int[][] result = new int[rows][columns];

    for (int row = 0; row < rows; row++) {
        for (int column = 0; column < columns; column++) {

            if (board[row][column] == 1) {
                continue;
            }

            int mines = 0;

            // Examinar las ocho posiciones vecinas.
            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {

                    if (dr == 0 && dc == 0) {
                        continue;
                    }

                    int neighborRow = row + dr;
                    int neighborColumn = column + dc;

                    if (neighborRow >= 0
                            && neighborRow < rows
                            && neighborColumn >= 0
                            && neighborColumn < columns) {

                        if (board[neighborRow][neighborColumn] == 1) {
                            mines++;
                        }
                    }
                }
            }

            result[row][column] = mines;
        }
    }

    // Mostrar el tablero resultante.
    for (int row = 0; row < rows; row++) {
        for (int column = 0; column < columns; column++) {

            if (board[row][column] == 1) {
                IO.print("* ");
            } else {
                IO.print(result[row][column] + " ");
            }
        }

        IO.println();
    }
}
```

**Qué se practica:** matrices, recorridos anidados, desplazamientos relativos y comprobación de límites.

---

# 13. Encontrar un camino en un laberinto

## Enunciado

Vamos a representar un laberinto mediante una matriz de números enteros.

Cada posición puede contener:

- `0`: camino libre.
- `1`: muro.
- `2`: posición inicial.
- `3`: destino.

Solo se permite avanzar horizontal o verticalmente, nunca en diagonal.

Debes determinar si existe un camino desde el inicio hasta el destino.

Si existe, debes mostrar uno de los caminos encontrados.

Por ejemplo:

```java
int[][] maze = {
    {2, 0, 1, 0, 0},
    {1, 0, 1, 0, 1},
    {0, 0, 0, 0, 1},
    {1, 1, 1, 0, 0},
    {0, 0, 0, 0, 3}
};
```

Una posible solución consiste en utilizar una búsqueda en profundidad (DFS).

## Restricciones

- No se permite utilizar colecciones.
- Se pueden utilizar matrices auxiliares.
- Se deben evitar los recorridos infinitos.
- No se puede atravesar una pared.
- Se debe evitar visitar repetidamente una misma posición.

## Solución

Para realizar una búsqueda en profundidad sin recurrir a la recursividad ni a métodos propios, utilizaremos arrays como una pila.

También guardaremos el origen desde el que se ha alcanzado cada posición para poder reconstruir el camino.

```java
void main() {
    int[][] maze = {
        {2, 0, 1, 0, 0},
        {1, 0, 1, 0, 1},
        {0, 0, 0, 0, 1},
        {1, 1, 1, 0, 0},
        {0, 0, 0, 0, 3}
    };

    int rows = maze.length;
    int columns = maze[0].length;

    boolean[][] visited = new boolean[rows][columns];

    int[][] parentRow = new int[rows][columns];
    int[][] parentColumn = new int[rows][columns];

    // Arrays que representan una pila de posiciones.
    int[] stackRow = new int[rows * columns];
    int[] stackColumn = new int[rows * columns];

    int startRow = -1;
    int startColumn = -1;

    int endRow = -1;
    int endColumn = -1;

    // Buscar el inicio y el destino.
    for (int row = 0; row < rows; row++) {
        for (int column = 0; column < columns; column++) {

            if (maze[row][column] == 2) {
                startRow = row;
                startColumn = column;
            }

            if (maze[row][column] == 3) {
                endRow = row;
                endColumn = column;
            }
        }
    }

    // Direcciones: arriba, derecha, abajo e izquierda.
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    int top = 0;

    boolean found = false;

    if (startRow != -1 && endRow != -1) {

        // Introducir el inicio en la pila.
        stackRow[top] = startRow;
        stackColumn[top] = startColumn;
        top++;

        visited[startRow][startColumn] = true;

        while (top > 0 && !found) {

            // Extraer la última posición introducida.
            top--;

            int row = stackRow[top];
            int column = stackColumn[top];

            if (row == endRow && column == endColumn) {
                found = true;
                break;
            }

            // Examinar las cuatro direcciones.
            for (int direction = 0; direction < 4; direction++) {

                int nextRow = row + dr[direction];
                int nextColumn = column + dc[direction];

                if (nextRow >= 0
                        && nextRow < rows
                        && nextColumn >= 0
                        && nextColumn < columns) {

                    if (!visited[nextRow][nextColumn]
                            && maze[nextRow][nextColumn] != 1) {

                        visited[nextRow][nextColumn] = true;

                        parentRow[nextRow][nextColumn] = row;
                        parentColumn[nextRow][nextColumn] = column;

                        stackRow[top] = nextRow;
                        stackColumn[top] = nextColumn;
                        top++;
                    }
                }
            }
        }
    }

    if (found) {

        // Marcar el camino encontrado.
        char[][] path = new char[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {

                if (maze[row][column] == 1) {
                    path[row][column] = '#';
                } else {
                    path[row][column] = '.';
                }
            }
        }

        // Reconstruir el camino desde el destino hasta el inicio.
        int row = endRow;
        int column = endColumn;

        while (row != startRow || column != startColumn) {

            path[row][column] = '*';

            int previousRow = parentRow[row][column];
            int previousColumn = parentColumn[row][column];

            row = previousRow;
            column = previousColumn;
        }

        path[startRow][startColumn] = 'S';
        path[endRow][endColumn] = 'E';

        IO.println("Camino encontrado:");

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                IO.print(path[r][c] + " ");
            }

            IO.println();
        }

    } else {
        IO.println("No existe ningún camino.");
    }
}
```

**Qué se practica:** matrices, búsqueda en profundidad, pilas implementadas con arrays, posiciones visitadas y reconstrucción de caminos.

**Importante:** esta solución encuentra un camino, pero no garantiza que sea el más corto. Para encontrar el camino más corto en un laberinto con movimientos de igual coste, se suele utilizar búsqueda en anchura (BFS).

---

# 14. El mayor rectángulo de unos

## Enunciado

Dada una matriz de valores binarios (0 y 1), encuentra el rectángulo de mayor superficie formado exclusivamente por unos.

Por ejemplo:

```java
int[][] matrix = {
    {1, 0, 1, 1, 1},
    {1, 1, 1, 1, 1},
    {1, 1, 1, 1, 1},
    {0, 1, 1, 0, 0}
};
```

Debes encontrar el rectángulo más grande que contenga únicamente unos.

Para cada rectángulo debes calcular:

- Fila inicial.
- Columna inicial.
- Fila final.
- Columna final.
- Superficie.

## Restricciones

- No se permite utilizar colecciones.
- Se pueden utilizar matrices auxiliares.
- El rectángulo debe estar formado exclusivamente por unos.
- Se debe encontrar el rectángulo de mayor superficie.

## Solución

Vamos a utilizar una solución de fuerza bruta.

La idea consiste en probar todos los rectángulos posibles y comprobar si todas sus posiciones contienen un uno.

Es una solución poco eficiente, pero resulta interesante para practicar matrices y bucles anidados.

```java
void main() {
    int[][] matrix = {
        {1, 0, 1, 1, 1},
        {1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1},
        {0, 1, 1, 0, 0}
    };

    int rows = matrix.length;
    int columns = matrix[0].length;

    int maxArea = 0;

    int bestTop = -1;
    int bestLeft = -1;
    int bestBottom = -1;
    int bestRight = -1;

    // Probar todas las combinaciones de límites.
    for (int top = 0; top < rows; top++) {
        for (int left = 0; left < columns; left++) {

            for (int bottom = top; bottom < rows; bottom++) {
                for (int right = left; right < columns; right++) {

                    boolean valid = true;

                    // Comprobar todas las posiciones del rectángulo.
                    for (int row = top; row <= bottom && valid; row++) {
                        for (int column = left;
                             column <= right && valid;
                             column++) {

                            if (matrix[row][column] == 0) {
                                valid = false;
                            }
                        }
                    }

                    if (valid) {
                        int height = bottom - top + 1;
                        int width = right - left + 1;

                        int area = height * width;

                        if (area > maxArea) {
                            maxArea = area;

                            bestTop = top;
                            bestLeft = left;
                            bestBottom = bottom;
                            bestRight = right;
                        }
                    }
                }
            }
        }
    }

    if (maxArea == 0) {
        IO.println("No existe ningún rectángulo de unos.");
    } else {
        IO.println("Superficie máxima: " + maxArea);

        IO.println(
            "Fila inicial: " + bestTop
        );

        IO.println(
            "Columna inicial: " + bestLeft
        );

        IO.println(
            "Fila final: " + bestBottom
        );

        IO.println(
            "Columna final: " + bestRight
        );
    }
}
```

**Qué se practica:** matrices, combinaciones de límites, bucles anidados y validación de regiones.

**Ampliación:** intentar resolver el mismo problema con un algoritmo más eficiente.

---

# 15. El juego de la vida

## Enunciado

El Juego de la Vida es un autómata celular creado por John Conway.

El tablero está formado por una matriz de celdas que pueden estar vivas o muertas:

- `1`: célula viva.
- `0`: célula muerta.

Cada generación se calcula aplicando las siguientes reglas:

1. Una célula viva con menos de dos vecinas vivas muere por aislamiento.
2. Una célula viva con dos o tres vecinas vivas sobrevive.
3. Una célula viva con más de tres vecinas vivas muere por sobrepoblación.
4. Una célula muerta con exactamente tres vecinas vivas nace.

Cada célula tiene ocho posibles vecinas.

Debes calcular la siguiente generación del tablero.

Por ejemplo:

```java
int[][] board = {
    {0, 0, 0, 0, 0},
    {0, 1, 1, 1, 0},
    {0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0}
};
```

Después de una generación, el resultado será:

```text
0 0 1 0 0
0 0 1 0 0
0 0 1 0 0
0 0 0 0 0
0 0 0 0 0
```

El patrón horizontal se ha convertido en uno vertical.

## Restricciones

- Se debe utilizar una matriz auxiliar para calcular la siguiente generación.
- No se puede modificar el tablero mientras se están calculando las nuevas células.
- Se deben comprobar los límites de la matriz.
- Se debe calcular el número de vecinas vivas de cada célula.

## Solución

```java
void main() {
    int[][] board = {
        {0, 0, 0, 0, 0},
        {0, 1, 1, 1, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0}
    };

    int rows = board.length;
    int columns = board[0].length;

    int[][] nextGeneration = new int[rows][columns];

    // Calcular cada célula de la siguiente generación.
    for (int row = 0; row < rows; row++) {
        for (int column = 0; column < columns; column++) {

            int aliveNeighbors = 0;

            // Contar las ocho posibles vecinas.
            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {

                    if (dr == 0 && dc == 0) {
                        continue;
                    }

                    int neighborRow = row + dr;
                    int neighborColumn = column + dc;

                    if (neighborRow >= 0
                            && neighborRow < rows
                            && neighborColumn >= 0
                            && neighborColumn < columns) {

                        if (board[neighborRow][neighborColumn] == 1) {
                            aliveNeighbors++;
                        }
                    }
                }
            }

            // Aplicar las reglas del Juego de la Vida.
            if (board[row][column] == 1) {

                if (aliveNeighbors == 2 || aliveNeighbors == 3) {
                    nextGeneration[row][column] = 1;
                } else {
                    nextGeneration[row][column] = 0;
                }

            } else {

                if (aliveNeighbors == 3) {
                    nextGeneration[row][column] = 1;
                } else {
                    nextGeneration[row][column] = 0;
                }
            }
        }
    }

    // Mostrar la siguiente generación.
    for (int row = 0; row < rows; row++) {
        for (int column = 0; column < columns; column++) {
            IO.print(nextGeneration[row][column] + " ");
        }

        IO.println();
    }
}
```

**Qué se practica:** matrices, matrices auxiliares, recorridos de vecindad, reglas de transición y simulación de estados.

**Ampliación:** permitir que el usuario indique cuántas generaciones quiere calcular y repetir el proceso, utilizando dos matrices que se intercambian como tablero actual y siguiente generación.

---

# Propuesta de organización de los retos

Los ejercicios se pueden distribuir en tres niveles de dificultad.

## Nivel 1. Dominio de arrays

| Ejercicio | Reto |
|---|---|
| 1 | Valores más frecuentes |
| 2 | Comparación de arrays |
| 3 | Eliminar apariciones |
| 4 | Rotación circular |
| 5 | Fusionar arrays ordenados |

Estos ejercicios permiten comprobar que el alumno domina los recorridos, los índices, los desplazamientos y la manipulación de arrays.

## Nivel 2. Diseño de algoritmos

| Ejercicio | Reto |
|---|---|
| 6 | Secuencia consecutiva más larga |
| 7 | Elemento mayoritario |
| 8 | Parejas con una suma objetivo |
| 9 | Pareja más cercana a un objetivo |
| 10 | Ordenación por frecuencia |
| 11 | Ordenación parcial con Insertion Sort |

Aquí el alumno debe pensar más allá de aplicar un recorrido convencional. Es importante que sepa justificar por qué su algoritmo funciona.

## Nivel 3. Retos avanzados

| Ejercicio | Reto |
|---|---|
| 12 | Buscaminas |
| 13 | Laberinto |
| 14 | Mayor rectángulo de unos |
| 15 | Juego de la Vida |

Estos ejercicios requieren combinar varias ideas y diseñar algoritmos más elaborados.

---

# Recomendaciones para la evaluación

No todos los retos deberían tener el mismo peso.

Una posible forma de evaluar es valorar cuatro aspectos:

1. **Corrección:** el programa obtiene los resultados esperados.
2. **Tratamiento de casos especiales:** arrays vacíos, elementos repetidos, empates y límites.
3. **Diseño del algoritmo:** la solución utiliza correctamente las estructuras de control y los arrays.
4. **Claridad:** los índices, variables y recorridos están bien planteados.

También es interesante pedir al alumnado que explique con sus propias palabras cómo funciona el algoritmo y que haga una prueba manual con un ejemplo pequeño.

Una solución que funciona por casualidad no demuestra necesariamente que el alumno comprenda el algoritmo.