//package Arrays.Arrays_&_Maths;

public class nth_magic_num {
    public int solve(int A) {
        int ans = 0;
        int pow = 1;
        while(A > 0){
            pow = pow * 5;
            if((A & 1) == 1){
                ans += pow;
            }
            A = A >> 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        nth_magic_num obj = new nth_magic_num();
        System.out.println(obj.solve(5));
    }
    
}
