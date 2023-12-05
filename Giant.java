import java.awt.Color;

public class Giant extends Critter {
    private int moveCount;          // Keeps track of how many moves our Giant has made.
    private String[] phrases = {"fee", "fie", "foe", "fum"}; // Phrases our Giant will say.

    public Giant() {
        moveCount = 0;  // When a Giant is created, we start counting its moves at 0.
    }

    @Override
    public Color getColor() {
        return Color.GRAY;  // Giants are always gray in color, as per the instructions.
    }

    @Override
    public String toString() {
        int period = 6;  // Change the displayed string every 6 moves.
        int index = moveCount / period % phrases.length;  // Choose a phrase based on move count.
        return phrases[index];  // The Giant's appearance text changes based on its move count.
    }

    @Override
    public Action getMove(CritterInfo info) {
        moveCount++;  // Every time the Giant moves, we increase its move count.

        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT; // If there's an enemy in front, the Giant attacks by infecting.
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP; // If the path is clear, the Giant hops forward.
        } else {
            return Action.RIGHT; // If there's a wall or another Giant ahead, the Giant turns right.
        }
    }
}
