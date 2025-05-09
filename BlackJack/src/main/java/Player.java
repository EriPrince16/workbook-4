public class Player {
    private String name;  // Player's name
    private Hand hand;    // The cards they hold

    // Constructor: create a player with a name and a hand
    public Player(String name, Hand hand) {
        this.name = name;
        this.hand = hand;
    }

    // Get the player's name
    public String getName() {
        return name;
    }

    // Get the player's hand
    public Hand getHand() {
        return hand;
    }

    // Get the value of the player's hand
    public int getValue() {
        return hand.getValue();
    }
}