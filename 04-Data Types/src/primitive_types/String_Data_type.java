void main() {
    printDominoTile();
    printDominoDemo();
}

void printDominoTile() {
    String domino = new String(Character.toChars(0x1F03B)); // 🀻 (1–5)
    IO.println(domino);
}

void printDominoDemo() {
    int dominoCode = 0x1F030;
    for(var i = dominoCode; i <= 0x1F093; i++) {
        var domino = new String(Character.toChars(i));
        IO.println(domino);
    }
}