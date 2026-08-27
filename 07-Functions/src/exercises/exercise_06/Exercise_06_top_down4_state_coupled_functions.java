import static exercises.exercise_06.helpers.Helpers.*;

/**
 * El ahorcado
 * <p>
 * Usando la función charAt de los String
 * <p>
 * Diseño top-down
 */

final char MASKED_LETTER = '_';
final char SUBSTITUTION_CHAR = '_';
String secretWord;
String maskedWord;
String notInSecretWordLetters;
String usedLetters;
int lives;

void main() {

    // Iniciar numero de vidas
    lives = 5;

    // Inicializar letras no encontradas
    notInSecretWordLetters = "";

    // Inicializar letras usadas
    usedLetters = "";

    // Inicializar si la palabra secreta ha sido adivinada
    boolean isSecretWordGuessed = false;

    // Pedir palabra secreta al administrador
    secretWord = askSecretWord();

    // Inicializar la palabra enmascarada
    maskedWord = createInitialMaskedWord();

    // Imprimir la palabra enmascarada
    printMaskedWord();

    do {
        // Pedir una letra al jugador
        char letter = askLetter();

        // Comprobar si la letra ya ha sido usada
        boolean hasBeenUsedLetter = checkHasBeenUsed(letter);

        // Si la letra ya ha sido usada
        if (hasBeenUsedLetter) {
            // Imprimir que ya ha sido usada anteriormente y que el jugador pierde una vida
            printAlreadyUsedLetter(letter);

            // Restar una vida al jugador
            lives--;

            // Imprimir que el jugador ha pedido una vida
            printLostLife();

            // Sí se han acabado las vidas del jugador terminar el juego
            if (lives == 0) continue;

        } else {
            // Añadir la letra a la lista de letras usadas
            addToUsedLetters(letter);

            // Buscar la letra en la palabra
            // contar cuantas coincidencias
            int matchCount = matchesCountInSecretWord(letter);

            // Si no se ha encontrado la letra en la palabra secreta ni una vez
            if (matchCount == 0) {

                // Imprimir que no se ha encontrado la letra en la palabra secreta
                printLetterNotFound(letter);

                // Comprobar si está en la lista de letras que no están en la palabra secreta
                boolean hasBeenAdded = checkHasBeenAdded(letter);

                // Añadir la letra a la lista de letras no encontradas en la palabra secreta
                if (!hasBeenAdded) addToNotInSecretWordLetters(letter);

                // quitar una vida al jugador
                lives--;

                // Imprimir que el jugador ha pedido una vida
                printLostLife();

                // Sí se han acabado las vidas del jugador terminar el juego
                if (lives == 0) continue;

            } else { // Sí se ha encontrado la letra al menos una vez

                //Imprimir cuantas veces se ha encontrado la letra
                printTimesLetterFound(matchCount, letter);

                // Actualizar la palabra enmascarada
                maskedWord = uncoverMaskedLetter(letter);

                // Comprobar que se ha adivinado la palabra completa y actualizar
                isSecretWordGuessed = checkSecretWordGuessed();
            }

        }

        // Imprimir la palabra enmascarada
        printMaskedWord();

        // Si la palabra ha sido adivinada, terminar
        if (isSecretWordGuessed) break; // termina el juego directamente

        // Imprimir letras que no están en la palabra secreta
        printNotInSecretWordLetters();

        // Imprimir vidas restantes
        printRemainingLives();

    } while (lives > 0); // mientras el juego no tenga que finalizar

    // Fin del juego

    // Si el jugador ha descubierto la palabra imprimir mensaje de ganador
    if (isSecretWordGuessed) {
        // Imprimir que el jugador ha adivinado la palabra secreta
        printSecretWordGuessed();
    }

    // Imprimir que has perdido si se te acabaron las vidas
    if (lives == 0) printNoLivesLeft();
}


/* Métodos todavía desacoplados (no dependen del estado) */

String askSecretWord() {
    return IO.readln("Dime la palabra secreta a adivinar: ");
}

char askLetter() {
    String input = IO.readln("Dime una letra: ");
    return input.charAt(0);
}

void printAlreadyUsedLetter(char letter) {
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

void printNoLivesLeft() {
    IO.println("Se te acabaron las vidas");
}



/* Métodos acoplados con el estado del programa */

void printRemainingLives() {
    IO.println("Te quedan " + lives + " vidas");
}

void printNotInSecretWordLetters() {
    IO.print("Letras que no están: ");
    printCharacters(notInSecretWordLetters, ", ");
}

void printMaskedWord() {
    printCharacters(maskedWord, " ");
}


String createInitialMaskedWord() {
    return replace(secretWord, MASKED_LETTER, true);
}

boolean checkHasBeenUsed(char letter) {
    return contains(usedLetters, letter);
}

boolean checkHasBeenAdded(char letter) {
    return contains(notInSecretWordLetters, letter);
}

int matchesCountInSecretWord(char letter) {
    return matchesCount(secretWord, letter);
}


String uncoverMaskedLetter(char letter) {
    return unmaskLetter(maskedWord, secretWord, letter);
}

boolean checkSecretWordGuessed() {
    return !contains(maskedWord, MASKED_LETTER);
}

void addToUsedLetters(char letter) {
    usedLetters += letter;
}

void addToNotInSecretWordLetters(char letter) {
    notInSecretWordLetters += letter;
}

