package service;

import io.ConsoleIO;
import io.GameIO;
import model.*;
import utils.GameUtils;

import java.util.*;

public class Game {
    private final GameIO io;
    private final List<Player> players;
    private final Deck deck;
    private final DiscardPile discardPile;

    public Game(GameIO io) {
        this.io = io;
        this.players = new ArrayList<>();
        this.deck = new Deck();
        this.discardPile = new DiscardPile();

    }

    public void start() {
        io.println("Old Maid");
        io.printSeparator();
        initializePlayers();
        io.println("Game Start!!");
        io.printSeparator();
        io.printSeparator();
        continueGameUntilThereIsAnOldMaid();
    }

    public void initializePlayers() {
        int numOfPlayers;
        while (true) {
            io.println("Choose the number of players:");
            io.println("2P | 3P | 4P | 5P | 6P");
            String input = io.readNextLine();
            switch (input) {
                case "2P" -> numOfPlayers = 2;
                case "3P" -> numOfPlayers = 3;
                case "4P" -> numOfPlayers = 4;
                case "5P" -> numOfPlayers = 5;
                case "6P" -> numOfPlayers = 6;
                default -> {
                    io.println("Invalid Input! Choose from the options above.");
                    continue;
                }
            }
            break;
        }
        for (int i = 1; i <= numOfPlayers; i++) {
            players.add(new Player("Player " + i));
        }
    }

    public void dealCards() {
        deck.shuffleDeck();
        Card oldMaid = deck.removeRandomQueen();
        discard(oldMaid);
        int index = 0;
        int deckSize = deck.getNumberOfCards();
        for (int i = 0; i < deckSize; i++) {
            Player currentPlayer = players.get(index);
            currentPlayer.addToHand(deck.getFirstCard());
            index++;
            if (index == players.size()) {
                index = 0;
            }
        }
        io.println("Cards Dealt.");
    }

    public void displayAllPlayerHands() {
        if (players.getFirst().getName().equals("Player 1")){
            players.getFirst().displayHand();
        }
        for (int i = 1; i < players.size(); i++) {
            Player currentPlayer = players.get(i);
            currentPlayer.displayHiddenHand();
        }
    }

    public void discardPairsFor(Player p) {
        Map<Value, List<Card>> cardsWithSameValueMap = new HashMap<>();
        List<Card> cardsInHand = p.getAllCards();
        for (Card c : cardsInHand) {
            cardsWithSameValueMap.computeIfAbsent(c.getValue(), k -> new ArrayList<>()).add(c);
        }
        for (List<Card> cards : cardsWithSameValueMap.values()) {
            for (int i = 0; i < cards.size() - 1; i += 2) {
                Card currentCard = cards.get(i);
                Card nextCard = cards.get(i + 1);
                if (p.getName().equals("Player 1")) {
                    io.println("You discarded: " + p.removePair(currentCard, nextCard) + "!!");
                } else {
                    io.println(p.getName() + " discarded: " + p.removePair(currentCard, nextCard) + "!!");
                }
                GameUtils.pauseForEffect(1000);
                discard(currentCard);
                discard(nextCard);
            }
        }
    }

    public boolean checkForWinners() {
        Iterator<Player> iterator = players.iterator();
        while (iterator.hasNext()) {
            Player p = iterator.next();
            int playersSize = players.size();
            if (playersSize == 1) {
                io.println("There is only one player left.");
                if (p.getName().equals("Player 1")) {
                    io.println("You are an old maid.");
                } else {
                    io.println(p.getName() + " is an old maid.");
                }
                return true;
            }
            if (p.getHandSize() == 0) {
                io.println(p.getName() + " discarded all of their cards!");
                iterator.remove();
            }
        }
        return false;
    }

    public void continueGameUntilThereIsAnOldMaid() {
        dealCards();
        displayAllPlayerHands();
        for (Player p : players) {
            discardPairsFor(p);
        }
        boolean gameIsOver = checkForWinners();
        while (!gameIsOver) {
            displayAllPlayerHands();
            if (players.getFirst().getName().equals("Player 1")){
                io.println("Enter any key to get a card from next player or 'D' to look at discard pile");
            }
            String input = io.readNextLine();
            if (input.equalsIgnoreCase("D")) {
                printAllDiscardedCards();
            } else {
                for (int i = 0; i < players.size(); i++) {
                    getCardFromOtherPlayer(i);
                    gameIsOver = checkForWinners();
                    if (gameIsOver) {
                        break;
                    }
                    io.printSeparator();
                }
            }
        }
    }

    public void getCardFromOtherPlayer(int playerIndex) {
        Player player = players.get(playerIndex);
        int nextPlayerIndex;
        if (playerIndex == players.size() - 1) {
            nextPlayerIndex = 0;
        } else {
            nextPlayerIndex = playerIndex + 1;
        }
        Player nextPlayer = players.get(nextPlayerIndex);
        if (player.getName().equalsIgnoreCase("Player 1")) {
            while (true) {
                io.println("From left to right enter the positional number of the card you want to get.");
                player.displayHand();
                nextPlayer.displayHand();
                int inputPosition = io.readInt() - 1;
                if (inputPosition > nextPlayer.getHandSize() - 1 || inputPosition < 0) {
                    io.println("Invalid Number. Try Again.");
                } else {
                    Card acquiredCard = nextPlayer.giveCardFromHand(inputPosition);
                    player.addToHand(acquiredCard);
                    io.println("You drew a " + acquiredCard.getCardNotation() + "!");
                    break;
                }
            }
        } else {
            Random random = new Random();
            Card acquiredCard = nextPlayer.giveCardFromHand(random.nextInt(nextPlayer.getHandSize()));
            player.addToHand(acquiredCard);
            io.println(player.getName() + " drew a card.");
            GameUtils.pauseForEffect(2000);
        }
        discardPairsFor(player);
    }


    public void discard(Card card) {
        discardPile.add(card);
    }

    public void printAllDiscardedCards() {
        for (Card c : discardPile.getAllCards()) {
            System.out.println(c);
        }
    }
}

