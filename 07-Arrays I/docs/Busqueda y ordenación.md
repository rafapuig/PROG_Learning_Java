# Algoritmos de búsqueda y ordenación

## 1. Introducción

Hasta ahora hemos aprendido a almacenar datos en arrays y a recorrerlos para consultar o modificar sus elementos.

En esta unidad vamos a estudiar algunos algoritmos clásicos que permiten realizar dos operaciones muy habituales:

- **Búsqueda:** localizar uno o varios elementos dentro de un array.
- **Ordenación:** reorganizar los elementos de un array siguiendo un determinado criterio.

Estos algoritmos son importantes porque aparecen constantemente en programación y permiten trabajar con algunos conceptos fundamentales:

- Recorrido de arrays.
- Comparación de elementos.
- Utilización de índices.
- Variables auxiliares.
- Intercambio de valores.
- Bucles anidados.
- Diseño de algoritmos.

Todavía no utilizaremos funciones propias. Todos los algoritmos estarán escritos directamente dentro de `main`, utilizando únicamente los elementos del lenguaje que ya conocemos.

### 1.1. Un ejemplo sencillo

Imaginemos que tenemos el siguiente array:

```java
int[] numbers = { 12, 5, 8, 21, 3, 15 };
```

Podemos plantearnos distintas preguntas:

- ¿Está el número 8 dentro del array?
- ¿En qué posición se encuentra?
- ¿Cuántas veces aparece el número 5?
- ¿Cómo podemos ordenar los números de menor a mayor?
- ¿Cómo podemos ordenar los números de mayor a menor?

Vamos a resolver estas cuestiones mediante diferentes algoritmos.

---

# 2. Algoritmos de búsqueda

## 2.1. Búsqueda lineal

La búsqueda lineal es el algoritmo más sencillo para localizar un elemento dentro de un array.

Consiste en recorrer los elementos uno a uno y compararlos con el valor que estamos buscando.

Si encontramos el elemento, podemos detener la búsqueda. Si terminamos de recorrer el array sin encontrarlo, significa que no está presente.

### Ejemplo

Tenemos el siguiente array:

```java
int[] numbers = { 12, 5, 8, 21, 3, 15 };
```

Queremos localizar el número 21.

El algoritmo realiza las siguientes comprobaciones:

| Índice | Valor | ¿Es 21? |
|---|---:|---|
| 0 | 12 | No |
| 1 | 5 | No |
| 2 | 8 | No |
| 3 | 21 | Sí |

El elemento se encuentra en la posición 3.

### Implementación

```java
void main() {
    int[] numbers = { 12, 5, 8, 21, 3, 15 };
    int target = 21;

    int position = -1;

    for (int i = 0; i < numbers.length; i++) {
        if (numbers[i] == target) {
            position = i;
            break;
        }
    }

    if (position == -1) {
        IO.println("Element not found");
    } else {
        IO.println("Element found at position " + position);
    }
}
```

### ¿Cómo funciona?

Utilizamos la variable `position` para almacenar el índice donde hemos encontrado el elemento.

Inicialmente le asignamos el valor `-1`:

```java
int position = -1;
```

¿Por qué utilizamos `-1`?

Porque los índices válidos de un array siempre empiezan en cero. Por tanto, podemos utilizar `-1` para representar que todavía no hemos encontrado el elemento.

Durante el recorrido:

```java
if (numbers[i] == target) {
    position = i;
    break;
}
```

Si encontramos el valor buscado:

1. Guardamos su posición.
2. Utilizamos `break` para terminar el bucle.

Finalmente comprobamos si la búsqueda ha tenido éxito.

### ¿Qué ocurre si el elemento no está?

Si recorremos todo el array sin encontrar el valor, `position` seguirá valiendo `-1`.

Por eso podemos comprobar:

```java
if (position == -1)
```

### Importante: búsqueda de la primera aparición

Este algoritmo termina cuando encuentra la primera coincidencia.

Si el array contiene varios elementos iguales al buscado, solamente obtendremos la posición de la primera aparición.

Por ejemplo:

```java
int[] numbers = { 4, 8, 2, 8, 5, 8 };
```

Si buscamos el número 8, el resultado será la posición 1.

### 2.1.1. Coste de la búsqueda lineal

En el peor de los casos tenemos que recorrer todo el array.

Esto sucede cuando:

- El elemento no existe.
- El elemento está en la última posición.

Si el array tiene `n` elementos, podemos llegar a realizar `n` comparaciones.

Por eso decimos que la búsqueda lineal tiene un coste de:

**O(n)**

Esto significa que el trabajo necesario crece proporcionalmente al número de elementos.

---

## 2.2. Buscar todas las apariciones

En ocasiones no queremos encontrar únicamente la primera aparición de un elemento, sino localizar todas las posiciones en las que aparece.

Para conseguirlo, simplemente tenemos que recorrer todo el array y no detener el bucle cuando encontremos una coincidencia.

### Ejemplo

