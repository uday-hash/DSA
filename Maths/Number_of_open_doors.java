/*
 * Problem Description
Given an integer A, which denotes the number of doors in a row numbered 1 to A. All the doors are closed initially.

A person moves to and fro, changing the states of the doors as follows: the person opens a door that is already closed and closes a door that is already opened.

In the first go, he/she alters the states of doors numbered 1, 2, 3, … , A.
In the second go, he/she alters the states of doors numbered 2, 4, 6 ….
In the third go, he/she alters the states of doors numbered 3, 6, 9 …
This continues till the A'th go in, which you alter the state of the door numbered A.

Find and return the number of open doors at the end of the procedure.



Problem Constraints
1 <= A <= 109
 */

package Maths;

public class Number_of_open_doors {
    public int solve(int A) {
        int count = 0;
        for (int i = 1; i * i <= A; i++) {
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Number_of_open_doors n = new Number_of_open_doors();
        System.out.println(n.solve(100));
    }
    
}
