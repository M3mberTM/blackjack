public class Main {




    public static void main(String[] args) {
        System.out.println("Hello");
        GameEngine blackjack = new GameEngine(6);
        blackjack.addParticipant(new Human(blackjack));
        do {
            blackjack.gameStart();
            System.out.println("do you want to continue the game? (y/n)");
        } while (GameEngine.sc.next().equals("y"));



    }




}