```java
void main() {
    int[] numbers = { 4, 8, 2, 8, 5, 8 };
    int target = 8;

    int count = 0;

    for (int i = 0; i < numbers.length; i++) {
        if (numbers[i] == target) {
            IO.println("Found at position " + i);
            count++;
        }
    }

    IO.println("Total occurrences: " + count);
}
```

El resultado será:

```text
Found at position 1
Found at position 3
Found at position 5
Total occurrences: 3
```

La diferencia fundamental respecto al algoritmo anterior es que no utilizamos `break`.

Queremos que el bucle continúe hasta recorrer todos los elementos.

Además, utilizamos una variable `count` para contabilizar las coincidencias.

### 2.2.1. Contar sin mostrar las posiciones

También podemos modificar el algoritmo para contar las apariciones sin mostrar cada posición:

```java
void main() {
    int[] numbers = { 4, 8, 2, 8, 5, 8 };
    int target = 8;

    int count = 0;

    for (int i = 0; i < numbers.length; i++) {
        if (numbers[i] == target) {
            count++;
        }
    }

    IO.println("Total occurrences: " + count);
}
```

---

# 3. Intercambio de elementos

Antes de estudiar los algoritmos de ordenación necesitamos aprender a intercambiar los valores almacenados en dos posiciones de un array.

Imaginemos el siguiente array:

```java
int[] numbers = { 12, 5, 8, 21 };
```

Queremos intercambiar los elementos de las posiciones 0 y 1.

El resultado debería ser:

```text
Antes:   12  5  8  21
Después: 5  12  8  21
```

### 3.1. ¿Cómo intercambiamos dos valores?

Podríamos intentar hacer lo siguiente:

```java
numbers[0] = numbers[1];
numbers[1] = numbers[0];
```

Pero no funcionaría.

Después de ejecutar la primera instrucción, habríamos perdido el valor original de `numbers[0]`.

Para resolverlo necesitamos una variable auxiliar que permita guardar temporalmente uno de los valores.

```java
int temp = numbers[0];

numbers[0] = numbers[1];

numbers[1] = temp;
```

El funcionamiento es el siguiente:

1. Guardamos el primer valor en `temp`.
2. Copiamos el segundo valor en la primera posición.
3. Recuperamos el valor original desde `temp` y lo guardamos en la segunda posición.

### 3.2. Intercambiar dos posiciones introducidas por teclado

```java
void main() {
    int[] numbers = { 12, 5, 8, 21 };

    IO.println("First position:");
    int first = Integer.parseInt(IO.readln());

    IO.println("Second position:");
    int second = Integer.parseInt(IO.readln());

    if (first >= 0 && first < numbers.length
            && second >= 0 && second < numbers.length) {

        int temp = numbers[first];
        numbers[first] = numbers[second];
        numbers[second] = temp;

        for (int i = 0; i < numbers.length; i++) {
            IO.print(numbers[i] + " ");
        }

    } else {
        IO.println("Invalid position");
    }
}
```

Este procedimiento de intercambio se utilizará constantemente en algunos algoritmos de ordenación.

---

# 4. Algoritmos de ordenación

Ordenar un array consiste en reorganizar sus elementos siguiendo un criterio.

En esta unidad vamos a trabajar con tres algoritmos clásicos:

1. Ordenación por selección (*Selection Sort*).
2. Ordenación de burbuja (*Bubble Sort*).
3. Ordenación por inserción (*Insertion Sort*).

Los tres permiten ordenar un array de menor a mayor o de mayor a menor.

Aunque los resultados sean los mismos, cada algoritmo sigue una estrategia diferente.

---

## 4.1. Ordenación por selección (Selection Sort)

La ordenación por selección consiste en buscar el elemento más pequeño de la parte del array que todavía no está ordenada y colocarlo en su posición definitiva.

El proceso se repite hasta que todos los elementos están ordenados.

### Ejemplo

Tenemos el siguiente array:

```text
12  5  8  21  3
```

Queremos ordenarlo de menor a mayor.

La idea es dividir mentalmente el array en dos partes:

- Parte ordenada: los elementos que ya están colocados correctamente.
- Parte sin ordenar: los elementos que todavía tenemos que procesar.

Inicialmente todo el array está sin ordenar.

### Primera pasada

Buscamos el elemento más pequeño de todo el array:

```text
12  5  8  21  3
```

El mínimo es 3.

Lo intercambiamos con el primer elemento:

```text
3  5  8  21  12
```

El primer elemento ya está en su posición definitiva.

### Segunda pasada

Ahora buscamos el mínimo a partir de la posición 1:

```text
3 | 5  8  21  12
```

El mínimo es 5.

Ya está en la posición correcta, así que no necesitamos intercambiar nada.

### Tercera pasada

Buscamos el mínimo a partir de la posición 2:

```text
3  5 | 8  21  12
```

El mínimo es 8.

Tampoco necesitamos intercambiarlo.

### Cuarta pasada

Buscamos el mínimo a partir de la posición 3:

```text
3  5  8 | 21  12
```

El mínimo es 12.

Lo intercambiamos con el elemento de la posición 3:

```text
3  5  8  12  21
```

El array ya está ordenado.

### Implementación

