/**
 * Escribe una función recursiva con nombre factorial que recibe un valor double como argumento
 * y calcula y devuelve su factorial.
 * (El factorial de un número n es el resultado de multiplicar todos los números desde 1 hasta n)
 * <p>
 * Usando la función factorial, escribe una función recursiva de nombre cosine que calcule y devuelva
 * el valor del coseno usando la serie de Taylor.
 * <p>
 * coseno(x) = 1- x^2/2! + x^4/4! - x^6/6! + ...
 * <p>
 * Pista : x^0/0! = 1
 *
 */

/**
 * Número máximo del que se puede calcular el valor del factorial mediante el tipo double
 */
final int MAX_FACTORIAL_N = 170;

double factorial(double number) {
    if (number == 0) return 1;
    else return number * factorial(number - 1);
}

double taylorTerm(double x, int n) {
    return Math.pow(x, n) / factorial(n);
}

double cosineRecursive(double angleInRadians) {
    return cosineRecursive(angleInRadians, MAX_FACTORIAL_N / 2);
}

double cosineRecursive(double angleInRadians, int toTerm) {
    if (toTerm == 0) return 1.0;
    final double sign = (toTerm % 2 == 0) ? 1.0 : -1.0;
    final double term = sign * taylorTerm(angleInRadians, toTerm * 2);
    //IO.println("Cosine term (" + toTerm + "): " + term);
    return term + cosineRecursive(angleInRadians, toTerm - 1);
}


double cosineIterative(double angleInRadians) {
    return cosineIterative(angleInRadians, MAX_FACTORIAL_N / 2);
}

double cosineIterative(double angleInRadians, int toTerm) {
    double result = 0.0;
    for (int i = 0; i < toTerm; i++) {
        final double sign = (i % 2 == 0) ? 1.0 : -1.0;
        final double term = sign * taylorTerm(angleInRadians, i * 2);
        result += term;
    }
    return result;
}

double cosine(double angleInRadians) {
    return cosineRecursive(angleInRadians, MAX_FACTORIAL_N / 2);
    //return cosineIterative(angleInRadians, MAX_FACTORIAL_N);
}

double degreesToRadians(double degrees) {
    return degrees * Math.PI / 180;
}

void main() {
    IO.println(factorial(MAX_FACTORIAL_N));
    IO.println(cosineRecursive(Math.PI / 4));
    IO.println(cosineIterative(Math.PI / 4));
    IO.println(Math.cos(Math.PI / 4));
}