package com.zz.clever_idea.Stack_;

import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/find-the-most-competitive-subsequence/
 * 给你一个整数数组 nums 和一个正整数 k ，返回长度为 k 且最具 竞争力 的 nums 子序列。
 * 数组的子序列是从数组中删除一些元素（可能不删除元素）得到的序列。
 * 在子序列 a 和子序列 b 第一个不相同的位置上，如果 a 中的数字小于 b 中对应的数字，
 * 那么我们称子序列 a 比子序列 b（相同长度下）更具 竞争力 。
 * 例如，[1,3,4] 比 [1,3,5] 更具竞争力，在第一个不相同的位置，也就是最后一个位置上， 4 小于 5 。
 *
 *  
 *
 * 示例 1：
 * 输入：nums = [3,5,2,6], k = 2
 * 输出：[2,6]
 * 解释：在所有可能的子序列集合 {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]} 中，[2,6] 最具竞争力。
 *
 * 示例 2：
 * 输入：nums = [2,4,3,3,5,4,9,6], k = 4
 * 输出：[2,3,3,4]
 *
 *
 * 单调栈
 */
public class P_5614 {
    public int[] mostCompetitive(int[] nums, int k) {
        int len = nums.length;
        Stack<Integer> st = new Stack<>();
        st.add(-1);
        for (int i = 0;i<len;i++){
            while (nums[i] < st.peek() && len-i>k-st.size()+1){
                st.pop();
            }
            if (st.size() < k+1){
                st.add(nums[i]);
            }
        }
                            // 过滤不等于-1的元素
        return st.stream().filter(s->s!=-1).mapToInt(Integer::intValue).toArray();
    }
}
