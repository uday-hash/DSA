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
package Recursion;

public class Power_function {
    public int pow(int A, int B, int C) {
        if (A == 0) {
            return 0;
        }
        if (B == 0) {
            return 1;
        }
        long ans = 1;
        long a = A;
        while (B > 0) {
            if (B % 2 == 1) {
                ans = (ans * a) % C;
                B--;
            } else {
                a = (a * a) % C;
                B /= 2;
            }
        }
        if (ans < 0) {
            ans = (ans + C) % C;
        }
        return (int) ans;    
    }
    
    public static void main(String[] args) {
        Power_function obj = new Power_function();
        int A = 2;
        int B = 3;
        int C = 3;
        System.out.println(obj.pow(A, B, C));
    }
    
}