```java
void main() {
    int[] numbers = { 12, 5, 8, 21, 3 };

    for (int i = 0; i < numbers.length - 1; i++) {

        int minIndex = i;

        for (int j = i + 1; j < numbers.length; j++) {

            if (numbers[j] < numbers[minIndex]) {
                minIndex = j;
            }
        }

        int temp = numbers[i];
        numbers[i] = numbers[minIndex];
        numbers[minIndex] = temp;
    }

    for (int i = 0; i < numbers.length; i++) {
        IO.print(numbers[i] + " ");
    }
}
```

### ¿Cómo funciona?

Este algoritmo utiliza dos bucles.

El bucle exterior:

```java
for (int i = 0; i < numbers.length - 1; i++)
```

Controla las pasadas del algoritmo.

En cada pasada, la posición `i` es la siguiente posición que queremos dejar ordenada.

El bucle interior:

```java
for (int j = i + 1; j < numbers.length; j++)
```

Busca el elemento más pequeño entre las posiciones que todavía no están ordenadas.

Para ello utilizamos:

```java
int minIndex = i;
```

Esta variable almacena el índice donde se encuentra el menor elemento encontrado hasta el momento.

Cada vez que encontramos uno más pequeño:

```java
if (numbers[j] < numbers[minIndex]) {
    minIndex = j;
}
```

Actualizamos `minIndex`.

Cuando termina el bucle interior, ya conocemos la posición del elemento más pequeño de la parte no ordenada.

Entonces intercambiamos ese elemento con el que ocupa la posición `i`.

### ¿Por qué utilizamos dos bucles?

Porque necesitamos realizar dos operaciones diferentes:

- El bucle exterior decide qué posición vamos a ordenar.
- El bucle interior busca qué elemento debe ocupar esa posición.

### 4.1.1. Coste de Selection Sort

El algoritmo realiza exactamente el siguiente número de comparaciones:

$$
\frac{n(n-1)}{2}
$$

Por ejemplo, con 5 elementos realiza:

$$
\frac{5 \cdot 4}{2} = 10
$$

comparaciones.

Su coste es:

**O(n²)**

Aunque el array ya esté ordenado, seguirá realizando las comparaciones necesarias para buscar los mínimos.

---

## 4.2. Ordenación de burbuja (Bubble Sort)

La ordenación de burbuja utiliza una estrategia diferente.

Compara elementos consecutivos y los intercambia cuando están en el orden incorrecto.

En cada pasada, el elemento más grande de la parte no ordenada acaba desplazándose hasta su posición definitiva.

### Ejemplo

Tenemos el siguiente array:

```text
12  5  8  21  3
```

Queremos ordenarlo de menor a mayor.

### Primera pasada

Comparamos los elementos consecutivos.

**Primera comparación:**

Comparamos 12 y 5.

Como 12 es mayor que 5, intercambiamos sus posiciones.

```text
5  12  8  21  3
```

**Segunda comparación:**

Comparamos 12 y 8.

Como 12 es mayor que 8, intercambiamos.

```text
5  8  12  21  3
```

**Tercera comparación:**

Comparamos 12 y 21.

Como están en el orden correcto, no hacemos nada.

```text
5  8  12  21  3
```

**Cuarta comparación:**

Comparamos 21 y 3.

Como 21 es mayor que 3, intercambiamos.

```text
5  8  12  3  21
```

Al terminar la primera pasada, el elemento más grande está en la última posición.

### Segunda pasada

Volvemos a recorrer el array, pero ya no necesitamos llegar hasta el último elemento.

El 21 ya está colocado correctamente.

Comparamos 5 y 8. No intercambiamos.

Comparamos 8 y 12. No intercambiamos.

Comparamos 12 y 3. Intercambiamos.

El resultado es:

```text
5  8  3  12  21
```

### Tercera pasada

Volvemos a comparar los elementos consecutivos de la parte que todavía no está ordenada.

Comparamos 5 y 8. No intercambiamos.

Comparamos 8 y 3. Intercambiamos.

El resultado es:

```text
5  3  8  12  21
```

### Cuarta pasada

Comparamos 5 y 3.

Como están desordenados, los intercambiamos:

```text
3  5  8  12  21
```

El array ya está ordenado.

### Implementación

```java
void main() {
    int[] numbers = { 12, 5, 8, 21, 3 };

    for (int i = 0; i < numbers.length - 1; i++) {

        for (int j = 0; j < numbers.length - 1 - i; j++) {

            if (numbers[j] > numbers[j + 1]) {

                int temp = numbers[j];
                numbers[j] = numbers[j + 1];
                numbers[j + 1] = temp;
            }
        }
    }

    for (int i = 0; i < numbers.length; i++) {
        IO.print(numbers[i] + " ");
    }
}
```

### ¿Cómo funciona?

También utilizamos dos bucles.

El bucle exterior:

```java
for (int i = 0; i < numbers.length - 1; i++)
```

Controla el número de pasadas.

El bucle interior:

```java
for (int j = 0; j < numbers.length - 1 - i; j++)
```

Recorre las parejas de elementos consecutivos que tenemos que comparar.

