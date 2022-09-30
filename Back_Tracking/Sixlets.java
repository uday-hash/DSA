/*Problem Description
Given a array of integers A of size N and an integer B.

Return number of non-empty subsequences of A of size B having sum <= 1000.



Problem Constraints
1 <= N <= 20

1 <= A[i] <= 1000

1 <= B <= N
 */

package Back_Tracking;

import java.util.ArrayList;

public class Sixlets {
    public int solve(ArrayList<Integer> A, int B)
    {
        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            count += solve(A, B, i, A.get(i));
        }
        return count;
    }
    public int solve(ArrayList<Integer> A, int B, int index, int sum)
    {
        if (B == 1) {
            if (sum <= 1000) {
                return 1;
            } else {
                return 0;
            }
        }
        int count = 0;
        for (int i = index + 1; i < A.size(); i++) {
            count += solve(A, B - 1, i, sum + A.get(i));
        }
        return count;
        
        
    }

    public static void main(String[] args) {
        Sixlets s = new Sixlets();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        System.out.println(s.solve(A, 3));
    }
    
}
