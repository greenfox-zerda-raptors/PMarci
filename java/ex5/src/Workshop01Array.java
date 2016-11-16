import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Workshop01Array {
    static int carCount = -1;
    static Random rand = new Random();
    static <T> T getRandomItem(List<T> list) {
        return list.get(rand.nextInt(list.size()));
    }
    public static void makeRndCar (ArrayList<Car> arr, int size) {
        for (int i = 0; i < size; i++) {
            Car car = new Car();
            car.setColor(getRandomItem(colors));
            car.setTypeCar(getRandomItem(types));
            car.setCcs(getRandomItem(engines));
            arr.add(car);
            carCount++;
        }
    }
    static ArrayList<String> colors = new ArrayList<>(Arrays.asList("white", "blue", "red", "silver", "black", "green", "banana"));
    static ArrayList<String> types = new ArrayList<>(Arrays.asList("Toyota", "Mazda", "BMW", "VW", "Opel", "Suzuki", "Ford", "Mercedes"));
    static ArrayList<Integer> engines = new ArrayList<>(Arrays.asList(1100, 1400, 1600, 1800, 2500));
    static ArrayList<Car> lsCars = new ArrayList<>(10); //I know 10 is not necessary

    public static void main(String[] args) {
        System.out.println("Number of Cars Available = " + carCount);
        makeRndCar(lsCars, 1);
        System.out.println("Number of Cars Available = " + carCount);
        makeRndCar(lsCars, 1);
        System.out.println("Number of Cars Available = " + carCount);
        makeRndCar(lsCars, 8);
        System.out.println("Number of Cars Available = " + carCount);
        lsCars.get(0).drive(5);
        lsCars.get(1).drive(7);
        for (Car c : lsCars) {
            System.out.println(c);
        }
    }
}
