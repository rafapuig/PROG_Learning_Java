# Comentarios en Java

Los **comentarios** son fragmentos de texto incluidos en el código fuente que **el compilador de Java ignora**. 

Se utilizan para 
* documentar el código
* explicar su funcionamiento, mejorar la legibilidad
* desactivar temporalmente partes del programa durante las pruebas.

Java dispone de **tres tipos de comentarios**:

1. Comentarios de una línea.
2. Comentarios de varias líneas.
3. Comentarios de documentación (Javadoc).

---

# 1. Comentarios de una línea

Los comentarios de una línea comienzan con `//` y terminan al final de la línea.

Se utilizan para realizar anotaciones breves o explicar una instrucción concreta.

## Sintaxis

```java
// Este es un comentario de una línea
```

## Ejemplo

```java
int edad = 18; // Edad mínima para acceder
```

### Cuándo utilizarlos

- Explicar una instrucción concreta.
- Añadir notas rápidas.
- Desactivar temporalmente una línea de código.

Ejemplo:

```java
// IO.println("Mensaje de prueba");
```

---

# 2. Comentarios de varias líneas

Los comentarios de varias líneas comienzan con `/*` y finalizan con `*/`.

Permiten escribir comentarios que ocupan varias líneas.
También se pueden insertar entre una línea de código fuente.

## Sintaxis

```java
/*
Este comentario
ocupa varias
líneas.
*/
```

## Ejemplo

```java
/*
Calcula el salario anual
multiplicando el salario mensual
por doce.
*/
double salarioAnual = salarioMensual * 12;
```

### Cuándo utilizarlos

- Explicar algoritmos complejos.
- Añadir descripciones largas.
- Desactivar temporalmente varios bloques de código.

Ejemplo:

```java
/*
IO.println("Línea 1");
IO.println("Línea 2");
IO.println("Línea 3");
*/
```

---

# 3. Comentarios de documentación (Javadoc)

Los comentarios **Javadoc** comienzan con `/**` y terminan con `*/`.

Se utilizan para generar automáticamente la documentación del código mediante la herramienta **Javadoc**.

Generalmente se escriben antes de:

- Clases.
- Interfaces.
- Métodos.
- Constructores.
- Atributos públicos.

## Sintaxis

```java
/**
 * Descripción del elemento.
 */
```

## Ejemplo

```java
/**
 * Calcula la suma de dos números enteros.
 *
 * @param a Primer número.
 * @param b Segundo número.
 * @return La suma de ambos números.
 */
public int sumar(int a, int b) {
    return a + b;
}
```

### Etiquetas Javadoc más utilizadas

| Etiqueta | Descripción |
|----------|-------------|
| `@author` | Autor del código. |
| `@version` | Versión del programa o clase. |
| `@param` | Describe un parámetro del método. |
| `@return` | Describe el valor devuelto por un método. |
| `@throws` | Describe una excepción que puede lanzar el método. |
| `@see` | Referencia a otro elemento relacionado. |
| `@since` | Indica desde qué versión existe el elemento. |
| `@deprecated` | Marca un elemento como obsoleto. |

Ejemplo completo:

```java
/**
 * Clase que representa una cuenta bancaria.
 *
 * @author Juan Pérez
 * @version 1.0
 * @since 21
 */
public class CuentaBancaria {

    /**
     * Ingresa una cantidad en la cuenta.
     *
     * @param cantidad Cantidad que se desea ingresar.
     */
    public void ingresar(double cantidad) {

    }
}
```

---

# Resumen

| Tipo de comentario | Sintaxis | Uso principal |
|--------------------|----------|---------------|
| Una línea | `// comentario` | Explicaciones breves y anotaciones rápidas. |
| Varias líneas | `/* comentario */` | Explicaciones largas o bloques de texto. |
| Documentación (Javadoc) | `/** comentario */` | Generar documentación automática del código. |

---

# Buenas prácticas

- Escribe comentarios que aporten información útil y no describan lo que ya es evidente.
- Mantén los comentarios actualizados cuando modifiques el código.
- Utiliza **Javadoc** para documentar las clases y métodos públicos.
- Evita comentar código que ya no se utiliza; es preferible eliminarlo o utilizar un sistema de control de versiones.
- Prioriza escribir código claro y legible para reducir la necesidad de comentarios innecesarios.

---

# Ejemplo completo

```java
/**
 * Programa de ejemplo sobre comentarios en Java.
 *
 * @author Juan Pérez
 */
public class Comentarios {

    void main(String[] args) {

        // Declaración de una variable
        int edad = 20;

        /*
         * Comprobamos si la persona
         * es mayor de edad.
         */
        if (edad >= 18) {
            IO.println("Mayor de edad");
        }
    }
}
```