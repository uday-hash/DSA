package Bit_manipulation;

public class Number_of_1_bits {
    public int numSetBits(int A) {
        int count = 0;
        while (A != 0) {
            A = A & (A - 1);
            count++;
        }
        return count;
        
    }
    public static void main(String[] args) {
        Number_of_1_bits n1b = new Number_of_1_bits();
        System.out.println(n1b.numSetBits(11));
    }
}
