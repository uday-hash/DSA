
//package Arrays.2D_Matrices;

import java.util.ArrayList;



public class Add_two_matrices {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        int n = A.size();
        int m = A.get(0).size();
        ArrayList<ArrayList<Integer>> C = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++){
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < m; j++){
                row.add(A.get(i).get(j) + B.get(i).get(j));
            }
            C.add(row);
        }
        return C;
    }
    public static void main(String[] args) {
           Add_two_matrices obj = new Add_two_matrices();
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
                ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
                ArrayList<Integer> row4 = new ArrayList<Integer>();
                row4.add(1);
                row4.add(2);
                row4.add(3);
                ArrayList<Integer> row5 = new ArrayList<Integer>();
                row5.add(4);
                row5.add(5);
                row5.add(6);
                ArrayList<Integer> row6 = new ArrayList<Integer>();
                row6.add(7);
                row6.add(8);
                row6.add(9);
                B.add(row4);
                B.add(row5);
                B.add(row6);
                System.out.println(obj.solve(A, B));
                
    }
    
}

