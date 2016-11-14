/**
 * Created by posam on 2016-11-14.
 */
public class Workshop01 {
    public static void main(String... args) {
        Car myCar1 = new Car();
        Car myCar2 = new Car("Ford", "silver", 2500, 152312);
        Car myCar3 = new Car("Beamer", "green", 2800, 42521);

        // km's set to 12312
        // type should be Mazda
        //sout "This %s is %s, has %d cc engine and clocked %d km's\n"
        System.out.printf("This %s is %s, has %d cc engine and clocked %d km's\n", myCar1.getTypeCar(), myCar1.getColor(), myCar1.getCcs(), myCar1.getKmOdometer());
        System.out.printf("This %s is %s, has %d cc engine and clocked %d km's\n", myCar2.getTypeCar(), myCar2.getColor(), myCar2.getCcs(), myCar2.getKmOdometer());
        System.out.printf("This %s is %s, has %d cc engine and clocked %d km's\n", myCar3.getTypeCar(), myCar3.getColor(), myCar3.getCcs(), myCar3.getKmOdometer());
        System.out.println("");
        myCar3.drive(49);
        myCar2.drive(1200);
        System.out.printf("This %s is %s, has %d cc engine and clocked %d km's\n", myCar3.getTypeCar(), myCar3.getColor(), myCar3.getCcs(), myCar3.getKmOdometer());
        System.out.printf("This %s is %s, has %d cc engine and clocked %d km's\n", myCar2.getTypeCar(), myCar2.getColor(), myCar2.getCcs(), myCar2.getKmOdometer());
        // 05
        System.out.println("-----------05------------");
        System.out.println(myCar1.toString());
        // 06
        System.out.println("-----------06------------");
        Car myCar05 = new Car("Opel", "white", 1400, 25);
        Car myCar06 = new Car("VW", "grey"); // defaults to 1600 cc, 10 kms
        Car myCar07 = new Car(1100, 15); // defaults to a red Mazda
        System.out.println(myCar1.toString());
        System.out.println(myCar2.toString());
        System.out.println(myCar3.toString());
        System.out.println(myCar05.toString());
        System.out.println(myCar06.toString());
        System.out.println(myCar07.toString());


    }
}