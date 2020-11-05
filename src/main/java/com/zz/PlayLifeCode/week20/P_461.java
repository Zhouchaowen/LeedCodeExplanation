package com.zz.PlayLifeCode.week20;

/**
 * https://leetcode-cn.com/problems/hamming-distance/
 * 异或
 */
public class P_461 {
    public int hammingDistance(int x, int y) {
        int ans = 0;
        for(int i = 0;i<32;i++){
            if((x>>i&1) != (y>>i&1)){
                ans++;
            }
        }
        return ans;
    }
}
