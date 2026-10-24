/**
 * Supongamos que un cliente en una tienda compra varias cosas.
 * Si el total es menor que 100 euros no se aplica ningún descuento, en otro caso se le aplica el 5%
 *
 * Escribe un programa que lea el coste total y muestre el total a pagar.
 */

void main() {
    final float totalCost = Float.parseFloat(IO.readln("Introduce el coste total: "));

    final float discount = 0.05f;

    final float amountToPay = totalCost >= 100 ? totalCost * (1 - discount) : totalCost;

    IO.println("El total a pagar es " + amountToPay);
}
