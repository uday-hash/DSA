
/*
Problem Description
You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.

Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.

NOTE: if B > N, return an empty array.
 */


package Hashing;

import java.util.*;

public class Distinct_numbers_in_window {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {

        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (B > A.size())
            return ans;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < B; i++) {
            map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);
        }
        ans.add(map.size());
        for (int i = B; i < A.size(); i++) {
            map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);
            map.put(A.get(i - B), map.get(A.get(i - B)) - 1);
            if (map.get(A.get(i - B)) == 0)
                map.remove(A.get(i - B));
            ans.add(map.size());
        }
        return ans;
    }

    public static void main(String[] args) {
        Distinct_numbers_in_window obj = new Distinct_numbers_in_window();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(1);
        A.add(3);
        A.add(4);
        A.add(3);
        System.out.println(obj.dNums(A, 3));
    }
}
