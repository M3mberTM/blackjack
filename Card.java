public class Card {
    private CardType type;
    private CardFace face;


    Card(CardType type, CardFace face) {
        this.type = type;
        this.face = face;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public CardFace getFace() {
        return face;
    }

    public void setFace(CardFace face) {
        this.face = face;
    }
}
