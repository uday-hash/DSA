/*
 * Problem Description
Given two binary strings, return their sum (also a binary string).
 */

package Bit_manipulation;

public class Add_binary_strings {
    public String addBinary(String A, String B) {
        int i = A.length() - 1;
        int j = B.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) {
                sum += B.charAt(j) - '0';
                j--;
            }
            if (i >= 0) {
                sum += A.charAt(i) - '0';
                i--;
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        Add_binary_strings abs = new Add_binary_strings();
        System.out.println(abs.addBinary("100", "11"));
    }
    
}
