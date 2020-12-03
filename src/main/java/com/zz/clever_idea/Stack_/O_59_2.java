package com.zz.clever_idea.Stack_;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、
 * push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 示例 1：
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 *
 * 示例 2：
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 *  
 * 限制：
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 *
 * 模拟队列
 */
public class O_59_2 {

    private int max_value = Integer.MIN_VALUE;

    Deque<Integer> dq ;
    TreeMap<Integer,Integer> treeMap;
    public O_59_2() {
        dq = new ArrayDeque<>();
        treeMap = new TreeMap<>();
    }

    public int max_value() {
        if (dq.size()<1) return -1;
        return treeMap.lastKey();
    }

    public void push_back(int value) {
        treeMap.put(value,treeMap.containsKey(value)?treeMap.get(value)+1:1);
        dq.add(value);
    }

    public int pop_front() {
        if (dq.size()<1) return -1;
        Integer integer = dq.pollFirst();
        if (treeMap.get(integer) > 1){
            treeMap.put(integer,treeMap.get(integer)-1);
        }else {
            treeMap.remove(integer);
        }
        return integer;
    }
}
