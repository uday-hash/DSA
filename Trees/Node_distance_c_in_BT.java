/*
 * Given a binary tree of integers. All nodes in the binary tree have distinct values. You are given an integer B.

You have to find all the nodes that are at a distance of exactly C from the node containing value B.

Return an array of integers consisting all the nodes that are C distance from node containing value B.

Note:

You may return the nodes in any order.

Your solution will run on multiple test cases, if you are using global variables make sure to clear every time .

Constraints

1 <= Number of nodes in binary tree <= 100000
0 <= Node values <= 10^9 
0 <= B <= 10^9
0 <= C <= 100
 */
package Trees;

import java.util.ArrayList;

public class Node_distance_c_in_BT {
    public ArrayList<Integer> solve(TreeNode A, int B, int C) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(A == null)
            return ans;
        if(C == 0) {
            ans.add(B);
            return ans;
        }
        TreeNode node = findNode(A, B);
        if(node == null)
            return ans;
        findNodesAtC(node, C, ans);
        return ans;
    }

    public TreeNode findNode(TreeNode A, int B) {
        if(A == null)
            return null;
        if(A.val == B)
            return A;
        TreeNode left = findNode(A.left, B);
        if(left != null)
            return left;
        return findNode(A.right, B);
    }

    public void findNodesAtC(TreeNode A, int C, ArrayList<Integer> ans) {
        if(A == null)
            return;
        if(C == 0) {
            ans.add(A.val);
            return;
        }
        findNodesAtC(A.left, C - 1, ans);
        findNodesAtC(A.right, C - 1, ans);
    }

    public static void main(String[] args) {
        Node_distance_c_in_BT n = new Node_distance_c_in_BT();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(70);
        root.left.left.left = new TreeNode(80);
        root.left.left.right = new TreeNode(90);
        root.left.right.left = new TreeNode(100);
        root.left.right.right = new TreeNode(110);
        root.right.left.left = new TreeNode(120);
        root.right.left.right = new TreeNode(130);
        root.right.right.left = new TreeNode(140);
        root.right.right.right = new TreeNode(150);
        System.out.println(n.solve(root, 40, 2));
    }
}
        
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