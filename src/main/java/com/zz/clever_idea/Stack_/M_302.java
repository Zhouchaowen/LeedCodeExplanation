package com.zz.clever_idea.Stack_;

import java.util.Stack;
import java.util.TreeMap;

/**
 * https://leetcode-cn.com/problems/min-stack-lcci/
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，
 * 该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
 *
 * 示例：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 */
public class M_302 {
    TreeMap<Integer,Integer> tm;
    Stack<Integer> st;
    /** initialize your data structure here. */
    public M_302() {
        tm = new TreeMap<>();
        st = new Stack<>();
    }

    public void push(int x) {
        st.add(x);
        tm.put(x,tm.get(x) == null?1:tm.get(x)+1);
    }

    public void pop() {
        Integer pop = st.pop();
        if (tm.get(pop)>1){
            tm.put(pop,tm.get(pop)-1);
        } else
            tm.remove(pop);
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return tm.firstKey();
    }
}
