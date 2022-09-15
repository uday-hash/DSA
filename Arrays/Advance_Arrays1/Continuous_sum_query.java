/*
 * Problem Description
There are A beggars sitting in a row outside a temple. Each beggar initially has an empty pot. When the devotees come to the temple, they donate some amount of coins to these beggars. Each devotee gives a fixed amount of coin(according to their faith and ability) to some K beggars sitting next to each other.

Given the amount P donated by each devotee to the beggars ranging from L to R index, where 1 <= L <= R <= A, find out the final amount of money in each beggar's pot at the end of the day, provided they don't fill their pots by any other means.
For ith devotee B[i][0] = L, B[i][1] = R, B[i][2] = P, Given by the 2D array B


Problem Constraints
1 <= A <= 2 * 105
1 <= L <= R <= A
1 <= P <= 103
0 <= len(B) <= 105

 */
package Arrays.Advance_Arrays1;

import java.util.ArrayList;

public class Continuous_sum_query {
    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        int[] arr = new int[A];
        for(int i = 0; i < B.size(); i++){
            int l = B.get(i).get(0) - 1;
            int r = B.get(i).get(1) - 1;
            int p = B.get(i).get(2);
            arr[l] += p;
            if(r + 1 < A){
                arr[r + 1] -= p;
            }
        }
        int sum = 0;
        for(int i = 0; i < A; i++){
            sum += arr[i];
            arr[i] = sum;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < A; i++){
            ans.add(arr[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        Continuous_sum_query obj = new Continuous_sum_query();
        int A = 5;
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        temp.add(10);
        B.add(temp);
        temp = new ArrayList<>();
        temp.add(2);
        temp.add(3);
        temp.add(20);
        B.add(temp);
        temp = new ArrayList<>();
        temp.add(2);
        temp.add(5);
        temp.add(25);
        B.add(temp);
        System.out.println(obj.solve(A, B));
    }
    
}
