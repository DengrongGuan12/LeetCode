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
     public int rob(TreeNode root) {
         int rootSum = sum(root,0);
         TreeNode right = root.right;
         TreeNode left = root.left;
         int sonSum = sum(right,right.val)+sum(left,left.val);
         return Math.max(rootSum,sonSum);
     }
    public int sum(TreeNode root,int sum){
        ArrayList<TreeNode> nodes = getGroundSunNodes(root);
        if(nodes.size() == 0){
            return sum;
        }else{
            for(TreeNode node:nodes){
                sum += node.val;
                sum(node,sum);
            }
            return sum;
        }
    }
     public ArrayList<TreeNode> getGroundSunNodes(TreeNode root){
         ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
         if(root != null){
             TreeNode right = root.right;
             TreeNode left = root.left;
             if(right != null){
                 if(right.right != null){
                     nodes.add(right.right);
                 }
                 if(right.left != null){
                     nodes.add(right.left);
                 }
             }
             if(left != null){
                 if(left.right != null){
                     nodes.add(left.right);
                 }
                 if(left.left !=null){
                     nodes.add(left.left);
                 }
             }
         }
         return nodes;
     }
}
