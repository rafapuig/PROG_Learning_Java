/**
 * En un videojuego, los jugadores lanzan un dado. El jugador que consigue la tirada más alta suma un punto.
 * Después de 10 tiradas, el jugador con más puntos es el ganador.
 * <p>
 * En esta versión desacoplamos,
 * la impresión del ganador de la ronda
 * de la actualización de marcadores
 *
 */


int random(int minInclusive, int maxInclusive) {
    return (int) (Math.random() * (maxInclusive + 1 - minInclusive)) + minInclusive;
}

int rollDice() {
    return random(1, 6);
}

int rollPlayerDice(String player) {
    IO.println("Turno de " + player);
    IO.readln("Pulsa INTRO para lanzar el dado");
    var dice = rollDice();
    IO.println("Has sacado un " + dice);
    return dice;
}

void printPlayerPoints(String player, int points) {
    IO.println(player + " tiene " + points + " puntos");
}


int findMaxWithoutRepetitionBy(final int[] values) {

    int max = Integer.MIN_VALUE;
    int posicion = -1;

    for (int i = 0; i < values.length; i++) {

        if (values[i] <= max) continue; // Si no es mayor que el máximo continuamos con el siguiente

        int contador = 0; // Vamos a contar cuantas veces aparece ese valor máximo
        for (int j = 0; j < values.length; j++) {
            if (values[j] == values[i]) contador++;
        }

        // Si solamente aparece una vez
        if (contador == 1) {
            max = values[i]; // Lo consideramos como nuevo máximo único
            posicion = i; // y asignamos la posicion donde lo hemos encontrado
        }

    }
    return posicion;
}


int findMaxWithRepetitionBy(final int[] values) {
    int position = -1;
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < values.length; i++) {
        if (values[i] > max) {
            max = values[i];
            position = i;
        }
    }
    return position;
}

int findMaxBy(final int[] values, boolean withoutRepetition) {
    return withoutRepetition ?
            findMaxWithoutRepetitionBy(values) :
            findMaxWithRepetitionBy(values);
}

int findMaxByUnique(final int[] values) {
    return findMaxBy(values, true);
}


int findWinnerBy(final int[] scores) {
    return findMaxByUnique(scores);
}


void main() {

    final int NUM_PLAYERS = 2;

    String[] players = new String[NUM_PLAYERS];

    // Inicializar los jugadores pidiendo el nombre de cada jugador
    for (int i = 0; i < NUM_PLAYERS; i++) {
        players[i] = IO.readln("Player " + (i + 1) + ": ");
    }

    int[] playersPoints = new int[NUM_PLAYERS];

    final int NUM_RONDAS = 10;

    int[] playersDice = new int[NUM_PLAYERS];

    for (int ronda = 1; ronda <= NUM_RONDAS; ronda++) {

        IO.println("Ronda " + ronda);

        // Lanzar los dados cada jugador en la ronda actual
        for (int i = 0; i < NUM_PLAYERS; i++) {
            playersDice[i] = rollPlayerDice(players[i]);
        }

        // Determinar el ganador de la ronda
        int roundWinner = findWinnerBy(playersDice);

        // Imprimir el ganador de la ronda (solo esta tarea)
        if (roundWinner == -1) {
            IO.println("La ronda acaba en empate");
        } else {
            IO.println("Gana la ronda " + players[roundWinner]);
        }

        // y actualizar los marcadores (tarea desacoplada!!!)
        if (roundWinner != -1) {
            playersPoints[roundWinner]++;
        }


        // Imprimir los marcadores de puntos de los jugadores
        IO.println();
        for (int i = 0; i < NUM_PLAYERS; i++) {
            printPlayerPoints(players[i], playersPoints[i]);
        }
        IO.println();
    }

    // Determinar el ganador final del juego
    int winner = findWinnerBy(playersPoints);

    // Imprimir el ganador
    if (winner == -1) {
        IO.println("Empate a puntos");
    } else {
        IO.println("Ganador: " + players[winner]);
    }

}