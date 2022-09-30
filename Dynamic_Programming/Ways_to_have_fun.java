/*
 * Problem Description

Find the number of ways you can have fun in A days, given you can sleep every day, Pizza can be eaten every alternate day and you can watch Tv shows every two days.

Since the answer could be large, return answer % 109 + 7.



Problem Constraints

1 <= A <= 105
 */

package Dynamic_Programming;

import java.util.*;

public class Ways_to_have_fun{
    public int solve(int A) {
        int[] dp = new int[A + 1];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for (int i = 3; i <= A; i++) {
            dp[i] = (int)(((long)dp[i - 1] + (long)dp[i - 2] + (long)dp[i - 3]) % 1000000007);
        }
        return dp[A];
    }
    public static void main(String[] args) {
        System.out.println(new Ways_to_have_fun().solve(5));
    }
}
    }
}
