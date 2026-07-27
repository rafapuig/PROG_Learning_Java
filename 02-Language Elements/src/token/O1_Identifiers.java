/**
 * IDENTIFICADOR
 * Nombre técnico para el término "nombre"
 * En programación un identificador cumple la función
 * de identificar (de forma única en un contexto)
 * un elemento (entidad) definida dentro de un código de programa.
 * "Ser el nombre de algo"
 *
 * El elemento (entidad) se declara y define (una vez)
 * - Se declara (se indica que va a existir algo y que se llamará así)
 * - Se define (se definen y describen sus caracteristicas)
 *
 * El elemento (entidad) se puede usar posteriormente varias veces
 * - Se usa haciendo referencia al este mediante su nombre idenficador
 * - Por eso es importante identificarlo mediante un nombre (identificador)
 *
 *
 * ¿De qué elementos (entidades) estamos hablando?
 * Variables, funciones, clases, tipos, interfaces, parametros, módulos, etc.
 *
 *
 * Buenas prácticas de la industria
 * - En general se recomienda que los nombres de los elementos de un programa
 * sean en inglés.
 * - Si identificamos una cosa usar sustantivos: User, name, day, year, etc.
 * - Si nombramos una action usar verbos: get, print, compute, add, remove, etc.
 *
 * NOTA: Quizá lo más importante de programar sea escoger un buen nombre
 * para identificar un elemento del programa.
 *
 */

/**
 * Ejemplo de uso de un identificador
 * Si vamos a guardar un valor (de un tipo)
 * Necesitamos identificar el almacén (lugar en la memoria) donde lo guardamos
 * para posteriormente poder buscar por su nombre identificador
 * donde se encuentra almacenado y proceder a leer y recuperarlo
 * Nota: Este almacén se denomina de manera general VARIABLE
 */

/**
 * Identificadores en Java
 * // https://docs.oracle.com/en/java/javase/26/docs/specs/jls/jls-3.html#jls-3.8
 *
 * En Java, un identificador consiste en:
 * - Una secuencia de CARACTERES Unicode de longitud ilimitada
 * - La secuencia solo puede incluir:
 *      - LETRAS (y asimilados como letras en Java)
 *          - A..Z y a..z y cualquiera Unicode (ñ, ç, ...)
 *          - El carácter de subrayado _ (underscore)
 *          - El $
 *      - DIGITOS 0..9
 *  - No puede empezar por DIGITO
 *
 *  OJO: Algunas combinaciones tampoco se consideran válidas:
 *  - Si coinidice con una palabra reservada del lenguaje --> https://docs.oracle.com/en/java/javase/26/docs/specs/jls/jls-3.html#jls-ReservedKeyword
 *  - Valor literal de tipo booleano (lógico): true o false --> https://docs.oracle.com/en/java/javase/26/docs/specs/jls/jls-3.html#jls-BooleanLiteral
 *  - Valor literal del tipo nulo: null --> https://docs.oracle.com/en/java/javase/26/docs/specs/jls/jls-3.html#jls-NullLiteral
 *
 *  NOTA ADICIONAL: Incluso dependiendo de lo que se vaya a identificar
 *  - Un tipo de dato definido por el usuario:
 *      - no se permiten --> record, sealed, var, o yield
 *  - Métodos
 *      - no se permite yield en llamadas no cualificadas
 */

// Válido en identificadores de variables
int record = 4;
int var = 6;
int yield = 8;
int sealed = 10;

/* No válidos en identificadores de tipos */
// class var {}
// class record {}
//interface yield {}
//enum sealed {}

/* Si le pongo el nombre yield a un método (función)
   Luego tendré problemas para llamarla (usarla) */
void yield() { }

void callYieldMethod() {
    this.yield(); // Si la cualifico la puedo usar
    //yield(); // Sin cualificar no se puede usar
}


void main() {
    // Un identificador puede empezar por el carácter dígito 1
    IO.println(Character.isJavaIdentifierStart('1'));
    // El digito 1 puede formar parte de un identificador en Java
    IO.println(Character.isJavaIdentifierPart('1'));

    IO.println(Character.isJavaIdentifierPart('.'));
    IO.println(Character.isJavaIdentifierPart(':'));
    IO.println(Character.isJavaIdentifierPart('-'));
    IO.println(Character.isJavaIdentifierPart('%'));

    // Un identificador puede empezar por el $?
    IO.println(Character.isJavaIdentifierPart('$')); // true
    // Un identificador puede usar el $ como carácter?
    IO.println(Character.isJavaIdentifierPart('$'));

    // Un identificador puede empezar por el carácter ñ
    IO.println(Character.isJavaIdentifierStart('ñ')); // true
    IO.println(Character.isJavaIdentifierPart('ñ')); // true
}