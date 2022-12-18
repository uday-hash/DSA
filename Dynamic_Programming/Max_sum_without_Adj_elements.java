package Dynamic_Programming;

import java.util.ArrayList;

public class Max_sum_without_Adj_elements {
    public int adjacent(ArrayList<ArrayList<Integer>> A) {
        int n = A.get(0).size();
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = Math.max(A.get(0).get(0), A.get(1).get(0));
        for(int i = 2; i <= n; i++){
            dp[i] = Math.max(dp[i - 1], Math.max(A.get(0).get(i - 1), A.get(1).get(i - 1)) + dp[i - 2]);
        }
        return dp[n];

    }  
    public static void main(String[] args) {
        Max_sum_without_Adj_elements obj = new Max_sum_without_Adj_elements();
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        ArrayList<Integer> b = new ArrayList<Integer>();
        b.add(2);
        b.add(3);
        b.add(4);
        b.add(5);
        A.add(a);
        A.add(b);
        System.out.println(obj.adjacent(A));
    }
    
}
