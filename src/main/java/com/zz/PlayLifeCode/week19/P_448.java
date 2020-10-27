package com.zz.PlayLifeCode.week19;

import java.util.ArrayList;
import java.util.List;

/**
 *  https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 *  参考442
 */
public class P_448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> arr = new ArrayList();
        for(int i = 0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])-1]  > 0){
                nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
            }
        }
        for(int i = 0;i<nums.length;i++){
            if(nums[i]>0){
                arr.add(i+1);
            }
        }
        return arr;
    }
}
