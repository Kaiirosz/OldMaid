import java.util.List;

public class Hand {
    private List<Card> cards;

    public void addCard(Card card){
        cards.add(card);
    }

    public void removeCard(Card card){
        cards.remove(card);
    }
}
