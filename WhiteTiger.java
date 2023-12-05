import java.awt.*;

public class WhiteTiger extends Critter {
    private boolean infected; // This variable keeps track of whether the WhiteTiger is infected.
    private int moveCount;    // This variable counts how many moves the WhiteTiger has made.

    public WhiteTiger() {
        infected = false;    // When a WhiteTiger is created, it's initially not infected.
        moveCount = 0;       // Initialize the move count to zero.
    }

    @Override
    public Color getColor() {
        if (infected) {
            return Color.WHITE; // If the WhiteTiger is infected, it appears white.
        } else {
            return Color.WHITE; // If not infected, it still appears white.
        }
    }

    @Override
    public String toString() {
        if (infected) {
            return "TGR"; // If infected, its string representation is "TGR" (capital letters).
        } else {
            return "tgr"; // If not infected, its string representation is "tgr" (lowercase letters).
        }
    }

    @Override
    public Action getMove(CritterInfo info) {
        moveCount++; // Increment the move count every time this method is called.

        if (info.getFront() == Neighbor.OTHER) {
            infected = true; // If there's an enemy in front, the WhiteTiger attacks and infects it.
            return Action.INFECT; // Return the action to infect.
        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT; // If there's a wall ahead or to the right, turn to the left.
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT; // If there's a fellow WhiteTiger ahead, turn to the right.
        } else {
            return Action.HOP; // If none of the above conditions apply, hop forward.
        }
    }
}
