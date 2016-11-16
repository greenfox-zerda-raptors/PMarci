/**
 * Created by posam on 2016-11-15.
 */
public class Bird extends Animal {
    public Bird() {
        super(2, false);
        System.out.println("New bird.");
    }
    public void fly() {
        System.out.println("The bird can fly.");
    }
    public void sleep() {
        System.out.println("The bird is sleeping.");
        super.sleep();
    }
    public void eat() {
        System.out.println("The bird is eating.");
        super.sleep();
    }

    public void speak() {
        System.out.println("chirps");
    }

    public void nightyNight() {
        super.eat();
        sleep();
    }
}
