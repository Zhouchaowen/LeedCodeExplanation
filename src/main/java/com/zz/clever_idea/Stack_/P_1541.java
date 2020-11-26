package com.zz.clever_idea.Stack_;

/**
 * https://leetcode-cn.com/problems/minimum-insertions-to-balance-a-parentheses-string/
 * 给你一个括号字符串 s ，它只包含字符 '(' 和 ')' 。一个括号字符串被称为平衡的当它满足：
 * 任何左括号 '(' 必须对应两个连续的右括号 '))' 。
 * 左括号 '(' 必须在对应的连续两个右括号 '))' 之前。
 * 比方说 "())"， "())(())))" 和 "(())())))" 都是平衡的，
 *  ")()"， "()))" 和 "(()))" 都是不平衡的。
 * 你可以在任意位置插入字符 '(' 和 ')' 使字符串平衡。
 * 请你返回让 s 平衡的最少插入次数。
 *
 *
 * 示例 1：
 * 输入：s = "(()))"
 * 输出：1
 * 解释：第二个左括号有与之匹配的两个右括号，但是第一个左括号只有一个右括号。我们需要在字符串结尾额外增加一个 ')' 使字符串变成平衡字符串 "(())))" 。
 *
 * 示例 2：
 * 输入：s = "())"
 * 输出：0
 * 解释：字符串已经平衡
 *
 *
 */
public class P_1541 {

    public int minInsertions(String s) {
        s = s.replace("())","");
        int len = s.length();
        while(len != s.replace("())","").length()){
            s = s.replace("())","");
            len = s.length();
        }
        int ans = 0;
        s = s.replace("()","");
        while(len != s.length()){
            ans += (len-s.length())/2;
            s = s.replace("()","");
            len = s.length();
        }

        s = s.replace("(", "");
        while(len != s.length()){
            ans += (len - s.length())*2;
            s = s.replace("(", "");
            len = s.length();
        }
        s = s.replace("))","");
        while(len != s.length()){
            ans += (len - s.length())/2;
            s = s.replace("))","");
            len = s.length();
        }
        ans += s.length()*2;
        return ans;

    }
}
