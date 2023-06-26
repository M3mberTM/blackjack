public enum CardFace {
    CLUBS('♣'),
    DIAMOND('♦'),
    SPADES('♠'),
    HEART('♥');

    public final char symbol;

    CardFace(char symbol) {
        this.symbol = symbol;
    }
}
