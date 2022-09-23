/*
 * You're given a read-only array of N integers. 
 * Find out if any integer occurs more than N/3 times in the array 
 * in linear time and constant additional space.
If so, return the integer. If not, return -1.

If there are multiple solutions, return any one.



Problem Constraints
1 <= N <= 7*105
1 <= A[i] <= 109
 */

import java.util.Arrays;
import java.util.List;

//package Arrays.Arrays_&_Maths;

public class Repeat_number {
    public int repeatedNumber(final List<Integer> a) {
        int n = a.size();
        int count1 = 0, count2 = 0;
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(a.get(i) == first){
                count1++;
            }
            else if(a.get(i) == second){
                count2++;
            }
            else if(count1 == 0){
                count1++;
                first = a.get(i);
            }
            else if(count2 == 0){
                count2++;
                second = a.get(i);
            }
            else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i = 0; i < n; i++){
            if(a.get(i) == first){
                count1++;
            }
            else if(a.get(i) == second){
                count2++;
            }
        }
        if(count1 > n/3){
            return first;
        }
        if(count2 > n/3){
            return second;
        }
        return -1;
    }
    public static void main(String[] args) {
        Repeat_number obj = new Repeat_number();
        System.out.println(obj.repeatedNumber(Arrays.asList(1, 2, 3, 1, 1)));
    }
	
    
}
