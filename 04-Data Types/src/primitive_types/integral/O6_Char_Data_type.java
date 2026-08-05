/**
 * El tipo char
 * <p>
 * Un valor de tipo char requiere 16 bits para representarlo
 * <p>
 * Esto nos permite unos 2^16 posibles valores diferentes de tipo char
 * (desde el 0 hasta el 65535 --> '\u0000' hasta '\uffff' inclusive)
 * <p>
 * Operaciones permite unas pocas de las de enteros
 * ++
 * --
 * +=
 * -=
 * *=
 * /=
 * %=
 * Pero truncará cuando haya desborde (overflow)
 *
 * Relacionales ( > < == != <= >= )
 *
 */

char myUninitializedChar; // El valor por defecto es 0

void main() {
    //defaultValueDemo();
    //operations();
    //overflowDemo2();
    //singleCharacterLiterals();
    //escapeSequenceLiterals();
    unicodeScapeLiterals();
    unicodeScapeLiteralsDiceFaces();
}

void defaultValueDemo() {
    IO.println(myUninitializedChar);
    IO.println((int) myUninitializedChar); // 0

    IO.println("Hola" + myUninitializedChar + "mundo");
}

void operations() {
    char x = '0';
    IO.println(x);

    char y = '1';
    IO.println(y);

    char m = 65535;
    char n = 91;
    m += n; // Hace truncado
    IO.println(m);
}

void relationalOperations1() {
    char zero = '0';
    IO.println(zero);

    char nine = '9';

    char eight = '8';

    IO.println(nine >= eight);
    IO.println(zero <= eight);
    IO.println(nine < eight);
    IO.println(zero > eight); // false
    IO.println(zero == '0'); // true
    IO.println(nine != eight); // true
}

void relationalOperations2() {
    char letter = 'f';

    // Vamos a comprobar que letter es una letra minúscula
    var isGreaterThanLowerA =  letter >= 'a';
    var isLessThanLowerZ =  letter <= 'z';
    IO.println(isGreaterThanLowerA); // true
    IO.println(isLessThanLowerZ); // true
}

void overflowDemo() {
    char c = 65535;
    IO.println((int) c);

    c++;
    IO.println((int) c);

    c--;
    IO.println((int) c);
}

void overflowDemo2() {
    char z = 'Z';
    IO.println(z);
    IO.println((int) z);

    char x = 65535;

    z += x;
    IO.println(z);
    IO.println((int) z);

    z++;
    IO.println(z);
    IO.println((int) z);

    z -= x;
    IO.println(z);
    IO.println((int) z);

    z--;
    IO.println(z);
    IO.println((int) z);

    z %= 255;
    IO.println(z);
}

// https://docs.oracle.com/en/java/javase/26/docs/specs/jls/jls-3.html#jls-3.10.4
void singleCharacterLiterals() {

    /* Podemos usar para valores del tipo char
    literales de enteros, siempre que estén entre 0 y 65535 */
    char minChar = 0;
    IO.println(minChar);
    IO.println((int) minChar);

    char maxChar = 65535;
    IO.println(maxChar);
    IO.println((int) maxChar);

    // Sin embargo, existen literales de character

    /* Los valores literales de carácter se expresan encerrados entre comillas simples */

    // En estos ejemplos el literal es un carácter único (solo uno)
    char a = 'a';
    char upperL = 'L';
    char digitFive = '5';
    char forwardSlash = '/';

    char tm = '™';

    IO.println(a);
    IO.println(upperL);
    IO.println(digitFive);
    IO.println(tm);

    /* Válido para cualquier carácter excepto ' y \ (veremos por qué)*/

    //OJO: No es lo mismo '9' que 9, o '0' que 0, etc.

    char nueve = 9;
    IO.println(nueve); // Imprime el carácter de código 9 (el tabulador horizontal)
    IO.println("Aitor" + nueve + "Tilla");
    IO.println((int) nueve); // 9

    char nine = '9';
    IO.println(nine);
    IO.println((int) nine); // 57 es el código unicode del carácter dígito 9
}


// https://docs.oracle.com/en/java/javase/26/docs/specs/jls/jls-3.html#jls-EscapeSequence
void escapeSequenceLiterals() {
    // El literal como una secuencia de escape
    /*
    ¿Cómo podemos hacer que el valor del carácter sea la comilla simple
    si la comilla simple se usa como delimitador del literal?
    Respuesta: usando un carácter de escape: el \
     */
    //char simpleQuoteWrong = ''';
    char simpleQuote = '\''; // El \ seguido de '

    IO.println(simpleQuote);

    //char backSlashWrong = '\';
    char backSlash = '\\'; // El \ y ahora el carácter que queramos

    IO.println(backSlash);


    /* Otras secuencias de escape */
    char lineFeed = '\n';
    IO.print("Line feed" + lineFeed);

    char carriageReturn = '\r';
    IO.println("Carriage return" + carriageReturn + "Sobrescribe el carriage return!!");

    char formFeed = '\f';
    IO.println("Form feed" + formFeed + "...");

    char backspace = '\b';
    IO.println("Hola" + backspace + "i!!"); // Imprime: Holi!! (borra la a)

    char tab = '\t';
    IO.println("Pedro" + tab + "Gado" + tab + "López");

    char doubleQuote = '\"';
    IO.println(doubleQuote);
}


// https://docs.oracle.com/en/java/javase/26/docs/specs/jls/jls-3.html#jls-UnicodeEscape
void unicodeScapeLiterals() {
    /* Escape para representar un código de carácter unicode */

    /* Un literal de carácter también se puede representar con una secuencia de escape
     * con la forma '\ u xxxx' x representa un dígito hexadecimal
     * Es decir, desde \u0000 hasta el \uffff
     */

    var unicode1 = '\uD83D';
    IO.println(unicode1);

    var unicode2 = '\uDEE9';
    IO.println(unicode2);

    IO.println("" + unicode1 + unicode2); // Magia

    var plane = '\u2708'; // ✈
    IO.println(plane);

    var diceOne = '⚀'; // \u2680
    IO.println(diceOne);

    var diceTwo = '⚁'; // \u2681
    IO.println(diceTwo);

    IO.println('\u2680'); // ⚀
    IO.println('\u2681'); // ⚁
    IO.println('\u2682'); // ⚂
    IO.println('\u2683'); // ⚃
    IO.println('\u2684'); // ⚄
    IO.println('\u2685'); // ⚅
}

void unicodeScapeLiteralsDiceFaces() {
    // Con literales de carácter en forma de secuencia de escape unicode
    for (char face = '\u2680'; face <= '\u2685'; face++) {
        IO.println(face);
    }

    // Con literales enteros en hexadecimal
    for (char face = 0x2680; face <= 0x2685 ; face++) {
        IO.println(face);
    }

    // Con literales enteros en decimal
    for (char face = 9856; face < 9861; face++) {
        IO.println(face);
    }
}

