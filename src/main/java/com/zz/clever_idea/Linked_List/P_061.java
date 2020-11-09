package com.zz.clever_idea.Linked_List;

/**
 * https://leetcode-cn.com/problems/rotate-list/
 *
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 示例 2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 */
public class P_061 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 注意只有一个节点时 特判
     * 注意k%len == 0时 特判
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int len = 0;
        ListNode t = head;
        while(t.next != null){
            len++;
            t = t.next;
        }
        len++;
        if (len == 1){
            return head;
        }
        ListNode end = t;
        k = k%len;
        if (k == 0) return head;
        t = head;
        for (int i = 0;i<len-k-1;i++){
            t = t.next;
        }
        ListNode ans = t.next;
        t.next = null;
        end.next = head;
        return ans;
    }
    // 方法二
    // 快慢指针，先计算链表长度 n ，求k%=n
    // 然后 slow , fast 让fast先走k步,然后一起走到停
    // 保存slow.next然后赋值为null,赋值fast.next = head
}
