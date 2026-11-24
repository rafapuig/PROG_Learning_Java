# Introducción a las operaciones con vectores y matrices

## 1. Introducción

En programación y matemáticas aparecen con frecuencia dos estructuras que permiten representar y trabajar con información relacionada: los vectores y las matrices.

Un **vector** es una estructura que permite representar una serie de componentes. En el plano bidimensional utilizaremos vectores con dos componentes, que representarán las coordenadas X e Y.

Una **matriz** es una estructura formada por filas y columnas. Nos permitirá representar, entre otras cosas, conjuntos de valores y operaciones matemáticas.

En Java podemos utilizar arrays para representar ambas estructuras:

- Un vector de dos componentes se representa mediante un array `double[]`.
- Una matriz se representa mediante un array bidimensional `double[][]`.

Por ejemplo:

```java
double[] vector = {3, 4};

double[][] matrix = {
    {1, 2},
    {3, 4}
};
```

En este documento vamos a estudiar cómo operar con vectores y matrices y cómo utilizar estas operaciones para realizar transformaciones geométricas en el plano.

---

## 2. Vectores en el plano

Un vector en el plano bidimensional está formado por dos componentes:

- Componente X: representa el desplazamiento o la posición horizontal.
- Componente Y: representa el desplazamiento o la posición vertical.

Matemáticamente, podemos representar un vector de la siguiente forma:

$$
V =
\begin{pmatrix}
x\\
y
\end{pmatrix}
$$

Por ejemplo:

$$
V =
\begin{pmatrix}
3\\
4
\end{pmatrix}
$$

En Java podemos representarlo mediante un array:

```java
double[] vector = {3, 4};
```

Para acceder a sus componentes utilizamos los índices:

```java
double x = vector[0];
double y = vector[1];
```

### 2.1. Diferencia entre punto y vector

Aunque podemos representar ambos mediante dos coordenadas, un punto y un vector tienen significados diferentes.

Un **punto** representa una posición concreta dentro del plano.

Un **vector** representa una dirección y una magnitud, es decir, un desplazamiento.

Por ejemplo:

- El punto `(3, 4)` indica una posición.
- El vector `(3, 4)` indica un desplazamiento de 3 unidades en X y 4 unidades en Y.

Esta distinción será importante cuando trabajemos con transformaciones geométricas.

---

## 3. Operaciones con vectores

Los vectores permiten realizar diferentes operaciones matemáticas. Vamos a estudiar las más habituales.

### 3.1. Suma de vectores

La suma de dos vectores consiste en sumar sus componentes correspondientes.

Dados los vectores:

$$
A =
\begin{pmatrix}
a_x\\
a_y
\end{pmatrix}
\qquad
B =
\begin{pmatrix}
b_x\\
b_y
\end{pmatrix}
$$

Su suma es:

$$
A+B =
\begin{pmatrix}
a_x+b_x\\
a_y+b_y
\end{pmatrix}
$$

Por ejemplo:

$$
A =
\begin{pmatrix}
2\\
3
\end{pmatrix}
\qquad
B =
\begin{pmatrix}
4\\
1
\end{pmatrix}
$$

El resultado será:

$$
A+B =
\begin{pmatrix}
2+4\\
3+1
\end{pmatrix}
=
\begin{pmatrix}
6\\
4
\end{pmatrix}
$$

En Java:

```java
double[] a = {2, 3};
double[] b = {4, 1};

double[] result = new double[2];

result[0] = a[0] + b[0];
result[1] = a[1] + b[1];
```

### 3.2. Resta de vectores

La resta funciona de forma similar a la suma, pero restando las componentes correspondientes.

$$
A-B =
\begin{pmatrix}
a_x-b_x\\
a_y-b_y
\end{pmatrix}
$$

Por ejemplo:

$$
A =
\begin{pmatrix}
5\\
7
\end{pmatrix}
\qquad
B =
\begin{pmatrix}
2\\
3
\end{pmatrix}
$$

Entonces:

