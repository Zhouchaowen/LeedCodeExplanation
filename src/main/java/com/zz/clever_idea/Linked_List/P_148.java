package com.zz.clever_idea.Linked_List;


/**
 * https://leetcode-cn.com/problems/sort-list/
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 * 示例 1：
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 *
 * 可以用P_147解法
 *
 */
public class P_148 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    // 链表归并,工程上写并不好
    public ListNode sortList(ListNode head) {
        // 注意结束边界
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHead = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(secondHead);
        return meager(left,right);
    }

    private ListNode meager(ListNode left, ListNode right) {
        ListNode superHead = new ListNode(-1);
        ListNode ans = superHead;
        while (left != null && right != null){
            if (left.val>right.val){
                superHead.next = right;
                right = right.next;
            }else {
                superHead.next = left;
                left = left.next;
            }
            superHead = superHead.next;
        }
        /*  slow.next = null;保证末尾指向空
        while (left != null){
            superHead.next = left;
            superHead = superHead.next;
            left = left.next;
        }
        while (right != null){
            superHead.next = right;
            superHead = superHead.next;
            right = right.next;
        }*/
        if (left!=null) superHead.next = left;
        if (right!=null) superHead.next = right;
        return ans.next;
    }
}
