/**
 * El ahorcado
 * <p>
 * Usando la función charAt de los String
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
    final String word = IO.readln("Dime la palabra secreta a adivinar: ");

    // Inicializar la palabra enmascarada
    String maskedWord = "";
    for (int i = 0; i < word.length(); i++) {
        maskedWord += SUBSTITUTION_CHAR;
    }

    // Imprimir la palabra enmascarada
    for (int i = 0; i < maskedWord.length(); i++) {
        if (i > 0) IO.print(" ");
        IO.print(maskedWord.charAt(i));
    }
    IO.println();

    do {
        // Pedir una letra al jugador
        String input = IO.readln("Dime una letra: ");
        char letter = input.charAt(0);

        // Comprobar si la letra ya ha sido usada
        boolean hasBeenUsedLetter = false;
        for (int i = 0; i < usedLetters.length(); i++) {
            if (letter == usedLetters.charAt(i)) {
                hasBeenUsedLetter = true;
                break;
            }
        }

        // Si la letra ya ha sido usada
        if (hasBeenUsedLetter) {
            // Imprimir que ya ha sido usada anteriormente y que el jugador pierde una vida
            IO.println("La letra '" + letter + "' ya ha sido usada!");

            // Restar una vida al jugador
            lives--;

            // Imprimir que el jugador ha pedido una vida
            IO.println("Pierdes una vida!");

            // Sí se han acabado las vidas del jugador terminar el juego
            if (lives == 0) continue;

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
                IO.println("No se ha encontrado la letra '" + letter + "' en la palabra secreta");

                // Comprobar si está en la lista de letras que no están en la palabra secreta
                boolean hasBeenAdded = false;
                for (int i = 0; i < notInSecretWordLetters.length(); i++) {
                    if (notInSecretWordLetters.charAt(i) != letter) continue;
                    hasBeenAdded = true;
                    break;
                }

                // Añadir la letra a la lista de letras no encontradas en la palabra secreta
                if (!hasBeenAdded) notInSecretWordLetters += letter;

                // quitar una vida al jugador
                lives--;

                // Imprimir que el jugador ha pedido una vida
                IO.println("Pierdes una vida!");

                // Sí se han acabado las vidas del jugador terminar el juego
                if (lives == 0) continue;

            } else { // Sí se ha encontrado la letra al menos una vez

                //Imprimir cuantas veces se ha encontrado la letra
                IO.println("Se ha" + (matchCount > 1 ? "n" : "") + " encontrado " + matchCount + " " + letter + (matchCount > 1 ? "'s" : ""));

                // Actualizar la palabra enmascarada
                for (int i = 0; i < word.length(); i++) {
                    // Si la letra i-ésima de la palabra
                    // no es la letra que dijo el jugador,
                    // seguir y probar con la siguiente i
                    if (word.charAt(i) != letter) continue;

                    // Descubrir la letra en la maskedWord
                    // Sustituir la letra de la palabra enmascarada en la posición i (_)
                    // por la letra que dijo el jugador
                    String newMaskedWord = "";
                    for (int j = 0; j < maskedWord.length(); j++) {
                        if (j != i) newMaskedWord += maskedWord.charAt(j);
                        else newMaskedWord += letter;
                    }
                    maskedWord = newMaskedWord;
                }

                // Comprobar si ha adivinado la palabra completa y actualizar
                isSecretWordGuessed = true;
                for (int i = 0; i < maskedWord.length(); i++) {
                    // Si no es el carácter de sustitución, seguimos con el siguiente
                    if (maskedWord.charAt(i) != SUBSTITUTION_CHAR) continue;
                    // Se ha encontrado el caracter de sustitución, luego la palabra no esta del todo descubierta aún.
                    isSecretWordGuessed = false;
                    break;
                }

            }

        }

        // Imprimir la palabra enmascarada
        for (int i = 0; i < maskedWord.length(); i++) {
            if (i != 0) IO.print(" ");
            IO.print(maskedWord.charAt(i));
        }
        IO.println();

        // Si la palabra ha sido adivinada, terminar
        if (isSecretWordGuessed) break; // termina el juego directamente

        // Imprimir letras que no están en la palabra secreta
        IO.print("Letras que no están: ");
        for (int i = 0; i < notInSecretWordLetters.length(); i++) {
            if (i != 0) IO.print(", ");
            IO.print(notInSecretWordLetters.charAt(i));
        }
        IO.println();

        // Imprimir vidas restantes
        IO.println("Te quedan " + lives + " vidas");


    } while (lives > 0); // mientras el juego no tenga que finalizar

    // Fin del juego

    // Si el jugador ha descubierto la palabra imprimir mensaje de ganador
    if (isSecretWordGuessed) {
        // Imprimir que el jugador ha adivinado la palabra secreta
        IO.println("Has descubierto la palabra secreta!!!");
    }

    // Imprimir que has perdido si se te acabaron las vidas
    if (lives == 0) IO.println("Se te acabaron las vidas");
}
