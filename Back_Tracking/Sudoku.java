/*
 * Problem Description
Write a program to solve a Sudoku puzzle by filling the empty cells. Empty cells are indicated by the character '.' You may assume that there will be only one unique solution.



A sudoku puzzle,



and its solution numbers marked in red.



Problem Constraints
N = 9

 */

package Back_Tracking;
import java.util.*; 

public class Sudoku {
    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        solveSudoku(a, 0, 0);
    }

    private boolean solveSudoku(ArrayList<ArrayList<Character>> a, int row, int col) {
        if (row == a.size()) {
            return true;
        }
        if (col == a.get(0).size()) {
            return solveSudoku(a, row + 1, 0);
        }
        if (a.get(row).get(col) != '.') {
            return solveSudoku(a, row, col + 1);
        }
        for (int i = 1; i <= 9; i++) {
            if (isValid(a, row, col, i)) {
                a.get(row).set(col, (char) (i + '0'));
                if (solveSudoku(a, row, col + 1)) {
                    return true;
                }
                a.get(row).set(col, '.');
            }
        }
        return false;
    }

    private boolean isValid(ArrayList<ArrayList<Character>> a, int row, int col, int num) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).get(col) == (char) (num + '0')) {
                return false;
            }
        }
        for (int i = 0; i < a.get(0).size(); i++) {
            if (a.get(row).get(i) == (char) (num + '0')) {
                return false;
            }
        }
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (a.get(i).get(j) == (char) (num + '0')) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Sudoku s = new Sudoku();
        ArrayList<ArrayList<Character>> a = new ArrayList<>();
        ArrayList<Character> row1 = new ArrayList<>();
        row1.add('5');
        row1.add('3');
        row1.add('.');
        row1.add('.');
        row1.add('7');
        row1.add('.');
        row1.add('.');
        row1.add('.');
        row1.add('.');
        ArrayList<Character> row2 = new ArrayList<>();
        row2.add('6');
        row2.add('.');
        row2.add('.');
        row2.add('1');
        row2.add('9');
        row2.add('5');
        row2.add('.');
        row2.add('.');
        row2.add('.');
        ArrayList<Character> row3 = new ArrayList<>();
        row3.add('.');
        row3.add('9');
        row3.add('8');
        row3.add('.');
        row3.add('.');
        row3.add('.');
        row3.add('.');
        row3.add('6');
        row3.add('.');
        ArrayList<Character> row4 = new ArrayList<>();
        row4.add('8');
        row4.add('.');
        row4.add('.');
        row4.add('.');
        row4.add('6');
        row4.add('.');
        row4.add('.');
        row4.add('.');
        row4.add('3');
        ArrayList<Character> row5 = new ArrayList<>();
        row5.add('4');
        row5.add('.');
        row5.add('.');
        row5.add('8');
        row5.add('.');
        row5.add('3');
        row5.add('.');
        row5.add('.');
        row5.add('1');
        ArrayList<Character> row6 = new ArrayList<>();
        row6.add('7');
        row6.add('.');
        row6.add('.');
        row6.add('.');
        row6.add('2');
        row6.add('.');
        row6.add('.');
        row6.add('.');
        row6.add('6');
        ArrayList<Character> row7 = new ArrayList<>();
        row7.add('.');
        row7.add('6');
        row7.add('.');
        row7.add('.');
        row7.add('.');
        row7.add('.');
        row7.add('2');
        row7.add('8');
        row7.add('.');
        ArrayList<Character> row8 = new ArrayList<>();
        row8.add('.');
        row8.add('.');
        row8.add('.');
        row8.add('4');
        row8.add('1');
        row8.add('9');
        row8.add('.');
    }
}