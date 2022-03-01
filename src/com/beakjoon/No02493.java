/*
package com.beakjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class No02493 {

    public static class Tower {
        int idx;
        int height;

        public Tower(int idx, int height){
            this.idx = idx;
            this.height = height;
        }

        public int getHeight() {
            return this.height;
        }

        public int getIdx() {
            return this.idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];

        StringTokenizer sToken = new StringTokenizer(br.readLine());
        if (num == 1){
            System.out.println(0);
            return;
        } else {
            for (int i = 0; i < num; i++) {
                arr[i] = Integer.parseInt(sToken.nextToken());
            }
        }

        int[] answer = new int[num];
        answer[0] = 0;

        Stack<Tower> st = new Stack<>();
        st.push(new Tower(1, arr[0]));



        for (int i = 1; i < num; i++) {
            int curr = arr[1];
            while(!st.isEmpty()){
                int prev = st.peek().getHeight();

                if (prev < curr) {
                    st.pop();
                    st.push(new Tower(i+1, curr));
                    if (st.size() == 1) {
                        break;
                    }
                } else {
                    answer[i] = st.peek().idx;
                    st.push(new Tower(i+1, curr));
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(answer));

        bw.flush();
        br.close();
        bw.close();

    }

}
*/
