package BST;

import java.util.ArrayList;

public class Recover_Binary_Search_Tree {
    public ArrayList<Integer> recoverTree(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode first = null, second = null, prev = null;
        while (A != null) {
            if (A.left == null) {
                if (prev != null && prev.val > A.val) {
                    if (first == null)
                        first = prev;
                    second = A;
                }
                prev = A;
                A = A.right;
            } else {
                TreeNode temp = A.left;
                while (temp.right != null && temp.right != A)
                    temp = temp.right;
                if (temp.right == null) {
                    temp.right = A;
                    A = A.left;
                } else {
                    temp.right = null;
                    if (prev != null && prev.val > A.val) {
                        if (first == null)
                            first = prev;
                        second = A;
                    }
                    prev = A;
                    A = A.right;
                }
            }
        }
        result.add(first.val);
        result.add(second.val);
        return result;
    }
}
