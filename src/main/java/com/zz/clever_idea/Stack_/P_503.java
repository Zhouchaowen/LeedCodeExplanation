package com.zz.clever_idea.Stack_;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/next-greater-element-ii/
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，
 * 这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 *
 */
public class P_503 {
    /**
     * 逆序-单调栈
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length*2);

        for (int i = 0;i<nums.length;i++){
            list.add(nums[i]);
        }
        for (int i = 0;i<nums.length;i++){
            list.add(nums[i]);
        }
        Stack<Integer> st = new Stack<>();
        Stack<Integer> ans = new Stack<>();
        for (int i = list.size()-1;i>=0;i--){
            int x = list.get(i);
            while (!st.isEmpty() && st.peek()<x)st.pop();
            if (st.isEmpty()) ans.add(-1);
            else ans.add(st.peek());
            st.add(x);
        }
        List<Integer> ints = new ArrayList<>(nums.length);
        while (!ans.isEmpty()){
           if (ints.size()>nums.length){
               break;
           }
           System.out.println(ans.peek());
           ints.add(ans.pop());
       }
        return ints.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] nextGreaterElements2(int[] nums) {
        int[] res = new int[nums.length];
        // 存的是下标
        Stack<Integer> st = new Stack<>();
        for(int i = nums.length*2-1;i>=0;i--){
            while (!st.isEmpty() && nums[st.peek()] <= nums[i%nums.length]){
                st.pop();
            }
            res[i%nums.length] = st.empty()?-1:nums[st.peek()];
            st.add(i%nums.length);
        }
        return res;
    }
}
