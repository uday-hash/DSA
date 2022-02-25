package Arrays.SubArrays;

import java.util.*;

public class Max_positive {
    public static void main(String[] args){
        int[] arr = {-1,2,5,-1,5,7};
        int n = 6;
        int[] out = maxArray1(arr, n);
        for (int j : out) {
            System.out.print(j);
        }
    }

    static int[] maxArray1(int[] arr, int n){
        HashMap<Integer, Integer> load = new HashMap<>();
        for(int i=0; i< n; i++){
            int j=0;
            while(arr[i+j]<n && arr[i+j]>=0){
                j++;
            }
            load.put(i, j);
        }
//      fetch max index from hashMap
        int maxIndex = 0;
        for(int i=0; i< n; i++){
            if(load.get(i)>load.get(maxIndex)){
                maxIndex=i;
            }
        }
//      copy max array from provided array
        int[] out = new int[load.get(maxIndex)];
        for(int j=0; j<load.get(maxIndex); j++){
            out[j]=arr[maxIndex+j];
        }
        return out;
    }
}