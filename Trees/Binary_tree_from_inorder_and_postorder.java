/*
 * Problem Description
Given the inorder and postorder traversal of a tree, construct the binary tree.

NOTE: You may assume that duplicates do not exist in the tree.


Problem Constraints
1 <= number of nodes <= 105
 */

package Trees;

import java.util.ArrayList;

public class Binary_tree_from_inorder_and_postorder {
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        if(A.size()==0)
            return null;
        return build(A,B,0,A.size()-1,0,B.size()-1);

    }
    public TreeNode build(ArrayList<Integer> A, ArrayList<Integer> B,int inStart,int inEnd,int postStart,int postEnd){
        if(inStart>inEnd || postStart>postEnd)
            return null;
        int rootVal=B.get(postEnd);
        TreeNode root=new TreeNode(rootVal);
        int k=0;
        for(int i=inStart;i<=inEnd;i++){
            if(A.get(i)==rootVal){
                k=i;
                break;
            }
        }
        root.left=build(A,B,inStart,k-1,postStart,postStart+k-(inStart+1));
        root.right=build(A,B,k+1,inEnd,postStart+k-inStart,postEnd-1);
        return root;
    }
    
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}