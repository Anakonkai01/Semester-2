package Lab6.implementBST;


public class Main {
    

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        for(int i = 0; i < 14; i++){
            root = BinaryTree.insert_Level_Order(root,i);
        }
        BinaryTree.print_Level_Order(root);
        root = BinarySearchTree.reverseTree_levelOrder(root);
        BinaryTree.print_Level_Order(root);
    }
}
