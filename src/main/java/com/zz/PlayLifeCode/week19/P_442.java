package com.zz.PlayLifeCode.week19;

import java.util.ArrayList;
import java.util.List;

/**
 *  https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/submissions/
 *  奇淫技巧：题目限制很强
 */
public class P_442 {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            int t = Math.abs(nums[i])-1;
            nums[t] *= -1;
            if(nums[t] > 0){
                list.add(Math.abs(nums[i]));
            }
        }
        return list;
    }
}
