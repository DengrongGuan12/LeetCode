package UniqueBinarySearchTrees;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by dengrong on 2016/10/31.
 */
public class Trees2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Trees2 trees2 = new Trees2();
        List<TreeNode> treeNodes = trees2.generateTrees(n);
        for (TreeNode treeNode:treeNodes) {
            trees2.printTree(treeNode);
        }
    }

    public void printTree(TreeNode node){
        System.out.println(node.val);
        if(node.left != null){
            System.out.print(node.left.val+" ");
        }else{
            System.out.print("  ");
        }
        if(node.right != null){
            System.out.println(node.right.val);
        }else{
            System.out.println(" ");
        }
    }

    public List<TreeNode> generateTrees(int n){
        int from = 1;
        int to = n;
        return genTree(from,to);
    }

    public List<TreeNode> genTree(int from,int to){
        List<TreeNode> treeNodeList = new ArrayList<TreeNode>();
        for(int i=from;i<=to;i++){
            int leftFrom = from;
            int leftTo = i-1;
            List<TreeNode> leftNodes = new ArrayList<TreeNode>();
            if(leftFrom < leftTo){
                leftNodes = genTree(leftFrom,leftTo);
            }
            int rightFrom = i+1;
            int rightTo = to;
            List<TreeNode> rightNodes = new ArrayList<TreeNode>();
            if(rightFrom < rightTo){
                rightNodes = genTree(rightFrom,rightTo);
            }
            if(leftNodes.size() == 0 && rightNodes.size() == 0){
                TreeNode treeNode = new TreeNode(i);
                treeNodeList.add(treeNode);
            }else if(leftNodes.size() == 0){
                for (TreeNode rightNode:rightNodes) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.right = rightNode;
                    treeNodeList.add(treeNode);
                }
            }else if(rightNodes.size() == 0){
                for (TreeNode left:leftNodes) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = left;
                    treeNodeList.add(treeNode);
                }
            }else{
                for (TreeNode leftNode:leftNodes) {
                    for (TreeNode rightNode:rightNodes) {
                        TreeNode treeNode = new TreeNode(i);
                        treeNode.left = leftNode;
                        treeNode.right = rightNode;
                        treeNodeList.add(treeNode);
                    }
                }
            }
        }
        return treeNodeList;
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
}
