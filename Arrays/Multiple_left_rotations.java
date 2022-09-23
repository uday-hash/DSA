package Arrays;

import java.util.ArrayList;

public class Multiple_left_rotations {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int n = A.size();
        for (Integer integer : B) {
            int d = integer % n;
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int j = d; j < n; j++) {
                temp.add(A.get(j));
            }
            for (int j = 0; j < d; j++) {
                temp.add(A.get(j));
            }
            result.add(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        ArrayList<Integer> B = new ArrayList<Integer>();
        B.add(1);
        B.add(2);
        B.add(3);
        B.add(4);
        B.add(5);
        Multiple_left_rotations obj = new Multiple_left_rotations();
        ArrayList<ArrayList<Integer>> result = obj.solve(A, B);
        for (ArrayList<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println("");
        }
    }
}
