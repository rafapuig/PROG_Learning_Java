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
 * para tener ambos operadores de tipo int
 * y luego se realiza la operación.
 * <p>
 * Operaciones:
 * + suma
 * - resta
 * * multiplicación
 * / división
 * % módulo
 *
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


/**
 * El operador  resto, módulo, modulus (remainder) %
 * <p>
 * op1 % op2
 * <p>
 * Realiza la division de op1 entre op2 y devuelve el resto 12 % 5 se evalúa como 2
 * <p>
 * Regla 1:
 * - Se producirá un error en tiempo de ejecución si el operando derecho vale 0
 * <p>
 * Regla 2:
 * - Si el operando de la derecha es distinto de cero, el signo del resultado es el mismo que el del operando izquierdo
 * <p>
 * Si además, algún operando es un valor de punto flotante se aplican ademas estas reglas:
 * Regla 3:
 * - No es un error si el operador derecho es 0 entero o 0.0 en punto flotante. Se evalua como NaN
 * <p>
 * Regla 4:
 * - El resultado es NaN si alguno de los operandos es NaN
 * <p>
 * Regla 5:
 * -Si el operando de la derecha es cero el resultado es NaN
 * <p>
 * Regla 6:
 * - Si el operando de la izquierda es infinito, el resultado es NaN
 * <p>
 * Regla 7:
 * -Si no se han podido aplicar las anteriores se evalúa como el resto
 */
void modulus() {
    //IO.println(15 % 0); // Error en tiempo de ejecución
    IO.println(15 % 4); // 3
    IO.println(-15 % 4); // -3 porque -15 es negativo
    IO.println(15 % -4); // 3
    IO.println(-15 % -4); // -3 porque -15 es negativo
    IO.println(0 % 5); // 0
    IO.println(5 % 9); // 5

    // Con valores en punto flotante nunca se producirá un error en tiempo de ejecución
    IO.println(-5.0 % 0);
    IO.println(-5 % 0.0f);
    IO.println(Float.NaN % 0); // NaN
    IO.println(-15 % 4.0f); // 3.0f
    IO.println(15 % 4.0); // 3.0
    IO.println(-15.0 % 4.0f); // -3.0f
    IO.println(Float.POSITIVE_INFINITY % -4.0f); // NaN por regla 6
    IO.println(15.0f % Float.NEGATIVE_INFINITY); // 15.0f
    IO.println(-15.0f % Float.NEGATIVE_INFINITY); // -15.0f
    IO.println(15.0f % Float.POSITIVE_INFINITY); // 15.0f
    IO.println(-15.0f % Float.POSITIVE_INFINITY); // -15.0f
}

/**
 * Operador unario +
 * <p>
 * + operando (de tipo numérico)
 * <p>
 * Si el operando es de tipo byte, short o char el operador promociona el valor a int.
 * (Como hemos visto los tipos byte, short y char no tienen sus propios operadores aritméticos)
 */

void unaryPlus() {
    byte b1 = 1, b2 = 2;
    b1 = b2; // OK
    //b1 = +b2; // Error de compilación, el operador + ha promocionado el valor del operando a tipo int como resultado
    b1 = (byte) +b2;
}

/**
 * Operador unario -
 * <p>
 * - operando (numérico)
 * <p>
 * Niega el valor del operando y además lo promociona a int
 */
void unaryMinus() {
    byte b1 = 1, b2 = 2;
    b1 = b2;
    // b1 = -b2; // Error de compilación, el operador - ha promocionado el valor del operando a tipo int como resultado
    b1 = (byte) -b2;
}

/**
 * OPERADORES ARITMÉTICOS DE ASIGNACIÓN COMPUESTOS
 * <p>
 * Cada uno de los 5 operadores aritméticos ( +, -, *, /, % ) tienen correspondencia con una versión
 * que une la operación aritmética en sí junto con una operación de asignación.
 * <p>
 * +=, -=, *=, /=, %=
 * <p>
 * operando_izquierdo operador_compuesto operando_izquierdo
 * <p>
 * que equivale a -->
 * op_izq = (casting_a_tipo_op_izq) (op_izq operador_aritmético op_der)
 * <p>
 * Se utiliza cuando alguna variable interviene a la vez en la expresión rvalue y la lvalue
 * En otras palabras, cuando queremos hacer un cálculo que usa el valor de un variable
 * y además, guardar el resultado en la variable.
 */

