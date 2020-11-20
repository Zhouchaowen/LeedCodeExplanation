# Linked List 栏目完结

## 1.结构

```
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
```

## 2.考点

1. 找链表倒数第k个元素的方法。【一次遍历；预处理k位后，双指针】
2. 删除一个节点。【list.next = list.next.next】 
3. 合并两个有序链表。
4. 判断链表是否为回文。【暴力；空间O(1)：快慢指针(L走一步，R走两步)+后半段链表翻转，边界问题】
5. 返回链表中间节点。【快慢指针+prev指针】
6. 删除链表中指定值。【prev指针+cur指针】
7. 判断两链表相交。【map；数学性质+快慢指针】
8. 翻转链表。【prev指针+cur指针】
9. 判断链表是否有环。【map；特征值判断】
10. 删除乱序链表重复元素。【set+从建】
11. 多层级链表。【栈；dfs】
12. 环形链表第k位。【取余+prev指针+cur指针】
13. 链表深拷贝。【map+重构；空间O(1) 拷贝+old指针+new指针】
14. 模拟加法
15. 链表元素两两交换。【重构；superHead指针+cur指针+next指针】
16. 重排链表l0->ln->l1->ln-1。【快慢指针+重构】
17. 链表转平衡二叉树。【数组化+dfs左右构建】
18. 分割链表
19. 判断链表是否存在于二叉树中。【双重dfs枚举每个起点】
20. 链表中的下一个更大节点。【反向单调栈】
21. 删除链表中总和为0的连续节点
22. 链表按照特定值x划分左右。【拆分后重构】

## 3.经典题目

1.**双指针**（pre+cur）

[返回倒数第k个节点](https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/)

[链表相交](https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/)

[反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)

[反转链表 II](https://leetcode-cn.com/problems/reverse-linked-list-ii/)

```java
ListNode pre = head;
ListNode cur = head;
while (cur != null){
    pre = pre.next;
    cur = cur.next;
}
//-------------
ListNode pre = null;
ListNode cur = head;
while(cur != null){
    ListNode t = cur.next;
    cur.next = pre;
    pre = cur;
    cur = t;
}
```

2.**快慢指针**（slow+fast）

[回文链表](https://leetcode-cn.com/problems/palindrome-linked-list/)

[链表中间节点](https://leetcode-cn.com/problems/middle-of-the-linked-list/)

[环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)

[环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/)

[重排链表](https://leetcode-cn.com/problems/reorder-list/)

[奇偶链表](https://leetcode-cn.com/problems/odd-even-linked-list/)

```java
ListNode slow = head;
ListNode fast = head;
while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}
```



3.**superHead**（辅助头）

[两两交换链表节点](https://leetcode-cn.com/problems/swap-nodes-in-pairs/)

[删除排序链表重复元素](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/)

4.复合题

[有序链表转换二叉搜索树](https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/)

[二叉树中的链表](https://leetcode-cn.com/problems/linked-list-in-binary-tree/)

[从链表中删去总和值为零的连续节点](https://leetcode-cn.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/)

[复制带随机指针的链表](https://leetcode-cn.com/problems/copy-list-with-random-pointer/)

[链表中的下一个更大节点](https://leetcode-cn.com/problems/next-greater-node-in-linked-list/)