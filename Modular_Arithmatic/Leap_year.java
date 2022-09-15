/*
 * Problem Description
Given an integer A representing a year, Return 1 if it is a leap year else, return 0.

A year is a leap year if the following conditions are satisfied:

The year is multiple of 400.
Else the year is multiple of 4 and not multiple of 100.


Problem Constraints
1 <= A <= 109


 */

package Modular_Arithmatic;

public class Leap_year {
    public int solve(int A) {
        if (A % 400 == 0 || (A % 4 == 0 && A % 100 != 0)) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Leap_year ly = new Leap_year();
        System.out.println(ly.solve(2020));
    }
    
}
