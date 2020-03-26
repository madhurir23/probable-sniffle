package TreeAlgo;

import java.util.Stack;

public class TreeTraversals_iterative {
    private void postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> values = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            values.push(stack.peek().data);
            TreeNode node = stack.pop();

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        while (!values.isEmpty()) {
            System.out.print(values.pop() + "  ");
        }
    }

    private void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                System.out.print(root.data + "  ");
                stack.push(root);
                root = root.left;
            }
            root = stack.pop().right;
        }
    }

    // Useful in solving problems like
    // https://leetcode.com/problems/validate-binary-search-tree
    private void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode cur = stack.pop();
            System.out.print(cur.data + "  ");
            root = cur.right;
        }
    }

    public static void main(String[] args) {
        // Create a tree
        //                     40
        //                   /    \
        //                 20     50
        //               /   \      \
        //             10    30     60
        //            /
        //          5
        TreeNode root = new TreeNode(40);
        TreeNode node20 = root.addLeftChild(20);
        TreeNode node50 = root.addRightChild(50);
        TreeNode node10 = node20.addLeftChild(10);
        node20.addRightChild(30);
        node10.addLeftChild(5);
        node50.addRightChild(60);

        TreeTraversals_iterative obj = new TreeTraversals_iterative();
        System.out.println("In order");
        obj.inOrder(root);
        System.out.println();
        System.out.println("Pre order");
        obj.preOrder(root);
        System.out.println();
        System.out.println("Post order");
        obj.postOrder(root);
    }
}
