package com.zz.clever_idea.Linked_List;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，
 * 它还有一个子链表指针，可能指向单独的双向链表。
 * 这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 *
 * 给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * 输出：[1,2,3,7,8,11,12,9,10,4,5,6]
 *
 * 解释：
 * 输入的多级列表如下图所示：
 *
 */
public class P_430 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
    // DFS
    public Node flatten(Node head) {
        if (head == null) return null;
        Node ans = head;
        dfs(head);
        return ans;
    }
    public Node dfs(Node head){
        while(head!=null){
            if(head.child == null){
                if (head.next == null) return head;
                head = head.next;
                continue;
            }
            Node t = dfs(head.child);
            Node nextNode = head.next;
            head.next = head.child;
            head.child.prev = head;
            head.child = null;
            if (nextNode != null){
                t.next = nextNode;
                nextNode.prev = t;
                head = t;
            }
        }
        return head;
    }

    // 迭代
    public Node flatten2(Node head) {
        if (head == null) return null;
        Stack<Node> st = new Stack<>();
        Node superHead = new Node();
        Node pre = superHead,cur = superHead;
        st.add(head);
        while (!st.isEmpty()){
            cur = st.pop();
            pre.next = cur;
            cur.prev = pre;
            // 核心 先存next,在存child
            if (cur.next != null) st.add(cur.next);
            if (cur.child != null){
                st.add(cur.child);
                cur.child = null;
            }
            pre = cur;
        }
        superHead.next.prev = null;
        return superHead.next;
    }
}
