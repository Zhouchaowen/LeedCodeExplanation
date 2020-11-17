package com.zz.clever_idea.Stack_;

import java.util.Calendar;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/make-the-string-great/
 * 给你一个由大小写英文字母组成的字符串 s 。
 * 一个整理好的字符串中，两个相邻字符 s[i] 和 s[i+1]，其中 0<= i <= s.length-2 ，要满足如下条件:
 * 若 s[i] 是小写字符，则 s[i+1] 不可以是相同的大写字符。
 * 若 s[i] 是大写字符，则 s[i+1] 不可以是相同的小写字符。
 * 请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。
 * 请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。
 * 注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。
 *
 *  
 * 示例 1：
 * 输入：s = "leEeetcode"
 * 输出："leetcode"
 * 解释：无论你第一次选的是 i = 1 还是 i = 2，都会使 "leEeetcode" 缩减为 "leetcode" 。
 *
 * 示例 2：
 * 输入：s = "abBAcC"
 * 输出：""
 * 解释：存在多种不同情况，但所有的情况都会导致相同的结果。例如：
 * "abBAcC" --> "aAcC" --> "cC" --> ""
 * "abBAcC" --> "abBA" --> "aA" --> ""
 */
public class P_1544 {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        for (; i < s.length() - 1; ) {
            String b = new Character(s.charAt(i)).toString();
            String c = new Character(s.charAt(i + 1)).toString();
            if (!st.isEmpty()) {
                String a = st.peek().toString();
                if (Math.abs(a.charAt(0) - b.charAt(0)) == 32 && a.toLowerCase().equals(b.toLowerCase())) {
                    st.pop();
                    i++;
                } else if (Math.abs(b.charAt(0) - c.charAt(0)) == 32 && b.toLowerCase().equals(c.toLowerCase())) {
                    i += 2;
                } else {
                    st.add(s.charAt(i));
                    st.add(s.charAt(i + 1));
                    i+=2;
                }
            } else {
                st.add(s.charAt(i));
                i++;
            }
        }
        if (i<s.length()){
            if (!st.isEmpty() ) {
                String a = st.peek().toString();
                String b = new Character(s.charAt(s.length() - 1)).toString();
                if (Math.abs(a.charAt(0) - b.charAt(0)) == 32 && a.toLowerCase().equals(b.toLowerCase())) {
                    st.pop();
                }else{
                    st.add(s.charAt(s.length() - 1));
                }
            }else {
                st.add(s.charAt(s.length() - 1));
            }
        }
        StringBuilder sb = new StringBuilder();
        st.forEach(ss -> sb.append(ss));
        return sb.toString();
    }
    // 双指针
    public String makeGood2(String s) {
        StringBuilder sb = new StringBuilder();
        int lastIdx = -1;
        int length = s.length();
        for(int i = 0;i<length;i++){
            char ch = s.charAt(i);
            if(sb.length()>0 &&
                    Character.toLowerCase(sb.charAt(lastIdx)) == Character.toLowerCase(ch) &&
                    ch != sb.charAt(lastIdx)){
                sb.deleteCharAt(lastIdx);
                lastIdx--;
            }else {
                sb.append(ch);
                lastIdx++;
            }
        }

        return sb.toString();
    }
}
