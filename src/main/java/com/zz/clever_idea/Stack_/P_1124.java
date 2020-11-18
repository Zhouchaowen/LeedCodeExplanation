package com.zz.clever_idea.Stack_;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/longest-well-performing-interval/
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 * 请你返回「表现良好时间段」的最大长度。
 *
 * 示例 1：
 * 输入：hours = [9,9,6,0,6,6,9]
 * 输出：3
 * 解释：最长的表现良好时间段是 [9,9,6]。
 *
 * 提示：
 * 1 <= hours.length <= 10000
 * 0 <= hours[i] <= 16
 *
 * 单调栈
 *
 */
public class P_1124 {
    public int longestWPI(int[] hours) {
        for(int i = 0;i<hours.length;i++){
            hours[i] = hours[i]>8?1:0;
        }
        int ans = 0;
        for(int i = 0;i<hours.length;i++){
            int sum = 0;
            for(int j = i;j<hours.length;j++){
                sum += hours[j];
                ans = Math.max(ans,j-i+1<sum*2?j-i+1:ans);
            }
        }
        return ans;
    }
    // 类似单调栈思想
    public int longestWPI2(int[] hours) {
        int cur = 0,ans = 0;
        HashMap<Integer,Integer> map = new HashMap();
        for(int i = 0;i<hours.length;i++){
            if (hours[i]>8) cur++;
            else cur--;
            if (cur>0) ans = i+1;
            else{
               if (!map.containsKey(cur)){
                   map.put(cur,i);
               }
               if (map.containsKey(cur-1)){
                   ans = Math.max(ans,i-map.get(cur-1));
               }
            }
        }
        return ans;
    }

}
