package com.zz.clever_idea.Stack_;

import org.springframework.util.AutoPopulatingList;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 */
public class P_103 {
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

    /**
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)return new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        Deque<Integer> dqi = new ArrayDeque<>();
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        st.add(root);
        dqi.add(idx);
        list.add(root.val);
        lists.add(list);
        list = new ArrayList<>();
        while(!st.isEmpty()){
            Integer sum = dqi.pollFirst();
            TreeNode tmp = st.pop();

            if (sum%2 == 0 ){
                if (tmp.right != null){
                    st2.add(tmp.right);
                    list.add(tmp.right.val);
                    dqi.add(idx+1);
                }
                if (tmp.left != null){
                    st2.add(tmp.left);
                    list.add(tmp.left.val);
                    dqi.add(idx+1);
                }
            }else {
                if (tmp.left != null){
                    st2.add(tmp.left);
                    list.add(tmp.left.val);
                    dqi.add(idx+1);
                }
                if (tmp.right != null){
                    st2.add(tmp.right);
                    list.add(tmp.right.val);
                    dqi.add(idx+1);
                }
            }
            if (st.isEmpty() && list.size()>0){
                lists.add(list);
                list = new ArrayList<>();
                idx++;
                st = st2;
                st2 = new Stack<>();
            }
        }
        return lists;
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> qu = new ArrayDeque<>();
        if (root != null){
            qu.add(root);
            int step = 0;
            while (qu.size() != 0){
                List<Integer> list = new ArrayList<>();
                int len = qu.size();
                for(int i = 0;i<len;i++){
                    TreeNode tmp = qu.poll();
                    list.add(tmp.val);
                    if (tmp.left != null){
                        qu.add(tmp.left);
                    }
                    if (tmp.right != null){
                        qu.add(tmp.right);
                    }
                }
                if (step % 2 == 1){
                    Collections.reverse(list);
                }
                lists.add(list);
                step++;
            }
        }
        return lists;
    }
}
