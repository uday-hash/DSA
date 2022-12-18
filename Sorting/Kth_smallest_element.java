/*
 * Problem Description
Find the Bth smallest element in given array A .

NOTE: Users should try to solve it in less than equal to B swaps.



Problem Constraints
1 <= |A| <= 100000

1 <= B <= min(|A|, 500)

1 <= A[i] <= 109
 */

package Sorting;

import java.util.List;

public class Kth_smallest_element {
    public int kthsmallest(final List<Integer> A, int B) {
        int n = A.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = A.get(i);
        }
        int low = 0, high = n - 1;
        while (low <= high) {
            int pivot = partition(arr, low, high);
            if (pivot == B - 1) {
                return arr[pivot];
            } else if (pivot < B - 1) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }
        return -1;
    }
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        Kth_smallest_element k = new Kth_smallest_element();
        int[] arr = { 2, 1, 4, 3, 2 };
        System.out.println(k.kthsmallest(arr, 3));
    }
}

