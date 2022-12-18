/*
 * Problem Description
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer A representing the total number of bits in the code, print the sequence of gray code.

A gray code sequence must begin with 0.



Problem Constraints
1 <= A <= 16


 */

package Recursion2;

import java.util.ArrayList;

public class Gray_code {
    public ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(a == 0){
            ans.add(0);
            return ans;
        }
        ArrayList<Integer> temp = grayCode(a-1);
        for(int i = 0; i < temp.size(); i++){
            ans.add(temp.get(i));
        }
        for(int i = temp.size()-1; i >= 0; i--){
            ans.add(temp.get(i) + (int)Math.pow(2, a-1));
        }
        return ans;

	}
    public static void main(String[] args) {
        Gray_code obj = new Gray_code();
        int A = 3;
        System.out.println(obj.grayCode(A));
    }
    
}
