/**
 * En un videojuego, los jugadores lanzan un dado. El jugador que consigue la tirada más alta suma un punto.
 * Después de 10 tiradas, el jugador con más puntos es el ganador.
 *
 * Determinamos el ganador de cada ronda y el ganador final
 * con la función findWinnerBy
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


int findWinnerBy(final int[] scores) {
    int winner = -1; // No hay ganador -1
    if (scores[0] > scores[1]) {
        winner = 0;
    } else if (scores[0] < scores[1]) {
        winner = 1;
    }
    return winner;
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

        // Imprimir el ganador de la ronda y actualizar los marcadores (2 tareas acopladas)
        if (roundWinner == -1) {
            IO.println("La ronda acaba en empate");
        } else {
            IO.println("Gana la ronda " + players[roundWinner]);
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