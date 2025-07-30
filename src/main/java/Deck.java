import java.util.*;

public class Deck  {
    private final List<Card> cards;

    public Deck(){
        this.cards = new ArrayList<>();
        initializeDeck();
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public Card removeRandomQueen() {
        List<Card> queens = new ArrayList<>();
        for (Card c : cards) {
            if (c.getValue().equals(Value.QUEEN)) {
                queens.add(c);
            }
        }
        Random random = new Random();
        Card randomQueen = queens.get(random.nextInt(queens.size()));
        cards.remove(randomQueen);
        return randomQueen;
    }

    public void shuffleDeck(){
        Collections.shuffle(cards);
    }

    public void initializeDeck(){
        Value[] values = Value.values();
        for (int i = 0; i <= 12; i++){
            addCard(new Card (values[i], Suit.HEARTS,"♥" ));
            addCard(new Card(values[i], Suit.DIAMONDS,"♦"));
            addCard(new Card(values[i], Suit.SPADES,"♠"));
            addCard(new Card(values[i], Suit.CLOVERS,"♣"));
        }
    }
    public List<Card> getAllCards(){
        return cards;
    }

}
