import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Garage extends ArrayList<Car> {

    static ArrayList<String> colors = new ArrayList<>(Arrays.asList("white", "blue", "red", "silver", "black", "green", "banana"));
    static ArrayList<String> types = new ArrayList<>(Arrays.asList("Toyota", "Mazda", "BMW", "VW", "Opel", "Suzuki", "Ford", "Mercedes"));
    static ArrayList<Integer> engines = new ArrayList<>(Arrays.asList(1100, 1400, 1600, 1800, 2500));
    static private int carCount = -1;

    public Garage(int size) {
        makeRndCar(this, size);
    }

    public Garage() {
        makeRndCar(this, 5);
    }

    public void addRandomCar() {
        makeRndCar(this, 1);
    }
    public void addCar(String type, String color, int ccs) {
        Car c = new Car();
        c.setTypeCar(type);
        c.setColor(color);
        c.setCcs(ccs);
        this.add(c);
        carCount++;
    }

//    public void addCar()
    static Random rand = new Random();
    static <T> T getRandomItem(List<T> list) {
        return list.get(rand.nextInt(list.size()));
    }

public void makeRndCar (ArrayList<Car> arr, int size) {
    for (int i = 0; i < size; i++) {
        Car c = new Car();
        c.setColor(getRandomItem(colors));
        c.setTypeCar(getRandomItem(types));
        c.setCcs(getRandomItem(engines));
        arr.add(c);
        carCount++;
    }
}
}