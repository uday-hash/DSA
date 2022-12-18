/*
 * Problem Description

Given a number A. Return square root of the number if it is perfect square otherwise return -1.

Problem Constraints

1 <= A <= 108
 */
package Problem_solving;

public class Square_root_of_a_number {
    public int solve(int A){
        int i = 1;
        while(i*i <= A){
            if(i*i == A){
                return i;
            }
            i++;
        }
        return -1;
        
    }
    public static void main(String[] args) {
        Square_root_of_a_number obj = new Square_root_of_a_number();
        System.out.println(obj.solve(11));
        
    }
}
