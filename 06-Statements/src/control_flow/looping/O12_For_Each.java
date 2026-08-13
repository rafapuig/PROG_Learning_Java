/**
 * For-each (bucle for mejorado)
 * <p>
 * Se usa para iterar los elementos de:
 * - un array (ya lo veremos)
 * - una colección (ya lo veremos)
 * <p>
 * Sintaxis:
 * <p>
 * for (tipo_elemento identificador_elemento : collection_array)
 *      instrucción
 * <p>
 * <p>
 * El bucle se repite para poder procesar todos los elementos de la colección (o array)
 * Cada vez que se ejecuta la instrucción, la variable identificador_elemento
 * contiene el elemento actual, el cual toca procesar en esa iteración.
 */

void main() {

    String message = "Hola, mundo!";

    // elems es un array de elementos de tipo char
    var elems = message.toCharArray();

    /* Mediante un bucle for normal */
    for (int k = 0; k < elems.length; k++) {
        char elem = elems[k];
        IO.println(elem);
    }

    /* Mediante un bucle for-each */
    for (char elem : elems) {
        IO.println(elem); // elem contiene el valor del elemento de la colección que toca procesar en la iteración.
    }

}