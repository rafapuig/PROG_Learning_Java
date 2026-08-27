/**
 * El ahorcado
 * <p>
 * Usando la función charAt de los String
 *
 * En esta versión
 * mantenemos una máscara que indica si el carácter ha sido desvelado (clear) o todavía no (masked)
 */

void main() {

    final char MASKED_CHAR = '#';
    final char CLEAR_CHAR = ' ';
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

    // Inicializar la máscara
    String mask = "";
    for (int i = 0; i < word.length(); i++) {
        mask += MASKED_CHAR;
    }

    // Imprimir la palabra enmascarada
    for (int i = 0; i < word.length(); i++) {
        if (i != 0) IO.print(" ");
        if (mask.charAt(i) == MASKED_CHAR) IO.print(SUBSTITUTION_CHAR);
        else IO.print(word.charAt(i));
        //IO.print(maskedWord.charAt(i));
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

                // Actualizar la máscara
                String newMask = "";
                for (int i = 0; i < word.length(); i++) {
                    // Descubrir la letra en la máscara
                    // Sustituir el '*' por el ' ' si la letra se encuentra en esa posición en la palabra
                    if (word.charAt(i) == letter) newMask += CLEAR_CHAR;
                    else newMask += mask.charAt(i);
                }
                mask = newMask;

                // Comprobar si ha adivinado la palabra completa y actualizar
                boolean maskCleared = true;
                for (int i = 0; i < mask.length(); i++) {
                    if (mask.charAt(i) == MASKED_CHAR) {
                        maskCleared = false;
                        break;
                    }
                }
                isSecretWordGuessed = maskCleared; //  false; //word.equals(maskedWord);
            }

        }

        // Imprimir la palabra enmascarada
        for (int i = 0; i < word.length(); i++) {
            if (i != 0) IO.print(" ");
            if (mask.charAt(i) == MASKED_CHAR) IO.print(SUBSTITUTION_CHAR);
            else IO.print(word.charAt(i));
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
