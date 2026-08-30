/**
 * Supongamos que el profesor pide a los alumnos que levanten las manos dependiendo de su edad.
 * Quiere encontrar ....
 */

void testAgeConditions(int age) {

    // 1) alumnos entre 9 y 12
    boolean between9and12 = age >= 9 && age <= 12;

    // 2) alumnos menores de 8 años y alumnos mayores de 11 (el y es una trampa!!!)
    boolean under8orOver11 = age < 8 || age > 11;

    // 3) alumnos de 8, 10, y 12 años
    boolean aged8_10_or_12 = age == 8 || age == 10 || age == 12;

    // 4) alumnos entre 6 y 8 años y entre 10 y 12 años
    boolean between6and8or10and12 = age >= 6 && age <= 8 || age >= 10 && age <= 12;

    // 5) alumno que ni tiene 10 ni 12 años
    boolean neither10nor12 = age != 10 && age != 12;

    // Este último caso se corresponde con las Leyes de De Morgan que dicen:
    // not (A or  B) = not A and not B <-- negación de la disyunción
    // not (A and B) = not A or  not B <-- negación de la conjunción

    // Ejemplo: A == guapo, B = rico
    //  si no es alto y guapo = no es alto o no es guapo
    //  si no es blanco o azul = no es blanco y no es azul
    // es leche si --> es blanco y en botella ==> no puede ser leche si --> no es blanco o no está en botella
    // se muere si --> no come o no bebe ==>  no se muere si --> come y bebe
    // aprovecha el tiempo si --> estudia o trabaja ==> no aprovecha el tiempo si --> no estudia y no trabaja

    boolean notAged10or12 = !(age == 10 || age == 12);
}

void negatingConditionsExample(int x, int y) {

    boolean condition = x > 5 && y == 3;

    // Primera forma de negar la condición, usando el operador ! aplicado mediante parenthesis a toda la expresión
    // /porque el operador lógico ! tiene mayor preferencia que los comparadores)
    boolean negateCondition1 = !(x > 5 && y == 3);

    // Segunda forma (leyes de De Morgan) cambiar && por || y cambiar los > por <= y == por !=
    boolean negateCondition2 = x <= 5 || y != 3;
}


/**
 * Niega las siguientes expresiones booleanas (condiciones)
 * a) utilizando el operador !
 * b) simplification con alguna ley o técnica
 */

void negateConditionExercises(int a, int b, int x, boolean n) {

    boolean condition1 = b != 4;
    boolean condition2 = a * 3 + 2 > 0;
    boolean condition3 = !(a == 5 && b >= 7);
    boolean condition4 = n == true;
    boolean condition5 = b > 7 && !(x > 4);
    boolean condition6 = a == 4 || b != 2;

    boolean negateCon1a = !(b != 4);
    boolean negateCon1b = b == 4;

    boolean negateCon2a = !(a * 3 + 2 > 0);
    boolean negateCon2b = a * 3 + 2 <= 0;

    boolean negateCon3a = !!(a == 5 && b >= 7);
    boolean negateCon3b = a == 5 && b >= 7;

    boolean negateCon4a = !(n == true);
    boolean negateCon4b = n != true;
    boolean condition4OK = n;
    boolean negateCon4OK = !n;

    boolean negateCon5a = !(b > 7 && !(x > 4));
    boolean negateCon5b = b >= 7 || x > 4;

    boolean negateCon6a = !(a == 4 || b != 2);
    boolean negateCon6b = a != 4 && b == 2;
}

void shakespeare(boolean toBe) {
    boolean thaIsTheQuestion = toBe || !toBe; // Siempre es true
}

void negateWithoutNotOperator(int x, int y, int z) {
    boolean cond1 = x == 4 && y != 3;
    boolean cond2 = x + 4 <= 0;
    boolean cond3 = !(x >= 4 || z > 4);

    boolean negCond1 = x != 4 || y == 3;
    boolean negCond2 = x + 4 > 0;
    boolean negCond3 = x > 4 && z <= 4;

}


void main() {

}