package Arrays;

import java.util.Scanner;

public class Max_Min_Array {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        //int[] arr = {2,3,4,5,6,7,8};
        //int count = 6;
        //System.out.println(maxmin(arr, count));
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        String arrIn = in.nextLine();
        String[] arrStr = arrIn.split(" ");
        int[] arr = new int[length];
        for(int i = 0; i< length; i++){
            if(i == 0){

            }
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        System.out.println(maxmin(length, arr));

    }

    public static String maxmin(int length, int[] arr){
        int max = arr[0];
        int min = arr[0];
        for(int i=0; i<length; i++){
            if(max<arr[i]){
                max = arr[i];
            }
            if(min>arr[i]){
                min = arr[i];
            }
        }
        return max+" "+min;
    }

}