/**
 * Programación procedural
 * <p>
 * - Un programa grande puede resultar muy difícil de depurar y mantener
 * cuando se crea mediante un solo bloque de código monolítico.
 * - Es más sencillo subdividirlo en subprogramas más pequeños, cada uno de los cuales
 * se encarga de realizar una tarea claramente definida.
 * <p>
 * Consiste en subdividir un problema inicial en varios subproblemas más pequeños,
 * y a su vez, cada subproblema se puede subdividir en otros subproblemas más pequeños todavía,
 * hasta que finalmente la complejidad es manejable y para el subproblema se puede escribir
 * un subprograma sencillo.
 * El programa principal, main, actúa como supervisor, y llama a los subprogramas para que realicen
 * su parte del trabajo.
 * <p>
 * Ejemplo,
 * Supongamos que te asignan a un proyecto para resolver el problema de abuso de drogas en tu ciudad.
 * Una posible forma de abordarlo podría ser tratar de solucionarlo directamente por ti mismo.
 * (Lo cual sería muy difícil e inabordable debido a la complejidad)
 * Una mejoe solución sería didivir el problema grande en subproblemas más pequeños y abordables:
 * - Prevención
 * - Tratamiento
 * - Rehabilitación
 * Los cuales a su vez se podrian dividir en subproblemas más sencillos.
 * - Prevencion
 * - Seminarios para padres
 * - Seminarios para los chavales
 * - ...
 * - Tratamiento
 * - Soporte Médico
 * - Soporte Psicologico
 * - ...
 * - Rehabilitación
 * - Ayuda para mudarse a un hogar sobrio
 * - Ayuda para encontrar un trabajo digno
 * <p>
 * <p>
 * <p>
 * Los criterios para dividir las tareas / responsabilidades del programa completo
 * y asignarlas a subprogramas son dos:
 * - Bajo Acoplamiento
 * - Alta cohesión
 * <p>
 * Bajo Acoplamiento
 * ----------------------------------------------------------------------------------------------
 * El acoplamiento tiene que ver con independencia de las demás partes del programa.
 * El acoplamiento baja cuanto menos conocimiento de otras partes del programa tiene un subprograma.
 * En cuanto a ese conocimiento o información conocida, pueden ser
 * - datos almacenados en variables que lee o escribe
 * - o la existencia de otros subprogramas a los que llama para delegar parte del trabajo.
 * <p>
 * Por ejemplo,
 * - Un subprograma A esta acoplado con otro subprograma B, si en A se hace alguna llamada a B.
 * - Un subprograma está acoplado con todas las variables (y constantes) "globales" que utiliza.
 * <p>
 * El bajo acoplamiento se refiere a que para realizar sus tareas,
 * un subprograma debería conocer la mínima información imprescindible de otras partes del programa
 * y, por eso, debe ser diseñado de manera que esta información sea minima, lo que lo hará
 * más independiente de los cambios que se puedan realizar en otras partes del programa.
 * <p>
 * <p>
 * Alta Cohesion
 * -----------------------------------------------------------------------------------------------
 * La cohesión se refiere a una propiedad interna del subprograma.
 * Un subprograma es cohesivo en la media en que las tareas que realiza estén muy relacionadas entre sí.
 * <p>
 * Nota: Cuantas menos tareas realice un subprograma más aumenta la cohesion entre estas.
 * <p>
 * Por ejemplo,
 * Si un subprograma obtiene datos del usuario, realiza un cálculo con estos datos, y muestra un resultado final.
 * Está realizando 3 tareas no demasiado cohesivas entre sí.
 * Obtener datos, tiene que ver con la entrada.
 * Calcular tiene que ver con procesar información en la CPU.
 * Mostrar el resultado tiene que ver con la salida.
 * <p>
 * Si un subprograma pregunta al usuario por la consola su peso y altura, calcula su IMC,
 * y luego muestra el valor resultado por consola.
 * <p>
 * Es mejor separarlo en 3 subprogramas y cada uno realiza una de las tareas,
 * resultando cada subsubprograma mucho más cohesivo, lo que mejora la reusabilidad de las partes.
 * <p>
 * Por ejemplo,
 * El subprograma que realiza el cálculo del IMC se podría reutilizar en un programa que utilice ventanas gráficas.
 * <p>
 * <p>
 * Ventajas
 * -------------------------------------------------------------------------------------------
 * - Permite al programador reusar el mismo código en cualquier lugar donde sea necesario,
 * ¡¡¡ sin necesidad de rescribirlo o copiarlo y pegarlo !!!
 * - Permite seguir el flujo de ejecución más fácilmente simplificando el proceso de depuración.<-- cuestionable
 * - Permite depurar y probar subprogramas de manera independiente y separada del resto.
 * - Permite repartir el esfuerzo de programación entre varios programadores una vez divido en subprogramas.
 */

void prevencion(int edad) {
    if (edad < 18) {
        seminarioAdolescente(edad);
    } else {
        seminarioPadres(edad);
    }
}

void tratamiento(String diagnostico) {
    switch (diagnostico) {
        case "daño físico":
            soporteMedico(diagnostico);
        case "daño psicológico":
            soportePsicologico();
    }
}

void rehabilitacion(boolean desempleado, boolean hogarEbrio) {
    if (hogarEbrio) ayudaMudanza();
    if (desempleado) ayudaEncontrarEmpleo();
}

void seminarioPadres(int edad) {

}

void seminarioAdolescente(int edad) {

}

void soporteMedico(String diagnostico) {

}

void soportePsicologico() {

}

void ayudaMudanza() {

}

void ayudaEncontrarEmpleo() {

}


void main() {

    String situacion = "tratamiento";
    int edad = 19;
    String diagnostico ="daño psicológico";
    boolean hogarEbrio = false;
    boolean desempleado = true;

    switch (situacion) {
        case "prevenir" -> prevencion(edad);
        case "tratamiento" -> tratamiento(diagnostico);
        case "rehabilitacion" -> rehabilitacion(hogarEbrio, desempleado);
    }

}