/**
 * Ya hemos visto un tipo de almacén de datos: las variables
 * <p>
 * Hemos visto que son una buena manera de almacenar datos en memoria.
 * Pero tienen una importante limitación:
 * - Solamente pueden almacenar un valor (en un momento dado).
 * <p>
 * En ocasiones nos interesa guardar una gran cantidad de valores del mismo tipo en memoria.
 * En ese caso necesitamos un tipo de datos almacén que permita almacenar esos valores.
 * <p>
 * Este almacén que vamos a ver es una estructura de datos
 * y se denomina ARRAY
 */

import java.util.Arrays;

/**
 * Ejemplo:
 * Si tuviéramos que escribir un programa que pida al usuario 3 números
 * y luego los muestre en orden ascendente. TODO: Podríamos cambiarlo por la suma, o la media, o algo mas sencillo.
 * Si no contáramos con los arrays, una forma de resolverlo sería la siguiente...
 * ¡Imagina después de verla y entenderla como sería si en lugar de 3 fueran 100 números!
 */
void solutionWithoutArrays() {

    // Tres variables una para número
    int num1, num2, num3;

    // Repetimos 3 veces el mismo procedimiento de pedir un número
    // as binándolo cada vez a una de las variables
    // (no podemos usar un bucle aunque se repita algo varias veces porque no asignamos a la misma variable)
    num1 = Integer.parseInt(IO.readln());
    num2 = Integer.parseInt(IO.readln());
    num3 = Integer.parseInt(IO.readln());

    if (num1 <= num2 && num2 <= num3) {
        IO.println(num1 + " " + num2 + " " + num3);
    } else if (num1 <= num3 && num3 <= num2) {
        IO.println(num1 + " " + num3 + " " + num2);
    } else if (num2 <= num1 && num1 <= num3) {
        IO.println(num2 + " " + num1 + " " + num3);
    } else if (num2 <= num3 && num3 <= num1) {
        IO.println(num2 + " " + num3 + " " + num1);
    } else if (num3 <= num1 && num1 <= num2) {
        IO.println(num3 + " " + num1 + " " + num2);
    } else {
        IO.println(num3 + " " + num2 + " " + num1);
    }
}


void solutionWithoutArrays2() {

    // Tres variables una para número
    int num1, num2, num3;

    // Repetimos 3 veces el mismo procedimiento de pedir un número
    // as binándolo cada vez a una de las variables
    // (no podemos usar un bucle aunque se repita algo varias veces porque no asignamos a la misma variable)
    num1 = Integer.parseInt(IO.readln());
    num2 = Integer.parseInt(IO.readln());
    num3 = Integer.parseInt(IO.readln());

    int sum = 0; // = num1 + num2 + num3;

    sum += num1;
    sum += num2;
    sum += num3;

    float average = (float) sum / 3;

    IO.println("Suma = " + sum);
    IO.println("Media = " + average);
}

