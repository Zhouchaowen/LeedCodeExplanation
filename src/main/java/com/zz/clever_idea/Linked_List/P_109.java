package com.zz.clever_idea.Linked_List;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 *
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 1.链表本身就是有序 ，所以A[i-1]<A[i]<A[i+1]
 * 2.找到中位数
 * 3.分别递归左边和右边
 * 4.回溯构建整颗树
 */
public class P_109 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

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
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        return dfs(list,0,list.size()-1);
    }

    // 长度奇偶其实不影响，高度差可以为 1
    TreeNode dfs(List<Integer> list,int left,int right){
        if(left>right) return null;
        int mid = (left+right+1)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = dfs(list,left,mid-1);
        root.right = dfs(list,mid+1,right);
        return root;
    }
}
