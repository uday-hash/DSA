/*Problem Description

In Danceland, one person can party either alone or can pair up with another person.

Can you find in how many ways they can party if there are A people in Danceland?

Note: Return your answer modulo 10003, as the answer can be large.



Problem Constraints

1 <= A <= 105 */

package Dynamic_Programming;

public class Lets_party {
    public int solve(int A) {
        int[] dp = new int[A + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= A; i++){
            dp[i] = (dp[i - 1] + (i - 1) * dp[i - 2]) % 10003;
        }
        return dp[A];
    }
    public static void main(String[] args) {
        Lets_party obj = new Lets_party();
        int A = 4;
        System.out.println(obj.solve(A));
    }
    
}
