/**
 * FUNCIÓN
 * <p>
 * ¿Que es una función? (en Java se llama método)
 * -------------------------------------------------------------------------------------------
 * Es un bloque de código al que se le pone un nombre.
 * <p>
 * Es un elemento de programación
 * identificado mediante un nombre identificador,
 * que contiene un bloque de instrucciones,
 * y que se ejecutarán cuando la función sea invocada (llamada) mediante su nombre.
 * <p>
 * Cada vez que se invoca (llama) a la función se procede a ejecutar el bloque de instrucciones de código que la definen.
 * <p>
 * Esto permite que un bloque de código sea reutilizable como si fuera una pieza de construcción.
 * Se define una vez, y se reutiliza invocándolo una y otra vez allí donde queramos ejecutar sus instrucciones.
 * NOTA: Esto evita copiar y pegar las mismas instrucciones una y otra vez, y aplicar el principio DRY (don't repeat yourself)
 * <p>
 * Por tanto,
 * 1) Una función se declara y define una sola vez, escribiendo las instrucciones que queremos que ejecute.
 * 2) Se invoca tantas veces como queramos usarla.
 * <p>
 * Las instrucciones (salvo las de declaración) no pueden estar "sueltas" en el código fuente,
 * deben estar organizadas en contenedores.
 * Estos contenedores de instrucciones son las funciones.
 * <p>
 * <p>
 * ¿Quién llama a una función? Código llamador
 * ----------------------------------------------------------------------------------------------------------------
 * <p>
 * Una función A que contiene una instrucción de llamada a otra función B decimos que A es la llamadora de B.
 * <p>
 * Durante la llamada, el llamador cede el control de flujo de ejecución de instrucciones a la función llamada.
 * Es decir, queda a la espera de que la función invocada, ejecute todas sus instrucciones,
 * termine y retorne el control a su llamadora.
 * Cuando la función llamada termina, se retorna el control de la ejecución de instrucciones a la llamadora,
 * que continúa por la instruccion siguente a la que dio origen a la llamada.
 * <p>
 * El sistema de llamadas es transitivo, A puede llamar a B, que a su vez puede llamar a C, etc.
 * <p>
 * Para poder gestionar el control de flujo cuando se producen llamadas a función,
 * y de esta manera saber en cualquier momento cuál es la siguiente instrucción a ejecutar,
 * se utiliza un mecanismo, en tiempo de ejecución, que utiliza una estructura de datos denominada
 * pila de llamadas (Call Stack).
 * <p>
 * ¿Es posible que el código de una función A contenga una llamada a la propia función A, es decir a sí mismo?
 * Sí, en este caso la función se autoinvoca a sí misma y esto se conoce como RECURSIVIDAD.
 * <p>
 * Cuando se inicia un programa el S.O. llama automáticamente a la función main.
 * El resto de funciones del código NO son llamadas. Para que se ejecute su código debe haber una llamada
 * desde el codigo de la función main (o alguna función que haya sido llamada a su vez desde main)
 *
 *
 * Parámetros de entrada (parametrización de las funciones)
 * -------------------------------------------------------------------------------------------- *
 * A veces, necesitamos que el código (bloque de instrucciones) que ejecuta el cuerpo de la función
 * dependa de unos valores que le proporcionamos justo en el momento cuando la vamos a usar (invocar, llamar).
 * De esta manera, la función recibe unas entradas y realiza un proceso a partir de estas entradas,
 * en cada llamada el proceso es el mismo, porque se ejecutan las mismas instrucciones,
 * pero el efecto o el resultado pueden ser diferentes porque dependen del valor de las entradas proporcionadas.
 * <p>
 * Opcionalmente, una función:
 * - puede aceptar valores de entrada proporcionados por el llamador.
 * - y puede devolver un valor al llamador al retornar.
 * <p>
 * Para devolver un valor se utiliza la instrucción return <expresion>;
 * <p>
 * Para que una función, al ser llamada, pueda recibir valores de entrada,
 * debe declarar una lista de parámetros.
 * - cada parámetro se corresponde con una declaración de variable (sin inicialización)
 * <p>
 * En el proceso de llamada, el llamador proporciona un valor para cada parámetro declarado en la función.
 * El nombre que recibe el dato proporcionado por el llamador para iniciar el parámetro correspondiente
 * se denomina informalmente ARGUMENTO.
 * <p>
 */


