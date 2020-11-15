package com.zz.clever_idea.Linked_List;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/split-linked-list-in-parts/
 *
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 * 返回一个符合上述规则的链表的列表。
 *
 * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
 *
 * 示例 1：
 * 输入:
 * root = [1, 2, 3], k = 5
 * 输出: [[1],[2],[3],[],[]]
 * 解释:
 * 输入输出各部分都应该是链表，而不是数组。
 * 例如, 输入的结点 root 的 val= 1, root.next.val = 2,
 * \root.next.next.val = 3, 且 root.next.next.next = null。
 * 第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
 * 最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
 *
 * 示例 2：
 * 输入:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * 输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * 解释:
 * 输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。
 *  
 *
 * 提示:
 * root 的长度范围： [0, 1000].
 * 输入的每个节点的大小范围：[0, 999].
 * k 的取值范围： [1, 50].
 *
 *
 */
public class P_725 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode[] splitListToParts(ListNode root, int k) {
        if (root==null) return new ListNode[0];
        List<ListNode> list = new ArrayList<>();
        ListNode[] ln = new ListNode[k];
        while(root!=null){
            list.add(root);
            root = root.next;
        }
        Deque<ListNode> dq = new ArrayDeque<>();
        int t = list.size()/k;
        int idx = 0;
        int exec = list.size()%k;
        if(t>0){
            if (exec == 0){
                for(int i = 0;i<list.size();i++){
                    dq.add(list.get(i));
                    if(dq.size() == t){
                        ln[idx++] = dq.getFirst();
                        dq.getLast().next = null;
                        while(dq.size()>0){
                            dq.pop();
                        }
                    }
                }
            }else{
                ln[idx++] = list.get(0);
                list.get(exec+t-1).next = null;
                for(int i = exec+t;i<list.size();i++){
                    dq.add(list.get(i));
                    if(dq.size() == t){
                        ln[idx++] = dq.getFirst();
                        dq.getLast().next = null;
                        while(dq.size()>0){
                            dq.pop();
                        }
                    }
                }
            }
        }else{
            idx = 0;
            for(int i = 0;i<list.size();i++){
                ln[idx++] = list.get(i);
                list.get(i).next = null;
            }
            while(idx<k){
                ln[idx++] = null;
            }
        }
        return ln;
    }

    public ListNode[] splitListToParts2(ListNode root, int k) {
        if (root==null) return new ListNode[k];
        List<ListNode> list = new ArrayList<>();
        ListNode[] ln = new ListNode[k];
        ListNode p = root;
        while(p!=null){
            list.add(p);
            p = p.next;
        }
        ListNode cur = root;
        int lenk = list.size()/k;
        int e = list.size()%k;
        for (int i = 0;i<k;i++){
            ListNode h = cur;
            // 均分 + 把多余的元素分散到每一位 lenk+(i<e?1:0)-1
            for(int j = 0;j<lenk+(i<e?1:0)-1;j++){
                if (cur!=null) cur = cur.next;
            }
            if (cur!=null){
                ListNode pre = cur;
                cur = cur.next;
                pre.next = null;
            }
            ln[i] = h;
        }
        return ln;
    }
}
