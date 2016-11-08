import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created by DengrongGuan on 2016/11/3.
 */
public class ZigzagLevelOrderTree {
    public static void main(String[] args){

    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int num;
        boolean reverse = false;
        while (!queue.isEmpty()) {
            num = queue.size();//跟普通的广度优先遍历不同
            tmp.clear();
            for (int i = 0; i < num; i++) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            if (reverse) {
                Collections.reverse(tmp);
                reverse = false;
            }
            else
                reverse = true;
            res.add(new ArrayList<Integer>(tmp));
        }
        return res;
    }
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
}
