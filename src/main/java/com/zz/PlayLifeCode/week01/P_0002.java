package com.zz.PlayLifeCode.week01;

/**
 *给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 
 * 逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 考点：
 * 1.链表使用
 * 2.模拟加法
 *
 * 同面试题02.05
 */
public class P_0002 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode listNode = new ListNode(0);
        ListNode ans = listNode;
        while(l1!=null || l2!=null){
            int a = l1 != null?l1.val:0;
            int b = l2 != null?l2.val:0; // 取值
            carry = (a+b+carry);
            ListNode tmp = new ListNode(carry%10); // 求余
            listNode.next = tmp;
            listNode = tmp;
            carry /= 10;
            l1 = l1 == null?null:l1.next; // 后移节点
            l2 = l2 == null?null:l2.next;
        }
        if (carry>0){ // 判断进位
            ListNode tmp = new ListNode(carry%10);
            listNode.next = tmp;
        }
        return ans.next;
    }
}
/*
class Solution {
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2)
    {
        ListNode *res = new ListNode(-1);   //添加虚拟头结点，简化边界情况的判断
        ListNode *cur = res;
        int carry = 0;  //表示进位
        while (l1 || l2)
        {
            int n1 = l1 ? l1->val : 0;
            int n2 = l2 ? l2->val : 0;
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            cur->next = new ListNode(sum % 10);
            cur = cur->next;
            if (l1) l1 = l1->next;
            if (l2) l2 = l2->next;
        }
        if (carry) cur->next = new ListNode(1); //如果最高位有进位，则需在最前面补1.
        return res->next;   //返回真正的头结点
    }
};

**/