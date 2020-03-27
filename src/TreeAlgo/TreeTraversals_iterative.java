package TreeAlgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class TreeTraversals_iterative {
    public List<Integer> postOrder(TreeNode root) {
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

        ArrayList<Integer> res = new ArrayList<>(values);
        Collections.reverse(res);
        return res;
    }

    public List<Integer> preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.data);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop().right;
        }
        return res;
    }

    // Useful in solving problems like
    // https://leetcode.com/problems/validate-binary-search-tree
    public List<Integer> inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode cur = stack.pop();
            res.add(cur.data);
            root = cur.right;
        }
        return res;
    }
}
