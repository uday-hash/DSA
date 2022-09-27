/*
 * Problem Description
Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.


NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.



Problem Constraints
0 <= number of nodes <= 105
 */

package Trees.Advance_tress;

import java.util.ArrayList;

public class Vertical_order_traversal{
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        
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