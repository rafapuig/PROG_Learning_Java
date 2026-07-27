/**
 * Bloques de texto
 * <p>
 * Consiste en cero o más caracteres encerrados entre los delimitadores de apertura y cierre.
 * <p>
 * Delimitador de apertura """ {Espacio|Tab} salto de línea   ({} quiere decir cero o más)
 * Delimitador de cierre """
 * <p>
 * Los caracteres se pueden representar mediante secuencias de escape
 * El salto de línea y la doble comilla (que deben representarse con secuencias de escape en literales de string)
 * se pueden usar directamente en un bloque de texto
 *
 */


void main() {
    //IO.println("""Hola mundo"""); // Error, falta el salto de linea en el delimitador de apertura
    IO.println("""
            Hola mundo"""); /* Equivale a */ IO.println("Hola mundo");

    IO.println("""
            <html>
                <body>
                    <p>Hola mundo</p>
                </body>
            </html>""");

    /**
     * La comilla doble y el salto de línea se puede usar directamente
     */
    IO.println("""
            <svg height="400" width="400">
                <circle cx="100" cy="100" r="50" />
            </svg>
            """);
    /* Mucho más legible que : */
    IO.println(
            "<svg height=\"400\" width=\"400\">\n" +
                "<circle cx=\"100\" cy=\"100\" r=\"50\" />\n" +
            "</svg>\n");



    IO.println("""
            cinco"""); // Cinco caracteres

    IO.println("""
            cinco
            """); // Seis caracteres C i n c o LF (salto de línea)
    /* Equivale a */
    IO.println("cinco\n");

    IO.println("""
            Hola, "Cuco"
            """); // 13 caracteres Hola, "Cuco"LF

    IO.println("""
            Hola,
             "Cuco"
            """); // 14 caracteres Hola,LF "Cuco"LF

    IO.println("""
            Hola, "Cuco\""""); // 12 caracteres Hola, "Cuco"
    //* Equivale a */
    IO.println("Hola, \"Cuco\"");
    //IO.println("""
    //        Hola, "Cuco""""); // Error terminar con 4 "
}