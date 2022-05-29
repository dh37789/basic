package com.algorithm.f_tree;

public class BinarySearchTreeMain {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insertNode(7);
        tree.insertNode(1);
        tree.insertNode(9);
        tree.insertNode(3);
        tree.insertNode(10);
        tree.insertNode(4);

        tree.removeNode(7);
        tree.removeNode(9);
        tree.removeNode(3);
        tree.removeNode(10);

        System.out.println(tree.search(10));
    }
}
