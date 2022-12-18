/*
 * Problem Description
There are N jobs to be done, but you can do only one job at a time.

Given an array A denoting the start time of the jobs and an array B denoting the finish time of the jobs.

Your aim is to select jobs in such a way so that you can finish the maximum number of jobs.

Return the maximum number of jobs you can finish.



Problem Constraints
1 <= N <= 105

1 <= A[i] < B[i] <= 109


 */

package Greedy_Algorithm;

import java.util.*;

public class Finish_maximum_jobs {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int[][] jobs = new int[A.size()][2];
        for (int i = 0; i < A.size(); i++) {
            jobs[i][0] = A.get(i);
            jobs[i][1] = B.get(i);
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        int count = 1;
        int end = jobs[0][1];
        for (int i = 1; i < jobs.length; i++) {
            if (jobs[i][0] >= end) {
                count++;
                end = jobs[i][1];
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Finish_maximum_jobs fmj = new Finish_maximum_jobs();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(3);
        A.add(0);
        A.add(5);
        A.add(8);
        A.add(5);
        ArrayList<Integer> B = new ArrayList<>();
        B.add(2);
        B.add(4);
        B.add(6);
        B.add(7);
        B.add(9);
        B.add(9);
        System.out.println(fmj.solve(A, B));
    }
}