La condición:

```java
numbers[j] > numbers[j + 1]
```

Comprueba si los elementos están desordenados.

Si el elemento de la izquierda es mayor que el de la derecha, tenemos que intercambiarlos.

### ¿Por qué restamos `i` al límite del bucle interior?

Porque después de cada pasada tenemos un elemento más grande colocado en su posición definitiva, al final del array.

No necesitamos volver a comparar esos elementos.

Por eso el recorrido se va acortando.

### 4.2.1. Coste de Bubble Sort

En el peor caso, el algoritmo realiza un número de comparaciones proporcional a:

$$
n^2
$$

Su coste es:

**O(n²)**

### 4.2.2. Optimización de Bubble Sort

Podemos mejorar el algoritmo si detectamos cuándo una pasada completa no ha realizado ningún intercambio.

Si no hemos intercambiado ningún elemento, significa que el array ya está ordenado.

Para ello utilizamos una variable booleana:

```java
void main() {
    int[] numbers = { 3, 5, 8, 12, 21 };

    boolean swapped = true;

    for (int i = 0; i < numbers.length - 1 && swapped; i++) {

        swapped = false;

        for (int j = 0; j < numbers.length - 1 - i; j++) {

            if (numbers[j] > numbers[j + 1]) {

                int temp = numbers[j];
                numbers[j] = numbers[j + 1];
                numbers[j + 1] = temp;

                swapped = true;
            }
        }
    }

    for (int i = 0; i < numbers.length; i++) {
        IO.print(numbers[i] + " ");
    }
}
```

La variable `swapped` indica si durante una pasada se ha producido algún intercambio.

Al principio de cada pasada le asignamos `false`.

Si se produce algún intercambio, vuelve a valer `true`.

Si termina una pasada y continúa valiendo `false`, el bucle exterior termina.

Esta optimización permite que un array que ya está ordenado se procese en una sola pasada.

---

## 4.3. Ordenación por inserción (Insertion Sort)

La ordenación por inserción utiliza una estrategia similar a la que empleamos cuando ordenamos cartas en nuestra mano.

Vamos tomando los elementos uno a uno y los insertamos en la posición correcta dentro de la parte que ya está ordenada.

El array se divide mentalmente en dos partes:

- Una parte inicial ordenada.
- Una parte restante todavía sin ordenar.

En cada pasada tomamos un elemento de la parte no ordenada y buscamos dónde debemos colocarlo.

### Ejemplo

Tenemos el siguiente array:

```text
12  5  8  21  3
```

Inicialmente consideramos que el primer elemento está ordenado:

```text
12 | 5  8  21  3
```

### Primera pasada

Tomamos el elemento 5.

Lo comparamos con 12.

Como 12 es mayor, lo desplazamos una posición hacia la derecha.

Después colocamos el 5 en la primera posición:

```text
5  12 | 8  21  3
```

### Segunda pasada

Tomamos el elemento 8.

Lo comparamos con 12.

Como 12 es mayor, lo desplazamos hacia la derecha.

A continuación comparamos 8 con 5.

Como 5 es menor que 8, colocamos el 8 después del 5.

```text
5  8  12 | 21  3
```

### Tercera pasada

Tomamos el 21.

Ya está en la posición correcta, porque es mayor que los elementos anteriores.

```text
5  8  12  21 | 3
```

### Cuarta pasada

Tomamos el 3.

Tenemos que desplazar hacia la derecha todos los elementos mayores que 3:

```text
5  8  12  21
```

Finalmente colocamos el 3 al principio:

```text
3  5  8  12  21
```

El array ya está ordenado.

### Implementación

```java
void main() {
    int[] numbers = { 12, 5, 8, 21, 3 };

    for (int i = 1; i < numbers.length; i++) {

        int key = numbers[i];
        int j = i - 1;

        while (j >= 0 && numbers[j] > key) {

            numbers[j + 1] = numbers[j];

            j--;
        }

        numbers[j + 1] = key;
    }

    for (int i = 0; i < numbers.length; i++) {
        IO.print(numbers[i] + " ");
    }
}
```

### ¿Cómo funciona?

Este algoritmo utiliza una variable llamada `key`:

```java
int key = numbers[i];
```

En ella guardamos el elemento que queremos insertar en la parte ordenada.

Después utilizamos `j` para recorrer hacia atrás los elementos anteriores:

```java
int j = i - 1;
```

Mientras encontremos elementos mayores que `key`:

```java
while (j >= 0 && numbers[j] > key)
```

Los desplazamos una posición hacia la derecha:

```java
numbers[j + 1] = numbers[j];
```

Después retrocedemos una posición:

```java
j--;
```

Cuando encontramos un elemento menor o igual que `key`, o llegamos al principio del array, podemos insertar el elemento.

Lo hacemos mediante:

```java
numbers[j + 1] = key;
```

### ¿Por qué no intercambiamos los elementos?

A diferencia de los algoritmos anteriores, Insertion Sort no utiliza intercambios entre dos posiciones.

En su lugar, desplaza los elementos mayores hacia la derecha y coloca el elemento que estamos procesando en el hueco que queda libre.

