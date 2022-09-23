
/*
* */


package Hashing;

import java.util.ArrayList;

public class Distinct_numbers_in_window {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {

        ArrayList<Integer> ans = new ArrayList<>();
        int[] count = new int[A.size()];
        int start = 0;
        int end = 0;
        int distinct = 0;
        for (int i = 0; i < A.size(); i++) {
            if (count[A.get(i)] == 0) {
                distinct++;
            }
            count[A.get(i)]++;
            end = i;
            if (end - start + 1 == B) {
                ans.add(distinct);
                count[A.get(start)]--;
                if (count[A.get(start)] == 0) {
                    distinct--;
                }
                start++;
            }
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
