package com.zz.clever_idea.Stack_;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 */
public class P_144 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
        }
    }


    /**
     * 前序遍历非迭代版
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.add(root);
        // 核心步骤
        TreeNode tmp = root;
        while (!st.isEmpty() && tmp != null){
            while (tmp!=null){
                list.add(tmp.val);
                st.add(tmp);
                tmp = tmp.left;
            }
            while (!st.isEmpty() && st.peek().right == null){
                st.pop();
            }
            tmp = st.isEmpty() == true?null:st.pop().right;
        }
        return list;
    }








    public List<Integer> preorderTraversal2(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        dfs(list,root);
        return list;
    }

    private void dfs(List<Integer> list, TreeNode root) {
        if (root == null)return;
        list.add(root.val);
        dfs(list,root.left);
        dfs(list,root.right);
    }
}
