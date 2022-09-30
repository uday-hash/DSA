/*
 * Problem Description
The monetary system in DarkLand is really simple and systematic. The locals-only use coins. The coins come in different values. The values used are:

 1, 5, 25, 125, 625, 3125, 15625, ...
Formally, for each K >= 0 there are coins worth 5K.

Given an integer A denoting the cost of an item, find and return the smallest number of coins necessary to pay exactly the cost of the item (assuming you have a sufficient supply of coins of each of the types you will need).



Problem Constraints
1 <= A <= 2×109
 */

package Greedy_Algorithm;

import java.util.*;

public class Another_coin_problem {
    public int solve(int A) {

        int count = 0;
        while (A > 0) {
            int temp = (int) Math.floor(Math.log(A) / Math.log(5));
            A -= Math.pow(5, temp);
            count++;
        }
        return count;
        
        
    }

    public static void main(String[] args) {
        Another_coin_problem acp = new Another_coin_problem();
        System.out.println(acp.solve(10));
    }
}