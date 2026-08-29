/**
 * En un videojuego, los jugadores lanzan un dado. El jugador que consigue la tirada más alta suma un punto.
 * Después de 10 tiradas, el jugador con más puntos es el ganador.
 *
 * En la transición 2:
 *
 * - Escribimos la función findWinnerBy
 *
 *      Esta función la usamos para determinar quien ha ganado una ronda y quien ha ganado al final del juego.
 *
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
    players[0] = IO.readln("Player 1: ");
    players[1] = IO.readln("Player 2: ");

    int[] playersPoints = new int[NUM_PLAYERS];

    final int NUM_RONDAS = 10;

    int[] playersDice = new int[NUM_PLAYERS];

    for (int round = 1; round <= NUM_RONDAS; round++) {

        IO.println("Ronda " + round);

        // Lanzar los dados cada jugador en la ronda actual
        playersDice[0] = rollPlayerDice(players[0]);
        playersDice[1] = rollPlayerDice(players[1]);

        // Determinar que jugador ha ganado la ronda (ha obtenido la tirada más alta)
        // imprimir el ganador de la ronda y actualizar el marcador de puntos
        int roundWinner = findWinnerBy(playersDice);
        if (roundWinner == -1) {
            IO.println("La ronda acaba en empate");
        } else {
            IO.println("Gana la ronda " + players[roundWinner]);
            playersPoints[roundWinner]++;
        }

        // Imprimir los marcadores de puntos de los jugadores
        IO.println();
        printPlayerPoints(players[0], playersPoints[0]);
        printPlayerPoints(players[1], playersPoints[1]);
        IO.println();
    }

    // Determinar el ganador final e imprimir el resultado final del juego
    int finalWinner = findWinnerBy(playersPoints);
    if (finalWinner == -1) {
        IO.println("Empate a puntos");
    } else {
        IO.println("Ganador: " + players[finalWinner]);
    }

}