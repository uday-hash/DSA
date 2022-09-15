package Strings;

import java.util.ArrayList;

public class Tolower {
    public ArrayList<Character> to_lower(ArrayList<Character> A) {
        for(int i=0;i<A.size();i++){
            if(A.get(i)>='A' && A.get(i)<='Z'){
                A.set(i, (char)(A.get(i)+32));
            }
        }
        return A;
    }

    public static void main(String[] args) {
        Tolower obj = new Tolower();
        ArrayList<Character> A = new ArrayList<Character>();
        A.add('A');
        A.add('B');
        A.add('C');
        A.add('D');
        A.add('E');
        System.out.println(obj.to_lower(A));
        
    }
}
