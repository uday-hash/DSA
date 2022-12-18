package Strings;

import java.util.ArrayList;

public class Longest_common_prefix {
    public String longestCommonPrefix(ArrayList<String> A) {
        String ans = "";
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < A.size(); i++){
            if(A.get(i).length() < min){
                min = A.get(i).length();
            }
        }
        for(int i = 0; i < min; i++){
            char c = A.get(0).charAt(i);
            for(int j = 1; j < A.size(); j++){
                if(A.get(j).charAt(i) != c){
                    return ans;
                }
            }
            ans += c;
        }
        return ans;
    }
    public static void main(String[] args) {
        Longest_common_prefix obj = new Longest_common_prefix();
        ArrayList<String> A = new ArrayList<String>();
        A.add("abcdefgh");
        A.add("aefghijk");
        A.add("abcefgh");
        System.out.println(obj.longestCommonPrefix(A));
    }
    
}
