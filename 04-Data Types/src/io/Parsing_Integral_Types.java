
/**
 * Las clases
 * - Integer para valores int
 * - Long para valores long
 * - Short para valores short
 * - Byte para valores byte
 *
 *
 * tienen un método parseXXX donde XXX es el nombre de la clase (Excepto Integer es ques Int)
 * que recibe como argumento un valor String y devuelve un valor del tipo primitivo correspondiente a la clase
 *
 * Integer y Long ademas cuentan con un metodo parseUnsignedXXX donde XXX es Int o Long
 *
 */

/**
 * Parsing a valores enteros con signo del tipo primitivo
 */
void integerParsing() {
    String input = IO.readln("Introduce los dígitos de un número entero: ");
    byte bNumber = Byte.parseByte(input);
    short sNumber = Short.parseShort(input);
    /* No existe un Character.parseChar() */
    int iNumber = Integer.parseInt(input);
    long lNumber = Long.parseLong(input);
}

/**
 * Parsing a valores enteros sin signo
 */
void unsignedIntegerParsing() {
    String input = IO.readln("Introduce los dígitos de un número entero: ");
    int iNumber = Integer.parseUnsignedInt(input);
    long lNumber = Long.parseUnsignedLong(input);
}


void parseUnsignedInt() {
    String input = IO.readln("Dime tu edad en años: ");

    // Los caracteres del texto deben ser todos dígitos decimales (0..9) (el primero puede ser el signo +)
    int age = Integer.parseUnsignedInt(input);

    IO.println(age);

    // Tener el valor como entero permite usarlo como un número
    IO.println("El año que viene cumplirás " + (age + 1) + " años");
}

void parseInt() {
    String input = IO.readln("Dime planta destino (negativa o positiva): ");

    // Los caracteres del texto deben ser todos dígitos decimales (0..9) (el primero puede ser el signo + o el signo -)
    int floor = Integer.parseInt(input);

    IO.println(floor);

    int nextFloor = floor + 1;
    IO.println("La planta mas arriba de la elegida es " + nextFloor);
}

/**
 * Radix
 *
 * El radix es el número que indica la base utilizada
 * para expresar ,mediante dígitos válidos para esa base, una cantidad numérica.
 *
 * Es un argumento que se puede pasar a la función parseXXX además del texto a analizar
 * Su valor debe estar entre 2 y 36 para ser aceptado
 */

void parseBinaryInteger() {
    String input = IO.readln("Introduce un número en binario (+|-){0, 1}*: ");
    // Los caracteres del texto deben ser todos dígitos válidos en base 2: 0 y 1
    // (el primero puede ser el signo + o el signo -)
    int binaryNumber = Integer.parseInt(input, 2); // Analizar un número escrito en base 2 (solo 1s y 0s)

    IO.println(binaryNumber);
    IO.println(Integer.toBinaryString(binaryNumber));
}

void parseHexadecimalInteger() {
    String input = IO.readln("Introduce un número en hexadecimal (+|-){0..9,A,B,C,D,E,F}*: ");

    // Los caracteres del texto deben ser todos dígitos válidos en hexadecimal [0..9A..F]
    int hexNumber = Integer.parseInt(input, 16); // Analizar un número escrito en hexadecimal

    // Si no es válido devuelve -1
    IO.println(Character.digit('Q', 16));

    IO.println(hexNumber);
    IO.println(Integer.toHexString(hexNumber));
}


void parseBase4Integer() {
    String input = IO.readln("Introduce un número en base 4 (+|-){0, 1, 2 3}*: ");
    // Los caracteres del texto deben ser todos dígitos válidos según el radix [0..radix-1]
    // (el primero puede ser el signo + o el signo -)
    int binaryNumber = Integer.parseInt(input, 4); // Analizar un número escrito en base 4 (solo 0,1,2 y 3)

    IO.println(binaryNumber);
}

void maxMinRadix() {
    IO.println("Base mínima: " + Character.MIN_RADIX);
    IO.println("Base máxima: " + Character.MAX_RADIX);
}

void parseRadixInteger(int radix) {
    String input = IO.readln("Introduce un número en base " + radix + ": ");
    // Los caracteres del texto deben ser todos dígitos válidos según el radix [0..radix-1]
    int binaryNumber = Integer.parseInt(input, radix);

    IO.println(binaryNumber);
}

void testDifferentRadixValues() {
    maxMinRadix();
    parseRadixInteger(Character.MIN_RADIX - 1);  // Excepción en tiempo de ejecución
    parseRadixInteger(Character.MIN_RADIX);
    parseRadixInteger(Character.MAX_RADIX);
    parseRadixInteger(Character.MAX_RADIX + 1); // Excepción en tiempo de ejecución
}

/**
 * Con Integer y Long
 * además podemos especificar la posición (inclusiva) del carácter del texto desde el cual empezar el análisis
 * y la posición (exclusiva, no incluida) del carácter por el cual terminar
 */
void IntegerParsingSubString() {
    String input = IO.readln("Introduce los dígitos de un número entero: ");
    int iNumber = Integer.parseInt(input, 0, input.length(), 10);
    long lNumber = Long.parseLong(input, 0, input.length(), 10);
}


void main() {
    //testDifferentRadixValues();
    //parseBinaryInteger();
    //parseRadixInteger();
    //parseHexadecimalInteger();
}

