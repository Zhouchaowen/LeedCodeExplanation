package com.zz.PlayLifeCode.week19;

import java.util.*;

public class P_436 {

    public static void main(String[] args) {

    }

    public int[] findRightInterval(int[][] intervals) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i<intervals.length;i++){
            int r = intervals[i][1];
            int flag = -1,t = Integer.MAX_VALUE;
            for(int j = 0;j<intervals.length;j++){
                if(i != j && intervals[j][0]>=r){
                    if(t>intervals[j][0]-r){
                        t = intervals[j][0]-r;
                        flag = j;
                    }
                }
            }
            list.add(flag);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] findRightInterval2(int[][] intervals) {
        return null;
    }
}
