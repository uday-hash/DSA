/*
 * Problem Description
Find the lowest common ancestor in an unordered binary tree A, given two values, B and C, in the tree.

Lowest common ancestor: the lowest common ancestor (LCA) of two nodes and w in a tree or directed acyclic graph (DAG) is the lowest (i.e., deepest) node that has both v and w as descendants.



Problem Constraints
1 <= size of tree <= 100000

1 <= B, C <= 109
 */
package BST;

public class Least_common_ancestor {
    public int lca(TreeNode A, int B, int C) {
        if (A == null)
            return -1;
        if (A.val == B || A.val == C)
            return A.val;
        int left = lca(A.left, B, C);
        int right = lca(A.right, B, C);
        if (left != -1 && right != -1)
            return A.val;
        if (left != -1)
            return left;
        return right;

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}