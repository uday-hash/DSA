/*
 * Problem Description
Given a binary search tree.
Return the distance between two nodes with given two keys B and C. It may be assumed that both keys exist in BST.

NOTE: Distance between two nodes is number of edges between them.



Problem Constraints
1 <= Number of nodes in binary tree <= 1000000

0 <= node values <= 109
 */
package BST;

public class Distance_between_nodes_of_BST {
    public int solve(TreeNode A, int B, int C) {
        TreeNode lca = lca(A, B, C);
        return distance(lca, B) + distance(lca, C);
    }

    public TreeNode lca(TreeNode A, int B, int C) {
        if(A == null)
            return null;
        if(A.val == B || A.val == C)
            return A;
        TreeNode left = lca(A.left, B, C);
        TreeNode right = lca(A.right, B, C);
        if(left != null && right != null)
            return A;
        if(left != null)
            return left;
        return right;
    }

    public int distance(TreeNode A, int B) {
        if(A == null)
            return -1;
        if(A.val == B)
            return 0;
        if(A.val > B)
            return 1 + distance(A.left, B);
        return 1 + distance(A.right, B);
    }

    public static void main(String[] args) {
        Distance_between_nodes_of_BST d = new Distance_between_nodes_of_BST();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(18);
        System.out.println(d.solve(root, 2, 18));
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