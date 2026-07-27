/**
 * Literal de cadena de caracteres (string)
 * https://docs.oracle.com/en/java/javase/26/docs/specs/jls/jls-3.html#jls-StringLiteral
 *
 * Un literal de string consiste en una secuencia de cero o más caracteres encerrados entre
 * dobles comillas.
 *
 * Los caracteres del string pueden ser:
 * - carácter unicode
 * - secuencia de escape ( \ )
 *
 * Todos los literales de string son instancias / objetos de la clase String
 */

void main() {

    IO.println(""); // Un string vacío, ningún carácter, cero caracteres
    IO.println("Hola"); // 4 caracteres 'H', 'o', 'l', y 'a' --> longitud 4
    IO.println("Un literal de string");

    /* Es un error de sintaxis usar el salto de línea (line separator) dentro
    del literal de string */
    // IO.println("Abraca
    //         dabra");

    /* Si queremos partir el literal de string en dos líneas tenemos que usar
    * el operador de concatenación */
    IO.println("Abraca" +
            "dabra");

    /* Si queremos que el literal contenga un salto de línea lo haremos mediante su
    secuencia de escape /n
     */
    IO.println("Abra\ncadabra");

    /**
     * Todo los dicho para carácter en lo que respecta a secuencias de escape se aplica
     * a los literales de string
     */

    IO.println("Perico\tPalotes");
    IO.println("\uD83D\uDEE9\uFE0F");

    /* En este caso el carácter " es el delimitador de literal string
    y es el que no podemos usar directamente como caracter del literal puesto que confunde
    el análisis léxico del compilador
     */
    //IO.println("El niño "Cuco" está dormido"); // ❌ Error de compilación
    IO.println("El niño \"Cuco\" está dormido"); // Escapamos el caracter " con \"

    IO.println("El carácter \\ necesita escaparse mediante \\\\"); // Escape del \ mediante \\


}