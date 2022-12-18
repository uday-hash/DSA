/*
 * Problem Description
Given an array where elements are sorted in ascending order, convert it to a height Balanced Binary Search Tree (BBST).

Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.



Problem Constraints
1 <= length of array <= 100000
 */

package BST;

public class Sorted_array_to_balanced_BST {
    public TreeNode sortedArrayToBST(final int[] A) {
        return solve(A, 0, A.length - 1);
    }

    public TreeNode solve(int[] A, int start, int end) {
        if(start > end)
            return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(A[mid]);
        root.left = solve(A, start, mid - 1);
        root.right = solve(A, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        Sorted_array_to_balanced_BST s = new Sorted_array_to_balanced_BST();
        int[] A = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = s.sortedArrayToBST(A);
        System.out.println(root.val);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; 
    left=null;
    right=null;
    }
}
