package com.zz.PlayLifeCode.week19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/submissions/
 * 双指针+哈希表
 *
 */
public class P_438 {
    int[] parr = new int[26];
    int[] sarr = new int[26];
    public List<Integer> findAnagrams(String s, String p) {
        for(int i = 0;i<p.length();i++){
            parr[p.charAt(i)-'a']++;
            sarr[s.charAt(i)-'a']++;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = p.length(),j = 0;i<s.length();i++,j++){
            int flag = 1;
            for(int l = 0;l<26;l++){
                if(parr[l] != sarr[l]){
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) list.add(j);
            sarr[s.charAt(j)-'a']--;
            sarr[s.charAt(i)-'a']++;
        }

        return list;
    }

/*
class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        unordered_map<char, int> cnt;
        for (auto c: p) cnt[c] ++ ;
        vector<int> res;
        int tot = cnt.size();
        for (int i = 0, j = 0, satisfy = 0; i < s.size(); i ++ ) {
            if ( -- cnt[s[i]] == 0) satisfy ++ ;
            while (i - j + 1 > p.size()) {
                if (cnt[s[j]] == 0) satisfy -- ;
                cnt[s[j ++ ]] ++ ;
            }
            if (satisfy == tot) res.push_back(j);
        }
        return res;
    }
};
*/

}
