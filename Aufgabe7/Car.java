
/**
 *
 * @author Johannes Wawerda <johannes.wawerda@student.tuwien.ac.at>
 */
public abstract class Car extends Thread {

    protected Orientation orientation;
    private int points;
    protected Position position;
    protected int wait;
    protected Autodrom autodrom;
    private String name;

    /**
     * Creates a auto
     * @param name name of the car
     * @param orientation starting orientation of the auto
     * @param pos position must bei in the autodrom, 
     *  pos.x >= 0, pos.y >= 0, pos.x < autodrom.width, pos.y < autodrom.height
     * @param autodrom autodromon wich the auto moves
     */
    public Car(String name, Orientation orientation, Position pos, Autodrom autodrom) {
        this.orientation = orientation;
        this.position = pos;
        this.autodrom = autodrom;
        this.name = name;
    }

    /**
     * Increments Points. If Points reach 10 then ends game.
     */
    public synchronized void incPoints() {
        points++;
        if (points == 10) {
            autodrom.endGame();
        }
    }

    /**
     * Decrement Points
     */
    public synchronized void decPoints() {
        points--;
    }

    /**
     * Returns the position where the auto drives in next step. 
     * The position has to be a neighbour of the actuall position and not one of 
     * the three fields behind the actual position.
     * Position must be in the autodrom
     * Changes orientation if the new position is not directly in front (90 deg 
     * left or 90 deg right)
     * Position.x >= 0, Position.y >= 0, Position.x < autodrom.width, Position.y < autodrom.height
     * @return 
     */
    public abstract Position getNextPosition();


    @Override
    public void run() {
        // ends automatically after 50000 turns
        for (int i = 0; i < 50000 && autodrom.isRunning(); i++) {
            try {
                Thread.sleep(wait);
            } catch (InterruptedException ex) {
                System.out.println(this + ": " + points);
                return;
            }
            Position p = this.getNextPosition();
            if (!p.equals(position)) {
                Field f = autodrom.getPlayingfield()[p.getX()][p.getY()];
                Car car = f.getCar();
                synchronized (f) {
                    if (car == null) {
                        Field act_f = autodrom.getPlayingfield()[position.getX()][position.getY()];
                        f.setCar(this);
                        position = p;
                        act_f.setCar(null);  // is threadsave because acf_f has a not null auto and setAuto(null) is only called if the auto is not null
                    } else {
                        this.incPoints();
                        if (orientation == car.orientation.getOpposite()) {
                            car.decPoints();
                        }
                    }
                }
            }
        }
        System.out.println(this + ": " + points);
        return;
    }

    @Override
    public String toString() {
        return name;
    }
}
