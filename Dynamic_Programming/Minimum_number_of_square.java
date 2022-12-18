package Dynamic_Programming;

public class Minimum_number_of_square {
    public int countMinSquares(int A) {
        int[] dp = new int[A + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= A; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[A];
    }
    public static void main(String[] args) {
        Minimum_number_of_square obj = new Minimum_number_of_square();
        int A = 12;
        System.out.println(obj.countMinSquares(A));
    }
    
}
