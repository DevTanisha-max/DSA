class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {

        // Key not found / tree is empty
        if (root == null) {
            return null;
        }

        // Search in left subtree
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }

        // Search in right subtree
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }

        // Node found
        else {

            // No child
            if (root.left == null && root.right == null) {
                return null;
            }

            // Only right child
            if (root.left == null) {
                return root.right;
            }

            // Only left child
            if (root.right == null) {
                return root.left;
            }

            // Two children
            TreeNode successor = root.right;

            // Find inorder successor
            while (successor.left != null) {
                successor = successor.left;
            }

            // Copy successor's value
            root.val = successor.val;

            // Delete original successor
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }
}