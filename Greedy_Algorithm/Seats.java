/*Problem Description
There is a row of seats represented by string A. Assume that it contains N seats adjacent to each other.
There is a group of people who are already seated in that row randomly. i.e. some are sitting together & some are scattered.

An occupied seat is marked with a character 'x' and an unoccupied seat is marked with a dot ('.')

Now your target is to make the whole group sit together i.e. next to each other, without having any vacant seat between them in such a way that the total number of hops or jumps to move them should be minimum.

In one jump a person can move to the adjacent seat (if available).

NOTE: 1. Return your answer modulo 107 + 3.



Problem Constraints
1 <= N <= 1000000
A[i] = 'x' or '.'
 */
package Greedy_Algorithm;



public class Seats {
    public int seats(String A) {
        int n = A.length();
        int[] arr = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == 'x') {
                arr[count] = i;
                count++;
            }
        }
        int mid = count / 2;
        int ans = 0;
        int left = arr[mid];
        int right = arr[mid];
        for (int i = mid - 1; i >= 0; i--) {
            left--;
            ans = (ans + (left - arr[i])) % 10000003;
        }
        for (int i = mid + 1; i < count; i++) {
            right++;
            ans = (ans + (arr[i] - right)) % 10000003;
        }
        return ans;
    }
    public static void main(String[] args) {
        Seats s = new Seats();
        System.out.println(s.seats("....x..xx...x.."));
    }
}
