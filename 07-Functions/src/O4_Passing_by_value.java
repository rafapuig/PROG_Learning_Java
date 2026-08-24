/**
 * Paso por valor
 *
 * En la llamada a la función greet
 * el llamador tiene de evaluar la expresión usada como argumento y obtener un valor.
 * Ese valor se almacena en la memoria en una determinada dirección (posición)
 * (como si fuera una variable) a este almacen lo denominamos parámetro actual.
 *
 * Por cada llamada a la función se crea un almacen para guardar en memoria el valor del parametro de entrada
 * denominado parametro formal.
 *
 * Cuando se utiliza el mecanismo de paso por valor,
 * se COPIA el valor que tenemos almacenado en el parametro actual
 * en la memoria reservada para el parámetro de entrada correspodiente a la llamada invocada, parámetro formal.
 */

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

void greet(String name) {
    IO.println("Hola, " + name + "!");
}

void main() {
    testGreet();
}