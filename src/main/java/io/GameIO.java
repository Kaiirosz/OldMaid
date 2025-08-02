package io;

public interface GameIO {
    void println(String message);
    void print(String message);
    void printSeparator();
    String readNextLine();
    int readInt();
}
