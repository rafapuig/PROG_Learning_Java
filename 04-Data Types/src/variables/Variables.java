/**
 * Una variable
 * es un espacio de memoria
 * que se reserva para almacenar un valor de un determinado tipo
 * declarada mediante:
 *
 * - un nombre denominado identificador
 * que sirve para poder hacer referencia a dicha variable posteriormente
 * cuando queremos acceder al valor que contiene guardado o queremos
 * reasignar un nuevo valor
 * durante el tipo de vida (lifetime) de la variable
 * Solamente podemos hacer uso de una variable en donde resulta conocida
 * es decir, en su ámbito o alcance (scope en inglés)
 *
 * - un tipo
 * que sirve para determinar cuantos bytes de memoria reservar para almacenar el valor
 */

/**
 * Variable "global"
 *
 * Una variable global
 * - es conocida en cualquier parte del fichero donde ha sido declarada
 * (su scope es el del fichero, no se conoce en los demás archivos fuente)
 * - su duración se corresponde con el del programa
 * (dura desde que se crea hasta que termina el programa)
 *
 * Está declarada fuera del cuerpo de una función
 */

// Variables "globales"
String name = "Perico Palotes";
int total = 100;

/**
 * Sintaxis de declaración de una variable global:
 * <p>
 * tipo identificador;
 * <p>
 * (Si solamente declaramos la variable, lo que estamos pidiendo es que se reserve una zona de la memoria
 * de tamaño (en bytes) suficiente para almacenar un valor del tipo de dato correspondiente a la variable.
 * Por eso tenemos que indicar el tipo de dato (además del identificador) cuando declaramos una variable,
 * para que quede claro cuantos bytes de memoria hay que reservar para la variable)
 */
int number;

/**
 * Inicialización de una variable
 * <p>
 * Inicializar una variable consiste en proporcionarle el valor inicial que queremos que tenga (su primer valor) en
 * el momento de crearla (reservar la memoria)
 * <p>
 * Si no la inicializamos con un valor, entonces su valor correspondería con la interpretación del contenido
 * previo que hubiera en los bytes de memoria reservados para la variable.
 * Es decir, la memoria asignada para la variable, pudo haber sido usada por otras variables y haber sido liberada
 * para su uso. (La memoria se reserva y se libera, si no se agotaría)
 * <p>
 * Podemos dar el valor inicial (inicializar) a una variable al mismo tiempo que la declaramos
 * <p>
 * Sintaxis de declaración + inicialización:
 * <p>
 * tipo identificador = valor_inicial;
 *
 */
boolean isValid = false;
int lives = 5;
float health = .85f;


/**
 * Las variables "globales" no es estrictamente necesario inicializarlas.
 * Si no se inicializan explícitamente en el código, entonces se inicializan automáticamente con un valor por defecto
 * que depende de su tipo
 * (Normalmente lo que se hace es poner a 0 todos los bits de los bytes de la memoria reservada por la variable)
 */
int notInitializedInt; // Una variable global de tipo integral toma el valor 0
double notInitializedDouble; // Una global de tipo double toma el valor 0.0
float notInitializedFloat; // Una global de tipo float toma el valor 0.0
boolean notInitializedBoolean; // Implícitamente valor false
Object notInitializedObject; // Implícitamente valor null

void showUninitializedGlobalVariablesValue() {
    IO.println(notInitializedInt);
    IO.println(notInitializedDouble);
    IO.println(notInitializedFloat);
    IO.println(notInitializedBoolean);
    IO.println(notInitializedObject);
}

/**
 * Variables locales
 * <p>
 * Son locales porque se declaran dentro de un ámbito (scope) más restringido
 * (no son accesibles en cualquier parte del fichero)
 * <p>
 * Las variables locales NO tienen inicialización implícita.
 * (Por tanto, si solo se declaran y no se les proporciona un valor inicial, en tiempo de ejecución solamente se
 * hará la reserva de los bytes de memoria necesarios, pero no se borrará el contenido previo de esos bytes)
 * <p>
 * IMPORTANTE:
 * - En Java, una variable local no se puede acceder para leer su contenido hasta que no ha sido inicializada.
 *
 *
 * Podemos inicializar las variables no inicializadas más adelante en instrucciones posteriores.
 *
 * En la declaración de una variable local con inicialización se puede sustituir el tipo por la keyword var.
 *
 * var level = 3; // level será una variable de tipo int
 *
 * Este mecanismo para determinar el tipo de la variable a partir de su valor inicial se denomina:
 * INFERENCIA DE TIPO
 */


void f1() {
    /**
     * Se puede acceder a la variable "global" desde cualquier función
     */
    // Acceso a la variable para modificar su valor almacenado (asignación)
    name = "Armando Bronca Segura";
    total = 99;

    // Declaramos una variable de tipo int con identificador `copy` sin inicializar
    int copy;

    // Acceso a la variable `total` para leer su valor y copiarlo en la variable
    // local `copy`
    copy = total; // Se obtiene el valor de `total` y asigna ese mismo valor a la variable `copy`

    IO.println("total = " + total); // 99
    IO.println("copy = " + copy); // `copy` tiene el mismo valor que `total` 99

    // Modificamos la copia
    copy = 50; // Asignamos el valor 50 en la variable `copy`
    IO.println("total = " + total); // 99
    IO.println("copy = " + copy); // 50

}

