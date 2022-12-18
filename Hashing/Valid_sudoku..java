package Hashing;

import java.util.ArrayList;
import java.util.List;

class Valid_sudoku {
    public int isValidSudoku(final List<String> A) {
        int n = A.size();
        int[][] row = new int[n][n];
        int[][] col = new int[n][n];
        int[][] box = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(A.get(i).charAt(j) != '.'){
                    int num = A.get(i).charAt(j) - '0' - 1;
                    int k = i/3*3 + j/3;
                    if(row[i][num] == 1 || col[j][num] == 1 || box[k][num] == 1){
                        return 0;
                    }
                    row[i][num] = 1;
                    col[j][num] = 1;
                    box[k][num] = 1;
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Valid_sudoku obj = new Valid_sudoku();
        List<String> A = new ArrayList<>();
        A.add("53..7....");
        A.add("6..195...");
        A.add(".98....6.");
        A.add("8...6...3");
        A.add("4..8.3..1");
        A.add("7...2...6");
        A.add(".6....28.");
        A.add("...419..5");
        A.add("....8..79");
        System.out.println(obj.isValidSudoku(A));
    }
}