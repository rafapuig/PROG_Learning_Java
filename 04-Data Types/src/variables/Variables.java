// Variable "global"
String name = "Perico Palotes";
int total = 100;


void f1() {
    int x = 5;
    int y = 3;
    IO.println(x);
    IO.println(y);
    // IO.println(z); // z no existe en este ámbito

    IO.println(total); // total existe en todas las funciones
}


void f2() {
    int x = 9;
    int z = 2;
    IO.println(x);
    //IO.println(y); // y no existe en este ámbito
    IO.println(z);

    IO.println(total); // total existe en todas las funciones
}


void main() {
    
}