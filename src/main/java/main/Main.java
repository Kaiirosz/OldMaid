package main;

import io.ConsoleIO;
import service.Game;

public class Main {

    public static void main(String[] args) {
        new Game(new ConsoleIO()).start();
    }
}
