/*
 * Problem Description

Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring all the numbers less than or equal to B together.

Note: It is possible to swap any two elements, not necessarily consecutive.



Problem Constraints

1 <= length of the array <= 100000
-109 <= A[i], B <= 109


 */

package Arrays.Advance_Array3;

import java.util.ArrayList;

public class Minimum_swaps {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int count = 0;
        for(int i=0;i<n;i++){
            if(A.get(i)<=B){
                count++;
            }
        }
        int ans = Integer.MAX_VALUE;
        int i=0;
        int j=count-1;
        int temp = 0;
        for(int k=i;k<=j;k++){
            if(A.get(k)>B){
                temp++;
            }
        }
        ans = Math.min(ans,temp);
        while(j<n-1){
            if(A.get(i)>B){
                temp--;
            }
            i++;
            j++;
            if(A.get(j)>B){
                temp++;
            }
            ans = Math.min(ans,temp);
        }
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(12);
        A.add(-5);
        A.add(-6);
        A.add(50);
        A.add(3);
        System.out.println(new Minimum_swaps().solve(A, 1));
    }
}
