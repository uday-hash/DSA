/*
Problem Description
You are given an integer array A.

Decide whether it is possible to divide the array into one or more subarrays of even length such that the first and last element of all subarrays will be even.

Return "YES" if it is possible; otherwise, return "NO" (without quotes).



Problem Constraints
1 <= |A|, A[i] <= 106

 */


package Arrays.SubArrays;

import java.util.*;

public class Even_subarrays {
    public String solve(ArrayList<Integer> A) {
        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) % 2 == 0) {
                count++;
            }
        }
        if (count == 0) {
            return "NO";
        }
        if (count == A.size()) {
            return "YES";
        }
        if (count == 1) {
            if (A.get(0) % 2 == 0 || A.get(A.size() - 1) % 2 == 0) {
                return "YES";
            } else {
                return "NO";
            }
        }
        return "YES";
    }
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(1);
        A.add(2);
        A.add(1);
        A.add(2);
        A.add(1);
        A.add(2);
        Even_subarrays obj = new Even_subarrays();
        System.out.println(obj.solve(A));
    }
}
    }   
    
}