$$
A-B =
\begin{pmatrix}
5-2\\
7-3
\end{pmatrix}
=
\begin{pmatrix}
3\\
4
\end{pmatrix}
$$

En Java:

```java
double[] a = {5, 7};
double[] b = {2, 3};

double[] result = new double[2];

result[0] = a[0] - b[0];
result[1] = a[1] - b[1];
```

### 3.3. Multiplicación de un vector por un escalar

Un escalar es un número que permite multiplicar todas las componentes de un vector.

Si multiplicamos un vector por un número `k`, obtenemos:

$$
k \cdot V =
\begin{pmatrix}
k \cdot x\\
k \cdot y
\end{pmatrix}
$$

Por ejemplo:

$$
V =
\begin{pmatrix}
3\\
4
\end{pmatrix}
\qquad
k=2
$$

El resultado será:

$$
2 \cdot V =
\begin{pmatrix}
6\\
8
\end{pmatrix}
$$

En Java:

```java
double[] vector = {3, 4};
double factor = 2;

double[] result = new double[2];

result[0] = vector[0] * factor;
result[1] = vector[1] * factor;
```

### 3.4. Módulo o longitud de un vector

El módulo de un vector representa su longitud.

Para calcularlo utilizamos el teorema de Pitágoras:

$$
|V| = \sqrt{x^2+y^2}
$$

Por ejemplo, para el vector:

$$
V =
\begin{pmatrix}
3\\
4
\end{pmatrix}
$$

Su módulo será:

$$
|V| = \sqrt{3^2+4^2}
$$

$$
|V| = \sqrt{9+16} = \sqrt{25}=5
$$

En Java podemos utilizar `Math.sqrt()`:

```java
double[] vector = {3, 4};

double length = Math.sqrt(
    vector[0] * vector[0] +
    vector[1] * vector[1]
);
```

### 3.5. Producto escalar

El producto escalar de dos vectores consiste en multiplicar sus componentes correspondientes y sumar los resultados.

Dados dos vectores:

$$
A =
\begin{pmatrix}
a_x\\
a_y
\end{pmatrix}
\qquad
B =
\begin{pmatrix}
b_x\\
b_y
\end{pmatrix}
$$

Su producto escalar es:

$$
A \cdot B = a_x \cdot b_x + a_y \cdot b_y
$$

Por ejemplo:

$$
A =
\begin{pmatrix}
2\\
3
\end{pmatrix}
\qquad
B =
\begin{pmatrix}
4\\
5
\end{pmatrix}
$$

Entonces:

$$
A \cdot B = 2 \cdot 4 + 3 \cdot 5 = 23
$$

En Java:

```java
double[] a = {2, 3};
double[] b = {4, 5};

double result = a[0] * b[0] + a[1] * b[1];
```

El resultado del producto escalar es un número, no otro vector.

---

## 4. Matrices

Una matriz es una estructura formada por filas y columnas.

Podemos representar una matriz de dos filas y dos columnas de la siguiente forma:

$$
A =
\begin{pmatrix}
a_{11} & a_{12}\\
a_{21} & a_{22}
\end{pmatrix}
$$

En Java utilizaremos un array bidimensional:

```java
double[][] matrix = {
    {1, 2},
    {3, 4}
};
```

Podemos acceder a sus elementos indicando primero la fila y después la columna:

```java
double value = matrix[0][1];
```

En este ejemplo, el resultado será `2`.

### 4.1. Dimensiones de una matriz

Las dimensiones de una matriz indican el número de filas y columnas que tiene.

Por ejemplo, la siguiente matriz tiene 2 filas y 3 columnas:

$$
A =
\begin{pmatrix}
1 & 2 & 3\\
4 & 5 & 6
\end{pmatrix}
$$

En Java:

```java
double[][] matrix = {
    {1, 2, 3},
    {4, 5, 6}
};
```

Podemos consultar sus dimensiones utilizando `length`:

```java
int rows = matrix.length;
int columns = matrix[0].length;
```

En este caso:

- `matrix.length` devuelve 2.
- `matrix[0].length` devuelve 3.

