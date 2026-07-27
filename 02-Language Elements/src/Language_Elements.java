/**
 * El código fuente escrito en un lenguaje de programación basado en texto
 * se compone de una serie continua de caracteres a interpretar por el compilador del lenguaje
 *
 * Por tanto, la primera tarea de la compilación es analizar la estructura léxica:
 * - A partir de los caracteres que confirman el texto del código fuente,
 * identificar los distintos elementos
 * (este proceso se denomina tokenización) y da como resultado 3 tipos de elementos.
 *
 * En el lenguaje Java tenemos 3 tipos de elementos principales:
 * 1. Espacio en blanco (White Space)
 * 2. Comentario (Comment)
 * 3. Token (los más importantes, los que aportan la información y contenido)
 *
 * Los espacios en blanco (y los comentarios) cumplen la función de separar los tokens.
 * (Igual que en un idioma escrito los espacios separan el texto en palabras, que serían
 * el equivalente a los tokens de un código fuente escrito en un lenguaje de programación)
 *
 * Ejemplos:
 * 1 5 --> Serían dos tokens: el literal 1 y el literal 5 separados por un espacio
 * 15 --> Sería un solo token: el literal 15
 * var x --> Son dos tokens: la keyword contextual var y el identificador x
 * int y=10 --> son 4 tokens: int, y, =, 10 (a veces no es necesario espacio para delimitar tokens)
 *
 * Se considera un espacio en blanco no solo el caracter espacio, además de este:
 * - el tabulador
 * - el final de línea (salto de línea)
 */

/**
 * TOKEN
 *
 * Existen 5 tipos de tokens:
 * 1. Separador
 * 2. Operador
 * 3. Identificador
 * 4. Keyword (palabra clave o reservada)
 * 5. Literal (valores directamente representados en el código de tipo primitivo, String, o nulo)
 *
 * 1. Separadores
 *
 * Aunque no haya espacio separan tokens entre sí.
 *
 * En Java existen 12 tokens que se consideran separadores:
 * ( ) --> Los paréntesis
 * { } --> Las llaves
 * [ ] --> Los corchetes
 *  ;  --> El punto y coma
 *  .  --> El punto
 *  ,  --> La coma
 * ... --> Los 3 puntos (puntos suspensivos)
 *  @  --> La arroba {at}
 * ::  --> Dos puntos doble
 *
 *
 * 2. Operadores
 *
 * Un operador es un símbolo (token)
 * para indicar que se quiere realizar un tipo de operación específico (dependiendo del operador)
 * sobre 1, 2 o 3 operandos y que producirá un resultado
 *
 * En Java tenemos 38 operadores
 *
 * 2.1 Aritméticos (7):
 *  + --> Suma (también significa concatenar textos y positivo)
 *  - --> resta (y también inversión a negativo)
 *  * --> multiplicación
 *  / --> división (entera y real)
 *  % --> resto de una division entera (también se denomina módulo)
 *  ++ --> incremento en una unidad
 *  -- --> decremento en una unidad
 *
 *  2.2 Asignación y compuestos (asignación + aritmético) [6]
 *  = --> asignación (no es el comparador de igualdad!!!)
 *  += --> sumar y asignar
 *  -= --> restar y asignar
 *  *=
 *  /=
 *  %=
 *
 *  2.3 Relacionales (comparan operandos y su resultado es un valor lógico) [6]
 *  == --> Comparador de igualdad
 *  != --> distinto de (no igual que, lo contrario de ==)
 *  >  --> mayor que
 *  <  --> menor que
 *  >= --> mayor o igual que (lo contrario de <)
 *  <= --> menor o igual que (lo contrario de >)
 *
 *  2.4 Lógicos (combinan otros valores lógicos) [7]
 *  && --> AND cortocircuitada (y & sin cortocircuito)
 *  || --> OR cortocircuitado (y | sin cortocircuitar)
 *  ! --> NOT
 *  ^ --> OR exclusivo
 *  &= AND con asignación
 *  |= OR con asignación
 *  ^= XOR con asignación
 *
 *  2.5 Operadores con bits (trabajan sobre valores enteros) [9]
 *  & --> AND bit a bit
 *  | --> OR bit a bit
 *  ^ --> XOR bit a bit (se repite, pero ahora a nivel de bit para operandos enteros)
 *  ~ --> NOT bit a bit (complemento a 1)
 *  << --> Desplazamiento de los bits hacia la izquierda
 *  >> --> Desplazamiento de los bits hacia la derecha (con signo)
 *  >>> --> Desplazamiento de los bits hacia la derecha sin signo
 *  &=, !=, ^= (se repiten, pero ahora a nivel de bit)
 *  <<= compuesto de desplazamiento y asignación
 *  >>=
 *  >>>=
 *
 *  2.6 Otros [3]
 *  ? junto con : para indicar los operandos del operador ternario
 *  -> expresiones lambda
 *
 */