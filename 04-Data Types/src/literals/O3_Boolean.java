/**
 * Literales booleanos
 *
 * Existen dos secuencias de caracteres:
 * - true
 * - false
 *
 * que sirven para representar los dos valores posibles del tipo de datos boolean
 */

boolean isVisible = true;
boolean isMaximized = false;

/**
 * Curiosidad: aunque true y false no son palabras clave según la especificación de Java,
 * siguen siendo palabras reservadas.
 * Esto significa que no puedes utilizarlas como identificadores.
 */

//int true = 5;      // ❌ Error de compilación
//boolean false = true; // ❌ Error de compilación

void main() {
    IO.println(true);
    IO.println(false);
}