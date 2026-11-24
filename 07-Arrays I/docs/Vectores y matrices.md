# Introducción a las operaciones con vectores y matrices

## 1. ¿Qué es un vector?

Hasta ahora hemos trabajado con arrays para almacenar conjuntos de datos. Por ejemplo:

```java
int[] numbers = {10, 20, 30};
```

Sin embargo, un array también puede representar conceptos matemáticos. Uno de ellos es el **vector**.

En geometría, un vector representa una magnitud que tiene dirección, sentido y longitud. En dos dimensiones podemos representarlo mediante dos componentes:

- Componente X: desplazamiento horizontal.
- Componente Y: desplazamiento vertical.

Por ejemplo, el vector:

$$
\vec{v} = (3, 2)
$$

representa un desplazamiento de 3 unidades hacia la derecha y 2 unidades hacia arriba.

En Java podemos representarlo mediante un array:

```java
double[] vector = {3, 2};
```

En este caso:

- `vector[0]` contiene la componente X.
- `vector[1]` contiene la componente Y.

Un vector bidimensional siempre tendrá dos componentes.

### 1.1. Representación gráfica

Un vector se puede representar como una flecha que comienza en el origen de coordenadas (0, 0) y termina en el punto indicado por sus componentes.

Por ejemplo, el vector (3, 2):

- Comienza en (0, 0).
- Termina en (3, 2).
- Tiene un desplazamiento horizontal de 3 unidades.
- Tiene un desplazamiento vertical de 2 unidades.

Es importante distinguir entre un punto y un vector:

- Un punto representa una posición en el plano.
- Un vector representa un desplazamiento o una dirección con una determinada magnitud.

Aunque ambos se pueden representar mediante dos números, su significado matemático es diferente.

## 2. Operaciones con vectores

Una de las ventajas de representar los vectores mediante arrays es que podemos realizar operaciones matemáticas sobre ellos utilizando sus componentes.

### 2.1. Suma de vectores

La suma de dos vectores se realiza sumando sus componentes correspondientes.

Dados los vectores:

$$
\vec{a} = (3, 2)
$$

$$
\vec{b} = (1, 4)
$$

Su suma es:

$$
\vec{a} + \vec{b} = (3+1, 2+4) = (4, 6)
$$

Es decir, sumamos las componentes X entre sí y las componentes Y entre sí.

En Java:

```java
double[] a = {3, 2};
double[] b = {1, 4};

double[] result = new double[2];

result[0] = a[0] + b[0];
result[1] = a[1] + b[1];

IO.println("Resultado: (" + result[0] + ", " + result[1] + ")");
```

El resultado será:

```text
Resultado: (4.0, 6.0)
```

**Interpretación geométrica:** sumar dos vectores equivale a combinar dos desplazamientos. Si primero nos desplazamos según el vector A y después según el vector B, el desplazamiento total será la suma de ambos.

### 2.2. Resta de vectores

La resta funciona de manera similar, pero restando las componentes correspondientes.

Dados:

$$
\vec{a} = (5, 7)
$$

$$
\vec{b} = (2, 3)
$$

Tenemos:

$$
\vec{a} - \vec{b} = (5-2, 7-3) = (3, 4)
$$

En Java:

```java
double[] a = {5, 7};
double[] b = {2, 3};

double[] result = new double[2];

result[0] = a[0] - b[0];
result[1] = a[1] - b[1];

IO.println("Resultado: (" + result[0] + ", " + result[1] + ")");
```

**Interpretación geométrica:** la resta permite obtener el desplazamiento que lleva desde un punto hasta otro.

Por ejemplo, si tenemos dos puntos:

$$
A = (2, 3)
$$

$$
B = (7, 5)
$$

El vector que va desde A hasta B es:

$$
\vec{AB} = B-A = (7-2, 5-3) = (5, 2)
$$

### 2.3. Multiplicación de un vector por un escalar

Un escalar es simplemente un número.

Podemos multiplicar un vector por un número para modificar su longitud.

Por ejemplo:

$$
\vec{v} = (3, 2)
$$

Si multiplicamos el vector por 2:

