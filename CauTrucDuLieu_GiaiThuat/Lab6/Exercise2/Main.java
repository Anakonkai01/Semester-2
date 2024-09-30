package Lab6.Exercise2;


import Lab6.implementBST.BinarySearchTree;
import Lab6.implementBST.TreeNode;

public class Main {
    public static TreeNode createTree(String str) {

    String[] tokens = str.split("\\s+");

    TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));

    for (int i = 1; i < tokens.length; i++) {
        int value = Integer.parseInt(tokens[i]);
        root = BinarySearchTree.insert(root, value);
    }

    return root;
}



    public static void main(String[] args) {
        TreeNode root = createTree("1 2 3");
        BinarySearchTree.print_levelOrder(root);
    }
}
