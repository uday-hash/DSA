/*
 * Problem Description
Given an array A of non-negative integers of size N. 
Find the minimum sub-array Al, Al+1 ,..., Ar such that if we 
sort(in ascending order) that sub-array, then the whole array should get sorted.
 If A is already sorted, output -1.



Problem Constraints
1 <= N <= 1000000
1 <= A[i] <= 1000000


 */
package Sorting;

import java.util.ArrayList;

public class Maximum_unsorted_subarray {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = A.size();
        int i = 0;
        while(i < n - 1 && A.get(i) <= A.get(i + 1)) i++;
        if(i == n - 1) {
            ans.add(-1);
            return ans;
        }
        int j = n - 1;
        while(j > 0 && A.get(j) >= A.get(j - 1)) j--;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int k = i; k <= j; k++) {
            min = Math.min(min, A.get(k));
            max = Math.max(max, A.get(k));
        }
        int l = 0;
        while(l < i && A.get(l) <= min) l++;
        int r = n - 1;
        while(r > j && A.get(r) >= max) r--;
        ans.add(l);
        ans.add(r);
        return ans;
    }
    public static void main(String[] args) {
        Maximum_unsorted_subarray m = new Maximum_unsorted_subarray();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(3);
        A.add(2);
        A.add(4);
        A.add(5);
        System.out.println(m.subUnsort(A));
    }
}