Es importante guardar previamente el valor en `key`, porque durante los desplazamientos podríamos sobrescribir su posición original.

### 4.3.1. Coste de Insertion Sort

En el peor caso, cuando el array está ordenado de mayor a menor, tenemos que desplazar muchos elementos en cada pasada.

Su coste es:

**O(n²)**

Sin embargo, cuando el array está prácticamente ordenado, puede ser bastante eficiente.

---

# 5. Comparación de los algoritmos de ordenación

Los tres algoritmos que hemos estudiado permiten ordenar arrays, pero utilizan estrategias diferentes.

| Algoritmo | Estrategia | Coste en el peor caso |
|---|---|---|
| Selection Sort | Busca el mínimo y lo coloca en su posición | O(n²) |
| Bubble Sort | Compara e intercambia elementos consecutivos | O(n²) |
| Insertion Sort | Inserta cada elemento en su posición correcta | O(n²) |

### 5.1. ¿Cuál es mejor?

No existe un único algoritmo que sea siempre el mejor.

Cada uno tiene sus características:

- **Selection Sort:** es sencillo de entender y realiza pocos intercambios.
- **Bubble Sort:** es muy visual y permite comprender fácilmente el funcionamiento de los intercambios.
- **Insertion Sort:** funciona especialmente bien cuando los datos ya están casi ordenados.

Los tres son algoritmos clásicos y tienen un coste cuadrático en el peor caso.

En esta unidad nos interesa especialmente comprender sus estrategias, no solamente memorizar su código.

---

# 6. Búsqueda binaria

Hasta ahora hemos utilizado la búsqueda lineal, que consiste en comprobar los elementos uno a uno.

Sin embargo, existe otro algoritmo mucho más eficiente cuando el array está ordenado: la búsqueda binaria.

La búsqueda binaria consiste en dividir repetidamente el espacio de búsqueda en dos mitades.

En cada paso descartamos la mitad en la que sabemos que no puede encontrarse el elemento.

### 6.1. Una condición imprescindible

La búsqueda binaria solamente funciona correctamente cuando los elementos están ordenados.

Por ejemplo, podemos utilizar:

```java
int[] numbers = { 3, 5, 8, 12, 15, 21, 28, 34 };
```

No podemos aplicar directamente este algoritmo sobre un array desordenado.

### 6.2. Ejemplo

Queremos buscar el número 21.

Utilizamos tres variables:

- `left`: índice del límite izquierdo.
- `right`: índice del límite derecho.
- `middle`: índice central de la zona que estamos buscando.

Inicialmente:

```text
left = 0
right = 7
```

Calculamos la posición central:

```text
middle = (left + right) / 2
middle = (0 + 7) / 2
middle = 3
```

El elemento de la posición 3 es 12.

```text
 3   5   8   12   15   21   28   34
                 ^
               middle
```

Como 21 es mayor que 12, sabemos que no puede estar en la mitad izquierda.

Por tanto, descartamos esa mitad y actualizamos:

```text
left = middle + 1
```

Ahora tenemos:

```text
left = 4
right = 7
```

Calculamos de nuevo el punto central:

```text
middle = (4 + 7) / 2
middle = 5
```

El elemento de la posición 5 es 21.

¡Lo hemos encontrado!

### 6.3. Implementación

```java
void main() {
    int[] numbers = { 3, 5, 8, 12, 15, 21, 28, 34 };
    int target = 21;

    int left = 0;
    int right = numbers.length - 1;

    int position = -1;

    while (left <= right && position == -1) {

        int middle = (left + right) / 2;

        if (numbers[middle] == target) {

            position = middle;

        } else if (numbers[middle] < target) {

            left = middle + 1;

        } else {

            right = middle - 1;
        }
    }

    if (position == -1) {
        IO.println("Element not found");
    } else {
        IO.println("Element found at position " + position);
    }
}
```

### 6.4. ¿Cómo funciona?

Comenzamos definiendo los límites de búsqueda:

```java
int left = 0;
int right = numbers.length - 1;
```

Mientras el intervalo siga siendo válido y no hayamos encontrado el elemento, continuamos buscando:

```java
while (left <= right && position == -1)
```

Calculamos la posición central:

```java
int middle = (left + right) / 2;
```

Como estamos trabajando con números enteros, la división elimina la parte decimal.

A continuación tenemos tres posibilidades.

**Caso 1: encontramos el elemento**

```java
if (numbers[middle] == target)
```

Guardamos su posición.

**Caso 2: el elemento buscado es mayor que el central**

```java
else if (numbers[middle] < target)
```

Tenemos que buscar en la mitad derecha.

Por tanto:

```java
left = middle + 1;
```

**Caso 3: el elemento buscado es menor que el central**

Si el valor central es mayor que el que buscamos, tenemos que buscar en la mitad izquierda:

```java
right = middle - 1;
```

En cada paso descartamos aproximadamente la mitad de los elementos restantes.

### 6.5. ¿Por qué es tan eficiente?

Imaginemos que tenemos un array de 1.000 elementos.

