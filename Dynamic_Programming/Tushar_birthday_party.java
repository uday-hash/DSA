/*
 * Problem Description
As it is Tushar's Birthday on March 1st, he decided to throw a party to all his friends at TGI Fridays in Pune. Given are the eating capacity of each friend, filling capacity of each dish and cost of each dish. A friend is satisfied if the sum of the filling capacity of dishes he ate is equal to his capacity. Find the minimum cost such that all of Tushar's friends are satisfied (reached their eating capacity).

NOTE:

Each dish is supposed to be eaten by only one person. Sharing is not allowed.

Each friend can take any dish unlimited number of times.

There always exists a dish with filling capacity 1 so that a solution always exists.



Problem Constraints
|A| <= 1000

|B| <= 1000

|C| <= 1000


 */
package Dynamic_Programming;

import java.util.*;

public class Tushar_birthday_party {
    public int solve(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int max = 0;
        for (Integer i : A) {
            max = Math.max(max, i);
        }
        int[] dp = new int[max + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= max; i++) {
            for (int j = 0; j < B.size(); j++) {
                if (i - B.get(j) >= 0 && dp[i - B.get(j)] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - B.get(j)] + C.get(j));
                }
            }
        }
        int sum = 0;
        for (Integer i : A) {
            sum += dp[i];
        }
        return sum;
    }
    
}
