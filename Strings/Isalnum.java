/*
 * Problem Description
You are given a function isalpha() consisting of a character array A.

Return 1 if all the characters of a character array are alphanumeric (a-z, A-Z, and 0-9) else, return 0.



Problem Constraints
1 <= |A| <= 105
 */
package Strings;

import java.util.ArrayList;

public class Isalnum {
    public int solve(ArrayList<Character> A) {
        for(int i=0;i<A.size();i++){
            if((A.get(i)>='a' && A.get(i)<='z') || (A.get(i)>='A' && A.get(i)<='Z') || (A.get(i)>='0' && A.get(i)<='9')){
                continue;
            }
            else{
                return 0;
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        Isalnum obj = new Isalnum();
        ArrayList<Character> A = new ArrayList<Character>();
        A.add('a');
        A.add('b');
        A.add('c');
        A.add('d');
        A.add('e');
        System.out.println(obj.solve(A));
    }
}
