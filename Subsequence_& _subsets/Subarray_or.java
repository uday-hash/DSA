package Subsequence & subsets;

public class Subarray_or {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int[] dp = new int[n];
        dp[0] = A.get(0);
        for(int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] | A.get(i);
        }
        int res = 0;
        for(int i = 0; i < n; i++) {
            res += dp[i];
        }
        return res;
    }
    
    
}
