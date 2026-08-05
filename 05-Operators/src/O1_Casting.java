/**
 * CONVERSION
 * <p>
 * Un valor de un tipo se puede intentar convertir en un valor equivalente de otro tipo
 * <p>
 * A veces, es posible que sea totalmente equivalente y otras veces no, y se perderá información.
 * Se puede perder información por:
 * - truncamiento
 * - overflow
 * - precision
 * - redondeo
 * <p>
 * Existen 3 tipos de conversiones:
 * - conversión de ampliación (widening)
 * - conversión de reducción (estrechamiento, narrowing)
 * - conversión de identidad
 * <p>
 * Conversión de identidad:
 * - Se produce cuando el valor a convertir y el tipo al que se quiere convertir es el mismo.
 * <p>
 * Conversión de ampliación:
 * - Se produce cuando la conversión en ningun caso va a ocasionar perdida de información.
 * <p>
 * Conversión de reducción:
 * - Se produce cuando convertir un valor al tipo destino puede ocasionar perdida de información.
 * Ejemplos:
 * Convertir el valor 5.2 a int --> se pierde la parte decimal --> 5
 * Convertir un valor double a uno float --> se pierden bits de precisión de 52 a 23
 * Convertir un valor int a short --> se pierden los 16 bits más significativos por truncamiento
 * <p>
 * Como la conversion de reducción puede potencialmente producir perdida de información el compilador
 * está atento cuando procesa el código fuente para detectarlas, señalarlas como error y evitar la compilación
 * del código fuente.
 * <p>
 * <p>
 * Casting:
 * Una forma de convertir un valor de un tipo a otro es utilizar un operador de molde (casting), llamado
 * así para indicar que de alguna manera lo que hacemos es meter algo en un molde y sacarlo moldeado.
 * <p>
 * Cuando se produce una conversión automáticamente allí donde se requiere esto es una conversión implícita
 * <p>
 * La operación de casting permite realizar conversiones de manera explícita, de manera que el compilador ya no se
 * puede negar a dejar compilar la instrucción.
 * Es la manera que tiene el programador de decirle al compilador que es consciente de que ahí se está producción
 * una acción potencialmente peligrosa porque puede implicar la perdida de información. El compilador se lava las manos.
 * Es como desactivar el piloto automático (el compilador)
 * y pasar a pilotar manualmente esa instrucción (pilota el programador)
 * <p>
 * En resumen.
 * Donde el compilador detecta conversión de reducción, se niega a dar por válida la instrucción y evita compilar.
 * Si nosotros queremos permitir que en tiempo de ejecución se realice la conversión de reducción asumiendo que se puede
 * perder información (o que de alguna manera sabemos que no va a pasar nada de eso [prevaricación!!!]) la solución
 * es aplicar un casting para indicar explícitamente la conversión al compilador.
 */

void main() {

    int i = 10;
    /* Aquí nosotros sabemos que no hay peligro en convertir el valor de i en tipo byte porque el valor es 10  */
    /* Hacemos un casting para indicar explícitamente la conversión e indicar al compilador que deje hacer */
    byte b = (byte) i;

    double d = 0.1;
    float f = (float) d; // Conversión de reducción explicita mediante una operación de casting a float

    d = (double) f; // Casting a double, es innecesario hacer la conversion explícita porque es una ampliación
    d = f;
    d = (double) i;
    d = i;

    i = b; // Conversion de ampliación implícita
}