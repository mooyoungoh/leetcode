class Solution {
    // Hash Set to store node value of the rightmost branch
    Set<Integer> visited = new HashSet<>();

    // Do Reverse Postorder Traversal. Assume input "root" as recursive parameter "node"
    public TreeNode correctBinaryTree(TreeNode root) {
        // If Empty Node, return
        if (root == null) {
            return null;
        }

        // If node.right is already visited, then the node is defective
        // No need to build tree rooted at "node". Replace it with null
        if (root.right != null && visited.contains(root.right.val)) {
            return null;
        }

        // Add this node's value to the visited
        visited.add(root.val);

        // Recursively build tree rooted at "node"
        // Build right subtree first, so that we can explore right to left
        root.right = correctBinaryTree(root.right);
        root.left = correctBinaryTree(root.left);

        // Return root of built tree
        return root;       
    }
}