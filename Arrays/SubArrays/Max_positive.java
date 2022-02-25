package Arrays.SubArrays;

public class Max_positive {
    public static void main(String[] args) {
        int[] a = {5,6,-1,7,8};
        int n = a.length;
       // int res = 0;

        for(int i = 0; i < n ; i++) {
            for(int j = i; j < n; j++ ){
                for(int k = j; k <= j; k++){
                    System.out.print(a[k]);
                }
            }
            System.out.println();
        }
        //System.out.println(A);
    }
}
