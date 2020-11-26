package com.zz.clever_idea.Stack_;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/decode-string/
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。
 * 注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例 1：
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 *
 * 示例 2：
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 *
 * 示例 3：
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 *
 */
public class P_394 {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<s.length();i++){
            if (s.charAt(i) == ']'){
                List<Character> list = new ArrayList<>();
                List<Character> tmp = new ArrayList<>();
                StringBuilder tt = new StringBuilder();
                while (!st.isEmpty()&& st.peek() != '['){
                    list.add(st.pop());
                }
                st.pop();
                while (!st.isEmpty() && st.peek() >= '0' && st.peek() <= '9'){
                    tt.append(st.pop());
                }
                tt = tt.reverse();
                int sum = Integer.valueOf(tt.toString());
                System.out.println(tt);
                while (sum>0){
                    for (int j = list.size()-1;j>=0;j--){
                        tmp.add(list.get(j));
                    }
                    sum--;
                }
                st.addAll(tmp);
            }else {
                st.add(s.charAt(i));
            }
        }
        st.forEach(c->{
            sb.append(c);
        });
        return sb.toString();
    }
}
