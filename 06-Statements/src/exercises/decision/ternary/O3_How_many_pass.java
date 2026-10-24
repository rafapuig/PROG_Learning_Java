/**
 * Escribe un programa que lea la nota minima para aprobar el examen
 * y las notas de 3 alumnos.
 * Tiene que mostrar cuantos de ellos han aprobado.
 */

void main() {
    final int minScore = Integer.parseInt(IO.readln("Introduce la nota minima para aprobar: "));

    final float student1Grades = Float.parseFloat(IO.readln("Introduce la nota del estudiante 1 (0-10): "));
    final float student2Grades = Float.parseFloat(IO.readln("Introduce la nota del estudiante 2 (0-10): "));
    final float student3Grades = Float.parseFloat(IO.readln("Introduce la nota del estudiante 3 (0-10): "));

    int succeededCount = 0;

    succeededCount += student1Grades >= minScore ? 1 : 0;
    succeededCount += student2Grades >= minScore ? 1 : 0;
    succeededCount += student3Grades >= minScore ? 1 : 0;

    IO.println("Numero de estudiantes que han aprobado: " + succeededCount);
}

