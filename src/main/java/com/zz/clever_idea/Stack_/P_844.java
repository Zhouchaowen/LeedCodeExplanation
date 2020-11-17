package com.zz.clever_idea.Stack_;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/backspace-string-compare/
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。
 * # 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 * 示例 1：
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 *
 * 示例 2：
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 *
 * 示例 3：
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 *
 * 双指针 空间 O(1)
 */
public class P_844 {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        for(int i = 0;i<S.length();i++){
            if (S.charAt(i) == '#' ){
                if (st1.size()>0)
                    st1.pop();
            } else
                st1.add(S.charAt(i));
        }
        for(int i = 0;i<T.length();i++){
            if (T.charAt(i) == '#'){
                if (st2.size()>0)
                    st2.pop();
            } else
                st2.add(T.charAt(i));
        }
        if (st1.size() != st2.size()){
            return false;
        }
        while(st1.size()>0 && st1.peek() == st2.peek()){
            st1.pop();
            st2.pop();
        }
        return st1.size() == 0?true:false;
    }
}
