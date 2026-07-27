/**
 * Literal del valor nulo
 *
 * En java, la secuencia de caracteres:
 *
 * null
 *
 * se considera el literal correspondiente al único valor posible del tipo de datos nulo *
 */

/**
 * No se puede usar como identificador
 */
// int null = 0; // ❌ Error de compilación


/** El valor de tipo nulo
 * se puede asignar a cualquier variable de un tipo por referencia
 * como por ejemplo String
 */
String nullText = null;

/** NO se puede asignar a variables de tipo primitivo !!! */
//int n = null; // ❌ Error de compilación

/** NO se pueden declarar variables cuyo tipo de datos sea el tipo nulo */
// Null aNull = null; // No existe forma de hacerlo
// Tampoco tendría sentido dado que solamente exite un único valor posible de ese tipo (no habría variedad)

void main() {
    IO.println(null);
}