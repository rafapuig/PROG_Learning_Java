/**
 * El ahorcado
 * <p>
 * Usando la función charAt de los String
 * <p>
 * Diseño top-down
 */

void printCharacters(String word, String separator) {
    String result = "";
    for (int i = 0; i < word.length(); i++) {
        if (i != 0) result += separator;
        result += word.charAt(i);
    }
    IO.print(result);
}

int matchesInWord(String word, char letter) {
    int count = 0;
    for (int i = 0; i < word.length(); i++) {
        if (word.charAt(i) == letter) count++;
    }
    return count;
}


String askSecretWord() {
    return IO.readln("Dime la palabra secreta a adivinar: ");
}


String createInitialMaskedWord(String word) {
    char[] maskedWordChars = new char[word.length()];
    for (int i = 0; i < maskedWordChars.length; i++) {
        maskedWordChars[i] = '_';
    }
    return new String(maskedWordChars);
}


char askLetter() {
    String input = IO.readln("Dime una letra: ");
    return input.charAt(0);
}


String uncoverLetter(String maskedWord, char letter, int position) {
    var maskedWordChars = maskedWord.toCharArray();

    maskedWordChars[position] = letter;

    return new String(maskedWordChars);
}

String uncoverLetters(String word, String maskedWord, char letter) {
    var maskedWordChars = maskedWord.toCharArray();

    for (int i = 0; i < maskedWord.length(); i++) {
        if (word.charAt(i) == letter) maskedWordChars[i] = letter;
    }
    return new String(maskedWordChars);
}


boolean checkHasBeenAdded(String letters, char letter) {
    boolean found = false;
    for (int i = 0; i < letters.length(); i++) {
        if (letters.charAt(i) != letter) continue;
        found = true;
        break;
    }
    return found;
}


void printWinnerMessage() {
    IO.println("Has descubierto la palabra secreta!!!");
}

void printLooseMessage() {
    IO.println("Se te acabaron las vidas");
}


final int INITIAL_LIVES = 5;

int lives; // Vidas restantes del jugador
String secretWord; // palabra secreta a adivinar antes de que se acaben las vidas
String notInSecretWordLetters; // letras ya probadas que no se usan en la palabra secreta
String maskedWord; // palabra con las letras enmascaradas de la palabra secreta aún no descubiertas
boolean wordFullyGuessed = false;

void main() {

    // Inicializar el juego a su estado inicial
    initGame();

    // Imprimir la palabra enmascarada
    printMaskedWord();

    do {
        // Pedir una letra
        char letter = askLetter();

        // Contar cuantas coincidencias de la letra
        int matchCount = matchesInSecretWord(letter);

        // Si la cuenta de coincidencias es 0
        if (matchCount == 0) {
            // añadir la letra a las no encontradas (si no está añadida)
            updateNotInWordLetters(letter);

            // y restar una vida
            looseALife();
        } else { // Si no, actualizar la palabra enmascarada
            IO.println("Se han encontrado " + matchCount + " " + letter + "'s");
            updateMaskedWord(letter);
        }

        // Imprimir la palabra de juego
        printMaskedWord();

        // Comprobar que se ha adivinado la palabra completa
        wordFullyGuessed = isWordFullyGuessed();
        if (wordFullyGuessed) break;

        // Imprimir letras que no están en la palabra
        printNotInWordLetters();

        // Imprimir vidas restantes
        printRemainingLives();

    } while (!hasToEndGame()); // mientras el juego no tenga que finalizar

    endGame();
}


void initGame() {
    // Iniciar numero de vidas
    initializeLives();

    // Pedir palabra secreta al administrador
    initializeSecretWord();

    // Inicializar la palabra de juego
    initializePlayWord();

    // Inicializar letras no encontradas
    initializeNotInWordLetters();
}


void initializeLives() {
    lives = INITIAL_LIVES;
}


void initializeSecretWord() {
    secretWord = askSecretWord();
}


void initializePlayWord() {
    maskedWord = createInitialMaskedWord(secretWord);
}


void initializeNotInWordLetters() {
    notInSecretWordLetters = "";
}


void updateNotInWordLetters(char letter) {
    // Comprobar si ya se ha dicho antes
    boolean found = checkHasBeenAdded(notInSecretWordLetters, letter);
    // Añadir la letra a las no encontradas
    if (!found) notInSecretWordLetters += letter;
}

int matchesInSecretWord(char letter) {
    return matchesInWord(secretWord, letter);
}

void updateMaskedWord(char letter) {
    // Actualizar la maskedWord
    maskedWord = uncoverLetters(secretWord, maskedWord, letter);
}


void looseALife() {
    lives--;
}


boolean isWordFullyGuessed() {
    return secretWord.equals(maskedWord);
}


void printMaskedWord() {
    printCharacters(maskedWord, " ");
    IO.println();
}


void printRemainingLives() {
    IO.println("Te quedan " + lives + " vidas");
}


void printNotInWordLetters() {
    IO.print("Letras que no están: ");
    printCharacters(notInSecretWordLetters, ", ");
    IO.println();
}


void endGame() {
    // Si el jugador ha descubierto la palabra imprimir mensaje de ganador
    if (wordFullyGuessed) printWinnerMessage();

    // Imprimir que has perdido, si se te acabaron las vidas
    if (lives == 0) printLooseMessage();
}


boolean hasToEndGame() {
    return lives == 0 || wordFullyGuessed;
}