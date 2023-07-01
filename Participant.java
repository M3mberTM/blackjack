import java.util.LinkedList;

public abstract class Participant {
    private final LinkedList<Card> currentHand = new LinkedList<>();
    private final LinkedList<Card> secondHand = new LinkedList<>();
    private GameEngine game;

    public void setGame(GameEngine game) {
        this.game = game;
    }

    public GameEngine getGame() {
        return game;
    }


    public int getHandValue() {
        int handValue = 0;
        int aceCount = 0;
        for (Card card : currentHand) {
            handValue += card.getCardValue();
            if (card.getType() == CardType.ACE) {
                aceCount++;
            }
        }
        if (handValue > 21) {
            while (handValue > 21 && aceCount > 0) {
                handValue -= 10;
                aceCount--;
            }
        }
        return handValue;
    }

    public boolean isBust() {
        return getHandValue() > 21;
    }

    public boolean isNatural() {
        return getHandValue() == 21;
    }

    public LinkedList<Card> getCurrentHand() {
        return currentHand;
    }


    public void addCard(Card newCard) {
        currentHand.add(newCard);
    }

    public abstract void play();

    public void discardCards() {
        for (Card card : currentHand) {
            game.getDiscardPile().add(card);
        }
        for (Card card : secondHand) {
            game.getDiscardPile().add(card);
        }
        currentHand.clear();
        secondHand.clear();
    }
}
