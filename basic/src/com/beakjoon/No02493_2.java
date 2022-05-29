package com.beakjoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class No02493_2 {
    public static class Tower{
        int idx;
        int height;

        public int getIdx() {
            return idx;
        }

        public int getHeight() {
            return height;
        }

        public Tower(int idx, int height){
            this.idx = idx;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer sToken = new StringTokenizer(br.readLine());
        Stack<Tower> stack = new Stack<Tower>();

        for (int i = 0; i < n; i++) {
            int tmpHeight = Integer.parseInt(sToken.nextToken());
            if(stack.isEmpty()){
                stack.push(new Tower(i + 1, tmpHeight));
                bw.write("0 ");
                continue;
            }

            while(!stack.isEmpty()){
                if(tmpHeight < stack.peek().height){
                    bw.write(stack.peek().idx + " ");
                    break;
                } else {
                    stack.pop();
                }
            }

            if (stack.isEmpty()){
                bw.write("0 ");
            }
            stack.push(new Tower(i + 1, tmpHeight));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
