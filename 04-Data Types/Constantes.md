# Constantes en Java

Las **constantes** son valores que **no pueden modificarse** una vez que han sido inicializados. Se utilizan para representar datos que permanecen invariables durante toda la ejecución del programa, como el valor de π, el número de días de una semana o el tipo de IVA.

El uso de constantes mejora la **legibilidad**, la **seguridad** y el **mantenimiento** del código.

---

# ¿Por qué utilizar constantes?

Imagina el siguiente programa:

```java
double area = 3.141592653589793 * radius * radius;
```

Aunque funciona correctamente, el número `3.141592653589793` no resulta muy descriptivo. Además, si aparece varias veces en el programa, cualquier modificación obligaría a cambiarlo en todos los lugares.

Una mejor solución consiste en utilizar una constante:

```java
final double PI = 3.141592653589793;

double area = PI * radius * radius;
```

Ahora el código es más fácil de leer y mantener.

---

# Declaración de una constante

En Java, una constante se declara utilizando la palabra reservada `final`.

## Sintaxis

```java
final tipo nombre = valor;
```

### Ejemplo

```java
final int DAYS_IN_WEEK = 7;
```

Una vez inicializada, la constante no puede modificarse.

---

# Intentar modificar una constante

El siguiente código produce un error de compilación.

```java
final int DAYS_IN_WEEK = 7;

DAYS_IN_WEEK = 5;
```

Error:

```text
Cannot assign a value to final variable 'DAYS_IN_WEEK'
```

---

# Constantes locales

Las constantes también pueden declararse dentro de un método.

```java
public static void main(String[] args) {

    final double VAT = 0.21;

    double price = 100;
    double total = price + price * VAT;

    System.out.println(total);

}
```

Su ámbito es el mismo que el de cualquier variable local.

---

# Constantes de clase

Cuando una constante debe ser compartida por todos los objetos de una clase, se declara utilizando `static` y `final`.

```java
public class MathConstants {

    public static final double PI = 3.141592653589793;

}
```

Se puede acceder a ella mediante el nombre de la clase.

```java
double area = MathConstants.PI * radius * radius;
```

---

# Convención de nomenclatura

Las constantes se escriben utilizando la convención **UPPER_SNAKE_CASE**.

Cada palabra se escribe en mayúsculas y se separa mediante un guion bajo (`_`).

## Correcto

```java
MAX_STUDENTS
DEFAULT_PORT
SECONDS_PER_DAY
MAX_FILE_SIZE
PI
```

## Incorrecto

```java
maxStudents
MaxStudents
max_students
```

---

# Ejemplos de constantes

## Constantes matemáticas

```java
public static final double PI = 3.141592653589793;
public static final double E = 2.718281828459045;
```

---

## Conversión de unidades

```java
public static final int HOURS_PER_DAY = 24;
public static final int MINUTES_PER_HOUR = 60;
public static final int SECONDS_PER_MINUTE = 60;
```

---

## Configuración de una aplicación

```java
public static final int DEFAULT_PORT = 8080;
public static final int MAX_CONNECTIONS = 100;
```

---

## Desarrollo de videojuegos

```java
public static final int MAX_HEALTH = 100;
public static final int MAX_LEVEL = 50;
public static final int INVENTORY_SIZE = 30;
```

---

# Ventajas de utilizar constantes

## Mayor legibilidad

No es lo mismo escribir:

```java
price = price * 1.21;
```

que

```java
price = price * (1 + VAT);
```

El segundo ejemplo resulta mucho más fácil de entender.

---

## Evitar errores

Si el valor cambia, solo será necesario modificar la constante.

```java
public static final double VAT = 0.21;
```

En lugar de buscar todos los valores `0.21` repartidos por el programa.

---

## Evitar los "Magic Numbers"

Los **Magic Numbers** son números escritos directamente en el código cuyo significado no es evidente.

### Mal ejemplo

```java
double area = 3.141592653589793 * radius * radius;
```

### Buen ejemplo

```java
final double PI = 3.141592653589793;

double area = PI * radius * radius;
```

---

# Buenas prácticas

✔ Declara como constante cualquier valor que no vaya a cambiar.

✔ Utiliza nombres descriptivos.

✔ Escribe las constantes en **UPPER_SNAKE_CASE**.

✔ Agrupa las constantes relacionadas dentro de una misma clase.

✔ Evita repetir el mismo valor varias veces en el programa.

---

# Errores frecuentes

## Utilizar una variable en lugar de una constante

```java
double PI = 3.141592653589793;
```

Mejor:

```java
final double PI = 3.141592653589793;
```

---

## No utilizar `static`

```java
public final double PI = 3.141592653589793;
```

Si la constante pertenece a toda la clase, debería declararse como:

```java
public static final double PI = 3.141592653589793;
```

---

## No seguir la convención de nombres

Incorrecto:

```java
final double pi = 3.141592653589793;
```

Correcto:

```java
final double PI = 3.141592653589793;
```

---

# Ejemplo completo

```java
public class Geometry {

    public static final double PI = 3.141592653589793;

    public static void main(String[] args) {

        double radius = 8.5;

        double area = PI * radius * radius;

        double circumference = 2 * PI * radius;

        System.out.println("Radius: " + radius);
        System.out.println("Area: " + area);
        System.out.println("Circumference: " + circumference);

    }

}
```

---

# Resumen

| Característica | Constante |
|----------------|-----------|
| Puede modificarse | ❌ No |
| Se declara con | `final` |
| Compartida por todos los objetos | `static final` |
| Convención de nombres | `UPPER_SNAKE_CASE` |
| Valor asignado | Una sola vez |

---

# Ideas clave

- Una constante es un valor que **no puede modificarse** una vez inicializado.
- En Java se declara utilizando la palabra reservada `final`.
- Las constantes compartidas por toda la clase se declaran con `static final`.
- Deben escribirse utilizando la convención **UPPER_SNAKE_CASE**.
- Sustituir los **Magic Numbers** por constantes mejora la legibilidad y facilita el mantenimiento del código.