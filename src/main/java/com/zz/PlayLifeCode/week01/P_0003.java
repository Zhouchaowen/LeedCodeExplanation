package com.zz.PlayLifeCode.week01;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 考点：
 * 1.思维逻辑
 * 2.双指针
 * 3.滑动窗口
 *
 */
public class P_0003 {
    private int[] sum = new int[128];
    public static void main(String[] args) {
        // "abcdaefg"
        new P_0003().lengthOfLongestSubstring("abcdaedfg");
    }

    public int lengthOfLongestSubstring(String s) {
        /**
         * abcdaedfg
         * abcd 4次循环后 r-l+1 = 4
         * l  r
         * abcda 5次循环后 r-l+1 = 4
         *  l  r
         * abcdaed 7次循环后 r-l+1 = 3
         *     l r
         * abcdaedfg 9次循环后 r-l+1 = 5
         *     l   r
         */
        if (s == null || s.equals("")) return 0;
        int l = 0;
        int ans = 1;
        for (int r = 0;r<s.length();r++){
            l = Math.max(l,sum[s.charAt(r)]); //直接跳到对应索引+1位置
            sum[s.charAt(r)] = r+1; // 存储的字符对应的索引位置
            ans = Math.max(ans,r-l+1);
        }
        System.out.println(ans);
        return ans;
    }
}
/*
指针 j 向后移一位, 同时将哈希表中 s[j] 的计数加一: hash[s[j]]++;
假设 j 移动前的区间 [i,j] 中没有重复字符，则 jj 移动后，只有 s[j] 可能出现2次。
因此我们不断向后移动 i，直至区间 [i,j]中 s[j] 的个数等于1为止；

int lengthOfLongestSubstring(string s) {
    unordered_map<char, int> hash;
    int res = 0;
    for (int i = 0, j = 0; j < s.size(); j ++ )
    {
        hash[s[j]] ++ ;
        while (hash[s[j]] > 1) hash[s[i ++ ]] -- ;
        res = max(res, j - i + 1);
    }
    return res;
}
*/

