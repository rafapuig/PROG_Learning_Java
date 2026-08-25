/**
 * El ahorcado
 *
 * Usando la función charAt de los String
 *
 * Diseño top-down
 */

void main() {

    // Iniciar numero de vidas
    int lives = 5;

    // Pedir palabra secreta al administrador
    final String word = askSecretWord();

    // Inicializar la palabra de juego
    String playWord = createInitialPlayWord(word);

    // Imprimir la palabra de juego
    printPlayWord(playWord);


    // Inicializar letras no encontradas
    String notFoundLetters = "";

    do {
        // Pedir una letra
        char letter = askLetter();

        // Buscar la letra en la palabra
        // contar cuantas coincidencias
        // actualizar playWord
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                count++;

                // Actualizar la playWord
                playWord = uncoverLetter(playWord, letter, i);
            }
        }

        // Si la cuenta es 0, añadir la letra a las no encontradas (si no está añadida) y restar una vida
        if (count == 0) {
            // Comprobar si ya se ha dicho antes
            boolean found = checkHasBeenAdded(notFoundLetters, letter);
            // Añadir la letra a las no encontradas
            if (!found) notFoundLetters += letter;

            // quitar una vida
            lives--;
        }

        // Imprimir la palabra de juego
        printPlayWord(playWord);        

        // Comprobar que se ha adivinado la palabra completa
        if (checkWordFullyGuessed(word, playWord)) {
            IO.println("Has descubierto la palabra secreta!!!");
            break;
        }

        // Imprimir letras que no están en la palabra
        printNotInWordLetters(notFoundLetters);

        // Imprimir vidas restantes
        IO.println("Te quedan " + lives + " vidas");

    } while (lives > 0);

    // Imprimir que has perdido si se te acabaron las vidas
    if (lives == 0) IO.println("Se te acabaron las vidas");

}


String askSecretWord() {
    return IO.readln("Dime la palabra secreta a adivinar: ");
}


String createInitialPlayWord(String word) {
    String playWord = "";
    for (int i = 0; i < word.length(); i++) {
        playWord += "_";
    }
    return playWord;
}


char askLetter() {
    String input = IO.readln("Dime una letra: ");
    return input.charAt(0);
}


String uncoverLetter(String playWord, char letter, int position) {
    String newPlayWord = "";
    for (int i = 0; i < playWord.length(); i++) {
        if (i != position) newPlayWord += playWord.charAt(i);
        else newPlayWord += letter;
    }
    return newPlayWord;
}


boolean checkHasBeenAdded(String notFoundLetters, char letter) {
    boolean found = false;
    for (int i = 0; i < notFoundLetters.length(); i++) {
        if (notFoundLetters.charAt(i) != letter) continue;
        found = true;
        break;
    }
    return found;
}


boolean checkWordFullyGuessed(String word, String playWord) {
    return word.equals(playWord);
}


void printNotInWordLetters(String notFoundLetters) {
    IO.print("Letras que no están: ");
    for (int i = 0; i < notFoundLetters.length(); i++) {
        if (i != 0) IO.print(", ");
        IO.print(notFoundLetters.charAt(i));
    }
    IO.println();
}


void printPlayWord(String playWord) {
    for (int i = 0; i < playWord.length(); i++) {
        if (i > 0) IO.print(" ");
        IO.print(playWord.charAt(i));
    }
    IO.println();
}
