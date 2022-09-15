/*
 * Problem Description
Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.

NOTE:

Each element in the result should appear as many times as it appears in both arrays.
The result can be in any order.


Problem Constraints
1 <= N, M <= 105

1 <= A[i] <= 109
 */

package Hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class Common_elements {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < A.size(); i++){
            if(map.containsKey(A.get(i))){
                map.put(A.get(i), map.get(A.get(i))+1);
            }
            else{
                map.put(A.get(i), 1);
            }
        }
        for(int i = 0; i < B.size(); i++){
            if(map.containsKey(B.get(i))){
                ans.add(B.get(i));
                map.put(B.get(i), map.get(B.get(i))-1);
                if(map.get(B.get(i)) == 0){
                    map.remove(B.get(i));
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Common_elements obj = new Common_elements();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        A.add(6);
        A.add(7);
        A.add(8);
        A.add(9);
        A.add(10);
        ArrayList<Integer> B = new ArrayList<Integer>();
        B.add(1);
        B.add(3);
        B.add(5);
        B.add(7);
        B.add(9);
        System.out.println(obj.solve(A, B));
    }
    
}
