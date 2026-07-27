# Variables en Java

Las **variables** son espacios de memoria que permiten almacenar información durante la ejecución de un programa. En Java, cada variable tiene un **tipo de dato**, un **nombre** (identificador) y un **ámbito** (*scope*) que determina dónde puede utilizarse.

---

# Clasificación de las variables en Java

Según el lugar donde se declaran, las variables se clasifican en:

1. Variables locales
2. Variables de instancia
3. Variables de clase (estáticas)
4. Parámetros de métodos

---

# 1. Variables locales

Las **variables locales** se declaran dentro de un método, constructor o bloque de código.

Su ámbito se limita únicamente al bloque donde han sido declaradas.

## Características

- Se crean cuando comienza la ejecución del bloque.
- Desaparecen al salir del bloque.
- **No tienen valor por defecto.**
- Deben inicializarse antes de utilizarlas.

## Ejemplo

```java
public class Example {

    public static void main(String[] args) {

        int age = 20;
        double average = 8.5;

        System.out.println(age);
        System.out.println(average);

    }

}
```

---

## Error frecuente

```java
public class Example {

    public static void main(String[] args) {

        int age;

        System.out.println(age);

    }

}
```

El compilador produce un error porque la variable **no ha sido inicializada**.

---

# 2. Variables de instancia

Las **variables de instancia** pertenecen a cada objeto creado a partir de una clase.

Cada objeto posee su propia copia de estas variables.

## Características

- Se declaran dentro de la clase.
- Fuera de los métodos.
- Cada objeto tiene sus propios valores.
- Se inicializan automáticamente.

## Valores por defecto

| Tipo | Valor por defecto |
|-------|-------------------|
| Numéricos | `0` |
| `double` | `0.0` |
| `boolean` | `false` |
| `char` | `'\u0000'` |
| Objetos | `null` |

---

## Ejemplo

```java
public class Student {

    String name;
    int age;

}
```

```java
Student student1 = new Student();
Student student2 = new Student();

student1.name = "Alice";
student2.name = "Bob";
```

Cada objeto mantiene sus propios datos.

---

# 3. Variables de clase (static)

Las **variables estáticas** pertenecen a la clase y no a los objetos.

Existe **una única copia** compartida por todas las instancias.

Se declaran utilizando la palabra reservada `static`.

## Características

- Compartidas por todos los objetos.
- Se crean cuando la clase se carga en memoria.
- Se accede mediante el nombre de la clase.

---

## Ejemplo

```java
public class Student {

    static int numberOfStudents = 0;

}
```

```java
Student.numberOfStudents++;
```

No es necesario crear un objeto para acceder a ellas.

---

## Ejemplo completo

```java
public class Student {

    String name;

    static int totalStudents = 0;

    public Student(String name) {

        this.name = name;
        totalStudents++;

    }

}
```

---

# 4. Parámetros

Los parámetros son variables que reciben información cuando se invoca un método.

## Ejemplo

```java
public static int add(int a, int b) {

    return a + b;

}
```

En este ejemplo

```text
a
b
```

son parámetros.

---

## Llamada

```java
int result = add(5, 8);
```

Durante la llamada

```text
a = 5
b = 8
```

---

# Comparativa

| Característica | Local | Instancia | Clase (static) | Parámetro |
|---------------|:----:|:---------:|:--------------:|:---------:|
| Pertenece al método | ✅ | ❌ | ❌ | ✅ |
| Pertenece al objeto | ❌ | ✅ | ❌ | ❌ |
| Pertenece a la clase | ❌ | ❌ | ✅ | ❌ |
| Valor por defecto | ❌ | ✅ | ✅ | ❌ |
| Debe inicializarse | ✅ | ❌ | ❌ | ✅ |

---

# Ámbito (Scope)

## Variable local

```java
public void calculate() {

    int total = 50;

}
```

La variable `total` solo existe dentro del método.

---

## Variable de instancia

```java
public class Student {

    int age;

}
```

Puede utilizarse desde cualquier método de la clase.

---

## Variable estática

```java
public class Student {

    static int totalStudents;

}
```

Existe una única copia compartida.

---

# Tiempo de vida

| Tipo | Se crea | Se destruye |
|------|----------|-------------|
| Local | Al entrar en el bloque | Al salir del bloque |
| Instancia | Al crear el objeto | Cuando el objeto es eliminado por el recolector de basura |
| Estática | Al cargar la clase | Al finalizar la aplicación |
| Parámetro | Al invocar el método | Al terminar el método |

---

# Buenas prácticas

## Variables locales

Utiliza nombres descriptivos.

```java
double averageGrade;
```

En lugar de

```java
double x;
```

---

## Variables de instancia

Representan el estado del objeto.

```java
private String name;
private int age;
```

---

## Variables estáticas

Utilízalas únicamente cuando el dato sea compartido.

Ejemplos:

```java
PI
MAX_SIZE
DEFAULT_PORT
```

---

## Parámetros

Utiliza nombres significativos.

```java
calculateArea(double radius)
```

En lugar de

```java
calculateArea(double r)
```

---

# Errores frecuentes

## Utilizar una variable local sin inicializar

```java
int age;

System.out.println(age);
```

❌ Error de compilación.

---

## Utilizar demasiadas variables estáticas

No todos los datos deben ser compartidos.

---

## Confundir variables de instancia con variables locales

```java
public class Student {

    int age;

    public void example() {

        int age = 20;

    }

}
```

En este caso existen dos variables diferentes llamadas `age`.

---

# Resumen

| Tipo de variable | ¿Dónde se declara? | ¿Quién la posee? |
|------------------|--------------------|------------------|
| Local | Dentro de un método | El método |
| Instancia | Dentro de la clase | Cada objeto |
| Estática | Dentro de la clase (`static`) | La clase |
| Parámetro | En la cabecera del método | El método |

---

# Conclusiones

- Las **variables locales** solo existen durante la ejecución del bloque donde se declaran.
- Las **variables de instancia** representan el estado de cada objeto.
- Las **variables estáticas** pertenecen a la clase y son compartidas por todos los objetos.
- Los **parámetros** permiten que un método reciba información del exterior.

Elegir correctamente el tipo de variable mejora la organización, la reutilización y el mantenimiento del código.