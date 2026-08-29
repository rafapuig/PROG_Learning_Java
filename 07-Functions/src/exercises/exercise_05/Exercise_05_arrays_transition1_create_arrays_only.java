/**
 * En un videojuego, los jugadores lanzan un dado. El jugador que consigue la tirada más alta suma un punto.
 * Después de 10 tiradas, el jugador con más puntos es el ganador.
 *
 * En este código vamos a hacer una transición desde la versión sin arrays,
 *
 * a una versión que en lugar de crear una variable para cada jugador, su dado y  sus puntos.
 *
 * Crea un array de jugadores, uno de dados y otro de puntos.
 *
 * Pero todavía no saca partido de la indexación de los array que permite iterarlos.
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


void main() {

    final int NUM_PLAYERS = 2;

    String[] players = new String[NUM_PLAYERS]; // String player1, player2;

    // Inicializar los jugadores pidiendo el nombre de cada jugador
    players[0] = IO.readln("Player 1: "); // player1 = IO.readln("Player 1: ");
    players[1] = IO.readln("Player 2: "); // player2 = IO.readln("Player 2: ");

    int[] playersPoints = new int[NUM_PLAYERS]; //int player1Points = 0; int player2Points = 0;

    final int NUM_RONDAS = 10;

    int[] playersDice = new int[NUM_PLAYERS]; // int player1Dice, player2Dice;

    for (int round = 1; round <= NUM_RONDAS; round++) {

        IO.println("Ronda " + round);

        // Lanzar los dados cada jugador en la ronda actual
        playersDice[0] = rollPlayerDice(players[0]); // player1Dice = rollPlayerDice(player1);
        playersDice[1] = rollPlayerDice(players[1]); // player2Dice = rollPlayerDice(player2);

        // Determinar que jugador ha ganado la ronda (ha obtenido la tirada más alta)
        // imprimir el ganador de la ronda y actualizar el marcador de puntos
        if (playersDice[0] > playersDice[1]) { // player1Dice > player2Dice
            IO.println("Gana la ronda " + players[0]); // player1
            playersPoints[0]++; // player1Points++;
        } else if (playersDice[0] < playersDice[1]) { // player1Dice < player2Dice
            IO.println("Gana la ronda " + players[1]); // player2
            playersPoints[1]++; // player2Points++;
        } else {
            IO.println("La ronda acaba en empate");
        }

        // Imprimir los marcadores de puntos de los jugadores
        IO.println();
        printPlayerPoints(players[0], playersPoints[0]); // printPlayerPoints(player1, player1Points);
        printPlayerPoints(players[1], playersPoints[1]); // printPlayerPoints(player2, player2Points);
        IO.println();
    }

    // Determinar el ganador final e imprimir el resultado final del juego
    if (playersPoints[0] > playersPoints[1]) { // player1Points > player2Points
        IO.println("Ganador: " + players[0]); // player1
    } else if (playersPoints[0] < playersPoints[1]) { // player1Points < player2Points
        IO.println("Ganador: " + players[1]); // player2
    } else {
        IO.println("Empate a puntos");
    }
}