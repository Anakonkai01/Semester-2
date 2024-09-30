package Lab6.Exercise3;

import Lab6.implementBST.BinarySearchTree;
import Lab6.implementBST.TreeNode;
import Lab6.Exercise2.Main.*;

import static Lab6.Exercise2.Main.createTree;

public class Exercise3 {
    public static void print_descending_order(TreeNode root){
        if(root == null) return;
        print_descending_order(root.getRight());
        print_descending_order(root.getLeft());
        System.out.println(root.getVal());
    }

    public static void main(String[] args) {
        TreeNode root = createTree("1 2 3 4 5 6 7");
        print_descending_order(root);
    }
}
