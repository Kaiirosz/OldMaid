import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final Scanner sc;
    private final List<Player> players;
    private final Deck deck;

    public Game(){
        this.sc = new Scanner(System.in);
        this.players = new ArrayList<>();
        this.deck = new Deck();
    }

    public void start() {
        System.out.println("Old Maid");
        System.out.println("-----");
        initializePlayers();
        System.out.println(players);


    }

        public void initializePlayers(){
            int numOfPlayers = 0;
            while (true) {
                System.out.println("Choose the number of players:");
                System.out.println("2P | 3P | 4P | 5P | 6P");
                String input = sc.nextLine();

                switch (input) {
                    case "2P" -> numOfPlayers = 2;
                    case "3P" -> numOfPlayers = 3;
                    case "4P" -> numOfPlayers = 4;
                    case "5P" -> numOfPlayers = 5;
                    case "6P" -> numOfPlayers = 6;
                    default -> {
                        System.out.println("Invalid Input! Choose from the options above.");
                        continue;
                    }
                }
                break;
            }
            for (int i = 1; i <= numOfPlayers; i++){
                players.add(new Player("Player " + i));
            }
        }

    }

