package Arrays.Advance_Array3;

import java.util.ArrayList;

public class Spiral_order_matrix {
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        int n = A;
        int[][] arr = new int[n][n];
        int count = 1;
        int i=0;
        int j=0;
        int dir = 0;
        while(count<=n*n){
            arr[i][j] = count;
            count++;
            if(dir==0){
                if(j+1<n && arr[i][j+1]==0){
                    j++;
                }else{
                    dir = 1;
                    i++;
                }
            }else if(dir==1){
                if(i+1<n && arr[i+1][j]==0){
                    i++;
                }else{
                    dir = 2;
                    j--;
                }
            }else if(dir==2){
                if(j-1>=0 && arr[i][j-1]==0){
                    j--;
                }else{
                    dir = 3;
                    i--;
                }
            }else if(dir==3){
                if(i-1>=0 && arr[i-1][j]==0){
                    i--;
                }else{
                    dir = 0;
                    j++;
                }
            }
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int k=0;k<n;k++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int l=0;l<n;l++){
                temp.add(arr[k][l]);
            }
            ans.add(temp);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(new Spiral_order_matrix().generateMatrix(3));
    }
}
