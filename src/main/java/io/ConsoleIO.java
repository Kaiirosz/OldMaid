package io;

import java.util.Scanner;

public class ConsoleIO implements GameIO {
    private final Scanner sc = new Scanner(System.in);

    @Override
    public void println(String message) {
        System.out.println(message);
    }

    @Override
    public void print(String message) {
        System.out.print(message);
    }

    @Override
    public void printSeparator() {
        System.out.println("----------------------");
    }

    @Override
    public String readNextLine() {
        return sc.nextLine();
    }

    @Override
    public int readInt() {
        int readInt = sc.nextInt();
        sc.nextLine();
        return readInt;
    }

}
