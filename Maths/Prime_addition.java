/*You are given an even number N and you need to represent the given 
number as the sum of primes. The prime numbers do not necessarily have 
to be distinct. It is guaranteed that at least one possible solution exists.

You need to determine the minimum number of prime numbers needed to represent 
the given number.
 */

package Maths;

public class Prime_addition {
    public int solve(int A) {
        int count = 0;
        for (int i = 2; i <= A; i++) {
            if (isPrime(i)) {
                count++;
                A = A - i;
            }
        }
        return count;
        
    }

    private boolean isPrime(int num) {
        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Prime_addition p = new Prime_addition();
        System.out.println(p.solve(4));
    }
}