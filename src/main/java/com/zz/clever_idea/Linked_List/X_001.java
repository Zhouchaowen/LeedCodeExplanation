package com.zz.clever_idea.Linked_List;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 *
 *编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 * 提示：
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 *
 * 如果不得使用临时缓冲区，该怎么解决？
 *
 * 注意要一个pre保存上一位
 *
 */
public class X_001 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return null;
        Set<Integer> set = new HashSet<>();
        ListNode root = head;
        ListNode pre = head;
        while(head.next != null){
            if (set.contains(head.val)){
                pre.next = head.next;
                head = head.next;
            }else {
                set.add(head.val);
                pre = head;
                head = head.next;
            }
        }
        if (set.contains(head.val)){
            pre.next = null;
        }else{

        }
        return root;
    }
}
