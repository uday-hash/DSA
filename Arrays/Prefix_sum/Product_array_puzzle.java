/*
Given an array of integers A, find and return the product array of the same size where the ith element of the product array will be equal to the product of all the elements divided by the ith element of the array.

Note: It is always possible to form the product array with integer (32 bit) values. Solve it without using the division operator.


Input Format

The only argument given is the integer array A.
Output Format

Return the product array.
Constraints

2 <= length of the array <= 1000
1 <= A[i] <= 10

 */

package Arrays.Prefix_sum;

import java.util.ArrayList;

public class Product_array_puzzle {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int N = A.size();
        int[] prefix = new int[N];
        int[] suffix = new int[N];
        int product = 1;
        for (int i = 0; i < N; i++) {
            product *= A.get(i);
            prefix[i] = product;
        }
        product = 1;
        for (int i = N - 1; i >= 0; i--) {
            product *= A.get(i);
            suffix[i] = product;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int left = i - 1 >= 0 ? prefix[i - 1] : 1;
            int right = i + 1 < N ? suffix[i + 1] : 1;
            ans.add(left * right);
        }
        return ans;
    }
}
