# Ejercicios de programación
# Entrada y salida con la clase `IO` (Java 25)

> **Objetivo:** Familiarizarse con la nueva clase `IO` incorporada en **Java 25** para realizar operaciones básicas de entrada y salida.
>
> En estos ejercicios únicamente se utilizarán los métodos:
>
> - `IO.print()`
> - `IO.println()`
> - `IO.readln()`
> - `IO.readln(String)`
>
> **No es necesario realizar cálculos ni utilizar estructuras de control.** El objetivo consiste únicamente en leer datos del usuario y mostrarlos posteriormente por pantalla.

---

# Ejercicio 1. Hola, mundo

Escribe un programa que muestre por pantalla el mensaje:

```text
Hello, World!
```

---

# Ejercicio 2. Presentación

Muestra el siguiente texto utilizando varias llamadas a `IO.println()`.

```text
My name is Alice.
I am learning Java.
Welcome!
```

---

# Ejercicio 3. Uso de `IO.print()`

Escribe un programa que utilice únicamente `IO.print()` para mostrar el siguiente resultado:

```text
Java Programming
```

---

# Ejercicio 4. Línea en blanco

Muestra el siguiente resultado utilizando `IO.println()`.

```text
Programming

Java
```

---

# Ejercicio 5. Leer un nombre

Solicita al usuario su nombre utilizando:

```java
IO.readln("Name: ")
```

Después, muestra un saludo.

Ejemplo:

```text
Name: Alice

Hello Alice!
```

---

# Ejercicio 6. Leer una ciudad

Solicita el nombre de una ciudad.

Después muestra:

```text
You live in Valencia.
```

(Sustituye *Valencia* por el dato introducido por el usuario).

---

# Ejercicio 7. Leer el nombre de un videojuego

Solicita el título del videojuego favorito del usuario.

Después muestra:

```text
Your favourite game is Minecraft.
```

---

# Ejercicio 8. Leer el nombre de un país

Pide al usuario el nombre de un país y muéstralo posteriormente.

---

# Ejercicio 9. Leer el nombre de una mascota

Solicita:

- Nombre de la mascota.

Muestra un mensaje como:

```text
Your pet is called Luna.
```

---

# Ejercicio 10. Leer dos cadenas

Solicita:

- Nombre.
- Apellidos.

Después muestra el nombre completo.

Ejemplo:

```text
Full name: Alice Smith
```

---

# Ejercicio 11. Leer tres datos

Solicita:

- Nombre.
- Ciudad.
- País.

Muestra un pequeño resumen.

Ejemplo:

```text
Name : Alice
City : Valencia
Country : Spain
```

---

# Ejercicio 12. Ficha personal

Solicita:

- Nombre.
- Edad.
- Altura.

**No conviertas los datos.** Guárdalos como `String`.

Muestra posteriormente toda la información.

---

# Ejercicio 13. Mensaje personalizado

Solicita el nombre del usuario.

Después muestra un mensaje de bienvenida utilizando concatenación.

Ejemplo:

```text
Welcome Alice to the Java course!
```

---

# Ejercicio 14. Datos de un libro

Solicita:

- Título.
- Autor.
- Editorial.

Muestra una ficha con esos datos.

---

# Ejercicio 15. Datos de una película

Solicita:

- Título.
- Director.
- Año.

Guarda todos los datos como cadenas de texto y muéstralos.

---

# Ejercicio 16. Perfil de un jugador

Solicita:

- Nickname.
- Juego favorito.
- Plataforma favorita.

Muestra una ficha como la siguiente:

```text
PLAYER PROFILE
--------------
Nickname : PixelMaster
Game     : Minecraft
Platform : PC
```

---

# Ejercicio 17. Perfil de un estudiante

Solicita:

- Nombre.
- Curso.
- Centro educativo.

Muestra posteriormente la información.

---

# Ejercicio 18. Perfil de un desarrollador

Solicita:

- Nombre.
- Lenguaje favorito.
- Editor de código favorito.

Muestra todos los datos.

---

# Ejercicio 19. Perfil de un personaje

Solicita:

- Nombre del personaje.
- Clase.
- Reino.

Muestra una ficha.

---

# Ejercicio 20. Datos de una empresa

Solicita:

- Nombre de la empresa.
- Ciudad.
- Página web.

Muestra toda la información.

---

# ⭐ Ejercicio 21. Tarjeta de presentación

Solicita los siguientes datos:

- Nombre.
- Apellidos.
- Profesión.
- Empresa.
- Correo electrónico.

Muestra el siguiente formato:

```text
==============================
BUSINESS CARD
==============================
Name............. Alice Smith
Profession....... Software Developer
Company.......... OpenAI
Email............ alice@example.com
==============================
```

---

# ⭐ Ejercicio 22. Perfil para una red social

Solicita:

- Nombre de usuario.
- Nombre completo.
- Ciudad.
- Biografía.

Muestra una ficha de perfil.

---

# ⭐ Ejercicio 23. Ficha de un videojuego

Solicita:

- Nombre.
- Género.
- Plataforma.
- Estudio desarrollador.

Muestra una ficha con formato.

---

# ⭐ Ejercicio 24. Registro de un alumno

Solicita:

- Nombre.
- Apellidos.
- Grupo.
- Correo electrónico.

Presenta la información de forma ordenada.

---

# ⭐ Ejercicio 25. Currículum básico

Solicita:

- Nombre.
- Profesión.
- Ciudad.
- Teléfono.
- Correo electrónico.

Muestra un pequeño currículum con un formato similar al siguiente:

```text
==============================
CURRICULUM
==============================
Name............... Alice Smith
Profession......... Software Developer
City............... Valencia
Phone.............. 600123123
Email.............. alice@example.com
==============================
```

---

# Objetivos de aprendizaje

Al finalizar estos ejercicios el alumnado será capaz de:

- Utilizar `IO.println()` para mostrar información.
- Utilizar `IO.print()` cuando no se desee un salto de línea.
- Leer datos mediante `IO.readln()`.
- Leer datos mediante `IO.readln(String)` mostrando un mensaje al usuario.
- Guardar los datos introducidos en variables de tipo `String`.
- Mostrar información utilizando concatenación de cadenas.
- Presentar la salida del programa de forma clara y organizada.

> **Nota:** En esta colección de ejercicios todos los datos pueden almacenarse como `String`. La conversión a tipos numéricos (`Integer.parseInt()`, `Double.parseDouble()`, etc.) se trabajará en ejercicios posteriores.