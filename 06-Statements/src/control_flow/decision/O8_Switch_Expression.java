/**
 * Expresión Switch
 * <p>
 * Existe una version de la estructura switch que funciona como una expresión que devuelve un valor cuando se evalúa
 * (y que podemos usar allí donde se pueda usar una expresión del tipo de datos esperado)
 * <p>
 * La sintaxis cambia respecto a la instrucción switch:
 * - cada etiqueta va seguida de -> y:
 * - una expresión
 * - una instruccion throw que lanza una excepción (ya veremos las exepciones)
 * - un bloque de instrucciones {}
 * - dentro del bloque se utiliza la instruccion yield para espeficar el valor devuelto para esa etiqueta
 * <p>
 * Cada case puede usar más de una etiqueta separada por comas.
 *
 * Los case, junto con el default deben cubrir todos lo valores posibles (por eso casi siempre es necesario el default)
 */


void ejemplo1() {
    String weekDay = "lunes";
    boolean isWeekend = switch (weekDay) {
        case "sabado", "domingo" -> true;
        default -> false;
    };
    IO.println("El " + weekDay + " se considera fin de semana? " + (isWeekend ? "Si" : "No"));
}

void ejemplo2() {
    String weekDay = "viernes";
    boolean isWeekend = switch (weekDay) {
        case "sabado", "domingo" -> true;
        case "lunes", "martes", "miercoles", "jueves", "viernes" -> false;
        default -> throw new RuntimeException(weekDay + " no es un dia de la semana valido!");
    };
    IO.println("El " + weekDay + " se considera fin de semana? " + (isWeekend ? "Si" : "No"));
}

void ejemplo3() {

    String weekDay = "domingo";

    boolean isWeekend = switch (weekDay) {
        case "sabado", "domingo" -> true;
        case "lunes", "martes", "miercoles", "jueves", "viernes" -> false;
        default -> throw new RuntimeException(weekDay + " no es un dia de la semana valido!");
    };
    IO.println("El " + weekDay + " se considera fin de semana? " + (isWeekend ? "Si" : "No"));
}

void ejemplo4() {

    int nota = 5;

    String resultado = switch (nota) {
        case 10, 9 -> "Sobresaliente";
        case 8, 7 -> "Notable";
        case 6 -> "Aprobado";
        case 5 -> {
            IO.println("Justo aprobado");
            yield "Aprobado";
        }
        default -> {
            IO.println("Hay que recuperar");
            yield "Suspenso";
        }
    };

    IO.println(resultado);
}


/**
 * En este ejemplo me repito a mí mismo, en cada etiqueta hago lo mismo, llamar a IO.println
 */
void ejemploForecastSwitchStatement() {
    String forecast = "Soleado";

    switch (forecast) {
        case "Soleado":
            IO.println("Sal de casa y aprovecha"); // Llamo a IO.println
            break;
        case "Lluvia":
            IO.println("No te olvides el paraguas"); // Llamo a IO.println
            break;
        case "Nublado":
            IO.println("No te hace falta ponerte protector solar"); // Llamo a IO.println
            break;
        default:
            IO.println("No te puedo aconsejar"); // Llamo a IO.println
            break;
    }
}

/**
 * Solución parcial, para no repetir la llamada a IO.println
 * Pero aun así, nos repetimos en algo, estamos asignado todo el tiempo a la misma variable message
 */
void ejemploForecastSwitchStatementDRY() {
    String forecast = "Soleado";

    String message;

    switch (forecast) {
        case "Soleado":
            message = "Sal de casa y aprovecha"; // Llamo a IO.println
            break;
        case "Lluvia":
            message = "No te olvides el paraguas"; // Llamo a IO.println
            break;
        case "Nublado":
            message = "No te hace falta ponerte protector solar"; // Llamo a IO.println
            break;
        default:
            message = "No te puedo aconsejar"; // Llamo a IO.println
            break;
    }

    IO.println(message);
}

void ejemploForecastSwitchExpressionDRY() {
    String forecast = "Lluvia";

    // Como aquí switch es una expresión, la usamos como inicialización de la variable message;
    String message = switch (forecast) {
        case "Soleado" -> "Sal de casa y aprovecha"; // Llamo a IO.println
        case "Lluvia" -> "No te olvides el paraguas"; // Llamo a IO.println
        case "Nublado" -> "No te hace falta ponerte protector solar"; // Llamo a IO.println
        default -> "No te puedo aconsejar"; // Llamo a IO.println
    };

    IO.println(message);
}


/**
 * Incluso podemos ahorrarnos la variable message (no conveniente por claridad del código)
 */
void ejemploForecastSwitchExpressionDRY2() {
    String forecast = "Nublado";

    // Como aquí switch es una expresión, la usamos como inicialización de la variable message;
    IO.println(switch (forecast) {
        case "Soleado" -> "Sal de casa y aprovecha"; // Llamo a IO.println
        case "Lluvia" -> "No te olvides el paraguas"; // Llamo a IO.println
        case "Nublado" -> "No te hace falta ponerte protector solar"; // Llamo a IO.println
        default -> "No te puedo aconsejar"; // Llamo a IO.println
    });
}


void main() {
    ejemplo1();
    ejemplo2();
    ejemplo3();
    ejemplo4();

}