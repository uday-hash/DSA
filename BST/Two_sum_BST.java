/*
 * Problem Description
Given a binary search tree A, where each node contains a positive integer, and an integer B, you have to find whether or not there exist two different nodes X and Y such that X.value + Y.value = B.

Return 1 to denote that two such nodes exist. Return 0, otherwise.



Problem Constraints
1 <= size of tree <= 100000

1 <= B <= 109
 */
package BST;

public class Two_sum_BST {
    public int t2Sum(TreeNode A, int B) {
        if(A == null)
            return 0;
        TreeNode left = A, right = A;
        while(left.left != null)
            left = left.left;
        while(right.right != null)
            right = right.right;
        while(left != right) {
            int sum = left.val + right.val;
            if(sum == B)
                return 1;
            if(sum < B)
                left = inorderSuccessor(A, left);
            else
                right = inorderPredecessor(A, right);
        }
        return 0;
    }

    public TreeNode inorderSuccessor(TreeNode A, TreeNode B) {
        if(B.right != null) {
            B = B.right;
            while(B.left != null)
                B = B.left;
            return B;
        }
        TreeNode succ = null;
        while(A != null) {
            if(B.val < A.val) {
                succ = A;
                A = A.left;
            }
            else if(B.val > A.val)
                A = A.right;
            else
                break;
        }
        return succ;
    }

    public TreeNode inorderPredecessor(TreeNode A, TreeNode B) {
        if(B.left != null) {
            B = B.left;
            while(B.right != null)
                B = B.right;
            return B;
        }
        TreeNode pred = null;
        while(A != null) {
            if(B.val < A.val)
                A = A.left;
            else if(B.val > A.val) {
                pred = A;
                A = A.right;
            }
            else
                break;
        }
        return pred;
    }

    public static void main(String[] args) {
        Two_sum_BST t = new Two_sum_BST();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(18);
        System.out.println(t.t2Sum(root, 20));
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