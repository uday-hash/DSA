/*
 * Problem Description
You are given a large number in the form of a string A where each character denotes a digit of the number.
You are also given a number B. You have to find out the value of A % B and return it.



Problem Constraints
1 <= A.length() <= 105
0 <= Ai <= 9
1 <= B <= 109
 */

package Modular_Arithmatic;

public class Mod_string {
    public int findMod(String A, int B) {
        long ans = 0;
        long m = B;
        int n = A.length();
        long curr = 1;
        for(int i = n - 1; i >= 0; i--){
            long dig = A.charAt(i) - 48;
            long term = (dig * curr) % m;
            ans = (ans + term) % m;
            curr = (curr * 10) % m;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        Mod_string ms = new Mod_string();
        System.out.println(ms.findMod("123456789", 1000000007));
    }
    
}
