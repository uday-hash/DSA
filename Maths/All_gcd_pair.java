/*Problem Description
Given an array of integers A of size N containing GCD of every possible pair of elements of another array.

Find and return the original numbers used to calculate the GCD array in any order. For example, if original numbers are {2, 8, 10} then the given array will be {2, 2, 2, 2, 8, 2, 2, 2, 10}.



Problem Constraints
1 <= N <= 10000

1 <= A[i] <= 109
 */

package Maths;

import java.util.ArrayList;

public class All_gcd_pair {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int n = A.size();
        int[] pre = new int[n];
        pre[0] = A.get(0);
        for (int i = 1; i < n; i++) {
            pre[i] = gcd(pre[i - 1], A.get(i));
        }
        int[] suf = new int[n];
        suf[n - 1] = A.get(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = gcd(suf[i + 1], A.get(i));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ans.add(suf[i + 1]);
            } else if (i == n - 1) {
                ans.add(pre[i - 1]);
            } else {
                ans.add(gcd(pre[i - 1], suf[i + 1]));
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
