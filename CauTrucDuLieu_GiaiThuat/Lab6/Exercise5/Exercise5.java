package Lab6.Exercise5;


import Lab6.implementBST.BinarySearchTree;
import Lab6.implementBST.TreeNode;


import static Lab6.Exercise2.Main.createTree;

public class Exercise5 {
    public static TreeNode deleteMax(TreeNode root) {
        if(root.getRight() == null){
            return root.getLeft();
        }
        root.setRight(deleteMax(root.getRight()));
        return root;
    }



    public static void main(String[] args) {
        TreeNode root = createTree("1 2 3 4 5 6 7");
        BinarySearchTree.print_levelOrder(root);
        deleteMax(root);
        System.out.println();
        BinarySearchTree.print_levelOrder(root);
    }
}
