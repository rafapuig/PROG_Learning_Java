/**
 * El ahorcado
 * <p>
 * Usando la función charAt de los String
 * <p>
 * Diseño top-down
 */

void main() {

    final char SUBSTITUTION_CHAR = '_';

    // Iniciar numero de vidas
    int lives = 5;

    // Inicializar letras no encontradas
    String notInSecretWordLetters = "";

    // Inicializar letras usadas
    String usedLetters = "";

    // Inicializar si la palabra secreta ha sido adivinada
    boolean isSecretWordGuessed = false;

    // Pedir palabra secreta al administrador
    final String word = askSecretWord();

    // Inicializar la palabra enmascarada
    String maskedWord = createInitialMaskedWord(word, SUBSTITUTION_CHAR);

    // Imprimir la palabra enmascarada
    printMaskedWord(maskedWord);

    do {
        // Pedir una letra al jugador
        char letter = askLetter();

        // Comprobar si la letra ya ha sido usada
        boolean hasBeenUsedLetter = checkHasBeenUsed(usedLetters, letter);

        // Si la letra ya ha sido usada
        if (hasBeenUsedLetter) {
            // Imprimir que ya ha sido usada anteriormente y que el jugador pierde una vida
            printUsedLetter(letter);

            // Restar una vida al jugador
            lives--;

            // Imprimir que el jugador ha pedido una vida
            printLostLife();

            // Sí se han acabado las vidas del jugador terminar el juego
            if(lives == 0) continue;

        } else {
            // Añadir la letra a la lista de letras usadas
            usedLetters += letter;

            // Buscar la letra en la palabra
            // contar cuantas coincidencias
            int matchCount = matchesCountInSecretWord(word, letter);

            // Si no se ha encontrado la letra en la palabra secreta ni una vez
            if (matchCount == 0) {

                // Imprimir que no se ha encontrado la letra en la palabra secreta
                printLetterNotFound(letter);

                // Comprobar si está en la lista de letras que no están en la palabra secreta
                boolean hasBeenAdded = checkHasBeenAdded(notInSecretWordLetters, letter);

                // Añadir la letra a la lista de letras no encontradas en la palabra secreta
                if (!hasBeenAdded) notInSecretWordLetters += letter;

                // quitar una vida al jugador
                lives--;

                // Imprimir que el jugador ha pedido una vida
                printLostLife();

                // Sí se han acabado las vidas del jugador terminar el juego
                if(lives == 0) continue;

            } else { // Sí se ha encontrado la letra al menos una vez

                //Imprimir cuantas veces se ha encontrado la letra
                printTimesLetterFound(matchCount, letter);

                // Actualizar la palabra enmascarada
                maskedWord = uncoverMaskedLetter(maskedWord, word, letter);

                // Comprobar que se ha adivinado la palabra completa y actualizar
                isSecretWordGuessed = checkSecretWordGuessed(maskedWord, SUBSTITUTION_CHAR);
            }

        }

        // Imprimir la palabra enmascarada
        printMaskedWord(maskedWord);

        // Si la palabra ha sido adivinada, terminar
        if (isSecretWordGuessed) break; // termina el juego directamente

        // Imprimir letras que no están en la palabra secreta
        printNotInSecretWordLetters(notInSecretWordLetters);

        // Imprimir vidas restantes
        printRemainingLives(lives);

    } while (lives > 0); // mientras el juego no tenga que finalizar

    // Fin del juego

    // Si el jugador ha descubierto la palabra imprimir mensaje de ganador
    if(isSecretWordGuessed) {
        // Imprimir que el jugador ha adivinado la palabra secreta
        printSecretWordGuessed();
    }

    // Imprimir que has perdido si se te acabaron las vidas
    if (lives == 0) printNoLivesLeft();
}



/* Mensajes que imprime el programa  */

void printUsedLetter(char letter) {
    IO.println("La letra '" + letter + "' ya ha sido usada!");
}

void printLetterNotFound(char letter) {
    IO.println("No se ha encontrado la letra '" + letter + "' en la palabra secreta");
}

