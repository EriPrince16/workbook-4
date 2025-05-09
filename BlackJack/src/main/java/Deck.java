import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<>();

    // Constructor: build a standard deck
    public Deck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        // Create one of each card and add it to the deck
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    // Randomize the deck
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Deal one card from the top of the deck
    public Card deal() {
        return cards.remove(0); // also shrinks the deck
    }
}