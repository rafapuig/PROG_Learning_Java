# Tokens separadores de Java

| Separador | Nombre | Uso |
|-----------|--------|-----|
| `(` `)` | Paréntesis | Agrupan expresiones y delimitan parámetros de métodos. |
| `{` `}` | Llaves | Delimitan bloques de código (clases, métodos, bucles, etc.). |
| `[` `]` | Corchetes | Se utilizan para declarar y acceder a arreglos (arrays). |
| `;` | Punto y coma | Finaliza una sentencia o instrucción. |
| `,` | Coma | Separa elementos en listas de parámetros, variables o inicializadores. |
| `.` | Punto | Accede a miembros de clases u objetos (atributos y métodos). |
| `...` | Elipsis | Indica un número variable de argumentos (*varargs*). |
| `@` | Arroba | Introduce anotaciones (*annotations*). |
| `::` | Doble dos puntos | Referencia a métodos o constructores (*method reference*). |

## Ejemplo

```java
public class Ejemplo {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3};
        System.out.println(numeros[0]);
    }
}
```

### Separadores utilizados en el ejemplo

- `{ }` → Delimitan la clase y el método.
- `( )` → Delimitan los parámetros de `main` y `println`.
- `[ ]` → Declaran y acceden al arreglo.
- `;` → Finalizan las instrucciones.
- `,` → Separa los elementos del arreglo.
- `.` → Accede a `out` y `println`.

> **Nota:** En Java, los espacios en blanco (espacios, tabulaciones y saltos de línea) también actúan como separadores entre tokens, aunque no se consideran separadores simbólicos.