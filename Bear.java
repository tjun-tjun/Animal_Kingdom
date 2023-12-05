import java.awt.*;

public class Bear extends Critter {
    // Instance variables to store bear properties
    private boolean polar; // Indicates if it's a polar bear
    private Color color;   // The bear's color
    private String representation; // How the bear looks

    // Constructor to create a bear
    public Bear(boolean polar) {
        this.polar = polar; // Set the polar status based on input
        // If it's a polar bear, make it white; otherwise, make it black
        this.color = polar ? Color.WHITE : Color.BLACK;
        // Start by looking like this: /
        this.representation = "/";
    }

    // Get the bear's color
    public Color getColor() {
        return color;
    }

    // Determine how the bear looks (visual representation)
    public String toString() {
        // Switch between / and \ to look like it's waving
        if (representation.equals("/")) {
            representation = "\\";
        } else {
            representation = "/";
        }
        return representation;
    }

    // Decide how the bear moves
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            // If there's an enemy in front, attack (infect)
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            // If the front is clear, jump (hop) forward
            return Action.HOP;
        } else {
            // If there's a wall or another bear in front, turn left
            return Action.LEFT;
        }
    }
}
