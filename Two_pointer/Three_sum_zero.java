/*
 * Problem Description

Given an array A of N integers, are there elements a, b, c in S such that a + b + c = 0

Find all unique triplets in the array which gives the sum of zero.

Note:

Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c) The solution set must not contain duplicate triplets.



Problem Constraints

0 <= N <= 7000

-108 <= A[i] <= 108
 */
package Two_pointer;

import java.util.ArrayList;

public class Three_sum_zero {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = A.size();
        A.sort(null);
        for(int i = 0; i < n - 2; i++) {
            if(i > 0 && A.get(i).equals(A.get(i - 1))) continue;
            int j = i + 1;
            int k = n - 1;
            while(j < k) {
                int sum = A.get(i) + A.get(j) + A.get(k);
                if(sum == 0) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(A.get(i));
                    temp.add(A.get(j));
                    temp.add(A.get(k));
                    ans.add(temp);
                    j++;
                    k--;
                    while(j < k && A.get(j).equals(A.get(j - 1))) j++;
                    while(j < k && A.get(k).equals(A.get(k + 1))) k--;
                }
                else if(sum < 0) j++;
                else k--;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Three_sum_zero t = new Three_sum_zero();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(-1);
        A.add(0);
        A.add(1);
        A.add(2);
        A.add(-1);
        A.add(-4);
        System.out.println(t.threeSum(A));
    }
}
