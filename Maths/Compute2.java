/*
 * Problem Description
Given three integers A, B, and C, where A represents n, B represents r,
and C represents p and p is a prime number greater than equal to n, 
find and return the value of nCr % p where nCr % p = (n! / ((n-r)! * r!)) % p.

x! means factorial of x i.e. x! = 1 * 2 * 3... * x.

NOTE: For this problem, we are considering 1 as a prime.



Problem Constraints
1 <= A <= 106
1 <= B <= A
A <= C <= 109+7
 */

package Maths;

public class Compute2 {
    public int solve(int A, int B, int C) {
        long n = A;
        long r = B;
        long p = C;
        long[] fact = new long[(int) n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % p;
        }
        long ans = (fact[(int) n] * modInverse((fact[(int) r] * fact[(int) (n - r)]) % p, p)) % p;
        return (int) ans;
    }

    private long modInverse(long a, long m) {
        long m0 = m;
        long y = 0, x = 1;
        if (m == 1) {
            return 0;
        }
        while (a > 1) {
            long q = a / m;
            long t = m;
            m = a % m;
            a = t;
            t = y;
            y = x - q * y;
            x = t;
        }
        if (x < 0) {
            x += m0;
        }
        return x;
    }
}