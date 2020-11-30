package com.zz.clever_idea.Stack_;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters/
 * 返回字符串 text 中按字典序排列最小的子序列，该子序列包含 text 中所有不同字符一次。
 *
 * 示例 1：
 * 输入："cdadabcc"
 * 输出："adbc"
 *
 * 示例 2：
 * 输入："abcd"
 * 输出："abcd"
 *
 */
public class P_1081 {
    /**
     * st储存最终答案
     * hs储存当前st中有没有该元素
     * hm储存每个元素最后出现的下标
     * @param s
     * @return
     */
    public String smallestSubsequence(String s) {
        Stack<Character> st = new Stack<>();
        HashSet<Character> hs = new HashSet<>();
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            hm.put(s.charAt(i),i);
        }
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if (!hs.contains(c)){
                while(!st.isEmpty() && st.peek().charValue()>=c && hm.get(st.peek()) > i){
                    hs.remove(st.peek());
                    st.pop();
                }
                st.add(c);
                hs.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        st.forEach(c->sb.append(c));
        return sb.toString();
    }
}
