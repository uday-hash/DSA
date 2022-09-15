/*
 * Problem Description
Given a binary tree, return the Postorder traversal of its nodes values.

NOTE: Using recursion is not allowed.



Problem Constraints
1 <= number of nodes <= 105
 */

package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Postorder_traversal {
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
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
        Collections.reverse(list);
        return list;
    }
    public static void main(String[] args) {
        Postorder_traversal obj = new Postorder_traversal();
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);
        A.left.left = new TreeNode(4);
        A.left.right = new TreeNode(5);
        A.right.left = new TreeNode(6);
        A.right.right = new TreeNode(7);
        System.out.println(obj.postorderTraversal(A));
    }
    
}
