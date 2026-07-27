/**
 * Literales de carácter
 * <p>
 * Se expresan en el código fuente mediante...
 * - un único caracter unicode
 * - una secuencia de escape
 * ... encerradas entre comillas simples
 * <p>
 * Los únicos caracteres que no se pueden usan dentro de las comillas simples son ' y \
 * <p>
 * Un literal de carácter SIEMPRE se considera un valor de tipo char
 */

// https://docs.oracle.com/en/java/javase/26/docs/specs/jls/jls-3.html#jls-3.10.4
void singleCharacterLiterals() {

    /* Los valores literales de carácter se expresan encerrados entre comillas simples */

    // En estos ejemplos el literal es un carácter único (solo uno)
    IO.println('a'); // a
    IO.println('L'); // uppercase L
    IO.println('5'); // digit Five
    IO.println('/'); // forward Slash
    IO.println('™'); // TM
    IO.println('❌'); // cross
    IO.println('✈'); // plane
    IO.println('⚄'); // cara 5 del dado

    /* Válido para cualquier carácter excepto ' y \ (veremos por qué) */

    //char singleQuote = '''; // ❌ Error de compilación
    //char backSlash = '\'; // ❌ Error de compilación
}

void singleCharacterLiteralsNumberVsDigit() {
    //OJO: No es lo mismo '9' que 9, o '0' que 0, etc.

    char nueve = 9;
    IO.println(nueve); // Imprime el carácter de código 9 (el tabulador horizontal)
    IO.println("Aitor" + nueve + "Tilla");
    IO.println((int) nueve); // 9

    char nine = '9'; // Carácter correspondiente al dígito 9
    IO.println(nine);
    IO.println((int) nine); // 57 es el código unicode del carácter dígito 9
}


// El literal de carácter como una secuencia de escape
void singleCharacterSingleQuoteAndBackSlash() {
    /*
    ¿Cómo podemos hacer que el valor literal del carácter sea la comilla simple
    si la comilla simple se usa como delimitador del literal?
    Respuesta: usando un carácter de escape especial: el \
     */

    // Single Quote
    // IO.println('''); // ❌ Error de compilación
    IO.println('\''); // El \ seguido de '

    // Backslash
    //IO.println('\'); // ❌ Error de compilación
    IO.println('\\'); // El \ y ahora el carácter que queramos
}

// https://docs.oracle.com/en/java/javase/26/docs/specs/jls/jls-3.html#jls-EscapeSequence
void escapeSequenceLiterals() {

    /* Otras secuencias de escape */
    IO.print("Line feed" + '\n');

    IO.println("Carriage return" + '\r' + "Sobrescribe el carriage return!!"); // Carriage Return

    IO.println("Form feed" + '\f' + "..."); // Form Feed

    IO.println("Hola" + '\b' + "i!!"); // Back Space,  Imprime: Holi!! (borra la a)

    IO.println("Pedro" + '\t' + "Gado" + '\t' + "López"); // Tabulación

    IO.println('\"'); // Double Quote
}


// https://docs.oracle.com/en/java/javase/26/docs/specs/jls/jls-3.html#jls-UnicodeEscape
void unicodeScapeLiterals() {
    /* Escape para representar un código de carácter unicode */

    /** Un literal de carácter también se puede representar con una secuencia de escape unicode
     * UnicodeMarker HexDigit HexDigit HexDigit HexDigit
     * El UnicodeMarker es la letra u
     * Un HexDigit puede ser  0 1 2 3 4 5 6 7 8 9 A B C D D E F a b c d e f
     *
     * Por tanto, con la forma '\ u xxxx' donde x representa un dígito hexadecimal (y hay 4 digitos)
     * Es decir, desde \u0000 hasta el \uffff
     */

    IO.println('\u274C'); // Secuencia de escape Unicode de la ❌
    IO.println('❌');

    IO.println('\u2708'); // ✈
    IO.println('✈');


    IO.println('⚀');// \u2680
    IO.println('⚁');// \u2681

    IO.println('\u2680'); // ⚀
    IO.println('\u2681'); // ⚁
    IO.println('\u2682'); // ⚂
    IO.println('\u2683'); // ⚃
    IO.println('\u2684'); // ⚄
    IO.println('\u2685'); // ⚅
}


void main() {
    singleCharacterLiterals();
    singleCharacterLiteralsNumberVsDigit();
    singleCharacterSingleQuoteAndBackSlash();
    escapeSequenceLiterals();
    unicodeScapeLiterals();
}





// TODO: para cadenas de caracteres ....
void printsPlane() {
    IO.println('\uD83D');
    IO.println('\uDEE9');

    IO.println("" + '\uD83D' + '\uDEE9'); // Magia
}

void printPlane() {
    var plane1 = '\uD83D';
    var plane2 = '\uDEE9';
    var plane3 = '\uFE0F';

    var plane = /*"🛩️"*/"🍕";

    var plane_ = new String(new char[]{'\uD83D', '\uDEE9', '\uFE0F'});
    IO.println(plane_);

    var planeX = new String(Character.toChars(0x1F6E9));
    IO.println(planeX);

    var planeArray = new char[]{plane1, plane2, plane3};
    var planeString = new String(planeArray);
    IO.println(planeString);

    IO.println("" + plane1 + plane2 + plane3);
    IO.println(plane);
}