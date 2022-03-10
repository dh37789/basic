package com.beakjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No01966 {
    public static class Print {
        int index;
        int importance;

        public int getIndex() {
            return index;
        }

        public int getImportance() {
            return importance;
        }

        public Print(int index, int importance) {
            this.index = index;
            this.importance = importance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++){
            StringTokenizer sToken = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(sToken.nextToken());
            int rtnIdx = Integer.parseInt(sToken.nextToken());
            int count = 0;

            Queue<Print> queue = new LinkedList<>();

            sToken = new StringTokenizer(br.readLine());

            for (int j = 0; j < num; j++){
                queue.add(new Print(j, Integer.parseInt(sToken.nextToken())));
            }

            while(!queue.isEmpty()){
                Print front = queue.poll();
                boolean isImpot = true;

                for (Print p : queue){
                    if (front.getImportance() < p.getImportance()){
                        isImpot = false;
                        break;
                    }
                }

                if (isImpot){
                    count++;
                    if (front.getIndex() == rtnIdx) break;
                } else {
                    queue.add(front);
                }

            }

            bw.write(String.valueOf(count));
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
    }
}