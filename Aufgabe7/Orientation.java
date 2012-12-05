
/**
 * orientation enum with logic to turn and get opposite 
 * @author Johannes Wawerda <johannes.wawerda@student.tuwien.ac.at>
 */
public enum Orientation {

    LEFT, TOP, RIGHT, BOTTOM;

    public Orientation getOpposite() {
        if (this == LEFT) {
            return RIGHT;
        } else if (this == RIGHT) {
            return LEFT;
        } else if (this == TOP) {
            return BOTTOM;
        } else {
            return TOP;
        }
    }

    public Orientation turnLeft() {
        if (this == LEFT) {
            return BOTTOM;
        } else if (this == RIGHT) {
            return TOP;
        } else if (this == TOP) {
            return LEFT;
        } else {
            return RIGHT;
        }
    }

    public Orientation turnRight() {
        if (this == LEFT) {
            return TOP;
        } else if (this == RIGHT) {
            return BOTTOM;
        } else if (this == TOP) {
            return RIGHT;
        } else {
            return LEFT;
        }
    }
}
