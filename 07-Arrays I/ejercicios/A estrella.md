# Reto 13. Encontrar el camino más corto en un laberinto mediante A*

Java 26 · Arrays y matrices · Algoritmos de búsqueda

## 1. Enunciado

Vamos a desarrollar un programa capaz de encontrar el camino más corto entre dos posiciones de un laberinto.

Para ello utilizaremos el algoritmo de búsqueda A* (A estrella).

El laberinto estará representado mediante una matriz de números enteros. Cada posición podrá contener uno de los siguientes valores:

| Valor | Significado |
|---|---|
| 0 | Camino libre |
| 1 | Muro |
| 2 | Posición inicial |
| 3 | Destino |

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

El programa debe encontrar un camino desde la posición inicial hasta el destino, evitando los muros.

Solo se permiten movimientos horizontales y verticales:

- Arriba.
- Abajo.
- Izquierda.
- Derecha.

Cada movimiento tiene un coste de 1.

El programa debe mostrar:

1. Si existe un camino hasta el destino.
2. El camino encontrado.
3. La longitud del camino, expresada en número de movimientos.

Si no existe ningún camino, deberá indicarlo.

## 2. ¿Qué es A*?

A* es un algoritmo de búsqueda que permite encontrar caminos de coste mínimo entre dos posiciones.

Su característica principal es que no explora todas las posiciones siguiendo un orden arbitrario, sino que utiliza una estimación de la distancia que falta para llegar al destino.

Para decidir qué posición explorar a continuación, utiliza una función de evaluación:

$$
f(n)=g(n)+h(n)
$$

Donde:

- `g(n)` representa el coste real desde el inicio hasta la posición actual.
- `h(n)` representa una estimación del coste que falta hasta el destino.
- `f(n)` representa el coste total estimado del camino pasando por esa posición.

El algoritmo selecciona siempre la posición pendiente que tenga el menor valor de `f`.

### 2.1. La distancia Manhattan

Para calcular la estimación utilizaremos la distancia Manhattan.

Como únicamente podemos desplazarnos horizontal y verticalmente, podemos calcularla sumando las diferencias absolutas entre las coordenadas:

$$
h(n)=|fila_n-fila_{destino}|+|columna_n-columna_{destino}|
$$

Por ejemplo, si estamos en la posición `(1, 2)` y el destino está en `(4, 5)`:

$$
h(n)=|1-4|+|2-5|=6
$$

La estimación indica que necesitamos al menos seis movimientos para alcanzar el destino.

Es importante entender que esta distancia no tiene en cuenta los muros. Por eso puede ser menor que la distancia real, pero nunca será mayor si todos los movimientos cuestan lo mismo y solo podemos desplazarnos horizontal y verticalmente.

Esta propiedad permite que A* encuentre un camino óptimo.

## 3. Estructuras de datos necesarias

Para implementar A* utilizaremos varias matrices auxiliares.

No necesitamos utilizar colecciones ni estructuras de datos especiales.

### 3.1. Matriz `open`

```java
boolean[][] open;
```

Indica qué posiciones están pendientes de explorar.

Una posición pertenece a la lista abierta cuando sabemos cómo llegar a ella, pero todavía no hemos examinado sus vecinos.

### 3.2. Matriz `closed`

```java
boolean[][] closed;
```

Indica qué posiciones ya hemos explorado.

Cuando terminamos de explorar una posición, la marcamos como cerrada para no volver a procesarla.

### 3.3. Matriz `gScore`

```java
int[][] gScore;
```

Almacena el coste real del camino más corto que conocemos desde el inicio hasta cada posición.

Inicialmente todas las posiciones tendrán un coste infinito, porque todavía no conocemos ningún camino hasta ellas.

La posición inicial tendrá un coste de cero.

### 3.4. Matrices `parentRow` y `parentColumn`

```java
int[][] parentRow;
int[][] parentColumn;
```

Permiten recordar desde qué posición hemos llegado a cada casilla.

Por ejemplo, si hemos llegado a `(2, 3)` desde `(2, 2)`, almacenaremos:

```text
parentRow[2][3] = 2
parentColumn[2][3] = 2
```

Estas matrices serán necesarias para reconstruir el camino una vez encontrado el destino.

## 4. Funcionamiento del algoritmo

El algoritmo seguirá estos pasos:

1. Localizar la posición inicial y el destino.
2. Inicializar las matrices auxiliares.
3. Introducir la posición inicial en la lista abierta.
4. Buscar en la lista abierta la posición que tenga el menor valor de `f`.
5. Sacar esa posición de la lista abierta y marcarla como explorada.
6. Si es el destino, hemos terminado.
7. En caso contrario, examinar sus cuatro posiciones vecinas.
8. Para cada vecino válido, calcular el coste de llegar hasta él.
9. Si hemos encontrado un camino mejor, actualizar su coste y recordar desde dónde hemos llegado.
10. Continuar hasta encontrar el destino o quedarnos sin posiciones pendientes.

