package com.learninglog.Aug.Day25;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        // Constructing a sample binary tree:
        //        1
        //         \
        //          2
        //         /
        //        3

        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode root = new TreeNode(1, null, node2);

        // Creating Solution instance and performing post-order traversal
        Solution solution = new Solution();
        List<Integer> postorder = solution.postorderTraversal(root);

        // Printing the result
        System.out.println(postorder);
    }
}



// TreeNode class representing each node in the binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// Solution class containing the method for post-order traversal
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    // Helper method to perform recursive post-order traversal
    private void postorderHelper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        // Traverse left subtree
        postorderHelper(node.left, list);
        // Traverse right subtree
        postorderHelper(node.right, list);
        // Visit the node itself
        list.add(node.val);
    }
}
