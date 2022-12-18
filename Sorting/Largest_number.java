/*
 * Problem Description
Given an array A of non-negative integers, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.



Problem Constraints
1 <= len(A) <= 100000
0 <= A[i] <= 2*109


 */

package Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Largest_number {
    public String largetstnumberString(final List<Integer> A) {
        String[] arr = new String[A.size()];
        for(int i = 0; i < A.size(); i++){
            arr[i] = String.valueOf(A.get(i));
        }
        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String a, String b){
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String s: arr){
            sb.append(s);
        }
        while(sb.charAt(0) == '0' && sb.length() > 1){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Largest_number obj = new Largest_number();
        System.out.println(obj.largetstnumberString(Arrays.asList(3, 30, 34, 5, 9)));
    }
}
