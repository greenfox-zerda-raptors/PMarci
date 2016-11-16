/**
 * Created by posam on 2016-11-16.
 */
public class Dog extends Animal {
    public Dog() {
        super(15, true);
        hasTail = true;
        System.out.println("New dog.");
    }
    public String toString() {
        return String.format("isCarnivore=%b lifeExpectancy=%d and hasTail=%b", this.isCarnivore, this.lifeExpectancy, hasTail);
    }
    public void speak() {
        System.out.println("barks");;
    }
    public void beg() {
        System.out.println("begs");
    }
}
