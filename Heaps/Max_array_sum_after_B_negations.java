package Heaps;

import java.util.*;

public class Max_array_sum_after_B_negations {
    public int solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < A.size(); i++) {
            pq.add(A.get(i));
        }
        while (B > 0) {
            int min = pq.poll();
            pq.add(-min);
            B--;
        }
        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        return sum;
    }

    public static void main(String[] args) {
        Max_array_sum_after_B_negations mas = new Max_array_sum_after_B_negations();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        System.out.println(mas.solve(A, 2));
    }
}