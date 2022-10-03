/*
 * Given a sorted array of distinct integers A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.


Input Format

The first argument given is the integer array A.
The second argument given is integer B.
Output Format

Return the number of pairs for which sum is equal to B.
Constraints

1 <= length of the array <= 100000
1 <= A[i] <= 10^9 
1 <= B <= 10^9
 */

package Two_pointer;

import java.util.*;

public class Count_of_pairs_with_the_given_sum {
    public int solve(ArrayList<Integer> A, int B) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            if (map.containsKey(B - A.get(i)))
                count += map.get(B - A.get(i));
            if (map.containsKey(A.get(i)))
                map.put(A.get(i), map.get(A.get(i)) + 1);
            else
                map.put(A.get(i), 1);
        }
        return count;
    }
    public static void main(String[] args) {
        Count_of_pairs_with_the_given_sum obj = new Count_of_pairs_with_the_given_sum();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        System.out.println(obj.solve(A, 5));
    }
}
