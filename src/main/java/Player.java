public class Player {
    private final String name;
    private Hand hand;

    public Player(String name){
        this.name = name;
        hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public void addToHand(Card card){
        hand.addCard(card);
    }

    @Override
    public String toString(){
        return name;
    }

}
