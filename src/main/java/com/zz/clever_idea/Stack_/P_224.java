package com.zz.clever_idea.Stack_;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/basic-calculator/
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 * 示例 1:
 * 输入: "1 + 1"
 * 输出: 2
 *
 * 示例 2:
 * 输入: " 2-1 + 2 "
 * 输出: 3
 *
 * 示例 3:
 * 输入: "(1+(4+5+2)-3)+(6+8)"
 * 输出: 23
 *
 * 模拟
 */
public class P_224 {
    public int calculate(String s) {
        s = s.replace(" ", "");
        s = "("+s+")";
        Stack<String> st = new Stack<>();
        for(int i = 0;i<s.length();){
            char c = s.charAt(i);
            if (c == ')'){
                Stack<String> tmp = new Stack<>();
                while(!st.isEmpty() && !st.peek().equals("(")){
                    tmp.add(st.pop());
                }
                st.pop();
                while (tmp.size()>2){
                    int a = Integer.valueOf(tmp.pop());
                    char ch = tmp.pop().charAt(0);
                    int b = Integer.valueOf(tmp.pop());
                    if (ch == '+'){
                        tmp.add(String.valueOf(a+b));
                    }else if (ch == '-'){
                        tmp.add(String.valueOf(a-b));
                    }
                }
                st.add(tmp.pop());
                i++;
            }else if (c >= '0' && c <= '9'){
                StringBuilder sb = new StringBuilder();
                while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
                    sb.append(s.charAt(i));
                    i++;
                }
                st.add(sb.toString());
            }else {
                st.add(c+"");
                i++;
            }
        }

        return Integer.valueOf(st.pop());
    }
}
