/**
 * Created by posam on 2016-11-15.
 */
public class GarageApp {
    public static void main(String[] args) {
        Garage gar = new Garage(7);
        for (Object c : gar)
            System.out.println(c);
        gar.addCar("Nissan GTR", "silver", 5000);
        System.out.println("-------------------");
        for (Object c : gar)
            System.out.println(c);
    }
}
