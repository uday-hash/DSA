/*Problem Description
You are given 3 sorted arrays A, B and C.

Find i, j, k such that : max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.

Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).



Problem Constraints
0 <= len(A), len(B), len(c) <= 106

0 <= A[i], B[i], C[i] <= 107 */
package Two_pointer;

import java.util.*;

public class Array_3_pointers {
    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0, k = 0;
        while (i < A.size() && j < B.size() && k < C.size()) {
            int max = Math.max(Math.abs(A.get(i) - B.get(j)), Math.max(Math.abs(B.get(j) - C.get(k)), Math.abs(C.get(k) - A.get(i))));
            if (max < min)
                min = max;
            if (A.get(i) <= B.get(j) && A.get(i) <= C.get(k))
                i++;
            else if (B.get(j) <= A.get(i) && B.get(j) <= C.get(k))
                j++;
            else
                k++;
        }
        return min;
    }
    public static void main(String[] args) {
        Array_3_pointers obj = new Array_3_pointers();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(4);
        A.add(10);
        ArrayList<Integer> B = new ArrayList<Integer>();
        B.add(2);
        B.add(15);
        B.add(20);
        ArrayList<Integer> C = new ArrayList<Integer>();
        C.add(10);
        C.add(12);
        System.out.println(obj.minimize(A, B, C));
    }
}
