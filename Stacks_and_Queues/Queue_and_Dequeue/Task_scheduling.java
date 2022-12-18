/*
 * Problem Description
A CPU has N tasks to be performed. It is to be noted that the tasks have to be completed in a specific order to avoid deadlock. In every clock cycle, the CPU can either perform a task or move it to the back of the queue. You are given the current state of the scheduler queue in array A and the required order of the tasks in array B.

Determine the minimum number of clock cycles to complete all the tasks.


Problem Constraints
1 <= N <= 1000
1 <= A[i], B[i] <= N
 */
package Stacks_and_Queues.Queue_and_Dequeue;

import java.util.*;

public class Task_scheduling {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size();
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            q.add(A.get(i));
        for (int i = 0; i < n; i++) {
            int curr = B.get(i);
            int idx = 0;
            Queue<Integer> temp = new LinkedList<>();
            while (q.peek() != curr) {
                temp.add(q.poll());
                idx++;
            }
            q.poll();
            ans += idx + 1;
            while (!temp.isEmpty())
                q.add(temp.poll());
        }
        return ans;
    }
    public static void main(String[] args) {
        Task_scheduling t = new Task_scheduling();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));
        System.out.println(t.solve(A, B));
    }
}
    
    