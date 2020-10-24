package com.zz.PlayLifeCode.week19;

/**
 *  https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/
 *  暴力：构建十叉树
 *  logN*logN：根据规律逐步缩小区间
 */
public class P_440 {

    long count(long c1,long c2,int n){
        long steps = 0;
        while(c1<=n){
            steps += Math.min(n+1,c2)-c1;
            c1 *= 10;
            c2 *= 10;
        }
        return steps;
    }

    public int findKthNumber(int n, int k) {
        int cur = 1;
        k -= 1;
        while(k>0){
            long steps = count(cur,cur+1,n);
            if(steps <= k){
                cur++;
                k -= steps;
            }else{
                cur *= 10;
                k -= 1;
            }
        }
        return cur;
    }

}
