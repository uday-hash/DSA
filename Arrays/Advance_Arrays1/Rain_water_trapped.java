/*
 * Problem Description
Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.



Problem Constraints
1 <= |A| <= 100000
 */

package Arrays.Advance_Arrays1;

import java.util.ArrayList;
import java.util.List;

public class Rain_water_trapped {
    public int trap(final List<Integer> A) {
        int n = A.size();
        int[] left = new int[n];
        int[] right = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++){
            left[i] = max;
            max = Math.max(max, A.get(i));
        }
        max = 0;
        for(int i = n - 1; i >= 0; i--){
            right[i] = max;
            max = Math.max(max, A.get(i));
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            int min = Math.min(left[i], right[i]);
            if(min > A.get(i)){
                ans += min - A.get(i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Rain_water_trapped obj = new Rain_water_trapped();
        List<Integer> A = new ArrayList<>();
        A.add(0);
        A.add(1);
        A.add(0);
        A.add(2);
        A.add(1);
        A.add(0);
        A.add(1);
        A.add(3);
        A.add(2);
        A.add(1);
        A.add(2);
        A.add(1);
        System.out.println(obj.trap(A));
    }
}