void compound() {
    int iNum = 100;
    byte bNum = 15;
    /*
    Como sumar el contenido de iNum (que es de tipo int) con el de bNum (que es de tipo byte)
    y almacenar el resultado en bNum
    Teniendo en cuenta los tipos de ambas variables, la instrucción quedaría así.
    */
    bNum = (byte) (iNum + bNum);

    bNum += iNum; // Se permite un casting implicito si se usa el operador compuesto

    iNum += 5; // equivale a iNum = iNum + 5
    /**
     * OJO con el orden += es el operador compuesto, no asi =+ (esto es asignar y el operador + unario)
     */
    iNum = 3;
    iNum = +5; // iNum pasa a contener el valor 5 positivo, no 3 + 5
    IO.println(iNum);
    iNum += 10; // 5 + 10 --> iNum = 15
    IO.println(iNum);


    /*
    El valor 5 se convierte a double para sumar a 3.4,
    el resultado convierte a int (se elimina la parte decimal) hay un casting implícito
     */
    iNum = 5;
    iNum += 3.4;
    IO.println(iNum);
    /* Equivalencia sin operador compuesto */
    iNum = 5;
    iNum = (int) (iNum + 3.4);
    IO.println(iNum); // 5 + 3 --> 8
}

/**
 * Operadores de incremento ++ y decremento --
 * <p>
 * El operador de incremento ++ incrementa en una unidad el valor almacenado en la variable.
 * El operador de decremento -- decrementa en una unidad el valor almacenado en la variable.
 * <p>
 * El operando debe ser un lvalue (referencia a una variable)
 * El resultado de la operación es un rvalue (un valor, no una variable)
 * <p>
 * Existen dos versiones del operador:
 * - Postfijo --> operando++
 * - Prefijo --> ++operando
 * <p>
 * La version posfija devuelve el valor previo al incremento de la variable
 * La version prefija devuelve el valor de la variable ya incrementada
 *
 */


void increment() {
    int i, j;

    // Primera forma de incrementar i: operador + y operador =
    i = 10;
    i = i + 1;

    // Segunda forma, operador de + y = compuesto
    i = 10;
    i += 1;

    // Tercera manera, con el operador de incremento
    i = 10;
    i++;

    //var x = 5++; // no es un lvalue

    j = 10;
    i = 50;
    // Se evalúa la i que vale 50 y la j que vale 10, 50 - 10 = 40 y se asigna a j
    // la i tras evaluarla se incrementa en una unidad
    j = i++ - j; // j = 50 - 10 = 40 y i = i + 1 = 51
    IO.println("i = " + i); // 51
    IO.println("j = " + j); // 40

    i = 10;
    // La primera vez que se evalúa i vale 10, la segunda vez vale 11 --> 10 + 11 = 21
    // y la i se incrementa dos veces i = 12
    j = i++ + i++;
    IO.println("i = " + i); // 12
    IO.println("j = " + j); // 21

    /* Prefija */

    j = 10;
    i = 50;
    // Se evalúa la i, que tras incrementar vale 51, y la j que vale 10, 51 - 10 = 41 y se asigna a la j
    // la se incrementa en una unidad
    j = ++i - j; // j = 50 - 10 = 40 y i = i + 1 = 51
    IO.println("i = " + i); // 51
    IO.println("j = " + j); // 41

    i = 10;
    // La primera vez que se evalúa i vale 11, la segunda vez vale 12 --> 11 + 12 = 23
    // y la i se incrementa dos veces i = 12
    j = ++i + ++i;
    IO.println("i = " + i); // 12
    IO.println("j = " + j); // 23

    i = 10;
    i = i++; // ¿i es 10 o es 11?
    /*
    i++ es postfijo, por tanto, para calcular el rvalue de la asignación utilizamos el valor previo al incremento: 10
    la variable i es incrementada y pasa a valer 11,
    pero ahora, por último tenemos que realizar la operación de asignación donde el lvalue es la variable i
    y el rvalue calculado era 10, por tanto, tenemos que escribir el valor 10 en la variable i
    con lo cual se pierde el valor anterior fruto de la operación de incremento
    La variable i sufre dos operaciones de modificación!!!
     */
    IO.println("i = " + i); // 10

    /* Esta operación tampoco tiene sentido, la variable i ya tiene incrementado el valor,
    es redundante asignarlo de nuevo */
    i = ++i;
    IO.println("i = " + i);

    // i++ es un rvalue, no se puede usar como operando izquierdo de una asignación
    /*i++ = 5;
    IO.println("i = " + i);*/
}


void main() {
    //division();
    //divideByZero();
    //modulus();
    increment();
}