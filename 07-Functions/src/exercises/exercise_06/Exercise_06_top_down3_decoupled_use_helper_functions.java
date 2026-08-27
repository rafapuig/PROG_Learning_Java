import static exercises.exercise_06.helpers.Helpers.*;

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
    final String secretWord = askSecretWord();

    // Inicializar la palabra enmascarada
    String maskedWord = createInitialMaskedWord(secretWord, SUBSTITUTION_CHAR);

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
            int matchCount = matchesCountInSecretWord(secretWord, letter);

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
                maskedWord = uncoverMaskedLetter(maskedWord, secretWord, letter);

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


String createInitialMaskedWord(String secretWord, char substitutionChar) {
    return replace(secretWord, substitutionChar, true);
}

boolean checkHasBeenUsed(String usedLetters, char letter) {
    return contains(usedLetters, letter);
}

boolean checkHasBeenAdded(String notInSecretWordLetters, char letter) {
    return contains(notInSecretWordLetters, letter);
}


int matchesCountInSecretWord(String secretWord, char letter) {
    return matchesCount(secretWord, letter);
}


String uncoverMaskedLetter(String maskedWord, String secretWord, char letter) {
    return unmaskLetter(maskedWord, secretWord, letter);
}


boolean checkSecretWordGuessed(String maskedWord, char maskedLetter) {
    return !contains(maskedWord, maskedLetter);
}


void printNotInSecretWordLetters(String notInSecretWordLetters) {
    IO.print("Letras que no están: ");
    printCharacters(notInSecretWordLetters, ", ");
}

void printMaskedWord(String maskedWord) {
    printCharacters(maskedWord, " ");
}
