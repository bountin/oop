
/**
 *
 * @author Johannes Wawerda <johannes.wawerda@student.tuwien.ac.at>
 */
public abstract class SlowCar extends Car {

    public SlowCar(String name, Orientation orientation, Position pos, Autodrom autodrom) {
        super(name, orientation, pos, autodrom);
        this.wait = 10;
    }
}
