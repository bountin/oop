
/**
 *
 * @author Johannes Wawerda <johannes.wawerda@student.tuwien.ac.at>
 */
public class RandomCar extends FastCar {

    public RandomCar(String name, Orientation orientation, Position pos, Autodrom autodrom) {
        super(name, orientation, pos, autodrom);
    }

    /** Cannot move to field directly left or right
     * Strategy: Select random a field and move if its valid
     * @return Random new valid Position or old position if new one is not valid
     */
    @Override
    public Position getNextPosition() {
        Position pos = null;
        Orientation o = this.orientation;

        // random 0 to 2
        int r = (int) Math.floor(Math.random() * 3);
        if (orientation == Orientation.TOP) {
            if (r == 0) {
                pos = new Position(position.getX(), position.getY() + 1);
            } else if (r == 1) {
                pos = new Position(position.getX() + 1, position.getY() + 1);
                o = orientation.turnRight();
            } else if (r == 2) {
                pos = new Position(position.getX() - 1, position.getY() + 1);
                o = orientation.turnLeft();
            }
        } else if (orientation == Orientation.BOTTOM) {
            if (r == 0) {
                pos = new Position(position.getX(), position.getY() - 1);
            } else if (r == 1) {
                pos = new Position(position.getX() + 1, position.getY() - 1);
                o = orientation.turnLeft();
            } else if (r == 2) {
                pos = new Position(position.getX() - 1, position.getY() - 1);
                o = orientation.turnRight();
            }
        } else if (orientation == Orientation.LEFT) {
            if (r == 0) {
                pos = new Position(position.getX() - 1, position.getY());
            } else if (r == 1) {
                pos = new Position(position.getX() - 1, position.getY() + 1);
                o = orientation.turnRight();
            } else if (r == 2) {
                pos = new Position(position.getX() - 1, position.getY() - 1);
                o = orientation.turnLeft();
            }
        } else if (orientation == Orientation.RIGHT) {
            if (r == 0) {
                pos = new Position(position.getX() + 1, position.getY());
            } else if (r == 1) {
                pos = new Position(position.getX() + 1, position.getY() + 1);
                o = orientation.turnLeft();
            } else if (r == 2) {
                pos = new Position(position.getX() + 1, position.getY() - 1);
                o = orientation.turnRight();
            }
        }
        this.orientation = o;
        if (autodrom.isValidPosition(pos)) {
            return pos;
        } else {
            return this.position;
        }
    }
}
