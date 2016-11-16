
public class Animal {

    public int lifeExpectancy = 10;
    public boolean isCarnivore = false;
    public boolean hasTail;

    public Animal() {
        System.out.println("Created an animal.");
    }
    public Animal(int lifeExpectancy, boolean isCarnivore) {
        this.lifeExpectancy = lifeExpectancy;
        this.isCarnivore = isCarnivore;
    }

    public void sleep() {
        System.out.println("Animal is sleeping.");
    }
    public void eat() {
        System.out.println("Animal is eating.");
    }
    public String toString() {
        return String.format("isCarnivore=%b lifeExpectancy=%d", this.isCarnivore, this.lifeExpectancy);
    }
    public void speak() {
        System.out.println("Animal speaks.");
    }
}