La búsqueda lineal podría necesitar comprobar los 1.000 elementos.

En cambio, la búsqueda binaria reduce el espacio de búsqueda aproximadamente de esta manera:

| Paso | Elementos que quedan |
|---|---:|
| Inicial | 1.000 |
| 1 | 500 |
| 2 | 250 |
| 3 | 125 |
| 4 | 63 |
| 5 | 32 |
| 6 | 16 |
| 7 | 8 |
| 8 | 4 |
| 9 | 2 |
| 10 | 1 |

Necesitamos aproximadamente 10 pasos para reducir 1.000 elementos a uno.

El coste de la búsqueda binaria es:

**O(log n)**

Es mucho más eficiente que la búsqueda lineal cuando trabajamos con arrays grandes y ordenados.

### 6.6. Comparación entre búsqueda lineal y binaria

| Característica | Búsqueda lineal | Búsqueda binaria |
|---|---|---|
| ¿Necesita ordenar el array? | No | Sí |
| Estrategia | Comprobar uno a uno | Dividir en mitades |
| Coste | O(n) | O(log n) |
| Dificultad | Baja | Media |

**Recuerda:** la búsqueda binaria no es una alternativa que podamos utilizar siempre. Si el array no está ordenado, tendremos que ordenarlo previamente o utilizar búsqueda lineal.

---

# 7. Ejercicios propuestos

En los siguientes ejercicios tendrás que aplicar los algoritmos estudiados.

Todos los programas deben resolverse sin crear funciones propias. Puedes utilizar variables, arrays, condicionales y bucles.

Las soluciones aparecen después de los enunciados.

## Ejercicio 1. Buscar un elemento

Crea un array de 10 números enteros.

Pide al usuario un número y utiliza la búsqueda lineal para localizarlo.

El programa debe mostrar:

- Si el número existe.
- La posición en la que se encuentra, si existe.

Si el número aparece varias veces, solamente debes mostrar la primera posición.

## Ejercicio 2. Contar apariciones

Crea un array de 12 números enteros.

Pide al usuario un número y muestra cuántas veces aparece en el array.

Además, muestra todas las posiciones donde aparece.

## Ejercicio 3. Intercambiar los extremos

Crea un array de 8 números enteros.

Intercambia el primer elemento con el último.

Muestra el array antes y después del intercambio.

## Ejercicio 4. Ordenar mediante selección

Crea un array de 10 números enteros.

Ordénalo de menor a mayor utilizando Selection Sort.

Muestra el array antes y después de ordenarlo.

## Ejercicio 5. Ordenar mediante burbuja

Crea un array de 8 números enteros.

Ordénalo de mayor a menor utilizando Bubble Sort.

Debes modificar la condición de comparación del algoritmo para conseguir el orden descendente.

## Ejercicio 6. Ordenar mediante inserción

Crea un array de 10 números enteros.

Ordénalo de menor a mayor utilizando Insertion Sort.

Muestra el array antes y después de ordenarlo.

## Ejercicio 7. Búsqueda binaria

Crea un array de números enteros ordenado de menor a mayor.

Pide un número al usuario y utiliza la búsqueda binaria para localizarlo.

Muestra la posición donde se encuentra o un mensaje indicando que no existe.

## Ejercicio 8. Comparar búsquedas

Crea un array de 20 números enteros.

Pide al usuario un número y realiza dos búsquedas:

1. Una búsqueda lineal.
2. Una búsqueda binaria.

Para poder utilizar la búsqueda binaria, primero debes ordenar el array.

Muestra cuántas comparaciones ha realizado cada algoritmo hasta encontrar el elemento o determinar que no existe.

---

# 8. Soluciones de los ejercicios

## Solución 1. Buscar un elemento

```java
void main() {
    int[] numbers = { 12, 5, 8, 21, 3, 15, 8, 9, 2, 17 };

    IO.println("Number to search:");
    int target = Integer.parseInt(IO.readln());

    int position = -1;

    for (int i = 0; i < numbers.length; i++) {

        if (numbers[i] == target) {
            position = i;
            break;
        }
    }

    if (position == -1) {
        IO.println("Element not found");
    } else {
        IO.println("Element found at position " + position);
    }
}
```

**Explicación:**

Recorremos el array desde la primera posición hasta encontrar el elemento.

Cuando lo encontramos, guardamos su posición y terminamos el bucle mediante `break`.

Utilizamos `-1` para indicar que no hemos encontrado el elemento.

## Solución 2. Contar apariciones

```java
void main() {
    int[] numbers = { 4, 8, 2, 8, 5, 8, 3, 2, 8, 7, 4, 8 };

    IO.println("Number to search:");
    int target = Integer.parseInt(IO.readln());

    int count = 0;

    for (int i = 0; i < numbers.length; i++) {

        if (numbers[i] == target) {
            IO.println("Found at position " + i);
            count++;
        }
    }

    IO.println("Total occurrences: " + count);
}
```

**Explicación:**

No utilizamos `break`, porque necesitamos recorrer todo el array.

Cada vez que encontramos una coincidencia, mostramos su posición e incrementamos el contador.

