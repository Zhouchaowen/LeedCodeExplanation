package com.zz.PlayLifeCode.week19;

/**
 * https://leetcode-cn.com/problems/path-sum-iii/solution/
 *
 * 双递归：
 *      1.第一重递归选出每个节点
 *      2.第二重递归以选出的点为root，往下找路径
 *
 */
public class P_437 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {

    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        int result = currentPath(root,sum);
        int l = pathSum(root.left,sum);
        int r = pathSum(root.right,sum);
        return result+l+r;
    }

    private int currentPath(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        sum = sum-root.val;
        int result = sum == 0?1:0;
        return result+currentPath(root.left,sum)+currentPath(root.right,sum);
    }
}
