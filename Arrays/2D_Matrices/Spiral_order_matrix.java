

import java.util.ArrayList;



public class Spiral_order_matrix {
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        int n = A;
        int m = A;
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++){
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < m; j++){
                row.add(0);
            }
            B.add(row);
        }
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = m - 1;
        int dir = 0;
        int num = 1;
        while (top <= bottom && left <= right){
            if (dir == 0){
                for (int i = left; i <= right; i++){
                    B.get(top).set(i, num);
                    num++;
                }
                top++;
            }
            else if (dir == 1){
                for (int i = top; i <= bottom; i++){
                    B.get(i).set(right, num);
                    num++;
                }
                right--;
            }
            else if (dir == 2){
                for (int i = right; i >= left; i--){
                    B.get(bottom).set(i, num);
                    num++;
                }
                bottom--;
            }
            else if (dir == 3){
                for (int i = bottom; i >= top; i--){
                    B.get(i).set(left, num);
                    num++;
                }
                left++;
            }
            dir = (dir + 1) % 4;
        }
        return B;
    }
    public static void main(String[] args) {
        Spiral_order_matrix obj = new Spiral_order_matrix();
        System.out.println(obj.generateMatrix(3));
    }
    
}
