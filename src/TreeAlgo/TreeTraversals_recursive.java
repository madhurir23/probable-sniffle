package TreeAlgo;

import java.util.LinkedList;
import java.util.List;

public class TreeTraversals_recursive {
    public List<Integer> inOrder(TreeNode treeNode) {
        List<Integer> res = new LinkedList<>();
        inOrderHelper(treeNode, res);
        return res;
    }
    private void inOrderHelper(TreeNode treeNode, List<Integer> res) {
        if (treeNode == null) return;
        inOrderHelper(treeNode.left, res);
        res.add(treeNode.data);
        inOrderHelper(treeNode.right, res);
    }

    public List<Integer> preOrder(TreeNode treeNode) {
        List<Integer> res = new LinkedList<>();
        preOrderHelper(treeNode, res);
        return res;
    }

    private void preOrderHelper(TreeNode treeNode, List<Integer> res) {
        if (treeNode == null) return;
        res.add(treeNode.data);
        preOrderHelper(treeNode.left, res);
        preOrderHelper(treeNode.right, res);
    }

    public List<Integer> postOrder(TreeNode treeNode) {
        List<Integer> res = new LinkedList<>();
        postOrderHelper(treeNode, res);
        return res;
    }

    private void postOrderHelper(TreeNode treeNode, List<Integer> res) {
        if (treeNode == null) return;
        postOrderHelper(treeNode.left, res);
        postOrderHelper(treeNode.right, res);
        res.add(treeNode.data);
    }
}
