
/**
 * Cannot move to field directly left or right
 * @author Johannes Wawerda <johannes.wawerda@student.tuwien.ac.at>
 */
public abstract class FastCar extends Car {

    public FastCar(String name, Orientation orientation, Position pos, Autodrom autodrom) {
        super(name, orientation, pos, autodrom);
        this.wait = 5;
    }

}
