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
    ejemploForecastSwitchStatement();
    ejemploForecastSwitchStatementDRY();
    ejemploForecastSwitchExpressionDRY();
    ejemploForecastSwitchExpressionDRY2();
}