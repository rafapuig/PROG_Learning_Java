import static exercises.helpers.Helpers.*;

/**
 * En un videojuego, los jugadores lanzan un dado. El jugador que consigue la tirada más alta suma un punto.
 * Después de 10 tiradas, el jugador con más puntos es el ganador.
 *
 * Realizar una refactorización a un diseño top-down
 *
 * Desde mayor grado de abstracción de detalle (tareas de alto nivel de abstracción) top
 * hasta mayor detalle (tareas de bajo nivel de abstracción) down
 *
 * Prácticamente se corresponde con crear un método por cada comentario que explicaba qué hacían un grupo de instrucciones
 * (auto-documentación del código como consecuencia del top-down)
 *
 */

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
    return findMaxBy(scores, true);
}


/**
 * Variables "globales"
 * Mantienen el estado general / global del programa
 */
final int NUM_PLAYERS = 2;

final String[] players = new String[NUM_PLAYERS];
final int[] playersPoints = new int[NUM_PLAYERS];
final int[] playersDice = new int[NUM_PLAYERS];


void main() {

    // Inicializar los jugadores pidiendo el nombre de cada jugador
    initPlayers();

    final int NUM_RONDAS = 10;

    for (int round = 1; round <= NUM_RONDAS; round++) {

        // Lanzar los dados cada jugador en la ronda actual
        playRound(round);

        // Determinar el ganador de la ronda
        int roundWinner = determineRoundWinner();

        // Imprimir el ganador de la ronda (solo esta tarea, para ello desacoplamos antes!!!)
        printRoundWinner(roundWinner);

        // Actualizar los marcadores (tarea desacoplada!!!)
        updateScores(roundWinner);

        // Imprimir los marcadores de puntos de los jugadores
        printPlayersScore();
    }

    // Imprimir el ganador final
    printFinalWinner();
}


// Todas estas funciones dependen de las variables globales (están acopladas)

/**
 * initPlayers modifica el estado global del programa,
 * modifica el array global: players
 */
void initPlayers() {
    for (int i = 0; i < NUM_PLAYERS; i++) {
        players[i] = IO.readln("Player " + (i + 1) + ": ");
    }
}


/**
 * playRound modifica el estado global del programa,
 * modifica el array global: playersDice
 */
void playRound(int round) {
    IO.println("Ronda " + round);
    for (int i = 0; i < NUM_PLAYERS; i++) {
        playersDice[i] = rollPlayerDice(players[i]);
    }
}


int determineRoundWinner() {
    return findWinnerBy(playersDice);
}


void printRoundWinner(int roundWinner) {
    if (roundWinner == -1) {
        IO.println("La ronda acaba en empate");
    } else {
        IO.println("Gana la ronda " + players[roundWinner]);
    }
}


/**
 * UpdateScores modifica el estado global del programa,
 * modifica el array global: playerPoints
 */
void updateScores(int roundWinner) {
    if (roundWinner != -1) playersPoints[roundWinner]++;
}


void printPlayersScore() {
    IO.println();
    for (int i = 0; i < NUM_PLAYERS; i++) {
        printPlayerPoints(players[i], playersPoints[i]);
    }
    IO.println();
}


int determineFinalWinner() {
    return findWinnerBy(playersPoints);
}


void printFinalWinner() {
    int winner = determineFinalWinner();

    if (winner == -1) {
        IO.println("Empate a puntos");
    } else {
        IO.println("Ganador: " + players[winner]);
    }
}



