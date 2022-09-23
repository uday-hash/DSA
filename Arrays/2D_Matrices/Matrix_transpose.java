import java.util.ArrayList;

public class Matrix_transpose {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < m; i++){
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < n; j++){
                row.add(A.get(j).get(i));
            }
            B.add(row);
        }
        return B;
    }
    public static void main(String[] args) {
        Matrix_transpose obj = new Matrix_transpose();
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
        System.out.println(obj.solve(A));
        
    }
    
}
