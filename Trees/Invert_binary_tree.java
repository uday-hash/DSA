/*Problem Description
Given a binary tree A, invert the binary tree and return it.

Inverting refers to making the left child the right child and vice versa.



Problem Constraints
1 <= size of tree <= 100000 */ 

package Trees;

public class Invert_binary_tree {
    public TreeNode invertTree(TreeNode A) {
        if (A == null) {
            return null;
        }
        TreeNode temp = A.left;
        A.left = A.right;
        A.right = temp;
        invertTree(A.left);
        invertTree(A.right);
        return A;
        
    }
    public static void main(String[] args) {
        Invert_binary_tree obj = new Invert_binary_tree();
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);
        A.left.left = new TreeNode(4);
        A.left.right = new TreeNode(5);
        A.right.left = new TreeNode(6);
        A.right.right = new TreeNode(7);
        TreeNode B = obj.invertTree(A);
        System.out.println(B.val);
        System.out.println(B.left.val);
        System.out.println(B.right.val);
        System.out.println(B.left.left.val);
        System.out.println(B.left.right.val);
        System.out.println(B.right.left.val);
        System.out.println(B.right.right.val);
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
  
