public class Dealer extends Participant {


    public Dealer(GameEngine game) {
        setGame(game);
    }

    @Override
    public void play() {
        while (getHandValue() < 17) { //dealer hits
            System.out.println("Dealer hits!");
            addCard(getGame().getRandomCard());
            if (isBust()) {
                System.out.println("Dealer busted");
                for (Player player : getGame().getParticipants()) {
                    if (player.getCurrentBet() > 0) {
                        System.out.println("Player won");
                        player.payout();
                    }
                }
                break;
            }
        }
        if (!isBust()) {
            System.out.println("Dealer stands");
        }


    }


}
