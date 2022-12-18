/*
Given an array A, find the size of the smallest subarray such that
it contains at least one occurrence of the maximum value of the array
and at least one occurrence of the minimum value of the array.
 */

package Arrays.Carry_forward;

public class Closest_MinMax {
    public int solve(int[] A) {
        int n = A.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }
        int l = 0;
        int r = 0;
        int ans = Integer.MAX_VALUE;
        while (r < n) {
            if (A[r] == min || A[r] == max) {
                while (l < r && A[l] != min && A[l] != max) {
                    l++;
                }
                if (A[l] == min && A[r] == max || A[l] == max && A[r] == min) {
                    ans = Math.min(ans, r - l + 1);
                }
            }
            r++;
        }
        return ans;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Closest_MinMax obj = new Closest_MinMax();
        int[] arr = { 1, 3, 2, 4, 5 };
        System.out.println(obj.solve(arr));
    }
}

