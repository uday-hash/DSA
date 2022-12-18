/*
 * Problem Description
Given an array of integers A, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.

Find and return the number of permutations of A that are squareful. Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].



Problem Constraints
1 <= length of the array <= 12

1 <= A[i] <= 109


 */

package Back_Tracking;

import java.util.*;

public class Number_of_squareful_arrays {
    public int solve(ArrayList<Integer> A) {
        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            count += solve(A, i, new ArrayList<>());
        }
        return count;
        
    }
    
    public int solve(ArrayList<Integer> A, int index, ArrayList<Integer> B)
    {
        if (B.size() == A.size()) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            if (B.contains(A.get(i))) {
                continue;
            }
            if (B.size() > 0 && !isSquare(B.get(B.size() - 1) + A.get(i))) {
                continue;
            }
            B.add(A.get(i));
            count += solve(A, i, B);
            B.remove(B.size() - 1);
        }
        return count;
    }

    public boolean isSquare(int n)
    {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    public static void main(String[] args) {
        System.out.println(new Number_of_squareful_arrays().solve(new ArrayList<>(Arrays.asList(2, 2, 2))));
    }
    
}
