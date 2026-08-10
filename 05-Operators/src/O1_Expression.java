/**
 * EXPRESIÓN
 * Es una serie de literales, variables, operadores y llamadas a métodos
 * construidos siguiendo las reglas de la gramática del lenguaje de programación.
 *
 * Constituyen una de las piezas de construcción de un programa.
 *
 * Reglas más importantes:
 *
 * Expresión --> literal
 * Expresión --> variable (de la que se leerá su contenido)
 * Expresión --> llamada_a_función (de la que se usará el valor que retorne)
 * Expresión --> operador_unario_prefijo <expresión>
 * Expresión --> <expresión> operador_unario_postfijo
 * Expresión --> <expresion_izquieda> operador_binario <expresion_derecha>
 * Expresión --> ( <expresion> )
 *
 * Un lvalue es un almacén de datos, un elemento donde se puede escribir información, una variable en sentido amplio.
 *
 * A las expresiones también se las conoce como rvalues.
 *
 * Las expresiones cuando se evalúan (en tiempo de ejecución) pueden dan como resultado:
 * - un valor (rvalue)
 * - una variable (lvalue)
 * - nada
 *
 * Las expresiones SIEMPRE tienen tipo, y este se obtiene por el compilador (en tiempo de compilación)
 * (el tipo de una llamada a función que no devuelve nada es void)
 *
 */

void main() {
    // En la llamada a la función le pasamos como argumento una expresión
    IO.println(25); // expresión literal de tipo int
    IO.println("Hola Mundo"); // expresión literal de tipo String

    var name = "Aitor Tilla";
    IO.println(name); // La expresión es una variable de tipo String (la expresión es, por tanto, de tipo String)

    var age = 46;
    IO.println(age); // La expresión es una variable de tipo int (la expresión es, por tanto, de tipo int)

    IO.println(Math.random()); // La expresión es una llamada a la función random de Math que devuelve un double, tipo dpouble

    IO.println("Hola, " + name); // La expresión es una operación de concatenación mediante el operador binario +
    // Sus operandos son dos expresiones: el literal "Hola, " y la variable name

    IO.println(name + " tiene " + age + " años"); // Expresión a base de operadores, literales variables

    // Expresión a base de literales (100, 1), operadores (+, *) y llamadas a función Math.random() y Math.floor(double).
    IO.println(Math.floor(Math.random() * 100) + 1);

    IO.println(age++);
    IO.println(age--);
    IO.println(++age);
    IO.println(--age);
    IO.println(~age);
    IO.println(~5);

    // La expresión IO.println() da como resultado void, por eso no se puede usar como argumento de llamada.
    // IO.println(IO.println());

}