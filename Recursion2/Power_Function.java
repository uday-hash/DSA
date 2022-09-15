/*
 * Problem Description
Implement pow(A, B) % C.
In other words, given A, B and C, Find (AB % C).

Note: The remainders on division cannot be negative. In other words, make sure the answer you return is non-negative.



Problem Constraints
-109 <= A <= 109
0 <= B <= 109
1 <= C <= 109
 */

package Recursion2;

public class Power_Function {
    public int pow(int x, int n, int d) {
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x%d;
        }
        long temp = pow(x, n/2, d);
        if(n%2 == 0){
            return (int)((temp*temp)%d);
        }
        return (int)((temp*temp*x)%d);

        
    }
     
    public static void main(String[] args) {
        Power_Function obj = new Power_Function();
        int A = 2;
        int B = 3;
        int C = 3;
        System.out.println(obj.pow(A, B, C));
    }
}
