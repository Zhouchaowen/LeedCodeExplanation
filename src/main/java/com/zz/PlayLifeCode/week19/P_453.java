package com.zz.PlayLifeCode.week19;

public class P_453 {

    public int minMoves(int[] nums) {
        if (nums.length <= 1)return 0;
        int minx = nums[0];
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
            minx = Math.min(minx,nums[i]);
        }
        return sum-(minx*nums.length);
    }
}