Recordemos que en Java los arrays bidimensionales son realmente arrays de arrays. Por tanto, no es obligatorio que todas las filas tengan la misma longitud.

---

## 5. Operaciones con matrices

Las matrices permiten realizar operaciones similares a las que hemos estudiado con los vectores.

Para los ejemplos siguientes utilizaremos matrices de dos filas y dos columnas.

### 5.1. Suma de matrices

Para sumar dos matrices deben tener las mismas dimensiones.

La suma se realiza elemento a elemento:

$$
A+B =
\begin{pmatrix}
a_{11}+b_{11} & a_{12}+b_{12}\\
a_{21}+b_{21} & a_{22}+b_{22}
\end{pmatrix}
$$

Por ejemplo:

$$
A =
\begin{pmatrix}
1 & 2\\
3 & 4
\end{pmatrix}
\qquad
B =
\begin{pmatrix}
5 & 6\\
7 & 8
\end{pmatrix}
$$

El resultado será:

$$
A+B =
\begin{pmatrix}
6 & 8\\
10 & 12
\end{pmatrix}
$$

En Java podemos utilizar dos bucles para recorrer las matrices:

```java
double[][] a = {
    {1, 2},
    {3, 4}
};

double[][] b = {
    {5, 6},
    {7, 8}
};

double[][] result = new double[2][2];

for (int row = 0; row < 2; row++) {
    for (int col = 0; col < 2; col++) {
        result[row][col] = a[row][col] + b[row][col];
    }
}
```

### 5.2. Resta de matrices

La resta también se realiza elemento a elemento y requiere que ambas matrices tengan las mismas dimensiones.

$$
A-B =
\begin{pmatrix}
a_{11}-b_{11} & a_{12}-b_{12}\\
a_{21}-b_{21} & a_{22}-b_{22}
\end{pmatrix}
$$

Por ejemplo:

$$
A =
\begin{pmatrix}
8 & 7\\
6 & 5
\end{pmatrix}
\qquad
B =
\begin{pmatrix}
1 & 2\\
3 & 4
\end{pmatrix}
$$

Entonces:

$$
A-B =
\begin{pmatrix}
7 & 5\\
3 & 1
\end{pmatrix}
$$

En Java:

```java
double[][] result = new double[2][2];

for (int row = 0; row < 2; row++) {
    for (int col = 0; col < 2; col++) {
        result[row][col] = a[row][col] - b[row][col];
    }
}
```

### 5.3. Multiplicación de una matriz por un escalar

Podemos multiplicar todos los elementos de una matriz por un número.

$$
k \cdot A =
\begin{pmatrix}
k \cdot a_{11} & k \cdot a_{12}\\
k \cdot a_{21} & k \cdot a_{22}
\end{pmatrix}
$$

Por ejemplo:

$$
A =
\begin{pmatrix}
1 & 2\\
3 & 4
\end{pmatrix}
\qquad
k=3
$$

El resultado será:

$$
3 \cdot A =
\begin{pmatrix}
3 & 6\\
9 & 12
\end{pmatrix}
$$

En Java:

```java
double[][] matrix = {
    {1, 2},
    {3, 4}
};

double factor = 3;

double[][] result = new double[2][2];

for (int row = 0; row < 2; row++) {
    for (int col = 0; col < 2; col++) {
        result[row][col] = matrix[row][col] * factor;
    }
}
```

---

## 6. Transformaciones geométricas en el plano

Una transformación geométrica permite modificar la posición, el tamaño o la orientación de una figura.

Para estudiar estas transformaciones utilizaremos puntos representados mediante sus coordenadas X e Y.

Un punto se puede representar como un vector columna:

$$
P =
\begin{pmatrix}
x\\
y
\end{pmatrix}
$$

En Java podemos representar un punto mediante un array:

```java
double[] point = {3, 4};
```

Las transformaciones que estudiaremos son la traslación, el escalado, el espejado y la rotación.

### 6.1. Traslación

Una traslación consiste en desplazar una figura de una posición a otra sin modificar su tamaño ni su orientación.

Para realizarla necesitamos un vector de desplazamiento:

$$
T =
\begin{pmatrix}
t_x\\
t_y
\end{pmatrix}
$$

Las nuevas coordenadas se obtienen sumando el vector de desplazamiento a las coordenadas originales:

$$
P'=P+T
$$

Por tanto:

$$
\begin{cases}
x'=x+t_x\\
y'=y+t_y
\end{cases}
$$

Por ejemplo, si tenemos el punto:

$$
P =
\begin{pmatrix}
3\\
4
\end{pmatrix}
$$

Y queremos desplazarlo 2 unidades a la derecha y 1 unidad hacia abajo:

$$
T =
\begin{pmatrix}
2\\
-1
\end{pmatrix}
$$

El resultado será:

$$
P' =
\begin{pmatrix}
3+2\\
4-1
\end{pmatrix}
=
\begin{pmatrix}
5\\
3
\end{pmatrix}
$$

En Java:

```java
double[] point = {3, 4};

double translateX = 2;
double translateY = -1;

double[] result = new double[2];

result[0] = point[0] + translateX;
result[1] = point[1] + translateY;
```

Si queremos trasladar una figura formada por varios puntos, tendremos que aplicar la misma operación a cada uno de ellos.

**Importante:** la traslación no se puede representar mediante una matriz de 2x2 multiplicada directamente por un vector de coordenadas 2D. Más adelante veremos cómo representarla mediante coordenadas homogéneas y matrices de 3x3.

### 6.2. Escalado

El escalado permite aumentar o reducir el tamaño de una figura.

Para ello utilizamos una matriz de transformación:

$$
S =
\begin{pmatrix}
s_x & 0\\
0 & s_y
\end{pmatrix}
$$

Donde:

- $s_x$ es el factor de escala horizontal.
- $s_y$ es el factor de escala vertical.

Aplicamos la transformación multiplicando la matriz por el vector de coordenadas:

$$
P'=S \cdot P
$$

Desarrollando la multiplicación:

$$
\begin{cases}
x'=s_x \cdot x\\
y'=s_y \cdot y
\end{cases}
$$

Por ejemplo, si queremos duplicar el tamaño de una figura, utilizaremos un factor de escala de 2 en ambos ejes:

$$
S =
\begin{pmatrix}
2 & 0\\
0 & 2
\end{pmatrix}
$$

El punto $(3,4)$ se transformará en:

$$
P' =
\begin{pmatrix}
2 & 0\\
0 & 2
\end{pmatrix}
\cdot
\begin{pmatrix}
3\\
4
\end{pmatrix}
=
\begin{pmatrix}
6\\
8
\end{pmatrix}
$$

Si utilizamos factores diferentes para X e Y, modificaremos las proporciones de la figura.

### 6.3. Espejado

El espejado permite invertir una figura respecto a uno de los ejes de coordenadas.

**Espejado horizontal**

Invierte la coordenada X:

$$
M_x =
\begin{pmatrix}
-1 & 0\\
0 & 1
\end{pmatrix}
$$

**Espejado vertical**

Invierte la coordenada Y:

$$
M_y =
\begin{pmatrix}
1 & 0\\
0 & -1
\end{pmatrix}
$$

En ambos casos aplicamos la transformación mediante:

$$
P'=M \cdot P
$$

Por ejemplo, al espejar horizontalmente el punto $(3,4)$:

$$
P' =
\begin{pmatrix}
-1 & 0\\
0 & 1
\end{pmatrix}
\cdot
\begin{pmatrix}
3\\
4
\end{pmatrix}
=
\begin{pmatrix}
-3\\
4
\end{pmatrix}
$$

El resultado es un punto situado a la misma distancia del eje Y, pero en el lado contrario.

### 6.4. Rotación

Una rotación permite girar una figura alrededor del origen de coordenadas.

La matriz de rotación para un ángulo $\theta$ es:

$$
R =
\begin{pmatrix}
\cos(\theta) & -\sin(\theta)\\
\sin(\theta) & \cos(\theta)
\end{pmatrix}
$$

Aplicamos la transformación:

$$
P'=R \cdot P
$$

Desarrollando la multiplicación:

$$
\begin{cases}
x'=x\cos(\theta)-y\sin(\theta)\\
y'=x\sin(\theta)+y\cos(\theta)
\end{cases}
$$

Por ejemplo, una rotación de 90 grados utiliza la matriz:

$$
R =
\begin{pmatrix}
0 & -1\\
1 & 0
\end{pmatrix}
$$

Al aplicarla al punto $(3,4)$ obtenemos:

$$
P' =
\begin{pmatrix}
0 & -1\\
1 & 0
\end{pmatrix}
\cdot
\begin{pmatrix}
3\\
4
\end{pmatrix}
=
\begin{pmatrix}
-4\\
3
\end{pmatrix}
$$

En Java, las funciones trigonométricas de la clase `Math` trabajan con radianes. Para convertir grados a radianes podemos utilizar:

```java
double radians = Math.toRadians(90);
```

**Nota sobre los sistemas de coordenadas gráficos:** las fórmulas anteriores utilizan un sistema cartesiano donde el eje Y crece hacia arriba. En los sistemas gráficos de pantalla, como el utilizado habitualmente en Jaylib, el eje Y crece hacia abajo. Por tanto, el sentido visual de las rotaciones puede invertirse.

### 6.5. Combinación de transformaciones

Podemos aplicar varias transformaciones consecutivamente sobre un mismo punto o sobre todos los puntos de una figura.

Por ejemplo:

1. Escalar una figura.
2. Rotarla.
3. Trasladarla a otra posición.

Las transformaciones de escalado, espejado y rotación se pueden representar mediante matrices de 2x2.

La traslación, en cambio, se realiza sumando un vector de desplazamiento.

Es importante recordar que el orden de aplicación de las transformaciones puede cambiar el resultado.

Por ejemplo, no es lo mismo escalar una figura y después trasladarla que trasladarla y después escalarla.

---

## 7. Multiplicación de matrices por vectores

Una de las operaciones más importantes cuando trabajamos con transformaciones geométricas es la multiplicación de una matriz por un vector.

Para poder realizar esta operación, el número de columnas de la matriz debe coincidir con el número de componentes del vector.

Por ejemplo, podemos multiplicar una matriz de 2x2 por un vector de dos componentes:

$$
A =
\begin{pmatrix}
a_{11} & a_{12}\\
a_{21} & a_{22}
\end{pmatrix}
\qquad
V =
\begin{pmatrix}
x\\
y
\end{pmatrix}
$$

El resultado será otro vector de dos componentes:

$$
A \cdot V =
\begin{pmatrix}
a_{11}\cdot x+a_{12}\cdot y\\
a_{21}\cdot x+a_{22}\cdot y
\end{pmatrix}
$$

Por ejemplo:

$$
A =
\begin{pmatrix}
1 & 2\\
3 & 4
\end{pmatrix}
\qquad
V =
\begin{pmatrix}
5\\
6
\end{pmatrix}
$$

Calculamos cada componente del resultado:

$$
x'=1\cdot5+2\cdot6=17
$$

$$
y'=3\cdot5+4\cdot6=39
$$

Por tanto:

$$
A \cdot V =
\begin{pmatrix}
17\\
39
\end{pmatrix}
$$

### 7.1. Implementación en Java

Podemos representar la matriz mediante un array bidimensional y el vector mediante un array normal:

```java
double[][] matrix = {
    {1, 2},
    {3, 4}
};

double[] vector = {5, 6};

double[] result = new double[2];

for (int row = 0; row < 2; row++) {
    result[row] = 0;

    for (int col = 0; col < 2; col++) {
        result[row] += matrix[row][col] * vector[col];
    }
}
```

El bucle exterior recorre las filas de la matriz.

El bucle interior multiplica cada elemento de una fila por la componente correspondiente del vector y acumula los resultados.

Al terminar cada iteración del bucle exterior, tenemos calculada una componente del vector resultante.

---

## 8. Aplicación de las transformaciones a figuras

