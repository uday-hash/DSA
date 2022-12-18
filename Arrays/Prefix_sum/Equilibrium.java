package Arrays.Prefix_sum;

public class Equilibrium {
    public int solve(int[] A) {
        int n = A.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = A[0];
        right[n-1] = A[n-1];
        for(int i=1;i<n;i++){
            left[i] = left[i-1] + A[i];
        }
        for(int i=n-2;i>=0;i--){
            right[i] = right[i+1] + A[i];
        }
        for(int i=0;i<n;i++){
            if(left[i] == right[i]){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Equilibrium obj = new Equilibrium();
        int[] A = {1,2,3,4,5};
        System.out.println(obj.solve(A));
    }
}
