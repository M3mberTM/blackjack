public class Card {
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

}
