/**
 * El ahorcado
 * <p>
 * Usando la función charAt de los String
 */

void main() {

    // Iniciar numero de vidas
    int lives = 5;

    // Pedir palabra secreta al administrador
    final String word = IO.readln("Dime la palabra secreta a adivinar: ");

    // Inicializar la palabra de juego
    String playWord = "";
    for (int i = 0; i < word.length(); i++) {
        playWord += "_";
    }

    // Imprimir la palabra de juego
    for (int i = 0; i < playWord.length(); i++) {
        if (i > 0) IO.print(" ");
        IO.print(playWord.charAt(i));
    }
    IO.println();

    // Inicializar letras no encontradas
    String notFoundLetters = "";

    do {
        // Pedir una letra
        String input = IO.readln("Dime una letra: ");
        char letter = input.charAt(0);

        // Buscar la letra en la palabra
        // contar cuantas coincidencias
        // actualizar playWord
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                count++;

                // Actualizar la playWord
                String newPlayWord = "";
                for (int j = 0; j < playWord.length(); j++) {
                    if (j != i) newPlayWord += playWord.charAt(j);
                    else newPlayWord += letter;
                }
                playWord = newPlayWord;
            }
        }

        // Si la cuenta es 0, añadir la letra a las no encontradas (si no está añadida) y restar una vida
        if (count == 0) {
            // Comprobar si ya se ha dicho antes
            boolean found = false;
            for (int i = 0; i < notFoundLetters.length(); i++) {
                if (notFoundLetters.charAt(i) != letter) continue;
                found = true;
                break;
            }
            // Añadir la letra a las no encontradas
            if (!found) notFoundLetters += letter;

            // quitar una vida
            lives--;
        }

        // Imprimir la palabra de juego
        for (int i = 0; i < playWord.length(); i++) {
            if (i != 0) IO.print(" ");
            IO.print(playWord.charAt(i));
        }
        IO.println();

        // Comprobar que se ha adivinado la palabra completa
        if (word.equals(playWord)) {
            IO.println("Has descubierto la palabra secreta!!!");
            break;
        }

        // Imprimir letras que no están en la palabra
        IO.print("Letras que no están: ");
        for (int i = 0; i < notFoundLetters.length(); i++) {
            if (i != 0) IO.print(", ");
            IO.print(notFoundLetters.charAt(i));
        }
        IO.println();

        // Imprimir vidas restantes
        IO.println("Te quedan " + lives + " vidas");

    } while (lives > 0);

    // Imprimir que has perdido si se te acabaron las vidas
    if (lives == 0) IO.println("Se te acabaron las vidas");

}
