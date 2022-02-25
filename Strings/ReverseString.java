package Strings;

public class ReverseString {
    public static void main(String[] args) {
       // char[] s = { 'd', 'e', 'c', 'a', 'f', 'f', 'e'};
       // System.out.println(reverseString(s));
    }
    public static void reverseString(char[] s) {
        int length = s.length;
        System.out.println(length);

        for(int i = 0; i<= (s.length - 1)/2; i++ ){
            char temp = s[i];
            s[i] = s[length - 1 - i];
            s[length - 1 - i] = temp;
            System.out.println(s[i]);
        }

    }
}
