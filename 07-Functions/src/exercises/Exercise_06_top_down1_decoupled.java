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
            printLooseLife();

            // Sí se han acabado las vidas del jugador terminar el juego
            if(lives == 0) continue;

        } else {
            // Añadir la letra a la lista de letras usadas
            usedLetters += letter;

            // Buscar la letra en la palabra
            // contar cuantas coincidencias
            int matchCount = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == letter) matchCount++;
            }

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
                printLooseLife();

                // Sí se han acabado las vidas del jugador terminar el juego
                if(lives == 0) continue;

            } else { // Sí se ha encontrado la letra al menos una vez

                //Imprimir cuantas veces se ha encontrado la letra
                printTimesLetterFound(matchCount, letter);

                // Actualizar la palabra enmascarada
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) != letter) continue;
                    // Descubrir la letra en la maskedWord
                    maskedWord = uncoverLetter(maskedWord, letter, i);
                }
            }

            // Comprobar que se ha adivinado la palabra completa y actualizar
            isSecretWordGuessed = checkWordFullyGuessed(word, maskedWord);
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

void printLooseLife() {
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


String createInitialMaskedWord(String word, char substitutionChar) {
    String masked = "";
    for (int i = 0; i < word.length(); i++) {
        masked += substitutionChar;
    }
    return masked;
}

boolean checkHasBeenUsed(String usedLetters, char letter) {
    boolean found = false;
    for (int i = 0; i < usedLetters.length(); i++) {
        if (letter != usedLetters.charAt(i)) continue;
        found = true;
        break;
    }
    return found;
}

boolean checkHasBeenAdded(String notInWordLetters, char letter) {
    boolean found = false;
    for (int i = 0; i < notInWordLetters.length(); i++) {
        if (letter != notInWordLetters.charAt(i)) continue;
        found = true;
        break;
    }
    return found;
}

boolean checkWordFullyGuessed(String word, String maskedWord) {
    return word.equals(maskedWord);
}

boolean checkSecretWordGuessed(String maskedWord, char maskedLetter) {
    boolean isSecretWordGuessed = true;
    for (int i = 0; i < maskedWord.length(); i++) {
        // Si no es el carácter de sustitución, seguimos con el siguiente
        if (maskedWord.charAt(i) != maskedLetter) continue;
        // Se ha encontrado el caracter de sustitución, luego la palabra no esta del todo descubierta aún.
        isSecretWordGuessed = false;
        break;
    }
    return isSecretWordGuessed;
}

String uncoverLetter(String maskedWord, char letter, int position) {
    String newMasked = "";
    for (int i = 0; i < maskedWord.length(); i++) {
        if (i != position) newMasked += maskedWord.charAt(i);
        else newMasked += letter;
    }
    return newMasked;
}




void printNotInSecretWordLetters(String notInSecretWordLetters) {
    IO.print("Letras que no están: ");
    for (int i = 0; i < notInSecretWordLetters.length(); i++) {
        if (i != 0) IO.print(", ");
        IO.print(notInSecretWordLetters.charAt(i));
    }
    IO.println();
}


void printMaskedWord(String maskedWord) {
    for (int i = 0; i < maskedWord.length(); i++) {
        if (i > 0) IO.print(" ");
        IO.print(maskedWord.charAt(i));
    }
    IO.println();
}
