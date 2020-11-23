package com.zz.clever_idea.Stack_;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/basic-calculator-ii/
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 * 示例 1:
 * 输入: "3+2*2"
 * 输出: 7
 *
 * 示例 2:
 * 输入: " 3/2 "
 * 输出: 1
 *
 * 示例 3:
 * 输入: " 3+5 / 2 "
 * 输出: 5
 *
 * 说明：
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 *
 *
 *
 *
 * wc
 */
public class P_227 {
    public static void main(String[] args) {
        new P_227().calculate("3/2");


    }
    public int calculate(String s) {
        s = s.replace(" ","");
        Deque<String> st = new ArrayDeque<>();
        for(int i = 0;i<s.length();){
            if (s.charAt(i) == ' '){
                i++;
                continue;
            }
            if (s.charAt(i)=='+' || s.charAt(i)=='-'){
                st.add(s.charAt(i)+"");
                i++;
            }else if(s.charAt(i) == '/'){
                int a = Integer.valueOf(st.pollLast());
                StringBuilder sb = new StringBuilder();
                i++;
                while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
                    sb.append(s.charAt(i));
                    i++;
                }
                int b = Integer.valueOf(sb.toString());
                st.add((a/b)+"");
            }else if (s.charAt(i) == '*'){
                int a = Integer.valueOf(st.pollLast());
                StringBuilder sb = new StringBuilder();
                i++;
                while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
                    System.out.println(s.charAt(i));
                    sb.append(s.charAt(i));
                    i++;
                }
                int b = Integer.valueOf(sb.toString());
                st.add((a*b)+"");
            }else{
                StringBuilder sb = new StringBuilder();
                while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
                    sb.append(s.charAt(i));
                    i++;
                }
                st.add(sb.toString());
            }
        }
        Stack<Integer> ans = new Stack<>();
        while (!st.isEmpty()){
            String tmp = st.pollFirst();
            System.out.println(tmp);
            if (tmp.equals("+")){
                ans.add(ans.pop()+Integer.valueOf(st.pollFirst()));
            }else if (tmp.equals("-")){
                ans.add(ans.pop()-Integer.valueOf(st.pollFirst()));
            }else {
                ans.add(Integer.valueOf(tmp));
            }
        }
        return ans.pop();
    }



}
