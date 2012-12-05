
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Johannes Wawerda <johannes.wawerda@student.tuwien.ac.at>
 */
public class Autodrom {

    private Field[][] playingfield;
    private int height;
    private int width;
    private List<Car> autos;
    private boolean running = false;

    public Autodrom(int width, int height) {
        this.height = height;
        this.width = width;
        this.autos = new ArrayList<Car>();
        playingfield = new Field[width][height];
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                playingfield[i][j] = new Field();
            }
        }
    }

    /**
     * Height of the playingfield
     * @return 
     */
    public int getHeight() {
        return height;
    }

    /**
     * Returns the Playingfield
     * @return 
     */    
    public Field[][] getPlayingfield() {
        return playingfield;
    }

    /**
     * Width of the playingfield
     * @return 
     */    
    public int getWidth() {
        return width;
    }

    /**
     * Adds a car to the carlist. A car added must not have equale position 
     * like a other car in the list.
     * @param a 
     */
    public void addCar(Car a) {
        autos.add(a);
    }

    /**
     * Ends the game.
     */
    public synchronized void endGame() {
        this.running = false;
        for (Car a : autos) {
            a.interrupt();        
        }
    }

    /**
     * Starts the game with all cars in the carlist (added by addCar)
     */
    public void startGame() {
        this.running = true;
        for (Car a : autos) {
            a.start();
        }
    }
    
    /**
     * true if the Game if running, otherwise false
     * @return 
     */
    public boolean isRunning() {
        return this.running;
    }

    /**
     * true if the position pos is in the playingfield
     * false if its outside
     * @param pos 
     * @return 
     */
    public boolean isValidPosition(Position pos) {
        return pos.getX() >= 0 && pos.getY() >= 0
                && pos.getX() < this.width && pos.getY() < this.height;
    }
}
