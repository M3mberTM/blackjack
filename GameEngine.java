import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class GameEngine {
    private final int numberOfDecksUsed = 6;
    private final HashMap<Card, Integer> currentDeck = new HashMap<>();
    private final LinkedList<Card> deck = new LinkedList<>();
    Random randomNumGen = new Random();

    public int getCardsLeft() {
        return cardsLeft;
    }

    private int cardsLeft = 52 * numberOfDecksUsed;
    private final LinkedList<Player> participants = new LinkedList<>();
    public void addParticipant(Player participant) {
        participants.add(participant);
    }

    public void gameStart() {
        makeCards();
        makeDeck();

    }

    //todo gameTurn
    private void gameTurn() {
        //1.Bet
        //2.Shuffle if under 75 cards
        //3.one card each
        //4. one card each
        //5. check if someone has 21. he wins if the dealer doesn't have the same
        //5. one person gets cards until everyone is done. can double down if the sum is 9 - 11
        //6. dealer gets cards
    }


    private boolean shuffle() {
        cardsLeft = 52 * numberOfDecksUsed;
        System.out.println("Shuffling cards... //" + System.currentTimeMillis());
        for (int index = 0; index < currentDeck.size(); index++) {
            currentDeck.put((Card) currentDeck.keySet().toArray()[index], numberOfDecksUsed);
        }
        return true;
    }


    public void deal(Player player) {
        System.out.println("Dealing cards... //" + System.currentTimeMillis());
        Card cardDealt = null;
        int randomNum = randomNumGen.nextInt(cardsLeft);
        for (int index = 0; index < currentDeck.values().toArray().length; index++) {
            randomNum = randomNum - (int) currentDeck.values().toArray()[index];
            if (randomNum <= 0) {
                cardDealt = (Card) currentDeck.keySet().toArray()[index];
                break;
            }
        }
        player.addCard(cardDealt);
        cardsLeft--;

        player.raiseHandValue(cardDealt.getType().value);
        System.out.println("Card dealt: " + cardDealt.getType().symbol + cardDealt.getFace().symbol);
        System.out.println("Current value in your hand: " + player.getHandValue());
    }


    public void makeDeck() {
        System.out.println("Making the deck... //" + System.currentTimeMillis());
        for (Card card : deck) {
            currentDeck.put(card, numberOfDecksUsed);
        }
    }

    public void makeCards() {
        System.out.println("Creating the cards... //" + System.currentTimeMillis());
        for (int indexFace = 0; indexFace < CardFace.values().length; indexFace++) {
            for (int indexType = 0; indexType < CardType.values().length; indexType++) {
                deck.add(new Card(CardType.values()[indexType], CardFace.values()[indexFace]));
            }
        }
    }
}
