public abstract class Player extends Participant {


    private int currentMoney = 500;
    private int currentBet = 0;



    public void setCurrentBet(int currentBet) {
        this.currentBet = currentBet;
    }

    public void setCurrentMoney(int amount) {
        this.currentMoney = amount;
    }

    public int getCurrentBet() {
        return currentBet;
    }

    public int getCurrentMoney() {
        return currentMoney;
    }

    public void addMoney(int amount) {
        this.currentMoney += amount;
    }

    public abstract void bet();

    public void payout() {
        int payout = (int) Math.floor(getCurrentBet() * 1.5);
        addMoney(payout);
        setCurrentBet(0);
    }

    public void tie() {
        addMoney(getCurrentBet());
        setCurrentBet(0);
    }

    public void doubleDown() {
        setCurrentMoney(getCurrentMoney() - getCurrentBet());
        setCurrentBet(getCurrentBet() * 2);
        addCard(getGame().getRandomCard());
    }

    public void splitPair() {

    }

    public abstract void play();


}
