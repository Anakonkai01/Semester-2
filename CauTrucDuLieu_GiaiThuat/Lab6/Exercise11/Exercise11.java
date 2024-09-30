package Lab6.Exercise11;

import Lab6.implementBST.TreeNode;

import static Lab6.Exercise2.Main.createTree;

public class Exercise11 {
    public static int sumEvenKeysAtLeaves(TreeNode root) {
        if(root == null) return 0;
        if(root.getLeft() == null && root.getRight() == null && root.getVal() % 2 == 0) return root.getVal();
        return sumEvenKeysAtLeaves(root.getLeft()) + sumEvenKeysAtLeaves(root.getRight());
    }

    public static void main(String[] args) {
        TreeNode root = createTree("4 2 1 3 6 5 8");
        System.out.println(sumEvenKeysAtLeaves(root));
    }
}
