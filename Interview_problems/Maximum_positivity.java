/*
 * Problem Description
Given an array of integers A, of size N.

Return the maximum size subarray of A having only non-negative elements. If there are more than one such subarray, return the one having the smallest starting index in A.

NOTE: It is guaranteed that an answer always exists.



Problem Constraints
1 <= N <= 105

-109 <= A[i] <= 109
 */
package Interview_problems;

import java.util.ArrayList;

public class Maximum_positivity {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        int temp = 0;
        for(int i = 0; i < A.size(); i++){
            if(A.get(i) >= 0){
                temp++;
                if(temp > max){
                    max = temp;
                    end = i;
                }
            }
            else{
                temp = 0;
            }
        }
        start = end - max + 1;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i = start; i <= end; i++){
            ans.add(A.get(i));
        }
        return ans;

    }

    public static void main(String[] args) {
        Maximum_positivity obj = new Maximum_positivity();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(-1);
        A.add(-2);
        A.add(4);
        A.add(5);
        A.add(6);
        A.add(-3);
        A.add(-4);
        A.add(7);
        A.add(8);
        A.add(9);
        System.out.println(obj.solve(A));
    }
    
}
