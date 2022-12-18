/*
 * Problem Description
Farmer John has built a new long barn with N stalls. 
Given an array of integers A of size N where each element of the 
array represents the location of the stall and an integer B which 
represents the number of cows.

His cows don't like this barn layout and become aggressive towards 
each other once put into a stall. To prevent the cows from hurting 
each other, John wants to assign the cows to the stalls, such that 
the minimum distance between any two of them is as large as possible.
 What is the largest minimum distance?



Problem Constraints
2 <= N <= 100000
0 <= A[i] <= 109
2 <= B <= N
 */
package Binary_search;

import java.util.ArrayList;

public class Aggressive_cows {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        A.sort(null);
        int low = 0;
        int high = A.get(n - 1) - A.get(0);
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(A, B, mid)) {
                ans = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return ans;
    }
    public boolean isPossible(ArrayList<Integer> A, int B, int mid) {
        int count = 1;
        int lastPos = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) - lastPos >= mid) {
                count++;
                lastPos = A.get(i);
            }
        }
        return count >= B;
    }
    public static void main(String[] args) {
        Aggressive_cows obj = new Aggressive_cows();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        System.out.println(obj.solve(A, 3));
    }
}
        
    
