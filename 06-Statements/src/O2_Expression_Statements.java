/**
 * Instrucción de expresión (Expression statement)
 *
 * Se forman añadiendo el separador ; a una expresión.
 *
 * No siempre que se añade el ; a una expresión se obtiene una instrucción de expresión válida.
 *
 * Solamente los siguientes tipos de expresiones pueden formar instrucciones de expresión válidas.
 * - Incremento y decremento
 * - Asignación
 * - Creación de objetos (ya se verá en POO)
 * - Llamada a función (en Java a las funciones se les denomina métodos)
 */

void main() {
  int number = 0;

  /* Cuando añadimos un ; a una expresión se forma una instrucción (statement) */

  // Incremento y decremento
  number++;
  --number;

  // Asignación
  number = number + 1;
  number += 5;

  // Creación de objetos con el operador new
  new String("Texto");

  // Llamadas a función (método)
  Math.random();
  IO.println("Hola mundo");
}