/*
 * Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.

The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array.

Find and return the required subarray.

NOTE:

    1. If there is a tie, then compare with segment's length and return segment which has maximum length.
    2. If there is still a tie, then return the segment with minimum starting index.


Input Format:

The first and the only argument of input contains an integer array A, of length N.
Output Format:

Return an array of integers, that is a subarray of A that satisfies the given conditions.
Constraints:

1 <= N <= 1e5
-INT_MAX < A[i] <= INT_MAX
 */

package Arrays.Advance_Arrays1;

import java.util.ArrayList;

public class Max_non_negative_subArray {
    public ArrayList<Integer> maxset(ArrayList<Integer> A) { 
        int n = A.size();
        int max_sum = 0;
        int max_len = 0;
        int max_start = 0;
        int start = 0;
        int sum = 0;
        int len = 0;
        for (int i = 0; i < n; i++){
            if (A.get(i) >= 0){
                sum += A.get(i);
                len++;
            }
            else{
                if (sum > max_sum){
                    max_sum = sum;
                    max_len = len;
                    max_start = start;
                }
                else if (sum == max_sum){
                    if (len > max_len){
                        max_len = len;
                        max_start = start;
                    }
                }
                sum = 0;
                len = 0;
                start = i + 1;
            }
        }
        if (sum > max_sum){
            max_sum = sum;
            max_len = len;
            max_start = start;
        }
        else if (sum == max_sum){
            if (len > max_len){
                max_len = len;
                max_start = start;
            }
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = max_start; i < max_start + max_len; i++){
            ans.add(A.get(i));
        }
        return ans;       
    }
    public static void main(String[] args) {
        Max_non_negative_subArray obj = new Max_non_negative_subArray();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(5);
        A.add(-7);
        A.add(2);
        A.add(3);
        System.out.println(obj.maxset(A));
    }
    
}
