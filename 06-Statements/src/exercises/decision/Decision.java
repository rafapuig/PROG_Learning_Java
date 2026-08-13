/**
 * Averiguar si un carácter es una vocal o no
 */

void exercise1() {
    char ch = 'a';

    boolean result;

    if (ch == 'a') {
        result = true;
    } else if (ch == 'e') {
        result = true;
    } else if (ch == 'i') {
        result = true;
    } else if (ch == 'o') {
        result = true;
    } else if (ch == 'u') {
        result = true;
    } else {
        result = false;
    }

    IO.print(result ? "Si" : "No");
}

void exercise1b() {
    char ch = 'a';

    boolean result;

    switch (ch) {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
            result = true;
            break;
        default:
            result = false;
            break;
    }

    IO.print(result ? "Si" : "No");
}


void exercise1c() {
    char ch = 'a';

    boolean result;

    switch (ch) {
        case 'a', 'e', 'i', 'o', 'u' -> result = true;
        default -> result = false;
    }

    IO.print(result ? "Si" : "No");
}

void exercise1d() {
    char ch = 'a';

    boolean result = switch (ch) {
        case 'a', 'e', 'i', 'o', 'u' -> true;
        default -> false;
    };

    IO.print(result ? "Si" : "No");
}


void exercise1e() {
    char ch = 'a';

    boolean result = ch == 'a' ? true
            : ch == 'e' ? true
            : ch == 'i' ? true
            : ch == 'o' ? true
            : ch == 'u' ? true
            : false;

    IO.print(result ? "Si" : "No");
}

void exercise1f() {
    char ch = 'a';

    boolean result = ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';

    IO.print(result ? "Si" : "No");
}



void main() {

}