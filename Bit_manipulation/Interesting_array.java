/*
 * Problem Description
You have an array A with N elements. We have two types of operation available on this array :
We can split an element B into two elements, C and D, such that B = C + D.
We can merge two elements, P and Q, to one element, R, such that R = P ^ Q i.e., XOR of P and Q.
You have to determine whether it is possible to convert array A to size 1, containing a single element equal to 0 after several splits and/or merge?



Problem Constraints
1 <= N <= 100000

1 <= A[i] <= 106
 */

package Bit_manipulation;

import java.util.ArrayList;

public class Interesting_array {
    public String solve(ArrayList<Integer> A) {
        int n = A.size();
        int xor = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            xor ^= A.get(i);
            if (A.get(i) == 1) {
                count++;
            }
        }
        if (xor == 0) {
            return "Yes";
        } else if (count == 0) {
            return "No";
        } else if (n % 2 == 0) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public static void main(String[] args) {
        Interesting_array i = new Interesting_array();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        System.out.println(i.solve(A));
    }
}
