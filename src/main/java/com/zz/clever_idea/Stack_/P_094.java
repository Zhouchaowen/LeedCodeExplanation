package com.zz.clever_idea.Stack_;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *
 */
public class P_094 {
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        dfs(root,list);
        return list;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;
        dfs(root.left,list);
        list.add(root.val);
        dfs(root.right,list);
    }

    /**
     * 和前序细节差别
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) return new ArrayList<>(0);
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        st.add(root);
        while (!st.isEmpty()){
            TreeNode tmp = st.pop();
            while (tmp!=null){
                st.add(tmp);
                tmp = tmp.left;
            }
            while (!st.isEmpty() && st.peek().right == null){
                list.add(st.pop().val);
            }
            if (!st.isEmpty()){
                tmp = st.pop();
                list.add(tmp.val);
                st.add(tmp.right);
            }
        }
        return list;
    }

    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

}
