package com.zz.clever_idea.Stack_;

import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/asteroid-collision/
 *
 * 给定一个整数数组 asteroids，表示在同一行的行星。
 * 对于数组中的每一个元素，其绝对值表示行星的大小，
 * 正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，
 * 较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。
 * 两颗移动方向相同的行星，永远不会发生碰撞。
 *
 * 示例 1:
 * 输入:
 * asteroids = [5, 10, -5]
 * 输出: [5, 10]
 * 解释:
 * 10 和 -5 碰撞后只剩下 10。 5 和 10 永远不会发生碰撞。
 *
 * 示例 2:
 * 输入:
 * asteroids = [8, -8]
 * 输出: []
 * 解释:
 * 8 和 -8 碰撞后，两者都发生爆炸。
 *
 */

public class P_735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        List<Integer> list = new ArrayList<>(asteroids.length);
        for(int i = 0;i<asteroids.length;i++){
            if (asteroids[i]<0){
                while (!st.isEmpty() && st.peek()<Math.abs(asteroids[i])){
                    st.pop();
                }
                if (st.isEmpty()){
                    list.add(asteroids[i]);
                }
                if (!st.isEmpty() && st.peek() == Math.abs(asteroids[i])){
                    st.pop();
                }

            }else {
                st.add(asteroids[i]);
            }
        }
        st.forEach(n->list.add(n));
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
