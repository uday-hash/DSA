/*Problem Description
A lucky number is a number that has exactly 2 distinct prime divisors.

You are given a number A, and you need to determine the count of lucky numbers between the range 1 to A (both inclusive).



Problem Constraints
1 <= A <= 50000 */

package Maths;

public class Lucky_numbers {
    public int solve(int A) {
        int count = 0;
        for (int i = 1; i <= A; i++) {
            if (isLucky(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isLucky(int num) {
        int count = 0;
        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                count++;
                while (num % i == 0) {
                    num = num / i;
                }
            }
        }
        return count == 2;
    }
    public static void main(String[] args) {
        Lucky_numbers l = new Lucky_numbers();
        System.out.println(l.solve(5));
    }
}
        