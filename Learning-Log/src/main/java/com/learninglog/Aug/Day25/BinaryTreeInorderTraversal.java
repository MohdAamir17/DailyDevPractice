package com.learninglog.Aug.Day25;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {

        // Constructing the binary tree based on the example
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        root.right = node2;
        node2.left = node3;

        // Creating SolutionInOrder instance and performing in-order traversal
        SolutionInOrder solutionInOrder = new SolutionInOrder();
        List<Integer> integerList = solutionInOrder.inorderTraversal(root);

        // Printing the result
        System.out.println(integerList);  // Output should be [1, 3, 2]

    }
}

class SolutionInOrder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    // Helper method to perform recursive in-order traversal
    private void inorderHelper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        // Traverse left subtree
        inorderHelper(node.left, list);
        // Visit the node itself
        list.add(node.val);
        // Traverse right subtree
        inorderHelper(node.right, list);
    }



}
