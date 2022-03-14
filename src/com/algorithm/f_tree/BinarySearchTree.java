package com.algorithm.f_tree;


import java.time.temporal.Temporal;

public class BinarySearchTree<T extends Comparable<T>> {
    private TreeNode<T> rootNode = null;

    private static class TreeNode<T extends Comparable<T>> {
        T data;
        TreeNode left;
        TreeNode right;

        public TreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public boolean insertNode(T item) {

        if (isEmpty()){
            rootNode = new TreeNode(item);
            return true;
        } else {
            TreeNode<T> head = rootNode;
            TreeNode<T> node;

            while (true) {
                node = head;

                if (head.data.compareTo(item) > 0) {
                    if(head.left == null) {
                        head.left = new TreeNode(item);
                        return true;
                    }
                    head = head.left;
                } else if (head.data.compareTo(item) < 0) {
                    if(head.right == null) {
                        head.right = new TreeNode(item);
                        return true;
                    }
                    head = head.right;
                } else if (head.data.compareTo(item) == 0) {
                    return false;
                }
            }
        }
    }

    public boolean removeNode(T item) {
        if (isEmpty()){
            return false;
        }

        TreeNode<T> removeNode = rootNode;
        TreeNode<T> removeParentNode = null;

        while (removeNode.data.compareTo(item) != 0) {
           removeParentNode = removeNode;
           if(removeNode.data.compareTo(item) > 0) {
               removeNode = removeNode.left;
           } else if (removeNode.data.compareTo(item) < 0) {
               removeNode = removeNode.right;
           }

           if (removeNode == null) {
                return false;
           }
        }

        if (removeNode.left == null && removeNode.right == null) {
            if (removeNode == rootNode) {
                rootNode = null;
            } else if (removeNode == removeParentNode.right) {
                removeParentNode.right = null;
            } else {
                removeParentNode.left = null;
            }
        } else if (removeNode.right == null) {
            if (removeNode == rootNode){
                rootNode = removeNode.left;
            } else if (removeNode == removeParentNode.right) {
                removeParentNode.right = removeNode.left;
            } else {
                removeParentNode.left = removeNode.left;
            }
        } else if (removeNode.left == null) {
            if (removeNode == rootNode){
                rootNode = removeNode.right;
            } else if (removeNode == removeParentNode.right) {
                removeParentNode.right = removeNode.right;
            } else {
                removeParentNode.left = removeNode.right;
            }
        } else {
            TreeNode<T> tempParentNode = removeNode;

            TreeNode<T> replaceNode = tempParentNode.right;

            while (replaceNode.left != null) {
                tempParentNode = replaceNode;
                replaceNode = replaceNode.left;
            }

            if (replaceNode != removeNode.right) {
                tempParentNode.left = removeNode.right;
                replaceNode.right = removeNode.right;
            }

            if (removeNode == rootNode) {
                rootNode = replaceNode;
            } else if (removeNode == tempParentNode.right) {
                tempParentNode.right = replaceNode;
            } else {
                tempParentNode.left = replaceNode;
            }

            replaceNode.left = removeNode.left;
        }

        return true;
    }

    public boolean search(T item) {
        TreeNode<T> node = rootNode;
        while (true) {
            if (node.data.compareTo(item) == 0) {
                return true;
            } else if (node.data.compareTo(item) > 0) {
                if (node.left == null) {
                    return false;
                }
                node = node.left;
            } else if (node.data.compareTo(item) < 0) {
                if (node.right == null) {
                    return false;
                }
                node = node.right;
            }
        }
    }

    public boolean isEmpty(){
        return rootNode == null;
    }

}
