/**
 * En un videojuego, los jugadores lanzan un dado. El jugador que consigue la tirada más alta suma un punto.
 * Después de 10 tiradas, el jugador con más puntos es el ganador.
 * <p>
 * 1) Escribe una función con nombre random que acepte dos números, que serán el valor más alto y el más bajo que puede
 * generarse de manera aleatoria (los límites inclusivos del intervalo)
 * <p>
 * 2) Escribe una función con nombre rollDice que devuelve un número aleatorio entre 1 y 6.
 */

int random(int minInclusive, int maxInclusive) {
    return (int) (Math.random() * (maxInclusive + 1 - minInclusive)) + minInclusive;
}

/**
 * 6 es el número cantidad posible de resultados diferentes
 * 1 es el primer valor y más bajo posible
 */
int rollDiceX() {
    return (int) (Math.random() * 6) + 1;
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

    // Inicializar los jugadores pidiendo el nombre de cada jugador
    String player1 = IO.readln("Player 1: ");
    String player2 = IO.readln("Player 2: ");

    int player1Points = 0;
    int player2Points = 0;

    final int NUM_RONDAS = 10;

    for (int round = 1; round <= NUM_RONDAS; round++) {

        IO.println("Ronda " + round);

        // Lanzar los dados cada jugador en la ronda actual
        var player1Dice = rollPlayerDice(player1);
        var player2Dice = rollPlayerDice(player2);

        // Determinar que jugador ha ganado la ronda (ha obtenido la tirada más alta)
        // imprimir el ganador de la ronda y actualizar el marcador de puntos
        if (player1Dice > player2Dice) {
            IO.println("Gana la ronda " + player1);
            player1Points++;
        } else if (player1Dice < player2Dice) {
            IO.println("Gana la ronda " + player2);
            player2Points++;
        } else {
            IO.println("La ronda acaba en empate");
        }

        // Imprimir los marcadores de puntos de los jugadores
        IO.println();
        printPlayerPoints(player1, player1Points);
        printPlayerPoints(player2, player2Points);
        IO.println();
    }

    // Determinar el ganador final e imprimir el resultado final del juego
    if (player1Points > player2Points) {
        IO.println("Ganador: " + player1);
    } else if (player1Points < player2Points) {
        IO.println("Ganador: " + player2);
    } else {
        IO.println("Empate a puntos");
    }
}