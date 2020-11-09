package com.zz.clever_idea.Linked_List;

import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 *
 * 提示：
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 *
 */
public class P_024 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 建立super头结点
     *
     * 1   ->   2   ->   3   ->   4
     * 0   ->   1   ->   2   ->   3   ->   4
     * sp       n1       n2
     *
     * 0   ->   1   ->   2   ->   3   ->   4
     * sp->n2 =>  0->2
     * n1->n2.next => 1->3
     * n2->n1 =>  2->1
     * sp=n1 sp = 1
     *
     *  0->2->1->3->4
     *  0   ->   2   ->   1   ->   3   ->   4
     *                    sp       n1       n2
     * 循环以操作
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode superHead = new ListNode(0);
        ListNode tmp = superHead;
        superHead.next = head;
        while(tmp.next != null && tmp.next.next != null){
            ListNode node1 = tmp.next;
            ListNode node2 = tmp.next.next;
            tmp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            tmp = node1;
        }
        return superHead.next;
    }

    public ListNode swapPairs2(ListNode head) {
       // 1.用大小为2的栈存结点，栈满就弹到List里面
       // 2.重List一次连接结点
        Stack<ListNode> stack = new Stack<>();
        LinkedList<ListNode> list = new LinkedList<>();

        while (head!=null){
            stack.push(head);
            head = head.next;
            stack.peek().next = null;
            if(stack.size()==2){
                list.add(stack.pop());
                list.add(stack.pop());
            }
        }
        if(!stack.isEmpty()){
            list.add(stack.pop());
        }
        ListNode temp = null;
        while (!list.isEmpty()){
            if(head == null){
                head = list.pollFirst();
                temp = head;
            }
            temp.next = list.pollFirst();
            temp = temp.next;
        }
        return head;
    }
}
