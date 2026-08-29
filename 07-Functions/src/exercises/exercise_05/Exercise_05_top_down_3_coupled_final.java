/**
 * En un videojuego, los jugadores lanzan un dado. El jugador que consigue la tirada más alta suma un punto.
 * Después de 10 tiradas, el jugador con más puntos es el ganador.
 *
 * En esta versión realizamos un top down
 *
 * con métodos que no solo utilizan datos recibidos mediante parámetros de entrada
 * también usan los de las variables "globales"
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


/**
 * Variables "globales"
 * Mantienen el estado general / global del programa
 */
String player1;
String player2;

int player1Points = 0;
int player2Points = 0;

int player1Dice;
int player2Dice;

void main() {

    // Inicializar los jugadores pidiendo el nombre de cada jugador
    initPlayers();

    final int NUM_RONDAS = 10;

    for (int round = 1; round <= NUM_RONDAS; round++) {

        // Lanzar los dados cada jugador en la ronda actual
        playRound(round);

        // Imprimir el ganador de la ronda
        printRoundWinner();

        // Actualizar los marcadores
        updateScores();

        // Imprimir los marcadores de puntos de los jugadores
        printPlayersScore();
    }

    // Imprimir el ganador final
    printFinalWinner();
}


/* Los métodos acoplados con las variables "globales" van después de la función main */

/**
 * Ahora ya puedo extraer un método que actualice los nombres de los players
 */
void initPlayers() {
    player1 = IO.readln("Player 1: ");
    player2 = IO.readln("Player 2: ");
}

/**
 * Ahora ya puedo extraer un método que actualice los dados de los jugadores
 */
void playRound(int round) {
    IO.println("Ronda " + round);
    player1Dice = rollPlayerDice(player1);
    player2Dice = rollPlayerDice(player2);
}

/**
 * Ahora ya puedo extraer un método que actualice los player points fuera de main
 */
void updateScores() {
    if (player1Dice > player2Dice) {
        player1Points++;
    } else if (player1Dice < player2Dice) {
        player2Points++;
    }
}


/* Los métodos siguientes no actualizan nigun valor,
pero leen el valor de las variables globales,
es decir, consultan el estado del programa */

void printRoundWinner() {
    if (player1Dice > player2Dice) {
        IO.println("Gana la ronda " + player1);
    } else if (player1Dice < player2Dice) {
        IO.println("Gana la ronda " + player2);
    } else {
        IO.println("La ronda acaba en empate");
    }
}


void printPlayersScore() {
    IO.println();
    printPlayerPoints(player1, player1Points);
    printPlayerPoints(player2, player2Points);
    IO.println();
}


void printFinalWinner() {
    if (player1Points > player2Points) {
        IO.println("Ganador: " + player1);
    } else if (player1Points < player2Points)  {
        IO.println("Ganador: " + player2);
    } else {
        IO.println("Empate a puntos");
    }
}