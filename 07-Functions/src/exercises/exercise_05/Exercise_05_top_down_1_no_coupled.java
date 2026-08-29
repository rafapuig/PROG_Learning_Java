/**
 * En un videojuego, los jugadores lanzan un dado. El jugador que consigue la tirada más alta suma un punto.
 * Después de 10 tiradas, el jugador con más puntos es el ganador.
 *
 * En esta versión realizamos un top down
 *
 * con métodos que solo utilizan datos recibidos mediante parámetros de entrada
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


void printRoundWinner(String player1, int player1Dice, String player2, int player2Dice) {
    if (player1Dice > player2Dice) {
        IO.println("Gana la ronda " + player1);
    } else if (player1Dice < player2Dice) {
        IO.println("Gana la ronda " + player2);
    } else {
        IO.println("La ronda acaba en empate");
    }
}


void printPlayersScore(String player1, int player1Points, String player2, int player2Points) {
    IO.println();
    printPlayerPoints(player1, player1Points);
    printPlayerPoints(player2, player2Points);
    IO.println();
}


void printFinalWinner(int player1Points, int player2Points, String player1, String player2) {
    if (player1Points > player2Points) {
        IO.println("Ganador: " + player1);
    } else if (player1Points < player2Points)  {
        IO.println("Ganador: " + player2);
    } else {
        IO.println("Empate a puntos");
    }
}


void main() {

    String player1 = IO.readln("Player 1: ");
    String player2 = IO.readln("Player 2: ");

    int player1Points = 0;
    int player2Points = 0;

    final int NUM_RONDAS = 10;

    for (int i = 1; i <= NUM_RONDAS; i++) {

        IO.println("Ronda " + i);

        var player1Dice = rollPlayerDice(player1);
        var player2Dice = rollPlayerDice(player2);

        printRoundWinner(player1, player1Dice, player2, player2Dice);

        if (player1Dice > player2Dice) {
            player1Points++;
        } else if (player1Dice < player2Dice) {
            player2Points++;
        }

        printPlayersScore(player1, player1Points, player2, player2Points);
    }

    printFinalWinner(player1Points, player2Points, player1, player2);
}