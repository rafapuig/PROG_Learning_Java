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
 * Una reserved keyword NUNCA se puede usar como identificador
 *
 * Existen otras 17 secuencias de caracteres que se interpretarán
 * como keyword o como otro tipo de token
 * dependiendo del contexto donde aparecen.
 *
 * NOTA: true y false NO son keywords se consideran literales del tipo de datos boolean
 */

void main() {

    // la keyword record aquí no tiene consideración especial de keyword
    var record  = "";

    // Aquí record sí actúa como keyword
    record Point(int x, int y) {}

    // var como keyword, como identificador y como literal de texto según el contexto
    var var = "var";
}