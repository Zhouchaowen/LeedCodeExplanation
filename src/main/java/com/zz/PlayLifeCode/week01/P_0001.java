package com.zz.PlayLifeCode.week01;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *示例：
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 *考点：
 * HashMap的用法
 */
public class P_0001 {
    public static void main(String[] args) {
        int[] nums= new int[]{2, 7, 11, 15};
        int target = 9;
        twoSum(nums,target);
    }

    public static int[] twoSum(int[] nums,int target){
        HashMap<Integer,Integer> hm = new HashMap<>(Math.max((int) (nums.length/.75f) + 1, 16));
        for(int i = 0;i<nums.length;i++){
            int tmp = target - nums[i];
            if(hm.containsKey(tmp)){
                return new int[]{hm.get(tmp),i};

            }else{
                hm.put(nums[i],i);
            }
        }
        return null;
    }
}

/*
*
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int> m;
        for(int i = 0;i<nums.size();i++){
            int fin = target-nums[i];
            if(m.find(fin) != m.end()){
                return {m[fin],i};
            }
            m[nums[i]] = i;
        }
        return {};
    }
};
*/