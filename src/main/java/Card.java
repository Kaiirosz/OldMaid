import java.util.Objects;

public class Card {
    private final Value value;
    private final Suit suit;
    private final boolean isOldMaid;

    public Card(Value value, Suit suit, boolean isOldMaid){
        this.value = value;
        this.suit = suit;
        this.isOldMaid = isOldMaid;
    }

    public String getValue() {
        return value.name();
    }

    public Suit getSuit() {
        return suit;
    }

    public boolean isOldMaid() {
        return isOldMaid;
    }

    @Override
    public String toString(){
        return getValue() + " of " + suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null){
            return false;
        }
        if (!(obj instanceof Card card)) {
            return false;
        }
        return Objects.equals(this.value, card.value)
                && Objects.equals(this.suit, card.suit);
    }

}
