package com.zz.clever_idea.Stack_;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 */
public class P_145 {
    class TreeNode {
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
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return list;
    }

    void dfs(TreeNode root){
        if (root == null) return;
        dfs(root.left);
        dfs(root.right);
        list.add(root.val);
    }

    void StackDfs(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        TreeNode pre = null;
        while(root != null|| !st.isEmpty()){
            while(root != null){
                st.add(root);
                root = root.left;
            }
            root = st.pop();
            // 没有指针，只能用pre表示right已经走过,让他不要在走下去
            if (root.right == null || root.right == pre){
                list.add(root.val);
                pre = root;
                root = null;
            }else {
                st.add(root);
                root = root.right;
            }
        }
    }




}
