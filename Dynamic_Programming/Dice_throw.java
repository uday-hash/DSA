/*
 * Problem Description

Given sum A, number of ways you can get that sum with dice roll[1-6].

As the number of ways can be large return its modulo by 1e9 + 7.



Problem Constraints

1 <= A <= 10 2

 */
package Dynamic_Programming;

 public class Dice_throw {
    public int solve(int A) {
        int[] dp = new int[A + 1];
        dp[0] = 1;
        for(int i = 1; i <= A; i++){
            for(int j = 1; j <= 6; j++){
                if(i - j >= 0){
                    dp[i] = (dp[i] + dp[i - j]) % 1000000007;
                }
            }
        }
        return dp[A];
    }
    public static void main(String[] args) {
        Dice_throw obj = new Dice_throw();
        int A = 12;
        System.out.println(obj.solve(A));
    }
}
