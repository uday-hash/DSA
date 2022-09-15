package Trees;

//import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Stack;

public class Inorderwithoutrecursion {
    public int[] inorderTraversal(TreeNode A) {

        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode curr = A;
        while(curr != null || stack.size() > 0){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();


            list.add(curr.val);
            curr = curr.right;
        }
        int[] arr = new int[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i] = list.get(i);
        }
        return arr;

    }
    public int[] preorderTraversal(TreeNode A) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode curr = A;
        while(curr != null || stack.size() > 0){
            while(curr != null){
                list.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
        int[] arr1 = new int[list.size()];
        for(int i=0;i<list.size();i++){
            arr1[i] = list.get(i);
        }
        return arr1;
    }
    public int[] postorderTraversal(TreeNode A) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode curr = A;
        while(curr != null || stack.size() > 0){
            while(curr != null){
                list.add(curr.val);
                stack.push(curr);
                curr = curr.right;
            }
            curr = stack.pop();
            curr = curr.left;
        }
        int[] arr2 = new int[list.size()];
        for(int i=0;i<list.size();i++){
            arr2[i] = list.get(i);
        }
        return arr2;
    }

    public int solve(TreeNode A) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode curr = A;
        while(curr != null || stack.size() > 0){
            while(curr != null){
                list.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
        int[] arr2 = new int[list.size()];
        for(int i=0;i<list.size();i++){
            arr2[i] = list.get(i);
        }
        return arr2.length;
    }
    public int isSameTree(TreeNode A, TreeNode B) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode curr = A;
        while(curr != null || stack.size() > 0){
            while(curr != null){
                list.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
        int[] arr2 = new int[list.size()];
        for(int i=0;i<list.size();i++){
            arr2[i] = list.get(i);
        }
        Stack<TreeNode> stack1 = new Stack<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        TreeNode curr1 = B;
        while(curr1 != null || stack1.size() > 0){
            while(curr1 != null){
                list1.add(curr1.val);
                stack1.push(curr1);
                curr1 = curr1.left;
            }
            curr1 = stack1.pop();
            curr1 = curr1.right;
        }
        int[] arr3 = new int[list1.size()];
        for(int i=0;i<list1.size();i++){
            arr3[i] = list1.get(i);
        }
        if(arr2.length != arr3.length){
            return 0;
        }
        for(int i=0;i<arr2.length;i++){
            if(arr2[i] != arr3[i]){
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        Inorderwithoutrecursion i = new Inorderwithoutrecursion();
        int[] arr = i.inorderTraversal(root);
        for (int k : arr) {
            System.out.print(k + " ");
        }
       /* Preorderwithoutrecursion p = new Preorderwithoutrecursion();
        int[] arr1 = p.preorderTraversal(root);
        for (int k : arr1) {
            System.out.print(k + " ");
        }
        Postorderwithoutrecursion po = new Postorderwithoutrecursion();
        int[] arr2 = po.postorderTraversal(root);
        for (int k : arr2) {
            System.out.print(k + " ");
        }*/
        System.out.println(i.solve(root));

    }

}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) {
      val = x;
      left=null;
      right=null;
     }
 }