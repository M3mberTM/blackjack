public class Computer extends Player {
    @Override
    public void bet() {
        int bettingAmount = GameEngine.randomNumGen.nextInt(getCurrentMoney());
        setCurrentBet(bettingAmount);
    }

    @Override
    public void play() {
        System.out.println(getCurrentHand());
        System.out.println("Value of hand: " + getHandValue());
        boolean isStand = false;
        while (!isStand) {

            if ((21 - getHandValue()) >= 10) {
                addCard(getGame().getRandomCard());
            } else {
                if (GameEngine.randomNumGen.nextDouble() < (4 * (4 + (9 - (21 - getHandValue())))) / 52.0) {
                    addCard(getGame().getRandomCard());
                    if (isBust()) {
                        System.out.println("Busted");
                        setCurrentBet(0);
                        break;
                    }
                } else {
                    isStand = true;
                    System.out.println("Computer stands");
                }
            }
        }
    }
}

