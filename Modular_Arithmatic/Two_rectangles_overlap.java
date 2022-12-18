/*
 * Problem Description
Eight integers A, B, C, D, E, F, G, and H represent two rectangles in a 2D plane.
For the first rectangle, its bottom left corner is (A, B), and the top right corner is (C, D), and for the second rectangle, its bottom left corner is (E, F), and the top right corner is (G, H).

Find and return whether the two rectangles overlap or not.



Problem Constraints
-10000 <= A < C <= 10000

-10000 <= B < D <= 10000

-10000 <= E < G <= 10000

-10000 <= F < H <= 10000



 */

package Modular_Arithmatic;

public class Two_rectangles_overlap {
    public int solve(int A, int B, int C, int D, int E, int F, int G, int H) {

       if (A >= G || B >= H || C <= E || D <= F) {
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        Two_rectangles_overlap tro = new Two_rectangles_overlap();
        System.out.println(tro.solve(0, 0, 1, 1, 1, 0, 2, 1));
    }

}