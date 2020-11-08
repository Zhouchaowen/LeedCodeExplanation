package com.zz.clever_idea.Linked_List;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 *
 */
public class F_006 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    private static int idx = 0;
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];
        List<Integer> ans  = new ArrayList<>();
        dfs(head,ans);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
    void dfs(ListNode root,List<Integer> arr){
        if(root.next != null){
            dfs(root.next,arr);
        }
        arr.add(root.val);
    }
    public int[] reversePrint2(ListNode head) {
        if (head == null) return new int[0];
        Stack<Integer> st = new Stack<>();
        while (head != null){
            st.push(head.val);
            head = head.next;
        }
        // 正向 x
        return st.stream().mapToInt(Integer::intValue).toArray();
    }

}
