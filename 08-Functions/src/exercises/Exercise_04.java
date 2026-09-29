/**
 * 1) Escribe una función con nombre isLeapYear que reciba un año mediante un parámetro de entrada de tipo entero
 * y devuelva true o false dependiendo de si el año se considera bisiesto o no.
 * <p>
 * 2) Escribe una función con nombre numDays que acepte un mes y un año y devuelva el número de días de ese mes
 * para ese año. Si el mes es febrero y el año es bisiesto la función debe devolver 29.
 * Pista: Usa la función isLeapYear
 * <p>
 * 3) Escribe una función checkDate, que reciba un día, un mes, y un año y compruebe si la fecha es válida o no.
 * <p>
 * 4) Escribe un programa que pida al usuario que introduzca una fecha (día, mes y año) y calcule los días que
 * han pasado desde que empezó ese año hasta la el día de la fecha introducida.
 * Debe validar la fecha introducida, y mostrar un mensaje de error cuando la fecha no sea válida.
 * Se debe volver a pedir al usuario la fecha hasta que la fecha inntroducida sea válida.
 */

boolean isLeapYear(int year) {
    return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
}

int numDays(int month, int year) {
    return switch (month) {
        case 1, 3, 5, 7, 8, 10, 12 -> 31;
        case 2 -> 28 + (isLeapYear(year) ? 1 : 0);
        case 4, 6, 9, 11 -> 30;
        default -> throw new IllegalArgumentException("Mes incorrecto: " + month);
    };
}

boolean checkDate(int day, int month, int year) {
    if (month < 1 || month > 12) return false;
    return day <= numDays(month, year);
}

void testIsLeapYear() {
    final String errorMessage = "Año bisiesto incorrecto";
    assertTrue(!isLeapYear(2026), errorMessage); // false
    assertTrue(isLeapYear(2028), errorMessage); // true
    assertTrue(isLeapYear(2000), errorMessage); // true
    assertTrue(!isLeapYear(1900), errorMessage); // false
    assertTrue(!isLeapYear(1999), errorMessage); // false
}

void assertTrue(boolean condition, String message) {
    if (!condition) {
        IO.println(message);
    }
}

void assertEquals(int result, int expected, String errorMessage) {
    if (result != expected) {
        IO.println(errorMessage);
    }
}

void testNumDays() {
    final String errorMessage = "Número de días incorrecto";
    assertEquals(numDays(2, 2026), 28, errorMessage);
    assertEquals(numDays(2, 2028), 29, errorMessage);
    assertEquals(numDays(2, 2000), 29, errorMessage);
    assertEquals(numDays(2, 1900), 28, errorMessage);
    assertEquals(numDays(1, 2026), 31, errorMessage);
    assertEquals(numDays(3, 2026), 31, errorMessage);
    assertEquals(numDays(4, 2026), 30, errorMessage);
    assertEquals(numDays(5, 2026), 31, errorMessage);
    assertEquals(numDays(6, 2026), 30, errorMessage);
    assertEquals(numDays(7, 2026), 31, errorMessage);
    assertEquals(numDays(8, 2026), 31, errorMessage);
    assertEquals(numDays(9, 2026), 30, errorMessage);
    assertEquals(numDays(10, 2026), 31, errorMessage);
    assertEquals(numDays(11, 2026), 30, errorMessage);
    assertEquals(numDays(12, 2026), 31, errorMessage);
}

void testCheckDate() {

    assertTrue(checkDate(29, 2, 2000), "Fallo en checkDate(29, 2, 2000)");
    assertTrue(!checkDate(29, 2, 2026), "Fallo en checkDate(29, 2, 2026)");
    assertTrue(!checkDate(29, 13, 2026), "Fallo en checkDate(29, 13, 2026)");
}


int day, month, year;

void readDate() {
    boolean isValid = false;
    do {
        try {
            String input = IO.readln("Introduce el dia: ");
            day = Integer.parseInt(input);
            input = IO.readln("Introduce el mes: ");
            month = Integer.parseInt(input);
            input = IO.readln("Introduce el año: ");
            year = Integer.parseInt(input);

            isValid = checkDate(day, month, year);
            if (!isValid) IO.println("Fecha introducida no válida!");

        } catch (NumberFormatException e) {
            IO.println("Por favor, introduce un numero válido");
        }
    } while (!isValid);
}


void tests() {
    testIsLeapYear();
    testNumDays();
    testCheckDate();
}

String formatDate(int day, int month, int year) {
    return String.format("%02d/%02d/%04d", day, month, year);
}


void main() {

    readDate();

    int days = 0;
    for (int i = 1; i < month; i++) {
        days += numDays(i, year);
    }
    days += day;

    String formattedDate = formatDate(day, month, year);

    IO.println("Días trascurridos desde principio del año hasta el " + formattedDate + ": " + days);
}