void printTimesLetterFound(int matchCount, char letter) {
    IO.println("Se ha" + (matchCount > 1 ? "n" : "") + " encontrado " + matchCount + " " + letter + (matchCount > 1 ? "'s" : ""));
}

void printSecretWordGuessed() {
    IO.println("Has descubierto la palabra secreta!!!");
}

void printLostLife() {
    IO.println("Pierdes una vida!");
}

void printRemainingLives(int lives) {
    IO.println("Te quedan " + lives + " vidas");
}

void printNoLivesLeft() {
    IO.println("Se te acabaron las vidas");
}



String askSecretWord() {
    return IO.readln("Dime la palabra secreta a adivinar: ");
}

char askLetter() {
    String input = IO.readln("Dime una letra: ");
    return input.charAt(0);
}


String replace(String text, char character) {
    String result = "";
    for (int i = 0; i < text.length(); i++) {
        result += character;
    }
    return result;
}

String replaceStringBuilderImpl(String text, char character) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < text.length(); i++) {
        result.append(character);
    }
    return result.toString();
}

String replaceStringBuilderImplOptimization1(String text, char character) {
    StringBuilder result = new StringBuilder();
    result.repeat(String.valueOf(character), text.length());
    return result.toString();
}

String replaceStringBuilderImplOptimization2(String text, char character) {
    return String.valueOf(character).repeat(text.length());
}


String replace(String text, char character, boolean replaceSpaces) {
    final char space = ' ';
    String result = "";
    for (int i = 0; i < text.length(); i++) {
        if (replaceSpaces && text.charAt(i) == space) result += space;
        else  result += character;
    }
    return result;
}

String replaceStringBuilderImpl(String text, char character, boolean replaceSpaces) {
    final char space = ' ';
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < text.length(); i++) {
        if (replaceSpaces && text.charAt(i) == space) result.append(space);
        else  result.append(character);
    }
    return result.toString();
}


String createInitialMaskedWord(String word, char substitutionChar) {
    return replaceStringBuilderImpl(word, substitutionChar, true);
}


/**
 * contains
 * Busca el carácter letter en la String text y devuelve true si al menos encuentra una vez el carácter
 * @param text
 * @param letter
 * @return
 */
boolean contains_v1(String text, char letter) {
    boolean found = false;
    for (int i = 0; i < text.length(); i++) {
        if (letter != text.charAt(i)) continue;
        found = true;
        break;
    }
    return found;
}

boolean contains(String text, char letter) {
    for (int i = 0; i < text.length(); i++) {
        if (letter == text.charAt(i)) return true;
    }
    return false;
}

boolean checkHasBeenUsed(String usedLetters, char letter) {
    return contains(usedLetters, letter);
}

boolean checkHasBeenAdded(String notInWordLetters, char letter) {
    return contains(notInWordLetters, letter);
}

int matchesCount(String text, char character) {
    int matches = 0;
    for (int i = 0; i < text.length(); i++) {
        if (text.charAt(i) == character) matches++;
    }
    return matches;
}

int matchesCountInSecretWord(String word, char letter) {
    return matchesCount(word, letter);
}


String replaceAt(String text, char character, int index) {
    String result = "";
    for (int i = 0; i < text.length(); i++) {
        if (i != index) result += text.charAt(i);
        else result += character;
    }
    return result;
}

String replaceAtStringBuilderImpl(String text, char character, int index) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < text.length(); i++) {
        if (i != index) result.append(text.charAt(i));
        else result.append(character);
    }
    return result.toString();
}

String uncoverLetter(String maskedWord, char letter, int position) {
    return replaceAtStringBuilderImpl(maskedWord, letter, position);
}

/**
 * uncoverMaskedLetterInefficient
 * Sustituye el carácter en la maskedWord por el carácter letter
 * en cada posición en la que encuentra el carácter letter en el String word
 *
 * Es ineficiente porque se apoya en la función uncoverLetter
 * y esto implica crear una nueva versión de la palabra enmascarada cada vez que se encuentra
 * una aparición de la letra en word
 * @param maskedWord
 * @param word
 * @param letter
 * @return
 */
