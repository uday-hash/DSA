class Parent {
    int age = 60;
}

class Child extends Parent {
    int age = 30;

    public static void main(String[] args) {
        Parent obj = new Child();
        System.out.println(obj.age);
    }
}