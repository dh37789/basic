package com.beakjoon;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No18405_Pior {
    int n, k, s;
    int[][] examiner;
    PriorityQueue<Node> queue;
    int[] dirY = {1, -1, 0, 0};
    int[] dirX = {0, 0, -1, 1};

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer sToken = new StringTokenizer(br.readLine());
        n = Integer.parseInt(sToken.nextToken());
        k = Integer.parseInt(sToken.nextToken());

        examiner = new int[n][n];

        queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            sToken = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                examiner[i][j] = Integer.parseInt(sToken.nextToken());
                if (examiner[i][j] != 0)
                    queue.add(new Node(i, j, examiner[i][j], 0));
            }
        }

        sToken = new StringTokenizer(br.readLine());

        s = Integer.parseInt(sToken.nextToken());
        int x = Integer.parseInt(sToken.nextToken());
        int y = Integer.parseInt(sToken.nextToken());

        if (s != 0)
            bfs();

        bw.write(String.valueOf(examiner[x-1][y-1]));
        bw.flush();
        bw.close();
        br.close();
    }

    public void bfs() {
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.time == s) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = node.y + dirY[i];
                int nx = node.x + dirX[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= n || examiner[ny][nx] != 0)
                    continue;

                examiner[ny][nx] = examiner[node.y][node.x];
                queue.offer(new Node(ny, nx, examiner[ny][nx], node.time + 1));
            }

        }

    }

    static class Node implements Comparable<Node> {
        int y;
        int x;
        int virus;
        int time;

        public Node(int y, int x, int virus, int time) {
            this.y = y;
            this.x = x;
            this.virus = virus;
            this.time = time;
        }

        @Override
        public int compareTo(Node other) {
            if (time == other.time) {
                return virus - other.virus;
            } else {
                return time - other.time;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        new No18405_Pior().solution();
    }
}
