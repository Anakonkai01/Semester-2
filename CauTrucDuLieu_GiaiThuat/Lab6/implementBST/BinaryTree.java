package Lab6.implementBST;


import java.util.*;

public class BinaryTree {
    public static TreeNode insert_Level_Order(TreeNode root, int val){
        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.offer(root);
        
        while(!myQueue.isEmpty()){
            TreeNode q = myQueue.poll();
            if(q.getLeft() != null){
                myQueue.offer(q.getLeft());
            }
            else
            {
                q.setLeft(new TreeNode(val));
                break;
            }
            if(q.getRight() != null){
                myQueue.offer(q.getRight());
            } 
            else{
                q.setRight(new TreeNode(val));
                break;
            }
        }
        return root;
    }

    public static void print_Level_Order(TreeNode root){
        if (root == null) return; // Nếu cây rỗng thì không làm gì

    Queue<TreeNode> myQueue = new LinkedList<>();
    myQueue.offer(root);    

    while (!myQueue.isEmpty()) {
        int levelSize = myQueue.size();  // Số lượng node trong tầng hiện tại
        
        // Duyệt qua tất cả các node trong tầng hiện tại
        for (int i = 0; i < levelSize; i++) {
            TreeNode q = myQueue.poll();
            System.out.print(q.getVal() + " ");
            
            // Thêm các con của node hiện tại vào hàng đợi
            if (q.getLeft() != null) myQueue.offer(q.getLeft());
            if (q.getRight() != null) myQueue.offer(q.getRight());
        }
        System.out.println();
    }
    }



    public static void print_Level_Order__d(TreeNode root){
        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.offer(root);
        
        while(!myQueue.isEmpty()){
            TreeNode q = myQueue.poll();
            System.out.print(q.getVal()+ " ");
            if(q.getLeft() != null) myQueue.offer(q.getLeft());
            if(q.getRight() != null) myQueue.offer(q.getRight());
        }
    }
}
