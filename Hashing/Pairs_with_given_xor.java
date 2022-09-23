package Hashing;

import java.util.ArrayList;

public class Pairs_with_given_xor {
    public int solve(ArrayList<Integer>: A, int B) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if ((A[i] ^ A[j]) == B) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Pairs_with_given_xor obj = new Pairs_with_given_xor();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(5);
        A.add(4);
        A.add(10);
        A.add(15);
        A.add(7);
        A.add(6);
        System.out.println(obj.solve(A, 5));
    }
}

