/*Problem Description
Given an array of integers A and an integer B, 
find and return the maximum value K such that there is no 
subarray in A of size K with the sum of elements greater than B.



Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9

1 <= B <= 10^9 */
package Binary_search;

import java.util.ArrayList;

public class Special_integer {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int l = 1;
        int r = n;
        int ans = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(A, mid, B)) {
                ans = mid;
                l = mid + 1;
            } else
                r = mid - 1;
        }
        return ans;
    }

    public boolean check(ArrayList<Integer> A, int mid, int B) {
        int n = A.size();
        long sum = 0;
        for (int i = 0; i < mid; i++)
            sum += A.get(i);
        if (sum > B)
            return false;
        for (int i = mid; i < n; i++) {
            sum += A.get(i);
            sum -= A.get(i - mid);
            if (sum > B)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Special_integer obj = new Special_integer();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        System.out.println(obj.solve(A, 10));
    }
}
    