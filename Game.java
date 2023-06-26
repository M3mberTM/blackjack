import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class Game {
    private final int numberOfDecksUsed = 1;
    private HashMap<Card, Integer> currentDeck = new HashMap<Card, Integer>();
    private LinkedList<Card> deck = new LinkedList<Card>();
    Random randomNumGen = new Random();

    //todo gameStart
    public void gameStart() {
        makeCards();
        makeDeck();
        //setting up of things
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

    //todo finish betting
    private boolean bet() {
        return false;
    }

    //todo finish shuffle
    private boolean shuffle() {
        System.out.println("Shuffling cards... //" + System.currentTimeMillis());
        for (int index = 0; index < currentDeck.size(); index++) {
            currentDeck.put((Card) currentDeck.keySet().toArray()[index], numberOfDecksUsed);
        }
        return true;
    }


    private boolean deal() {
        System.out.println("Dealing cards... //" + System.currentTimeMillis());
        boolean isCardDealt = false;
        while (!isCardDealt) {
            Card cardDealt = (Card) currentDeck.keySet().toArray()[randomNumGen.nextInt(53)];
            if (currentDeck.get(cardDealt) < 0) {
                currentDeck.put(cardDealt, currentDeck.get(cardDealt) - 1);
                isCardDealt = true;
            }
        }
        return true;
    }


    public boolean makeDeck() {
        System.out.println("Making the deck... //" + System.currentTimeMillis());
        for (int index = 0; index < deck.size(); index++) {
            currentDeck.put(deck.get(index), numberOfDecksUsed);
        }
        if (currentDeck.size() == 52 && currentDeck.get(currentDeck.keySet().toArray()[randomNumGen.nextInt(52 + 1)]) == numberOfDecksUsed) {
            return true;
        }
        return false;
    }

    public boolean makeCards() {
        System.out.println("Creating the cards... //" + System.currentTimeMillis());
        for (int indexFace = 0; indexFace < CardFace.values().length; indexFace++) {
            for (int indexType = 0; indexType < CardType.values().length; indexType++) {
                deck.add(new Card(CardType.values()[indexType], CardFace.values()[indexFace]));
            }
        }
        if (deck.size() == 52) {
            return true;
        }
        return false;
    }
}
