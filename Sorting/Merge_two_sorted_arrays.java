

/*
 * Problem Description
Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.



Problem Constraints
-1010 <= A[i], B[i] <= 1010
 */

package Sorting;
import java.util.ArrayList;
import java.util.List;

public class Merge_two_sorted_arrays {
    public ArrayList<Integer> solve(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int i = 0, j = 0;
        while (i < A.size() && j < B.size()) {
            if (A.get(i) < B.get(j)) {
                result.add(A.get(i));
                i++;
            } else {
                result.add(B.get(j));
                j++;
            }
        }
        while (i < A.size()) {
            result.add(A.get(i));
            i++;
        }
        while (j < B.size()) {
            result.add(B.get(j));
            j++;
        }
        return result;
    }
    public static void main(String[] args) {
        Merge_two_sorted_arrays m = new Merge_two_sorted_arrays();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(5);
        A.add(8);
        ArrayList<Integer> B = new ArrayList<Integer>();
        B.add(6);
        B.add(9);
        System.out.println(m.solve(A, B));
    }
}
