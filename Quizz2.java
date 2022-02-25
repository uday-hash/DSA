//import com.sun.org.apache.xpath.internal.objects.XString;
import java.lang.*;
import java.util.*;

public class Quizz2 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //String name2 = in.nextLine();
        // int indexToChange = 0;
        // char newCharacter = 'T';
        // String newword = name.substring(0, indexToChange) + newCharacter + name.substring(indexToChange, name.length());
        //System.out.println(newword);


       // char[] array = name.toCharArray(); // converting to array of characters
       // array[0] = 'T';
       // String change = new String(array);
       // System.out.println(change);


       // String name = "udayiuuuuuuuuuuuuuu I amm sai kiran ";
       // String change = name.replace("sai","uday");// using replace func
       // System.out.println(change);

       // System.out.println(money());
       // System.out.println(sorting());
       // System.out.println(add());
      //  System.out.println(exceptionHandling());

    }

    public static boolean money(){
        Scanner in = new Scanner(System.in);
        int money = in.nextInt();
        int toy = 40;
        int pen = 10;
        int buy = toy + pen;
        if(money < pen){
            System.out.println("Cannot buy anyitem");
        }else if(money >= 10 && money < buy){
            System.out.println("You can buy only one item");
        }else if(money >= buy){
            System.out.println("you can buy both items");
        }else{
            System.out.println("error");
        }
        return true;
    }

    public static int sorting(){
        int a = 30;
        int b = 20;
        int c = 1;
        int[] arr = new int[3];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        for (int i = 0; i < 3; i++) {
            for (int j = i; j < 3; j++) {
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr[0];

    }

    public static int add(){
        Scanner x = new Scanner(System.in);
        String read;
        int n = 0;
        do {
            read = x.nextLine();
            if(!read.equals("ok")){
                n = n + Integer.valueOf(read);
            }
        }while(!read.equals("ok"));

        System.out.println(n);

       // int sum = a + b;
        return n;
    }

    public static int exceptionHandling(){
        int[] arr = {1,2, 3};
        try {
            System.out.println(arr[5] + " uday");

        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }




}
