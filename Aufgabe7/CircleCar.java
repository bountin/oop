/**
 *
 * @author Johannes Wawerda <johannes.wawerda@student.tuwien.ac.at>
 */
public class CircleCar extends SlowCar{

    public CircleCar(String name, Orientation orientation, Position pos, Autodrom autodrom) {
        super(name, orientation, pos, autodrom);
    }
    
    
    // Strategy: Always drives a closely right-turned circle
    @Override
    public Position getNextPosition() {
        Position pos = null;
        orientation = orientation.turnRight();
        if (orientation == Orientation.TOP) {
            pos = new Position(position.getX() + 1, position.getY());
        } else if (orientation == Orientation.BOTTOM) {
            pos = new Position(position.getX() + 1, position.getY());
        } else if (orientation == Orientation.RIGHT) {
            pos = new Position(position.getX(), position.getY() - 1);
        } else if (orientation == Orientation.LEFT) {
            pos = new Position(position.getX(), position.getY() + 1);
        }
        if (autodrom.isValidPosition(pos)) {
            return pos;
        } else {
            return this.position;
        }
    }    
}
