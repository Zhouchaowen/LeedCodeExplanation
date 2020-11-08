package com.zz.clever_idea.Linked_List;


import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 *
 *定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *  
 * 限制：
 * 0 <= 节点个数 <= 5000
 *
 * 空间O(1)？双指针
 */
public class F_024 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode reverseList(ListNode head) {
        if (head == null)return null;
        ListNode root = new ListNode(0);
        ListNode ans = root;
        Stack<ListNode> st = new Stack<>();
        while(head!=null){
            st.push(head);
            head = head.next;
        }
        while(!st.isEmpty()){
            ListNode t = new ListNode(st.pop().val);
            root.next = t;
            root = t;
        }
        return ans.next;
    }
    // 双指针
    public ListNode reverseList2(ListNode head) {
        if (head == null)return null;
        ListNode cur = null;
        ListNode pre = head;
        while(pre!=null){
            ListNode t = pre.next;
            pre.next = cur;
            cur = pre;
            pre = t;
        }
        return cur;
    }
}
