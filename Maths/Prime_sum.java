/*
 * Problem Description
Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to the given number.

If there is more than one solution possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then 
[a, b] < [c, d], If a < c OR a==c AND b < d. 
NOTE: A solution will always exist. Read Goldbach's conjecture.



Problem Constraints
4 <= A <= 2*107
 */

package Maths;

import java.util.ArrayList;

public class Prime_sum {
    public ArrayList<Integer> primesum(int A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        boolean[] isPrime = new boolean[A + 1];
        for (int i = 0; i <= A; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= A; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= A; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i <= A; i++) {
            if (isPrime[i] && isPrime[A - i]) {
                res.add(i);
                res.add(A - i);
                break;
            }
        }
        return res;

    }
    public static void main(String[] args) {
        Prime_sum p = new Prime_sum();
        System.out.println(p.primesum(4));
    }
}
