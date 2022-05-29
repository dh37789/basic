package com.beakjoon;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No02178 {
    int n, m;
    int[][] maze;
    boolean[][] visited;
    int min = Integer.MAX_VALUE;
    int[] dirY = {1, -1, 0 ,0};
    int[] dirX = {0, 0, -1, 1};

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer sToken = new StringTokenizer(br.readLine());
        n = Integer.parseInt(sToken.nextToken());
        m = Integer.parseInt(sToken.nextToken());

        maze = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
                maze[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        bw.write(String.valueOf(bfs(0, 0)));
        bw.flush();
        bw.close();
        br.close();
    }

    private int bfs (int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y, x, 1));
        visited[y][x] = true;
        while (!queue.isEmpty()){
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = node.y + dirY[i];
                int nx = node.x + dirX[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m || maze[ny][nx] == 0 || visited[ny][nx])
                    continue;

                queue.add(new Node(ny, nx, node.distance + 1));
                visited[ny][nx] = true;

                if (ny+1 == n && nx+1 == m){
                    return node.distance + 1;
                }
            }
        }

        return 0;
    }

    static class Node {
        int y;
        int x;
        int distance;

        public Node (int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        new No02178().solution();
    }
}