## Solución 3. Intercambiar los extremos

```java
void main() {
    int[] numbers = { 12, 5, 8, 21, 3, 15, 9, 2 };

    IO.println("Before:");

    for (int i = 0; i < numbers.length; i++) {
        IO.print(numbers[i] + " ");
    }

    int temp = numbers[0];

    numbers[0] = numbers[numbers.length - 1];

    numbers[numbers.length - 1] = temp;

    IO.println("\nAfter:");

    for (int i = 0; i < numbers.length; i++) {
        IO.print(numbers[i] + " ");
    }
}
```

**Explicación:**

El primer elemento se encuentra en la posición 0.

El último elemento se encuentra en:

```java
numbers.length - 1
```

Guardamos el primer elemento en una variable auxiliar, intercambiamos los valores y finalmente mostramos el resultado.

## Solución 4. Ordenar mediante selección

```java
void main() {
    int[] numbers = { 12, 5, 8, 21, 3, 15, 9, 2, 17, 6 };

    IO.println("Before:");

    for (int i = 0; i < numbers.length; i++) {
        IO.print(numbers[i] + " ");
    }

    for (int i = 0; i < numbers.length - 1; i++) {

        int minIndex = i;

        for (int j = i + 1; j < numbers.length; j++) {

            if (numbers[j] < numbers[minIndex]) {
                minIndex = j;
            }
        }

        int temp = numbers[i];
        numbers[i] = numbers[minIndex];
        numbers[minIndex] = temp;
    }

    IO.println("\nAfter:");

    for (int i = 0; i < numbers.length; i++) {
        IO.print(numbers[i] + " ");
    }
}
```

**Explicación:**

En cada pasada buscamos el menor elemento de la parte que todavía no está ordenada.

Guardamos su posición en `minIndex` y, cuando termina la búsqueda, lo intercambiamos con el elemento de la posición `i`.

## Solución 5. Ordenar mediante burbuja

```java
void main() {
    int[] numbers = { 12, 5, 8, 21, 3, 15, 9, 2 };

    IO.println("Before:");

    for (int i = 0; i < numbers.length; i++) {
        IO.print(numbers[i] + " ");
    }

    for (int i = 0; i < numbers.length - 1; i++) {

        for (int j = 0; j < numbers.length - 1 - i; j++) {

            if (numbers[j] < numbers[j + 1]) {

                int temp = numbers[j];
                numbers[j] = numbers[j + 1];
                numbers[j + 1] = temp;
            }
        }
    }

    IO.println("\nAfter:");

    for (int i = 0; i < numbers.length; i++) {
        IO.print(numbers[i] + " ");
    }
}
```

**Explicación:**

Para ordenar de mayor a menor tenemos que colocar los valores más grandes a la izquierda.

Por eso intercambiamos cuando el elemento de la izquierda es menor que el de la derecha:

```java
if (numbers[j] < numbers[j + 1])
```

El resto del algoritmo es igual que en la ordenación ascendente.

## Solución 6. Ordenar mediante inserción

```java
void main() {
    int[] numbers = { 12, 5, 8, 21, 3, 15, 9, 2, 17, 6 };

    IO.println("Before:");

    for (int i = 0; i < numbers.length; i++) {
        IO.print(numbers[i] + " ");
    }

    for (int i = 1; i < numbers.length; i++) {

        int key = numbers[i];
        int j = i - 1;

        while (j >= 0 && numbers[j] > key) {

            numbers[j + 1] = numbers[j];

            j--;
        }

        numbers[j + 1] = key;
    }

    IO.println("\nAfter:");

    for (int i = 0; i < numbers.length; i++) {
        IO.print(numbers[i] + " ");
    }
}
```

**Explicación:**

Comenzamos en la posición 1 porque consideramos que el primer elemento ya está ordenado.

Guardamos el elemento que queremos insertar en `key`.

Desplazamos hacia la derecha todos los elementos anteriores que sean mayores que `key`.

Finalmente insertamos el elemento en la posición correcta.

## Solución 7. Búsqueda binaria

```java
void main() {
    int[] numbers = { 3, 5, 8, 12, 15, 21, 28, 34, 39, 45 };

    IO.println("Number to search:");
    int target = Integer.parseInt(IO.readln());

    int left = 0;
    int right = numbers.length - 1;

    int position = -1;

    while (left <= right && position == -1) {

        int middle = (left + right) / 2;

        if (numbers[middle] == target) {

            position = middle;

        } else if (numbers[middle] < target) {

            left = middle + 1;

        } else {

            right = middle - 1;
        }
    }

    if (position == -1) {
        IO.println("Element not found");
    } else {
        IO.println("Element found at position " + position);
    }
}
```

**Explicación:**

Comenzamos buscando en todo el array.

En cada iteración calculamos el punto central y comparamos su valor con el elemento buscado.

Si el valor central es menor, descartamos la mitad izquierda.

Si es mayor, descartamos la mitad derecha.

Si encontramos el elemento, guardamos su posición y terminamos.

## Solución 8. Comparar búsquedas

