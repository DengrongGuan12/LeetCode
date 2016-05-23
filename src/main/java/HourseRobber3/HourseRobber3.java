package HourseRobber3; /**
 * Created by DengrongGuan on 2016/4/30.
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area,
 * called the "root." Besides the root, each house has one and only one parent house. After a tour,
 * the smart thief realized that "all houses in this place forms a binary tree".
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.

 Determine the maximum amount of money the thief can rob tonight without alerting the police.

 Example 1:

 3
 / \
 2   3
 \   \
 3   1

 Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

 Example 2:

 3
 / \
 4   5
 / \   \
 1   3   1

 Maximum amount of money the thief can rob = 4 + 5 = 9.
*/

import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class HourseRobber3 {
    public static void main(String[] args){
        HourseRobber3 hourseRobber3 = new HourseRobber3();
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        TreeNode r2 = new TreeNode(3);
        TreeNode r3 = new TreeNode(1);
        l1.left = null;
        l1.right = r2;
        r1.left = null;
        r1.right = r3;
        root.left = l1;
        root.right = r1;
        System.out.println(hourseRobber3.rob(root));
    }
     public int rob(TreeNode root) {
         int child = 0, childchild = 0;
         int[] childs = {child,childchild};
         rob(root, childs);
         return Math.max(childs[0], childs[1]);
     }
    public void rob(TreeNode root,int[] childs){
        if(root == null){
            return;
        }
        int l1 = 0, l2 = 0, r1 = 0, r2 = 0;
        int[] l = {l1,l2};
        int[] r = {r1,r2};
        rob(root.left,l);
        rob(root.right,r);

        //rob the node root
        childs[0] = l[1] + r[1] + root.val;
        //no rob the node root
        childs[1] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
    }
}
