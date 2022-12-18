import java.util.ArrayList;
import java.util.List;

//package Arrays.2D_Matrices;

public class Minor_diagonal_sum {
    public int solve(final List<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        int sum = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (i + j == n - 1){
                    sum += A.get(i).get(j);
                }
            }
        }
        return sum;
        
    }
    public static void main(String[] args) {
        Minor_diagonal_sum obj = new Minor_diagonal_sum();
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
