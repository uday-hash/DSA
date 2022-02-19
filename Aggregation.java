class Operation {
    int add(int n) {
        return n + n;
    }
}

public class Aggregation {
    int pi = 2;

    int area(int radius) {
        Operation op = new Operation();
        int rsquare = op.add(radius);
        return pi * rsquare;
    }

    public static void main(String[] args) {
        Aggregation c = new Aggregation();
        int result = c.area(2);
        System.out.println(result);
    }
}
