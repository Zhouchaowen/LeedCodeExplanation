package com.zz.clever_idea.Linked_List;


/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 *
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 */
public class P_082 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    // 题看错：去重重复的元素，只保留一个
    public ListNode deleteDuplicates(ListNode head) {
        for (ListNode t = head;t.next!=null;){
            while (t.val == t.next.val){
                t.next = t.next.next;
            }
            t = t.next;
        }
        return head;
    }

    /**
     * 1  ->  2  ->  3  ->  3  ->  4  ->  4  ->  5
     * 0  ->  1  ->  2  ->  3  ->  3  ->  4  ->  4  ->  5
     * sp
     * l      r
     * 0  ->  1  ->  2  ->  3  ->  3  ->  4  ->  4  ->  5
     * sp
     *        l      r
     * 0  ->  1  ->  2  ->  3  ->  3  ->  4  ->  4  ->  5
     * sp
     *               l      r
     * 0  ->  1  ->  2  ->  3  ->  3  ->  4  ->  4  ->  5
     * sp
     *               l                    r
     * 0  ->  1  ->  2  ->  4  ->  4  ->  5
     * sp
     *               l      r
     * 0  ->  1  ->  2  ->  4  ->  4  ->  5
     * sp
     *               l                    r
     * 0  ->  1  ->  2  ->  5
     * sp
     *               l      r
     *
     * 建立超级头，l必须要以head的前一位开始
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode superHead = new ListNode(0);
        ListNode l = superHead,r = head;
        superHead.next = head;
        while (r != null && r.next != null){
            // 不等，移动左下标
            if (l.next.val != r.next.val){
                l = l.next;
                r = r.next;
            }else {
                while (r.next != null && r != null && l.next.val == r.next.val){
                    r = r.next;
                }
                l.next = r.next;
                r = r.next;
            }
        }
        return superHead.next;
    }

}
