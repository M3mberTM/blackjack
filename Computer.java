import java.util.LinkedList;

public class Computer implements Player {
    private final LinkedList<Card> currentHand = new LinkedList<>();
    private int currentMoney = 500;
    private int currentBet = 0;
    private int handValue = 0;

    public LinkedList<Card> getCurrentHand() {
        return currentHand;
    }

    public int getCurrentMoney() {
        return currentMoney;
    }

    //todo finish betting
    public boolean bet(int bettingAmount) {
        if (currentMoney - bettingAmount >= 0) {
            currentMoney = currentMoney - bettingAmount;
            currentBet += bettingAmount;
            return true;
        }
        return false;
    }


    public boolean addCard(Card newCard) {
        currentHand.add(newCard);
        return true;
    }

    @Override
    public void raiseHandValue(int amount) {
        handValue += amount;
    }

    @Override
    public int getHandValue() {
        return handValue;
    }

    @Override
    public int getCurrentBet() {
        return currentBet;
    }
}
