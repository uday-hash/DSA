/*You have given an array A having N integers. Let say G is the product of all elements of A.

You have to find the number of distinct prime divisors of G.



Input Format

The first argument given is an Array A, having N integers.
Output Format

Return an Integer, i.e number of distinct prime divisors of G.
Constraints

1 <= N <= 1e5
1 <= A[i] <= 1e5
 */

package Maths;

import java.util.ArrayList;

public class Distinct_primes {
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
            if (count[i] != 0) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Distinct_primes d = new Distinct_primes();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(8);
        A.add(9);
        A.add(10);
        System.out.println(d.solve(A));
    }
}
    }
}
