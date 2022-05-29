package com.beakjoon;

import java.io.*;

public class No10828 {
    public static class StackNode {
        int data;
        StackNode next;

        public StackNode(int data){
            this.data = data;
        }
    }

    public static class CustomStack {
        StackNode top;
        int size;

        public CustomStack(){
            this.top = null;
            this.size = 0;
        }

        public void push(int data) {
            StackNode stackNode = new StackNode(data);
            if(top != null){
                stackNode.next = top;
            }
            top = stackNode;
            size++;
        }

        public int pop(){
            if (top == null){
                return -1;
            }
            StackNode deleteNode = top;
            int returnData = top.data;
            top = top.next;
            size--;
            return returnData;
        }

        public int getSize() {
            return size;
        }

        public int isEmpty(){
            if (size == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        public int peek(){
            if(top == null){
                return -1;
            } else {
                return top.data;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        CustomStack stack = new CustomStack();

        for (int i = 0; i < n; i++){
            String line = br.readLine();
            if ("pop".equals(line)) {
                bw.write(String.valueOf(stack.pop()));
                bw.newLine();
                bw.flush();
            } else if ("top".equals(line)) {
                bw.write(String.valueOf(stack.peek()));
                bw.newLine();
                bw.flush();
            } else if ("empty".equals(line)) {
                bw.write(String.valueOf(stack.isEmpty()));
                bw.newLine();
                bw.flush();
            } else if ("size".equals(line)) {
                bw.write(String.valueOf(stack.getSize()));
                bw.newLine();
                bw.flush();
            } else {
                int num =Integer.parseInt(line.split(" ")[1]);
                stack.push(num);
            }
        }

        bw.close();
        br.close();
    }
}
