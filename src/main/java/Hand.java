import java.util.ArrayList;
import java.util.List;

public class Hand<Card> {
    private final List<Card> cards;

    public Hand(){
        cards = new ArrayList<>();
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public void discardPair(Card card){
        cards.remove(card);
    }
}
