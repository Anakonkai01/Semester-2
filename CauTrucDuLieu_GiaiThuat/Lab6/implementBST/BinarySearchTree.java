package Lab6.implementBST;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
//    private TreeNode root;

    public static TreeNode insert(TreeNode root,int val){
        if(root == null){
            return new TreeNode(val);
        }
        if(root.getVal() == val){
            return root;
        }
        if(root.getVal() > val){
            root.setLeft(insert(root.getLeft(),val));
        }
        else{
            root.setRight(insert(root.getRight(),val));
        }
        return root;
    }

    public static TreeNode search(TreeNode root, int val){
        if(root == null || root.getVal() == val) return root;
        if(root.getVal() < val){
            return search(root.getRight(),val);
        }
        return search(root.getLeft(),val);
    }

    public static TreeNode deleteNode(TreeNode root, int val){
        if(root == null) return root;

         //find the subtree

        if(root.getVal() < val){
            root.setRight(deleteNode(root.getRight(),val));
        } else if (root.getVal() > val) {
            root.setLeft(deleteNode(root.getLeft(),val));
        }
        else{
            // when node is 0 child or 1 child left
            if(root.getLeft() == null){
                return root.getRight();
            }

            // node is 1 child right
            if(root.getRight() == null){
                return root.getLeft();
            }

            // have both children
            TreeNode successor = getSuccessor_RightSubTree(root);
            root.setVal(successor.getVal());
            root.setRight(deleteNode(root.getRight(), successor.getVal()));
        }
        return root;
    }

    public static TreeNode getSuccessor_RightSubTree(TreeNode curr){
        curr = curr.getRight();
        while(curr != null && curr.getLeft() != null){
            curr = curr.getLeft();
        }
        return curr;
    }

    public static TreeNode deleteMin(TreeNode curr){
        if(curr.getLeft() == null) return curr.getRight();
        return deleteMin(curr.getLeft());
    }


    public static TreeNode min(TreeNode root){
        if(root.getLeft() == null) return root;
        return min(root.getLeft());
    }

    public static TreeNode max(TreeNode root){
        if(root.getRight() == null) return root;
        return max(root.getRight());
    }

    public static void print_levelOrder(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            System.out.print(curr.getVal() + " ");
            if(curr.getLeft() != null) queue.add(curr.getLeft());
            if(curr.getRight() != null) queue.add(curr.getRight());
        }
    }


    // DFS in-order, pre-order, post-order
    // left -> root -> right
    // root -> left -> right
    // left -> right -> root

    public static void inOrder_Traversal(TreeNode root){
        if(root == null) return;
        
        inOrder_Traversal(root.getLeft());
        System.out.print(root.getVal()+" ");
        inOrder_Traversal(root.getRight());
    }


    public static void preOrder_Traversal(TreeNode root){
        if(root == null) return;

        System.out.print(root.getVal()+" ");
        preOrder_Traversal(root.getLeft());
        preOrder_Traversal(root.getRight());
    }


    public static void postOrder_Traverval(TreeNode root){
        if(root == null) return;

        postOrder_Traverval(root.getLeft());
        postOrder_Traverval(root.getRight());
        System.out.print(root.getVal() + " ");
    }

    public static TreeNode reverseTree_postOrder(TreeNode root){
        if(root == null) return null;
        TreeNode newNode = new TreeNode(root.getVal());

        newNode.setRight(reverseTree_postOrder(root.getLeft()));
        newNode.setLeft(reverseTree_postOrder(root.getRight())); 
        return newNode;
    }

    public static TreeNode reverseTree_levelOrder(TreeNode root){
        if(root == null) return root;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();

            //swap
            TreeNode temp = node.getLeft();
            node.setLeft(node.getRight());
            node.setRight(temp);

            if(node.getLeft() != null) q.add(node.getLeft());
            if(node.getRight() != null) q.add(node.getRight()); 
        }

        return root;
    }
}
