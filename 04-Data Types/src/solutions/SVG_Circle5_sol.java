/**
 * Modifica el programa del círculo 4:
 * Vamos a hacer que el radio del círculo y las coordenadas del centro sean variables.
 * <svg height="400" width="400">
 *     <circle cx="100" cy="100" r="50" />
 * </svg>
 *
 * - Declara 2 variables enteras `x` e `y` y una double `r`
 * - Asigna valores a las variables
 * - Usa las variables en la generación del resultado

 */

void main() {
    int x, y;
    double r;

    x = 100;
    y = 110;
    r = 20.5;

    IO.println("<svg height=\"400\" width=\"400\">\n" +
        "<circle cx=\"" + x + "\" cy=\"" + y + " r=\"" + r + "\" />\n" +
    "</svg>");
}

/**
 * Introduce la salida resultante de la consola
 * en https://www.w3schools.com/html/tryit.asp?filename=tryhtml_svg_circle
 * y luego pulsa Run
 */