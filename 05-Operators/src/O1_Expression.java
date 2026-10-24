/**
 * EXPRESIÓN
 * -----------------------------------------------------------------------------------------------------------
 * Es una serie de literales, variables, operadores y llamadas a métodos
 * construidos siguiendo las reglas de la gramática del lenguaje de programación.
 *
 * Constituyen una de las piezas de construcción de un programa.
 *
 * Reglas gramaticales más importantes:
 *
 * Expresión --> literal
 * Expresión --> variable (de la cual se leerá y obtendrá su contenido como valor de la expresión)
 * Expresión --> llamada_a_función (de la que se usará el valor que retorne)
 * Expresión --> operador_unario_prefijo <expresión>
 * Expresión --> <expresión> operador_unario_postfijo
 * Expresión --> <expresion_izquieda> operador_binario <expresion_derecha>
 * Expresión --> ( <expresion> )
 * Expresión --> (tipo_casting) <expresion>
 *
 * Un lvalue es un almacén de datos,
 * un elemento donde se puede escribir información, una variable en sentido amplio.
 *
 *
 * Las expresiones cuando se evalúan (en tiempo de ejecución) pueden dar como resultado:
 * - un valor (rvalue)
 * - una variable (lvalue)
 * - nada
 *
 * Las expresiones SIEMPRE tienen tipo, y este se obtiene por el compilador (en tiempo de compilación)
 * (el tipo de una llamada a función que no devuelve nada es void)
 */

void main() {

    /** En una llamada a una función pasamos como argumento una expresión */
    IO.println(25); // expresión -> literal de tipo int
    IO.println("Hola Mundo"); // expresión -> literal de tipo String

    var name = "Aitor Tilla"; // La variable name se inicializa mediante un literal de tipo String, por tanto, tipo String
    IO.println(name); // La expresión es una variable de tipo String (la expresión es, por tanto, de tipo String)

    var age = 46; // La variable age se inicializa mediante un literal de tipo int, por tanto, tipo de age es int
    IO.println(age); // La expresión es una variable de tipo int (la expresión es, por tanto, de tipo int)

    // La expresión es una llamada a la función random de Math que devuelve un double, tipo double
    IO.println(Math.random());

    // La expresión es una operación de concatenación mediante el operador binario +
    // Sus operandos son dos expresiones: el literal "Hola, " y la variable `name`
    IO.println("Hola, " + name);

    // Expresión a base de operadores, literales variables
    IO.println(name + " tiene " + age + " años");

    // Expresión compuesta a base de literales (100, 1), operadores (+, *)
    // y llamadas a función Math.random() y Math.floor(double).
    IO.println(Math.floor(Math.random() * 100) + 1);

    IO.println(age++);
    IO.println(age--);
    IO.println(++age);
    IO.println(--age);
    IO.println(~age);
    IO.println(~5);

    // La expresión IO.println() da como resultado void, por eso no se puede usar como argumento de llamada.
    // IO.println(IO.println()); // ERROR

}