package Arrays;

//import java.lang.*;
import java.util.*;

public class Search_element {
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
            for(int i = 0;i < N;i++){
                A[i] = sc.nextInt();
            }
            int B;
            B = sc.nextInt();
            int found = 0;
            for (int i = 0; i < N;i++){
                if(A[i] ==  B){
                    found = 1;
                }
            }
            System.out.println(found);
        }
        sc.close();
    }
}