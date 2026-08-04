/**
 * Un operador aritmético toma operadores numéricos
 * y realiza una operación aritmética con ellos.
 * <p>
 * Por tanto, solo se aplican a operandos tipos de datos numéricos:
 * byte, short, char, int, long, float y double
 * <p>
 * IMPORTANTE:
 * - En realidad byte, short y char no tienen operadores aritméticos propios
 * La operación pertenece al tipo int,
 * si algún operador es de tipo byte, short o char
 * estos se convierten primero a int
 * para tener ambos operadores de tipo int y luego se realiza la operación
 * <p>
 * Operaciones:
 * + suma
 * - resta
 * * multiplicación
 * / división
 * % módulo
 */

void integerArithmeticAppliesToInts() {

    byte b1 = 1, b2 = 2;
    //byte bResult = b1 + b2; // b1 + b2 es de tipo int
    byte bResult = (byte) (b1 + b2); // Se convierte la expresion a byte
    //byte bResult = (byte) b1 + b2; // No es lo mismo, aqui solo se convierte b1

    short s1 = 1, s2 = 2;
    //short sResult = s1 + s2;
    short sResult = (short) (s1 + s2);

    char c1 = 65, c2 = 66;
    //char cResult = c1 + c2;
    char cResult = (char) (c1 + c2);

    /**
     * Si los operandos son constantes de tiempo de compilación
     * la evaluación se realiza por el compilador (optimización)
     * Solamente una vez cuando se compila, y se sustituye por el resultado
     * Y así, ya no hay que realiza el mismo cálculo en cada ejecución
     * del programa
     */

    final byte cb1 = 1, cb2 = 2;
    byte cbResult = cb1 + cb2;
}

void promotion() {
    /**
     * 1) Si uno de los operandos es double el otro se convierte a double
     * y la expresión tendrá tipo double
     */
    int n = 100;
    double d = 20.0;

    //int sum = n + d; // n se convierte a double y n + d es de tipo double

    /**
     * 2) Si un operando es de tipo float, el otro operando se convierte a float
     * y el tipo de la expresión será float
     */
    float f = 1.5f;
    //int sum = n + f;

    /**
     * 3) Si un operando es de tipo long, el otro se convierte a long
     * y tipo de la expresión long
     */
    long l = 120L;
    //int sum = n + l;

    /**
     * 4) Todos los operandos se convertirán a int, si alguno
     * no es int (byte, short, char)
     */
}

void division() {
    int n;
    /**
     * Si ambos operandos son integrales
     * se realiza la division entera (D = d * c + r)
     */
    n = 5 / 2; // cociente 2, resto 1 (no da 2.5)
    n = 5 / 6; // cociente 0, resto 5 (n = 0)

    /**
     * Si algún operando es float o double
     * se lleva a cabo la división de punto flotante.
     */

    double d;
    d = 5 / 2.0; // d = 2.5
    IO.println(d);
    d = 5.0 / 2; // d = 2.5
    IO.println(d);
    d = 5.0 / 2.0; // d = 2.5
    IO.println(d);
    d = 5 / 2; // d = 2.0, La division es la entera y el resultado se convierte a double
    IO.println(d);

    var dividendo = 10;
    var divisor = 3.0;

    /**
     * Si no sabemos el tipo de dividendo y del divisor
     * no sabemos qué operación se realiza exactamente
     * division entera? o división decimal?
     * Cuando un mismo código puede hacer cosas distintas en función
     * del contexto, veremos que recibe el nombre de código POLIMORFICO
     */
    var result = dividendo / divisor;
    IO.println(result);
}

void divideByZero() {
    // Division entera
    // Compila bien, no hay problema, es sintácticamente correcto
    //IO.println(3 / 0); // Error en tiempo de ejecución (Excepción)

    // Division flotante
    IO.println(3.0 / 0); // + infinito
    IO.println(3.0 / -0.0); // -infinito
    IO.println(0 / 0.0); // Not a Number
}


void main() {
    division();
    divideByZero();
}