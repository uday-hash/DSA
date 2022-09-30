/*
 * Problem Description
The local ship renting service has a special rate plan:

It is up to a passenger to choose a ship.
If the chosen ship has X (X > 0) vacant places at the given moment, then the ticket for such a ship costs X.
The passengers buy tickets in turn, the first person in the queue goes first, then the second one, and so on up to A-th person.

You need to tell the maximum and the minimum money that the ship company can earn if all A passengers buy tickets.



Problem Constraints
1 ≤ A ≤ 3000
1 ≤ B ≤ 1000
1 ≤ C[i] ≤ 1000
It is guaranteed that there are at least A empty seats in total.
 */
package Greedy_Algorithm;

import java.util.*;

public class Ship_company {
    public ArrayList<Integer> solve(int A, int B, ArrayList<Integer> C) {
        ArrayList<Integer> ans = new ArrayList<>();
        int max = 0;
        int min = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < B; i++) {
            pq.add(C.get(i));
        }
        for (int i = 0; i < A; i++) {
            int curr = pq.poll();
            max += curr;
            curr--;
            if (curr > 0) {
                pq.add(curr);
            }
        }
        ans.add(max);
        pq.clear();
        for (int i = 0; i < B; i++) {
            pq.add(C.get(i));
        }
        for (int i = 0; i < A; i++) {
            int curr = pq.poll();
            min += curr;
            curr--;
            if (curr > 0) {
                pq.add(curr);
            }
        }
        ans.add(min);
        return ans;
        
    }
}
