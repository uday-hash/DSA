package Hashing;

import java.util.ArrayList;

public class Shaggy_and_distances {
    public int solve(ArrayList<Integer> A) {
        int count = 0;
        int sum = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            end = i;
            while (sum > 2) {
                sum -= A.get(start);
                start++;
            }
            if (sum == 2) {
                count += (end - start);
            }
        }
        return count;
    }
}