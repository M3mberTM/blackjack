import java.util.LinkedList;

public class Human implements Player {


    private final LinkedList<Card> currentHand = new LinkedList<>();
    private int currentMoney = 500;
    private int handValue = 0;
    private int currentBet = 0;
    public int getHandValue() {
        return handValue;
    }

    public int getCurrentBet() {
        return currentBet;
    }



    public LinkedList<Card> getCurrentHand() {
        return currentHand;
    }

    public int getCurrentMoney() {
        return currentMoney;
    }

    public void raiseHandValue(int amount) {
        handValue += amount;
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

    public void showHand() {
        System.out.println("Your current hand is: ");
        for (Card card : currentHand) {
            System.out.print(card.getType().symbol + card.getFace().symbol);
            System.out.print(", ");
        }
    }


}