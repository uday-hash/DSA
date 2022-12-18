import java.util.ArrayList;

//package Arrays.2D_Matrices;

public class Scalar_product {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        int n = A.size();
        int m = A.get(0).size();
        ArrayList<ArrayList<Integer>> C = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++){
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < m; j++){
                row.add(A.get(i).get(j) * B);
            }
            C.add(row);
        }
        return C;
    }
    public static void main(String[] args) {
        Scalar_product obj = new Scalar_product();
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
        System.out.println(obj.solve(A, 2));
        
    }
}
