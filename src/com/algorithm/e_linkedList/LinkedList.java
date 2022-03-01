package com.algorithm.e_linkedList;

public class LinkedList<T> {
    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;
    private int size;

    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(T data){
        LinkedListNode<T> node = new LinkedListNode<>(data);
        if(isEmpty()){
            head = node;
            tail = node;
        } else {
            node.link = head;
            head = node;
        }
        size++;
    }

    public void addLast(T data){
        LinkedListNode<T> node = new LinkedListNode<>(data);
        if(isEmpty()){
            addFirst(data);
        } else {
            tail.link = node;
            tail = node;
            size++;
        }
    }

    public void add(int idx, T data){
        if(isEmpty()){
            addFirst(data);
        } else {
            if (idx == 0){
                addFirst(data);
            } else if (idx == size){
                addLast(data);
            } else if (idx > size){
                throw new ArrayIndexOutOfBoundsException("OutOfBounds!! Index : " + idx + ", Size : " + size);
            } else {
                LinkedListNode newNode = new LinkedListNode(data);

                LinkedListNode tmpNode = getNode(idx-1);
                LinkedListNode tmpLinkNode = tmpNode.link;
                newNode.link = tmpLinkNode;
                tmpNode.link = newNode;
                size++;

                if (newNode.link == null){
                    tail = newNode;
                }
            }
        }
    }

    public Object removeFirst(){
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException("OutOfBounds!! Size : " + size);
        } else {
            LinkedListNode tmpNode = head.link;
            Object returnData = head.data;

            head = tmpNode;
            size--;

            if (head == null){
                tail = null;
            }
            return returnData;
        }
    }

    public Object removeLast(){
        return remove(size-1);
    }

    public Object remove(int idx){
        if(idx >= size){
            throw new ArrayIndexOutOfBoundsException("OutOfBounds!! Index : " + idx + ", Size : " + size);
        } else if (idx == 0) {
            return removeFirst();
        } else {
            LinkedListNode tmpNode = getNode(idx - 1);
            LinkedListNode deleteNode = tmpNode.link;

            Object returnData = deleteNode.data;

            if (deleteNode == tail){
                tail = tmpNode;
                tmpNode.link = deleteNode.link;
            } else {
                tmpNode.link = tmpNode.link.link;
            }
            size--;
            return returnData;
        }
    }

    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return (head == null);
    }

    public String toString(){
        if (size == 0){
            return "[]";
        } else {
            StringBuffer sb = new StringBuffer();
            LinkedListNode strNode = head;
            sb.append("[");
            while (strNode != null){
                sb.append(strNode.data);
                strNode = strNode.link;
                if(strNode != null) {
                    sb.append(",");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    private LinkedListNode getNode(int idx){
        LinkedListNode node = head;
        for (int i = 0; i < idx;i++){
            node = node.link;
        }
        return node;
    }

}