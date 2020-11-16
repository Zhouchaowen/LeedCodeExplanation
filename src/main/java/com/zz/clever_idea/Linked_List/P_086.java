package com.zz.clever_idea.Linked_List;

/**
 * https://leetcode-cn.com/problems/partition-list/
 *
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * 同面试题02.04
 */
public class P_086 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 定义超级头，在定义双指针
     * 1  ->  4  ->  3  ->  2  ->  5  ->  2
     * 0  ->  1  ->  4  ->  3  ->  2  ->  5  ->  2
     * sp
     * pre    h
     * 0  ->  1  ->  4  ->  3  ->  2  ->  5  ->  2
     * sp
     *       tmp
     *       pre     h
     * 0  ->  1  ->  4  ->  3  ->  2  ->  5  ->  2
     * sp
     *       tmp
     *                     pre     h
     *
     * 0  ->  1  ->  4  ->  3  ->  5  ->  2  pre.next = head.next;
     *                      2  ->
     *
     * 0  ->  1  ->  4  ->  3  ->  5  ->  2  head.next = tmp.next;
     *        2  ->
     * 0  ->  1  ->  2  ->  4  ->  3  ->  5  ->  2  tmp.next = head;
     *
     * 0  ->  1  ->  2  ->  4  ->  3  ->  5  ->  2
     * sp
     *              tmp                             tmp = tmp.next;
     *                                    pre    h  head = pre.next;
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode superHead = new ListNode(0);
        superHead.next = head;
        ListNode tmp = superHead;
        ListNode pre = superHead;
        while (head != null){
            if (head.val >= x){
                pre = head;
                head = head.next;
                continue;
            }
            if (tmp.next == head){
                tmp = tmp.next;
                pre = head;
                head = head.next;
            }else{
                pre.next = head.next;
                head.next = tmp.next;
                tmp.next = head;
                tmp = tmp.next;
                head = pre.next;
            }
        }
        return superHead.next;
    }

    public ListNode partition2(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        // 储存小于x的节点
        ListNode leftOne = new ListNode(-1);
        ListNode left = leftOne;
        // 储存大于等于x的节点
        ListNode rightOne = new ListNode(-1);
        ListNode right = leftOne;
        ListNode next;
        while (head!=null){
            next = head.next;
            if (head.val<x){
                left.next = head;
                left = head;
            }else {
                right.next = head;
                right = head;
            }
            // 必须赋值为null,不然可能成环
            head.next = null;
            head = next;
        }
        // 拼接
        left.next = rightOne.next;
        return leftOne.next;
    }

}