```java
void main() {
    int[] numbers = {
        34, 12, 56, 8, 23,
        45, 17, 3, 61, 29,
        14, 50, 6, 38, 20,
        72, 11, 41, 26, 9
    };

    IO.println("Number to search:");
    int target = Integer.parseInt(IO.readln());

    // Linear search

    int linearPosition = -1;
    int linearComparisons = 0;

    for (int i = 0; i < numbers.length; i++) {

        linearComparisons++;

        if (numbers[i] == target) {
            linearPosition = i;
            break;
        }
    }

    // Sort the array using Selection Sort

    for (int i = 0; i < numbers.length - 1; i++) {

        int minIndex = i;

        for (int j = i + 1; j < numbers.length; j++) {

            if (numbers[j] < numbers[minIndex]) {
                minIndex = j;
            }
        }

        int temp = numbers[i];
        numbers[i] = numbers[minIndex];
        numbers[minIndex] = temp;
    }

    // Binary search

    int left = 0;
    int right = numbers.length - 1;

    int binaryPosition = -1;
    int binaryComparisons = 0;

    while (left <= right && binaryPosition == -1) {

        int middle = (left + right) / 2;

        binaryComparisons++;

        if (numbers[middle] == target) {

            binaryPosition = middle;

        } else if (numbers[middle] < target) {

            left = middle + 1;

        } else {

            right = middle - 1;
        }
    }

    // Results

    IO.println("\nLinear search:");

    if (linearPosition == -1) {
        IO.println("Element not found");
    } else {
        IO.println("Found at original position " + linearPosition);
    }

    IO.println("Comparisons: " + linearComparisons);

    IO.println("\nBinary search:");

    if (binaryPosition == -1) {
        IO.println("Element not found");
    } else {
        IO.println("Found at sorted position " + binaryPosition);
    }

    IO.println("Comparisons: " + binaryComparisons);

    IO.println("\nSorted array:");

    for (int i = 0; i < numbers.length; i++) {
        IO.print(numbers[i] + " ");
    }
}
```

**Explicación:**

Este ejercicio permite comparar los dos algoritmos de búsqueda.

Primero realizamos una búsqueda lineal sobre el array original.

Guardamos:

- La posición donde encontramos el elemento.
- El número de comparaciones realizadas.

Después ordenamos el array mediante Selection Sort.

Es importante observar que la búsqueda binaria se realiza sobre el array ordenado.

Finalmente mostramos los resultados.

Hay una diferencia importante entre las posiciones obtenidas:

- `linearPosition` corresponde al array original.
- `binaryPosition` corresponde al array ordenado.

Por tanto, si buscamos un mismo número, las posiciones pueden ser diferentes.

También hay que tener en cuenta que este ejercicio compara el número de comparaciones de las búsquedas, pero no incluye el coste de ordenar el array. Si tenemos que ordenar el array exclusivamente para realizar una búsqueda, ese trabajo también debe tenerse en cuenta.

---

# 9. Resumen

En esta unidad hemos estudiado diferentes algoritmos para buscar y ordenar elementos de un array.

## 9.1. Algoritmos de búsqueda

| Algoritmo | Funcionamiento | Coste |
|---|---|---|
| Búsqueda lineal | Recorre los elementos uno a uno | O(n) |
| Búsqueda binaria | Divide el espacio de búsqueda en mitades | O(log n) |

La búsqueda lineal puede utilizarse sobre cualquier array.

La búsqueda binaria necesita que el array esté previamente ordenado.

## 9.2. Algoritmos de ordenación

| Algoritmo | Funcionamiento | Coste en el peor caso |
|---|---|---|
| Selection Sort | Busca el mínimo y lo coloca en su posición | O(n²) |
| Bubble Sort | Compara e intercambia elementos consecutivos | O(n²) |
| Insertion Sort | Inserta cada elemento en su posición correcta | O(n²) |

## 9.3. Conceptos importantes

- Una búsqueda lineal puede detenerse en la primera coincidencia o continuar para localizar todas las apariciones.
- Para intercambiar dos valores necesitamos una variable auxiliar.
- Selection Sort utiliza una variable para recordar la posición del menor elemento.
- Bubble Sort compara elementos consecutivos y los intercambia cuando están desordenados.
- Insertion Sort desplaza elementos para insertar cada valor en su posición correcta.
- La búsqueda binaria necesita un array ordenado.
- Los bucles anidados permiten implementar los algoritmos de ordenación.

## 9.4. Una última reflexión

Los algoritmos que hemos estudiado son ejemplos de cómo podemos resolver problemas utilizando únicamente las herramientas básicas de programación.

En todos ellos hemos trabajado con:

- Variables.
- Arrays.
- Condicionales.
- Bucles.
- Operaciones de comparación.
- Intercambios y desplazamientos de valores.

Más adelante, cuando estudiemos funciones, podremos reorganizar estos mismos algoritmos para convertirlos en bloques independientes que reciban datos, realicen una tarea y devuelvan un resultado.

De esta manera podremos reutilizarlos en diferentes programas sin tener que escribir de nuevo todo el código.