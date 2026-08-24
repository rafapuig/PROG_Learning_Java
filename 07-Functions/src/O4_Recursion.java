/**
 * Nada impide a un función llamarse a si misma
 * <p>
 * Es decir, que en las instrucciones del cuerpo de la función A haya llamadas a la misma función A.
 * <p>
 * Si esto ocurre, se denomina Recursividad.
 * <p>
 * Con la recursividad hay que tener cuidado de no generar un ciclo de llamadas a sí mismo infinito,
 * recursividad infinita, puesto que se termina produciendo un Stack Overflow.
 */

void recursiveWithOverflow() {
    IO.println("Llamando a recursiveWithOverflow()...");
    recursiveWithOverflow();
}

void testRecursiveWithOverflow() {
    recursiveWithOverflow();
}

/**
 * La forma de evitar la recursividad infinita es cortar la recursividad
 * por ejemplo, comprobando sí se cumple una determinada condición para realizar la llamada (o no hacerla)
 * <p>
 * Necesitamos que el código de la función tenga dos ramas,
 * - una será la via recursiva, que conducirá a realizar de nuevo una llamada recursiva (a sí misma) que se apila.
 * - y la otra rama no llamará a la función (por lo que dará la oportunidad de terminar y retornar y desapilar dicha llamada) *
 */

void recursiveFinite(int n) {
    IO.println("Ejecutando recursiveFinite(" + n + ")");
    if (n > 0) {
        IO.println("Llamando a recursiveFinite(" + (n - 1) + ")...");
        recursiveFinite(n - 1);
    } else {
        IO.println("Fin de la recursión!");
    }
    IO.println("Retornando desde la llamada a recursiveFinite(" + n + ") al llamador...");
}

int sum1ToN(int n) {
    if (n == 1) {
        return 1;
    } else {
        return n + sum1ToN(n - 1);
    }
}

int sum1ToN_v2(int n) {
    if (n == 1) return 1;
    return n + sum1ToN_v2(n - 1);
}

void testSum1ToN(int n) {
    IO.println("Llamando a testSum1ToN(" + n + ")");
    var result = sum1ToN(n);
    IO.println(result);
}

void main() {
    //testRecursiveWithOverflow();
    //recursiveFinite(5);
    testSum1ToN(10);
}