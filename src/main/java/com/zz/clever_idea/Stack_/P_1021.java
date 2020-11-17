package com.zz.clever_idea.Stack_;

import java.util.Stack;

/***
 * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，
 * + 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 *
 * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），
 * 其中 A 和 B 都是非空有效括号字符串。
 *
 * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，
 * 其中 P_i 是有效括号字符串原语。
 *
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 *
 *
 *
 * 输入："(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 *
 */
public class P_1021 {
    public static void main(String[] args) {
        /***
         * (()())(())
         * (()())(())(()(()))
         * ()()
         */
        Solve("()()");
    }

    private static void Solve(String s) {
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int l = 0,r = 0;
        for (int i = 0;i<chars.length;i++){
            if (chars[i] == '('){
                if (l != 0)
                    stringBuilder.append('(');
                l++;
            }else{
                r++;
                if (r != l)
                    stringBuilder.append(')');
            }
            if (r == l) r = l = 0;
        }
        System.out.println(stringBuilder.toString());
    }
    public static void Solve1(String S){
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        int start = 0;// 初始化原语的起始位置
        int end = 0;// 初始化原语的结束位置
        boolean flag = false;// 标志每个原语

        for (int i = 0;i < S.length();i++) {
            char ch = S.charAt(i);

            if (ch == '(') {// 遇到左括号，入栈
                stack.push(ch);
                if (!flag) {// 遇到的第一个左括号，是原语的开始位置，记录下原语开始位置
                    start = i;
                    flag = true;
                }
            }

            if (ch == ')') {// 遇到右括号，出栈
                stack.pop();
                if (stack.isEmpty()) {// 当栈空的时候，找到了一个完整的原语
                    end = i;// 记录下结束位置
                    ans.append(S.substring(start + 1,end));// 去掉原语的最外层括号，并追加到答案中
                    flag = false;// 置标志为false，往后接着找下一个原语
                    start = end;// 往后找，再次初始化原语开始位置
                }
            }
        }
        ans.toString();
    }
}
