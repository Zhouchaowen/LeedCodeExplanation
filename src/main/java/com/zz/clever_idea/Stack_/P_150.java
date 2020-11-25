package com.zz.clever_idea.Stack_;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 * 示例 1：
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 *
 * 示例 2：
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: 该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 *
 *  经典栈问题
 */
public class P_150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String s:tokens){
            if (s.equals("-")){
                int a = st.pop();
                st.add(st.pop()-a);
            }else if (s.equals("+")){
                st.add(st.pop()+st.pop());
            }else if (s.equals("*")){
                st.add(st.pop()*st.pop());
            }else if (s.equals("/")){
               int a = st.pop();
               st.add(st.pop()/a);
            }else {
                st.add(Integer.valueOf(s));
            }
        }
        return st.pop();
    }
}
