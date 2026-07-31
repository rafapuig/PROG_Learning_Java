/**
 * Una variable es un espacio de memoria que se reserva
 * para almacenar un valor de un determinado tipo
 * declarada mediante un nombre denominado identificador
 * que sirve para poder hacer referencia a dicha variable posteriormente
 * cuando queremos acceder al valor que contiene guardado o queremos
 * reasignar un nuevo valor
 * durante el tipo de vida de la variable
 * Solamente podemos hacer referencia a una variable donde resulta conocida
 * es decir, en su ámbito o alcance (scope en inglés)
 */

/**
 * Una variable global es conocida en cualquier parte del fichero donde se declara
 * (su scope es el del fichero, no se conoce en los demás archivos fuente)
 */

// Variable "global"
String name = "Perico Palotes";
int total = 100;

/**
 * Las variables "globales" no es estrictamente necesario inicializarlas,
 * se inicializan entonces con un valor por defecto, dependiendo de su tipo
 */
int notInitializedInt; // Una variable global de tipo integral toma el valor 0
double notInitializedDouble; // Una global de tipo double toma el valor 0.0
float notInitializedFloat; // Una global de tipo float toma el valor 0.0
boolean notInitializedBoolean; // Implícitamente valor false
Object notInitializedObject; // Implícitamente valor null



void f1() {
    /**
     * Se puede acceder a la variable "global" desde cualquier función
     */
    // Acceso a la variable para modificar su valor almacenado (asignación)
    name = "Armando Bronca Segura";
    total = 99;

    // Acceso a la variable `total` para leer su valor y copiarlo en la variable
    // local `copy`
    int copy = total;

}

void f2() {
    int x = 5;
    int y = 3;
    IO.println(x);
    IO.println(y);
    // IO.println(z); // z no existe en este ámbito

    IO.println(total); // total existe en todas las funciones
}


void f3() {
    int x = 9;
    int z = 2;
    IO.println(x);
    //IO.println(y); // y no existe en este ámbito
    IO.println(z);

    IO.println(total); // total existe en todas las funciones
}


void showUninitializedGlobalVariablesValue() {
    IO.println(notInitializedInt);
    IO.println(notInitializedDouble);
    IO.println(notInitializedFloat);
    IO.println(notInitializedBoolean);
    IO.println(notInitializedObject);
}

void main() {
    showUninitializedGlobalVariablesValue();
}