package week9;

public class PolyDriver {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();
        Cat cat = new Cat();
/*
        animal.makeSound();
        dog.makeSound();
        cat.makeSound();

        Animal animal1 = new Dog();
        animal1.makeSound();
        animal1 = cat;
        animal1.makeSound();
*/
        Animal animal2 = new Dog();
        ((Dog)animal2).chaseTail();
    }
}
