package com.learninglog.Aug.Tree;

public class BinaryTree {
    TreeNode root;

    BinaryTree() {
        root = null;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        // Inserting nodes into the binary tree
        tree.root = tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 80);

        // Traversal of the binary tree
        System.out.println("Inorder Traversal:");
        tree.inorderTraversal(tree.root);

        System.out.println("\nPreorder Traversal:");
        tree.preorderTraversal(tree.root);

        System.out.println("\nPostorder Traversal:");
        tree.postorderTraversal(tree.root);
    }

    // Method to insert a node in the tree
    TreeNode insert(TreeNode node, int val) {
        if (node == null) {
            node = new TreeNode(val);
            return node;
        }

        if (val < node.val) {
            node.left = insert(node.left, val);
        } else if (val > node.val) {
            node.right = insert(node.right, val);
        }
        return node;
    }

    // Method for inorder traversal (left, root, right)
    void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.val + " ");
            inorderTraversal(node.right);
        }
    }

    // Method for preorder traversal (root, left, right)
    void preorderTraversal(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    // Method for postorder traversal (left, right, root)
    void postorderTraversal(TreeNode node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.val + " ");
        }
    }
}