$$
2 \cdot \vec{v} = (2 \cdot 3, 2 \cdot 2) = (6, 4)
$$

En Java:

```java
double[] vector = {3, 2};
double factor = 2;

double[] result = new double[2];

result[0] = vector[0] * factor;
result[1] = vector[1] * factor;
```

Si multiplicamos por un número mayor que 1, el vector aumenta su longitud.

Si multiplicamos por un número entre 0 y 1, disminuye su longitud.

Si multiplicamos por un número negativo, además de modificar su longitud, invertimos su sentido.

Esta operación será especialmente importante cuando estudiemos las transformaciones geométricas.

### 2.4. Longitud o módulo de un vector

La longitud de un vector se conoce como módulo.

Para calcularla utilizamos el teorema de Pitágoras:

$$
|\vec{v}| = \sqrt{x^2+y^2}
$$

Por ejemplo, para el vector:

$$
\vec{v} = (3, 4)
$$

Su longitud será:

$$
|\vec{v}| = \sqrt{3^2+4^2} = \sqrt{25} = 5
$$

En Java:

```java
double[] vector = {3, 4};

double length = Math.sqrt(
    vector[0] * vector[0] +
    vector[1] * vector[1]
);

IO.println("Longitud: " + length);
```

La función `Math.sqrt()` calcula la raíz cuadrada de un número.

### 2.5. Producto escalar

El producto escalar de dos vectores consiste en multiplicar sus componentes correspondientes y sumar los resultados.

Dados:

$$
\vec{a} = (3, 2)
$$

$$
\vec{b} = (4, 5)
$$

Su producto escalar es:

$$
\vec{a} \cdot \vec{b} = 3 \cdot 4 + 2 \cdot 5 = 22
$$

En Java:

```java
double[] a = {3, 2};
double[] b = {4, 5};

double result = a[0] * b[0] + a[1] * b[1];

IO.println("Producto escalar: " + result);
```

A diferencia de la suma o la resta, el producto escalar de dos vectores devuelve un número, no otro vector.

Este producto tiene aplicaciones geométricas importantes, por ejemplo, para estudiar el ángulo entre dos vectores o determinar si son perpendiculares.

---

## 3. ¿Qué es una matriz?

Una matriz es una estructura matemática formada por filas y columnas de elementos.

Por ejemplo, esta matriz tiene 2 filas y 2 columnas:

$$
A =
\begin{pmatrix}
2 & 3 \\
4 & 5
\end{pmatrix}
$$

En Java podemos representarla mediante un array bidimensional:

```java
double[][] matrix = {
    {2, 3},
    {4, 5}
};
```

Cada elemento se identifica mediante dos índices:

- El primer índice indica la fila.
- El segundo índice indica la columna.

Por ejemplo:

```java
IO.println(matrix[0][0]); // 2
IO.println(matrix[0][1]); // 3
IO.println(matrix[1][0]); // 4
IO.println(matrix[1][1]); // 5
```

Una matriz con 2 filas y 2 columnas se denomina matriz 2x2.

En matemáticas, el primer número indica las filas y el segundo las columnas.

### 3.1. Recorrer una matriz

Como ya hemos trabajado con arrays bidimensionales, sabemos que podemos recorrer una matriz mediante dos bucles anidados.

```java
double[][] matrix = {
    {2, 3},
    {4, 5}
};

for (int row = 0; row < matrix.length; row++) {
    for (int col = 0; col < matrix[row].length; col++) {
        IO.print(matrix[row][col] + " ");
    }

    IO.println();
}
```

Esto nos permite recorrer todos los elementos de la matriz, independientemente de sus dimensiones.

---

## 4. Operaciones con matrices

Al igual que ocurre con los vectores, podemos realizar diferentes operaciones matemáticas con matrices.

Para empezar, vamos a trabajar principalmente con matrices 2x2, ya que serán especialmente importantes cuando estudiemos las transformaciones geométricas en dos dimensiones.

### 4.1. Suma de matrices

Para sumar dos matrices deben tener las mismas dimensiones.

La operación consiste en sumar cada elemento con el elemento que ocupa su misma posición en la otra matriz.

