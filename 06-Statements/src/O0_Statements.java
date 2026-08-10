/**
 * Statements (instrucciones)
 * <p>
 * Tipos de instrucciones (statements):
 * - de declaración (declaration)
 * - de expresión (expression)
 * - de control de flujo (control flow)
 * <p>
 * <p>
 * Las instrucciones de declaración se usan para declarar variables (e inicializarlas)
 */

void main() {

    // Instrucción de declaración
    int number = 25;

    // Instrucción de expresión (expresión seguida de un ;)
    // NOTA, no toda expresión añadiéndole el ; se convierte en una instrucción de expresión válida
    IO.println("Hola mundo");
    number = 15;
    number++;
    //number + 5; // instrucción de expresión no válida
    number += 5; // si válida

    // Instrucción de control de flujo
    if (number >= 10) IO.println("El numero tiene al menos dos dígitos.");
}