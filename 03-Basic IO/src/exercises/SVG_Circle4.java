/**
 * Modifica el programa 3 para que obtenga el mismo resultado con solo una llamada a IO.println:
 * <svg height="400" width="400">
 *     <circle cx="100" cy="100" r="50" />
 * </svg>
 *
 * Pista:
 * De nuevo, al igual que introducimos tabulaciones podemos introducir saltos de línea
 * mediante secuencias de escape, en entre caso \n
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