/*
 * Problem Description
Given preorder and inorder traversal of a tree, construct the binary tree.

NOTE: You may assume that duplicates do not exist in the tree.


Problem Constraints
1 <= number of nodes <= 105



 */

package Trees;

import java.util.ArrayList;

public class Binary_tree_from_inorder_and_preorder {
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        return buildTree(A, B, 0, A.size() - 1, 0, B.size() - 1);
    }
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B, int preStart, int preEnd, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd)
            return null;
        int rootVal = A.get(preStart);
        int rootIndex = -1;
        for(int i = inStart; i <= inEnd; i++) {
            if(B.get(i) == rootVal) {
                rootIndex = i;
                break;
            }
        }
        int leftTreeSize = rootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(A, B, preStart + 1, preStart + leftTreeSize, inStart, rootIndex - 1);
        root.right = buildTree(A, B, preStart + leftTreeSize + 1, preEnd, rootIndex + 1, inEnd);
        return root;
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
