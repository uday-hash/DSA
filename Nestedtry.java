public class Nestedtry {
    public static void main(String[] args) {
        try {
            try {
                try {
                    int a = 10 / 0;
                } catch (ArrayIndexOutofBoundsException e) {
                    System.out.println("ArrayIndexOutofBoundsException exception");
                    // TODO: handle exception
                }
            } catch (ArrayIndexOutofBoundsException e) {
                System.out.println("ArrayIndexOutofBoundsException exception");
                System.out.println("inner try block");
                // TODO: handle exception
            }
        } catch (ArithmeticException e4) {
            System.out.println("ArithmeticException exception");
            System.out.println("oter try block");
            // TODO: handle exception
        } catch (exception e5) {
            System.out.println("Exception");
        }
    }
}