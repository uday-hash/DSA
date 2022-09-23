

import java.util.ArrayList;



public class Rotate_matrix {
    public void solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        for (int i = 0; i < n; i++){
            for (int j = i; j < m; j++){
                int temp = A.get(i).get(j);
                A.get(i).set(j, A.get(j).get(i));
                A.get(j).set(i, temp);
            }
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m/2; j++){
                int temp = A.get(i).get(j);
                A.get(i).set(j, A.get(i).get(m - j - 1));
                A.get(i).set(m - j - 1, temp);
            }
        }
    }
    public static void main(String[] args) {
        Rotate_matrix obj = new Rotate_matrix();
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row1 = new ArrayList<Integer>();
        row1.add(1);
        row1.add(2);
        row1.add(3);
        ArrayList<Integer> row2 = new ArrayList<Integer>();
        row2.add(4);
        row2.add(5);
        row2.add(6);
        ArrayList<Integer> row3 = new ArrayList<Integer>();
        row3.add(7);
        row3.add(8);
        row3.add(9);
        A.add(row1);
        A.add(row2);
        A.add(row3);
        obj.solve(A);
        System.out.println(A);
        
    }
}
