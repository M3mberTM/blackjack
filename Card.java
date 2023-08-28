public class Card { //Card object
    private final CardType type;
    private final CardFace face;


    Card(CardType type, CardFace face) {
        this.type = type;
        this.face = face;
    }

    public CardType getType() {
        return type;
    }

    public CardFace getFace() {
        return face;
    }

    public String toString() {
        return this.type.symbol + this.face.symbol;
    }

    public int getCardValue() {
        return this.type.value;
    }
}
