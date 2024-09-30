package Lab6.Exercise9;

import Lab6.implementBST.TreeNode;

import static Lab6.Exercise2.Main.createTree;

public class Exercise9 {
    public static Integer sumEven(TreeNode root){
        if(root == null) return 0;
        if(root.getVal() % 2 == 0){
            return root.getVal() + sumEven(root.getLeft()) + sumEven(root.getRight());
        }
        return sumEven(root.getLeft()) + sumEven(root.getRight());
    }

    public static void main(String[] args) {
        TreeNode root = createTree("1 2 3 4 6 7");
        System.out.println(sumEven(root));
    }
}
