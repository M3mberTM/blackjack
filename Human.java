public class Human extends Player {


    public Human(GameEngine game) {
        setGame(game);
    }


    public void bet() {
        System.out.println("Current money: " + getCurrentMoney());
        System.out.println("How much do you want to bet?");
        int bettingAmount = GameEngine.sc.nextInt();
        System.out.println("Betting " + bettingAmount + " coins.");
        if (getCurrentMoney() - bettingAmount >= 0) {
            setCurrentMoney(getCurrentMoney() - bettingAmount);
            setCurrentBet(getCurrentBet() + bettingAmount);
        }

    }


    public void play() {
        System.out.println(getCurrentHand());
        System.out.println("Value of hand: " + getHandValue());
        System.out.println("Hit? (y/n)");
        while (GameEngine.sc.next().equals("y")) {
            addCard(getGame().getRandomCard());
            System.out.println(getCurrentHand());
            System.out.println("Value of hand: " + getHandValue());
            if (isBust()) {
                System.out.println("Busted");
                setCurrentBet(0);
                break;
            } else {
                System.out.println("Hit? (y/n)");
            }

        }
    }

}