void f2() {
    int x = 5; // Declaración de la variable x local a la funcion f2
    int y = 3;
    IO.println(x); // Se refiere a la variable x local de la funcion f2
    IO.println(y);
    // IO.println(z); // z no existe en este ámbito

    IO.println(total); // `total` es accesible en todas las funciones del archivo
}

void f3() {
    /**
     * La variable x
     * Está declarada dentro del cuerpo de la función f3,
     * por tanto, es una variable local circunscrita a la función donde ha sido declarada: f3
     * Solamente la podemos usar dentro esta función
     * Su vida comienza cuando se llama a la función para ejecutar las instrucciones de su cuerpo
     * y termina cuando la ejecución de la función termina
     *
     * Corolarios:
     * - La variable x local de f3 no es la misma que la variable x local de la funcion f2
     * - Se puede reutilizar nombres identificadores (usar el mismo nombre) en ambitos diferentes
     * (en este caso funciones diferentes) dado que cada una se conoce en su propio ámbito
     */
    int x = 9; // Declaración de la variable x local a la funcion f3
    int z = 2;
    IO.println(x);
    //IO.println(y); // y no existe en este ámbito
    IO.println(z);

    IO.println(total); // total existe en todas las funciones
}


/**
 * Uso de var en declaración de variables locales (inferencia de tipos)
 */

void typeInference() {
    /**
     * Se infiere el tipo de la variable a partir del tipo del valor inicial
     */
    var i = 1; // tipo int
    var c = '\n'; // tipo char
    var city = "Valencia"; // tipo String
    var l = 1L; // tipo long
    var d = 0.5; // tipo double
    var f = 0.5f; // tipo float

    // var x; // Error, al no proporcionar valor inicial no se puede inferir el tipo de la variable
    // var nothing = null; // No se puede inferir el tipo de dato si el valor inicial es el literal del tipo nulo
}


/**
 * Intercambio del valor entre dos variables
 * (Es un problema similar a intercambiar el contenido de dos vasos, se necesita un tercer recipiente)
 * Hace falta una tercera variable
 */

void swap() {
    int x = 5;
    int y = 3;
    IO.println("x = " + x);
    IO.println("y = " + y);

    // Intercambio del valor entre las variables x e y
    int temp = x; // Copiamos el valor de x en una tercera variable temp porque el valor de x lo vamos a cambiar
    x = y; // Ahora copiamos el valor de y en x
    y = temp; // Ahora el valor de x que habíamos copiado en temp lo asignamos a la variable y

    IO.println("x = " + x);
    IO.println("y = " + y);
}


void local() {

    /**
     * Declaración de una variable local de tipo int sin inicialización identificada por el nombre x
     *
     * (En tiempo de ejecución se reservarán los 4 bytes necesarios para almacenar un valor de tipo int,
     * pero el contenido de esos cuatro bytes no se "toca", por lo que permanecen con el valor que tuvieran
     * cuando fueron liberados para poder ser reasignados a otra variable)
     */
    int x;

    /**
     * En Java, no podemos leer el valor de una variable local no inicializada
     * (Sus bytes reservados contienen información previa por uso anterior, esto se denomina BASURA)
     */

    //IO.println(x); // Error, todavía no se ha inicializado la variable x

    x = 5; // Inicialización de la variable x, a partir de ahora podemos acceder para leer su valor
    IO.println("x = " + x);

    /* Y como es una variable, podemos modificar su valor tantas veces como queramos */
    x = 10;
    IO.println("x = " + x);

    x = 11;
    IO.println("x = " + x);
}


void local2() {

    int x;

    {
        // El ámbito (scope) de una variable abarca el bloque (delimitado por las { } ) en que ha sido declarada
        int n = 5;
        IO.println("n = " + n);
        x = n;
    }

    IO.println("x = " + x);

    // n = -1; // Error, acceso fuera del ámbito

    {
        // Esta variable n solamente se llama igual que la n de más arriba pero se trata de otra variable
        int n = 3;
        IO.println("n = " + n);
        x = n;
    }

    IO.println("x = " + x);

    //n = -2; // Error, acceso fuera del ámbito
}


void shadowing() {

    IO.println(total); // Estamos accediendo a la variable global `total`

    /**
     * Si declaramos una variable local con el mismo nombre identificador que el de una variable "global"
     * En adelante, cuando usemos el nombre para acceder a la variable, estaremos accediendo a la variable local
     * y no a la global
     * Se dice que la variable local con el mismo nombre que la global ENSOMBRECE (shadows) a la global
     */
    int total;

    total = 50; // Asignamos el valor 50 a la variable local

    IO.println("total = " + total);

    /**
     * La unica forma que tenemos a partir de entonces de acceder a la variable global ensombrecida
     * es mediante la referencia this y el operador punto
     * En este caso this.total
     */
    IO.println("total = " + this.total);
}


/**
 * No podemos hacer shadowing de una variable local por otra local que solapen su ámbito
 */
void shadowing2() {

    // El ámbito de x, es todo el cuerpo de la función
    int x = 0;

    {
        // El ámbito (scope) de una variable abarca el bloque (delimitado por las { } ) en que ha sido declarada
        //int x = 5; // Error, no se puede declarar otra variable local con el mismo nombre dentro de su ámbito
        IO.println("x = " + x);
        x = x;
    }

    IO.println("x = " + x);

}


void main() {
    showUninitializedGlobalVariablesValue();
}