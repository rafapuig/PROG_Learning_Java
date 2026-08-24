/**
 * Paso por valor
 * -------------------------------------------------------------------------------------------------
 * En la llamada a la función greet
 * el llamador tiene que evaluar la expresión usada como argumento y obtener un valor.
 * <p>
 * Ese valor se almacena en la memoria en una determinada dirección (posición)
 * (como si fuera una variable) a este almacen lo denominamos parámetro actual.
 * <p>
 * Por cada llamada a la función se crea un almacen para guardar en memoria el valor del parámetro de entrada
 * denominado parametro formal.
 * <p>
 * Cuando se utiliza el mecanismo de paso por valor,
 * se COPIA el valor que tenemos almacenado en el parámetro actual
 * en la memoria reservada para el parámetro de entrada correspodiente a la llamada invocada, parámetro formal.
 */

void greet(String name) {
    IO.println("Hola, " + name + "!");
}

void testGreet() {
    String name = "Perico Palotes";
    /* Al llamar a greet se crea un parámetro actual con el valor del argumento de llamada
     llamemosle actualGreetName1 y se asigna el valor resultado de evaluar el argumento: Perico Palotes

     También se reserva memoria para aamacenar el valor del parámetro de entrada (parametro formal)
     llamemosle formalGreetName1
     El valor del parámetro actual actualGreetName1 se copia en el parametro formal formalGreetName1
     y dentro del cuerpo de la funcion greet se accede mediante el parametro de entrada name
     */
    greet(name);

    String pedro = "Pedro Gado";
    /* Al retornar de la llamada a greet se libera la memoria reservada por actualGreetName1 y formalGreetName1

    /* Ahora, al llamar de nuevo a greet se crea de nuevo un parámetro actual con el valor del argumento de llamada
     llamemosle actualGreetName2 y se asigna el valor resultado de evaluar el argumento: Pedro Gado

     También se reserva memoria para almacenar el valor del parámetro de entrada en esta nueva llamada
      (parametro formal), llamemosle formalGreetName2
     El valor del parámetro actual actualGreetName2 se copia en el parámetro formal formalGreetName2
     y dentro del cuerpo de la funcion greet en esta nueva llamada
     se accede igualmente mediante el parámetro de entrada name
     */
    greet(pedro);

    /* Al haberse liberado la memoria usada por actualGreetName1 y formalGreetName1 podría ser que se volviera
    a utilizar otra vez, las mismas direcciones de memoria, pero lo normal será que no!!!
     */

    /* Esto se entiende mejor si pensamos que la primera llamada a greet puede no haber finalizado y mientras
    se realiza otra llamada a la funcion greet
    Cada llamada tiene su parametro formal correspondiente e independiente
     */
}

/**
 * El parámetro number recibe su valor mediante el mecanismo de paso por valor
 * una copia del valor del argumento de llamada
 */
void triple(int number) {
    number = number * 3; // Aunque modificamos el valor del parámetro... (no afectará al argumento)
    IO.println("Number = " + number);
}

void callTriple() {
    int value = 5;
    triple(value); // El paso es por valor, el valor de la variable value se copia en el parámetro number
    IO.println("Value = " + value);

    value = 10;
    triple(value);
    IO.println("Value = " + value);
}


long triple(long number) {
    number = number * 3;
    return number;
}

void callTriple2() {
    var value = 20L;
    value = triple(value);
    IO.println("Value = " + value); // 60
}

void swap(int a, int b) {
    int temp = a;
    a = b;
    b = temp;
}

void callSwap() {
    int x = 2;
    int y = 3;
    swap(x, y);
    IO.println("x = " + x);
    IO.println("y = " + y);
}

/**
 * No funciona tampoco, intercambia las referencias, no los valores
 */
void swap2(Integer a, Integer b) {
    Integer temp = a;
    a = b;
    b = temp;
}

void callSwap2() {
    Integer x = 5;
    Integer y = 10;
    swap2(x, y);
    IO.println("x = " + x);
    IO.println("y = " + y);
}

void swap3(int... args) {
    int temp = args[0];
    args[0] = args[1];
    args[1] = temp;
}

void callSwap3() {
    var x = 5;
    var y = 10;
    swap3(x, y);
    IO.println("x = " + x);
    IO.println("y = " + y);
}

void callSwap4() {
    var values = new int[]{4, 8};
    swap3(values);
    IO.println("x = " + values[0]);
    IO.println("y = " + values[1]);
}

class Box<T> {
    T value;

    Box(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

<T> void swap(Box<T> a, Box<T> b) {
    T temp = a.value;
    a.value = b.value;
    b.value = temp;
}

void callSwap5() {
    var x = new Box(10);
    var y = new Box(20);
    swap(x, y);
    IO.println("x = " + x);
    IO.println("y = " + y);
}


void main() {
    //testGreet();
    //callTriple();
    //callTriple2();
    callSwap();
    callSwap2();
    callSwap3();
    callSwap4();
    callSwap5();
}