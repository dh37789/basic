package com.beakjoon;

import java.io.*;
import java.util.*;

public class No15686 {
    int n, m;
    int sum = Integer.MAX_VALUE;
    boolean[] visit;
    List<Node> homeList = new ArrayList<>();
    List<Node> chickenList  = new ArrayList<>();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer sToken = new StringTokenizer(br.readLine());
        n = Integer.parseInt(sToken.nextToken());
        m = Integer.parseInt(sToken.nextToken());

        int[][] city = new int[n][n];
        for (int i = 0; i < n; i++) {
            sToken = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                city[i][j] = Integer.parseInt(sToken.nextToken());
                if (city[i][j] == 1) homeList.add(new Node(i, j));
                if (city[i][j] == 2) chickenList.add(new Node(i, j));
            }
        }

        visit = new boolean[chickenList.size()];
        backTracking(0, 0);

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }

    private void backTracking(int count, int index) {
        if(count == m) {
            int total = 0;
            for (int i = 0; i < homeList.size(); i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < chickenList.size(); j++) {
                    if (visit[j] == true) {
                        Node homeNode = homeList.get(i);
                        Node chickenNode = chickenList.get(j);
                        int road = Math.abs(homeNode.y - chickenNode.y) + Math.abs(homeNode.x - chickenNode.x);
                        min = Math.min(min, road);
                    }
                }
                total += min;
            }
            sum = Math.min(sum, total);
            return;
        }

        for (int i = index; i < chickenList.size(); i++) {
            if (visit[i] == false) {
                visit[i] = true;
                backTracking(count + 1, i + 1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new No15686().solution();
    }

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

    }
}
