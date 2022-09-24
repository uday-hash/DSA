/*Problem Description
Given an unsorted integer array, A of size N. Find the first missing positive integer.

Note: Your algorithm should run in O(n) time and use constant space.



Problem Constraints
1 <= N <= 1000000

-109 <= A[i] <= 109 */

package Arrays.Advance_Array3;

import java.util.ArrayList;

public class First_missing_integer {
    public int firstMissingPositive(ArrayList<Integer> A) {
        int n = A.size();
        for(int i=0;i<n;i++){
            if(A.get(i)<=0){
                A.set(i,n+1);
            }
        }
        for(int i=0;i<n;i++){
            int val = Math.abs(A.get(i));
            if(val<=n){
                A.set(val-1,-Math.abs(A.get(val-1)));
            }
        }
        for(int i=0;i<n;i++){
            if(A.get(i)>0){
                return i+1;
            }
        }
        return n+1;
    }
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(4);
        A.add(-1);
        A.add(1);
        System.out.println(new First_missing_integer().firstMissingPositive(A));
    }
    
}
