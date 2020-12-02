package com.zz.clever_idea.Stack_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/html-entity-parser/
 * 「HTML 实体解析器」 是一种特殊的解析器，它将 HTML 代码作为输入，
 * 并用字符本身替换掉所有这些特殊的字符实体。
 *
 * HTML 里这些特殊字符和它们对应的字符实体包括：
 *
 * 双引号：字符实体为 &quot; ，对应的字符是 " 。
 * 单引号：字符实体为 &apos; ，对应的字符是 ' 。
 * 与符号：字符实体为 &amp; ，对应对的字符是 & 。
 * 大于号：字符实体为 &gt; ，对应的字符是 > 。
 * 小于号：字符实体为 &lt; ，对应的字符是 < 。
 * 斜线号：字符实体为 &frasl; ，对应的字符是 / 。
 * 给你输入字符串 text ，请你实现一个 HTML 实体解析器，返回解析器解析后的结果。
 *
 *  
 *
 * 示例 1：
 * 输入：text = "&amp; is an HTML entity but &ambassador; is not."
 * 输出："& is an HTML entity but &ambassador; is not."
 * 解释：解析器把字符实体 &amp; 用 & 替换
 *
 * 示例 2：
 * 输入：text = "and I quote: &quot;...&quot;"
 * 输出："and I quote: \"...\""
 *
 * 示例 3：
 * 输入：text = "Stay home! Practice on Leetcode :)"
 * 输出："Stay home! Practice on Leetcode :)"
 *
 */
public class P_1410 {
    public String entityParser(String text) {
        Map<String,String> map = new HashMap<>();
        StringBuilder ans = new StringBuilder();
        map.put("&quot;","\"");
        map.put("&apos;","'");
        map.put("&amp;","&");
        map.put("&gt;",">");
        map.put("&lt;","<");
        map.put("&frasl;","/");
        for (int i = 0;i<text.length();i++){
            char c = text.charAt(i);
            if (c == '&'){
                StringBuilder sb = new StringBuilder(); //
                while(i<text.length() && text.charAt(i) != ';'){
                    sb.append(text.charAt(i));
                    i++;
                }
                sb.append(text.charAt(i));
                if (map.containsKey(sb.toString())){
                    ans.append(map.get(sb.toString()));
                }else {
                    ans.append(sb);
                }

            }else
                ans.append(c);
        }
        return ans.toString();
    }
    // pass
    public String entityParser2(String text) {
        text.replace("&quot;","\"");
        text.replace("&apos;","'");
        text.replace("&amp;","&");
        text.replace("&gt;",">");
        text.replace("&lt;","<");
        text.replace("&frasl;","/");
        return text;
    }
}
