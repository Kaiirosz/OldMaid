import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final Scanner sc;
    private final List<Player> players;
    private final Deck deck;
    private final DiscardPile discardPile;

    public Game() {
        this.sc = new Scanner(System.in);
        this.players = new ArrayList<>();
        this.deck = new Deck();
        this.discardPile = new DiscardPile();
    }

    public void start() {
        System.out.println("Old Maid");
        System.out.println("-----");
        initializePlayers();
        dealCards();
        for (Player p : players){
            System.out.println(p.getHand().getNumberOfCards() + ": " + p.getHand().getAllCards());
        }
    }

    public void initializePlayers() {
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
        for (int i = 1; i <= numOfPlayers; i++) {
            players.add(new Player("Player " + i));
        }
    }

    public void dealCards(){
        deck.shuffleDeck();
        Card oldMaid = deck.removeRandomQueen();
        discard(oldMaid);
        int index = 0;
        int deckSize = deck.getNumberOfCards();
        for(int i = 0; i < deckSize; i++){
            Player currentPlayer = players.get(index);
            currentPlayer.addToHand(deck.getFirstCard());
            index++;
            if (index == players.size()){
                index = 0;
            }
        }
    }

    public void discard(Card card) {
        discardPile.add(card);
    }

    public void printAllDiscardedCards(){
        for (Card c: discardPile.getAllCards()){
            System.out.println(c);
        }
    }

}

