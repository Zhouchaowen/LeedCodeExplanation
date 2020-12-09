package com.zz.clever_idea.Stack_;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/implement-queue-using-stacks-lcci/
 *
 * 实现一个MyQueue类，该类用两个栈来实现一个队列。
 * 示例：
 * MyQueue queue = new MyQueue();
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 *
 * 说明：
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size
 * 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，
 * 只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 *
 */
public class M_304 {

    Stack<Integer> st1;
    Stack<Integer> st2;
    /** Initialize your data structure here. */
    public M_304() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        st1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!st1.isEmpty()){
            st2.push(st1.pop());
        }
        int tmp = st2.pop();
        while (!st2.isEmpty()){
            st1.push(st2.pop());
        }
        return tmp;
    }

    /** Get the front element. */
    public int peek() {
        return st1.firstElement();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st1.size()==0;
    }
}
