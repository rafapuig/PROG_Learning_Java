/**
 * Modifica el programa 2 en lugar de comillas simples se impriman comillas dobles
 * y la salida sea:
 * <svg height="400" width="400">
 *     <circle cx="100" cy="100" r="50" />
 * </svg>
 *
 * Pista:
 * el carácter " es el delimitador de los textos literales,
 * por tanto, no se puede usar directamente dentro de un literal de texto,
 * puesto que el compilador, al hacer el análisis léxico, se confundiría
 * y lo interpretaría como el delimitador de final del texto.
 *
 * Pero, la cosa cambia si escapamos la comilla doble mediante \"
 */

void main() {
    IO.println("<svg height='400' width='400'>");
    IO.println("\t<circle cx='100' cy='100' r='50' />");
    IO.println("</svg>");
}

/**
 * Introduce la salida resultante de la consola
 * en https://www.w3schools.com/html/tryit.asp?filename=tryhtml_svg_circle
 * y luego pulsa Run
 */