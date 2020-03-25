package TreeAlgo;

public class TreeTraversals_iterative {
    private void postOrder(TreeNode root) {

    }

    private void preOrder(TreeNode root) {

    }

    private void inOrder(TreeNode root) {

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
