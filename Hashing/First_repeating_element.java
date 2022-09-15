/*
 * Problem Description
Given an integer array A of size N, find the first repeating element in it.

We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.

If there is no repeating element, return -1.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 109


 */
package Hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class First_repeating_element {
    public int solve(ArrayList<Integer> A){
        int n = A.size();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = A.get(i);
        }
        int min = -1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i])){
                int temp = map.get(arr[i]);
                if(temp < min){
                    min = temp;
                }
            }
            else{
                map.put(arr[i], i);
            }
        }
        return min;
        
    }
public static void main(String[] args) {
        First_repeating_element obj = new First_repeating_element();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(10);
        A.add(5);
        A.add(3);
        A.add(4);
        A.add(3);
        A.add(5);
        A.add(6);
        System.out.println(obj.solve(A));
    }

    
}
