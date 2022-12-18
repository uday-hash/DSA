/*
 * Problem Description
Given an integer A.

Compute and return the square root of A.

If A is not a perfect square, return floor(sqrt(A)).

DO NOT USE SQRT FUNCTION FROM THE STANDARD LIBRARY.

NOTE: Do not use the sqrt function from the standard library. Users are expected to solve this in O(log(A)) time.



Problem Constraints
0 <= A <= 1010
 */

package Binary_search;

public class Square_root_of_integer {
    public int sqrt(int A) {
        if (A == 0 || A == 1) {
            return A;
        }
        int low = 1, high = A;
        int result = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid <= A / mid) {
                low = mid + 1;
                result = mid;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Square_root_of_integer s = new Square_root_of_integer();
        System.out.println(s.sqrt(11));
        System.out.println(s.sqrt(9));
        System.out.println(s.sqrt(0));
        System.out.println(s.sqrt(1));
        System.out.println(s.sqrt(2));
        System.out.println(s.sqrt(3));
        System.out.println(s.sqrt(4));
        System.out.println(s.sqrt(5));
        System.out.println(s.sqrt(6));
        System.out.println(s.sqrt(7));
        System.out.println(s.sqrt(8));
        System.out.println(s.sqrt(9));
        System.out.println(s.sqrt(10));
        
    }
}
