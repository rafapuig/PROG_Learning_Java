/** PALABRAS CLAVE (KEYWORD)
 * Cada lenguaje define un conjunto de secuencias de caracteres
 * a las que se denomina keywords o palabras clave
 *
 * https://docs.oracle.com/en/java/javase/26/docs/specs/jls/jls-3.html#jls-3.9
 *
 * En Java, las keyword están divididas en 2 categorías:
 * - Reserved Keyword (51)
 * - Contextual Keyword (17)
 *
 * Una reserved keyword no se puede usar como identificador
 *
 * Existen 17 secuencias de caracteres que se interpretarán como keyword o como otro tipo de token
 * dependiendo de donde aparecen, es decir, del contexto.
 *
 * NOTA: true y false NO son keywords se consideran literales
 */

void main() {
    var record  = ""; // la keyword record aquí no tiene consideración especial de keyword

    record Point(int x, int y) {} // Aquí record si es actúa como keyword

    var var = "var"; // var como keyword, como identificador y como literal de texto según el contexto
}