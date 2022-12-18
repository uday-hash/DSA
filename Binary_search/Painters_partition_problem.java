/*
 * Problem Description
Given 2 integers A and B and an array of integers C of size N. 
Element C[i] represents the length of ith board.
You have to paint all N boards [C0, C1, C2, C3 … CN-1]. 
There are A painters available and each of them takes B units of time to 
paint 1 unit of the board.

Calculate and return the minimum time required to paint all boards under 
the constraints that any painter will only paint contiguous sections of the board.
NOTE:
1. 2 painters cannot share a board to paint. That is to say, a board cannot 
be painted partially by one painter, and partially by another.
2. A painter will only paint contiguous boards. This means a configuration
 where painter 1 paints boards 1 and 3 but not 2 is invalid.

Return the ans % 10000003.



Problem Constraints
1 <= A <= 1000
1 <= B <= 106
1 <= N <= 105
1 <= C[i] <= 106
 */
package Binary_search;

import java.util.ArrayList;

public class Painters_partition_problem {
    public int paint(int A, int B, ArrayList<Integer> C) {
        int n = C.size();
        int low = 0, high = 0;
        for (int i = 0; i < n; i++) {
            high += C.get(i);
            low = Math.max(low, C.get(i));
        }
        long ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(C, A, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) ((ans * B) % 10000003);
    }
    public boolean isPossible(ArrayList<Integer> C, int A, int mid) {
        int n = C.size();
        int sum = 0;
        int count = 1;
        for (int i = 0; i < n; i++) {
            sum += C.get(i);
            if (sum > mid) {
                count++;
                if (count > A) {
                    return false;
                }
                sum = C.get(i);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Painters_partition_problem p = new Painters_partition_problem();
        ArrayList<Integer> C = new ArrayList<Integer>();
        C.add(1);
        C.add(10);
        C.add(12);
        C.add(3);
        C.add(4);
        C.add(6);
        C.add(5);
        System.out.println(p.paint(2, 5, C));
    }
    
}
    