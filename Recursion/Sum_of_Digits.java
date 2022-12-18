package Recursion;

public class Sum_of_Digits {
    public int solve(int A){
        if(A == 0){
            return 0;
        }
        return A%10 + solve(A/10);
    }
    public static void main(String[] args) {
        Sum_of_Digits obj = new Sum_of_Digits();
        int A = 1291;
        System.out.println(obj.solve(A));
    }
    
}