Hasta ahora hemos aplicado las operaciones a vectores individuales, pero podemos utilizarlas para transformar figuras completas.

Una figura geométrica se puede representar mediante un conjunto de puntos.

Por ejemplo, un triángulo está formado por tres puntos:

$$
P_1=(1,1)
$$

$$
P_2=(4,1)
$$

$$
P_3=(2,4)
$$

En Java podemos almacenar todos sus puntos en una matriz:

```java
double[][] triangle = {
    {1, 1},
    {4, 1},
    {2, 4}
};
```

Cada fila representa un punto:

- `triangle[0]` contiene las coordenadas del primer punto.
- `triangle[1]` contiene las coordenadas del segundo punto.
- `triangle[2]` contiene las coordenadas del tercer punto.

### 8.1. Transformar todos los puntos de una figura

Para transformar una figura completa, basta con recorrer todos sus puntos y aplicar la transformación correspondiente.

Por ejemplo, para trasladar el triángulo:

```java
double translateX = 3;
double translateY = 2;

double[][] result = new double[triangle.length][2];

for (int i = 0; i < triangle.length; i++) {
    result[i][0] = triangle[i][0] + translateX;
    result[i][1] = triangle[i][1] + translateY;
}
```

De esta forma obtenemos una nueva figura con las mismas dimensiones y orientación, pero desplazada.

### 8.2. Aplicar una transformación matricial a una figura

También podemos aplicar una transformación matricial a todos los puntos de una figura.

Por ejemplo, para escalar el triángulo:

```java
double[][] scale = {
    {2, 0},
    {0, 2}
};

double[][] result = new double[triangle.length][2];

for (int i = 0; i < triangle.length; i++) {
    for (int row = 0; row < 2; row++) {
        result[i][row] = 0;

        for (int col = 0; col < 2; col++) {
            result[i][row] += scale[row][col] * triangle[i][col];
        }
    }
}
```

El procedimiento es el mismo que hemos utilizado para multiplicar una matriz por un vector, pero repetido para cada punto de la figura.

### 8.3. Transformaciones consecutivas

Podemos aplicar varias transformaciones a una misma figura.

Por ejemplo:

1. Escalar todos sus puntos.
2. Rotar todos sus puntos.
3. Trasladar todos sus puntos.

Para ello, el resultado de cada transformación se utiliza como entrada de la siguiente.

Es importante respetar el orden, porque cambiarlo puede producir una figura situada en una posición diferente.

---

## 9. Ejercicios propuestos

Los siguientes ejercicios permiten practicar las operaciones con vectores y matrices y su aplicación a transformaciones geométricas.

Se deben resolver utilizando arrays, variables, operadores y estructuras de control. No es necesario utilizar funciones propias ni clases auxiliares.

### Bloque 1. Operaciones con vectores

**Ejercicio 1. Suma de vectores**

Declara dos vectores de dos componentes con valores iniciales y calcula su suma.

Muestra por pantalla el resultado.

**Ejercicio 2. Resta de vectores**

Declara dos vectores de dos componentes y calcula la resta del segundo al primero.

Muestra las coordenadas del vector resultante.

**Ejercicio 3. Multiplicación por un escalar**

Declara un vector de dos componentes y un número que actuará como escalar.

Calcula el resultado de multiplicar el vector por dicho número.

**Ejercicio 4. Módulo de un vector**

Declara un vector de dos componentes y calcula su módulo.

Recuerda que debes utilizar la fórmula:

$$
|V|=\sqrt{x^2+y^2}
$$

**Ejercicio 5. Distancia entre dos puntos**

Declara dos puntos del plano, cada uno representado mediante un array de dos componentes.

Calcula la distancia entre ambos puntos.

Puedes obtener primero el vector que los separa y calcular después su módulo.

**Ejercicio 6. Producto escalar de dos vectores**

Declara dos vectores y calcula su producto escalar.

Muestra el resultado, que será un único número.

**Ejercicio 7. Operaciones con tres vectores**

Declara tres vectores de dos componentes.

