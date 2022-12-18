/*
You are given an array of integers A of size N.
Return the difference between the maximum among all even numbers of A
and the minimum among all odd numbers in A.
 */
 

package Arrays;

public class Minimum_picks {
    public int solve(int[] A) {
        int n = A.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(A[i]%2 == 0){
                max = Math.max(max,A[i]);
            }else{
                min = Math.min(min,A[i]);
            }
        }
        return max-min;

    }

    public static void main(String[] args) {
        Minimum_picks obj = new Minimum_picks();
        int[] A = {1,2,3,4,5};
        System.out.println(obj.solve(A));
    }
}

