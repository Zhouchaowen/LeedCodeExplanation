package com.zz.PlayLifeCode.week19;

import java.util.Arrays;

public class P_455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        for (int i = 0;i<s.length;i++){
            if (s[i]>= g[j]){
                j++;
            }
            if (j>=g.length){
                break;
            }
        }
        return j;
    }
}
