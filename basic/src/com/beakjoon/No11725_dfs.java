package com.beakjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class No11725_dfs {
    public static void main(String[] args) throws IOException {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] parent = new int[n+1];

        for (int i = 0; i < n+1; i++){
            graph.add(new ArrayList<>());
        }

        StringTokenizer sToken;
        for (int i = 1; i < n; i++ ){
            sToken = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(sToken.nextToken());
            int node2 = Integer.parseInt(sToken.nextToken());
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        dfs(graph, parent);

        for (int i = 2; i < parent.length; i++) {
            bw.write(String.valueOf(parent[i]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();

    }

    private static void dfs(ArrayList<ArrayList<Integer>> graph, int[] parent) {
        Stack<Integer> stack = new Stack<>();

        parent[1] = 1;
        stack.push(1);
        while (!stack.isEmpty()){
            int node = stack.pop();
            for (int num : graph.get(node)){
                if (parent[num] == 0){
                    parent[num] = node;
                    stack.push(num);
                }
            }
        }
    }
}
