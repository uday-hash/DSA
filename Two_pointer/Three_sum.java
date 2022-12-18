/*
 * Problem Description
Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.

Assume that there will only be one solution.



Problem Constraints
-108 <= B <= 108
1 <= N <= 104
-108 <= A[i] <= 108
 */
package Two_pointer;

import java.util.*;

public class Three_sum {
    public int threeSumClosest(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int ans = A.get(0) + A.get(1) + A.get(2);
        for (int i = 0; i < A.size() - 2; i++) {
            int j = i + 1;
            int k = A.size() - 1;
            while (j < k) {
                int sum = A.get(i) + A.get(j) + A.get(k);
                if (sum == B)
                    return B;
                if (Math.abs(sum - B) < Math.abs(ans - B))
                    ans = sum;
                if (sum < B)
                    j++;
                else
                    k--;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Three_sum obj = new Three_sum();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(-1);
        A.add(2);
        A.add(1);
        A.add(-4);
        System.out.println(obj.threeSumClosest(A, 1));
    }
}
    