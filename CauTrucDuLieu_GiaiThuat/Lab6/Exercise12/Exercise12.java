package Lab6.Exercise12;

import Lab6.implementBST.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Exercise12 {
    public void bfs(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            System.out.println(node.getVal() + " ");
            if (node.getLeft() != null) q.add(node.getLeft());
            if (node.getRight() != null) q.add(node.getRight());
        }
    }
}
