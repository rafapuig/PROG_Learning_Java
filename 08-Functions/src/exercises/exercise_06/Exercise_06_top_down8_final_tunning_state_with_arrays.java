import static exercises.exercise_06.helpers.CharArrayHelpers.*;

/**
 * El ahorcado
 * <p>
 * Usando la función charAt de los String
 * <p>
 * Diseño top-down
 */

final int INITIAL_LIVES = 5;
final char MASKED_LETTER = '_';
final char SUBSTITUTION_CHAR = '_';
char[] secretWord;
char[] maskedWord;
char[] notInSecretWordLetters;
char[] usedLetters;
int lives;
boolean isSecretWordGuessed;

void main() {

    // Inicializar el juego a su estado inicial
    initGame();

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

            // El jugador pierde una vida
            lostLife();

            // Sí se han acabado las vidas del jugador terminar el juego
            if (!hasLives()) continue;

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

                // Actualizar letras no encontradas en la palabra secreta
                updateNotInSecretWordLetters(letter);

                // El jugador pierde una vida
                lostLife();

                // Sí se han acabado las vidas del jugador terminar el juego
                if (!hasLives()) continue;

            } else { // Sí se ha encontrado la letra al menos una vez

                //Imprimir cuantas veces se ha encontrado la letra
                printTimesLetterFound(matchCount, letter);

                // Actualizar la palabra enmascarada
                updateMaskedWord(letter);

                // Comprobar que se ha adivinado la palabra completa y actualizar
                isSecretWordGuessed = checkSecretWordGuessed();
            }
        }

        // Imprimir la palabra enmascarada
        printMaskedWord();

        // Si la palabra ha sido adivinada, terminar
        if (isSecretWordGuessed) continue; // termina el juego directamente

        // Imprimir letras que no están en la palabra secreta
        printNotInSecretWordLetters();

        // Imprimir vidas restantes
        printRemainingLives();

    } while (!hasToEndGame()); // mientras el juego no tenga que finalizar

    // Fin del juego
    endGame(isSecretWordGuessed);
}

private boolean hasToEndGame() {
    return isSecretWordGuessed || lives == 0;
}

private void endGame(boolean isSecretWordGuessed) {
    // Si el jugador ha descubierto la palabra imprimir mensaje de ganador
    if (isSecretWordGuessed) {
        // Imprimir que el jugador ha adivinado la palabra secreta
        printSecretWordGuessed();
        return;
    }

    // Imprimir que has perdido si se te acabaron las vidas
    if (!hasLives()) printNoLivesLeft();
}


private void updateMaskedWord(char letter) {
    maskedWord = uncoverMaskedLetter(letter);
}

private void updateNotInSecretWordLetters(char letter) {
    // Comprobar si está en la lista de letras que no están en la palabra secreta
    boolean hasBeenAdded = checkHasBeenAdded(letter);

    // Añadir la letra a la lista de letras no encontradas en la palabra secreta
    if (!hasBeenAdded) addToNotInSecretWordLetters(letter);
}


private void initGame() {
    // Iniciar numero de vidas
    initializeLives();

    // Inicializar letras no encontradas
    initializeNotInSecretWordLetters();

    // Inicializar letras usadas
    initializeUsedLetters();

    // Pedir palabra secreta al administrador
    secretWord = askSecretWord();

    // Inicializar la palabra enmascarada
    maskedWord = createInitialMaskedWord();

    // Inicializar si la palabra secreta ha sido adivinada
    isSecretWordGuessed = false;
}

private void initializeLives() {
    lives = INITIAL_LIVES;
}

private void initializeNotInSecretWordLetters() {
    notInSecretWordLetters = new char[0];
}

private void initializeUsedLetters() {
    usedLetters = new char[0];
}


private void lostLife() {
    // Restar una vida al jugador
    loseALife();

    // Imprimir que el jugador ha pedido una vida
    printLostLife();
}

private void loseALife() {
    lives--;
}

private boolean hasLives() {
    return lives > 0;
}




/* Métodos todavía desacoplados (no dependen del estado) */

char[] askSecretWord() {
    return IO.readln("Dime la palabra secreta a adivinar: ").toCharArray();
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


char[] createInitialMaskedWord() {
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


char[] uncoverMaskedLetter(char letter) {
    return unmaskCharacter(maskedWord, secretWord, letter);
}


boolean checkSecretWordGuessed() {
    return !contains(maskedWord, MASKED_LETTER);
}


void addToUsedLetters(char letter) {
    usedLetters = append(usedLetters, letter);
}


void addToNotInSecretWordLetters(char letter) {
    notInSecretWordLetters = append(notInSecretWordLetters, letter);
}

