/*
 * Problem Description
You are given a string A consisting of 1's and 0's. Now the task is to make the string consisting of only 1's. But you are allowed to perform only the following operation:

Take exactly B consecutive string elements and change 1 to 0 and 0 to 1.
Each operation takes 1 unit time, so you have to determine the minimum time required to only make the string of 1's. If not possible, return -1.



Problem Constraints
2 ≤ length of A ≤ 105
2 ≤ B ≤ (length of A)
 */

package Greedy_Algorithm;


public class Binary_strings {
    public int solve(String A, int B) {
        int n = A.length();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = A.charAt(i) - '0';
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                count++;
                if (i + B > n) {
                    return -1;
                }
                for (int j = i; j < i + B; j++) {
                    arr[j] = 1 - arr[j];
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Binary_strings bs = new Binary_strings();
        System.out.println(bs.solve("101", 2));
    }
}
        
