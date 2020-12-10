package com.zz.clever_idea.Stack_;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/volume-of-histogram-lcci/
 *
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?
 * 直方图的宽度为 1。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，
 * 在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class M_1721 {
    public int trap(int[] height) {
        Stack<Integer> st = new Stack<>();
        int sum = 0;
        for (int i = 0;i<height.length;i++) {
            while (!st.isEmpty() && height[i]>height[st.peek()]){
                int t = st.pop();
                if (!st.empty()){
                    int ll = st.peek();
                    sum +=(Math.min(height[ll],height[i])-height[t])*(i-ll-1);
                }
            }
            st.push(i);
        }
        return sum;
    }
}
