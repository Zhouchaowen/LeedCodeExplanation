package com.zz.clever_idea.Stack_;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/score-of-parentheses/
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 *
 * 示例 1：
 * 输入： "()"
 * 输出： 1
 *
 * 示例 2：
 * 输入： "(())"
 * 输出： 2
 *
 * 提示：
 * S 是平衡括号字符串，且只含有 ( 和 ) 。
 * 2 <= S.length <= 50
 */
public class P_856 {
    /**
     *
     * （（）（（）））
     * [0]          st.add(0);
     * [0,0]
     * [0,0,0]
     * [0,1]        pre2+Math.max(pre1*2,1)
     * [0,1,0]
     * [0,1,0,0]
     * [0,1,1]      1+max(1*2,1)
     * [0,3]        0+max(3*2,1)
     * [6]
     *
     *
     * 可以递归分至
     * @param S
     * @return
     */
    public int scoreOfParentheses(String S) {
        Stack<Integer> st = new Stack<>();
        st.add(0);
        for(int i = 0;i<S.length();i++){
            if (S.charAt(i) == '('){
                st.add(0);
            }else{
                int pre1 = st.pop();
                int pre2 = st.pop();
                st.add(pre2+Math.max(pre1*2,1));
            }
        }
        return st.pop();
    }
}
