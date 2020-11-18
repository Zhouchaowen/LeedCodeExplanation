package com.zz.clever_idea.Stack_;

/**
 * https://leetcode-cn.com/problems/check-if-word-is-valid-after-substitutions/
 * 给定有效字符串 "abc"。
 * 对于任何有效的字符串 V，我们可以将 V 分成两个部分 X 和 Y，使得 X + Y（X 与 Y 连接）等于 V。
 * （X 或 Y 可以为空。）那么，X + "abc" + Y 也同样是有效的。
 * 例如，如果 S = "abc"，则有效字符串的示例是："abc"，"aabcbc"，"abcabc"，"abcabcababcc"。
 * 无效字符串的示例是："abccba"，"ab"，"cababc"，"bac"。
 * 如果给定字符串 S 有效，则返回 true；否则，返回 false。
 *
 * 示例 1：
 * 输入："aabcbc"
 * 输出：true
 * 解释：
 * 从有效字符串 "abc" 开始。
 * 然后我们可以在 "a" 和 "bc" 之间插入另一个 "abc"，产生 "a" + "abc" + "bc"，即 "aabcbc"。
 *
 * 这题意：消除abc，能把整个字符串消除完就满足，不能就不满足。
 *
 * 栈消除
 */
public class P_1003 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abcd");
        System.out.println(sb.delete(sb.length()-3,sb.length()));
    }
    public boolean isValid(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            sb.append(s.charAt(i));
            int n = sb.length();
            if(n>=3&&sb.charAt(n-1) == 'c' && sb.charAt(n-2) == 'b' && sb.charAt(n-3) == 'a'){
                sb.delete(n-3,n);
            }
        }
        return sb.length() == 0?true:false;
    }
}
