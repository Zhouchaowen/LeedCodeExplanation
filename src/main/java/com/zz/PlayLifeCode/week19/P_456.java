package com.zz.PlayLifeCode.week19;


import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/132-pattern/
 * 单调栈，反向存储
 * 存储次二大元素
 *
 */
public class P_456 {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int secondMax = Integer.MIN_VALUE;
        for (int i = nums.length-1;i>=0;i--){
            // 确保成功
            if(nums[i]<secondMax) return true;
            while(st.size()>0 && nums[i]>st.peek()){
                secondMax = Math.max(secondMax,st.peek());
                st.pop();
            }
            st.push(nums[i]);
        }
        return false;
    }


    public boolean find132pattern2(int[] nums) {
        if (nums.length < 3)
            return false;
        Stack < Integer > stack = new Stack < > ();
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            min[i] = Math.min(min[i - 1], nums[i]);
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] > min[j]) {
                while (!stack.isEmpty() && stack.peek() <= min[j])
                    stack.pop();
                if (!stack.isEmpty() && stack.peek() < nums[j])
                    return true;
                stack.push(nums[j]);
            }
        }
        return false;
    }

}
