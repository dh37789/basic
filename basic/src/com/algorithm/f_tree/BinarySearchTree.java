package com.algorithm.f_tree;

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

    /**
     * 트리에서 item을 삽입한다.
     */
    public boolean insertNode(T item) {

        if (isEmpty()){
            rootNode = new TreeNode(item);
            return true;
        } else {
            TreeNode<T> node = rootNode;

            /** data 및 좌, 우를 비교하여 자식노드가 비어있는 곳을 찾아 넣어준다. */
            while (true) {
                if (node.data.compareTo(item) > 0) {
                    if(node.left == null) {
                        node.left = new TreeNode(item);
                        return true;
                    }
                    node = node.left;
                } else if (node.data.compareTo(item) < 0) {
                    if(node.right == null) {
                        node.right = new TreeNode(item);
                        return true;
                    }
                    node = node.right;
                } else if (node.data.compareTo(item) == 0) {
                    return false;
                }
            }
        }
    }

    /**
     * 트리에서 item을 삭제한다.
     */
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

    /**
     * 트리에서 item을 조회한다.
     */
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

    /**
     * 트리가 비어있는지 확인한다.
     */
    public boolean isEmpty(){
        return rootNode == null;
    }
}
