import java.awt.Color;
import java.util.Random;

public class NinjaCat extends Critter {
    private Random random;   // Used to make random decisions for our NinjaCat.

    public NinjaCat() {
        random = new Random(); // When a NinjaCat is created, it sets up a random number generator.
    }

    @Override
    public Color getColor() {
        return Color.pink;  // NinjaCats are pink in color
    }

    @Override
    public String toString() {
        return "NjC";  // When you look at a NinjaCat, it appears as "NjC."
    }

    @Override
    public Action getMove(CritterInfo info) {
        // NinjaCat move unpredictability:
        // Initialize an array of possible actions based on the situation.
        Action[] possibleActions;

        if (info.getFront() == Neighbor.OTHER) {
            // If there is another critter in front, NinjaCat can try to infect it.
            possibleActions = new Action[]{Action.HOP, Action.LEFT, Action.RIGHT, Action.INFECT};
        } else {
            // If there is no critter in front, it can perform regular movements.
            possibleActions = new Action[]{Action.HOP, Action.LEFT, Action.RIGHT};
        }

        // The NinjaCat randomly selects one of these actions for each move.
        return possibleActions[random.nextInt(possibleActions.length)];
    }
}
