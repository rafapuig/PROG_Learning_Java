/**
 * 1) Escribe una función iterativa con nombre factorial que recibe un valor double como argumento
 * y calcula y devuelve su factorial.
 * (El factorial de un número n es el resultado de multiplicar todos los números desde 1 hasta n)
 * <p>
 * 2) Usando la función factorial, escribe una función iterativa de nombre sine que calcule y devuelva
 * el valor del seno de un ángulo expresado en radianes usando la serie de Taylor.
 * <p>
 * seno(x) = x - x^3/3! + x^5/5! - x^7/7! + ...
 * <p>
 * Pista : x^1/1! = x
 *
 * 3) Escribe una función con nombre degreesToRadians que acepte un ángulo expresado en grados
 * mediante un parámetro de entrada degrees de tipo double y devuelva su valor equivalente en radianes
 *  2 * PI = 360º
 *     r   =   xº
 *
 *     r =  x * 2 * PI / 360 = x * PI / 180
 */

/**
 * Número máximo del que se puede calcular el valor del factorial mediante el tipo double
 */
final int MAX_FACTORIAL_N = 170;

double factorial(double number) {
    double result = 1.0;
    for (int i = 1; i <= number; i++) {
        result = result * i;
    }
    return result;
}

double taylorTerm(double x, int n) {
    return Math.pow(x, n) / factorial(n);
}

double sineRecursive(double angleInRadians) {
    return sineRecursive(angleInRadians, MAX_FACTORIAL_N);
}

double sineRecursive(double angleInRadians, int toTerm) {
    if (toTerm == 0) return angleInRadians;
    final double sign = (toTerm % 2 == 0) ? 1.0 : -1.0;
    final double term = sign * taylorTerm(angleInRadians, toTerm * 2 + 1);
    //IO.println("Sine term (" + toTerm + "): "  + term);
    return term + sineRecursive(angleInRadians, toTerm - 1);
}


double sineIterative(double angleInRadians) {
    return sineIterative(angleInRadians, MAX_FACTORIAL_N);
}

double sineIterative(double angleInRadians, int toTerm) {
    double result = 0.0;
    double sign = 1.0;
    for (int i = 0; i < toTerm; i++, sign *= -1.0) {
        final int n = i * 2 + 1;
        final double term = sign * Math.pow(angleInRadians, n) / factorial(n);
        result += term;
    }
    return result;
}

double degreesToRadians(double degrees) {
    return degrees * 2 * Math.PI / 360;
    //return degrees * Math.PI / 180;
}


void main() {
    IO.println(factorial(170));
    IO.println(sineRecursive(Math.PI / 4));
    IO.println(sineIterative(Math.PI / 4));
    IO.println(Math.sin(Math.PI / 4));

    IO.println(degreesToRadians(180));
    IO.println(Math.toRadians(180));

    IO.println(sineRecursive(degreesToRadians(45)));
    IO.println(sineIterative(degreesToRadians(45)));
    IO.println(Math.sin(degreesToRadians(45)));
}