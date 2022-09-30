/*
 * Problem Description
Given an integer A, you have to find the Ath Perfect Number.

A Perfect Number has the following properties:

It comprises only 1 and 2.

The number of digits in a Perfect number is even.

It is a palindrome number.

For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.



Problem Constraints
1 <= A <= 100000
 */

package Stacks_and_Queues.Queue_and_Dequeue;

import java.util.*;
public class Perfect_numbers {
    public String solve(int A) {
        Queue<String> q = new LinkedList<>();
        q.add("1");
        q.add("2");
        int count = 0;
        while(count < A) {
            String curr = q.poll();
            if(isPerfect(curr)) {
                count++;
                if(count == A)
                    return curr;
            }
            q.add(curr + "1");
            q.add(curr + "2");
        }
        return "";
    }
    private boolean isPerfect(String curr) {
        int n = curr.length();
        if(n % 2 != 0)
            return false;
        int i = 0;
        int j = n - 1;
        while(i < j) {
            if(curr.charAt(i) != curr.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    
    }
    
    public static void main(String[] args) {
        Perfect_numbers p = new Perfect_numbers();
        System.out.println(p.solve(4));
    }

}
    