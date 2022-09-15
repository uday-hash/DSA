/*
 * Problem Description
Given a string A consisting only of '(' and ')'.

You need to find whether parentheses in A are balanced or not, if it is balanced then return 1 else return 0.



Problem Constraints
1 <= |A| <= 105
 */

package Stacks_and_Queues;

public class Balanced_parantheses {
    public int solve(String A){
        int count = 0;
        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) == '('){
                count++;
            }
            else{
                count--;
            }
            if(count < 0){
                return 0;
            }
        }
        if(count == 0){
            return 1;
        }
        else{
            return 0;
        }

    }
    public static void main(String[] args) {
        Balanced_parantheses obj = new Balanced_parantheses();
        String A = "(()())";
        System.out.println(obj.solve(A));
    }
}
