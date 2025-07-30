public class Player {
    private final String name;
    private Hand hand;

    public Player(String name){
        this.name = name;
        Hand hand = new Hand();
    }

}
