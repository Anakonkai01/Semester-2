package Lab6.Exercise8;

import Lab6.implementBST.TreeNode;

import static Lab6.Exercise2.Main.createTree;

public class Exercise8 {
    public static Integer sum(TreeNode root){
        if(root == null) return 0;
        return root.getVal() + sum(root.getLeft()) + sum(root.getRight());
    }

    public static void main(String[] args) {
        TreeNode root = createTree("1 2 3 4 5 6 7 8 9 10");
        System.out.println(sum(root));
    }
}
