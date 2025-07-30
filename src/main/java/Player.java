public class Player {
    private final String name;
    private Hand hand;

    public Player(String name){
        this.name = name;
        Hand hand = new Hand();
    }

    public void addToHand(Card card){
        hand.addCard(card);
    }

    @Override
    public String toString(){
        return name;
    }

}
