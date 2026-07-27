/**
 * Literales de valores de punto flotante
 * <p>
 * Consta de las siguientes partes:
 * <p>
 * ParteEntera PuntoDecimal ParteFraccionaria Exponente Sufijo
 * Digitos      .        Digitos          e E p P   f F d D
 * <p>
 * Se puede expresar en decimal (base 10) o en hexadecimal (base 16)
 * <p>
 * Para valores en decimal:
 * - Al menos un dígito en parte entera o en la parte fraccionaria
 * - el punto decimal (.) y/o el exponente (E) y el sufijo
 * <p>
 * Para valores en hexadecimal:
 * - Al menos un dígito bien en parte entera o en la parte fraccionaria
 * - Exponente obligatorio {p|P} + Entero con signo
 * - Sufijo opcional
 * <p>
 * Se permiten _ como sepapadores entre digitos que denoten: parte entera, parte fraccionaria y exponente
 * <p>
 * Sufijos:
 * - f (o F) para que el valor sea de tipo float
 * - d (o D) o sin sufijo el valor se considera de tipo double
 * <p>
 * - El valor más grande positivo de tipo float es numericamente igual a (2-2^23)*2^127
 * y se corresponde con el literal 3.4028235e38f
 * y 0x1.ffffrP+127f
 * <p>
 * - El valor más pequeño positivo de tipo float es numericamente equivalente a 2^-149
 * y se corresponde con el literal 1.4e-45f
 * y 0x0.00002P-126f o también 0x1.0P-149f
 *
 */
void main() {
    /* Literales de tipo float (Obligatorio el sufijo f o F */
    IO.println(0f);

    IO.println(5f);
    IO.println(5.f);
    IO.println(5.f);
    IO.println(.5f);
    IO.println(0.5f);
    IO.println(3.14f);

    IO.println(+5f);
    IO.println(+5.f);
    IO.println(+5.f);
    IO.println(+.5f);
    IO.println(+0.5f);
    IO.println(+3.14f);

    IO.println(-5f);
    IO.println(-5.f);
    IO.println(-.5f);
    IO.println(-0.5f);
    IO.println(-3.14f);

    IO.println(5e2f); // 5 * 10^2
    IO.println(5.e2f);
    IO.println(-5e2f);
    IO.println(5e+2f);
    IO.println(-5e+2f);
    IO.println(5e-2f); // 5 * 10^-2
    IO.println(-5e-2f);
    IO.println(-.5e+2f);
    IO.println(-.5e-2f);
    IO.println(0.5e2f);
    IO.println(-0.5e+2f);
    IO.println(6.022137e+23f);

    IO.println(0xCAFEP23f);

    /* Literales de tipo double */
    IO.println(0d);
    IO.println(0D);
    IO.println(0.0);
    IO.println(.0);

    IO.println(5d);
    IO.println(-5d);
    IO.println(5D);
    IO.println(-5D);
    IO.println(.5);
    IO.println(0.5);
    IO.println(3.1416);
    IO.println(-3.1416);
    IO.println(+3.1416d);
    IO.println(-3.1416D);

    IO.println(1e-9d);
    IO.println(1e137);
}
