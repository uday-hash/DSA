package BST;

public class Kth_smallest_element_in_BST{
    public int kthsmallest(TreeNode A, int B) {
        int[] count = new int[1];
        int[] result = new int[1];
        inorder(A, B, count, result);
        return result[0];
    }
    
    private void inorder(TreeNode root, int k, int[] count, int[] result) {
        if (root == null) {
            return;
        }
        inorder(root.left, k, count, result);
        count[0]++;
        if (count[0] == k) {
            result[0] = root.val;
            return;
        }
        inorder(root.right, k, count, result);
    }
    public static void main(String[] args) {
        Kth_smallest_element_in_BST obj = new Kth_smallest_element_in_BST();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(obj.kthsmallest(root, 2));
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