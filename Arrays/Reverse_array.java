package Arrays;

import java.util.Scanner;
import java.util.Arrays;

public class Reverse_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] A = new int[6];
        A[0] = sc.nextInt();
        for (int i = 1; i < A.length; i++) {
            A[i] = sc.nextInt();
        }
        solve(A);
        System.out.println(Arrays.toString(A));
        sc.close();
    }

    public static int[] solve(final int[] A){
        int start = 0;
        int end = A.length-1;

        while(start< end){
            //swap
            swap(A,start,end);
            start++;
            end--;
        }

        return A;
    }

    static void swap(int[] A, int index1, int index2){
        int temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
    }
}
