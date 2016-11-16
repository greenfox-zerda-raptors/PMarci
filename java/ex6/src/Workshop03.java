/**
 * Created by posam on 2016-11-16.
 */
public class Workshop03 {
        public static void main(String[] args) {
            Animal animal = new Animal();
            Bird bird = new Bird();
            Dog dog = new Dog();

            System.out.println("Testing Animal");
            // how does it speak, sleep, and tell me about its lifeExpectancy and if its a carnivore
            // animal.
            animal.speak();
            animal.sleep();
            System.out.println(animal.toString());
            System.out.println("\nTesting Bird");
            // how does it speak, sleep, what else it can do and tell me about its lifeExpectancy and if its a carnivore
            bird.speak();
            bird.sleep();
            bird.fly();
            System.out.println(bird.toString());

            System.out.println("\nTesting Dog");
            dog.speak();
            dog.sleep();
            dog.beg();
            System.out.println(dog.toString());
            // how does it speak, sleep, what else it can do and tell me about its lifeExpectancy and if its a carnivore, and what about the tail?


            System.out.println("\nTesting Dog2");
            Animal dog2 = new Dog();
            // how does it speak, sleep, what else it can do and tell me about its lifeExpectancy and if its a carnivore, and what about the tail?
            dog.speak();
            dog.sleep();
            dog.beg();
            if (dog2 instanceof Dog){
                Dog Y = (Dog) dog2;
                Y.hasTail=false;
                Y.lifeExpectancy=22;
                System.out.println("Casting dog2 into Y to see if it begs...");
                Y.beg();
                System.out.println("And a dog2 cast as (Dog) Y: " + Y.toString());
            }

            System.out.println("\nTesting Dog 'd'");
            Dog d = new Dog();
            if (d instanceof Animal) {
                Animal a = (Animal) d;
                a.speak();
                a.sleep();
                System.out.println(a.toString());
            }
            // how does it speak, sleep, what else it can do and tell me about its lifeExpectancy and if its a carnivore, and what about the tail?

        }
    }