String uncoverMaskedLetterInefficient(String maskedWord, String word, char letter) {
    for (int i = 0; i < word.length(); i++) {
        if (word.charAt(i) != letter) continue;
        // Descubrir la letra en la maskedWord
        maskedWord = uncoverLetter(maskedWord, letter, i);
    }
    return maskedWord;
}


/**
 * unmaskLetterDirectly
 * Sustituye el carácter en la maskedWord por el carácter letter
 * en cada posición en la que encuentra el carácter letter en el String word
 *
 * Al contrario que uncoverMaskedLetterInefficient
 * no crea una nueva palabra enmascarada cada vez que sustituye una aparición de la letra letter en word
 * Crea directamente la palabra enmascarada resultante final de manera directa
 * @param maskedWord
 * @param word
 * @param letter
 * @return
 */
String unmaskLetterDirectly(String maskedWord, String word, char letter) {
    String result = "";
    for (int i = 0; i < word.length(); i++) {
        if (word.charAt(i) != letter) result += maskedWord.charAt(i);
        else result += word.charAt(i);
    }
    return result;
}

/**
 * unmaskLetterDirectlyStringBuilderImpl
 * Sustituye el carácter en la maskedWord por el carácter letter
 * en cada posición en la que encuentra el carácter letter en el String word
 *
 * Al contrario que uncoverMaskedLetterInefficient
 * no crea una nueva palabra enmascarada cada vez que sustituye una aparición de la letra letter en word
 * Crea directamente la palabra enmascarada resultante final de manera directa
 *
 * Como usa StringBuilder es más eficiente que concatenar Strings,
 * ya que el propio String result se genera una vez llamando al final a toString()
 * @param maskedWord
 * @param word
 * @param letter
 * @return
 */
String unmaskLetterDirectlyStringBuilderImpl(String maskedWord, String word, char letter) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < word.length(); i++) {
        if (word.charAt(i) != letter) result.append(maskedWord.charAt(i));
        else result.append(word.charAt(i));
    }
    return result.toString();
}

String unmaskLetter(String maskedWord, String word, char letter) {
    return unmaskLetterDirectlyStringBuilderImpl(maskedWord, word, letter);
}


String uncoverMaskedLetter(String maskedWord, String word, char letter) {
    return unmaskLetter(maskedWord, word, letter);
}



boolean checkWordFullyGuessed(String word, String maskedWord) {
    return word.equals(maskedWord);
    //return contains(maskedWord, '_');
}


/**
 * Ahora usamos la función conntains
 * pasándole el carácter maskedLetter
 * Si lo no contiene querrá decir que la palabra ha sido completamente descubierta
 * @param maskedWord
 * @param maskedLetter
 * @return
 */
boolean checkSecretWordGuessed(String maskedWord, char maskedLetter) {
    return !contains(maskedWord, maskedLetter);
}


/**
 * Función de utilidad genérica para imprimir los caracteres de un String
 * separados entre sí por el separador
 * @param text
 * @param separator
 */
void printCharacters_v1(String text, String separator) {
    for (int i = 0; i < text.length(); i++) {
        if (i != 0) IO.print(separator);
        IO.print(text.charAt(i));
    }
    IO.println();
}

/**
 * Función de utilidad genérica para imprimir los caracteres de un String
 * separados entre sí por el separador (sola una llamada final al método de I/O println)
 * @param text
 * @param separator
 */
void printCharacters(String text, String separator) {
    String result = "";
    for (int i = 0; i < text.length(); i++) {
        if (i != 0) result += separator;
        result += text.charAt(i);
    }
    IO.println(result);
}

/**
 * Función de utilidad genérica para imprimir los caracteres de un String
 * separados entre sí por el separador (sola una llamada final al método de I/O println)
 * Y optimizada por usar StringBuilder
 * @param text
 * @param separator
 */
void printCharactersStringBuilderImplementation(String text, String separator) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < text.length(); i++) {
        if (i != 0) result.append(separator);
        result.append(text.charAt(i));
    }
    IO.println(result.toString());
}


void printNotInSecretWordLetters(String notInSecretWordLetters) {
    IO.print("Letras que no están: ");
    printCharacters(notInSecretWordLetters, ", ");
}

void printMaskedWord(String maskedWord) {
    printCharacters(maskedWord, " ");
}
