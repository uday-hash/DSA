/*
 * Problem Description
Richard Hendricks, a mastermind in compression algorithms, is an employee of Hooli in Silicon Valley.
One day, he finally decided to quit and work on his new idea of the middle-out compression algorithm.

He needed to work at the bit - level to compress data. He, eventually, encountered this problem.
There is an array A of N integers. He has to perform certain operations on the elements.
In any one operation, two indices i and j (i < j) are chosen, and A[i] is replaced with A[i] & A[j],
and A[j] is replaced with A[i] | A[j], where & represents the Bitwise AND operation and | represents the Bitwise OR operation.
This operation is performed over all the pairs of integers in the array.

Help Richard find the Bitwise XOR of all the elements after performing the operations.



Problem Constraints
1 <= N <= 105
1 <= Ai <= 109
 */

package Bit_manipulation;

import java.util.*;

public class Bit_compression {
    public int compressBits(ArrayList<Integer> A) {
        int n=A.size();
        int ans=0;
        for(int i=0; i<n; ++i)
        ans^=A.get(i);
        return ans;

    }
    public static void main(String[] args) {
        Bit_compression obj=new Bit_compression();
        ArrayList<Integer> A=new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        System.out.println(obj.compressBits(A));
    }

    
}
