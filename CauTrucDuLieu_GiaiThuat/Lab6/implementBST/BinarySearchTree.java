package Lab6.implementBST;

import com.sun.source.tree.Tree;

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


    public static TreeNode min(TreeNode root){
        if(root.getLeft() == null) return root;
        return min(root.getLeft());
    }

    public static TreeNode max(TreeNode root){
        if(root.getRight() == null) return root;
        return max(root.getRight());
    }

    
}
