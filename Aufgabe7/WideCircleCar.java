/**
 *
 * @author Johannes Wawerda <johannes.wawerda@student.tuwien.ac.at>
 */
public class WideCircleCar extends SlowCar {

    private int count = 0;

    public WideCircleCar(String name, Orientation orientation, Position pos, Autodrom autodrom) {
        super(name, orientation, pos, autodrom);
    }

    /**
     * Strategy: Always drives a wide left-turned circle
     * returns new position if valid, otherwise old position
     */ 
    @Override
    public Position getNextPosition() {
        Position pos = null;
        if (orientation == Orientation.TOP) {
            if (count == 0) {
                pos = new Position(position.getX(), position.getY() + 1);
            } else if (count == 1) {
                pos = new Position(position.getX() - 1, position.getY());
                orientation = orientation.turnLeft();
            }
        } else if (orientation == Orientation.BOTTOM) {
            if (count == 0) {
                pos = new Position(position.getX(), position.getY() - 1);
            } else if (count == 1) {
                pos = new Position(position.getX() + 1, position.getY());
                orientation = orientation.turnLeft();
            }
        } else if (orientation == Orientation.RIGHT) {
            if (count == 0) {
                pos = new Position(position.getX() + 1, position.getY());
            } else if (count == 1) {
                pos = new Position(position.getX(), position.getY() + 1);
                orientation = orientation.turnLeft();
            }
        } else if (orientation == Orientation.LEFT) {
            if (count == 0) {
                pos = new Position(position.getX() - 1, position.getY());
            } else if (count == 1) {
                pos = new Position(position.getX(), position.getY() - 1);
                orientation = orientation.turnLeft();
            }
        }
        if(count == 0) {
            count = 1;
        }else {
            count = 0;
        }
        if (autodrom.isValidPosition(pos)) {
            return pos;
        } else {
            return this.position;
        }
    }
}
