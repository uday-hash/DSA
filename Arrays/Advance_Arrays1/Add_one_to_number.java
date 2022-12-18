/*
 * Problem Description
Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, the following are some good questions to ask :

Q: Can the input have 0's before the most significant digit. Or, in other words, is 0 1 2 3 a valid input?
A: For the purpose of this question, YES
Q: Can the output have 0's before the most significant digit? Or, in other words, is 0 1 2 4 a valid output?
A: For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.


Problem Constraints
1 <= size of the array <= 1000000
 */

package Arrays.Advance_Arrays1;

import java.util.ArrayList;

public class Add_one_to_number {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int n = A.size();
        int carry = 1;
        for(int i = n - 1; i >= 0; i--){
            int sum = A.get(i) + carry;
            A.set(i, sum % 10);
            carry = sum / 10;
        }
        if(carry == 1){
            A.add(0, 1);
        }
        int i = 0;
        while(i < A.size() && A.get(i) == 0){
            A.remove(i);
        }
        return A;
    }
    public static void main(String[] args) {
        Add_one_to_number obj = new Add_one_to_number();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(0);
        A.add(6);
        A.add(0);
        A.add(6);
        A.add(4);
        A.add(8);
        A.add(8);
        A.add(1);
        System.out.println(obj.plusOne(A));
    }
}
