
/**
 *
 * @author Johannes Wawerda <johannes.wawerda@student.tuwien.ac.at>
 */
public class Field {
    private Car car;

    /**
     * Returns Auto or Null if there is no Auto
     * @return 
     */
    public Car getCar() {
        return car;
    }

    /**
     * Sets on this Field
     * Is only called with null, if car is not null!
     * @param auto 
     */
    public void setCar(Car car) {
        this.car = car;
    }
    
    
}
