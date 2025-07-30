public class Main {

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.initializeDeck();
        for (Card c: deck.getAllCards()){
            System.out.println(c);
        }
    }
}
