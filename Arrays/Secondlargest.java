/*
You are given an integer array A. You have to find the second largest element/value in
 the array or report that no such element exists.
 Return the second largest element. If no such element exist then return -1.

 Problem Constraints
1 <= |A| <= 105

0 <= A[i] <= 109


 */

package Arrays;


public class Secondlargest {
    public int solve(int[] A) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) {
                secondMax = max;
                max = A[i];
            } else if (A[i] > secondMax && A[i] != max) {
                secondMax = A[i];
            }
        }
        if (secondMax == Integer.MIN_VALUE) {
            return -1;
        }
        return secondMax;
        

    }

    public static void main(String[] args) {
        Secondlargest obj = new Secondlargest();
        int[] A = {1};
        System.out.println(obj.solve(A));
    }
}
