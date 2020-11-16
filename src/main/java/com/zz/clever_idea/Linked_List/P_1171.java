package com.zz.clever_idea.Linked_List;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
 *
 * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，
 * 直到不存在这样的序列为止。
 * 删除完毕后，请你返回最终结果链表的头节点。
 * 你可以返回任何满足题目要求的答案。
 * （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
 *
 * 示例 1：
 * 输入：head = [1,2,-3,3,1]
 * 输出：[3,1]
 * 提示：答案 [1,2,1] 也是正确的。
 *
 * 示例 2：
 * 输入：head = [1,2,3,-3,4]
 * 输出：[1,2,4]
 *
 * 示例 3：
 * 输入：head = [1,2,3,-3,-2]
 * 输出：[1]
 *
 * 提示：
 * 给你的链表中可能有 1 到 1000 个节点。
 * 对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000.
 *
 */
public class P_1171 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null)return null;
        int[] arr = new int[1005];
        arr[0] = 0;
        int idx = 1;
        while(head!=null){
            arr[idx++] = head.val;
            head = head.next;
        }

        for(int i = 1;i<idx;i++){
            int[] t = new int[1005];
            System.out.println(i);
            for(int j = i;j<idx;j++){
                t[j] = t[j-1]+arr[j];
                if(t[j] == 0){
                    while (i<=j){
                        arr[i++] = 0;
                    }
                    i = j;
                    break;
                }
            }
        }
        ListNode ans = new ListNode(-1);
        head = ans;
        for(int i = 1;i<idx;i++){
            if (arr[i]!=0){
                ListNode tmp = new ListNode(arr[i]);
                ans.next = tmp;
                ans = tmp;
            }
        }
        return head.next;
    }

    // map中sum被覆盖时就代表有相加等于0的段
    public ListNode removeZeroSumSublists2(ListNode head) {
        if (head == null) return null;
        Map<Integer,ListNode> map = new HashMap<>();
        ListNode p = new ListNode(0);

        p.next = head;
        int sum =0 ;
        while(p!=null){
            sum += p.val;
            map.put(sum,p);
            p = p.next;
        }
        sum = 0;
        p = new ListNode(0);
        p.next = head;
        ListNode ans = p;
        while (p!=null){
            sum += p.val;
            p.next = map.get(sum).next;
            p = p.next;
        }
        return ans.next;
    }
}
