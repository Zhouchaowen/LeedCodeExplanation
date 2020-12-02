package com.zz.clever_idea.Stack_;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 * 示例:
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 */
public class P_084 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right,n);
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                right[st.pop()] = i;
            }
            left[i] = st.isEmpty() == true?-1:st.peek();
            st.add(i);
        }
        int ans = 0;
        for (int i = 0;i<n;i++){
            System.out.print(left[i]+" ");
        }
        System.out.println();
        for (int i = 0;i<n;i++){
            System.out.print(right[i]+" ");
        }
        for(int i = 0;i<n;i++){
            ans = Math.max(ans,(right[i]-left[i]-1)*heights[i]);
        }
        return ans;
    }
}
