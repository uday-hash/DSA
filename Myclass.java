class Animal {
    void eat() {
        System.out.println("eating...");
    }
}

class Dog extends Animal {
    void eat() {
        super.eat();
        System.out.println("eating bread...");
    }

    void bark() {
        System.out.println("barking...");
    }

    void work() {
        eat();
        bark();
    }
}

public class Myclass {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.work();
    }
}