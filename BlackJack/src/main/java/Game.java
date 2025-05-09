import java.util.ArrayList;

public class Game {

    public static void main(String[] args) {
        // Step 1: Create a deck and shuffle it
        Deck deck = new Deck();    // A full deck of 52 cards
        deck.shuffle();            // Shuffle to randomize the order

        // Step 2: Set up a table of players
        ArrayList<Player> table = new ArrayList<>();  // List to hold all the players

        // Step 3: These are the names of the players who will play the game
        String[] names = {"Izel", "Million", "Noah", "Gio"};

        // Step 4: For each name, create a player and deal 2 cards to their hand
        for (String name : names) {
            Hand hand = new Hand();  // Create a new empty hand

            // Deal 2 cards to each player
            for (int i = 0; i < 2; i++) {
                Card currentCard = deck.deal(); // Take the top card from the deck
                hand.deal(currentCard);         // Add it to the hand
            }

            // Create a new player with a name and their hand
            Player player = new Player(name, hand);

            // Add the player to the table
            table.add(player);
        }

        // Step 5: Determine the winner
        Player winner = null;  // Start with no winner

        for (Player player : table) {
            int value = player.getValue();  // Get total points of player's hand

            // Print each player's name and score
            System.out.println("Player " + player.getName() + " value: " + value);

            // Step 6: Check if the player is the new winner
            if (value <= 21) { // Player must be 21 or less to be eligible
                if (winner == null || value > winner.getValue()) {
                    winner = player;  // This player becomes the new winner
                }
            }
        }

        // Step 7: Show the winner or no winner
        if (winner != null) {
            System.out.println("🏆 Winner is " + winner.getName() + " with " + winner.getValue() + " points!");
        } else {
            System.out.println("😵 No winner — everyone busted!");
        }
    }
}