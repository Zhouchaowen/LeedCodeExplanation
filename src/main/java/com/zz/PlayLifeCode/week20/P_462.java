package com.zz.PlayLifeCode.week20;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements-ii/
 * 中位数
 */
public class P_462 {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int len = nums.length;
        for(int i = 0;i<nums.length;i++){
            ans += Math.abs(nums[i]-nums[len/2]);
        }
        return ans;
    }
}