Por ejemplo:

$$
A =
\begin{pmatrix}
1 & 2 \\
3 & 4
\end{pmatrix}
$$

$$
B =
\begin{pmatrix}
5 & 6 \\
7 & 8
\end{pmatrix}
$$

La suma es:

$$
A+B =
\begin{pmatrix}
1+5 & 2+6 \\
3+7 & 4+8
\end{pmatrix}
=
\begin{pmatrix}
6 & 8 \\
10 & 12
\end{pmatrix}
$$

En Java:

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

for (int row = 0; row < 2; row++) {
    for (int col = 0; col < 2; col++) {
        IO.print(result[row][col] + " ");
    }

    IO.println();
}
```

Observa que el algoritmo es muy parecido al que utilizábamos para recorrer matrices. La diferencia es que ahora realizamos una operación con los elementos de dos matrices.

### 4.2. Resta de matrices

La resta funciona exactamente igual que la suma, pero restando los elementos correspondientes.

Por ejemplo:

$$
A =
\begin{pmatrix}
8 & 6 \\
5 & 4
\end{pmatrix}
$$

$$
B =
\begin{pmatrix}
3 & 2 \\
1 & 4
\end{pmatrix}
$$

Entonces:

$$
A-B =
\begin{pmatrix}
5 & 4 \\
4 & 0
\end{pmatrix}
$$

En Java, solamente tenemos que cambiar el operador de suma por el de resta en el algoritmo anterior.

### 4.3. Multiplicación de una matriz por un escalar

También podemos multiplicar todos los elementos de una matriz por un número.

Por ejemplo:

$$
A =
\begin{pmatrix}
1 & 2 \\
3 & 4
\end{pmatrix}
$$

Si multiplicamos por 3:

$$
3A =
\begin{pmatrix}
3 & 6 \\
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

Esta operación será útil cuando estudiemos determinadas transformaciones geométricas.

---

## 5. Multiplicación de matrices y vectores

Esta operación es especialmente importante porque nos permitirá transformar vectores utilizando matrices.

A diferencia de la suma, la multiplicación de matrices y vectores no consiste en multiplicar los elementos que ocupan la misma posición.

Para entenderla, vamos a utilizar una matriz 2x2 y un vector de dos componentes.

Tenemos:

$$
A =
\begin{pmatrix}
2 & 1 \\
3 & 2
\end{pmatrix}
$$

Y el vector:

$$
\vec{v} =
\begin{pmatrix}
4 \\
5
\end{pmatrix}
$$

El resultado de multiplicar la matriz por el vector es otro vector:

$$
A \cdot \vec{v} =
\begin{pmatrix}
2 \cdot 4 + 1 \cdot 5 \\
3 \cdot 4 + 2 \cdot 5
\end{pmatrix}
$$

Por tanto:

$$
A \cdot \vec{v} =
\begin{pmatrix}
13 \\
22
\end{pmatrix}
$$

Observa cómo se calcula cada componente del resultado:

- La primera componente se obtiene multiplicando la primera fila de la matriz por el vector.
- La segunda componente se obtiene multiplicando la segunda fila de la matriz por el vector.

En Java:

```java
double[][] matrix = {
    {2, 1},
    {3, 2}
};

double[] vector = {4, 5};

double[] result = new double[2];

for (int row = 0; row < 2; row++) {
    result[row] = 0;

    for (int col = 0; col < 2; col++) {
        result[row] += matrix[row][col] * vector[col];
    }
}

