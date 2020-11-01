package com.zz.PlayLifeCode.week19;

/**
 *  https://leetcode-cn.com/problems/delete-node-in-a-bst/
 *  二叉搜索树左边小于中间右边大于中间
 *  java的引用传递
 *  dfs应用
 */
public class P_450 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // delete from the right subtree
        if (key > root.val) root.right = deleteNode(root.right, key);
            // delete from the left subtree
        else if (key < root.val) root.left = deleteNode(root.left, key);
            // delete the current node
        else {
            // the node is a leaf
            if (root.left == null && root.right == null) root = null;
                // the node is not a leaf and has a right child
            else if (root.right != null) {
                TreeNode t = root.right;
                while (t.left != null)t = t.left;
                root.val = t.val;
                root.right = deleteNode(root.right, root.val);
            }
            // the node is not a leaf, has no right child, and has a left child
            else {
                TreeNode t = root.left;
                while (t.right != null) t = t.right;
                root.val = t.val;
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }


}
