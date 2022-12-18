/*
 * Problem Description

Given a Binary Search Tree rooted at A.

Given an integer array B of size N. Find the floor and ceil of every element of the array B.

Floor(X) is the highest element in the tree <= X, while the ceil(X) is the lowest element in the tree >= X.

NOTE: If floor or ceil of any element of B doesn't exists, output -1 for the value which doesn't exists.



Problem Constraints

0 <= Number of nodes in the tree <= 1000000
0 <= node values <= 109
0 <= N <= 100000
0 <= B[i] <= 109
 */
package BST;

import java.util.ArrayList;

public class Floor_and_ceil_in_BST {
    public ArrayList<ArrayList<Integer>> solve(TreeNode A, ArrayList<Integer> B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < B.size(); i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(floor(A, B.get(i)));
            temp.add(ceil(A, B.get(i)));
            ans.add(temp);
        }
        return ans;
    }

    public int floor(TreeNode A, int key) {
        if(A == null)
            return -1;
        if(A.val == key)
            return A.val;
        if(A.val > key)
            return floor(A.left, key);
        int floor = floor(A.right, key);
        if(floor == -1)
            return A.val;
        return floor;
    }

    public int ceil(TreeNode A, int key) {
        if(A == null)
            return -1;
        if(A.val == key)
            return A.val;
        if(A.val < key)
            return ceil(A.right, key);
        int ceil = ceil(A.left, key);
        if(ceil == -1)
            return A.val;
        return ceil;
    }

    public static void main(String[] args) {
        Floor_and_ceil_in_BST f = new Floor_and_ceil_in_BST();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(18);
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(5);
        arr.add(10);
        arr.add(15);
        arr.add(20);
        System.out.println(f.solve(root, arr));
    }

}
