/*
You are given an integer T denoting the number of test cases. For each test case, 
you are given an integer array A.

You have to print the odd and even elements of array A in 2 separate lines.

NOTE: Array elements should have the same relative order as in A.

Problem Constraints
1 <= T <= 10

1 <= |A| <= 105

1 <= A[i] <= 109
 */

package Arrays;

import java.util.Scanner;

public class Separate_Odd_Even {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- > 0){
            int N = sc.nextInt();
            int[] A = new int[N];
            int cnto = 0;
            int cnte = 0;

            for (int i = 0; i < N; i++){
                A[i] = sc.nextInt();
                if(A[i] % 2 == 1){
                    cnto++;
                }
                else{
                    cnte++;
                }
            }
            int[] B = new int[cnto];
            int[] C = new int[cnte];
            int ptrB = 0;
            int ptrC = 0;
            for (int i = 0; i < N; i++){
                if(A[i] % 2 ==  1){
                    B[ptrB] = A[i];
                    ptrB++;
                }
                else{
                    C[ptrC] = A[i];
                    ptrC++;
                }
            }
            for (int i = 0; i < cnto; i++){
                System.out.print(B[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < cnte; i++){
                System.out.print(C[i] + " ");
            }
            System.out.println();
        }

    }
   
}
