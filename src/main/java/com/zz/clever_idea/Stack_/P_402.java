package com.zz.clever_idea.Stack_;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/remove-k-digits/
 *
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 *
 * 示例 1 :
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 *
 * 示例 2 :
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 *
 */
public class P_402 {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for (int i = 0;i<num.length();i++){
            char c = num.charAt(i);
            while (!st.isEmpty() && st.peek().charValue() > c && k>0){
                st.pop();
                k--;
            }
            st.add(c);
        }
        while (!st.isEmpty() && k>0){
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        st.forEach(c->{
            if (c == '0' && sb.length()==0){
            }else {
                sb.append(c);
            }
        });
        return sb.toString().equals("")?"0":sb.toString();
    }
}
