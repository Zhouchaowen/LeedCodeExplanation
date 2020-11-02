package com.zz.PlayLifeCode.week19;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * 排序+贪心
 */
public class P_452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[1],o2[1]));
        int t = points[0][1];
        int ans = 1; // 至少射一箭
        for(int i = 1;i<points.length;i++){
            if (points[i][0]>t){
                ans ++;
                t = points[i][1];
            }
        }
        return ans;
    }
}