/**
 * ¿Qué es una array?
 * <p>
 * Es una estructura de datos que permite almacenar valores de un mismo tipo comun, sus elementos,
 * y que permite acceder a ellos indicando la posición que ocupa el elemento en la estructura.
 * A dicha posición también se denomina índice (index).
 * <p>
 * La característica principal y que distingue a los arrays es la de que
 * todos sus elementos se almacenan de manera compacta en bloque, es decir, de forma consecutiva en la memoria.
 * <p>
 * La forma de crear un array es mediante el operador new
 * <p>
 * new tipo_elemento[numero_elementos]
 * <p>
 *
 * ¿Y la forma de acceder a cada elemento?
 * <p>
 * Un array se considera un tipo de datos,
 * y, por tanto, podemos declarar una variable donde asignarlo, para poder hacer referencia a él más adelante.
 * <p>
 * Para poder asignarle un array el nombre de la variable debe terminar en []
 * <p>
 * Y ahora,
 * para acceder al elemento situado en la primera posición usamos como valor de posición o índice el 0
 * para acceder al último elemento usamos como valor de posición / índice el del numero_elementos - 1
 * <p>
 * Por tanto, si un array se creó con espacio para N elementos, sus elementos se acceden con índices
 * que van desde el 0 hasta el N-1.
 * <p>
 * La explicación es que el valor del índice indica cuantos elementos tienes que dejar atrás avanzando
 * si empiezas desde el principio del array hasta posicionarte justo en el elemento al que quieres acceder.
 * <p>
 * Por eso, para acceder al primer elemento se usa el índice 0, porque no tienes que avanzar ninguna posición
 * par situarte en el primer elemento.
 * Y para llegar hasta el último (n-estimo) habrás tenido que dejar a tras a los N-1 anteriores.
 * <p>
 * Mucho cuidado con esto.
 *
 * Una vez tenemos el índice para acceder al almacén donde se almacena el valor usamos el operador []
 *
 * referencia_array [ índice ]
 *
 * Donde índice puede ser cualquier expresión de tipo entero int (no tiene por qué ser necesariamente un valor literal)
 *
 * El operador [] expresa un almacén de datos (como una variable)
 * que permite acceder al valor almacenado en la posición indicado por el índice almacenado en el array referenciado.
 * Y tiene, por tanto,  toda la consideración de un almacén de datos o lvalue (como si se tratara de una variable).
 * Puedo usar  referencia_array[indice] :
 * - como operando izquierdo en una operación de asignación =.
 * - como operando izquierdo en una operación de asignación compuesta += , -=, *= etc.
 * - como operando de los operadores de incremento ++ y decremento --
 *
 *
 * Por tanto, podemos verlo como si declarar un array 3 elementos de tipo entero
 * diera lugar a tres almacenes consecutivos en la memoria y el operador [] mediante el índice me permite seleccionar
 * cuál de ellos quiero usar.
 *
 *
 */

void arraysDemo1() {

    int numbers[] = new int[3];

    numbers[0] = 1;
    numbers[1] = 2;
    numbers[2] = 3;

    IO.println(numbers[0] + " " + numbers[1] + " " + numbers[2]);
}

/**
 * En Java los [] se suelen colocar después del tipo de los elementos
 */
void arraysDemo2() {

    int[] numbers = new int[3];

    numbers[0] = 1;
    numbers[1] = 2;
    numbers[2] = 3;

    IO.println(numbers[0] + " " + numbers[1] + " " + numbers[2]);
}

/**
 * Sí conocemos explícitamente los valores de los elementos podemos crear el array
 * indicando los elementos uno por uno separados por comas y entre {}
 * <p>
 * {valor1, valor2, valor3, ...}
 * <p>
 * y no hará falta indicar entre [] el número de elementos del array,
 * ya que se deduce a partir de contar los elementos de la lista entre {}
 */

void arraysDemo3() {
    int[] numbers = new int[]{1, 2, 3};
    IO.println(numbers[0] + " " + numbers[1] + " " + numbers[2]);
}

/**
 * Y en el caso de que se trate de una inicialización de la variable para referenciar el array
 * se puede simplificar
 * no hace falta escribir new tipo_elemento[], solamente la lista entre {}
 */
void arraysDemo4() {
    int[] numbers = {1, 2, 3};
    IO.println(numbers[0] + " " + numbers[1] + " " + numbers[2]);
}


/**
 *  // La expresión numbers[0] es un lvalue,
 *     // puede aparecer a la izquierda de un operador de asignación (como operando izquierdo del operador de asignación)
 *     // Se considera un almacen
 */

void arraysDemo5() {
    int[] numbers = {1, 2, 3};
    IO.println(numbers[0] + " " + numbers[1] + " " + numbers[2]);

    numbers[0] = 10;
    numbers[1] *= 2;
    numbers[2]++;

    IO.println(numbers[0] + " " + numbers[1] + " " + numbers[2]);

    numbers[0]--;
    numbers[1] = numbers[0] / 2;
    numbers[2] += 5;
    IO.println(numbers[0] + " " + numbers[1] + " " + numbers[2]);
}

void arraysDemo6() {
    int[] numbers = {1, 2, 3};

    int n = 3;
    int number = numbers[1 + 2 - n % 4];

    int index = 0;
    numbers[index++] = 10;
    numbers[index++] = 20;
    numbers[index++] = 30;
    IO.println(numbers[0] + " " + numbers[1] + " " + numbers[2]);
}

