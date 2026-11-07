# Ejercicios de Java: bucles while y do-while

**Ciclo:** 1.º DAW  
**Lenguaje:** Java  
**Tema:** Estructuras repetitivas  
**Dificultad:** Inicial – Intermedia

## Bloque 1. Ejercicios con while

### Ejercicio 1. Cuenta atrás para comenzar la partida

Un videojuego muestra una cuenta atrás antes de comenzar una partida.

- Solicita al usuario un número entero positivo.
- Muestra una cuenta atrás desde ese número hasta 1.
- Cuando termine, muestra el mensaje `¡Comienza la partida!`.

**Ejemplo de ejecución:**

```text
Introduce el número inicial: 5

5
4
3
2
1
¡Comienza la partida!
```

### Ejercicio 2. Energía del personaje

Un personaje comienza una partida con 100 puntos de energía.

Cada vez que recibe un ataque pierde 15 puntos.

- Muestra la energía restante después de cada ataque.
- Repite los ataques mientras el personaje tenga energía superior a 0.
- Cuando termine, muestra `El personaje ha sido derrotado`.

### Ejercicio 3. Experiencia necesaria para subir de nivel

Un jugador tiene 250 puntos de experiencia y necesita alcanzar los 1.000 para subir de nivel.

Cada enemigo derrotado proporciona 125 puntos de experiencia.

- Utiliza un bucle para simular la derrota de enemigos.
- Muestra la experiencia acumulada después de cada enemigo.
- Cuando alcance o supere los 1.000 puntos, muestra `¡Has subido de nivel!`.

### Ejercicio 4. Munición limitada

Un jugador dispone de 30 balas al comenzar una partida.

Cada disparo consume una bala.

- Simula los disparos mientras queden balas.
- Muestra el número de balas restantes después de cada disparo.
- Cuando se agoten, muestra `¡Sin munición!`.

### Ejercicio 5. El jefe final

Un personaje debe enfrentarse a un jefe final que tiene 500 puntos de vida.

El jugador realiza ataques que producen 75 puntos de daño cada uno.

- Utiliza un bucle `while` para simular los ataques.
- Muestra la vida restante del jefe después de cada ataque.
- Cuando su vida llegue a 0 o menos, muestra `¡Jefe derrotado!`.

### Ejercicio 6. Adivina el número

El programa tiene almacenado un número secreto entre 1 y 100.

- Solicita al usuario que introduzca números.
- Si el número introducido es mayor que el secreto, muestra `El número secreto es menor`.
- Si es menor, muestra `El número secreto es mayor`.
- Repite el proceso hasta que el usuario acierte.
- Cuando acierte, muestra `¡Has encontrado el número secreto!`.

Puedes utilizar un número secreto fijo, por ejemplo, 37.

### Ejercicio 7. Puntuación máxima

Un videojuego registra las puntuaciones obtenidas por un jugador en diferentes partidas.

- Solicita puntuaciones enteras al usuario.
- El usuario introducirá 0 para finalizar.
- El programa debe mostrar la puntuación más alta obtenida.
- También debe mostrar cuántas partidas se han registrado.

No debes utilizar arrays ni colecciones.

### Ejercicio 8. Tienda de videojuegos

Un jugador tiene 150 monedas y quiere comprar objetos en una tienda.

Cada objeto tiene un precio que introduce el usuario.

- Solicita el precio del objeto que quiere comprar.
- Si tiene suficientes monedas, realiza la compra y descuenta el importe.
- Si no tiene suficientes monedas, muestra un mensaje indicando que no puede comprarlo.
- Repite el proceso mientras el jugador tenga monedas.
- El usuario puede introducir un precio de 0 para salir de la tienda.

Muestra las monedas restantes después de cada compra.

## Bloque 2. Ejercicios con do-while

### Ejercicio 9. Menú principal de un videojuego

Crea un menú que permita al usuario elegir entre las siguientes opciones:

```text
===== MENÚ PRINCIPAL =====
1. Nueva partida
2. Cargar partida
3. Opciones
4. Salir
Selecciona una opción:
```

- El menú debe mostrarse al menos una vez.
- Si el usuario selecciona una opción entre 1 y 3, muestra un mensaje indicando la opción seleccionada.
- Si selecciona 4, muestra `Hasta pronto`.
- Si introduce una opción incorrecta, muestra `Opción no válida`.
- El menú debe repetirse hasta seleccionar la opción 4.

### Ejercicio 10. Introducción de contraseña

Un videojuego necesita solicitar una contraseña para acceder a una partida protegida.

- La contraseña correcta será `DAW2026`.
- Solicita la contraseña al usuario.
- Si es incorrecta, vuelve a solicitarla.
- Cuando sea correcta, muestra `Acceso concedido`.

El programa debe solicitar la contraseña al menos una vez.

### Ejercicio 11. Tiradas de dados

Un jugador lanza un dado de seis caras.

- Simula una tirada utilizando `Random`.
- Muestra el resultado de cada tirada.
- Repite las tiradas hasta obtener un 6.
- Al finalizar, muestra el número de tiradas necesarias.

### Ejercicio 12. Crear un personaje

Un videojuego permite crear un personaje distribuyendo puntos entre tres atributos:

- Fuerza.
- Agilidad.
- Inteligencia.

El jugador dispone de 20 puntos.

