/**
 * Tipo de dato (tipo)
 *
 * Se define en terminos de 3 componentes:
 * - Un cojunto de valores
 * - Un conjunto de operaciones aplicables a los valores
 * - Una representación que determina como se almacena un valor en memoria
 *
 *
 * Un lenguaje de programación
 * - proporciona algunos tipos de datos predefinidos (built-in data type)
 * - permite definir nuevos tipos de datos (User defined data type)
 *
 *
 * Tipos de datos primitivos
 * Consiste en un valor atómico (indivisible)
 *
 *
 * Tipos de datos definidos por el usuario (el programador)
 * Se definen en terminos de combinar tipos primitivos
 * y otros tipos de datos definidos por el usuario
 */

/** Tipos primitivos en Java
 *
 * Java tiene 8 tipos de datos primitivos
 *
 * Se dividen en 2 categorias principales:
 *  - booleanos
 *  - numéricos
 *
 * Los tipos de datos numéricos se subdividen a su vez en:
 *  - Integrales
 *  - Punto flotante (floating point)
 *
 * Los tipos integrales son:
 *  - byte
 *  - short
 *  - int
 *  - long
 *  - char
 *
 * Y los tipos de punto flotante:
 *  - float
 *  - double
 *
 *
 * El tipo booleano es boolean
 */

/**
 * Literales
 *
 * Un literal de tipo X es un valor del tipo X que puede ser representado directamente en el código fuente
 * sin que se requiera realizar ningún cálculo.
 *
 * Ejemplos;
 * 10 es un literal del tipo int
 * true es un literal del tipo boolean
 *
 * Java define literales para todos los tipos primitivos además de para el tipo String y el tipo nulo.
 *
 */

/**
 * Ejemplo, el tipo int
 * - Conjunto de valores enteros comprendidos entre -2.147.483.648 y el 2.147.483.647
 * - Conjunto de operaciones:
 *      - aritméticas: suma, resta, multiplicación, división, módulo,
 *      - relacionales: comparaciones > < <= >= != ==,
 *      - a nivel de bit ...
 * - Se representa en memoria mediante 32 bits en complemento a 2
 */

void main() {
    IO.println(10); // Valor de tipo entero
    IO.println(10L); // Valor de tipo long (entero largo)
    IO.println(true); // Valor booleano (lógico) V o F
    IO.println(10.5f); // Valor de tipo float
    IO.println('1'); // Valor de tipo caracter
    IO.println("10"); // Valor de tipo String (cadena de caracteres)
}