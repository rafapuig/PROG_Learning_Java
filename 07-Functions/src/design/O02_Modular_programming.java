/**
 * Programación modular
 * <p>
 * Consiste en AGRUPAR subprogramas que tengan funcionalidad en común en un mismo módulo.
 * Creando módulos separados y de manera que
 * cada módulo contenga su propia información (conjunto de datos, estado)
 * y que esta se pueda compartir exclusivamente entre los subprogramas que forman parte del mismo módulo.
 */


static class Prevencion {

    static int edad;

    static void prevenir(int edad) {
        Prevencion.edad = edad;

        if (edad < 18) {
            seminarioAdolescente();
        } else {
            seminarioPadres();
        }
    }

    static void seminarioPadres() {
        IO.println("Seminario Padres para paciente edad " + edad);
    }

    static void seminarioAdolescente() {
        IO.println("Seminario Adolescentes para paciente edad " + edad);
    }
}


static class Tratamiento {

    static String diagnostico;

    static void tratar(String diagnostico) {
        Tratamiento.diagnostico = diagnostico;
        switch (diagnostico) {
            case "daño físico":
                soporteMedico();
            case "daño psicológico":
                soportePsicologico();
        }
    }

    static void soporteMedico() {
        IO.println("Soporte medico para paciente con " + diagnostico);
    }

    static void soportePsicologico() {

    }
}


static class Rehabilitacion {

    static void rehabilitar(boolean desempleado, boolean hogarEbrio) {
        if (hogarEbrio) ayudaMudanza();
        if (desempleado) ayudaEncontrarEmpleo();
    }

    static void ayudaMudanza() {
    }

    static void ayudaEncontrarEmpleo() {
    }
}


void main() {

    String situacion = "tratamiento";
    int edad = 19;
    String diagnostico = "daño psicológico";
    boolean hogarEbrio = false;
    boolean desempleado = true;

    switch (situacion) {
        case "prevenir" -> Prevencion.prevenir(edad);
        case "tratamiento" -> Tratamiento.tratar(diagnostico);
        case "rehabilitacion" -> Rehabilitacion.rehabilitar(hogarEbrio, desempleado);
    }

}