/**
 * Y como sabemos el tamaño de un array si no lo guardamos en una variable?
 *
 * Accediendo a la propiedad length a traves de la referencia al array (de la variable)
 */

void arraysDemo7() {
    int[] numbers = {1, 2, 3};
    int size = numbers.length;

    // Acceso al último elemento del array referenciado por la variable numbers
    numbers[size - 1] *= 2;

    IO.println(numbers[0] + " " + numbers[1] + " " + numbers[2]);
}


/**
 * ¿Y si creo otra variable de tipo array y le asigno un array referenciado en otra variable?
 *
 * Los arrays NO se copian cuando asignamos a una variable de tipo array usando como expresión
 *
 * Al hacer la asignación lo que estamos diciendo es que
 * ambas variables van a hacer referencia al MISMO array
 *
 */
void arraysDemo8() {
    int[] numbers = {1, 2, 3};
    int[] copy = numbers;

    IO.println(numbers[0] + " " + numbers[1] + " " + numbers[2]);

    copy[0] = 10; // es equivalente a hacer numbers[0] = 10
    copy[1] = 20; // es equivalente a hacer numbers[1] = 20

    IO.println(copy[0] + " " + copy[1] + " " + copy[2]);
    IO.println(numbers[0] + " " + numbers[1] + " " + numbers[2]);
}

/**
 * El poder de los arrays se manifiesta cuando los combinamos con el uso de los bucles
 * donde podemos indicar que queremos repetir la misma operación para cada elemento del array
 */
void arraysDemo9() {
    int[] numbers = {1, 2, 3};
    for (int i = 0; i < numbers.length; i++) {
        numbers[i] *= 2;
    }
    IO.println(numbers[0] + " " + numbers[1] + " " + numbers[2]);
}

/**
 * Si solamente queremos leer los valores del array (no modificarlos)
 * podemos usar el bucle foreach
 */
void arraysDemo10() {
    int[] numbers = {1, 2, 3};

    for (int number : numbers) {
        IO.println(number);
    }
}

/**
 * Entonces como ¿hago una copia de un array?
 *
 * Creando otro array del mismo número de elementos que el array original.
 */
void arraysDemo11() {
    int[] numbers = {1, 2, 3};
    IO.println(numbers[0] + " " + numbers[1] + " " + numbers[2]);

    int[] copy = new int[numbers.length];
    for (int i = 0; i < numbers.length; i++) {
        copy[i] = numbers[i];
    }

    IO.println(copy[0] + " " + copy[1] + " " + copy[2]);

    copy[0] = 10;
    copy[1] = 20;
    IO.println(copy[0] + " " + copy[1] + " " + copy[2]);

    IO.println(numbers[0] + " " + numbers[1] + " " + numbers[2]);
}


/**
 * Recopilando todo lo que hemos visto podemos solucionar el ejercicio anterior mediante arrays
 */
void solutionWithArrays() {

    /* // Tres variables una para número
    int num1, num2, num3; */

    int[] numbers = new int[10];

    /*// Repetimos 3 veces el mismo procedimiento de pedir un número
    // as binándolo cada vez a una de las variables
    // (no podemos usar un bucle aunque se repita algo varias veces porque no asignamos a la misma variable)
    num1 = Integer.parseInt(IO.readln());
    num2 = Integer.parseInt(IO.readln());
    num3 = Integer.parseInt(IO.readln());*/

    // Mediante un bucle guardamos cada valor en una posición diferente del array gracias al índice expresado como i
    for (int i = 0; i < numbers.length; i++) {
        numbers[i] = Integer.parseInt(IO.readln("Dame el número " + (i + 1) + ": "));
    }

    // Ordenar
    for (int i = 0; i < numbers.length; i++) {
        var min =  i;
        for (int j = i + 1; j < numbers.length; j++) {
            if (numbers[j] < numbers[min]) {
                min = j;
            }
        }
        var temp = numbers[min];
        numbers[min] = numbers[i];
        numbers[i] = temp;
    }

    for (int i = 0; i < numbers.length; i++) {
        if (i != 0) IO.print(" ");
        IO.print(numbers[i]);
    }
    IO.println();
}


void main() {
    solutionWithArrays();
}