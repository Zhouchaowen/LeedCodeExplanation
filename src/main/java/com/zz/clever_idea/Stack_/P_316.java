package com.zz.clever_idea.Stack_;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/remove-duplicate-letters/
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * 示例 1：
 * 输入：s = "bcabc"
 * 输出："abc"
 *
 * 示例 2：
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *
 * 提示：
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 *
 */
public class P_316 {
    /**
     * 要预处理记录元素的最大下标位置，用于判断元素是否可以出栈
     * 通过循环向set设置元素判断当前元素是否可以入栈
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        HashSet<Character> hs = new HashSet<>();
        HashMap<Character,Integer> hm = new HashMap<>();
        for (int i = 0;i<s.length();i++){
            hm.put(s.charAt(i),i);
        }
        Stack<Character> st = new Stack<>();
        for (int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            // 当前元素在set中还未出现
            if (!hs.contains(c)){
                // 栈顶的元素大于当前元素，并且 栈顶元素在当前元素后面的下标位置还重复出现过
                // 所以可以将当前栈顶元素弹出，因为后面他的重复元素还是可以再次进来
                while (!st.isEmpty() && st.peek() > c && hm.get(st.peek())>i){
                    char ch = st.pop();
                    hs.remove(ch);
                }
                hs.add(c);
                st.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        st.forEach(c->sb.append(c));
        return sb.toString();
    }
}
