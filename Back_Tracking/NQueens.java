/*
 * Problem Description
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer A, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
The final list should be generated in such a way that the indices of the queens in each list should be in reverse lexicographical order.


Problem Constraints
1 <= A <= 10


 */

package Back_Tracking;

import java.util.*;

public class NQueens {
    public ArrayList<ArrayList<String>> solveNQueens(int A) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        char[][] board = new char[A][A];
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < A; j++) {
                board[i][j] = '.';
            }
        }
        solveNQueens(board, 0, ans);
        return ans;
    }
	
    private void solveNQueens(char[][] board, int row, ArrayList<ArrayList<String>> ans) {
        if (row == board.length) {
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                list.add(new String(board[i]));
            }
            ans.add(list);
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (isValid(board, row, i)) {
                board[row][i] = 'Q';
                solveNQueens(board, row + 1, ans);
                board[row][i] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens nq = new NQueens();
        System.out.println(nq.solveNQueens(4));
    }
    
}
