package Lab6.Exercise4;

import Lab6.implementBST.TreeNode;

import static Lab6.Exercise2.Main.createTree;

public class Exercise4 {
    public static boolean contains(TreeNode root, int val){
        if(root == null) return false;
        return root.getVal() == val || contains(root.getLeft(), val) || contains(root.getRight(), val);
    }

    public static void main(String[] args) {
        TreeNode root = createTree("1 2 3");
        System.out.println(contains(root, 1));
    }
}
