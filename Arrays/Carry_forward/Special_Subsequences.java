/*
 * Problem Description
You have given a string A having Uppercase English letters.

You have to find how many times subsequence "AG" is there in the given string.

NOTE: Return the answer modulo 109 + 7 as the answer can be very large.

Problem Constraints
1 <= |A| <= 105

 */

package Arrays.Carry_forward;

public class Special_Subsequences {
    public int solve(String A) {
        int n = A.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == 'A') {
                for (int j = i + 1; j < n; j++) {
                    if (A.charAt(j) == 'G') {
                        count++;
                    }
                }
            }
        }
        return count;
        

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Special_Subsequences obj = new Special_Subsequences();
        String str = "ABCGAG";
        System.out.println(obj.solve(str));
    }
}
