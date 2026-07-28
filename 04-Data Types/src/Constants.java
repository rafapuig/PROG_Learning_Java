/**
 * Constantes
 *
 * Al contrario de las variables, donde el valor almacenado puede
 * sustituirse por otro durante la ejecución del programa...
 *
 * A una constante solamente se le puede asignar un valor inicial
 * que permanece durante toda la vida de la variable.
 *
 * Para indicar que el valor con el que se inicializa es su valor
 * final se usa precisamente la keyword final.
 *
 *
 * Constantes de compilación vs. valores finales
 *
 * Constante en tiempo de compilación:
 * - Son aquellas cuyo valor se conoce en el momento de compilar el
 * código fuente del programa.
 * - Por convención se utiliza SNAKE_CASE para el identificador
 * - Se inicializa mediante una expresión que depende unicamente
 * de valores literales y/u otras constantes en tiempo de ejecución.
 * - Es obligatorio inicializarlas en su declaración.
 *
 * Si NO se puede conocer su valor en tiempo de compilación
 * entonces simplemente las podemos llamar valores (en lugar de variables)
 * y se usa el camelCase para el identificador.
 */

void main() {
    // Constante en tiempo de compilación
    final float CENTIMETERS_PER_INCH = 2.54f;

    // Constante en tiempo de compilación
    /* Se inicializa con una expresion que depende de literales y otras constantes */
    final float MILIMETERS_PER_INCH = 10 * CENTIMETERS_PER_INCH;

    notInitializedConstant();
    compileConstantVsValue();

}

void compileConstantVsValue() {
    // Constante en tiempo de compilación
    /* (se inicializa con una expresión que depende solamente de un valor literal) */
    final int DAYS_IN_WEEK = 7;

    // Constante en tiempo de compilación (sigue siendo una constante de compilación)
    /* Se inicializa con una expresion que depende de literales y otras constantes */
    final int DAY_IN_FORTNIGHT = 2 * DAYS_IN_WEEK;

    /**
     * Las constantes en tiempo de compilación, su valor lo conoce
     * el compilador y lo puede usar para decidir si es correcta o no
     * una asignación de un valor a una variable de otro tipo
     */
    byte b = DAYS_IN_WEEK; // Es correcto sin necesidad de hacer casting
    b = DAY_IN_FORTNIGHT; // Es correcto sin necesidad de hacer casting

    int numWeeks = 4; // Es una variable no final
    // Esto es un valor final no una constante de compilación
    final int daysInNumWeeks = numWeeks * DAYS_IN_WEEK; // Es un valor final, no se puede cambiar

    //daysInNumWeeks = daysInNumWeeks + 3; // Error, no se puede reasignar una constante de valor final

    byte b2 = (byte) daysInNumWeeks; // El casting siempre funciona
    //b2 = daysInNumWeeks; // Error, esto solo funciona si daysInNumWeeks es constante de compilación

}

void notInitializedConstant() {
    // NO es constante en tiempo de compilación!!!
    /* No se inicializa en el momento de la declaración */
    final int MONTHS_PER_YEAR;

    // IO.println(MONTHS_PER_YEAR); // Error, se lee antes de inicializar

    /* Se inicializa cuando se le asigna un valor por primera vez */
    MONTHS_PER_YEAR = 12;

    IO.println(MONTHS_PER_YEAR);

    /**
     * Es un error intentar cambiar el valor de una constante
     * en una instrucción de asignación
     */
    //MONTHS_PER_YEAR = 11; // Error, no se puede reasignar el valor

    /* El compilador no conoce el valor de la constante al no haber
    sido inicializada en la declaración,
    por tanto, no es una constante de compilación.
     */
    //byte b = MONTHS_PER_YEAR; // Error, no es una constante de compilación

    byte b = (byte) MONTHS_PER_YEAR; // Es necesario hacer el casting
}