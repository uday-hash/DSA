/*Given an array A having N positive numbers. You have to find the number of Prime subsequences of A.

A Prime subsequence is one that has only prime numbers, for example [2, 3], [5] are the Prime subsequences where [2, 4] and [1, 2, 3, 4] are not.



Input Format

The first argument given is an Array A, having N integers.
Output Format

Return an integer X, i.e number of Prime subsequences. 
As X can be very large print X % (1000000007), here % is modulus operator.
Constraints

1 <= N <= 1e3
1 <= A[i] <= 1e6 */

package Maths;

import java.util.ArrayList;

public class Prime_subsequence {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (A.get(i) > max) {
                max = A.get(i);
            }
        }
        boolean[] isPrime = new boolean[max + 1];
        for (int i = 0; i <= max; i++) {
            isPrime[i] = true;
        }
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int[] count = new int[max + 1];
        for (int i = 0; i < n; i++) {
            int curr = A.get(i);
            for (int j = 2; j * j <= curr; j++) {
                if (isPrime[j] && curr % j == 0) {
                    count[j]++;
                    while (curr % j == 0) {
                        curr /= j;
                    }
                }
            }
            if (curr != 1) {
                count[curr]++;
            }
        }
        int res = 0;
        for (int i = 0; i <= max; i++) {
            if (isPrime[i]) {
                res += count[i];
            }
        }
        return res;
    }

}
