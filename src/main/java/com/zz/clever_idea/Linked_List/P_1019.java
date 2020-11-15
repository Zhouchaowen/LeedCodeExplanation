package com.zz.clever_idea.Linked_List;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/next-greater-node-in-linked-list/
 *
 * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：
 * node_1, node_2, node_3, ... 。
 * 每个节点都可能有下一个更大值（next larger value）：
 * 对于 node_i，如果其 next_larger(node_i) 是 node_j.val，
 * 那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。
 * 如果不存在这样的 j，那么下一个更大值为 0 。
 * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 * 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，
 * 其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。
 *
 * 示例 1：
 * 输入：[2,1,5]
 * 输出：[5,5,0]
 *
 * 示例 2：
 * 输入：[2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 *
 * 示例 3：
 * 输入：[1,7,5,1,9,2,5,1]
 * 输出：[7,9,9,9,0,5,0,0]
 *
 * 提示：
 * 对于链表中的每个节点，1 <= node.val <= 10^9
 * 给定列表的长度在 [0, 10000] 范围内
 *
 * 单调栈
 */
public class P_1019 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 单调栈，求左边第一个比他大或者比他小的数是几
     * 本题需要反向求
     *
     * @param head
     * @return
     */
    public int[] nextLargerNodes(ListNode head) {
        if (head ==  null)return new int[0];
        if (head.next == null)return new int[1];
        // 反向
        Stack<Integer> st = new Stack<>();
        while (head!=null){
            st.add(head.val);
            head = head.next;
        }
        int[] stk = new int[st.size()+1];
        // 反向存储答案
        int[] ans = new int[st.size()];
        int tt = 0;
        int idx = st.size()-1;
        while (st.size()>0){
            int x = st.pop();
            while(tt>0 && stk[tt]<=x)tt--;
            if(tt>0) ans[idx--] = stk[tt];
            else ans[idx--] = 0;
            stk[++tt] = x;
        }
        return ans;
    }
}
