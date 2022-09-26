/*
 * Problem Description
In the classic problem of the Towers of Hanoi, you have 3 towers numbered from 1 to 3 (left to right) and A disks numbered from 1 to A (top to bottom) of different sizes which can slide onto any tower.
The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sits on top of an even larger one).
You have the following constraints:
Only one disk can be moved at a time.
A disk is slid off the top of one tower onto another tower.
A disk cannot be placed on top of a smaller disk.
You have to find the solution to the Tower of Hanoi problem.
You have to return a 2D array of dimensions M x 3, where M is the minimum number of moves needed to solve the problem.
In each row, there should be 3 integers (disk, start, end), where:

disk - number of disk being moved
start - number of the tower from which the disk is being moved
stop - number of the tower to which the disk is being moved


Problem Constraints
1 <= A <= 18
 */

package Recursion;

import java.util.ArrayList;

public class Tower_of_hanoi {
    public ArrayList<ArrayList<Integer>> towerOfHanoi(int A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        towerOfHanoi(A, 1, 2, 3, res);
        return res;
        
    }
    
    public void towerOfHanoi(int A, int start, int aux, int end, ArrayList<ArrayList<Integer>> res) {
        if (A == 1) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(A);
            temp.add(start);
            temp.add(end);
            res.add(temp);
            return;
        }
        towerOfHanoi(A - 1, start, end, aux, res);
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(A);
        temp.add(start);
        temp.add(end);
        res.add(temp);
        towerOfHanoi(A - 1, aux, start, end, res);
    }
    public static void main(String[] args) {
        Tower_of_hanoi t = new Tower_of_hanoi();
        System.out.println(t.towerOfHanoi(3));
    }
}
