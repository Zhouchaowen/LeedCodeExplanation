package com.zz.PlayLifeCode.week19;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/sort-characters-by-frequency/
 * Map/PriorityQueue优先队列
 * 排序
 *
 */
public class P_451 {

    public static void main(String[] args) {
        new P_451().frequencySort("tree");
    }
    public String frequencySort(String s) {
        TreeMap<Character,Integer> tm = new TreeMap<>();
        for (int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if (tm.containsKey(c)){
                tm.put(c,tm.get(c)+1);
            }else {
                tm.put(c,1);
            }
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(tm.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue()-o1.getValue());
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character,Integer> e:list){
            for (int i = 0;i<e.getValue();i++){
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }
    public String frequencySort2(String s) {
        int[] letters = new int[128];
        for (char c : s.toCharArray()) letters[c]++;

        PriorityQueue<Character> heap = new PriorityQueue<>(128, (a, b) -> Integer.compare(letters[b], letters[a]));
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < letters.length; ++i) {
            if (letters[i] != 0) {
                heap.offer((char)i);
            }
        }

        while (!heap.isEmpty()) {
            char c = heap.poll();
            while (letters[c]-- > 0) {
                res.append(c);
            }
        }
        return res.toString();
    }

}
