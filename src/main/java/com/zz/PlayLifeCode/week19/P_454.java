package com.zz.PlayLifeCode.week19;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/4sum-ii/
 * hash表+思维转换（枚举）
 *
 */
public class P_454 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> hm = new HashMap<>(A.length*B.length);
        for (int i = 0;i<A.length;i++){
            for(int j = 0;j<B.length;j++){
                int t = A[i]+B[j];
                if (hm.containsKey(t)){
                    hm.put(t,hm.get(t)+1);
                }else{
                    hm.put(t,1);
                }
            }
        }
        int ans = 0;
        for(int i = 0;i<C.length;i++){
            for (int j = 0;j<D.length;j++){
                int t = C[i]+D[j];
                if(t>=0){
                    if (hm.containsKey(-t)){
                        ans+=hm.get(-t);
                    }
                }else{
                    if (hm.containsKey(Math.abs(t))){
                        ans+=hm.get(Math.abs(t));
                    }
                }
            }
        }
        return ans;
    }
}
