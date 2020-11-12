package com.zz.clever_idea.Linked_List;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，
 * 时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 *
 * 示例 2:
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 *
 * 说明:
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 */
public class P_328 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    // 空间O(n/2)
    public ListNode oddEvenList(ListNode head) {
        // 排除为空和只有一位的情况
        if (head == null) return null;
        if(head.next == null) return head;
        List<ListNode> node1 = new ArrayList<>();
        List<ListNode> node2 = new ArrayList<>();
        int idx = 1;
        while (head!=null){
            if (idx%2 == 1){
                node1.add(head);
            }else{
                node2.add(head);
            }
            head = head.next;
            idx++;
        }
        for (int i = 0;i<node1.size()-1;i++){
            node1.get(i).next = node1.get(i+1);
        }
        node1.get(node1.size()-1).next = node2.get(0);
        for (int i = 0;i<node2.size()-1;i++){
            node2.get(i).next = node2.get(i+1);
        }
        // 赋值为null，否则容易成环
        node2.get(node2.size()-1).next = null;
        return node1.get(0);
    }

    /** 空间O(1)
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.1 MB, 在所有 Java 提交中击败了88.59%的用户
     */
    public ListNode oddEvenList2(ListNode head) {
        // 排除为空和只有一位的情况
        if (head == null) return null;
        if(head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;
        ListNode secondHead = fast;
        while (fast != null && fast.next != null){
            slow.next = fast.next;
            slow = fast.next;
            fast.next = fast.next.next;
            fast = fast.next;
        }
        slow.next = secondHead;
        return head;
    }
}
