import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards = new ArrayList<>();

    // Add a card to the hand
    public void deal(Card card) {
        cards.add(card);
    }

    // Calculate the total value of the hand
    public int getValue() {
        int value = 0;
        for (Card card : cards) {
            value += card.getValue();
        }
        return value;
    }

    // For printing the hand (e.g., [10 of Hearts, A of Spades])
    @Override
    public String toString() {
        return cards.toString();
    }
}
