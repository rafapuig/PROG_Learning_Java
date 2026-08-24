/**
 * La función:
 * String IO.readln(String prompt)
 * Lee caracteres a partir de la escritura por teclado del usuario mientras que no sea que ha pulsado el ENTER
 * En ese momento, da por terminada su labor y retorna el control al llamador
 * devolviéndole un String (cadena de caracteres) que contiene lo que escribió el usuario hasta pulsar ENTER
 *
 * Llamar o invocar a una función consiste en solicitar que ejecute las instrucciones
 * con las que ha sido declarada y definida
 * El llamador le cede el control de la CPU para que ejecute dichas instrucciones y permanece a la espera
 * de que la función termine y le retorne el control para seguir.
 * Además, la funcion puede generar un resultado que es capaz de devolver al llamador a modo de respuesta
 * al terminar. A esto se le suele denominar la salida.
 *
 * A veces, una función está parametrizada, lo que quiere decir que para realizar su trabajo
 * necesita que el llamador le aporte los datos con los que quiere que proceda.
 *
 * El nombre que reciben los datos que aporta el llamador a la funcion en el momento de realizar
 * la llamada se denominan ARGUMENTOS de entrada.
 *
 * Llamador --> Llamada(ARGUMENTOS) --> Funcion --> ejecuta instrucciones --> devuelve resultado (Salida)
 *
 * Ejemplo:
 *
 * Salida      <--   llamada(   argumento    )
 *
 * String input = IO.readln("Escribe algo: ");
 *
 * - IO.readln es el nombre de la función y es lo que tenemos que usar para llamarla, además de unos ()
 *  y dentro de los pararentesis, si fuera necesario, proporcionar los argumentos de entrada.
 *
 * - "Escribe algo: " es el argumeto de la llamada, la función lo usa para saber que tiene que imprimir al usuario
 * para darle información sobre lo que se está pidiendo que escriba.
 *
 * - Si la función devuelve algo al llamador, podemos asignarlo a un contenedor para poder usarlo más adelante.
 * En este caso el contenedor es la variable input
 * Como el valor devuelto por la llamada es un String el contenedor tiene que ser un contenedor de datos de tipo String.
 * 
 *
 */

void main() {
    /* Leemos la entrada del usuario
    y la almacenamos en la variable name
     */
    var name = IO.readln("Dime tu nombre: ");

    /* Imprimimos Hola,
    seguido de lo que hemos guardado en la variable name
    El símbolo + en este caso es el operador de CONCATENACION
    Este operador toma dos textos y crea otro nuevo
    que es el resultado de pegar el segundo a continuación del primero
     */
    IO.println("Hola, " + name);
}