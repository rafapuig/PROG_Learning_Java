/**
 * https://docs.oracle.com/en/java/javase/26/docs/specs/jls/jls-4.html#jls-4.2.3

 * Tipos de datos decimales (reales)

 * Es un tipo de datos numérico cuyos valores son números con parte entera y parte decimal

 * En Java tenemos 2 tipos de datos decimales:
 * - float
 * - double

 * Se representan en la memoria en binario mediante 1s y 0s
 * Por tanto, hay que convertir el valor a su formato en binario antes de almacenarlo
 * y volver a reconvertirlo a su valor decimal real para operar, mostrarlo, etc.

 * También se debe conocer la posición del punto decimal.
 * Existen 2 estrategias para almacenar un número real en la memoria del ordenador.
 * 1. FIXED-POINT Asumir que el número de dígitos decimales es fijo y siempre el mismo después del punto decimal.
 * 2. FLOATING_POINT Guardar la posición del punto decimal junto con la representación en binario
 * y que el número de decimales pueda variar (flotar)

 * Las representaciones en punto flotante son:
 * - más lentas
 * - menos precisas
 * --> pero... a cambio,
 * pueden representar un rango más grande de números con la misma cantidad de memoria que el punto fijo.

 * En Java tenemos dos tipos que usan el formato de punto flotante:
 * - float
 * - double

 * NOTA:
 * - NO todos los números reales tienen una representación en binario exacto de su valor,
 * en ese caso, se usan aproximaciones.

 * Java utiliza el estándar IEEE 754 para la representación de punto flotante.
 *
 *
 * NÚMEROS EN PUNTO FLOTANTE
 * ---------------------------------------------------------------------------------------------------
 *
 * Un número decimal en punto flotante se divide en 4 partes:
 * - signo
 * - Mantisa
 * - Base (radix)
 * - exponente
 *
 * Ejemplo:
 * 19.25 --> +19.25 x 10^0 --> +19.25E0
 * - signo: positivo
 * - significando (mantisa): 19.25
 * - base: 10
 * - exponente: 0
 *
 *  Existen infinitas formas de representar la misma cantidad
 *  19.25e0, 1.925e1, 0.1925e2, 192.5e-1, 1925e-2
 *
 *  La forma normalizada en base 10 es la que cumple que:
 *  0.1 <= mantisa < 1
 *
 *  Por tanto, 0.1925e2 es la forma normalizada
 *
 *  En base 2 (binario) el número 19.25 se representa como: 10011.01
 *
 *  1001101 x 2^-2 100110.1 x 2^-1, 10011.01 x 2^0, 1001.101 x 2^1, ... 1.001101 x 2^4 ...
 *
 *  Cuando desplazamos el punto decimal el exponente:
 *  - se decrementa si lo desplazamos hacia la derecha
 *  - se incremente cuando lo desplazamos hacia la izquierda
 *
 *  La forma normalizada en base 2 cumple:
 *  1 <= mantisa < 2
 *
 *  Entonces la mantisa normalizada tiene el formato 1.bbbbbbb... donde b es un dígito binario (1 o 0)
 *
 *  1.001101 x 2^4 es la forma normalizada (empieza por un uno seguido del punto binario y varios dígitos binarios)
 *
 *  NOTA: No todos los números se pueden representar de forma normalizada.
 *  - Números que no tienen ningún 1. Ejemplo, el 0.0
 *  - Hay un número determinado de bits para el exponente
 *  (si el exponente de un número es el mínimo permitido por el formato y la mantisa es <1 no se puede normalizar)
 *  Por ejemplo, -126 sea mínimo exponente y el número es el 0.01101 x 2^-126 porque normalizado
 *  sería 1.101x2^-128, pero -128 es menor que el exponente mínimo.
 *
 *  Ventajas de la normalización:
 *  - Es única
 *  - El punto binario siempre se sitúa después del primer 1, no es necesario almacenar la posición del punto
 *  - 2 números normalizados son fáciles de comparar, mediante sus signos, mantisas y exponentes.
 *  - Siempre se almacenan los dígitos más interesantes de la mantisa
 *  (si tenemos 5 bits para mantisa, con 0.0010110x2^10 solo almacenamos 0.00101 y perdemos el 10 final,
 *  pero si normalizamos a 1.0110x2^7 podemos almacenar sus 5 bits a 1
 *  - En la forma normalizada la mantisa siempre empieza por 1
 *  (y, por tanto, no hace falta gastar un bit para almacenarlo, el hidden bit)
 *
 *  Estándares del IEEE 754:
 *  - 32 bit single-precision floating point format --> Java lo usa para el tipo float
 *  - 64 bit double-precision floating point format --> Java lo usa para el tipo double
 */

void main() {
    float x = 1.5f;
    float y = 0.25E-2f;

    double d = 0.1;
    double z = 0x1P-1023;
}