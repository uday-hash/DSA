/*Problem Description

You are given two positive numbers A and B . You need to find the maximum valued integer X such that:

X divides A i.e. A % X = 0
X and B are co-prime i.e. gcd(X, B) = 1


Problem Constraints

1 <= A, B <= 109 */

package Maths;

public class Largest_coprime_divisor {
    public int cpFact(int A, int B) {
        while (gcd(A, B) != 1) {
            A = A / gcd(A, B);
        }
        return A;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    public static void main(String[] args) {
        Largest_coprime_divisor l = new Largest_coprime_divisor();
        System.out.println(l.cpFact(30, 12));
    }
}
