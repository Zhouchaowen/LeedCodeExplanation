package com.zz.clever_idea.Stack_;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * 注意，您的结果中 不应 包含任何括号。
 *
 * 示例 1：
 * 输入：s = "(abcd)"
 * 输出："dcba"
 *
 * 示例 2：
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 *
 * 提示：
 * 0 <= s.length <= 2000
 * s 中只有小写英文字母和括号
 * 我们确保所有括号都是成对出现的
 *
 */
public class P_1190 {
    public String reverseParentheses(String s) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        for(int i = 0;i<s.length();i++){
            if (s.charAt(i) == ')'){
                while (!st1.isEmpty() && st1.peek() != '('){
                    st2.add(st1.pop());
                }
                st1.pop();
                st2.forEach(c->{
                    st1.add(c);
                });
                st2.clear();
            }else{
                st1.add(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        st1.forEach(c->{
            sb.append(c);
        });
        return sb.toString();
    }

    public String reverseParentheses2(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<s.length();i++){
            if (s.charAt(i) == ')'){
                int l = st.pop()+1;
                int r = i-1;
                while(l<r){
//                    StringBuffer stringBuffer = new StringBuffer(sb.substring(l, r));
//                    sb.toString().replace(stringBuffer,stringBuffer.reverse());
                    char ch = sb.charAt(l);
                    sb.setCharAt(l,sb.charAt(r));
                    sb.setCharAt(r,ch);
                    l++;
                    r--;
                }
            }else if (s.charAt(i) == '('){
                st.add(i);
            }
        }
        String replace = sb.toString().replace("(", "").replace(")", "");
        return replace;
    }
}
