import java.util.LinkedList;

public interface Player {


    boolean bet(int bettingAmount);

    boolean addCard(Card newCard);

    void raiseHandValue(int amount);

    int getHandValue();

    int getCurrentBet();

    LinkedList<Card> getCurrentHand();

    int getCurrentMoney();
}
