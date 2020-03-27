package TreeAlgo;

public class Sniffer {
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

        TreeTraversals_recursive obj1 = new TreeTraversals_recursive();
        TreeTraversals_iterative obj2 = new TreeTraversals_iterative();
        System.out.println("In order " + obj1.inOrder(root));
        System.out.println(obj1.inOrder(root).equals(obj2.inOrder(root)));
        System.out.println("Pre order " + obj1.preOrder(root));
        System.out.println(obj1.preOrder(root).equals(obj2.preOrder(root)));
        System.out.println("Post order " + obj1.postOrder(root));
        System.out.println(obj1.postOrder(root).equals(obj2.postOrder(root)));
    }
}
