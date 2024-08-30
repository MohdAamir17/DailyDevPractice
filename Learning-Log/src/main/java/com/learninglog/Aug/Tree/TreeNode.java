package com.learninglog.Aug.Tree;

public class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = null;
        right= null;
    }

    TreeNode (int val , TreeNode left , TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
