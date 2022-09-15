/*
 * Problem Description
Given a column title as appears in an Excel sheet, return its corresponding column number.



Problem Constraints
1 <= length of the column title <= 5


 */

package Modular_Arithmatic;

public class Excel_column_number {
    public int titleToNumber(String A) {
        int ans = 0;
        for (int i = 0; i < A.length(); i++) {
            ans = ans * 26 + (A.charAt(i) - 'A' + 1);
        }
        return ans;
    }
    public static void main(String[] args) {
        Excel_column_number ecn = new Excel_column_number();
        System.out.println(ecn.titleToNumber("A"));
        System.out.println(ecn.titleToNumber("AB"));
        System.out.println(ecn.titleToNumber("ZY"));
    }
    
}