La búsqueda termina cuando encontramos el destino o cuando la lista abierta queda vacía.

## 5. Implementación completa en Java 26

En esta implementación representaremos la lista abierta mediante una matriz de booleanos.

Para seleccionar la siguiente posición que debemos explorar, recorreremos la matriz buscando la posición abierta que tenga el menor valor de `f`.

Esta implementación no utiliza una cola de prioridad, por lo que la selección de la siguiente posición no es tan eficiente como en una implementación profesional de A*. Sin embargo, permite trabajar con el algoritmo utilizando únicamente arrays y matrices.

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

    // Matrices auxiliares.
    boolean[][] open = new boolean[rows][columns];
    boolean[][] closed = new boolean[rows][columns];

    int[][] gScore = new int[rows][columns];

    int[][] parentRow = new int[rows][columns];
    int[][] parentColumn = new int[rows][columns];

    // Un camino óptimo nunca necesita visitar más de
    // rows * columns - 1 posiciones.
    int infinity = rows * columns + 1;

    // Localizar las posiciones inicial y final.
    int startRow = -1;
    int startColumn = -1;

    int endRow = -1;
    int endColumn = -1;

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

            // Inicializar los costes.
            gScore[row][column] = infinity;

            // Inicializar los padres.
            parentRow[row][column] = -1;
            parentColumn[row][column] = -1;
        }
    }

    // Comprobar que existen el inicio y el destino.
    boolean found = false;

    if (startRow != -1 && endRow != -1) {

        // El coste para llegar al inicio es cero.
        gScore[startRow][startColumn] = 0;

        // Introducir el inicio en la lista abierta.
        open[startRow][startColumn] = true;

        // Desplazamientos posibles: arriba, derecha,
        // abajo e izquierda.
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        // Comenzar la búsqueda.
        boolean searching = true;

        while (searching) {

            // Buscar la posición abierta con menor f.
            int bestRow = -1;
            int bestColumn = -1;
            int bestF = infinity;

            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {

                    if (open[row][column]) {

                        int g = gScore[row][column];

                        int h = Math.abs(row - endRow)
                              + Math.abs(column - endColumn);

                        int f = g + h;

                        if (f < bestF) {
                            bestF = f;
                            bestRow = row;
                            bestColumn = column;
                        }
                    }
                }
            }

            // Si no quedan posiciones pendientes,
            // no existe ningún camino.
            if (bestRow == -1) {
                searching = false;
            } else {

                // Extraer la mejor posición de la lista abierta.
                open[bestRow][bestColumn] = false;

                // Marcarla como explorada.
                closed[bestRow][bestColumn] = true;

                // Comprobar si hemos llegado al destino.
                if (bestRow == endRow && bestColumn == endColumn) {

                    found = true;
                    searching = false;

                } else {

                    // Examinar los cuatro vecinos.
                    for (int direction = 0;
                         direction < 4;
                         direction++) {

                        int neighborRow = bestRow + dr[direction];
                        int neighborColumn = bestColumn + dc[direction];

                        // Comprobar que el vecino está dentro
                        // de los límites del laberinto.
                        if (neighborRow >= 0
                                && neighborRow < rows
                                && neighborColumn >= 0
                                && neighborColumn < columns) {

                            // No atravesar muros ni volver a
                            // explorar posiciones cerradas.
                            if (maze[neighborRow][neighborColumn] != 1
                                    && !closed[neighborRow][neighborColumn]) {

                                // Calcular el coste de llegar
                                // al vecino pasando por la posición actual.
                                int tentativeG = gScore[bestRow][bestColumn] + 1;

                                // Comprobar si hemos encontrado
                                // un camino mejor.
                                if (tentativeG < gScore[neighborRow][neighborColumn]) {

                                    // Actualizar el coste.
                                    gScore[neighborRow][neighborColumn] = tentativeG;

                                    // Recordar desde dónde hemos llegado.
                                    parentRow[neighborRow][neighborColumn] = bestRow;
                                    parentColumn[neighborRow][neighborColumn] = bestColumn;

                                    // Introducir el vecino en la lista abierta.
                                    open[neighborRow][neighborColumn] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // Mostrar el resultado.
    if (found) {

        // Crear una matriz para representar el camino.
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

        // Reconstruir el camino desde el destino
        // hasta la posición inicial.
        int currentRow = endRow;
        int currentColumn = endColumn;

        while (currentRow != startRow
                || currentColumn != startColumn) {

            path[currentRow][currentColumn] = '*';

            int previousRow = parentRow[currentRow][currentColumn];
            int previousColumn = parentColumn[currentRow][currentColumn];

            currentRow = previousRow;
            currentColumn = previousColumn;
        }

        // Marcar las posiciones inicial y final.
        path[startRow][startColumn] = 'S';
        path[endRow][endColumn] = 'E';

        // Mostrar el camino.
        IO.println("Camino encontrado:");

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                IO.print(path[row][column] + " ");
            }

            IO.println();
        }

        IO.println("Longitud del camino: "
                + gScore[endRow][endColumn]);

    } else {
        IO.println("No existe ningún camino.");
    }
}
```

## 6. Resultado esperado

Para el laberinto del ejemplo, el programa encuentra el siguiente camino:

```text
S * # . .
# * # . #
. * * * #
# # # * *
. . . . E
```

La longitud del camino es:

```text
Longitud del camino: 8
```

El camino encontrado es:

```text
(0,0)
  |
(0,1)
  |
(1,1)
  |
(2,1) -- (2,2) -- (2,3)
                         |
                       (3,3) -- (3,4)
                                  |
                                (4,4)
```

## 7. Entender la reconstrucción del camino

Una vez alcanzado el destino, ya conocemos el coste mínimo para llegar hasta él.

Pero todavía necesitamos averiguar qué posiciones forman ese camino.

Para ello utilizamos las matrices `parentRow` y `parentColumn`.

Cuando llegamos a una posición, guardamos las coordenadas de la posición desde la que hemos llegado.

Por ejemplo:

```text
Posición actual:       (2, 3)
Posición anterior:     (2, 2)
```

Por tanto:

```java
parentRow[2][3] = 2;
parentColumn[2][3] = 2;
```

Una vez alcanzado el destino, hacemos el recorrido inverso:

1. Empezamos en el destino.
2. Consultamos su posición anterior.
3. Nos desplazamos a esa posición.
4. Volvemos a consultar su posición anterior.
5. Repetimos hasta llegar al inicio.

De esta manera reconstruimos el camino sin necesidad de guardar una lista de posiciones.

## 8. ¿Por qué A* encuentra el camino más corto?

En nuestro problema todos los movimientos tienen un coste de 1.

Además, utilizamos la distancia Manhattan como heurística.

Esta heurística nunca sobreestima el coste real que falta para alcanzar el destino, porque ignora los obstáculos y calcula la distancia mínima posible sin ellos.

Por tanto, es una heurística admisible.

También es consistente: el valor de la heurística no puede disminuir más de lo que cuesta realizar un movimiento.

Gracias a estas propiedades, cuando una posición se extrae de la lista abierta con el menor valor de `f`, su coste real ya es óptimo.

Por eso podemos marcarla como cerrada y no necesitamos volver a explorarla.

## 9. Mejoras y ampliaciones

Una vez que el programa funcione, se pueden plantear diferentes ampliaciones.

### Ampliación 1. Mostrar el coste estimado

Modificar el programa para mostrar los valores de `g`, `h` y `f` de cada posición cuando se selecciona para explorar.

Esto permitirá observar cómo funciona la selección de posiciones de A*.

### Ampliación 2. Contar las posiciones exploradas

Añadir un contador que indique cuántas posiciones se han extraído de la lista abierta.

Así podremos comparar el comportamiento de A* con otros algoritmos de búsqueda.

### Ampliación 3. Comparar A* con búsqueda en anchura

Implementar BFS para resolver el mismo laberinto y comparar:

- Longitud del camino encontrado.
- Número de posiciones exploradas.

Como todos los movimientos tienen el mismo coste, BFS también encuentra el camino más corto.

Sin embargo, no utiliza ninguna estimación de la distancia al destino.

### Ampliación 4. Permitir movimientos diagonales

Modificar el algoritmo para permitir desplazamientos diagonales.

En ese caso, habría que adaptar:

- Las direcciones posibles.
- El coste de los movimientos diagonales.
- La función heurística.

Por ejemplo, si los movimientos horizontales y verticales cuestan 1 y los diagonales cuestan aproximadamente 1,414, se puede utilizar la distancia octil como heurística.

### Ampliación 5. Laberintos generados aleatoriamente

Crear un laberinto aleatorio con un tamaño determinado.

Después, ejecutar A* para encontrar un camino desde el inicio hasta el destino.

El programa deberá indicar si existe una solución.

### Ampliación 6. Dibujar el proceso de búsqueda

En lugar de mostrar únicamente el camino final, representar también:

- Las posiciones pendientes de explorar.
- Las posiciones que ya se han explorado.
- Los muros.
- El camino final.

Esto permite visualizar cómo A* va descubriendo el laberinto.

---

## 10. Consideraciones sobre la implementación

Esta versión utiliza una matriz `open` y busca la posición con menor `f` recorriendo todas las casillas del laberinto.

Es una implementación sencilla de comprender, pero no es la más eficiente.

En una implementación más avanzada, la lista abierta se representa mediante una cola de prioridad, que permite obtener rápidamente la posición con menor valor de `f`.

La complejidad de nuestra implementación puede llegar a ser:

$$
O(V^2)
$$

donde \(V\) es el número de casillas transitables del laberinto.

Con una cola de prioridad, la selección de la siguiente posición resulta mucho más eficiente.

**Lo interesante de esta práctica no es conseguir la implementación más rápida, sino comprender cómo se combinan los arrays, las matrices, los costes y una heurística para resolver un problema de búsqueda.**