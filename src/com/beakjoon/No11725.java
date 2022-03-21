package com.beakjoon;

import java.io.*;
import java.util.*;

public class No11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[] parent = new int[n+1];

        for (int i = 0; i < n+1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            StringTokenizer sToken = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(sToken.nextToken());
            int node2 = Integer.parseInt(sToken.nextToken());
            list.get(node1).add(node2);
            list.get(node2).add(node1);
        }

        bfs(list, parent);

        for (int i = 2; i < n+1; i++) {
            bw.write(String.valueOf(parent[i]));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(ArrayList<ArrayList<Integer>> list, int[] parent) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        parent[1] = 1;

        while (!queue.isEmpty()){
            int parentNum = queue.poll();
            for (int n : list.get(parentNum)){
               if(parent[n] == 0){
                   queue.offer(n);
                   parent[n] = parentNum;
               }
            }
        }
    }
}
