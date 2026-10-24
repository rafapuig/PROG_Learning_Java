/**
 * Escribe un programa que lea la nota minima para aprobar el examen
 * y las notas de 3 alumnos.
 * Tiene que mostrar cuantos de ellos han aprobado.
 * Tiene que mostrar la nota media de los aprobados. (asumiendo que al menos un alumno ha aprobado)
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

    IO.println("Numero de alumnos que han aprobado: " + succeededCount);

    float succeededGradesSum = 0f;
    succeededGradesSum += student1Grades >= minScore ? student1Grades : 0f;
    succeededGradesSum += student2Grades >= minScore ? student2Grades : 0f;
    succeededGradesSum += student3Grades >= minScore ? student3Grades : 0f;

    // Si el número de alumnos aprobados fuera 0 se produciría un error al dividir por cero
    final float succeededGradesAverage = succeededGradesSum / succeededCount;

    IO.println("La nota media de los alumnos que han aprobado: " + succeededGradesAverage);
}