/** Sintaxis de la declaración y definición de una función (simplificada)
 * -----------------------------------------------------------------------------------------------------------
 * <p>
 * tipo_valor_retornado nombre_función (lista_parámetros) {
 * // Cuerpo de la función (instrucciones a ejecutar cuando es llamada)
 * }
 * <p>
 * La lista de parámetros es una lista separada por comas cuyos elementos son
 * declaraciones de variable (sin inicialización).
 * <p>
 * Cuando una función nunca va a devolver nada a su llamador se utiliza el tipo de retorno void
 * <p>
 * Función void (procedimiento, en Java se denomina void function)
 *
 * Una función que no devuelve nada, solo es interesante llamarla por los efectos colaterales (secundarios),
 * que produce ejecutar las instrucciones contenidas en el cuerpo de la función.
 * <p>
 * A la función main la llama directamente el S.O. al iniciar la ejecución del programa. *
 */


/** Llamada a una función
 * ---------------------------------------------------------------------------------------------------------------
 * Para llamar a una función hay que usar una expresión de tipo llamada a función.
 * <p>
 * La expresión de llamada a función consiste sintácticamente en:
 * <p>
 * nombre_funcion ( lista_argumentos )
 * <p>
 * La lista de argumentos es una lista de 0, 1, 2... elementos separados por , (coma)
 * Cada elemento (argumento) es una expresión.
 * <p>
 * La posición del elemento en la lista de argumentos determina con qué parámetro de entrada se asocia.
 * Esto se denomina correspondencia por posición.
 * <p>
 * En cada llamada a la función hay que proporcionar un argumento por cada parametro de entrada declarado en la función.
 * (El primer argumento se asocia al primer parametro de entrada,
 * el segundo argumento con el segundo parametro de entrada y asi sucesivamente.)
 * <p>
 * Podemos llamar a la misma función tantas veces como queramos.
 * Si en cada llamada proporcionamos argumentos diferentes se ejecutará el mismo código pero con diferentes resultados.
 * <p>
 * El valor retornado se considera el resultado de la llamada a la función.
 * Es decir, como la llamada a una función es un tipo de expresión, el valor retornado es el resultado de evaluar
 * una expresión de tipo llamada a función.
 */


/**
 * Función greet (saludar)
 * No devuelve nada al llamador (tipo de retorno void) *
 * No recibe ningún argumento en la llamada, lista de parámetros vacía. ()
 * Al no devolver nada, el unico interes en llamarla es por el efecto que produce ejecutar sus instrucciones
 * (en este caso escribir el mensaje "Hola, ¿qué tal?", en la consola)
 */
void greet() {
    IO.println("Hola, ¿que tal?"); // única instrucción del cuerpo del método
}

/**
 * Función requestNumber
 * Devuelve un valor de tipo int al llamador
 * (en este caso el número que haya introduction el usuario por teclado)
 */
int requestNumber() {
    String input = IO.readln("Introduce un número: ");
    int number = Integer.parseInt(input);
    return number; // Evaluar la expresión y devolver el valor computado al llamador
}

/**
 * Versión que no usa la variable local intermedia number
 * (Nota:
 * aparece en gris porque nunca es llamada, ya que
 * ni main,
 * ni ninguna función llamada desde main,
 * ni ninguna funciona llamada desde alguna función que ha sido llamada desde main, etc
 * la llama)
 */
int requestNumber2() {
    String input = IO.readln("Introduce un número: ");
    return Integer.parseInt(input); // Evaluar la expresión y devolver el valor computado al llamador
}