IO.println("Resultado: (" + result[0] + ", " + result[1] + ")");
```

El resultado será:

```text
Resultado: (13.0, 22.0)
```

Fíjate en que necesitamos dos bucles:

- El bucle exterior recorre las filas de la matriz. Cada fila permite calcular una componente del vector resultante.
- El bucle interior recorre las columnas de esa fila y realiza las multiplicaciones necesarias.

Esta operación será la base de muchas de las transformaciones geométricas que estudiaremos posteriormente.

---

## 6. Las matrices como herramientas para transformar vectores

Hasta ahora hemos visto operaciones matemáticas con vectores y matrices. Pero ¿por qué son tan importantes en programación gráfica?

La razón es que podemos utilizar matrices para modificar las coordenadas de los puntos de una figura.

Imaginemos que tenemos un punto del plano:

$$
P = (3, 2)
$$

Podemos representarlo como un vector:

$$
\vec{p} =
\begin{pmatrix}
3 \\
2
\end{pmatrix}
$$

Si multiplicamos este vector por una matriz, obtenemos otro vector con nuevas coordenadas.

Es decir, podemos transformar la posición original del punto.

### 6.1. Escalado

El escalado permite aumentar o reducir las dimensiones de una figura.

Por ejemplo, queremos multiplicar por 2 las coordenadas X e Y de un punto.

Podemos utilizar esta matriz:

$$
S =
\begin{pmatrix}
2 & 0 \\
0 & 2
\end{pmatrix}
$$

Multiplicamos:

$$
S \cdot \vec{p} =
\begin{pmatrix}
2 & 0 \\
0 & 2
\end{pmatrix}
\cdot
\begin{pmatrix}
3 \\
2
\end{pmatrix}
$$

El resultado es:

$$
\begin{pmatrix}
6 \\
4
\end{pmatrix}
$$

El punto original (3, 2) pasa a ocupar la posición (6, 4).

Si utilizamos factores diferentes para X e Y, podemos modificar las dimensiones horizontal y vertical de forma independiente.

Por ejemplo:

$$
S =
\begin{pmatrix}
2 & 0 \\
0 & 3
\end{pmatrix}
$$

En este caso, multiplicamos X por 2 e Y por 3.

### 6.2. Espejado

También podemos utilizar matrices para invertir las coordenadas de un punto.

Por ejemplo, para realizar un espejado horizontal respecto al eje Y, utilizamos:

$$
M =
\begin{pmatrix}
-1 & 0 \\
0 & 1
\end{pmatrix}
$$

Si aplicamos esta matriz al punto (3, 2):

$$
M \cdot \vec{p} =
\begin{pmatrix}
-1 & 0 \\
0 & 1
\end{pmatrix}
\cdot
\begin{pmatrix}
3 \\
2
\end{pmatrix}
=
\begin{pmatrix}
-3 \\
2
\end{pmatrix}
$$

La coordenada X cambia de signo, mientras que Y permanece igual.

El punto pasa de (3, 2) a (-3, 2).

Para realizar un espejado vertical respecto al eje X, utilizamos:

$$
M =
\begin{pmatrix}
1 & 0 \\
0 & -1
\end{pmatrix}
$$

### 6.3. Rotación

Las matrices también permiten rotar puntos alrededor del origen de coordenadas.

Para realizar una rotación de un ángulo $\theta$, utilizamos:

$$
R =
\begin{pmatrix}
\cos(\theta) & -\sin(\theta) \\
\sin(\theta) & \cos(\theta)
\end{pmatrix}
$$

No necesitamos estudiar todavía en profundidad las funciones trigonométricas para entender la idea principal.

La matriz contiene cuatro valores que dependen del ángulo de rotación. Al multiplicarla por un vector, obtenemos las nuevas coordenadas del punto.

Por ejemplo, una rotación de 90 grados en sentido antihorario utiliza esta matriz:

$$
R =
\begin{pmatrix}
0 & -1 \\
1 & 0
\end{pmatrix}
$$

Si aplicamos la rotación al punto (3, 2):

$$
R \cdot \vec{p} =
\begin{pmatrix}
0 & -1 \\
1 & 0
\end{pmatrix}
\cdot
\begin{pmatrix}
3 \\
2
\end{pmatrix}
=
\begin{pmatrix}
-2 \\
3
\end{pmatrix}
$$

El punto pasa de (3, 2) a (-2, 3).

---

## 7. Resumen de las operaciones

| Operación | Elementos | Resultado |
|---|---|---|
| Suma de vectores | Dos vectores | Un vector |
| Resta de vectores | Dos vectores | Un vector |
| Multiplicación por escalar | Un vector y un número | Un vector |
| Módulo | Un vector | Un número |
| Producto escalar | Dos vectores | Un número |
| Suma de matrices | Dos matrices de las mismas dimensiones | Una matriz |
| Resta de matrices | Dos matrices de las mismas dimensiones | Una matriz |
| Multiplicación por escalar | Una matriz y un número | Una matriz |
| Matriz por vector | Una matriz y un vector compatible | Un vector |

**Una idea fundamental:** una matriz no es solamente una tabla de números. Podemos interpretarla como una operación que transforma vectores.

Más adelante veremos cómo combinar estas operaciones para trasladar, rotar, escalar y espejar figuras completas en un plano 2D.

---

# 8. Ejercicios propuestos

Todos los ejercicios se resolverán utilizando exclusivamente arrays, arrays bidimensionales, variables, operadores y estructuras de control. No se deben crear clases propias ni métodos propios.

## Bloque A. Operaciones con vectores

### Ejercicio 1. Suma de dos vectores

Declara dos vectores de dos componentes:

- A = (4, 3)
- B = (2, 5)

Calcula su suma y muestra el resultado por pantalla.

El resultado debe ser:

```text
(6.0, 8.0)
```

### Ejercicio 2. Resta de vectores

Declara dos vectores:

- A = (8, 6)
- B = (3, 2)

Calcula A - B y muestra el resultado.

### Ejercicio 3. Multiplicación por un escalar

Declara el vector:

$$
\vec{v} = (4, 6)
$$

Multiplica el vector por un escalar introducido por teclado.

Muestra el vector original y el resultado.

Prueba con los siguientes valores:

- 2
- 0.5
- -1

Observa cómo cambia el resultado en cada caso.

### Ejercicio 4. Longitud de un vector

Declara un vector de dos componentes y calcula su longitud utilizando el teorema de Pitágoras.

Prueba con:

- (3, 4)
- (5, 12)
- (1, 1)

Muestra el resultado con dos decimales si sabes utilizar el formato correspondiente. En caso contrario, muestra directamente el valor calculado.

### Ejercicio 5. Distancia entre dos puntos

Declara dos puntos del plano:

$$
A = (2, 3)
$$

$$
B = (8, 6)
$$

Calcula el vector que va desde A hasta B mediante una resta.

A continuación, calcula la longitud de ese vector.

El resultado será la distancia entre los dos puntos.

### Ejercicio 6. Producto escalar

Declara dos vectores de dos componentes e implementa el producto escalar.

Prueba con:

$$
\vec{a} = (2, 3)
$$

$$
\vec{b} = (3, -2)
$$

¿Qué resultado obtienes?

Prueba también con:

$$
\vec{a} = (1, 0)
$$

$$
\vec{b} = (0, 1)
$$

Observa qué ocurre cuando los vectores son perpendiculares.

### Ejercicio 7. Operaciones con tres vectores

Declara tres vectores:

$$
A = (2, 3)
$$

$$
B = (4, 1)
$$

$$
C = (-1, 2)
$$

Calcula:

1. A + B.
2. A + C.
3. A + B + C.
4. 2 · A.
5. A - B.

Muestra todos los resultados.

## Bloque B. Operaciones con matrices

### Ejercicio 8. Suma de matrices

Declara las siguientes matrices:

$$
A =
\begin{pmatrix}
1 & 2 \\
3 & 4
\end{pmatrix}
$$

$$
B =
\begin{pmatrix}
5 & 6 \\
7 & 8
\end{pmatrix}
$$

Calcula A + B y muestra la matriz resultante.

### Ejercicio 9. Resta de matrices

Utilizando las mismas matrices del ejercicio anterior, calcula A - B.

### Ejercicio 10. Multiplicación por un escalar

Declara una matriz 2x2 con los siguientes valores:

$$
A =
\begin{pmatrix}
2 & 3 \\
4 & 5
\end{pmatrix}
$$

Multiplica todos sus elementos por un número introducido por teclado.

Muestra la matriz original y la resultante.

### Ejercicio 11. Matrices de dimensiones diferentes

Declara dos matrices de dimensiones 3x2:

$$
A =
\begin{pmatrix}
1 & 2 \\
3 & 4 \\
5 & 6
\end{pmatrix}
$$

$$
B =
\begin{pmatrix}
6 & 5 \\
4 & 3 \\
2 & 1
\end{pmatrix}
$$

Calcula su suma.

En este ejercicio debes utilizar `matrix.length` y `matrix[row].length` para recorrer las matrices, en lugar de escribir directamente las dimensiones en los bucles.

## Bloque C. Multiplicación de matrices y vectores

### Ejercicio 12. Multiplicar una matriz por un vector

Declara:

$$
A =
\begin{pmatrix}
2 & 1 \\
3 & 2
\end{pmatrix}
$$

$$
\vec{v} = (4, 5)
$$

Calcula el producto A · v utilizando dos bucles.

Muestra el vector resultante.

### Ejercicio 13. Multiplicación por la matriz identidad

La matriz identidad 2x2 es:

$$
I =
\begin{pmatrix}
1 & 0 \\
0 & 1
\end{pmatrix}
$$

Multiplica esta matriz por diferentes vectores.

Comprueba qué ocurre con las coordenadas.

¿Por qué crees que se llama matriz identidad?

### Ejercicio 14. Crear una matriz de escalado

Declara una matriz que permita multiplicar la coordenada X por 2 y la coordenada Y por 3.

Utiliza la matriz para transformar el vector:

$$
\vec{v} = (4, 5)
$$

Muestra las coordenadas originales y las transformadas.

### Ejercicio 15. Crear una matriz de espejado

Declara una matriz que permita realizar un espejado horizontal respecto al eje Y.

Utiliza esa matriz para transformar los siguientes vectores:

- (3, 2)
- (5, 4)
- (-2, 6)

Comprueba cómo cambian las coordenadas.

### Ejercicio 16. Rotación de 90 grados

Declara la matriz:

$$
R =
\begin{pmatrix}
0 & -1 \\
1 & 0
\end{pmatrix}
$$

Utilízala para rotar los siguientes vectores 90 grados en sentido antihorario:

- (3, 2)
- (5, 0)
- (0, 4)
- (-2, 3)

Muestra los resultados.

## Bloque D. Aplicación conjunta

### Ejercicio 17. Transformar varios puntos

Tenemos una figura formada por cuatro puntos:

$$
P_1 = (1, 1)
$$

$$
P_2 = (4, 1)
$$

$$
P_3 = (4, 3)
$$

$$
P_4 = (1, 3)
$$

Representa estos puntos mediante una matriz de cuatro filas y dos columnas.

Cada fila contendrá las coordenadas X e Y de un punto.

A continuación:

1. Muestra los puntos originales.
2. Crea una matriz de escalado que multiplique X por 2 e Y por 2.
3. Recorre todos los puntos y aplica la transformación.
4. Muestra las nuevas coordenadas.

Observa que una única matriz de transformación puede aplicarse a todos los puntos de una figura.

### Ejercicio 18. Aplicar varias transformaciones

Utiliza los cuatro puntos del ejercicio anterior.

Realiza las siguientes transformaciones, en este orden:

1. Escala la figura multiplicando X por 2 e Y por 2.
2. Aplica un espejado horizontal.
3. Aplica una rotación de 90 grados en sentido antihorario.

Muestra las coordenadas después de cada operación.

Es importante que cada transformación se aplique sobre los resultados de la transformación anterior.

---

# 9. Ideas que debemos recordar

Antes de continuar con las transformaciones geométricas, debemos tener claras estas ideas:

1. Un vector 2D se puede representar mediante un array de dos elementos: X e Y.
2. Una matriz 2D se puede representar mediante un array bidimensional.
3. Las operaciones con vectores se realizan normalmente componente a componente.
4. Las operaciones con matrices se realizan recorriendo sus filas y columnas.
5. La multiplicación de una matriz por un vector permite obtener un nuevo vector.
6. Una matriz puede representar una transformación geométrica.
7. Podemos aplicar la misma transformación a todos los puntos de una figura.

La idea más importante de todo este tema es que, si representamos los puntos de una figura mediante vectores, podremos transformar la figura completa aplicando operaciones matemáticas sobre sus coordenadas.