public class Card {
    private String rank; // The value of the card: 2–10, J, Q, K, A
    private String suit; // The suit: Hearts, Diamonds, Clubs, Spades

    // Constructor: used when creating a card
    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // This method returns how many points the card is worth
    public int getValue() {
        switch (rank) {
            case "J": case "Q": case "K": return 10; // Face cards = 10 points
            case "A": return 11;                    // Ace = 11 points (simple rule)
            default: return Integer.parseInt(rank); // Number cards = their number
        }
    }

    // Returns a string like "10 of Hearts"
    public String toString() {
        return rank + " of " + suit;
    }
}