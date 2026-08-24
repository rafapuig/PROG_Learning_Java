/**
 * La función main (principal) es el punto de entrada
 * para comenzar la ejecución de una aplicación
 */
void main() {
    /* Esto es un comentario de multiples líneas (o entre líneas) */
    // IO.println es una función para imprimir en la consola
    IO.println("Welcome to JAVA"); // Esto es un comentario hasta final de línea
}

/*
- void main() es la declaración de una función de nombre `main` (en otro contexto también se le denomina método)
- void es una keyword (palabra clave) del lenguaje que indica `el vacío` (porque main no retorna nada)
- main es un identificador que da nombre a la función declarada
- () parantesis que sirven para indicar que main es una función (dentro irían posibles parámetros)
- Los separadores { y } encierran (encapsulan) el contenido o cuerpo de la función
  es decir, el conjunto (bloque) de instrucciones a ejecutar por la función cuando es invocada.
- IO.println("Welcome to JAVA") es una instrucción (la única en este caso del cuerpo de la función main),
  en este caso concreto una llamada a una función, y se delimita mediante el separador ;
- El separador ; se usa para separar y delimitar cierto tipo de instrucciones.
- "Welcome to JAVA" es un valor literal de tipo String (cadena de caracteres) por eso, va encerrado entre "
- IO agrupa una colección de métodos relacionados con la entrada y salida (I de Input y O de Output)
- println es un método (función) de la colección IO
                   que imprime un texto
                   y además un salto de linea (print + ln)
  lo que hacemos en la instrucción es invocarlo (llamarlo), es decir, solicitar que se ejecuten
  las instrucciones contenidas en su cuerpo
 */

/* Comentarios */
// https://docs.oracle.com/en/java/javase/26/docs/specs/jls/jls-3.html#jls-3.7