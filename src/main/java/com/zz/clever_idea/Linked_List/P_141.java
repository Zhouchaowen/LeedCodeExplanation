package com.zz.clever_idea.Linked_List;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 链表里面有环整么判断
 * 注意：单节点自环问题
 *
 * 快慢指针：假想「乌龟」和「兔子」在链表上移动，「兔子」跑得快，「乌龟」跑得慢。当「乌龟」和「兔子」从链表上的同一个节点开始移动时，如果该链表中没有环，那么「兔子」将一直处于「乌龟」的前方；如果该链表中有环，那么「兔子」会先于「乌龟」进入环，并且一直在环内移动。等到「乌龟」进入环时，由于「兔子」的速度快，它一定会在某个时刻与乌龟相遇，即套了「乌龟」若干圈。
 *
 */
public class P_141 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        int pos = -1,idx = 1000000;
        ListNode t;
        while (head.next != null){
            t = head;
            head = head.next;
            if (head.val>100000){
                 pos = head.val-1000000;
            }
            t.next = null;
            t.val = idx++;
            if (t == head){
                pos = t.val-1000000;
            }
        }
        return pos==-1?false:true;
    }
}
