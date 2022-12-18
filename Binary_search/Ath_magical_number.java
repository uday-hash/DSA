/*
 * Problem Description
You are given three positive integers, A, B, and C.

Any positive integer is magical if divisible by either B or C.

Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.



Problem Constraints
1 <= A <= 109

2 <= B, C <= 40000
 */
package Binary_search;

public class Ath_magical_number {
    public int solve(int A, int B, int C) {
        int mod = 1000000007;
        int low = 1;
        int high = Integer.MAX_VALUE;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = (mid / B) + (mid / C) - (mid / (B * C));
            if (count >= A) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans % mod;

    }
}
