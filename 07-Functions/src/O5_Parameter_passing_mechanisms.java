/*
 * Mecanismos para el paso de parámetros
 * -----------------------------------------------------------------------------------------
 *
 * Existen varios mecanismos para el paso de valores a los parámetros de entrada (y para el valor de retorno)
 *
 * Recordatorio:
 * Una variable (lvalue) tiene 3 componentes:
 * - nombre
 * - dirección de memoria (localización) donde empieza el espacio en bytes necesario para almacenar su valor
 * - datos (almacenados en ese espacio reservado en la memoria) también conocido como 'valor' de la variable.
 *
 * El nombre de una variable es el sistema por el cual el programador no necesita saber la dirección de memoria
 * donde se almacena su valor. Solamente usa el nombre cuando quiere modificar o leer el valor de la variable,
 * con lo que se accede a esa zona de memoria y se leen o modifican esos bytes.
 *
 * Cuando se declara una variable e inicializa, en tiempo de ejecución se reserva la memoria necesaria
 * para almacenar el valor. La dirección del primer byte será la dirección de la variable.
 *
 * Por ejemplo:
 *
 *  int age = 49
 *
 * variable: age (nombre) ---> 0x100000 (dirección en memoria) --> 49 (valor)
 *
 * Pero podría darse el caso (no en Java) que el dato / valor guardado (en la zona de la memoria indicada por la dirección)
 * sea también una dirección de memoria donde el valor está almacenado.
 *
 * Este dato / valor (una dirección de memoria) se denomina referencia o puntero.
 *
 * Si una variable almacena (no un valor) sino la referencia (o puntero) a donde se encuentra un valor, se
 * la denomina variable referencia o variable puntero.
 *
 * En lenguajes como C o C++ existe la operación para obtener la dirección donde se encuentra el valor --> & (referenciar)
 *
 * int *pointerToAge = &age  // &age es una expresión que devuelve la dirección en memoria de la variable age
 *
 * variable pointerToAge (nombre) ---> 0x200000 (dirección) ----> 0x100001 (valor, la dirección donde está el valor de age)
 *
 * Del mismo modo, exite la operación de desreferenciar (obtener el valor al que apunta una variable referencia) --> *
 *
 * int copy = *pointerToAge
 * // *pointerToAge es una expresión que devuelve el valor obtenido leyendo en la dirección almacenada en la variable pointerToAge
 * // Como la dirección era 0x100001 se habrá leído el valor 49 para inicializar copy
 *
 * variable: copy (nombre) ---> 0x110000 (dirección) --> 49 (valor contenido)
 */