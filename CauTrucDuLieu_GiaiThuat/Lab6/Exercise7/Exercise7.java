package Lab6.Exercise7;

import Lab6.implementBST.TreeNode;

import static Lab6.Exercise2.Main.createTree;

public class Exercise7 {


    // root -> left -> right
    public static int maxHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int heightLeft = 1 + maxHeight(root.getLeft());
        int heightRight = 1 + maxHeight(root.getRight());
        return Math.max(heightLeft,heightRight);
    }

    public static void main(String[] args) {
        TreeNode root = createTree("4 2 1 3 6 5 7");
        System.out.println(maxHeight(root));
    }
}
