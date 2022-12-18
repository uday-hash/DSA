/*
A wire connects N light bulbs.

Each bulb has a switch associated with it; however, due to faulty wiring, a switch also changes the state of all the bulbs to the right of the current bulb.

Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.

You can press the same switch multiple times.

Note: 0 represents the bulb is off and 1 represents the bulb is on.
Problem Constraints
0 <= N <= 5×105
0 <= A[i] <= 1


 */

package Arrays.Carry_forward;

public class Bulbs {
    public int bulbs(int[] A) {
        int n = A.length;
        int count = 0;
        int i = 0;
        while (i < n) {
            if (A[i] == 0) {
                count++;
                while (i < n && A[i] == 0) {
                    i++;
                }
            }
            if (i < n && A[i] == 1) {
                while (i < n && A[i] == 1) {
                    i++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Bulbs obj = new Bulbs();
        int[] arr = { 0, 1, 0, 1 };
        System.out.println(obj.bulbs(arr));
    }
}
