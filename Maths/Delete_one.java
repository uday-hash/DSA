

/*
 * Problem Description

Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.

Find the maximum value of GCD.



Problem Constraints

2 <= N <= 105
1 <= A[i] <= 109


 */

package Maths;
import java.util.ArrayList;

public class Delete_one {

    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = A.get(0);
        right[n - 1] = A.get(n - 1);
        for (int i = 1; i < n; i++) {
            left[i] = gcd(left[i - 1], A.get(i));
            right[n - i - 1] = gcd(right[n - i], A.get(n - i - 1));
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                max = Math.max(max, right[i + 1]);
            } else if (i == n - 1) {
                max = Math.max(max, left[i - 1]);
            } else {
                max = Math.max(max, gcd(left[i - 1], right[i + 1]));
            }
        }
        return max;

    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    public static void main(String[] args) {
        Delete_one d = new Delete_one();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(12);
        A.add(15);
        A.add(18);
        A.add(9);
        A.add(6);
        System.out.println(d.solve(A));
    }
}
