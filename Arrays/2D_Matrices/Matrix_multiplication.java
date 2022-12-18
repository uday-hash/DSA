import java.util.ArrayList;

public class Matrix_multiplication {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        int n = A.size();
        int m = A.get(0).size();
        int p = B.get(0).size();
        ArrayList<ArrayList<Integer>> C = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++){
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < p; j++){
                int sum = 0;
                for (int k = 0; k < m; k++){
                    sum += A.get(i).get(k) * B.get(k).get(j);
                }
                row.add(sum);
            }
            C.add(row);
        }
        return C;
    }
    public static void main(String[] args) {
        Matrix_multiplication obj = new Matrix_multiplication();
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

        ArrayList<Integer> row5 = new ArrayList<Integer>();
        row5.add(3);
        row5.add(4);

        ArrayList<Integer> row6 = new ArrayList<Integer>();
        row6.add(5);
        row6.add(6);
        B.add(row4);
        B.add(row5);
        B.add(row6);
        System.out.println(obj.solve(A, B));
        
    }
    
}
