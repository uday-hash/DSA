//package Arrays.Arrays_&_Maths;

import java.util.ArrayList;
import java.util.List;



public class Majority_element {
    public int majorityElement(final List<Integer> A) {
        int n = A.size();
        int count = 1;
        int majority = A.get(0);
        for (int i = 1; i < n; i++){
            if (A.get(i) == majority){
                count++;
            }
            else{
                count--;
            }
            if (count == 0){
                majority = A.get(i);
                count = 1;
            }
        }
        return majority;
    }
    public static void main(String[] args) {
        Majority_element obj = new Majority_element();
        List<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(1);
        A.add(1);
        A.add(3);
        A.add(1);
        A.add(1);
        System.out.println(obj.majorityElement(A));
        
    }
}
