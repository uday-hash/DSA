/*Problem Description
Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single element "-1".

First sub-array means the sub-array for which starting index in minimum.



Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 109

 */

package Hashing;

import java.util.ArrayList;

public class Subarray_with_given_sum {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        int sum = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            end = i;
            while (sum > B) {
                sum -= A.get(start);
                start++;
            }
            if (sum == B) {
                for (int j = start; j <= end; j++) {
                    ans.add(A.get(j));
                }
                return ans;
            }
        }
        ans.add(-1);
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        int B = 5;
        Subarray_with_given_sum obj = new Subarray_with_given_sum();
        System.out.println(obj.solve(A, B));
    }
}
