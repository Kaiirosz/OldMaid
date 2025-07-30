import java.util.*;

public class Deck  {
    private List<Card> cards;

    public Deck(){
        cards = new ArrayList<>();
        initializeDeck();
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public void removeCard(Card card){
        cards.remove(card);
    }

    public Card getRandomCard(){
        Random rand = new Random();
        int randCardIndex = rand.nextInt(cards.size()) + 1;
        return cards.get(randCardIndex);
    }
    public void shuffleDeck(){
        Collections.shuffle(cards);
    }

    public void initializeDeck(){
        Value[] values = Value.values();
        for (int i = 0; i <= 12; i++){
            addCard(new Card (values[i], Suit.HEARTS, false));
            addCard(new Card(values[i], Suit.DIAMONDS, false));
            addCard(new Card(values[i], Suit.SPADES, false));
            addCard(new Card(values[i], Suit.CLOVERS, false));
        }
    }
    public List<Card> getAllCards(){
        return cards;
    }

}
