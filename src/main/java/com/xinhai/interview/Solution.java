package com.xinhai.interview;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by dengrongguan on 2017/3/14.
 */
public class Solution {
    public boolean isSymmetric(TreeNode root){
        if(root == null){
            return true;
        }else{
            return dfs(root.left,root.right);
        }
    }
    private boolean dfs(TreeNode l,TreeNode r){
        if(l == null && r == null){
            return true;
        }
        if(l == null && r !=null){
            return false;
        }
        if(l != null && r == null){
            return false;
        }
        if(l.val != r.val){
            return false;
        }
        if(dfs(l.left,r.right) && dfs(l.right,r.left)){
            return true;
        }
        return false;

    }
    public static void main(String[] args){
        Integer a[] = {1,2,2,3,4,4,3};
        Queue<TreeNode> treeNodes = new ConcurrentLinkedQueue<TreeNode>();
        TreeNode treeNode = new TreeNode(a[0]);
        treeNodes.add(treeNode);
        int i = 0;
        while(!treeNodes.isEmpty()){
            TreeNode treeNode1 = treeNodes.poll();
            i++;
            if(i<a.length){
                if(a[i] != null){
                    treeNode1.left = new TreeNode(a[i]);
                    treeNodes.add(treeNode1.left);
                }else{
                    treeNode1.left = null;
                }
            }else{
                break;
            }
            i++;
            if(i < a.length){
                if(a[i] != null){
                    treeNode1.right = new TreeNode(a[i]);
                    treeNodes.add(treeNode1.right);
                }else{
                    treeNode1.right = null;
                }

            }else{
                break;
            }
        }

        Solution solution = new Solution();
//        solution.bfs(treeNode);
        System.out.println(solution.isSymmetric(treeNode));
    }
    public void bfs(TreeNode treeNode){
        Queue<TreeNode> treeNodes = new ConcurrentLinkedQueue<TreeNode>();
        treeNodes.add(treeNode);
        while(!treeNodes.isEmpty()){
            TreeNode treeNode1 = treeNodes.poll();
            if(treeNode1 != null){
                System.out.print(treeNode1.val+" ");
                if(treeNode1.left != null){
                    treeNodes.add(treeNode1.left);
                }
                if(treeNode1.right != null){
                    treeNodes.add(treeNode1.right);
                }

            }
        }
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
