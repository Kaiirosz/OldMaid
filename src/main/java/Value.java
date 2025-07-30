public enum Value {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING;

    public boolean isHigherValue(Value value){
        if (ordinal() == 1){
            return true;
        }
        return this.ordinal() > value.ordinal();
    }
}
