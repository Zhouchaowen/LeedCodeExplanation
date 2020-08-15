package com.zz.clever_idea.StackProblem;

import java.util.Deque;
import java.util.LinkedList;

/***
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 */
public class P_offer09 {
    private static Deque<Integer> de1 = new LinkedList<>();
    private static Deque<Integer> de2 = new LinkedList<>();

    public static void main(String[] args) {
    }

    private static void push(Integer s) {
        de1.push(s);
    }

    private static Integer pop() {
        if (!de2.isEmpty())
            return de2.pop();
        else{
            while(!de1.isEmpty()){
                de2.push(de1.pop());
            }
            if(!de2.isEmpty()){
                return de2.pop();
            }else{
                return -1;
            }
        }
    }

}
