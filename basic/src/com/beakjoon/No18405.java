package com.beakjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No18405 {
    int n, k;
    static int[][] examiner;
    static boolean[][] visited;
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer sToken = new StringTokenizer(br.readLine());
        n = Integer.parseInt(sToken.nextToken());
        k = Integer.parseInt(sToken.nextToken());

        examiner = new int[n][n];

        for (int i = 0; i < n; i++) {
            sToken = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                examiner[i][j] = Integer.parseInt(sToken.nextToken());
            }
        }

        sToken = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(sToken.nextToken());
        int x = Integer.parseInt(sToken.nextToken());
        int y = Integer.parseInt(sToken.nextToken());

        visited = new boolean[n][n];

        loop:
        while(s-- > 0) {
            for (int virus = 1; virus <= k; virus++) {
                infection(virus);
                if (examiner[x-1][y-1] != 0) break loop;
            }
        }

        bw.write(String.valueOf(examiner[x-1][y-1]));
        bw.flush();
        bw.close();
        br.close();
    }

    public void infection(int virus) {
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < n; i++ ) {
            for (int j = 0; j < n; j++) {
                if (examiner[i][j] == virus) queue.offer(new Node(i, j));
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++){
                int ny = node.y + dirY[i];
                int nx = node.x + dirX[i];
                if (nx < 0 || ny < 0  || nx >= examiner.length || ny >= examiner.length || examiner[ny][nx] != 0 || visited[ny][nx])
                    continue;
                visited[ny][nx] = true;
                examiner[ny][nx] = virus;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new No18405().solution();
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
