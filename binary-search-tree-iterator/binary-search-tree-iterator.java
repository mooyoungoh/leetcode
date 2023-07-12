/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 public class BSTIterator {

    Stack<TreeNode> stack;
    TreeNode node;
    public BSTIterator(TreeNode root) {
        stack = new Stack();
        node = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() || node != null;
    }

    /** @return the next smallest number */
    public int next() {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        node = stack.pop();
        int res = node.val;
        node = node.right;
        return res;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */