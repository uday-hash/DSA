/*
 * Problem Description
Given n non-negative integers A[0], A[1], ..., A[n-1] , where each represents a point at coordinate (i, A[i]).

N vertical lines are drawn such that the two endpoints of line i is at (i, A[i]) and (i, 0).

Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.



Problem Constraints
0 <= N <= 105

1 <= A[i] <= 105
 */
package Two_pointer;

import java.util.ArrayList;

public class Container_with_most_water {
    public int maxArea(ArrayList<Integer> A) {
        int n = A.size();
        int i = 0;
        int j = n - 1;
        int ans = 0;
        while(i < j) {
            int h = Math.min(A.get(i), A.get(j));
            int w = j - i;
            ans = Math.max(ans, h * w);
            if(A.get(i) < A.get(j)) i++;
            else j--;
        }
        return ans;
    }
    
}
