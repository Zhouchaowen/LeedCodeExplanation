package com.zz.PlayLifeCode.week20;

/**
 * https://leetcode-cn.com/problems/repeated-substring-pattern/
 * KMP+题目性质
 * int t = len-next[len];
 * return t<len && len%t == 0;
 *
 */
public class P_459 {

    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        s = " "+s;
        int[] next = new int[len+1];
        for(int i = 2,j = 0;i<=len;i++){
            while(j > 0 && s.charAt(i) != s.charAt(j+1)) j = next[j];
            if(s.charAt(i) == s.charAt(j+1)) j++;
            next[i] = j;
        }
        int t = len-next[len];
        return t<len && len%t == 0;
    }


    public static void main(String[] args) {

    }
    public static String repeatedSubstringPattern2(String s) {
        int len = s.length();
        String str = s;
        s = " "+s;
        int[] next = new int[len+1];
        for(int i = 2,j = 0;i<=len;i++){
            while(j > 0 && s.charAt(i) != s.charAt(j+1)) j = next[j];
            if(s.charAt(i) == s.charAt(j+1)) j++;
            next[i] = j;
        }
        int t = len-next[len];
        if(t<len && len%t == 0){
            String substring = str.substring(0, t);
            int num = (str.length()/t);
            return num+substring;
        }else{
            return "1"+str;
        }
    }
}
