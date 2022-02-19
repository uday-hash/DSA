package Arrays;

public class Good_pair {
    public static void main(String[] args) {
        int[] A = {2,3,4,6,8};
        int B = 7;
        System.out.println(pair(A,B)); // two-pointer approach O(n)
       // System.out.println(solve(A,B));  //  brute-force O(n2)
    }

    public static int pair(int[] A, int B){
        for(int i=0; i<A.length; i++){
            for(int j=i+1; j<A.length; j++){
                if(A[i]+A[j]==B){
                    return 1;
                }
            }
        }
        return 0;
    }

    public static int solve(int[] A, int B) {
        int j = A.length-1;
        int i=0;
        for(int n=0; n<A.length; n++){
            if(A[i]+A[j]==B){
                return 1;
            } else if(A[i]+A[j]>B){
                j--;
            } else if(A[i]+A[j]<B){
                i++;
            }
        }
        return 0;

    }
}
