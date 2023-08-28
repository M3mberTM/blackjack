import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class GameEngine {

    private final LinkedList<Card> discardPile = new LinkedList<>();
    private final LinkedList<Card> deck = new LinkedList<>();
    private final Dealer dealer;
    private final LinkedList<Player> participants = new LinkedList<>();

    public static final Random randomNumGen = new Random();
    public static final Scanner sc = new Scanner(System.in);

    public GameEngine(int numberOfDecks) {
        gameInit(numberOfDecks);
        this.dealer = new Dealer(this);
    }

    public LinkedList<Card> getDiscardPile() {
        return discardPile;
    }

    public LinkedList<Player> getParticipants() {
        return this.participants;
    }

    private void gameInit(int deckAmount) {
        makeDeck(deckAmount);
    }

    private int getCardsLeft() {
        return deck.size();
    }

    public void addParticipant(Player participant) {
        participants.add(participant);
    }

    //todo shuffle method
    private void shuffle() {
        deck.addAll(discardPile);
        discardPile.clear();
    }

    public void gameStart() {

        if (getCardsLeft() < 75) {
            shuffle();
        }

        for (Player player : participants) {
            if (player.getCurrentMoney() > 0) {
                player.bet();
            } else {
                System.out.println("no money to bet");
                participants.remove(player);
            }

        }
        if (participants.size() > 0) {
            for (Player player : participants) {
                player.addCard(getRandomCard());
                player.addCard(getRandomCard());
            }
            dealer.addCard(getRandomCard());
            dealer.addCard(getRandomCard());
            boolean dealerNatural = dealer.isNatural();
            for (Player player : participants) { //checking whether the player has a natural
                boolean playerNatural = player.isNatural();
                if (playerNatural && dealerNatural) { //tie
                    System.out.println("Player and the dealer are tied.");
                    player.tie();
                } else if (playerNatural && !dealerNatural) { //player wins
                    System.out.println("Player wins");
                    player.payout();
                } else if (!playerNatural && dealerNatural) {//dealer wins
                    System.out.println("Player loses");
                    player.setCurrentBet(0);
                }
            }


            for (Player player : participants) { //hitting or standing if you don't have a natural
                if (player.getHandValue() > 8 && player.getHandValue() < 12 && player.getCurrentBet() > 0) {
                    if (player instanceof Human) {
                        System.out.println("Do you want to double down? (y/n)");
                        if (sc.next().equals("y")) {
                            System.out.println("Your hand: " + player.getCurrentHand());
                            player.doubleDown();
                        } else {
                            player.play();
                        }
                    } else {
                        player.doubleDown();
                    }
                } else {
                    player.play();
                }
            }

            dealer.play();
            System.out.println("The dealer's hand: " + dealer.getCurrentHand());
            System.out.println("Dealer hand's value: " + dealer.getHandValue());

            for (Player player : participants) {
                if (player.getCurrentBet() > 0) {
                    if (player.getHandValue() != dealer.getHandValue()) {
                        if (isPlayerWin(player)) {
                            player.payout();
                            System.out.println("Player wins");
                        } else {
                            player.setCurrentBet(0);
                            System.out.println("Dealer wins");
                        }
                    } else {
                        player.tie();
                        System.out.println("Player ties with the dealer");
                    }
                }
            }
            System.out.println("Game done!");

            for (Player player : participants) {
                player.discardCards();
            }
            dealer.discardCards();
        }
    }

    private boolean isPlayerWin(Player player) {

        return player.getHandValue() > dealer.getHandValue();


    }


    public Card getRandomCard() {
        Card cardDealt = deck.remove(randomNumGen.nextInt(deck.size()));
        System.out.println("Card dealt: " + cardDealt.toString());
        return cardDealt;
    }


    public void makeDeck(int deckAmount) {
        System.out.println("Creating the cards... //" + System.currentTimeMillis());
        for (int indexFace = 0; indexFace < CardFace.values().length; indexFace++) {
            for (int indexType = 0; indexType < CardType.values().length; indexType++) {
                for (int i = 0; i < deckAmount; i++) {
                    deck.add(new Card(CardType.values()[indexType], CardFace.values()[indexFace]));
                }

            }
        }
    }


}
