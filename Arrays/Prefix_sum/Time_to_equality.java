package Arrays.Prefix_sum;

public class Time_to_equality {
    public int solve(int[] A) {
        int n = A.length;
        int[] prefix = new int[n];
        prefix[0] = A[0];
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1] + A[i];
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            if(prefix[i] == (i+1)*A[i]){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Time_to_equality obj = new Time_to_equality();
        int[] A = {1,2,3,4,5};
        System.out.println(obj.solve(A));
    }
}
