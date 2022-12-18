/*
 * Problem Description
There are N players, each with strength A[i]. when player i attack player j, player j strength reduces to max(0, A[j]-A[i]). When a player's strength reaches zero, it loses the game, and the game continues in the same manner among other players until only 1 survivor remains.

Can you tell the minimum health last surviving person can have?



Problem Constraints
1 <= N <= 100000

1 <= A[i] <= 1000000
 */

package Maths;

import java.util.ArrayList;

public class Pubg {
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
}
