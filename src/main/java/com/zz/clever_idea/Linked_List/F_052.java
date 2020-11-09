package com.zz.clever_idea.Linked_List;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * 输入两个链表，找出它们的第一个公共节点。
 * 输入：intersectVal = 8, listA = [4,1,8,4,5],
 * listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 * 空间O(1)?
 *
 */
public class F_052 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode,Integer> hm = new HashMap<>();
        while (headA != null){
            if (!hm.containsKey(headA)){
                hm.put(headA,0);
            }
            headA = headA.next;
        }
        while (headB != null){
            if (hm.containsKey(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /** 规律
     * 4,1,[8],4,5 -> 5,0,1,[8],4,5 null
     * n1
     * 5,0,1,[8],4,5 -> 4,1,[8],4,5 null
     * n2
     *
     * 如果没有相等的他们，因为headA+headB 拼接后链是一样长的
     * 所以最后会走到末尾 等于 null 并不会死循环
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != node2){
            node1 = node1 == null?headB:node1.next;
            node2 = node2 == null?headA:node2.next;
        }
        return node1;
    }
}
