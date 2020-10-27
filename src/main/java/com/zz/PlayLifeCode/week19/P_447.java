package com.zz.PlayLifeCode.week19;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/number-of-boomerangs/
 * Hash表的使用+数学排列组合
 *
 */
public class P_447 {

    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for(int i = 0;i<points.length;i++){
            HashMap<Integer,Integer> mp = new HashMap<>();
            for(int j = 0;j<points.length;j++){
                if(i != j){
                    int dx = points[i][0]-points[j][0];
                    int dy = points[i][1]-points[j][1];
                    int dist = dx*dx + dy*dy;
                    if(mp.containsKey(dist)){
                        mp.put(dist,mp.get(dist)+1);
                    }else{
                        mp.put(dist,1);
                    }
                }
            }
            for (Integer t:mp.keySet()){
                int v = mp.get(t).intValue();
                res += v*(v-1);
            }
        }
        return res;
    }
}
