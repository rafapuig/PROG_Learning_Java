/**
 * En un videojuego, los jugadores lanzan un dado. El jugador que consigue la tirada más alta suma un punto.
 * Después de 10 tiradas, el jugador con más puntos es el ganador.
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


int findWinner(final int[] scores) {
    int winner = -1; // No hay ganador -1
    if (scores[0] > scores[1]) {
        winner = 0;
    } else if (scores[0] < scores[1]) {
        winner = 1;
    }
    return winner;
}

void printFinalWinner() {
    int finalWinner = findWinner(playersPoints);
    if (finalWinner == -1) {
        IO.println("Empate a puntos");
    } else {
        IO.println("Ganador: " + players[finalWinner]);
    }
}

void printRoundWinner(int roundWinner) {
    //int roundWinner = findWinner(playersDice);
    if (roundWinner == -1) {
        IO.println("La ronda acaba en empate");
    } else {
        IO.println("Gana la ronda " + players[roundWinner]);
        //playersPoints[roundWinner]++;
    }
}

final int NUM_PLAYERS = 2;
String[] players = new String[NUM_PLAYERS];
int[] playersPoints = new int[NUM_PLAYERS];
int[] playersDice = new int[NUM_PLAYERS];

void main() {

    players[0] = IO.readln("Player 1: ");
    players[1] = IO.readln("Player 2: ");

    final int NUM_RONDAS = 10;

    for (int round = 1; round <= NUM_RONDAS; round++) {

        IO.println("Ronda " + round);

        playersDice[0] = rollPlayerDice(players[0]);
        playersDice[1] = rollPlayerDice(players[1]);

        int roundWinner = findWinner(playersDice);
        printRoundWinner(roundWinner);
        if (roundWinner != -1) playersPoints[roundWinner]++;

        IO.println();
        printPlayerPoints(players[0], playersPoints[0]);
        printPlayerPoints(players[1], playersPoints[1]);
        IO.println();
    }

    printFinalWinner();
}