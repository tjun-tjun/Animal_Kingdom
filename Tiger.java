import java.awt.*;
import java.util.Random;

public class Tiger extends Critter {
    private Color color;            // The tiger's color
    private int moveCount;          // Count of moves
    private String representation;  // How the tiger looks

    public Tiger() {
        // Initialize the move count and choose an initial color
        moveCount = 0;
        chooseRandomColor();
        // Start by looking like this: TGR
        representation = "TGR";
    }

    // Choose a random color for the tiger
    private void chooseRandomColor() {
        Random random = new Random();
        int colorChoice = random.nextInt(3);
        switch (colorChoice) {
            case 0:
                color = Color.RED;
                break;
            case 1:
                color = Color.GREEN;
                break;
            case 2:
                color = Color.BLUE;
                break;
        }
    }

    public Color getColor() {
        return color;
    }

    public String toString() {
        return representation;
    }

    public Action getMove(CritterInfo info) {
        moveCount++;
        if (moveCount >= 3) {
            // After every 3 moves, choose a new random color
            chooseRandomColor();
            moveCount = 0;
        }

        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT; // Attack if there's an enemy ahead
        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;   // Turn left if there's a wall ahead or to the right
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;  // Turn right if there's a fellow Tiger ahead
        } else {
            return Action.HOP;    // Jump forward if it's clear
        }
    }
}
