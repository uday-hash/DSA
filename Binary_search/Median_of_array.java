/*
Problem Description
There are two sorted arrays A and B of sizes N and M respectively.

Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

NOTE:

The overall run time complexity should be O(log(m+n)).
IF the number of elements in the merged array is even, then the median is the average of (n/2)th and (n/2+1)th element. For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.


Problem Constraints
1 <= N + M <= 2*106
*/
package Binary_search;

import java.util.ArrayList;
import java.util.List;

public class Median_of_array {
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int n = a.size(), m = b.size();
        if (n > m) {
            return findMedianSortedArrays(b, a);
        }
        int low = 0, high = n;
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (n + m + 1) / 2 - partitionX;
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : a.get(partitionX - 1);
            int minRightX = (partitionX == n) ? Integer.MAX_VALUE : a.get(partitionX);
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : b.get(partitionY - 1);
            int minRightY = (partitionY == m) ? Integer.MAX_VALUE : b.get(partitionY);
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((n + m) % 2 == 0) {
                    return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Median_of_array m = new Median_of_array();
        List<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(4);
        a.add(5);
        List<Integer> b = new ArrayList<Integer>();
        b.add(2);
        b.add(3);
        System.out.println(m.findMedianSortedArrays(a, b));
    }
}