package com.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class No18405 {
    static int[][] examiner;
    static boolean[][] visited;
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer sToken = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(sToken.nextToken());
        int k = Integer.parseInt(sToken.nextToken());

        examiner = new int[n][n];

        for (int i = 0; i < n ; i++) {
            sToken = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n ; j++) {
                examiner[i][j] = Integer.parseInt(sToken.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            examiner[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        sToken = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(sToken.nextToken());
        int x = Integer.parseInt(sToken.nextToken());
        int y = Integer.parseInt(sToken.nextToken());

        visited = new boolean[n][n];
        for (int virus = 1; virus <= k; virus++) {
            bfs(virus);
        }

        System.out.println(examiner[x-1][y-1]);
    }

    private static void bfs(int virus) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dirX[i];
                int ny = node.y + dirY[i];
                if (nx < 0 || ny < 0 || nx >= examiner.length || ny >= examiner.length || examiner[nx][ny] != 0 || visited[nx][ny])
                    continue;
                queue.offer(new Node(nx, ny));
                visited[nx][ny] = true;
                examiner[nx][ny] = virus;
            }
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