/**
 * Esta función requestNumberCaller
 * contiene una instrucción (la declaración de la variable result) que efectúa una llamada a la función
 * requestNumber() cada vez que se ejecuta.
 * Para poder obtener el valor mediante el cual inicializar la variable result, se debe llamar a requestNumber()
 * con lo que se le cederá el control de la CPU para que ejecute sus instrucciones
 * y se esperará a que termine y retorne un valor.
 * Tras el retorno de la llamada a requestNumber la función requestNumberCaller recupera el control y asigna el
 * valor devuelto considerandolo como el resultado de evaluar la expresión de inicialización.
 * Y continúa imprimiendo el valor del número.
 */
void requestNumberCaller() {
    /* La variable result se inicializa con el valor resultante de evaluar la expresión de tipo
    llamada a función `requestNumber()` */
    var result = requestNumber();
    IO.println("Número introducido: " + result);
}

void callGreet() {
    IO.println("Llamando a la funcion greet()...");
    greet(); // Llamada a la funcion greet para que imprima: 'Hola, ¿que tal?', en la consola
    IO.println("Continuar por la siguiente instrucción, después de llamar a la funcion greet()...");

    // Si llamamos a greet 2 veces más (obtendremos 2 mensajes más en la consola)
    greet();
    greet();
}


/**
 * Calcula el valor al cubo del número proporcionado como argumento
 * y lo devuelve al llamador.
 */
double cube(double number) {
    return number * number * number;
}

void callCubeDemo1() {
    // Guardar el resultado devuelto por la llamada a la función IO.readln en un almacén (variable input)
    String input = IO.readln("Introduce un numero: ");

    // Usar el valor de la variable input como argumento de llamada a Double.parseDouble
    // y guardar el resultado devuelto por la función en un almacén (variable `x`)
    double x = Double.parseDouble(input);

    // Guardar el resultado devuelto por la llamada a la función en un almacén (variable cbx)
    double cbx = cube(x);

    // Usar el valor de la variable cbx en la expresión que calcula el valor a asignar a `y`
    double y = cbx + 1 / x;

    // Usar el valor de `y`como argumento de la llamada al método IO.println
    IO.println(y);
}

void callCubeDemo2() {
    // El resultado String devuelto por la llamada a IO.readln con el argumento literal "Introduce un número: "
    // Se usa directamente como argumento en la llamada a Double.parseDouble
    // y el resultado devuelto por la llamada a Double.parseDouble se guarda en la variable `x`
    double x = Double.parseDouble(IO.readln("Introduce un número: "));

    // La expresión para asignar a `y` se incluye directamente la llamada a función
    double y = cube(x) + 1 / x;

    // Usar el valor de `y`como argumento de la llamada al método IO.println
    IO.println(y);
}

void callCubeDemo3() {
    // El resultado String devuelto por la llamada a IO.readln con el argumento literal "Introduce un número: "
    // Se usa directamente como argumento en la llamada a Double.parseDouble
    // y el resultado devuelto por la llamada a Double.parseDouble se guarda en la variable `x`
    double x = Double.parseDouble(IO.readln("Introduce un número: "));

    // La llamada a IO.println usa como argumento una expresión que incluye directamente la llamada a cube
    // como parte de la expresión
    IO.println(cube(x) + 1 / x);
}

/**
 * Métodos void (que no devuelven nada)
 */

void printLine(int length) {
    IO.println("".repeat(length));
}

/**
 * Las funciones void solamente se pueden usar para formar instrucciones de expresión (añadiendo el ; al final)
 */
void callPrintLineDemo() {
    IO.println("¡Hola!");
    printLine(20); // Instrucción de expresión (expression statement)
    IO.println("¿Que tal?");
    printLine(20);
    IO.println("¿Cómo estas?");
    printLine(30);
}

void callPrintLineDemoWrong() {
    // Como la función printLine no devuelve un valor ...

    // no se puede usar una llamada como expresión de inicialización o asignación de a un almacén (variable)
    // String line = printLine(20); // ERROR

    // ni participar como parte de una expresión
    // IO.println("¡Hola!" + printLine(20)); // ERROR
}



void main() {
    // Llamada a callGreet (no tiene parámetros declarados y, por tanto, no proporcionamos ningún argumento)
    callGreet();

    // Llamada a requestNumberCaller (no declara ningún parámetro de entrada, por tanto, lista de argumentos vacía)
    requestNumberCaller();
}