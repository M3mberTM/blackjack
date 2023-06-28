public class Main {




    public static void main(String[] args) {
        System.out.println("Hello");
        GameEngine blackjack = new GameEngine();
        blackjack.gameStart();
        Human playerOne = new Human();
        Computer comp = new Computer();
        blackjack.addParticipant(playerOne);
        blackjack.addParticipant(comp);
        blackjack.deal(playerOne);
        blackjack.deal(playerOne);
        playerOne.showHand();

        System.out.println();
        System.out.println("Cards left: " + blackjack.getCardsLeft());
    }




}
