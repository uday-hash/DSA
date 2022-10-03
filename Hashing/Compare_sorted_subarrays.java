/*
 * Problem Description
Given an array A of length N. You have to answer Q queries.

Each query will contain four integers l1, r1, l2, and r2. If sorted segment from [l1, r1] is the same as the sorted segment from [l2 r2], then the answer is 1 else 0.

NOTE The queries are 0-indexed.



Problem Constraints
0 <= A[i] <= 100000
1 <= N <= 100000
1 <= Q <= 100000


 */
package Hashing;

import java.util.*;

public class Compare_sorted_subarrays {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < B.size(); i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = B.get(i).get(0); j <= B.get(i).get(1); j++)
                temp.add(A.get(j));
            Collections.sort(temp);
            A.set(B.get(i).get(0), temp.get(0));
            A.set(B.get(i).get(1), temp.get(temp.size() - 1));
        }
        for (int i = 0; i < B.size(); i++) {
            ArrayList<Integer> temp1 = new ArrayList<>();
            ArrayList<Integer> temp2 = new ArrayList<>();
            for (int j = B.get(i).get(0); j <= B.get(i).get(1); j++)
                temp1.add(A.get(j));
            for (int j = B.get(i).get(2); j <= B.get(i).get(3); j++)
                temp2.add(A.get(j));
            Collections.sort(temp1);
            Collections.sort(temp2);
            if (temp1.equals(temp2))
                ans.add(1);
            else
                ans.add(0);
        }
        return ans;
    }
}
