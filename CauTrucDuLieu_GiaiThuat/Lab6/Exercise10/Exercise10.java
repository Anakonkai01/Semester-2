package Lab6.Exercise10;

import Lab6.implementBST.TreeNode;

import static Lab6.Exercise2.Main.createTree;

public class Exercise10 {
    public static int countLeaves(TreeNode root) {
        if(root == null) return 0;
        if (root.getLeft() == null && root.getRight() == null) return 1;
        return countLeaves(root.getLeft()) + countLeaves(root.getRight());
    }

    public static void main(String[] args) {
        TreeNode root = createTree("4 2 1 3 6");
        System.out.println(countLeaves(root));
    }
}
