/*
 * Problem Description
You are given an array of N integers, A1, A2, .... AN.

Return the maximum value of f(i, j) for all 1 ≤ i, j ≤ N. f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.



Problem Constraints
1 <= N <= 100000

-109 <= A[i] <= 109


 */
package Arrays.Advance_Array3;

import java.util.ArrayList;

public class Max_absolute_difference {
    public int maxArr(ArrayList<Integer> A) {
        int n = A.size();
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            max1 = Math.max(max1,A.get(i)+i);
            max2 = Math.max(max2,A.get(i)-i);
            min1 = Math.min(min1,A.get(i)+i);
            min2 = Math.min(min2,A.get(i)-i);
        }
        return Math.max(max1-min1,max2-min2);
    }
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(3);
        A.add(-1);
        System.out.println(new Max_absolute_difference().maxArr(A));
    }
}
