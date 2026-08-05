/**
 * https://docs.oracle.com/en/java/javase/26/docs/specs/jls/jls-4.html#jls-4.2.3
 *
 * Tipos de datos decimales (reales)
 * <p>
 * Es un tipo de datos numérico cuyos valores son números con parte entera y parte decimal
 * <p>
 * En Java tenemos 2 tipos de datos decimales:
 * - float <--
 * - double
 * <p>
 * Se representan en la memoria en binario mediante 1s y 0s
 * Por tanto, hay que convertir el valor a su formato en binario antes de almacenarlo
 * y volver a reconvertirlo a su valor decimal real para operar, mostrarlo, etc.
 * <p>
 * También se debe conocer la posición del punto decimal.
 * Existen 2 estrategias para almacenar un número real en la memoria del ordenador.
 * 1. FIXED-POINT Asumir que el número de dígitos decimales es fijo y siempre el mismo después del punto decimal.
 * 2. FLOATING_POINT Guardar la posición del punto decimal junto con la representación en binario
 * y que el número de decimales pueda variar (flotar)
 * <p>
 * Las representaciones en punto flotante son:
 * - más lentas
 * - menos precisas
 * --> pero... a cambio,
 * pueden representar un rango más grande de números con la misma cantidad de memoria que el punto fijo.
 * <p>
 * En Java tenemos dos tipos que usan el formato de punto flotante:
 * - float
 * - double
 * <p>
 * NOTA:
 * - NO todos los números reales tienen una representación en binario exacto de su valor,
 * en ese caso, se usan aproximaciones.
 * <p>
 * Java utiliza el estándar IEEE 754 para la representación de punto flotante.
 */

void main() {
    float x = 1.5f;
    float y = 0.25E-2f;

    double d = 0.1;
    double z = 0x1P-1023;
}