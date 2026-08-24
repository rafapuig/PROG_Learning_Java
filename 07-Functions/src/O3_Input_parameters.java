/**
 * Parámetros de entrada
 * -------------------------------------------------------------------------------------------------------------
 *
 * Una función puede declarar una lista de parámetros de entrada.
 * La lista puede ser de 0, 1, 2, ... n parámetros.
 * Cada parámetro va separado de los demás en la lista mediante una ,
 *
 * Por cada parámetro de la lista hay que indicar su tipo de datos y su nombre identificador.
 *
 * Un parámetro de entrada es una variable local al ámbito de la función
 * que inicializará el llamador mediante un valor que se denomina ARGUMENTO de llamada.
 * Si lo declaramos como final, no se podrá modificar dentro de la función.
 *
 * Argumento
 * -------------------------------------------------------------------------------------------------------------
 * El argumento de llamada es una EXPRESIÓN
 * El valor del argumento de llamada con el que se inicializa el parámetro correspondiente
 * se obtiene del resultado de evaluar la expresión argumento
 *
 * El llamador de la función tiene que proporcionar un argumento por cada parámetro de entrada al invocar a la función.
 *
 * Este mecanismo se denomina paso por valor (de argumentos a los parametros de entrada)
 * Basicamente, si la expresión argumento de una llamada es una variable,
 * se pasa al parametro una COPIA del valor almancenado en ese momento en la variable.
 * Por tanto, podemos modificar el valor del parámetro, pero esto,
 * NUNCA supondrá un cambio en el valor de la variable utilizada como argumento de llamada.
 */

/**
 * Función greet (saludar)
 * Tiene un parámetro de entrada:
 * - su nombre es name y es de tipo String
 */
void greet(String name) {
    IO.println("Hola, " + name + "!");
}

void greet(String name, String greeting) {
    IO.println(greeting + ", " + name + "!");
}

void countToN(int n) {
    for (int i = 1; i <= n; i++) {
        IO.println(i);
    }
}

void printToConsole(String message) {
    message = "--> " + message;
    IO.println(message);
}

/**
 * Si el parámetro lo declaramos como final, entonces no se puede reasignar (mutar)
 * y tendrá el valor inicial con que el llamador lo inicializó mediante el argumento de llamada
 */
void printToConsoleFinal(final String message) {
    //message = "--> " + message; // ERROR, no se puede modificar el parámetro porque es final
    var processedMessage = "--> " + message;
    IO.println(processedMessage);
}

/**
 * El parámetro name recibe una copia del valor del argumento para inicializar el parámetro
 */
void greetWithChangeName(String name) {
    name = name.toUpperCase(); // Cambiar el valor del parametro no afecta fuera de la función
    IO.println("Hola, " + name + "!");
}

/**
 * El parámetro de entrada se inicializa con un VALOR resultado de evaluar la expresión
 */
void testNonChangingArgumentValue() {
    String name = "Pedro Gado";
    greetWithChangeName(name);
    // El contenido de la variable name no se modifica en ningún momento!!!
    IO.println("El nombre es " + name + "!");
}





void main() {
    /* Llamada a la función greet con el argumento "Perico Palotes" como valor de inicialización
     del parametro de entrada name */
    greet("Perico Palotes");
    /* Llamada a la función greet con el argumento aitor
     El resultado de evaluar la expresión (en este caso obtener el valor de la variable aitor => "Aitor Tilla")
     será el valor con que se inicializa el parametro de entrada name */
    var aitor = "Aitor Tilla";
    greet("");

    var martaName = "Marta";
    var martaSurname = "Baco";
    greet(martaName + " " + martaSurname);

    greet("Amador Denador", "Buenos días");
    greet("Sandra Mática", "Buenas tardes");

    printToConsole("Esto es un mensaje de prueba");
    printToConsoleFinal("Esto es un mensaje de prueba 2");

    testNonChangingArgumentValue();
}

