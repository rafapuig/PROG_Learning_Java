# Entrada y salida simplificada en Java con `IO`

A partir de **Java 25**, el JDK incorpora la clase `IO`, que simplifica la entrada y salida de datos en programas de consola.

Esta clase permite escribir programas más sencillos sin necesidad de utilizar clases como `Scanner` o realizar importaciones adicionales.

Gracias a esta API, los programas de las primeras unidades pueden centrarse en los conceptos fundamentales de programación, como las variables, los operadores y las expresiones.

---

# La clase `IO`

La clase `IO` pertenece al paquete `java.lang`, por lo que **no es necesario importarla**.

```java
// No es necesario importar nada
```

Proporciona métodos para:

- Mostrar información por pantalla.
- Leer texto introducido por el usuario.

---

# Métodos disponibles

La clase `IO` dispone de los siguientes métodos:

| Método | Descripción |
|---------|-------------|
| `IO.print(Object)` | Muestra un valor sin cambiar de línea. |
| `IO.println(Object)` | Muestra un valor y cambia de línea. |
| `IO.println()` | Escribe una línea en blanco. |
| `IO.readln()` | Lee una línea de texto introducida por el usuario. |
| `IO.readln(String prompt)` | Muestra un mensaje y lee una línea de texto. |

---

# Mostrar información

## `IO.println()`

Este método muestra información y, al finalizar, sitúa el cursor en la línea siguiente.

```java
IO.println("Hello world!");
```

Resultado:

```text
Hello world!
```

---

# Mostrar varias líneas

```java
IO.println("Programming");
IO.println("Java");
IO.println("Variables");
```

Resultado:

```text
Programming
Java
Variables
```

---

# Mostrar una línea en blanco

```java
IO.println();
```

Ejemplo:

```java
IO.println("Header");
IO.println();
IO.println("Content");
```

Resultado:

```text
Header

Content
```

---

# `IO.print()`

Este método muestra información **sin realizar un salto de línea**.

```java
IO.print("Hello ");
IO.print("world!");
```

Resultado:

```text
Hello world!
```

---

# Mostrar variables

Es posible mostrar directamente el contenido de una variable.

```java
int age = 20;

IO.println(age);
```

Resultado:

```text
20
```

---

# Concatenar texto y variables

Es habitual combinar texto con el contenido de variables utilizando el operador `+`.

```java
String name = "Alice";
int age = 20;

IO.println("Name: " + name);
IO.println("Age: " + age);
```

Resultado:

```text
Name: Alice
Age: 20
```

---

# Leer texto

El método `IO.readln()` lee una línea completa introducida por el usuario y devuelve un objeto de tipo `String`.

```java
String name = IO.readln();
```

Ejemplo:

```java
IO.println("Enter your name:");

String name = IO.readln();

IO.println("Hello " + name);
```

---

# Leer texto mostrando un mensaje

La versión con parámetro muestra un mensaje antes de leer la entrada.

```java
String name = IO.readln("Enter your name: ");
```

Es equivalente a escribir:

```java
IO.println("Enter your name:");
String name = IO.readln();
```

pero resulta más cómoda.

---

# Leer números

La clase `IO` **siempre devuelve una cadena de texto**.

Para trabajar con números es necesario convertir esa cadena al tipo de dato adecuado.

---

# Leer un número entero

```java
int age = Integer.parseInt(IO.readln("Age: "));
```

Si el usuario escribe:

```text
25
```

La variable `age` contendrá el valor:

```text
25
```

---

# Leer un número decimal

```java
double height = Double.parseDouble(IO.readln("Height: "));
```

Si el usuario introduce:

```text
1.75
```

La variable contendrá:

```text
1.75
```

---

# Leer un número de tipo `long`

```java
long population =
        Long.parseLong(IO.readln("Population: "));
```

---

# Leer un número de tipo `float`

```java
float temperature =
        Float.parseFloat(IO.readln("Temperature: "));
```

---

# Leer un valor lógico

```java
boolean student =
        Boolean.parseBoolean(IO.readln("Student (true/false): "));
```

El usuario deberá escribir:

```text
true
```

o

```text
false
```

---

# Resumen de conversiones

| Tipo de dato | Conversión |
|---------------|------------|
| `int` | `Integer.parseInt()` |
| `long` | `Long.parseLong()` |
| `float` | `Float.parseFloat()` |
| `double` | `Double.parseDouble()` |
| `boolean` | `Boolean.parseBoolean()` |

---

# Programa completo

```java
public class Main {

    public static void main(String[] args) {

        String name = IO.readln("Name: ");

        int age =
                Integer.parseInt(IO.readln("Age: "));

        double height =
                Double.parseDouble(IO.readln("Height: "));

        IO.println();
        IO.println("PERSONAL DATA");
        IO.println("-------------------------");
        IO.println("Name: " + name);
        IO.println("Age: " + age);
        IO.println("Height: " + height);

    }

}
```

---

# Recomendaciones

## Utiliza mensajes descriptivos

Es recomendable indicar claramente qué dato debe introducir el usuario.

Correcto:

```java
int age =
        Integer.parseInt(IO.readln("Age: "));
```

Menos recomendable:

```java
int age =
        Integer.parseInt(IO.readln());
```

---

## Guarda siempre el resultado

El valor leído debe almacenarse en una variable.

Correcto:

```java
String city = IO.readln("City: ");
```

---

## Utiliza el tipo adecuado

Si el dato puede contener decimales, utiliza `double`.

```java
double price =
        Double.parseDouble(IO.readln("Price: "));
```

No utilices `int` para almacenar cantidades decimales.

---

# Errores frecuentes

## Olvidar la conversión

Incorrecto:

```java
int age = IO.readln();
```

`IO.readln()` devuelve un `String`, no un `int`.

Correcto:

```java
int age =
        Integer.parseInt(IO.readln());
```

---

## Utilizar una conversión incorrecta

Incorrecto:

```java
double price =
        Integer.parseInt(IO.readln());
```

Correcto:

```java
double price =
        Double.parseDouble(IO.readln());
```

---

## Introducir un dato con un formato incorrecto

Si el usuario escribe:

```text
twenty
```

y el programa intenta ejecutar:

```java
Integer.parseInt(...)
```

se producirá una excepción porque el texto no representa un número entero válido.

En las primeras unidades del curso se supondrá que el usuario introduce siempre datos correctos.

---

# Resumen

| Acción | Método |
|--------|--------|
| Mostrar sin salto de línea | `IO.print()` |
| Mostrar con salto de línea | `IO.println()` |
| Mostrar una línea en blanco | `IO.println()` |
| Leer una línea de texto | `IO.readln()` |
| Leer una línea mostrando un mensaje | `IO.readln(String)` |

---

# Ideas clave

- La clase `IO` forma parte del **JDK** a partir de Java 25.
- No es necesario importar la clase `IO`.
- Los métodos `IO.print()` e `IO.println()` permiten mostrar información por pantalla.
- Los métodos `IO.readln()` e `IO.readln(String)` leen una línea de texto y devuelven un objeto de tipo `String`.
- Para obtener valores numéricos o booleanos es necesario convertir la cadena utilizando métodos como `Integer.parseInt()` o `Double.parseDouble()`.
- La API `IO` facilita el aprendizaje de la programación al reducir el código necesario para realizar operaciones básicas de entrada y salida.