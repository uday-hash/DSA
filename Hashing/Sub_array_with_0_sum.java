package Hashing;

import java.util.ArrayList;

public class Sub_array_with_0_sum {
    public int solve(ArrayList<Integer> A) {
        int count = 0;
        int sum = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            end = i;
            while (sum > 0) {
                sum -= A.get(start);
                start++;
            }
            if (sum == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Sub_array_with_0_sum obj = new Sub_array_with_0_sum();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        System.out.println(obj.solve(A));
    }
}

