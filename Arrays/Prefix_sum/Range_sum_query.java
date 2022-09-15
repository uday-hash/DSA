package Arrays.Prefix_sum;

public class Range_sum_query {
    public long[] solve(int[] A, int[][] B) {
        int n = A.length;
        long[] left = new long[n];
        long[] right = new long[n];
        left[0] = A[0];
        right[n-1] = A[n-1];
        for(int i=1;i<n;i++){
            left[i] = left[i-1] + A[i];
        }
        for(int i=n-2;i>=0;i--){
            right[i] = right[i+1] + A[i];
        }
        int m = B.length;
        long[] ans = new long[m];
        for(int i=0;i<m;i++){
            int l = B[i][0]-1;
            int r = B[i][1]-1;
            if(l>0){
                ans[i] = left[r] - left[l-1];
            }else{
                ans[i] = left[r];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Range_sum_query obj = new Range_sum_query();
        int[] A = {1,2,3,4,5};
        int[][] B = {{0,2},{2,4},{0,4}};
        long[] ans = obj.solve(A,B);
        for (long an : ans) {
            System.out.print(an + " ");
        }
    }
}
