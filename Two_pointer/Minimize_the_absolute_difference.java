/*
 * Given three sorted arrays A, B and Cof not necessarily same sizes.

Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively. i.e. minimize | max(a,b,c) - min(a,b,c) |.

Example :

Input:

A : [ 1, 4, 5, 8, 10 ]
B : [ 6, 9, 15 ]
C : [ 2, 3, 6, 6 ]
Output:

1
Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.

See Expected Output
 */

package Two_pointer;

import java.util.*;

public class Minimize_the_absolute_difference {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {

        int i = 0, j = 0, k = 0;
        int min = Integer.MAX_VALUE;
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
        Minimize_the_absolute_difference obj = new Minimize_the_absolute_difference();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(4);
        A.add(5);
        A.add(8);
        A.add(10);
        ArrayList<Integer> B = new ArrayList<Integer>();
        B.add(6);
        B.add(9);
        B.add(15);
        ArrayList<Integer> C = new ArrayList<Integer>();
        C.add(2);
        C.add(3);
        C.add(6);
        C.add(6);
        System.out.println(obj.solve(A, B, C));
    }
}
