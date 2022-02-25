package Arrays;

import java.lang.*;
import java.util.*;

public class Rotation_game {

    public static void reverse(int[] A, int start, int end) {
        int i, j;
        for (i = start, j = end; i < j; i++, j--) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        int B = sc.nextInt() % n;
        reverse(A, 0, n - 1);
        reverse(A, 0, B - 1);
        reverse(A, B, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println("");
    }
}