- Solicita los puntos que quiere asignar a cada atributo.
- No se pueden asignar cantidades negativas.
- La suma de los tres atributos no puede superar los 20 puntos.
- Si la distribución no es válida, vuelve a solicitar los valores.
- Cuando sea válida, muestra los atributos definitivos.

Utiliza `do-while` para garantizar que se solicitan los datos al menos una vez.

### Ejercicio 13. Recuperar puntos de vida

Un personaje tiene inicialmente 20 puntos de vida y puede recuperar vida mediante pociones.

Cada poción recupera 15 puntos de vida.

- El personaje puede utilizar pociones hasta alcanzar 100 puntos de vida.
- Muestra la vida después de utilizar cada poción.
- No permitas superar los 100 puntos de vida.
- Muestra el número de pociones utilizadas.

## Bloque 3. Ejercicios combinados y retos

### Ejercicio 14. Simulador de combate

Dos personajes se enfrentan en un combate por turnos.

- El jugador comienza con 100 puntos de vida.
- El enemigo comienza con 120 puntos de vida.
- En cada turno, el jugador inflige 20 puntos de daño.
- Después, si el enemigo sigue vivo, inflige 15 puntos de daño al jugador.
- El combate continúa mientras ambos personajes tengan puntos de vida.
- Al finalizar, indica quién ha ganado.

### Ejercicio 15. Máquina recreativa

Una máquina recreativa permite jugar mientras el usuario tenga créditos.

- El jugador comienza con 10 créditos.
- Cada partida cuesta 2 créditos.
- Cada partida permite obtener una puntuación que introduce el usuario.
- Al finalizar, muestra el número de partidas jugadas y la puntuación total.
- Cuando no queden créditos, muestra `No tienes créditos suficientes`.

### Ejercicio 16. El laberinto

Un personaje debe escapar de un laberinto.

El jugador comienza en la posición 0 y debe alcanzar la posición 10.

- Solicita al usuario cuántas posiciones quiere avanzar.
- Cada movimiento debe avanzar entre 1 y 3 posiciones.
- Si introduce un valor incorrecto, muestra un mensaje de error.
- El programa debe repetir la solicitud hasta alcanzar o superar la posición 10.
- Muestra la posición actual después de cada movimiento.

### Ejercicio 17. Sistema de puntuación

Un videojuego concede puntos por derrotar enemigos.

- Cada enemigo derrotado proporciona 100 puntos.
- Solicita al usuario si quiere continuar derrotando enemigos (`S/N`).
- Cada vez que responda `S`, añade 100 puntos.
- Cuando responda `N`, finaliza el juego.
- Muestra el número de enemigos derrotados y la puntuación total.

### Ejercicio 18. El número de intentos

Un jugador dispone de 5 intentos para abrir una caja fuerte.

El código correcto es 4821.

- Solicita un código de cuatro cifras.
- Si es incorrecto, resta un intento.
- Si es correcto, muestra `¡Caja fuerte desbloqueada!`.
- Si agota los intentos, muestra `Acceso bloqueado`.
- Indica los intentos restantes después de cada fallo.

### Ejercicio 19. Gestión de monedas

Un jugador comienza con 500 monedas y puede realizar diferentes operaciones:

```text
===== GESTIÓN DE MONEDAS =====
1. Consultar saldo
2. Ganar monedas
3. Gastar monedas
4. Salir
```

- Consultar saldo muestra las monedas disponibles.
- Ganar monedas solicita una cantidad y la suma al saldo.
- Gastar monedas solicita una cantidad y la resta si hay saldo suficiente.
- No se permiten cantidades negativas ni iguales a cero.
- El menú se repetirá hasta seleccionar la opción 4.

### Ejercicio 20. Supervivencia zombi

Un personaje debe sobrevivir a una horda de zombis.

- Comienza con 100 puntos de vida.
- Cada ronda aparecen entre 1 y 3 zombis.
- Cada zombi provoca 10 puntos de daño.
- El personaje puede sobrevivir mientras tenga puntos de vida superiores a 0.
- Después de cada ronda, muestra el número de zombis y los puntos de vida restantes.
- Cuando el personaje muera, muestra el número de rondas que ha conseguido sobrevivir.

Puedes utilizar `Random` para determinar el número de zombis de cada ronda.

---

## Orientaciones didácticas

Para trabajar estos ejercicios en clase, se propone la siguiente distribución:

| Dificultad | Ejercicios | Conceptos principales |
|---|---|---|
| Inicial | 1-5 | Contadores, acumuladores y condiciones |
| Básica | 6-8 | Centinelas, entrada de datos y máximos |
| Intermedia | 9-13 | Menús, validación y repetición obligatoria |
| Avanzada | 14-20 | Bucles combinados, condiciones múltiples y simulaciones |

### Aspectos que deberían dominar

1. Saber cuándo utilizar `while` y cuándo `do-while`.
2. Controlar correctamente la condición de finalización.
3. Evitar los bucles infinitos.
4. Actualizar las variables de control dentro del bucle.
5. Utilizar contadores y acumuladores.
6. Validar los datos introducidos por el usuario.

### Recomendación

Se recomienda resolver los ejercicios 1-8 exclusivamente con `while` y los ejercicios 9-13 con `do-while`.

En los últimos siete ejercicios se puede dejar libertad para elegir el bucle más apropiado, pidiendo a los alumnos que justifiquen su elección.