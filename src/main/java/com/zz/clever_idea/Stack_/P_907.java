package com.zz.clever_idea.Stack_;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/sum-of-subarray-minimums/
 *
 * 给定一个整数数组 A，找到 min(B) 的总和，其中 B 的范围为 A 的每个（连续）子数组。
 * 由于答案可能很大，因此返回答案模 10^9 + 7。
 *
 * 示例：
 * 输入：[3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 *  
 *
 * 提示：
 * 1 <= A <= 30000
 * 1 <= A[i] <= 30000
 *
 * ????????????????????????????
 */
public class P_907 {
    class Rep{
        int val,count;
        Rep(int v,int c){
            this.val = v;
            this.count = c;
        }

        @Override
        public String toString() {
            return "Rep{" +
                    "val=" + val +
                    ", count=" + count +
                    '}';
        }
    }
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1000000007;
        Stack<Rep> st = new Stack<>();
        int ans = 0,dot = 0;
        for (int i = 0;i<arr.length;i++){
            int count = 1;
            while (!st.isEmpty() && st.peek().val >= arr[i]){
                Rep t = st.pop();
                System.out.println(t);
                count += t.count;
                dot -= t.val*t.count;
            }
            st.add(new Rep(arr[i],count));
            dot += arr[i]*count;
            ans += dot;
            System.out.println(arr[i]+"--"+count+"--"+dot+"--"+ans);
            ans %= MOD;
        }
        return ans;
    }
}
