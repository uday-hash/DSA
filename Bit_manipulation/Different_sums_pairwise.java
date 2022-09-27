/*
 * Problem Description
We define f(X, Y) as the number of different corresponding bits in the binary 
representation of X and Y.
For example, f(2, 7) = 2, since the binary representation of 2 and 7 are 010 and 
111, respectively. The first and the third bit differ, so f(2, 7) = 2.

You are given an array of N positive integers, A1, A2,..., AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 231 - 1
 */

package Bit_manipulation;

import java.util.ArrayList;

public class Different_sums_pairwise {
    public int cntBits(ArrayList<Integer> A) {
        int mod = 1000000007;
        int n = A.size();
        long ans = 0;
        for (int i = 0; i < 32; i++) {
            long count = 0;
            for (int j = 0; j < n; j++) {
                if ((A.get(j) & (1 << i)) != 0) {
                    count++;
                }
            }
            ans = (ans + (count * (n - count) * 2) % mod) % mod;
        }
        return (int) ans;
    }
    public static void main(String[] args) {
        Different_sums_pairwise d = new Different_sums_pairwise();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(3);
        A.add(5);
        System.out.println(d.cntBits(A));
    }
}
    }
}
