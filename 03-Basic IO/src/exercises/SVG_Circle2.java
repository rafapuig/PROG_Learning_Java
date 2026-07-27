/**
 * Modifica el programa para que haya saltos de línea en la salida del programa
 * y la salida sea:
 * <svg height='400' width='400'>
 *     <circle cx='100' cy='100' r='50' />
 * </svg>
 *
 * Pista:
 * la secuencia de caracteres \t no imprime una \ seguida de una t
 * el carácter \ tiene una consideración especial y se interpreta como carácter de escape
 * es decir, que queremos "escapar" de la interpretación normal que tendría el carácter que le sucede
 * de este modo, la t no quiere decir que queremos escribir una t, sino que se considere como una tabulación
 */

void main() {
    IO.println("<svg height='400' width='400'><circle cx='100' cy='100' r='50' /></svg>");
}

/**
 * Introduce la salida resultante de la consola
 * en https://www.w3schools.com/html/tryit.asp?filename=tryhtml_svg_circle
 * y luego pulsa Run
 */