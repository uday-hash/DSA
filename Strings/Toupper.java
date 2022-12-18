package Strings;

import java.util.ArrayList;

public class Toupper {
    public ArrayList<Character> to_upper(ArrayList<Character> A) {
        for(int i=0;i<A.size();i++){
            if(A.get(i)>='a' && A.get(i)<='z'){
                A.set(i, (char)(A.get(i)-32));
            }
        }
        return A;
        
    }
    public static void main(String[] args) {
        Toupper obj = new Toupper();
        ArrayList<Character> A = new ArrayList<Character>();
        A.add('a');
        A.add('b');
        A.add('c');
        A.add('d');
        A.add('e');
        System.out.println(obj.to_upper(A));
    }
    
}
