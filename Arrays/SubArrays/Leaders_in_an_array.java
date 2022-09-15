/*
 * Problem Description

Given an integer array A containing N distinct integers, you have to find all the leaders in array A.

An element is a leader if it is strictly greater than all the elements to its right side.

NOTE:The rightmost element is always a leader.



Problem Constraints

1 <= N <= 105

1 <= A[i] <= 108
 */

package Arrays.SubArrays;

public class Leaders_in_an_array {
    public int[] solve(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        int max = A[n-1];
        ans[n-1] = max;
        int j = n-2;
        for(int i = n-2; i >= 0; i--){
            if(A[i] > max){
                max = A[i];
                ans[j] = max;
                j--;
            }
        }
        int[] ans2 = new int[n-j-1];
        for(int i = 0; i < n-j-1; i++){
            ans2[i] = ans[j+i+1];
        }
        return ans2;
    }
    public static void main(String[] args) {
        Leaders_in_an_array obj = new Leaders_in_an_array();
        int[] A = {16, 17, 4, 3, 5, 2};
        int[] ans = obj.solve(A);
        for(int i = 0; i < ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }
}