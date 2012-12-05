
/**
 *
 * @author Johannes Wawerda <johannes.wawerda@student.tuwien.ac.at>
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        Autodrom autodrom1 = new Autodrom(10, 15);

        System.out.println("Plays a Game with 10x15 and only RandomCars");
        for (int i = 0; i < 10; i = i + 2) {
            for (int j = 0; j < 15; j = j + 2) {
                Car c = new RandomCar("Game 1: RandomCar" + i + "/" + j, Orientation.BOTTOM, new Position(i, j), autodrom1);
                autodrom1.addCar(c);
            }
        }
        autodrom1.startGame();

        Thread.sleep(800);

        Autodrom autodrom2 = new Autodrom(15, 15);
        System.out.println("Plays a Game with 15x15 and with CircleCars und RandomCars");
        for (int i = 0; i < 15; i = i + 6) {
            for (int j = 0; j < 15; j = j + 6) {
                Car c = new RandomCar("Game 2: RandomCar" + i + "/" + j, Orientation.RIGHT, new Position(i, j), autodrom2);
                autodrom2.addCar(c);
            }
        }
        for (int i = 3; i < 15; i = i + 6) {
            for (int j = 3; j < 15; j = j + 6) {
                Car c = new CircleCar("Game 2: CircleCar" + i + "/" + j, Orientation.TOP, new Position(i, j), autodrom2);
                autodrom2.addCar(c);
            }
        }
        autodrom2.startGame();
        
        Thread.sleep(800);

        Autodrom autodrom3 = new Autodrom(15, 15);
        System.out.println("Plays a Game with 15x15 and with CircleCars und RandomCars");
        for (int i = 0; i < 15; i = i + 5) {
            for (int j = 0; j < 15; j = j + 5) {
                Car c = new RandomCar("Game 3: RandomCar" + i + "/" + j, Orientation.RIGHT, new Position(i, j), autodrom3);
                autodrom3.addCar(c);
            }
        }
        for (int i = 4; i < 15; i = i + 4) {
            for (int j = 4; j < 15; j = j + 4) {
                Car c = new CircleCar("Game 3: CircleCar" + i + "/" + j, Orientation.TOP, new Position(i, j), autodrom3);
                autodrom3.addCar(c);
            }
        }
        autodrom3.startGame();        
        
        
        Thread.sleep(800);

        Autodrom autodrom4 = new Autodrom(15, 15);
        System.out.println("Plays a Game with 15x15 and with WideCircleCars und RandomCars");
        for (int i = 0; i < 15; i = i + 3) {
            for (int j = 0; j < 15; j = j + 3) {
                Car c = new RandomCar("Game 4: RandomCar" + i + "/" + j, Orientation.RIGHT, new Position(i, j), autodrom4);
                autodrom4.addCar(c);
            }
        }
        for (int i = 1; i < 15; i = i + 3) {
            for (int j = 1; j < 15; j = j + 3) {
                Car c = new WideCircleCar("Game 4: WideCircleCars" + i + "/" + j, Orientation.LEFT, new Position(i, j), autodrom4);
                autodrom4.addCar(c);
            }
        }
        autodrom4.startGame();           
    }
}