Calcula el resultado de sumar los tres vectores y multiplícalo después por un escalar.

Muestra el vector resultante.

### Bloque 2. Operaciones con matrices

**Ejercicio 8. Suma de matrices**

Declara dos matrices de 2x2 y calcula su suma.

Almacena el resultado en una tercera matriz y muestra sus elementos.

**Ejercicio 9. Resta de matrices**

Declara dos matrices de 2x2 y calcula su resta.

Muestra la matriz resultante.

**Ejercicio 10. Multiplicación de una matriz por un escalar**

Declara una matriz de 2x2 y un número.

Multiplica todos los elementos de la matriz por ese número y muestra el resultado.

**Ejercicio 11. Operaciones con matrices de 3x2**

Declara dos matrices de 3 filas y 2 columnas.

Calcula su suma y su resta.

Utiliza bucles anidados para recorrer sus elementos.

### Bloque 3. Multiplicación de matrices y vectores

**Ejercicio 12. Multiplicación de una matriz por un vector**

Declara una matriz de 2x2 y un vector de dos componentes.

Multiplica la matriz por el vector y muestra el vector resultante.

**Ejercicio 13. Matriz identidad**

La matriz identidad es una matriz cuadrada que tiene unos en su diagonal principal y ceros en el resto de posiciones.

La matriz identidad de 2x2 es:

$$
I =
\begin{pmatrix}
1 & 0\\
0 & 1
\end{pmatrix}
$$

Declara un vector y multiplícalo por la matriz identidad.

Comprueba que el resultado es el mismo vector original.

### Bloque 4. Transformaciones geométricas

**Ejercicio 14. Traslación de un punto**

Declara un punto mediante un array de dos componentes.

Solicita o establece dos valores que representarán el desplazamiento horizontal y vertical.

Calcula las nuevas coordenadas del punto aplicando la traslación.

Muestra tanto las coordenadas originales como las transformadas.

**Ejercicio 15. Escalado de un punto**

Declara un punto y una matriz de escalado de 2x2.

Multiplica la matriz por el punto y muestra las nuevas coordenadas.

Prueba con diferentes factores de escala para comprobar cómo cambia el resultado.

**Ejercicio 16. Espejado de un punto**

Declara un punto y aplica sobre él las matrices de espejado horizontal y vertical.

Muestra las coordenadas obtenidas en cada caso.

**Ejercicio 17. Rotación de un punto**

Declara un punto y un ángulo de rotación expresado en grados.

Convierte el ángulo a radianes y construye la matriz de rotación utilizando `Math.sin()` y `Math.cos()`.

Multiplica la matriz por el punto y muestra las nuevas coordenadas.

### Bloque 5. Transformaciones de figuras

**Ejercicio 18. Transformación de una figura completa**

Declara una figura formada por cuatro puntos y almacena sus coordenadas en una matriz de cuatro filas y dos columnas.

Aplica las siguientes transformaciones a todos sus puntos:

1. Traslada la figura mediante un vector de desplazamiento.
2. Escala la figura utilizando una matriz de escalado.
3. Espeja la figura horizontalmente.
4. Rota la figura 90 grados.

Almacena los resultados de cada transformación en nuevas matrices.

Muestra las coordenadas originales y las obtenidas después de cada transformación.

**Ejercicio 19. Combinación de transformaciones**

Utiliza la figura del ejercicio anterior.

Aplica dos transformaciones consecutivas:

1. Escala la figura.
2. Traslada el resultado.

Después repite las operaciones en el orden contrario:

1. Traslada la figura.
2. Escala el resultado.

Compara las coordenadas finales y comprueba si ambos resultados son iguales.

**Ejercicio 20. Transformaciones sucesivas de una figura**

Declara una figura formada por varios puntos.

Realiza un programa que aplique sucesivamente las siguientes transformaciones:

1. Escalado.
2. Rotación.
3. Traslación.

Almacena las coordenadas después de cada transformación y muestra los resultados.

Comprueba cómo cambia la posición y el tamaño de la figura a medida que se aplican las operaciones.