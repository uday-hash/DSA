/* 
 * Problem Description
You are given a binary string A(i.e., with characters 0 and 1) consisting of characters A1, A2, ..., AN. In a single operation, you can choose two indices, L and R, such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, ..., AR. By flipping, we mean changing character 0 to 1 and vice-versa.

Your aim is to perform ATMOST one operation such that in the final string number of 1s is maximized.

If you don't want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.

NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.



Problem Constraints
1 <= size of string <= 100000
 */

package Arrays.Advance_Arrays1;

import java.util.ArrayList;

public class Flip {
    public ArrayList<Integer> flip(String A) {
        int n = A.length();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = A.charAt(i) - '0';
        }
        int max = 0;
        int sum = 0;
        int start = 0;
        int end = 0;
        int s = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i] == 0 ? 1 : -1;
            if(sum < 0){
                sum = 0;
                s = i + 1;
            }
            if(sum > max){
                max = sum;
                start = s;
                end = i;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        if(max == 0){
            return ans;
        }
        ans.add(start + 1);
        ans.add(end + 1);
        return ans;        
    }
    public static void main(String[] args) {
        Flip obj = new Flip();
        String A = "010";
        System.out.println(obj.flip(A));
    }
    
}
