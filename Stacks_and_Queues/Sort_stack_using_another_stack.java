/*
 * Problem Description
Given a stack of integers A, sort it using another stack.

Return the array of integers after sorting the stack using another stack.



Problem Constraints
1 <= |A| <= 5000

0 <= A[i] <= 109


Example Input
Input 1:

 A = [5, 4, 3, 2, 1]
Input 2:

 A = [5, 17, 100, 11]


Example Output
Output 1:

 [1, 2, 3, 4, 5]
Output 2:

 [5, 11, 17, 100]


Example Explanation
Explanation 1:

 Just sort the given numbers.
Explanation 2:

 Just sort the given numbers.


 */
package Stacks_and_Queues;

import java.util.*;
public class Sort_stack_using_another_stack {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < A.size(); i++) {
            s.push(A.get(i));
        }
        Stack<Integer> temp = new Stack<>();
        while (!s.isEmpty()) {
            int curr = s.pop();
            while (!temp.isEmpty() && temp.peek() > curr) {
                s.push(temp.pop());
            }
            temp.push(curr);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!temp.isEmpty()) {
            ans.add(temp.pop());
        }
        return ans;
    }
}
