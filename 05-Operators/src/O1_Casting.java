/**
 * CONVERSION (de valores)
 * ---------------------------------------------------------------------------------------------------
 * Un valor de un tipo se puede intentar convertir en un valor equivalente de otro tipo
 *
 * A veces, es posible que la conversión sea a un valor totalmente equivalente,
 * pero otras veces no será posible, y se perderá información.
 *
 * Se puede perder información debido a:
 * - truncamiento
 * - overflow
 * - precision
 * - redondeo
 *
 * Existen 3 tipos de conversiones:
 * - conversión de ampliación (widening)
 * - conversión de reducción (estrechamiento, narrowing)
 * - conversión de identidad
 *
 * Conversión de identidad:
 * - Se produce cuando el valor a convertir y el tipo al que se quiere convertir es el mismo.
 *
 * Conversión de ampliación:
 * - Se produce cuando la conversión en ningún caso va a ocasionar perdida de información.
 *
 * Conversión de reducción:
 * - Se produce cuando convertir un valor al tipo destino puede ocasionar perdida de información.
 *
 *
 * Ejemplos:
 * Convertir el valor 5.2 a int --> se pierde la parte decimal --> 5
 * Convertir un valor double a uno float --> se pierden bits de precisión de 52 a 23
 * Convertir un valor int a short --> se pierden los 16 bits más significativos por truncamiento
 *
 * Dado que la conversión de reducción puede potencialmente producir perdida de información,
 * el compilador está atento cuando procesa el código fuente para detectarlas, señalarlas como error
 * y evitar la compilación del código fuente.
 */

/**
 * CASTING
 * ----------------------------------------------------------------------------------------------------------
 * La forma explícita de convertir un valor de un tipo a otro es utilizar un operador de molde (casting),
 * llamado así por la analogía de meter algo derretido en un molde y sacar eso mismo, pero moldeado
 * (misma sustancia, pero con la forma que le da el molde utilizado).
 *
 * Cuando se produce una conversión automática allá donde es requerida y factible,
 * se considera una conversión implícita.
 *
 * La operación de casting, sin embargo, permite realizar conversiones de manera explícita,
 * de manera que el compilador ya no se puede oponer a compilar la instrucción.
 * Es la manera que tiene el programador de decirle al compilador:
 * "soy consciente de que ahí se está produciendo una acción potencialmente peligrosa
 * porque puede implicar la perdida de información"
 * El compilador, ante esto, se lava las manos y deja hacer a criterio del programador.
 * Es como desactivar el piloto automático (el compilador)
 * y pasar a pilotar manualmente esa instrucción (pilota el programador)
 *
 * En resumen.
 * Donde el compilador detecta una conversión de reducción, se niega a dar por válida la instrucción y evita compilar.
 * Si nosotros queremos permitir que, en tiempo de ejecución, se realice la conversión de reducción,
 * asumiendo que se puede perder información
 * (o que de alguna manera sabemos que no va a pasar nada de eso [prevaricación!!!]),
 * la solución es realizar una operación de casting para indicar explícitamente la conversión al compilador.
 */

void main() {

    int i = 10;
    /* Aquí nosotros sabemos que no hay peligro en convertir el valor de i en tipo byte porque el valor es 10 (entre -128,127) */
    /* Hacemos un casting para realizar explícitamente la conversión e indicar al compilador que nos deje hacer */
    byte b = (byte) i;

    double d = 0.1;
    float f = (float) d; // Conversión de reducción explicita mediante una operación de casting a float

    d = (double) f; // Casting a double, es innecesario hacer la conversion explícita porque es una ampliación
    d = f; // Conversion de ampliación implícita

    d = (double) i;
    d = i; // Conversion de ampliación implícita

    i = b; // Conversion de ampliación implícita
}