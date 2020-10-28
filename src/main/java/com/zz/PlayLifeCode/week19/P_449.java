package com.zz.PlayLifeCode.week19;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/serialize-and-deserialize-bst/
 * 链表+队列+BFS
 */
public class P_449 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode t = new P_449().new TreeNode(2);
        TreeNode r = new P_449().new TreeNode(1);
        TreeNode l = new P_449().new TreeNode(3);
        t.right = r;
        t.left = l;
        System.out.println(new P_449().serialize(t));
        new P_449().deserialize("2,3,1,#,#,#,#,");
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            TreeNode tn = q.poll();
            if (tn == null){
                sb.append("#,");
            }else{
                sb.append(tn.val+",");
                q.add(tn.right);
                q.add(tn.left);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("") || data == null) return null;
        String[] split = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode h = new TreeNode(Integer.valueOf(split[0]));
        q.add(h);
        int idx = 1;
        while (!q.isEmpty()){
            TreeNode head = q.poll();
            if (head == null){
                continue;
            }
            String sr = split[idx++];
            if (sr.equals("#")){
                head.right = null;
                q.add(null);
            }else{
                TreeNode r = new TreeNode(Integer.valueOf(sr));
                head.right = r;
                q.add(r);
            }
            String sl = split[idx++];
            if (sl.equals("#")){
                head.left = null;
                q.add(null);
            }else{
                TreeNode l = new TreeNode(Integer.valueOf(sl));
                head.left = l;
                q.add(l);
            }
        }
        return h;
    }
}
