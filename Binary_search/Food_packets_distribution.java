/*
 * Problem Description
The government wants to set up B distribution offices across N 
cities for the distribution of food
packets. The population of the ith city is A[i]. Each city must 
have at least 1 office, and people can go to an office of their own city.
 We want to maximize the minimum number of people who can get food in any single office.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 106

1 <= B <= 5 x 105
 */
package Binary_search;

import java.util.ArrayList;

public class Food_packets_distribution {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = A.get(i);
        }
        int low = 1;
        int high = 1000000;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(arr, mid, B)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;

    }

    private boolean isPossible(int[] arr, int mid, int b) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += arr[i] / mid;
        }
        if (count >= b) {
            return true;
        }

        return false;
    }

}
