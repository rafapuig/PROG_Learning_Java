/**
 * El orden de ejecución de la instrucción de un programa es secuencial
 * (una detrás de otra, de arriba a abajo tal como aparecen en el archivo de código fuente)
 *
 * A esto se le llama flujo de ejecución
 *
 * Sí queremos
 * - evitar la ejecución de una instrucción (que el flujo se la salte)
 * - que se ejecute solamente si se cumple una condición.
 * - que se repita una instrucción
 * - que se repita mientras se cumple una condición.
 *
 * Para ello debemos controlar el flujo de la ejecución
 * haciendo uso de las estructuras de control de flujo.
 *
 * Las estructuras de control de flujo se dividen en 2 categorías:
 * - de decisión
 * - de repetición (bucles)
 *
 * Todas tienen en común que dependen de evaluar una condición para tomar la decisión.
 *
 * Una condición es una expresión que tiene tipo boolean,
 * y, por tanto, cuando se evalúa su resultado puede ser true o false
 */


void main() {

    int edad = 15;

    if(edad < 18) IO.println("Es menor de edad");

    IO.println("Edad = " + edad);
    while (edad < 18) {
        edad++; // Cumplir años
        IO.println("Cumplir un año");
    }
    IO.println("Edad = " + edad);

    if(edad < 18) IO.println("Es menor de edad");
}