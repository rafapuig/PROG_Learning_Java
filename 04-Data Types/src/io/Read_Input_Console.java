/**
 * Ahora que ya conocemos los tipos de datos
 * Vamos a ver como podemos transformar la entrada leída desde la consola
 * en un valor de cualquier tipo.
 * <p>
 * NOTA:
 * - La entrada leída de la consola SIEMPRE es una cadena de caracteres (String) !!!
 * <p>
 * Lo que veremos es como analizar (parsing) una cadena de texto
 * para reconocer patrones
 * que permitan interpretar los caracteres que conforman ese texto
 * como la representación textual de un valor de otro tipo.
 * <p>
 * Por ejemplo, si el texto contiene únicamente dígitos,
 * podemos interpretarlo como las cifras de un número entero en base decimal
 * y generar un valor entero equivalente como resultado del análisis (parsing)
 * <p>
 * En general hacer un parsing es analizar un texto y obtener un valor de otro como resultado.
 */

void main() {
    boolean bool = Boolean.parseBoolean("true");
    int iNumber = Integer.parseInt("1");
    float fNumber = Float.parseFloat("1.1");
    double dNumber = Double.parseDouble("1.1");
}