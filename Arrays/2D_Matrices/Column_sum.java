import java.util.ArrayList;

public class Column_sum {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        ArrayList<Integer> B = new ArrayList<Integer>();
        for (int i = 0; i < m; i++){
            int sum = 0;
            for (int j = 0; j < n; j++){
                sum += A.get(j).get(i);
            }
            B.add(sum);
        }
        return B;
    }
    public static void main(String[] args) {
        Column_sum obj = new Column_sum();
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
